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
	
	private int hauteur_une_ligne;
	private int largeur_une_ligne;
	
	
	/**
	 * Constructeur d'un gestionnaire de contraintes
	 */
	public GestionnaireDeContraintes() {
		this.setBackground(Color.white);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, Configuration.HGAP_FLOWLAYOUT, Configuration.VGAP_FLOWLAYOUT));
		
		// prise de dimension d'une ligne :
		add(new LigneDeContrainte(true));
		hauteur_une_ligne = (int) (getPreferredSize().getHeight() - Configuration.VGAP_FLOWLAYOUT);
		largeur_une_ligne = (int) getPreferredSize().getWidth();
		removeAll();
	}
	

	/**
	 * Permet de mettre à jour les Lignes de contrainte pour que leur JComboBox
	 * prennent en compte le changement de table dans le from
	 */
	public void mettreAJourColonnes() {
		LigneDeContrainte[] tab_lignes = getLignes();
		
		for(LigneDeContrainte ligne : tab_lignes) {
			ligne.mettreAJourColonnesComboBox();
		}
		
	}
	
	
	/**
	 * Permet d'ajouter une ligne de contrainte au gestionnaire
	 */
	@Override
	public Component add(Component comp) {
		super.add(comp);
		
		mettreAJour();
		
		return comp;
	}
	
	
	/**
	 * Permet d'enlever une ligne de contrainte au gestionnaire
	 */
	@Override
	public void remove(Component comp) {
		super.remove(comp);
		
		if( getComponentCount() > 0 ) {
			LigneDeContrainte premiere_ligne = (LigneDeContrainte) getComponent(0);
			premiere_ligne.enleverLiaison();
		}
		
		mettreAJour();
	}
	
	
	/**
	 * Permet de mettre à jour l'affichage dans le gestionnaire de contraintes
	 */
	public void mettreAJour() {
		updatePreferSize();
		revalidate();
		repaint();
		
		// fix bug affichage java 8 :
		if(getComponentCount() > 0)
			getComponent(getComponentCount()-1).repaint();
	}
	
	
	
	/**
	 * Met à jour la preferred size pour gestion dynamique de la scrollbar
	 */
	private void updatePreferSize() {
		if(getComponentCount() > 1 ) {
			int hauteur_totale = ((int) (hauteur_une_ligne*getComponentCount())+Configuration.VGAP_FLOWLAYOUT);
			this.setPreferredSize(new Dimension(largeur_une_ligne, hauteur_totale));
		}
		
	}
	
	
	
	/**
	 * Retourne toutes les lignes du gestionnaire de contraintes
	 * sous forme de tableau
	 * @return Tableau de LigneDeContrainte
	 */
	public LigneDeContrainte[] getLignes() {
			// on récupère les lignes de contraintes :
			Component[] tab_lignes_cont = getComponents();

			// on les cast correctement et on les met dans un tableau :
			LigneDeContrainte[] tab_cont_ret = new LigneDeContrainte[getComponentCount()];
			int i = 0;
			for(Component ligne : tab_lignes_cont) {
				tab_cont_ret[i] = (LigneDeContrainte) ligne;
				i++;
			}
			
			return tab_cont_ret;
	}
	
}












