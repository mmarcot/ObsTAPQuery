package fr.obs.util;

import java.awt.GraphicsConfiguration;

import javax.swing.Icon;


/**
 * Classe qui regroupe l'ensemble des chaines de caractère visible pour
 * l'utilisateur afin de pouvoir changer de langue facilement
 * @author Mallory Marcot
 *
 */
public class Langage {
	
	/** Langage francais */
	public static String FRANCAIS = "FR";
	/** Langage anglais */
	public static String ENGLISH = "EN";
	
	/** langage actuellement utilisé */
	private static String current_lang = ENGLISH;
	
	
	
	/**
	 * Permet de changer de langage
	 * @param l le nouveau langage
	 */
	public static void setLangage(String l) {
		current_lang = l;
	}
	
	
	
	/**
	 * Texte correspondant au titre de la partie requete
	 * @return String
	 */
	public static String getReq_titre() {
		if(current_lang.equals("FR"))
			return "Requête résultante";
		else
			return "Resulting query";
	}
	
	
	
	/**
	 * Texte correspondant a la description de la partie requete
	 * @return String
	 */
	public static String getReq_desc() {
		if(current_lang.equals("FR"))
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
		if(current_lang.equals("FR"))
			return "Générer requête";
		else
			return "Generate query";
	}
	
	
	
	/**
	 * Texte tooltip correspondant au bouton générer
	 * @return String
	 */
	public static String getReq_generer_tt() {
		if(current_lang.equals("FR"))
			return "Génère la requête dans la zone de texte à gauche";
		else
			return "Generate the query in the left text area";
	}
	
	
	/**
	 * Texte correspondant au bouton executer
	 * @return String
	 */
	public static String getReq_executer() {
		if(current_lang.equals("FR"))
			return "Exécuter requête";
		else
			return "Perform query";
	}
	
	
	/**
	 * Texte tooltip correspondant au bouton executer
	 * @return String
	 */
	public static String getReq_executer_tt() {
		if(current_lang.equals("FR"))
			return "Permet d'exécuter la requête et de voir son résultat dans Aladin";
		else
			return "To perform the query and see the result in Aladin";
	}
	
	
	/**
	 * Texte correspondant au bouton help
	 * @return String
	 */
	public static String getReq_help() {
		if(current_lang.equals("FR"))
			return "Aide";
		else
			return "Help";
	}
	
	
	/**
	 * Texte tooltip correspondant au bouton help
	 * @return String
	 */
	public static String getReq_help_tt() {
		if(current_lang.equals("FR"))
			return "Pour recevoir de l'aide";
		else
			return "To get helped";
	}
	
	
	
	/**
	 * Texte correspondant au bouton ajouter contrainte
	 * @return 
	 */
	public static String getWhere_but_constraint() {
		if(current_lang.equals("FR"))
			return "<html>Contrainte<br>générique</html>";
		else
			return "<html>Generic field's<br>constraint</html>";
	}
	
	
	/**
	 * Texte correspondant au tooltip bouton 'ajouter contrainte'
	 * @return 
	 */
	public static String getWhere_but_add_tt() {
		if(current_lang.equals("FR"))
			return "Ajoute une ligne de contrainte";
		else
			return "Add a constraint line";
	}
	
	
	
	
	/**
	 * Texte correspondant au bouton supprime contrainte
	 * @return 
	 */
	public static String getWhere_but_remove() {
		if(current_lang.equals("FR"))
			return "Supprimer";
		else
			return "Remove";
	}
	
	
	/**
	 * Texte correspondant au tooltip du bouton supprimer contrainte
	 * @return 
	 */
	public static String getWhere_but_remove_tt() {
		if(current_lang.equals("FR"))
			return "Supprimer cette contrainte";
		else
			return "Remove this constraint";
	}
	
	
	/**
	 * Texte correspondant à l'aide 
	 * @return L'aide
	 */
	public static String getAide() {
		if(current_lang.equals("FR"))
			return "Le contenu de l'aide";
		else
			return "Content help";
	}



	/**
	 * Texte correspondant au bouton clear
	 * @return texte
	 */
	public static String getReq_clear() {
		if(current_lang.equals("FR"))
			return "Recommencer";
		else
			return "Clear all";
	}
	
	
	/**
	 * Texte correspondant au tooltip du bouton clear
	 * @return texte
	 */
	public static String getReq_clear_tt() {
		if(current_lang.equals("FR"))
			return "Vider tous les champs";
		else
			return "Clear all fields";
	}
	
	
	/**
	 * Texte correspondant au titre de la confirm dialog pour clear
	 * @return texte
	 */
	public static String getAttention() {
		if(current_lang.equals("FR"))
			return "Attention";
		else
			return "Warning";
	}
	
	
	/**
	 * Texte correspondant au message de la confirm dialog pour clear
	 * @return texte
	 */
	public static String getReq_clear_message_dialog() {
		if(current_lang.equals("FR"))
			return "Etes-vous sûr de vouloir recommencer la saisie ?";
		else
			return "Are you sure that you want to clear all fields ?";
	}
	
	
	/**
	 * Texte correspondant au message de la confirm dialog pour clear
	 * @return texte
	 */
	public static String getReq_changer_table_message_dialog() {
		if(current_lang.equals("FR"))
			return "Cette action va nettoyer la saisie";
		else
			return "It's going to clear all fields, please confirm";
	}
	
	
	
