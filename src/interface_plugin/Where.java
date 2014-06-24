package interface_plugin;

import java.awt.*;

import javax.swing.*;

import util.Configuration;


/**
 * Classe JPanel qui représente le where (vue)
 * @author Mallory Marcot
 *
 */
public class Where extends JPanel {
	
	/**
	 * Constructeur du panneau where
	 */
	public Where() {
		this.setLayout(new BorderLayout());
		
		// JLabel titre :
		JLabel lab_where = new JLabel("Where", JLabel.CENTER);
		Font pol_where = new Font(Configuration.POLICE, Font.BOLD, 20);
		lab_where.setFont(pol_where);
		this.add(lab_where, BorderLayout.NORTH);
		
		// Gestionnaire de contraintes :
		GestionnaireDeContraintes gest = new GestionnaireDeContraintes();
		this.add(gest, BorderLayout.CENTER);
	}

}
