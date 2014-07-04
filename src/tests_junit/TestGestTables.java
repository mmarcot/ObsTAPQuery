package tests_junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import metier.GestionnaireDeTables;

import org.junit.Test;

public class TestGestTables {

	/**
	 * Methode qui teste le gestionnaire de tables
	 */
	@Test
	public void test() {
		ArrayList<String> ls_tables = GestionnaireDeTables.getListe_tables();
		
		for(String table : ls_tables) {
			System.out.println(table);
		}
		
		if(ls_tables == null || ls_tables.size() == 0) 
			fail("Aucune table n'a été récupérée");
	}

}
