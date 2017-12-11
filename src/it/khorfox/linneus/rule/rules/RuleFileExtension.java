package it.khorfox.linneus.rule.rules;

import it.khorfox.linneus.base.Document;
import it.khorfox.linneus.base.Element;
import it.khorfox.linneus.base.Element.Type;

public class RuleFileExtension extends RuleAbstract {

	public RuleFileExtension(String properties) {
		super();
		this.properties = properties.toUpperCase();
		this.validFor=Type.DOCUMENT;
	}

	public Element apply(Element el) {
		if (isAppliable(el)) {
			Document doc  = (Document)el;
			if(doc.getExtension().toUpperCase().contains(properties)){
				el.setExclude(true);
			}
		}
		return el;
	}
}
