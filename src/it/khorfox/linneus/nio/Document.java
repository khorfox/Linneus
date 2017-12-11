package it.khorfox.linneus.nio;

public class Document extends it.khorfox.linneus.abs.Document implements it.khorfox.linneus.base.Document {

	public Folder folder;
	
	public Document(String name) {
		this.fullName = name;
		int i = fullName.lastIndexOf('.');
		if (i > 0) {
			this.name = fullName.substring(0, i);
		    extension = fullName.substring(i+1);
		}
	}

}
