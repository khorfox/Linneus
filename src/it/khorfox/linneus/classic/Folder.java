package it.khorfox.linneus.classic;

import java.io.File;
import java.util.ArrayList;

public class Folder extends it.khorfox.linneus.abs.Folder implements it.khorfox.linneus.base.Folder {

	public Folder(String name) {
		File directory = new File(name);
		this.name = directory.getName();
		fullName = directory.getAbsolutePath();
	}

	public Folder(String name, String absolutePath) {
		this.name = name;
		this.fullName=absolutePath;
	}

	public ArrayList<Folder> listSubFolders(){
		ArrayList<Folder> subFolders = new ArrayList<Folder>();
		File directory = new File(fullName);
		File[] fList = directory.listFiles();
		if(fList!= null){
			for (File file : fList) {
				if (file.isDirectory()){
					Folder folder = new Folder(file.getName(),file.getAbsolutePath());
					folder.tags.addAll(tags);
					subFolders.add(folder);
				}
			}
		}
		return subFolders;
	}

	public ArrayList<Document> listFiles(){
		ArrayList<Document> docs = new ArrayList<Document>();
		File directory = new File(fullName);
		File[] fList = directory.listFiles();
		if(fList!= null){
			for (File file : fList) {
				if (file.isFile()){
					Document doc = new Document(this,file.getName());
					docs.add(doc);
				}
			}
		}
		return docs;
	}

}
