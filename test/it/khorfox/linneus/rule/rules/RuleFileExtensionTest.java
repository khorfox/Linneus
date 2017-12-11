package it.khorfox.linneus.rule.rules;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.khorfox.linneus.abs.Element;
import it.khorfox.linneus.classic.Document;
import it.khorfox.linneus.classic.Folder;

public class RuleFileExtensionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testApply() {
		Element doc = new Document(new Folder("win"),"provalo.txt");
		RuleFileExtension rule = new RuleFileExtension("txt");
		rule.apply(doc);
		assertTrue(doc.exclude);
	}

}
