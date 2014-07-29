package metier;

import util.Configuration;
import interface_plugin.AbstractLigne;
import interface_plugin.GestionnaireDeContraintes;
import interface_plugin.LigneDeContrainte;
import interface_plugin.PluginLayout;


/**
 * Classe statique qui gère les différents exemples de requete et leur selection
 * par l'utilisateur
 * @author Mallory Marcot
 *
 */
public class GestionnaireExemples {
	
	/** variable qui dit quel est l'exemple selectionné dans le tableau */
	private static int selected_index = 1;
	
	
	// /!\ les 2 tableaux suivant sont liées : le texte doit correspondre à la requete (en terme d'index)
	
	/** tableau contenant les exemples */
	private static String[] tab_exemples = {
		"only cube datasets",
		"datasets with central position in a north cap of 10 degrees radius (s_dec > +80)",
		"datasets with observation date between modified julian day 55000 and 55100",
		"datasets with minimal wavelength between 2E-4 and 9E-4",
		"datasets with observation date between modified julian day 53000 and 54000, minimal wavelength between 0.01 and 0.02 and facility = VLA"
	};
	

	
	/**
	 * Methode qui ajoute les lignes corresponsant à la requete dans le 
	 * gestionnaire de contraintes
	 * @param gestionnaire Référence au gestionnaire de contrainte
	 * @param index_req Index de la requête selectionnée par l'user
	 */
	public static void executerExemple(GestionnaireDeContraintes gestionnaire, int index_req) {
		
		// construction des requetes dans le gestionnaire de contrainte :
		if(index_req == 0) {
			LigneDeContrainte ligne = new LigneDeContrainte(gestionnaire.besoinLiaison());
			ligne.getCombo_col_obs().setSelectedItem("dataproduct_type");
			ligne.getCombo_oper().setSelectedItem(Configuration.TAB_OPERATEURS_WHERE[0]);
			ligne.getText_valeur().setText("cube");
			gestionnaire.add(ligne);
		}
		else if(index_req == 1) {
			LigneDeContrainte ligne = new LigneDeContrainte(gestionnaire.besoinLiaison());
			ligne.getCombo_col_obs().setSelectedItem("s_dec");
			ligne.getCombo_oper().setSelectedItem(Configuration.TAB_OPERATEURS_WHERE[3]);
			ligne.getText_valeur().setText("80");
			gestionnaire.add(ligne);
		}
		else if(index_req == 2) {
			LigneDeContrainte ligne = new LigneDeContrainte(gestionnaire.besoinLiaison());
			ligne.toBetweenComposition();
			ligne.getCombo_oper().setSelectedItem(Configuration.TAB_OPERATEURS_WHERE[6]);
			ligne.getCombo_col_obs().setSelectedItem("t_min");
			ligne.getText1_between().setText("55000");
			ligne.getText2_between().setText("55100");
			gestionnaire.add(ligne);
		}
		else if(index_req == 3) {
			LigneDeContrainte ligne = new LigneDeContrainte(gestionnaire.besoinLiaison());
			ligne.toBetweenComposition();
			ligne.getCombo_oper().setSelectedItem(Configuration.TAB_OPERATEURS_WHERE[6]);
			ligne.getCombo_col_obs().setSelectedItem("em_min");
			ligne.getText1_between().setText("2E-4");
			ligne.getText2_between().setText("9E-4");
			gestionnaire.add(ligne);
		}
		else if(index_req == 4) {
			LigneDeContrainte ligne = new LigneDeContrainte(gestionnaire.besoinLiaison());
			ligne.toBetweenComposition();
			ligne.getCombo_oper().setSelectedItem(Configuration.TAB_OPERATEURS_WHERE[6]);
			ligne.getCombo_col_obs().setSelectedItem("t_min");
			ligne.getText1_between().setText("53000");
			ligne.getText2_between().setText("54000");
			gestionnaire.add(ligne);
			
			LigneDeContrainte ligne2 = new LigneDeContrainte(gestionnaire.besoinLiaison());
			ligne2.toBetweenComposition();
			ligne2.getCombo_oper().setSelectedItem(Configuration.TAB_OPERATEURS_WHERE[6]);
			ligne2.getCombo_col_obs().setSelectedItem("em_min");
			ligne2.getText1_between().setText("0.01");
			ligne2.getText2_between().setText("0.02");
			gestionnaire.add(ligne2);
			
			LigneDeContrainte ligne3 = new LigneDeContrainte(gestionnaire.besoinLiaison());
			ligne3.getCombo_col_obs().setSelectedItem("facility_name");
			ligne3.getCombo_oper().setSelectedItem(Configuration.TAB_OPERATEURS_WHERE[0]);
			ligne3.getText_valeur().setText("VLA");
			gestionnaire.add(ligne3);
		}
		
	}
	
	
	
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



	
}



















