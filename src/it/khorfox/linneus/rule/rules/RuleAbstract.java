package it.khorfox.linneus.rule.rules;

import it.khorfox.linneus.base.Element;
import it.khorfox.linneus.base.Element.Type;

public abstract class RuleAbstract {

	public String properties;

	public abstract Element apply(Element el);

	public Type validFor;

	public RuleAbstract() {
		super();
	}

	protected boolean isAppliable(Element el) {
		return el.getType().equals(validFor);
	}

}