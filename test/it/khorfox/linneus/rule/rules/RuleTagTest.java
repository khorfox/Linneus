package it.khorfox.linneus.rule.rules;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.khorfox.linneus.base.Element.Type;
import it.khorfox.linneus.classic.Folder;

public class RuleTagTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testApplyPositive() {
		Folder folder = new Folder("FiLm Sci-fi");
		RuleTag rule = new RuleTag("Film",Type.FOLDER,"Movie");
		rule.apply(folder);
		assertTrue(folder.tags.contains(rule.properties));
	}
	@Test
	public final void testApplyPositive2() {
		Folder folder = new Folder("Action","C:\\principale\\film\\action\\thai");
		RuleTag rule = new RuleTag("Film",Type.FOLDER,"Movie");
		rule.apply(folder);
		assertTrue(folder.tags.contains(rule.properties));
	}


}
