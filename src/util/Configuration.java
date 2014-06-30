package util;

import java.awt.*;


/**
 * Classe qui centralise toutes les variables de configuration
 * @author Mallory Marcot
 *
 */
public class Configuration {
	
	/** Largeur totale du plug-in */
	public static int LARGEUR_PLUGIN_PX = 800;
	/** Hauteur totale du plug-in */
	public static int HAUTEUR_PLUGIN_PX = 600;
	
	/** Police par default du plug-in */
	public static String POLICE = Font.MONOSPACED;
	
	/** Vitesse incrémentation scrollbar verticale */
	public static int VITESSE_SCROLL_VER = 23;
	/** Vitesse incrémentation scrollbar horizontale */ 
	public static int VITESSE_SCROLL_HOR = 10;
	
	/** horizontal gap flowlayout dans le gestionnaire de contrainte */
	public static int HGAP_FLOWLAYOUT = 5;
	/** vertical gap flowlayout dans le gestionnaire de contrainte */
	public static int VGAP_FLOWLAYOUT = 5;
	
	/** Tableau contenant l'ensemble des opérateurs du where */
	public static String[] TAB_OPERATEURS_WHERE = {"=", "!=", "<", ">", "<=", ">=", "LIKE", "IS", "BETWEEN"};
	/** Tableau contenant l'ensemble des opérateurs de liaison */
	public static String[] TAB_LIAISONS = {"AND", "OR"};
	
	/** taille d'un petit JTextField (pour between) */
	public static int TAILLE_JTEXTFIELD_BETWEEN = 5;
	/** taille d'un grand JTextField (normal) */
	public static int TAILLE_JTEXTFIELD_NORMAL = 14;
	
	/** Nombre de lignes max dans la combo box des opérateurs 
	 * avant l'apparition de la scrollbar */
	public static final int NB_LIGNES_COMBOBOX_OPER = TAB_OPERATEURS_WHERE.length;
	
	/** hauteur d'une ligne de contrainte dans le gestionnaire de contraintes */
	public static final int HAUTEUR_UNE_LIGNE_CONTRAINTE = 35 + VGAP_FLOWLAYOUT;
	
	/** Liste des caractère définissant une chaine de carac */
	public static final String LISTE_CARACTERE_STRING = "AZERTYUIOPQSDFGHJKLMWXCVBN%_-[]^";
	
}
