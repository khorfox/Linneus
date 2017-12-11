package it.khorfox.linneus.rule.rules;

import it.khorfox.linneus.base.Element;
import it.khorfox.linneus.base.Element.Type;

public class RuleTag extends RuleAbstract {
	
	public String tag;

	public RuleTag(String properties,Type validFor, String tag) {
		super();
		this.properties = properties.toUpperCase();
		this.validFor=validFor;
		this.tag=tag;
	}

	@Override
	public Element apply(Element el) {
		if (isAppliable(el)) {
			if(el.getFullName().contains(properties)){
				if(!el.getTags().contains(properties)){
					el.getTags().add(properties);
				}
			}
		}
		return el;
	}

	@Override
	public String toString() {
		return "RuleTag [tag=" + tag + ", properties=" + properties + ", validFor=" + validFor + "]";
	}
	
	
}
