package interface_plugin;

import java.awt.*;
import javax.swing.*;

import cds.aladin.Aladin;

import util.Configuration;


/**
 * JPanel qui contient l'ensemble de l'interface du plug-in Aladin
 * @author Mallory Marcot
 *
 */
public class PluginLayout extends JPanel {
	
	private Select pan_select;
	private Where pan_where;
	private Requete pan_requete;
	private boolean avec_aladin;
	private Aladin aladin;

	/**
	 * Constructeur de l'interface principal avec le lanceur normal
	 */
	public PluginLayout() {
		this.avec_aladin = false;
		this.setPreferredSize(new Dimension(Configuration.LARGEUR_PLUGIN_PX, Configuration.HAUTEUR_PLUGIN_PX));
		this.setLayout(new BorderLayout());
		
		// Gestion de la ScrollBar :
		pan_select = new Select();
		JScrollPane scroller = new JScrollPane(pan_select);
		scroller.getVerticalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_VER);
		scroller.getHorizontalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_HOR);
		this.add(scroller,BorderLayout.CENTER);
		
		PanneauDroite pan_droite = new PanneauDroite();
		pan_where = pan_droite.getWhere();
		pan_requete = pan_droite.getRequete();
		
		this.add(scroller, BorderLayout.LINE_START);
		this.add(pan_droite, BorderLayout.CENTER);
	}
	
	
	/**
	 * Constructeur de l'interface avec Aladin
	 * @param aladin
	 */
	public PluginLayout(Aladin aladin) {
		// affectation des attributs :
		this.avec_aladin = true;
		this.aladin = aladin;
		
		// mise en page :
		this.setPreferredSize(new Dimension(Configuration.LARGEUR_PLUGIN_PX, Configuration.HAUTEUR_PLUGIN_PX));
		this.setLayout(new BorderLayout());
		
		// Gestion de la ScrollBar :
		pan_select = new Select();
		JScrollPane scroller = new JScrollPane(pan_select);
		scroller.getVerticalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_VER);
		scroller.getHorizontalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_HOR);
		this.add(scroller,BorderLayout.CENTER);
		
		PanneauDroite pan_droite = new PanneauDroite();
		pan_where = pan_droite.getWhere();
		pan_requete = pan_droite.getRequete();
		
		this.add(scroller, BorderLayout.LINE_START);
		this.add(pan_droite, BorderLayout.CENTER);
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
















