package metier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import cds.savot.model.*;
import cds.savot.pull.*;
import cds.xml.TableParser;

import util.Configuration;
import util.Langage;


/**
 * Classe qui va chercher les différentes tables disponibles à l'interogation
 * directe par l'utilisateur
 * @author Mallory Marcot
 *
 */
public class GestionnaireDeTables {
	
	private static ArrayList<String> liste_tables;
	/** permet de centraliser la table selectionnée afin qu'elle soit accessible de partout */
	private static String table_selectionnee = Configuration.TABLE_PAR_DEFAULT;
	
	
	/**
	 * Methode statique qui permet de changer la table selectionnée
	 * @param nouvelle_table
	 */
	public static void changerTableSelectionnee(String nouvelle_table) {
		table_selectionnee = nouvelle_table;
	}
	
	
	/**
	 * @return Retourne la table actuellement selectionnée dans le from
	 */
	public static String getTableSelectionnee() {
		return table_selectionnee;
	}
	
	
	/**
	 * @return the liste_tables
	 */
	public static ArrayList<String> getListe_tables() {
		if(liste_tables == null) {
			liste_tables = new ArrayList<String>();
			chercherTables();
		}
		
		return liste_tables;
	}
	
	
	
	/**
	 * Methode qui va chercher les colonnes présentes dans une table donnée
	 * @param table La table voulue
	 */
	public static ArrayList<UnChamps> getColonnes() {
		ArrayList<UnChamps> liste_colonnes = new ArrayList<UnChamps>();
		
		Connection conn = seConnecterBDD();
		
		if(conn != null) {
			try {
				Statement state = conn.createStatement();
				ResultSet res_set = state.executeQuery("SELECT column_name, datatype, unit, ucd, utype " + 
														"FROM columns " +
														"WHERE table_name = '" + table_selectionnee + "' ");
				
				// parcours et ajout des resultats de la requete dans la liste :
				while(res_set.next()) {
					String column_name = res_set.getString("column_name");
					String datatype = res_set.getString("datatype");
					String unit = res_set.getString("unit");
					String ucd = res_set.getString("ucd");
					String utype = res_set.getString("utype");
					
					liste_colonnes.add(new UnChamps(column_name, datatype, unit, ucd, utype));
				}
				conn.close();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, Langage.getMessage_err_recup_bdd_colonnes(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		
		return liste_colonnes;
	}
	
	

	
	/**
	 * Methode qui va chercher les tables dans la base de données
	 */
	private static void chercherTables() {
		Connection conn = seConnecterBDD();
		
		// Si la connection est OK :
		if(conn != null) {
			try {
				Statement state = conn.createStatement();
				ResultSet res_set = state.executeQuery("SELECT DISTINCT table_name " + 
														"FROM columns " +
														"WHERE table_name NOT LIKE 'TAP_SCHEMA.%';");
				
				// parcours et ajout des resultats de la requete dans la liste :
				while(res_set.next()) {
					String nom_table = res_set.getString("table_name");
					liste_tables.add(nom_table);
				}
				conn.close();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, Langage.getMessage_err_recup_bdd_tables(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	/**
	 * Methode qui se connecte à la base de données
	 */
	private static Connection seConnecterBDD() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://" + Configuration.URL_BDD, Configuration.USER_BDD, Configuration.MOT_DE_PASSE_BDD);
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, Langage.getMessage_err_conn_bdd(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return conn;
	}
	
	

	/**
	 * Permet de récupérer l'input stream de la VOTable distante 
	 * @param url URL du fichier CSV
	 * @return Contenu du fichier CSV
	 */
	public static InputStream getInputStream(URL url) {
		InputStream input = null;
		
		try {
			URLConnection connection = url.openConnection();
			input = connection.getInputStream();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return input;
	}
	

	public static void parserVOTable() {
		
		// construction de l'URL :
		URL url_src = null;
		try {
			url_src = new URL(Configuration.URL_SERVICE_TAP + "/sync?REQUEST=doQuery&LANG=ADQL&QUERY=SELECT+*+FROM+TAP_SCHEMA.columns");
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, Langage.getMessage_err_url(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		// récupération de l'input stream de la VOTable :
		InputStream source = getInputStream(url_src);
		
		// begin the parsing
		SavotPullParser sb = new SavotPullParser(source, SavotPullEngine.SEQUENTIAL, "UTF-8"); // parsing starting 

		// get the next resource of the VOTable file
		SavotResource currentResource = sb.getNextResource();  // get the next resource

		// while a resource is available
		while (currentResource != null) {

			// for each table of this resource
			for (int i = 0; i < currentResource.getTableCount(); i++) {
				
				// on récupère les fields dans un tableau :
				FieldSet fields = currentResource.getFieldSet(i);
				SavotField[] tab_fields = new SavotField[fields.getItemCount()];
				for(int j=0; j<fields.getItemCount(); j++) {
					tab_fields[j] = (SavotField)fields.getItemAt(j);
				}
				
				// récupération des index des colonnes qui nous interesse :
				int index_table_name = getIndexOfField("table_name", tab_fields);
				
				ArrayList<String> liste_tables = new ArrayList<String>();
				ArrayList<String> liste_colonnes = new ArrayList<String>();
				
				TRSet tr = currentResource.getTRSet(i);

				if (tr != null) {
					System.out.println("Number of items in TRset (= number of <TR></TR>) : " + tr.getItemCount());

					// for each row of the table
					for (int j = 0; j < tr.getItemCount(); j++) {

						// get all the data of the row
						TDSet theTDs = tr.getTDSet(j);

						String currentLine = new String();

						//System.out.println("Number of items in TDSet for the index " + (j+1) + " tr (= number of <TD></TD>) : " + theTDs.getItemCount());

						// for each data of the row
						for (int k = 0; k < theTDs.getItemCount(); k++) {
							String data = theTDs.getContent(k);
							if(k == index_table_name && !liste_tables.contains(data) && !data.matches("TAP_SCHEMA.*")) { 
								liste_tables.add(data);
								System.out.println(data);
							}
							//currentLine = currentLine + theTDs.getContent(k);
							//System.out.println("<" + theTDs.getContent(k) + ">");
						}
					}
				}
			}
			// get the next resource
			currentResource = sb.getNextResource();
		}

	}
	
	
	/**
	 * Permet de connaitre l'index du field passée en parametre
	 * @param field_name Nom du field dont on veut l'index
	 * @param tab_fields Tableau contenant l'ensemble des fields
	 * @return L'index ou -1 si non trouvée 
	 */
	private static int getIndexOfField(String field_name, SavotField[] tab_fields) {
		int index = -1;
		
		for(int i=0; i<tab_fields.length; i++) {
			if(tab_fields[i].getName().equals(field_name))
				return i;
		}
		
		return index;
	}
	
	
}












