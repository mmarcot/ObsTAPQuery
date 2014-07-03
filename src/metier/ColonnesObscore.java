package metier;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import util.Configuration;
import util.Langage;


/**
 * Classe qui contient l'ensemble des champs obscore
 * @author Mallory Marcot
 *
 */
public class ColonnesObscore {
	
	private static ArrayList<UnChampsObscore> liste_col;

	/**
	 * Methode statique qui renvoie l'ensemble des colonnes obscores
	 * à incorporer dans le plug-in
	 * Pour avoir cette information la methode se connecte à la base de donnée
	 * contenant le TAP_SCHEMA
	 * @return ArrayList<String> liste colonnes
	 */
	public static ArrayList<UnChampsObscore> getColonnesObscore() {
		
		// si la liste de colonne n'a pas encore été initialisée alors on le fait,
		// sinon on retourne simplement la liste 
		// cela permet de limiter les accès à la BDD et donc d'être + rapide :
		if(liste_col == null) {
			liste_col = new ArrayList<UnChampsObscore>();
			
			// on tente de se connecter à la BDD :
			Connection conn;
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(Configuration.URL_BDD_JDBC, Configuration.USER_BDD, Configuration.MOT_DE_PASSE_BDD);
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, Langage.getMessage_err_conn_bdd(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				return liste_col;
			}
			
			try {
				// recupération des colonnes obscore et de leur descrition :
				Statement state = conn.createStatement();
				ResultSet result = state.executeQuery("select column_name, datatype, unit, ucd, utype " +
														"from columns " +
														"where table_name = 'ivoa.ObsCore'");
				
				
				// on crée tous les champs et on les ajoutent à la liste :
				while(result.next()) {
					String column_name = result.getString("column_name");
					String datatype = result.getString("datatype");
					String unit = result.getString("unit");
					String ucd = result.getString("ucd");
					String utype = result.getString("utype");
					
					liste_col.add(new UnChampsObscore(column_name, datatype, unit, ucd, utype));
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getStackTrace(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
				return liste_col;
			}
		}

		return liste_col;
	}

}
