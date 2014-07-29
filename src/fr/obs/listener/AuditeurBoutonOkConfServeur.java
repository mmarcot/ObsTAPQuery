package fr.obs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.*;

import fr.obs.model.GestionnaireDeTables;
import fr.obs.util.Configuration;
import fr.obs.util.Langage;
import fr.obs.view.PanneauConfServeur;
import fr.obs.view.PluginLayout;


/**
 * Classe qui détermine les actions à réaliser lors d'un clic
 * sur le bouton OK de la configuration du serveur
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonOkConfServeur implements ActionListener {

	private PluginLayout plug_lay;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		PanneauConfServeur pan_conf = (PanneauConfServeur) but_src.getParent().getParent();
		plug_lay = pan_conf.getPlug_lay();
		
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
		
		plug_lay.mettreAJour(true);
	}

}
