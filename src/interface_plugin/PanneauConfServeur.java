package interface_plugin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import listeners.AuditeurBoutonOkConfServeur;

import util.Configuration;
import util.Langage;


/**
 * Classe qui modélise le panneau de configuration pour l'url
 * du serveur et du service TAP
 * @author Mallory Marcot
 *
 */
public class PanneauConfServeur extends JPanel {
	
	private ArrayList<JTextField> ls_textfiels;
	

	/**
	 * Constructeur d'un panneau de configuration pour l'url
	 * du serveur tap et de la BDD
	 */
	public PanneauConfServeur() {
		this.ls_textfiels = new ArrayList<JTextField>();
		
		setLayout(new BorderLayout());
		initPanChamps();
		initPanBoutons();
	}
	
	
	/**
	 * @return le contenu des JTextFields
	 */
	public ArrayList<String> getLs_conf_serv() {
		ArrayList<String> ls_conf_serv = new ArrayList<String>();
		
		for(JTextField tf : ls_textfiels) {
			ls_conf_serv.add(tf.getText());
		}
		
		return ls_conf_serv;
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

		// on ajoute les champs et leur label un à un :
		for(int i = 0; i < Configuration.TAB_NOM_CHAMPS_CONF_SERVEUR.length; i++) {
			// label :
			JLabel lab = new JLabel(Configuration.TAB_NOM_CHAMPS_CONF_SERVEUR[i], JLabel.TRAILING);
			pan_champs.add(lab);
			
			// champs :
			JTextField textField;
			if(i == Configuration.INDEX_PASSWD_TAB_CHAMPS_CONF_SERVEUR) 
				textField = new JPasswordField(Configuration.TAILLE_JTEXTFIELD_CONF_SERV);
			else 
				textField = new JTextField(Configuration.TAILLE_JTEXTFIELD_CONF_SERV);
			
			ls_textfiels.add(textField);
			lab.setLabelFor(textField);
			textField.setText(Configuration.TAB_CONTENU_CHAMPS_CONF_SERVEUR[i]);
			pan_champs.add(textField);
			pan_champs.add(new JLabel(" ")); // espacement
		}
		
		add(pan_champs, BorderLayout.CENTER);
	}

}








