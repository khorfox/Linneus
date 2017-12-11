package it.khorfox.linneus.nio;

import static org.junit.Assert.assertTrue;

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
		ArrayList<Document> docs = new ArrayList<Document>();
		MyFileVisitor visitor = new MyFileVisitor(docs);
		folder.listFiles(visitor);
		assertTrue(docs.size() >0);
	}

}