	/**
	 * Texte correspondant au titre de la confirm dialog pour perform
	 * @return texte
	 */
	public static String getErreur() {
		if(current_lang.equals("FR"))
			return "Erreur";
		else
			return "Error";
	}
	
	
	/**
	 * Texte correspondant au message de la confirm dialog pour perform
	 * @return texte
	 */
	public static String getReq_perform_message_dialog_err() {
		if(current_lang.equals("FR"))
			return "Le plug-in doit fonctionner avec Aladin";
		else
			return "The plug-in must run with Aladin";
	}


	/**
	 * Message de la boite de dialogue lorsque l'on arrive pas à se connecter 
	 * à la base de donnée
	 * @return
	 */
	public static String getMessage_err_conn_bdd() {
		if(current_lang.equals("FR"))
			return "Impossible de se connecter à la base de données";
		else
			return "Failing to connect with the database";
	}
	
	
	/**
	 * Message de la boite de dialogue lorsque l'on arrive pas à se récupérer 
	 * les chamsp obscore dans la base de donnée
	 * @return
	 */
	public static String getMessage_err_recup_bdd() {
		if(current_lang.equals("FR"))
			return "Impossible recupérer le TAP schéma";
		else
			return "Unable to get the TAP schema";
	}
	
	
	
	/**
	 * Texte correspondant à la check box select all
	 * @return texte
	 */
	public static String getSelect_all() {
		if(current_lang.equals("FR"))
			return "Tout cocher";
		else
			return "Select all";
	}



	/**
	 * Message d'erreur lors de la récupération des tables dans le TAP SCHEMA
	 * @return
	 */
	public static String getMessage_err_recup_bdd_tables() {
		if(current_lang.equals("FR"))
			return "Impossible de récupérer les différentes tables dans la base de données";
		else
			return "Unable to get tables from database";
	}
	
	
	/**
	 * Message d'erreur lors de la récupération des colonnes dans le TAP SCHEMA
	 * @return
	 */
	public static String getMessage_err_recup_bdd_colonnes() {
		if(current_lang.equals("FR"))
			return "Impossible de récupérer les différentes colonnes dans la table";
		else
			return "Unable to get columns from table";
	}


	/**
	 * @return Texte correspondant au JMenu "Option"
	 */
	public static String getMenuOption() {
		if(current_lang.equals("FR"))
			return "Option";
		else
			return "Option";
	}


	/**
	 * @return Texte correspondant au JMenuItem "url du serveur"
	 */
	public static String getMenuItemUrlBDD() {
		if(current_lang.equals("FR"))
			return "URL service TAP";
		else
			return "URL TAP service";
	}


	/**
	 * @return Texte correspondant au JMenu "fichier"
	 */
	public static String getMenuFichier() {
		if(current_lang.equals("FR"))
			return "Fichier";
		else
			return "File";
	}


	/**
	 * @return Texte correspondant au JMenuItem "enregistrer la requete"
	 */
	public static String getMenuItemEnrReq() {
		if(current_lang.equals("FR"))
			return "Sauv. requête";
		else
			return "Save query";
	}
	
	
	public static String getMenuItemLoadReq() {
		if(current_lang.equals("FR"))
			return "Charger requête";
		else
			return "Load query";
	}


	/**
	 * @return Texte correspondant au JMenu help
	 */
	public static String getMenuHelp() {
		if(current_lang.equals("FR"))
			return "Aide";
		else
			return "Help";
	}


	/**
	 * @return Texte correspondant au JMenuItem documentation
	 */
	public static String getMenuItemDocu() {
		if(current_lang.equals("FR"))
			return "Documentation";
		else
			return "Documentation";
	}


	/**
	 * @return Texte correspondant au JMenuItem about
	 */
	public static String getMenuItemAbout() {
		if(current_lang.equals("FR"))
			return "À propos";
		else
			return "About";
	}


	/**
	 * @return Texte correspondant à cancel
	 */
	public static String getCancel() {
		if(current_lang.equals("FR"))
			return "Annuler";
		else
			return "Cancel";
	}
	
	
	/**
	 * @return Texte correspondant à OK
	 */
	public static String getOk() {
		if(current_lang.equals("FR"))
			return "OK";
		else
			return "OK";
	}



	/**
	 * @return Texte correspondant au mot quitter
	 */
	public static String getQuitter() {
		if(current_lang.equals("FR"))
			return "Quitter";
		else
			return "Exit";
	}


