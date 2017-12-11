package it.khorfox.linneus.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Hashtable;

import it.khorfox.linneus.rule.RuleEngine;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

	private ArrayList<Document> files;
	private RuleEngine rule;
	private Hashtable<String,Folder> folders = new Hashtable<String,Folder>();
	
	public MyFileVisitor(ArrayList<Document> files) {
		super();
		this.files = files;
	}

	public MyFileVisitor(ArrayList<Document> files, RuleEngine rule) {
		super();
		this.files = files;
		this.rule = rule;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		if( !folders.contains(dir.toAbsolutePath() + "") ) {
			Folder folder = new Folder(dir);
			rule.apply(folder);
			if(folder.exclude){
				return FileVisitResult.SKIP_SUBTREE;
			}
			folders.put(folder.fullName, folder);
		}
		return super.preVisitDirectory(dir, attrs);
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return super.postVisitDirectory(dir, exc);
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			Document doc = new Document(file.getFileName() + "");
			doc.setFolder(folders.get(file.getParent().toAbsolutePath().toString()));
			rule.apply(doc);
			if(!doc.exclude) {
				files.add(doc);
			}
			return FileVisitResult.CONTINUE;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}
