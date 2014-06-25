package interface_plugin;

import java.awt.Color;

import javax.swing.*;

/**
 * Classe qui modélise une unique contrainte du gestionnaire 
 * @author Mallory Marcot
 *
 */
public class LigneDeContrainte extends JPanel {
	
	/**
	 * Constructeur d'une ligne de contrainte 
	 */
	public LigneDeContrainte() {
		this.setBackground(Color.white);
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	}

}
