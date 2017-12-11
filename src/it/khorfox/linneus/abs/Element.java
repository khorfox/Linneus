package it.khorfox.linneus.abs;

import java.util.ArrayList;

public abstract class Element implements it.khorfox.linneus.base.Element {


	public String name = "";
	public boolean exclude = false;
	public ArrayList<String> tags = new ArrayList<String>();
	public String fullName = "";

	public Element() {
		super();
	}

	public String getName() {
		return name.toUpperCase();
	}

	public String getFullName() {
		return fullName.toUpperCase();
	}

	public void setExclude(boolean exclude) {
		this.exclude = exclude;
	}

	public abstract Type getType(); 

	public ArrayList<String> getTags() {
		return tags;
	}

}