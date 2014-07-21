package metier;

import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;

import cds.savot.model.*;
import cds.savot.pull.*;
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
	private static ArrayList<UnChamps> liste_colonnes;
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
	 * Methode qui retourne la liste des tables depuis le service TAP ou celles déjà mémorisées
	 * en fonction du paramêtre passé.
	 * @param depuis_service_tap Chercher l'information depuis le service TAP (oui ou non) ?
	 * @return the liste_tables
	 */
	public static ArrayList<String> getListe_tables(boolean depuis_service_tap) {
		if(depuis_service_tap)
			parserVOTable();
		
		return liste_tables;
	}
	
	

	/**
	 * Methode qui retourne la liste des colonnes depuis le service TAP ou celles déjà mémorisées
	 * en fonction du paramêtre passé.
	 * @param depuis_service_tap Chercher l'information depuis le service TAP (oui ou non) ?
	 * @return Liste des colonnes de la table sélectionnée
	 */
	public static ArrayList<UnChamps> getColonnes(boolean depuis_service_tap) {
		if(depuis_service_tap)
			parserVOTable();
		
		return liste_colonnes;
	}
	
	
	
	

	/**
	 * Permet de récupérer l'input stream de la VOTable distante 
	 * @param url URL du fichier CSV
	 * @return Contenu du fichier CSV
	 */
	private static InputStream getInputStream(URL url) {
		InputStream input = null;
		
		try {
			URLConnection connection = url.openConnection();
			input = connection.getInputStream();
		} 
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, Langage.getMessage_err_url(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return input;
	}
	

	/**
	 * Methode qui parse la VOTable et construit la liste des colonnes et la liste des tables
	 */
	private static void parserVOTable() {
		
		// création des listes à charger :
		liste_tables = new ArrayList<String>();
		liste_colonnes = new ArrayList<UnChamps>();
		
		// construction de l'URL :
		URL url_src = null;
		try {
			url_src = new URL(Configuration.URL_SERVICE_TAP + "/sync?REQUEST=doQuery&LANG=ADQL&QUERY=SELECT+*+FROM+TAP_SCHEMA.columns");
		} catch (Exception e) {
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
				int index_column_name = getIndexOfField("column_name", tab_fields);
				int index_datatype= getIndexOfField("datatype", tab_fields);
				int index_unit = getIndexOfField("unit", tab_fields);
				int index_ucd = getIndexOfField("ucd", tab_fields);
				int index_utype = getIndexOfField("utype", tab_fields);
				int index_description = getIndexOfField("description", tab_fields);
				
				TRSet tr = currentResource.getTRSet(i);

				if (tr != null) {
					
					// for each row of the table
					for(int j = 0; j < tr.getItemCount(); j++) {
						boolean ligne_deja_faite = false;

						// get all the data of the row
						TDSet theTDs = tr.getTDSet(j);

						// for each data of the row
						for(int k = 0; k < theTDs.getItemCount(); k++) {
							
							String data = theTDs.getContent(k); // récup la donnée
							
							// on construit la liste des tables :
							if(k == index_table_name && !liste_tables.contains(data) && !data.matches("TAP_SCHEMA.*")) { 
								liste_tables.add(data);
							}
							
							// on construit la liste des colonnes de la table séléctionnée :
							if(theTDs.getContent(index_table_name).equals(table_selectionnee) && !ligne_deja_faite) {
								ligne_deja_faite = true;
								
								String name = theTDs.getContent(index_column_name);
								String datatype = theTDs.getContent(index_datatype);
								String unit = theTDs.getContent(index_unit);
								String ucd = theTDs.getContent(index_ucd);
								String utype = theTDs.getContent(index_utype);
								String description = theTDs.getContent(index_description);
								
								liste_colonnes.add(new UnChamps(name, datatype, unit, ucd, utype, description));
							}
							
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












