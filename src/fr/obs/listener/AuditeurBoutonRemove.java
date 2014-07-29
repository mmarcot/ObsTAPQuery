package fr.obs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import fr.obs.view.AbstractLigne;
import fr.obs.view.GestionnaireDeContraintes;
import fr.obs.view.LigneDeContrainte;


/**
 * Classe auditrice qui implémente l'action à réaliser lors d'un clic
 * sur le bouton 'Remove' d'une ligne de contrainte
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonRemove implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		AbstractLigne ligne = (AbstractLigne) but_src.getParent();
		GestionnaireDeContraintes gest = (GestionnaireDeContraintes) but_src.getParent().getParent();
		
		gest.remove(ligne);
	}

}
