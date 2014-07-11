package listeners;

import interface_plugin.PanneauConfServeur;
import interface_plugin.PluginLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.*;

import metier.GestionnaireDeTables;

import util.Configuration;
import util.Langage;


/**
 * Classe qui détermine les actions à réaliser lors d'un clic
 * sur le bouton OK de la configuration du serveur
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonOkConfServeur implements ActionListener {

	private PanneauConfServeur pan_conf;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		pan_conf = (PanneauConfServeur) but_src.getParent().getParent();
		
		// recup l'ArrayList contenant les champs texte de conf :
		String str_url_tap = pan_conf.getChamps_url_tap().getText().trim();
		
		// affectation dans la configuration :
		Configuration.URL_SERVICE_TAP = str_url_tap;
		
		mettreAJour();
		
		((JFrame) but_src.getParent().getParent().getParent().getParent().getParent()).dispose();
	}
	
	
	/**
	 * Permet de tout nettoyer et de mettre à jour les colonnes 
	 */
	private void mettreAJour() {
		GestionnaireDeTables.changerTableSelectionnee(Configuration.TABLE_PAR_DEFAULT);
		
		PluginLayout plug_lay = pan_conf.getPlug_lay();
		
		// on nettoye tout :
		plug_lay.getSelect().uncheckAll();
		plug_lay.getWhere().toutEnlever();
		plug_lay.getRequete().setTexteRequete(null);
		
		// on met à jour :
		plug_lay.getSelect().mettreAJourColonnes();
		plug_lay.getFrom().mettreAJour();
		plug_lay.getWhere().getGestionnaire().mettreAJourColonnes();
	}

}
