package fr.obs.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import fr.obs.listener.AuditeurBoutonOkConfServeur;
import fr.obs.util.Configuration;
import fr.obs.util.Langage;


/**
 * Classe qui modélise le panneau de configuration pour l'url
 * du serveur et du service TAP
 * @author Mallory Marcot
 *
 */
public class PanneauConfServeur extends JPanel {
	
	private JTextField champs_url_tap;
	private PluginLayout plug_lay;
	

	/**
	 * Constructeur d'un panneau de configuration pour l'url
	 * du serveur tap et de la BDD
	 * @param plug_lay 
	 */
	public PanneauConfServeur(PluginLayout plug_lay) {
		this.plug_lay = plug_lay;
		
		setLayout(new BorderLayout());
		initPanChamps();
		initPanBoutons();
	}
	
	
	/**
	 * @return une référence au PluginLayout
	 */
	public PluginLayout getPlug_lay() {
		return plug_lay;
	}
	
	
	/**
	 * @return le contenu du champs tap url
	 */
	public JTextField getChamps_url_tap() {
		return champs_url_tap;
	}

	
	/**
	 * Permet d'initialiser les boutons
	 */
	private void initPanBoutons() {
		JPanel pan_but = new JPanel();
		pan_but.setLayout(new GridLayout(0,3,10,0));
		pan_but.setBorder(new EmptyBorder(0, 10, 10, 10));
		
		// bouton cancel :
		JButton cancel = new JButton(Langage.getCancel());
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((JFrame)getParent().getParent().getParent()).dispose();
			}
		});
		
		// bouton ok :
		JButton ok = new JButton(Langage.getOk());
		ok.addActionListener(new AuditeurBoutonOkConfServeur());
		
		pan_but.add(new JLabel(" "));
		pan_but.add(cancel);
		pan_but.add(ok);
		
		add(pan_but, BorderLayout.SOUTH);
	}
	
	
	
	/**
	 * Permet d'initialiser le panneau contenant les champs texte
	 * à remplir
	 */
	private void initPanChamps() {
		JPanel pan_champs = new JPanel();
		pan_champs.setLayout(new BoxLayout(pan_champs, BoxLayout.Y_AXIS));
		pan_champs.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// champs TAP service URL :
		JLabel lab_tap = new JLabel("TAP service URL", JLabel.TRAILING);
		pan_champs.add(lab_tap);
		champs_url_tap = new JTextField(Configuration.TAILLE_JTEXTFIELD_CONF_SERV);
		lab_tap.setLabelFor(champs_url_tap);
		champs_url_tap.setText(Configuration.URL_SERVICE_TAP);
		pan_champs.add(champs_url_tap);
		pan_champs.add(new JLabel(" "));
		
		add(pan_champs, BorderLayout.CENTER);
	}

}








