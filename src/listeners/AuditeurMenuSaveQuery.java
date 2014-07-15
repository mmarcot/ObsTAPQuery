package listeners;

import interface_plugin.PluginLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import util.BoiteOutils;
import util.Langage;


/**
 * Classe qui définit les action à réaliser lors d'un clic sur le JMenuItem
 * save query
 * @author Mallory Marcot
 *
 */
public class AuditeurMenuSaveQuery implements ActionListener {
	
	private PluginLayout plug_lay;

	/**
	 * Constructeur de l'auditeur 
	 * @param plug_lay Référence au plug-in
	 */
	public AuditeurMenuSaveQuery(PluginLayout plug_lay) {
		this.plug_lay = plug_lay;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// on récupère le texte de la requete :
		String content = plug_lay.getRequete().getTexte();
		
		// on demande le fichier :
		String chemin = JOptionPane.showInputDialog(plug_lay, Langage.getPath());
		if(chemin == null)
			return;
		File fichier = new File(chemin); 
		
		// on écrit dans une fichier :
		BoiteOutils.ecrireDansLeFichier(fichier, content);		
	}
	
}











