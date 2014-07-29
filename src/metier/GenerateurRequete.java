package metier;

import interface_plugin.AbstractLigne;
import interface_plugin.From;
import interface_plugin.LigneDeContrainte;
import interface_plugin.Requete;
import interface_plugin.Select;
import interface_plugin.Where;

import java.util.ArrayList;

import util.Configuration;


/**
 * Classe qui permet de générer une requete ADQL en fonction du select
 * et des contraintes (where)
 * @author Mallory Marcot
 *
 */
public class GenerateurRequete {

	private Select select;
	private From from;
	private Where where;
	private Requete requete;

	
	/**
	 * Constructeur d'un générateur de requête avec les bonnes références
	 * @param select Référence vers le select du plug-in
	 * @param from Référence vers le from du plug-in
	 * @param where Référence vers le where du plug-in
	 * @param requete Référence vers la zone de requete resultante du plug-in
	 */
	public GenerateurRequete(Select sel, From fro, Where whe, Requete req) {
		this.select = sel;
		this.from = fro;
		this.where = whe;
		this.requete = req;
	}
	
	
	
	/**
	 * Methode qui va générer la requête et l'afficher dans la zone de texte
	 * requête résultante
	 */
	public void generer() {
		String req = new String();

		// construction de la requete
		req += genererSelect();
		req += genererFrom();
		req += genererWhere();
		req = (req.trim() + ";");
		
		// affichage :
		requete.setTexteRequete(req);
	}
	



	/**
	 * Methode qui génère la partie "select" de la requete
	 */
	private String genererSelect() {
		String ret = new String("SELECT ");
		if(Configuration.LIMIT != -1) {
			ret += ("TOP " + Integer.toString(Configuration.LIMIT) + " "); 
		}
		ArrayList<String> liste_col_checked = select.getChecked();
		boolean all_selected = select.getCb_select_all().isSelected();
		
		if(all_selected) {
			ret += "*";
		}
		else {
			// on ajoute les colonnes une à une :
			for(String col : liste_col_checked) 
				ret += (col + ", ");
			// puis on enleve la virgule de fin :
			if(liste_col_checked.size() > 0)
				ret = ret.substring(0, ret.length()-2);
			else
				ret += "*";
		}
		
		return ret + "\n";
	}
	
	
	
	/**
	 * Methode qui génère la partie "from" de la requete
	 */
	private String genererFrom() {
		String ret = "FROM ";
		ret += from.getSelectedTable();
		
		return ret + "\n";
	}

	
	
	/**
	 * Methode qui génère la partie "where" de la requete
	 */
	private String genererWhere() {
		String ret = new String();
		
		// on récupère les lignes de contraintes :
		AbstractLigne[] tab_lignes_cont = where.getGestionnaire().getLignes();
		
		for(AbstractLigne ligne : tab_lignes_cont) {
			ret += ligne.toString() + '\n'; 
		}
		
		return ret;
	}
	
	
	
}



















