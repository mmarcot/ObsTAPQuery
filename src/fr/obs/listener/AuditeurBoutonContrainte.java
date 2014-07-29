package fr.obs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import fr.obs.view.LigneDeContrainte;
import fr.obs.view.Where;


/**
 * Classe auditrice qui écoute le bouton ajouter contrainte et exécute
 * les actions necessaires
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonContrainte implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bout_src = (JButton)e.getSource();
		Where pan_where = (Where)bout_src.getParent().getParent();
		
		// on cherche si il faut mettre une liaison entre les conditions ou non :
		boolean liaison = false;
		if( pan_where.getGestionnaire().getComponentCount() > 0 )
			liaison = true;
			
		pan_where.getGestionnaire().add(new LigneDeContrainte(liaison));
	}
	

}
