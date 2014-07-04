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
	private ArrayList<String> liste_tables;
	
	
	/**
	 * Constructeur du gestionnaire de tables
	 */
	public GestionnaireDeTables() {
		liste_tables = new ArrayList<String>();
		chercherTables();
	}
	
	
	/**
	 * Methode qui va chercher les tables dans la base de données
	 */
	private void chercherTables() {
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
	private Connection seConnecterBDD() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(Configuration.URL_BDD_JDBC, Configuration.USER_BDD, Configuration.MOT_DE_PASSE_BDD);
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, Langage.getMessage_err_conn_bdd(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
}






