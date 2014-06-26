package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


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
		but_src.getParent().removeAll();
	}

}
