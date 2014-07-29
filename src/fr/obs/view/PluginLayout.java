package fr.obs.view;

import java.awt.*;

import javax.swing.*;

import cds.aladin.Aladin;
import fr.obs.util.Configuration;


/**
 * JPanel qui contient l'ensemble de l'interface du plug-in Aladin
 * @author Mallory Marcot
 *
 */
public class PluginLayout extends JPanel {
	
	private Select pan_select;
	private Where pan_where;
	private From pan_from;
	private Requete pan_requete;
	private boolean avec_aladin;
	private Aladin aladin;

	
	/**
	 * Constructeur de l'interface principal avec le lanceur normal
	 *    /!\ Il y a 2 constructeurs
	 */
	public PluginLayout() {
		this.avec_aladin = false;
		
		initPanneaux();
	}
	
	

	/**
	 * Constructeur de l'interface avec pour lanceur Aladin
	 *    /!\ Il y a 2 constructeurs
	 * @param aladin
	 */
	public PluginLayout(Aladin aladin) {
		// affectation des attributs :
		this.avec_aladin = true;
		this.aladin = aladin;
		
		initPanneaux();
	}
	
	
	/**
	 * Permet de tout nettoyer et de mettre à jour les colonnes 
	 * @param maj_from Mise à jour du from (oui ou non)
	 */
	public void mettreAJour(boolean maj_from) {
		// on nettoye tout :
		getSelect().uncheckAll();
		getWhere().toutEnlever();
		getRequete().setTexteRequete(null);
		
		// on met à jour :
		if(maj_from)
			getFrom().mettreAJour();
		getSelect().mettreAJourColonnes();
		getWhere().getGestionnaire().mettreAJourColonnes();
	}
	
	
	/**
	 * Méthode qui initialise les panneaux et leur disposition
	 */
	private void initPanneaux() {
		setPreferredSize(new Dimension(Configuration.LARGEUR_PLUGIN_PX, Configuration.HAUTEUR_PLUGIN_PX));
		setLayout(new BorderLayout());
		
		PartieGauche pan_gauche = new PartieGauche();
		PartieDroite pan_droite = new PartieDroite();
		pan_from = pan_gauche.getFrom();
		pan_select = pan_gauche.getSelect();
		pan_where = pan_droite.getWhere();
		pan_requete = pan_droite.getRequete();
		BarreDeMenu barre_menu = new BarreDeMenu(this);
		
		add(barre_menu, BorderLayout.NORTH);
		add(pan_gauche, BorderLayout.WEST);
		add(pan_droite, BorderLayout.CENTER);
	}


	/**
	 * Get the Select panel
	 * @return the Select panel
	 */
	public Select getSelect() {
		return pan_select;
	}
	
	
	/**
	 * @return the pan_where
	 */
	public Where getWhere() {
		return pan_where;
	}
	
	
	/**
	 * @return the pan_requete
	 */
	public Requete getRequete() {
		return pan_requete;
	}
	
	
	/**
	 * @return the pan_from
	 */
	public From getFrom() {
		return pan_from;
	}
	
	
	/**
	 * @return Le plug-in est lancé avec aladin ? oui ou non
	 */
	public boolean avecAladin() {
		return this.avec_aladin;
	}


	/**
	 * @return the aladin
	 */
	public Aladin getAladin() {
		return aladin;
	}

}
















