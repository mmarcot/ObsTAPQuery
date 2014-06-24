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
			return "Générer";
		else
			return "Generate";
	}
	
	
	/**
	 * Texte correspondant au bouton executer
	 * @return String
	 */
	public static String getReq_executer() {
		if(lang.equals("FR"))
			return "Exécuter";
		else
			return "Perform";
	}
}
