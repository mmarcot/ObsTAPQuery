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

	/**
	 * Methode statique qui renvoie l'ensemble des colonnes obscores
	 * à incorporer dans le plug-in
	 * @return ArrayList<String> liste colonnes
	 */
	public static ArrayList<UnChampsObscore> getColonnesObscore() {
		ArrayList<UnChampsObscore> liste_col = new ArrayList<UnChampsObscore>();

		try {
			Class.forName("org.postgresql.Driver");

			Connection conn = DriverManager.getConnection(Configuration.URL_BDD_JDBC, Configuration.USER_BDD, Configuration.MOT_DE_PASSE_BDD);
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, Langage.getMessage_err_conn_bdd(), Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
		}

		//liste_col.add(new UnChampsObscore("instrument_name", Configuration.VARCHAR));

		return liste_col;
	}

}
