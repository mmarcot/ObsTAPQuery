package interface_plugin;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;



/**
 * Classe qui modélise un gestionnaire de contraintes ou clause "where"
 * dans la requete
 * @author Mallory Marcot
 *
 */
public class GestionnaireDeContraintes extends JPanel {
	
	private ArrayList<LigneDeContrainte> liste_contraintes;
	
	/**
	 * Constructeur d'un gestionnaire de contraintes
	 */
	public GestionnaireDeContraintes() {
		this.setBackground(Color.yellow);
		
		this.liste_contraintes = new ArrayList<LigneDeContrainte>();
		
		this.ajouterLigne();
	}
	
	
	/**
	 * Methode qui permet d'ajouter une ligne de contrainte au 
	 * gestionnaire de contraintes
	 */
	public void ajouterLigne() {
		this.liste_contraintes.add(new LigneDeContrainte());
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
		
		// on rajoute le bon nombre :
		for( LigneDeContrainte ligne : this.liste_contraintes ) {
			this.add(ligne);
		}
		
		repaint(); // TODO Vraiment utile ?
	}
}












