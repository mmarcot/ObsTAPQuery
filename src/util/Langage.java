package util;

public class Langage {
	private static String lang = "EN";
	
	/** Langage francais */
	public static String FRANCAIS = "FR";
	/** Langage anglais */
	public static String ENGLISH = "EN";
	
	
	
	/**
	 * Permet de changer de langage
	 * @param l le nouveau langage
	 */
	public static void setLangage(String l) {
		lang = l;
	}
	
	
	
	/**
	 * Texte correspondant au titre de la partie requete
	 * @return String
	 */
	public static String getReq_titre() {
		if(lang.equals("FR"))
			return "Requête résultante";
		else
			return "Resulting query";
	}
	
	
	
	/**
	 * Texte correspondant a la description de la partie requete
	 * @return String
	 */
	public static String getReq_desc() {
		if(lang.equals("FR"))
			return "Cliquez sur '" + getReq_generer() +
					"', modifiez la, puis exécutez la.";
		else
			return "Click on '" + getReq_generer() +
					"', modify the query, then perform it.";
	}
	
	
	
	/**
	 * Texte correspondant au bouton générer
	 * @return String
	 */
	public static String getReq_generer() {
		if(lang.equals("FR"))
			return "Générer requête";
		else
			return "Generate query";
	}
	
	
	
	/**
	 * Texte tooltip correspondant au bouton générer
	 * @return String
	 */
	public static String getReq_generer_tt() {
		if(lang.equals("FR"))
			return "Génère la requête dans la zone de texte à gauche";
		else
			return "Generate the query in the left text area";
	}
	
	
	/**
	 * Texte correspondant au bouton executer
	 * @return String
	 */
	public static String getReq_executer() {
		if(lang.equals("FR"))
			return "Exécuter requête";
		else
			return "Perform query";
	}
	
	
	/**
	 * Texte tooltip correspondant au bouton executer
	 * @return String
	 */
	public static String getReq_executer_tt() {
		if(lang.equals("FR"))
			return "Permet d'exécuter la requête et de voir son résultat";
		else
			return "To perform the query in the left text area, and see the result";
	}
	
	
	/**
	 * Texte correspondant au bouton help
	 * @return String
	 */
	public static String getReq_help() {
		if(lang.equals("FR"))
			return "Aide";
		else
			return "Help";
	}
	
	/**
	 * Texte tooltip correspondant au bouton help
	 * @return String
	 */
	public static String getReq_help_tt() {
		if(lang.equals("FR"))
			return "Pour recevoir de l'aide";
		else
			return "To get helped";
	}
	
	
	
	/**
	 * Texte correspondant au bouton ajouter contrainte
	 * @return 
	 */
	public static String getWhere_but_add() {
		if(lang.equals("FR"))
			return "Ajouter";
		else
			return "Add";
	}
	
	
	/**
	 * Texte correspondant au tooltip bouton 'ajouter contrainte'
	 * @return 
	 */
	public static String getWhere_but_add_tt() {
		if(lang.equals("FR"))
			return "Ajoute une ligne de contrainte";
		else
			return "Add a constraint line";
	}
	
	
	
	
	/**
	 * Texte correspondant au bouton supprime contrainte
	 * @return 
	 */
	public static String getWhere_but_remove() {
		if(lang.equals("FR"))
			return "Supprimer";
		else
			return "Remove";
	}
	
	
	/**
	 * Texte correspondant au tooltip du bouton supprimer contrainte
	 * @return 
	 */
	public static String getWhere_but_remove_tt() {
		if(lang.equals("FR"))
			return "Supprimer cette contrainte";
		else
			return "Remove this constraint";
	}
}














