package it.khorfox.linneus.abs;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Document extends Element implements it.khorfox.linneus.base.Document {

	public String extension = "";
	public Folder folder;
	public final static String csvSeparator = ";";
	public final static String HEADER = "LEVEL;PATH;FOLDER;FILE;EXTENSION;FILE NAME";

	public String getExtension() {
		return extension;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}
	
	@Override
	public Type getType() {
		return Type.DOCUMENT;
	}

	public String virgoletta(String s) {
		return "\"" + s + "\"";
	}

	public String getCsv() {
		return  folder.level
				+ Document.csvSeparator
				+ folder.fullName 
				+ Document.csvSeparator
				+ folder.name
				+ Document.csvSeparator
				+ virgoletta(fullName)
				+ Document.csvSeparator
				+ extension
				+ Document.csvSeparator
				+ virgoletta(name)
				+ getTagList(Document.csvSeparator);
				
	}

	protected String getTagList(String csvseparator) {
		ArrayList<String> mergedTags = new ArrayList<String>();
		mergedTags.addAll(this.tags);
		mergedTags.removeAll(folder.tags);
		mergedTags.addAll(folder.tags);
		Collections.sort(mergedTags);
		String list = "";
		for(String tag:mergedTags){
			list = list + csvseparator + tag;
		}
		return list;
	}

	@Override
	public String toString() {
		return "Document [extension=" + extension + ", folder=" + folder + ", name=" + name + ", tags=" + tags
				+ ", fullName=" + fullName + "]";
	}


}