	/**
	 * @return Texte correspondant au message d'erreur url incorrect
	 */
	public static String getMessage_err_url() {
		if(current_lang.equals("FR"))
			return "URL incorrect";
		else
			return "Bad URL";
	}


	/**
	 * @return Texte correspondant à la saisie du path
	 */
	public static String getPath() {
		if(current_lang.equals("FR"))
			return "Chemin vers le fichier";
		else
			return "Path to file";
	}


	/**
	 * @return Texte correspondant au message d'erreur fichier non trouvé
	 */
	public static String getFileNotFound() {
		if(current_lang.equals("FR"))
			return "Fichier non trouvé";
		else
			return "File not found";
	}


	/**
	 * @return Texte correspondant au à la clause limit
	 */
	public static String getLimit() {
		if(current_lang.equals("FR"))
			return "Clause LIMIT";
		else
			return "LIMIT clause";
	}


	/**
	 * @return Texte correspondant à la saisie de la clause limit
	 */
	public static String getLimitInputMessage() {
		if(current_lang.equals("FR"))
			return "Entrez la valeur de la clause LIMIT";
		else
			return "Enter the value of the LIMIT clause";
	}


	/**
	 * @return Texte correspondant au message d'erreur lors de la saisie d'un nombre
	 */
	public static String getErreurEntrezNombreEntier() {
		if(current_lang.equals("FR"))
			return "Entrez un nombre entier SVP";
		else
			return "Please enter an integer";
	}


	/**
	 * @return Texte correspondant à "pas de limite"
	 */
	public static String getNoLimit() {
		if(current_lang.equals("FR"))
			return "Pas de limite";
		else
			return "No limit";
	}


	/**
	 * @return Texte correspondant à la saisie d'une limite
	 */
	public static String getMenuItemEnterLimitValue() {
		if(current_lang.equals("FR"))
			return "Entrer limite...";
		else
			return "Enter limit...";
	}


	/**
	 * @return bouton position
	 */
	public static String getPosition() {
		if(current_lang.equals("FR"))
			return "Position";
		else
			return "Position";
	}



	/**
	 * @return ToolTip bouton position
	 */
	public static String getPosition_tt() {
		if(current_lang.equals("FR"))
			return "Ajouter une contrainte sur la position";
		else
			return "Add a constraint on position";
	}


	/**
	 * @return Ascension droite recherche par position
	 */
	public static String getRA() {
		if(current_lang.equals("FR"))
			return "RA";
		else
			return "RA";
	}
	
	
	/**
	 * @return Déclinaison recherche position
	 */
	public static String getDEC() {
		if(current_lang.equals("FR"))
			return "DEC";
		else
			return "DEC";
	}

	
	/**
	 * @return Rayon recherche position
	 */
	public static String getRayon() {
		if(current_lang.equals("FR"))
			return "Rayon";
		else
			return "Radius";
	}


	/**
	 * @return Message erreur lors de la saisie d'un double
	 */
	public static String getEntrezDouble() {
		if(current_lang.equals("FR"))
			return "Entrez un nombre réel SVP";
		else
			return "Please enter a float number";
	}


	/**
	 * @return unité degré
	 */
	public static String getDeg() {
		if(current_lang.equals("FR"))
			return "deg";
		else
			return "deg";
	}


	/**
	 * @return unité arcmin
	 */
	public static String getArcmin() {
		if(current_lang.equals("FR"))
			return "arcmin";
		else
			return "arcmin";
	}
	
	
	/**
	 * @return unité arcsec
	 */
	public static String getArcsec() {
		if(current_lang.equals("FR"))
			return "arcsec";
		else
			return "arcsec";
	}


	/**
	 * @return Right ascension
	 */
	public static String getRA_tt() {
		if(current_lang.equals("FR"))
			return "Ascension droite";
		else
			return "Right ascension";
	}
	
	
	/**
	 * @return Déclinaison
	 */
	public static String getDEC_tt() {
		if(current_lang.equals("FR"))
			return "Déclinaison";
		else
			return "Declination";
	}



	public static String getExemple() {
		if(current_lang.equals("FR"))
			return "Exemples";
		else
			return "Examples";
	}



	public static String getExemple_tt() {
		if(current_lang.equals("FR"))
			return "Pour essayer quelques exemples";
		else
			return "Try some examples";
	}



	public static String getChoisirExemple() {
		if(current_lang.equals("FR"))
			return "Choisissez un exemple";
		else
			return "Please choose an example";
	}



	public static String getTitrePartieWhere() {
		if(current_lang.equals("FR"))
			return "Contraintes";
		else
			return "Constraints";
	}



	public static String getPreselectedFields() {
		if(current_lang.equals("FR"))
			return "<html><br>Champs selectionnés pour :</html>";
		else
			return "<html><br>Preselected fields for :</html>";
	}


	
}















