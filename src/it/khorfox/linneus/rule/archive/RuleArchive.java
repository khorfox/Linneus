package it.khorfox.linneus.rule.archive;

import java.util.ArrayList;

import it.khorfox.linneus.rule.rules.RuleAbstract;

public interface RuleArchive {

	public int load();
	public ArrayList<RuleAbstract> getRules();
}
