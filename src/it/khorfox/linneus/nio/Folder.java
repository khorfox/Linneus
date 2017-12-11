package it.khorfox.linneus.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Folder extends it.khorfox.linneus.abs.Folder implements it.khorfox.linneus.base.Folder {

	public Folder(String name) {
		Path rootPath = Paths.get(name);
		this.name = rootPath.getFileName() + "";
		this.fullName = rootPath.toAbsolutePath() + "";
	}

	public Folder(String name, String path) {
		this.name = name;
		this.fullName = path;
	}

	public Folder(Path path) {
		this.name = path.getFileName() + "";
		this.fullName = path.toAbsolutePath() + "";
	}

	public void listFiles(MyFileVisitor visitor){
		Path rootPath = Paths.get(name);
		try {
			Files.walkFileTree(rootPath, visitor); 
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
