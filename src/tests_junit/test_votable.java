package tests_junit;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.net.*;
import java.util.Scanner;

import cds.savot.pull.SavotPullParser;

import metier.GestionnaireDeTables;

import org.junit.Test;

public class test_votable {

//	@Test
//	public void testTelechargement() {
//		URL url = null;
//		try {
//			url = new URL("http://obs-stage-s4:8080/vizier2/tap/sync?REQUEST=doQuery&LANG=ADQL&QUERY=SELECT+*+FROM+TAP_SCHEMA.columns");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		InputStream content = GestionnaireDeTables.getInputStream(url);
//		
//		System.out.println(new Scanner(content).useDelimiter("\\A").next());
//	}
	
	
//	@Test
//	public void testParser() {
//		GestionnaireDeTables.parserVOTable();
//	}

}
