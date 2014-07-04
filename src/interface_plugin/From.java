package interface_plugin;

import java.awt.*;

import javax.swing.*;

import util.Configuration;


/**
 * Classe qui modélise un panneau From (vue)
 * @author Mallory Marcot
 *
 */
public class From extends JPanel {

	/**
	 * Constructeur du panneau From (vue)
	 */
	public From() {
		setPreferredSize(new Dimension(190,100));
		setLayout(new BorderLayout());
		
		// JLabel "Select" :
		JLabel lab_from = new JLabel("     From");
		Font pol_select = new Font(Configuration.POLICE, Font.BOLD, 20);
		lab_from.setFont(pol_select);
		add(lab_from, BorderLayout.NORTH);
		
		// JComboBox liste de tables :
		
	}
}
