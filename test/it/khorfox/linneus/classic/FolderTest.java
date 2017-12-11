package it.khorfox.linneus.classic;

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
	public final void testListSubFolders() {
		Folder folder = new Folder("Principale");
		ArrayList<Folder> list = folder.listSubFolders();
		System.out.println(list);
		assertTrue(!list.isEmpty());
		
	}
	@Test
	public final void testListSubFolders2() {
		Folder folder = new Folder("Movie");
		folder.fullName= "C:\\Laboratorio\\workspace\\Linneus\\Principale";
		ArrayList<Folder> list = folder.listSubFolders();
		System.out.println(list);
		assertTrue(!list.isEmpty());
		
	}
	@Test
	public final void testListSubFolders3() {
		Folder folder = new Folder("C:\\Laboratorio\\workspace\\Linneus\\Principale");
		ArrayList<Folder> list = folder.listSubFolders();
		System.out.println(list);
		assertTrue(!list.isEmpty());
		
	}


}
