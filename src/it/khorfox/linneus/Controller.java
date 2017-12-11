package it.khorfox.linneus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import it.khorfox.linneus.classic.Document;
import it.khorfox.linneus.classic.Folder;
import it.khorfox.linneus.rule.RuleEngine;
import it.khorfox.linneus.rule.archive.RuleFileArchive;

public class Controller {

	private String baseFolder;
	private ArrayList<Folder> list = new ArrayList<Folder>();
	private ArrayList<Document> files = new ArrayList<Document>();
	private RuleEngine rule;
	
	public Controller(String baseFolder) {
		this.baseFolder = baseFolder;
		rule = new RuleEngine(new RuleFileArchive());
	}

	public Controller(String baseFolder, String fileProperties) {
		this.baseFolder = baseFolder;
		rule = new RuleEngine(new RuleFileArchive(fileProperties));
	}

	private void execute() {
		createTree();
		printList(list);
		listFiles();
		printList(files);
		exportToCsv();
	}

	private void exportToCsv() {
		try {
			PrintWriter out  = new PrintWriter(new BufferedWriter(new FileWriter("listFiles.csv")));
			out.println(Document.HEADER);
			for(Document el: files) {
				out.println(el.getCsv());
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createTree() {
		Folder folder = new Folder(baseFolder);
		list.add(folder);
		getDirRecursive(folder,0);
	}
	
	private void getDirRecursive(Folder parent, int level){
		level++;
		ArrayList<Folder> children = parent.listSubFolders();
		rule.applyAll(children);
		for(Folder el : children) {
			if(!el.exclude){
				el.level = level;
				list.add(el);
				getDirRecursive(el,level);
			}
		}
	}

	private <T> void printList(ArrayList<T> list) {
		for (Object el:list){
			System.out.println(el);
		}
	}

	private void listFiles() {
		for (Folder el:list){
			ArrayList<Document> docs = el.listFiles();
			rule.applyAll(docs);
			for(Document file: docs) {
				if (!file.exclude){
					files.add(file);
				}
			}
		}
	}

	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("Wrong number of parameters: the syntax is [parent folder]");
		} else {
			if(args.length == 1) {
				Controller controller = new Controller(args[0]);
				controller.execute();
			} 
			if(args.length > 1) {
				Controller controller = new Controller(args[0], args[1]);
				controller.execute();
			} 
		}
	}

}
