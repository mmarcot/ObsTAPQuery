package interface_plugin;

import java.awt.*;

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
		
		this.add(new LigneDeContrainte(false));
		
		hauteur_une_ligne = getPreferredSize().getHeight() - Configuration.VGAP_FLOWLAYOUT;
	}
	
	
	@Override
	public Component add(Component comp) {
		super.add(comp);
		updatePreferSize();
		revalidate();
		
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
	
}












