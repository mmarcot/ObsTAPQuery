package metier;

import interface_plugin.Requete;
import interface_plugin.Select;
import interface_plugin.Where;


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
		return null;
		
	}
	
	
	/**
	 * Methode qui génère la partie "from" de la requete
	 */
	private String genererFrom() {
		return null;
		
	}
	
	
	/**
	 * Methode qui génère la partie "where" de la requete
	 */
	private String genererWhere() {
		return null;
		
	}
	
	
	
}
