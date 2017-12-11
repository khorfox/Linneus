package it.khorfox.linneus.rule.archive;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.khorfox.linneus.base.Element.Type;
import it.khorfox.linneus.rule.rules.RuleAbstract;
import it.khorfox.linneus.rule.rules.RuleExclude;
import it.khorfox.linneus.rule.rules.RuleTag;

public class RuleFileArchiveTest {

	private RuleFileArchive archive;

	@Before
	public void setUp() throws Exception {
		archive = new RuleFileArchive();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testLoad() {
		int numRules = archive.load();
		System.out.println(archive.rules);
		assertTrue(numRules > 0);
	}

	@Test
	public final void testLoadRule() {
		RuleAbstract rule = archive.loadRule("FolderExclude:Windows");
		assertEquals(rule.getClass().getName(),new RuleExclude("",Type.FOLDER).getClass().getName());
	}
	@Test
	public final void testLoadRule2() {
		RuleAbstract rule = archive.loadRule("FileExclude:Windows");
		assertEquals(rule.getClass().getName(),new RuleExclude("",Type.DOCUMENT).getClass().getName());
	}
	@Test
	public final void testLoadRule3() {
		RuleAbstract rule = archive.loadRule("FolderTag:Windows:System");
		assertEquals(rule.getClass().getName(),new RuleTag("",Type.FOLDER,"").getClass().getName());
	}
	@Test
	public final void testLoadRule4() {
		RuleAbstract rule = archive.loadRule("FileTag:prova:test");
		assertEquals(rule.getClass().getName(),new RuleTag("",Type.DOCUMENT,"").getClass().getName());
	}

}
