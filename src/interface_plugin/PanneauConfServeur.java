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
	private PluginLayout plug_lay;
	

	/**
	 * Constructeur d'un panneau de configuration pour l'url
	 * du serveur tap et de la BDD
	 * @param plug_lay 
	 */
	public PanneauConfServeur(PluginLayout plug_lay) {
		this.plug_lay = plug_lay;
		this.ls_textfiels = new ArrayList<JTextField>();
		
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

		
		// champs TAP service URL :
		JLabel lab_tap = new JLabel("TAP service URL", JLabel.TRAILING);
		pan_champs.add(lab_tap);
		JTextField tf_tap = new JTextField(Configuration.TAILLE_JTEXTFIELD_CONF_SERV);
		ls_textfiels.add(tf_tap);
		lab_tap.setLabelFor(tf_tap);
		tf_tap.setText(Configuration.URL_SERVICE_TAP);
		pan_champs.add(tf_tap);
		pan_champs.add(new JLabel(" "));
		
		// champs URL BDD :
		JLabel lab_bdd = new JLabel("Database URL", JLabel.TRAILING);
		pan_champs.add(lab_bdd);
		JTextField tf_bdd = new JTextField(Configuration.TAILLE_JTEXTFIELD_CONF_SERV);
		ls_textfiels.add(tf_bdd);
		lab_bdd.setLabelFor(tf_bdd);
		tf_bdd.setText(Configuration.URL_BDD);
		pan_champs.add(tf_bdd);
		pan_champs.add(new JLabel(" "));
		
		// champs USER :
		JLabel lab_user = new JLabel("User", JLabel.TRAILING);
		pan_champs.add(lab_user);
		JTextField tf_user = new JTextField(Configuration.TAILLE_JTEXTFIELD_CONF_SERV);
		ls_textfiels.add(tf_user);
		lab_user.setLabelFor(tf_user);
		tf_user.setText(Configuration.USER_BDD);
		pan_champs.add(tf_user);
		pan_champs.add(new JLabel(" "));
		
		// champs MDP :
		JLabel lab_mdp = new JLabel("Password", JLabel.TRAILING);
		pan_champs.add(lab_mdp);
		JPasswordField tf_mdp = new JPasswordField(Configuration.TAILLE_JTEXTFIELD_CONF_SERV);
		ls_textfiels.add(tf_mdp);
		lab_mdp.setLabelFor(tf_mdp);
		tf_mdp.setText(Configuration.MOT_DE_PASSE_BDD);
		pan_champs.add(tf_mdp);
		pan_champs.add(new JLabel(" "));

		
		add(pan_champs, BorderLayout.CENTER);
	}

}








