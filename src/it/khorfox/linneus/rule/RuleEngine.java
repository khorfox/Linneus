package it.khorfox.linneus.rule;

import java.util.ArrayList;

import it.khorfox.linneus.base.Element;
import it.khorfox.linneus.rule.archive.RuleArchive;
import it.khorfox.linneus.rule.rules.RuleAbstract;

public class RuleEngine {

	public RuleArchive archive;

	public RuleEngine(RuleArchive archive) {
		super();
		this.archive = archive;
		archive.load();
	}
	
	public Element apply(Element el){
		ArrayList<RuleAbstract> rules = archive.getRules();
		for(RuleAbstract rule: rules){
			el = rule.apply(el);
		}
		return el;
	}

	public ArrayList<? extends Element> applyAll(ArrayList<? extends Element> elements){
		for(Element el: elements){
			el = apply(el);
		}
		return elements;
	}


}
