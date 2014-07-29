package fr.obs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.obs.util.Configuration;


/**
 * Classe qui modélise les actions à réaliser lors d'un clic sur 
 * les radio button dans le sous menu limit, permettant d'inserer une clause 
 * limit dans la requete résultante
 * @author Mallory Marcot
 *
 */
public class AuditeurRadioButtonLimit implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Configuration.LIMIT = Integer.parseInt(e.getActionCommand().replace(" ", ""));
		}
		catch(NumberFormatException nfe) { // no limit :
			Configuration.LIMIT = -1;
		}
	}

}
