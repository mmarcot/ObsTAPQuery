package listeners;

import interface_plugin.PluginLayout;

import java.awt.event.*;

import javax.swing.*;

import metier.GestionnaireExemples;


/**
 * Classe qui implémente les actions à réaliser lors d'un clic souris sur le bouton OK
 * de la fenetre d'exemple
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonOkExemple implements ActionListener{
	
	private PluginLayout plug_lay;
	private JList<String> jlist_ex;

	
	/**
	 * Constructeur de l'auditeur
	 * @param plug_lay Référence au PluginLayout
	 * @param jlist JList contenant la liste des exemples
	 */
	public AuditeurBoutonOkExemple(PluginLayout plug_lay, JList<String> jlist) {
		this.plug_lay = plug_lay;
		this.jlist_ex = jlist;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		
		// on recupère l'index de la ligne selectionnée :
		int index_sel = jlist_ex.getSelectedIndex();
		
		// si une ligne est effectivement selectionnée alors on affiche la requete
		// correspondante dans la zone de requete resultante :
		if(index_sel != -1)
			plug_lay.getRequete().setTexteRequete(GestionnaireExemples.getTab_req()[index_sel]);
		
		// on ferme la fenetre :
		((JFrame)but_src.getParent().getParent().getParent().getParent().getParent()).dispose();
	}

}















