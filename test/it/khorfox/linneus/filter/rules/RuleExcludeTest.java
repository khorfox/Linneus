package it.khorfox.linneus.filter.rules;

import static org.junit.Assert.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RuleExcludeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testApply() {
		RuleExclude rule = new RuleExclude("Movie",Files::isDirectory);
		Path path = FileSystems.getDefault().getPath("Principale//Movie");
		assertTrue(!rule.apply(path));
	}

	@Test
	public final void testNotApply() {
		RuleExclude rule = new RuleExclude("DOCUMENTS",Files::isDirectory);
		Path path = FileSystems.getDefault().getPath("Principale//Movie");
		assertTrue(rule.apply(path));
	}

	@Test
	public final void testNotApplyToDirectory() {
		RuleExclude rule = new RuleExclude("DOCUMENTS",Files::isDirectory);
		Path path = FileSystems.getDefault().getPath("Principale//Movie","primo.txt");
		assertTrue(rule.apply(path));
	}


}
