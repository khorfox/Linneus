package it.khorfox.linneus.abs;

public abstract class Folder extends Element implements it.khorfox.linneus.base.Folder {

	public int level = 0;

	@Override
	public Type getType() {
		return Type.FOLDER;
	}

	@Override
	public String toString() {
		return "Folder [path=" + fullName + ", level=" + level + ", name=" + name + ", exclude=" + exclude + ", fullName="
				+ fullName + "]";
	}


}
