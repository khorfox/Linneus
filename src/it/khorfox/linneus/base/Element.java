package it.khorfox.linneus.base;

import java.util.ArrayList;

public interface Element {
	public enum Type {FOLDER, DOCUMENT};
	
	public String getName();

	public String getFullName();

	public void setExclude(boolean flag);
	
	public Type getType();
	
	public ArrayList<String> getTags();
	
}
