package it.khorfox.linneus.rule.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.khorfox.linneus.abs.Element;
import it.khorfox.linneus.base.Element.Type;
import it.khorfox.linneus.classic.Document;
import it.khorfox.linneus.classic.Folder;

public class RuleExcludeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testIsAppliable() {
		Element folder = new Folder("Windows");
		RuleExclude rule = new RuleExclude("WindOWS",Type.FOLDER);
		assertTrue(rule.isAppliable(folder));
	}
	@Test
	public final void testFolderApplyPositive() {
		Element folder = new Folder("Windows");
		RuleExclude rule = new RuleExclude("WindOWS",Type.FOLDER);
		rule.apply(folder);
		assertTrue(folder.exclude);
	}
	@Test
	public final void testFolderApplyNegative() {
		Element folder = new Folder("Movie");
		RuleExclude rule = new RuleExclude("WindOWS",Type.FOLDER);
		rule.apply(folder);
		assertFalse(folder.exclude);
	}
	@Test
	public final void testDocumentApplyPositive() {
		Element doc = new Document(new Folder("win"),"provalo.txt");
		RuleExclude rule = new RuleExclude("prova",Type.DOCUMENT);
		rule.apply(doc);
		assertTrue(doc.exclude);
	}
	@Test
	public final void testDocumentApplyNegative() {
		Element doc = new Document(new Folder("win"),"importa.txt");
		RuleExclude rule = new RuleExclude("prova",Type.DOCUMENT);
		rule.apply(doc);
		assertFalse(doc.exclude);
	}
	@Test
	public final void testRuleNotAppliable() {
		Element doc = new Document(new Folder("win"),"provalo.txt");
		RuleExclude rule = new RuleExclude("prova",Type.FOLDER);
		rule.apply(doc);
		assertFalse(doc.exclude);
	}


}
