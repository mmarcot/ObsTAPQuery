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
	
	private double hauteur_une_ligne = 0.0;
	
	/**
	 * Constructeur d'un gestionnaire de contraintes
	 */
	public GestionnaireDeContraintes() {
		this.setBackground(Color.white);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, Configuration.HGAP_FLOWLAYOUT, Configuration.VGAP_FLOWLAYOUT));
		
		hauteur_une_ligne = getPreferredSize().getHeight() - Configuration.VGAP_FLOWLAYOUT;
	}
	

	
	@Override
	public Component add(Component comp) {
		super.add(comp);
		updatePreferSize();
		revalidate();
		repaint();
		
		// fix bug affichage java 8 :
		getComponent(getComponentCount()-1).repaint();
		
		return comp;
	}
	
	
	@Override
	public void remove(Component comp) {
		super.remove(comp);
		
		if( getComponentCount() > 0 ) {
			LigneDeContrainte premiere_ligne = (LigneDeContrainte) getComponent(0);
			premiere_ligne.enleverLiaison();
		}
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
			this.setPreferredSize(new Dimension(100, hauteur_totale));
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












