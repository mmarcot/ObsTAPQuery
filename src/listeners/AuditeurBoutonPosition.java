package listeners;

import interface_plugin.GestionnaireDeContraintes;
import interface_plugin.LigneDePosition;
import interface_plugin.PluginLayout;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import util.BoiteOutils;
import util.Langage;


/**
 * Classe qui implémente les actions à réaliser lors d'un clic sur le bouton 
 * position dans le where
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonPosition implements ActionListener {
	
	private JComboBox combo_unite;

	@Override
	public void actionPerformed(ActionEvent e) {
		// récupère les références :
		JButton but_src = (JButton) e.getSource();
		PluginLayout plug_lay = (PluginLayout) but_src.getParent().getParent().getParent().getParent().getParent();
		GestionnaireDeContraintes gestionnaire = plug_lay.getWhere().getGestionnaire();
		
		JPanel wrapper = new JPanel(new BorderLayout(5, 5));

		// JPanel de label :
		JPanel pan_lab = new JPanel(new GridLayout(0, 1, 2, 2));
		pan_lab.add(new JLabel(Langage.getRA(), SwingConstants.RIGHT));
		pan_lab.add(new JLabel(Langage.getDEC(), SwingConstants.RIGHT));
		pan_lab.add(new JLabel(Langage.getRayon(), SwingConstants.RIGHT));
		wrapper.add(pan_lab, BorderLayout.WEST);

		// JPanel de textField :
		JPanel pan_text = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField txt_ra = new JTextField();
		pan_text.add(txt_ra);
		JTextField txt_dec = new JTextField();
		pan_text.add(txt_dec);
		JTextField txt_rayon = new JTextField();
		pan_text.add(txt_rayon);
		wrapper.add(pan_text, BorderLayout.CENTER);
		
		// JPanel des unités :
		JPanel pan_unites = new JPanel(new GridLayout(0, 1, 2, 2));
		pan_unites.add(new JLabel(" "));
		pan_unites.add(new JLabel(" "));
		String[] tab_unites = {Langage.getDeg(), Langage.getArcmin(), Langage.getArcsec()};
		combo_unite = new JComboBox(tab_unites);
		combo_unite.setSelectedItem("deg");
		pan_unites.add(combo_unite);
		wrapper.add(pan_unites, BorderLayout.EAST);
		
		// pour ajouter de l'espacement :
		wrapper.setBorder(new EmptyBorder(0, 0, 10, 0));

		// Demande à l'user :
		int selection = JOptionPane.showConfirmDialog(plug_lay, wrapper, Langage.getPosition(), JOptionPane.OK_CANCEL_OPTION);
		
		if(selection == JOptionPane.OK_OPTION) {
			// convertion des input en Double :
			double ra = 0;
			double dec = 0;
			double rayon = 0;
			boolean afficher_ligne = true;
			try {
				ra = Double.parseDouble(txt_ra.getText());
				dec = Double.parseDouble(txt_dec.getText());
				rayon = Double.parseDouble(txt_rayon.getText());
			}
			catch(NumberFormatException nfe) {
				afficher_ligne = false;
				BoiteOutils.erreur(plug_lay, Langage.getEntrezDouble());
			}
			
			// on affiche la ligne si OK :
			if(afficher_ligne) {
				// on determine si on a besoin d'une liaison :
				boolean liaison = false;
				if(gestionnaire.getComponentCount()>0)
					liaison = true;
				
				// on ajoute une ligne de position dans les contraintes :
				gestionnaire.add(new LigneDePosition(liaison, ra, dec, rayon, (String)combo_unite.getSelectedItem()));
			}
		}
		
		
	}

}












