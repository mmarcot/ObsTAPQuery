package interface_plugin;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import util.Configuration;



/**
 * Classe qui modélise un gestionnaire de contraintes ou clause "where"
 * dans la requete
 * @author Mallory Marcot
 *
 */
public class GestionnaireDeContraintes extends JPanel {
	
	private ArrayList<LigneDeContrainte> liste_contraintes;
	/** hauteur d'une unique ligne de contrainte */
	private double hauteur_une_ligne = 0.0;
	
	/**
	 * Constructeur d'un gestionnaire de contraintes
	 */
	public GestionnaireDeContraintes() {
		this.setBackground(Color.white);
		this.liste_contraintes = new ArrayList<LigneDeContrainte>();
		this.setLayout(new FlowLayout(FlowLayout.CENTER, Configuration.HGAP_FLOWLAYOUT, Configuration.VGAP_FLOWLAYOUT));
		
		this.ajouterLigne();
		
		hauteur_une_ligne = getPreferredSize().getHeight() - Configuration.VGAP_FLOWLAYOUT;
		this.setPreferredSize(new Dimension(0, (int)hauteur_une_ligne));
	}
	
	
	/**
	 * Methode qui permet d'ajouter une ligne de contrainte au 
	 * gestionnaire de contraintes
	 */
	public void ajouterLigne() {
		boolean liaison = false;
		
		if(liste_contraintes.size() > 0)
			liaison = true;
		
		this.liste_contraintes.add(new LigneDeContrainte(liaison));
		miseAJourVue();
	}
	
	


	/**
	 * Methode qui permet de supprimer une ligne de contrainte au 
	 * gestionnaire de contraintes
	 * @param index Index de la ligne dans l'ArrayList
	 */
	public void supprimerLigne(int index) {
		this.liste_contraintes.remove(index);
		miseAJourVue();
	}
	
	
	/**
	 * Methode qui permet de mettre à jour la vue en fonction
	 * du nombre de contraintes
	 */
	public void miseAJourVue() {
		// on supprime tous les composants du gestionnaire:
		this.removeAll(); 
		
		// on met à jour la preferred size pour une gestion de la scrollbar :
		if(liste_contraintes.size() > 1 )
			this.setPreferredSize(new Dimension(100, (int)hauteur_une_ligne*liste_contraintes.size()+Configuration.VGAP_FLOWLAYOUT));
		
		// on rajoute le bon nombre :
		for( LigneDeContrainte ligne : this.liste_contraintes ) {
			this.add(ligne);
		}
		
		revalidate();
	}
}












