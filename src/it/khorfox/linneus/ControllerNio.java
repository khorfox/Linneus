package it.khorfox.linneus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import it.khorfox.linneus.nio.Document;
import it.khorfox.linneus.nio.Folder;
import it.khorfox.linneus.nio.MyFileVisitor;
import it.khorfox.linneus.rule.RuleEngine;
import it.khorfox.linneus.rule.archive.RuleFileArchive;

public class ControllerNio {

	private String baseFolder;
	private ArrayList<Document> files = new ArrayList<Document>();
	private RuleEngine rule;
	
	public ControllerNio(String baseFolder) {
		this.baseFolder = baseFolder;
		rule = new RuleEngine(new RuleFileArchive());
	}
	public ControllerNio(String baseFolder, String fileProperties) {
		this.baseFolder = baseFolder;
		rule = new RuleEngine(new RuleFileArchive(fileProperties));
	}

	private void execute() {
		Folder folder = new Folder(baseFolder);
		MyFileVisitor visitor = new MyFileVisitor(files, rule);
		folder.listFiles(visitor);
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


	private <T> void printList(ArrayList<T> list) {
		for (Object el:list){
			System.out.println(el);
		}
	}

	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("Wrong number of parameters: the syntax is: parent_folder [properties file]");
		} else {
			if(args.length == 1) {
				ControllerNio controller = new ControllerNio(args[0]);
				controller.execute();
			} 
			if(args.length > 1) {
				ControllerNio controller = new ControllerNio(args[0], args[1]);
				controller.execute();
			} 
		}
	}

}
