package tests_junit;

import static org.junit.Assert.*;

import java.net.*;

import metier.GestionnaireDeTables;

import org.junit.Test;

public class test_csv {

	@Test
	public void test() {
		URL url = null;
		try {
			url = new URL("http://www.cadc-ccda.hia-iha.nrc-cnrc.gc.ca/tap/sync?REQUEST=doQuery&LANG=ADQL&FORMAT=csv&QUERY=SELECT+*+FROM+TAP_SCHEMA.columns");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String content = GestionnaireDeTables.telechargerFichierCSV(url);
		
		System.out.println(content);
	}

}
