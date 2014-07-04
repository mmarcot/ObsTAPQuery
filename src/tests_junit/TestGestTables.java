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
		GestionnaireDeTables gest = new GestionnaireDeTables();
		ArrayList<String> ls_tables = gest.getListe_tables();
		
		for(String table : ls_tables) {
			System.out.println(table);
		}
	}

}
