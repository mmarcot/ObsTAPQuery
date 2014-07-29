package fr.obs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import fr.obs.util.BoiteOutils;
import fr.obs.view.PluginLayout;


/**
 * Classe qui implémente les actions à réaliser lors d'un clic sur le JMenuItem
 * load query
 * @author Mallory Marcot
 *
 */
public class AuditeurMenuLoadQuery implements ActionListener {

	private PluginLayout plug_lay;
	
	
	/**
	 * Constructeur de l'auditeur
	 * @param p_plug_lay Référence au PluginLayout
	 */
	public AuditeurMenuLoadQuery(PluginLayout p_plug_lay) {
		this.plug_lay = p_plug_lay;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String content = "";
		
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(plug_lay);
		if( returnValue == JFileChooser.APPROVE_OPTION ) {
			File selectedFile = fileChooser.getSelectedFile();
			content = BoiteOutils.lireLeFichier(selectedFile);
			plug_lay.getRequete().setTexteRequete(content);
		}
	}

}

















