package metier;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

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
		if( conn != null) {
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
	
	
}






