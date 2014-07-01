package listeners;

import interface_plugin.Requete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cds.aladin.Aladin;


/**
 * Classe qui détermine les actions à réaliser lors du clic sur le 
 * bouton 'Générer'
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonPerform implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		Requete pan_req = (Requete)but_src.getParent().getParent();

		String requete = pan_req.get

		Aladin aladin = Aladin.launch();
		aladin.execCommand("get File(http://obs-stage-s4:8088/VizieR/tap/sync?REQUEST=doQuery&LANG=ADQL&QUERY=" + requete + ")");

	}

}
