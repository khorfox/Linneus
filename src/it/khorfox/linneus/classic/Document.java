package it.khorfox.linneus.classic;

public class Document extends it.khorfox.linneus.abs.Document implements it.khorfox.linneus.base.Document {

	public Document(Folder folder, String name) {
		super();
		setFolder(folder);
		this.fullName = name;
		int i = name.lastIndexOf('.');
		if (i > 0) {
			this.name = fullName.substring(0, i);
		    extension = fullName.substring(i+1);
		}
	}

	
}
