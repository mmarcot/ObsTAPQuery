package listeners;

import interface_plugin.PluginLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import metier.GenerateurRequete;


/**
 * Classe auditrice qui réalise les actions suite à un clic sur 
 * le bouton "générer la requete resultante"
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonGenererReq implements ActionListener{

	@Override
  public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		PluginLayout plug_lay = (PluginLayout)but_src.getParent().getParent().getParent().getParent();
		
		GenerateurRequete gen_req = new GenerateurRequete(plug_lay.getSelect(), plug_lay.getFrom(), plug_lay.getWhere(), plug_lay.getRequete());
		gen_req.generer();
  }

}
