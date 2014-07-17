package listeners;

import interface_plugin.GestionnaireDeContraintes;
import interface_plugin.LigneDePosition;
import interface_plugin.PluginLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import util.BoiteOutils;
import util.Langage;


/**
 * Classe qui implémente les actions à réaliser lors d'un clic sur le bouton 
 * position dans le where
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonPosition implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// récupère les références :
		JButton but_src = (JButton) e.getSource();
		PluginLayout plug_lay = (PluginLayout) but_src.getParent().getParent().getParent().getParent().getParent();
		GestionnaireDeContraintes gestionnaire = plug_lay.getWhere().getGestionnaire();
		
		JPanel wrapper = new JPanel(new BorderLayout(5, 5));

		// JPanel de label :
		JPanel pan_lab = new JPanel(new GridLayout(0, 1, 2, 2));
		pan_lab.add(new JLabel(Langage.getAbscisse(), SwingConstants.RIGHT));
		pan_lab.add(new JLabel(Langage.getOrdonnee(), SwingConstants.RIGHT));
		pan_lab.add(new JLabel(Langage.getRayon(), SwingConstants.RIGHT));
		wrapper.add(pan_lab, BorderLayout.WEST);

		// JPanel de textField :
		JPanel pan_text = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField txt_abs = new JTextField();
		pan_text.add(txt_abs);
		JTextField txt_ord = new JTextField();
		pan_text.add(txt_ord);
		JTextField txt_rayon = new JTextField();
		pan_text.add(txt_rayon);
		wrapper.add(pan_text, BorderLayout.CENTER);

		// Demande à l'user :
		JOptionPane.showMessageDialog(plug_lay, wrapper, Langage.getPosition(), JOptionPane.QUESTION_MESSAGE);
		
		// convertion des input en Double :
		double x = 0;
		double y = 0;
		double rayon = 0;
		try {
			x = Double.parseDouble(txt_abs.getText());
			y = Double.parseDouble(txt_ord.getText());
			rayon = Double.parseDouble(txt_rayon.getText());
		}
		catch(NumberFormatException nfe) {
			BoiteOutils.erreur(Langage.getEntrezDouble());
			nfe.printStackTrace();
		}
		
		// si tous les champs sont remplis :
		if(txt_abs.getText() != null && txt_ord.getText() != null && txt_rayon.getText() != null) {
			// on determine si on a besoin d'une liaison :
			boolean liaison = false;
			if(gestionnaire.getComponentCount()>0)
				liaison = true;
			
			// on ajoute une ligne de position dans les contraintes :
			gestionnaire.add(new LigneDePosition(liaison, x, y, rayon));
		}
		
		
		
	}

}












