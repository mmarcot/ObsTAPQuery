package fr.obs.view;

import java.awt.*;

import javax.swing.*;

import fr.obs.util.Langage;


/**
 * Classe permettant de représenter un panneau d'aide pour aider
 * l'utilisateur à utiliser le plug-in
 * @author Mallory Marcot
 *
 */
public class PanneauAide extends JPanel {
	
	/**
	 * Constructeur d'un panneau (JPanel) d'aide
	 */
	public PanneauAide() {
		this.setLayout(new GridLayout(0,1));
		
		JTextArea text_area = new JTextArea(Langage.getAide());
		text_area.setEditable(false);
		
		add(text_area);
	}
}
