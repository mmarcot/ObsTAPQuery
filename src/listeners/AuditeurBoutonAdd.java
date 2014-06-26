package listeners;

import interface_plugin.Where;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * Classe auditrice qui écoute le bouton ajouter contrainte et exécute
 * les actions necessaires
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonAdd implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bout_src = (JButton)e.getSource();
		Where pan_where = (Where)bout_src.getParent().getParent();
		pan_where.ajouterLigne();
	}
	

}
