package util;

import java.awt.*;


/**
 * Classe qui centralise toutes les variables de configuration
 * @author Mallory Marcot
 *
 */
public class Configuration {
	
	/** Largeur totale du plug-in */
	public static int LARGEUR_PLUGIN_PX = 850;
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
	public static String[] TAB_OPERATEURS_WHERE = {"=", "!=", "<", ">", "<=", ">=", "LIKE", "NOT LIKE", "IS", "IS NOT", "BETWEEN", "NOT BETW"};
	/** Tableau contenant l'ensemble des opérateurs de liaison */
	public static String[] TAB_LIAISONS = {"AND", "OR"};
	/** Nombre de lignes max dans la combo box des opérateurs 
	 * avant l'apparition de la scrollbar */
	public static final int NB_LIGNES_COMBOBOX_OPER = 9;
	
	/** taille d'un petit JTextField (pour between) */
	public static int TAILLE_JTEXTFIELD_BETWEEN = 5;
	/** taille d'un grand JTextField (normal) */
	public static int TAILLE_JTEXTFIELD_NORMAL = 14;
	
	/** Liste des caractère définissant une chaine de carac */
	public static final String LISTE_CARACTERE_STRING = "AZERTYUIOPQSDFGHJKLMWXCVBN%_-[]^";
	
	/** Url vers le service tap de Saada */
	public static final String URL_SERVICE_TAP = "http://obs-stage-s4.u-strasbg.fr:8080/vizier2/tap";
	/** Url de la base de donnée pour JDBC */
	public static final String URL_BDD_JDBC = "jdbc:postgresql://obs-stage-s4.u-strasbg.fr:5432/vizier2";
	/** user de la bdd */
	public static final String USER_BDD = "postgres";
	/** mot de passe de la bdd */
	public static final String MOT_DE_PASSE_BDD = "reverser";
	
	/** table selectionnée par default dans le from */
	public static String TABLE_PAR_DEFAULT = "ivoa.ObsCore";
	
	
}
