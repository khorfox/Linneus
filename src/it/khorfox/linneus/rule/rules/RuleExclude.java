package it.khorfox.linneus.rule.rules;

import it.khorfox.linneus.base.Element;
import it.khorfox.linneus.base.Element.Type;

public class RuleExclude extends RuleAbstract {
	
	public RuleExclude(String properties,Type validFor) {
		super();
		this.properties = properties.toUpperCase();
		this.validFor=validFor;
	}

	@Override
	public Element apply(Element el) {
		if (isAppliable(el)) {
			if(el.getName().contains(properties)){
				el.setExclude(true);
			}
		}
		return el;
	}

	@Override
	public String toString() {
		return "RuleExclude [properties=" + properties + ", validFor=" + validFor + "]";
	}

	
}
