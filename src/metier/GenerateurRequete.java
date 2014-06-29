package metier;

import interface_plugin.LigneDeContrainte;
import interface_plugin.Requete;
import interface_plugin.Select;
import interface_plugin.Where;

import java.awt.Component;
import java.util.ArrayList;


/**
 * Classe qui permet de générer une requete ADQL en fonction du select
 * et des contraintes (where)
 * @author Mallory Marcot
 *
 */
public class GenerateurRequete {

	private Select select;
	private Where where;
	private Requete requete;

	/**
	 * Constructeur d'un générateur de requête avec les bonnes références
	 * @param select Référence vers le select du plug-in
	 * @param where Référence vers le where du plug-in
	 * @param requete Référence vers la zone de requete resultante du plug-in
	 */
	public GenerateurRequete(Select sel, Where whe, Requete req) {
		this.select = sel;
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
		req += (genererSelect() + "\n");
		req += (genererFrom() + "\n");
		req += (genererWhere() + "\n");
		req = (req.trim() + ";");
		
		// affichage :
		requete.setTexteRequete(req);
	}
	
	
	/**
	 * Methode qui génère la partie "select" de la requete
	 */
	private String genererSelect() {
		String ret = new String("SELECT ");
		ArrayList<String> tab_col = select.getChecked();
		
		// on ajoute les colonnes une à une :
		for(String col : tab_col) {
			ret += (col + ", ");
		}
		// puis on enleve la virgule de fin :
		if(tab_col.size() > 0)
			ret = ret.substring(0, ret.length()-2);
		else
			ret += "*";
		
		return ret;
	}
	
	
	/**
	 * Methode qui génère la partie "from" de la requete
	 */
	private String genererFrom() {
		return new String("FROM obscore");
	}

	
	
	/**
	 * Methode qui génère la partie "where" de la requete
	 */
	private String genererWhere() {
		String ret = new String("WHERE ");
		
		// on récupère les lignes de contraintes :
		LigneDeContrainte[] tab_lignes_cont = where.getGestionnaire().getLignes();
		
		for(LigneDeContrainte ligne : tab_lignes_cont) {
			ret += ligne.toString() + '\n';
		}
		
		return ret;
	}
	
	
}



















