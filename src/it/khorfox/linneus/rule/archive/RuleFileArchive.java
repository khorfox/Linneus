package it.khorfox.linneus.rule.archive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import it.khorfox.linneus.base.Element.Type;
import it.khorfox.linneus.rule.rules.RuleAbstract;
import it.khorfox.linneus.rule.rules.RuleExclude;
import it.khorfox.linneus.rule.rules.RuleFileExtension;
import it.khorfox.linneus.rule.rules.RuleTag;

public class RuleFileArchive implements RuleArchive {

	public String archive;
	private static final String RULES = "rules.properties";
	
	public RuleFileArchive() {
		archive=RULES;
	}

	public RuleFileArchive(String fileProperties) {
		archive=fileProperties;
	}

	public ArrayList<RuleAbstract> rules = new ArrayList<RuleAbstract>();
	/*
	 * the format of properties is rule type - values:
	 * 
	 * FolderExclude:value
	 * FileExclude:value
	 * FolderTag:value:tag
	 * FileTag:value:tag
	 * 
	 */

	@Override
	public int load() {
		File propertiesArchive = new File(archive);
		BufferedReader input;
		int i= 0;
		try {
			input = new BufferedReader(new FileReader(propertiesArchive));
			String prop;
			while ((prop = input.readLine()) != null) {
				if (!prop.startsWith("//")) {
					i++;
					RuleAbstract rule = loadRule(prop);
					rules.add(rule);
				}
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public RuleAbstract loadRule(String prop) {
		RuleAbstract rule = null;
		if(prop!= null){
			String[] el = prop.split(":");
			if(el.length > 0){
				switch(el[0]){
				case "FolderExclude":
					rule = new RuleExclude(el[1], Type.FOLDER);
					break;
				case "FileExclude":
					rule = new RuleExclude(el[1], Type.DOCUMENT);
					break;
				case "FolderTag":
					rule = new RuleTag(el[1], Type.FOLDER,el[2]);
					break;
				case "FileTag":
					rule = new RuleTag(el[1], Type.DOCUMENT,el[2]);
					break;
				case "ExtExclude":
					rule = new RuleFileExtension(el[1]);
					break;
				default:
					break;
				}
			}
			
		}
		return rule;
	}

	@Override
	public ArrayList<RuleAbstract> getRules() {
		return rules;
	}

	
}
