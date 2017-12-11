package it.khorfox.linneus.stream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FolderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testListFiles() {
		Folder folder = new Folder("Principale");
		try {
			ArrayList<Document> files = folder.listFiles();
			System.out.println(files);
			assertTrue(files.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
