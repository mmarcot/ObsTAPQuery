package metier;


/**
 * Classe statique qui gère les différents exemples de requete et leur selection
 * par l'utilisateur
 * @author Mallory Marcot
 *
 */
public class GestionnaireExemples {
	
	/** variable qui dit quel est l'exemple selectionné dans le tableau */
	private static int selected_index = 1;
	
	/** tableau contenant les exemples */
	private static String[] tab_exemples = {
			"Select only cube datasets",
			"Select datasets with central position in a north cap of 10 degrees radius (s_dec > +80)",
			"Select datasets with observation date between modified julian day 55000 and 55100",
			"Select datasets with minimal wavelength between 2E-4 and 9E-4 and maximal wavelength either the same or unknown",
			"Select datasets with observation date between modified julian day 53000 and 54000, minimal wavelength between 0.01 and 0.02 and maximal wavelength either the same or unknown and facility = VLA"
	};
	
	/** tableau contenant les requetes correspondant aux exemples */
	private static String[] tab_req = {
		"SELECT *\nFROM ivoa.ObsCore\nWHERE dataproduct_type = 'cube';",

		"SELECT *\nFROM ivoa.ObsCore\nWHERE s_dec > 80",
		"SELECT *\nFROM ivoa.ObsCore\nWHERE t_min BETWEEN 55000 AND 55100;",
		"SELECT *\nFROM ivoa.ObsCore\nWHERE em_min BETWEEN 2E-4 AND 9E-4;",
		"SELECT *\nFROM ivoa.ObsCore\nWHERE t_min BETWEEN 53000 AND 54000\nAND em_min BETWEEN 0.01 AND 0.02\nAND facility_name = 'VLA';"
	};
	
	
	
	/**
	 * Setter de l'attribut selected_index
	 * @param i Le nouvel index selectionné
	 */
	public static void setSelectedIndex(int i) {
		selected_index = i;
	}
	

	
	/**
	 * @return L'index selectionné
	 */
	public static int getSelectedIndex() {
		return selected_index;
	}


	
	/**
	 * @return Le tableau contenant les chaines de caractère (explications) pour les exemples
	 */
	public static String[] getTab_exemples() {
		return tab_exemples;
	}



	/**
	 * @return Le tableau contenant les requetes
	 */
	public static String[] getTab_req() {
		return tab_req;
	}
}



















