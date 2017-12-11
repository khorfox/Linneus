package it.khorfox.linneus.filter.rules;

import java.nio.file.Path;
import java.util.function.Predicate;

public class RuleExclude  {
	public String properties;
	public Predicate<Path> predicate;
	
	public RuleExclude(String properties,Predicate<Path> p) {
		super();
		this.properties = properties.toUpperCase();
		this.predicate=p;
	}

	public boolean apply(Path p) {
		if (predicate.test(p)) {
				if(p.getFileName().toString().toUpperCase().contains(properties)){
				return false;
			}
			return true;
		}
		return true;
	}

}
