package it.khorfox.linneus.stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Folder extends it.khorfox.linneus.abs.Folder implements it.khorfox.linneus.base.Folder {

	private Path rootPath;

	protected ArrayList<Path> paths = new ArrayList<Path>();
	
	public Folder(String name) {
		rootPath = Paths.get(name);
		this.name = rootPath.getFileName() + "";
		this.fullName = rootPath.toAbsolutePath() + "";
	}

	public Folder(String name, String path) {
		rootPath = Paths.get(name);
		this.name = name;
		this.fullName = path;
	}

	public Folder(Path path) {
		rootPath = path;
		this.name = path.getFileName() + "";
		this.fullName = path.toAbsolutePath() + "";
	}

//	public ArrayList<Document> listFiles() throws Exception {
//		ArrayList<Document> files = new ArrayList<Document>();
//		Files.walk(rootPath)
//        .filter(Files::isRegularFile)
//        .forEach(filePath -> files.add(new Document(filePath)));
//		return files;
//	}
	public ArrayList<Document> listFiles() throws Exception {
		ArrayList<Document> files = 
		Files.walk(rootPath)
        .filter(Files::isRegularFile).collect(ArrayList::new, (c, e) -> c.add(new Document(e)), ArrayList::addAll);
		return files;
	}

}
