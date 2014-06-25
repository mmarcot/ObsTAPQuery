package interface_plugin;

import java.awt.*;

import javax.swing.*;

import util.Configuration;
import util.Langage;


/**
 * Classe JPanel qui modélise la vue sur la requete résultante
 * @author Mallory Marcot
 *
 */
public class Requete extends JPanel {
	
	/**
	 * Constructeur du panneau requete
	 */
	public Requete() {
		this.setLayout(new BorderLayout());
		
		initTextePan();
		
		// création de la zone de texte :
		JTextArea text_area = new JTextArea("SELECT *\nFROM obscore\nWHERE t_min IS NOT NULL;");
		this.add(text_area, BorderLayout.CENTER);
		
		initBoutonsPan();
	}

	
	
	/**
	 * Méthode qui initialise le JPanel de boutons
	 */
	private void initBoutonsPan() {
		// création du panel conteneur :
		JPanel bout_wrap = new JPanel();
		bout_wrap.setLayout(new GridLayout(0, 1, 0, 10));
		
		// création des boutons + tooltip :
		JButton but_generer = new JButton(Langage.getReq_generer());
		but_generer.setToolTipText(Langage.getReq_generer_tt());
		JButton but_executer = new JButton(Langage.getReq_executer());
		but_executer.setToolTipText(Langage.getReq_executer_tt());
		JButton but_help = new JButton(Langage.getReq_help());
		but_help.setToolTipText(Langage.getReq_help_tt());
		
		// ajout des boutons au panel de boutons :
		bout_wrap.add(but_generer);
		bout_wrap.add(but_executer);
		bout_wrap.add(but_help);
		
		// ajout du panel de bouton au panel requete :
		this.add(bout_wrap, BorderLayout.EAST);
	}



	/**
	 * Methode qui initialise le JPanel de texte préliminaire 
	 */
	private void initTextePan() {
		// création d'un wrapper qui contient les textes préliminaires :
		JPanel text_wrap = new JPanel();
		text_wrap.setLayout(new GridLayout(0,1));
		
		// JLabel titre :
		JLabel lab_titre = new JLabel(Langage.getReq_titre(), JLabel.CENTER);
		Font pol_titre = new Font(Configuration.POLICE, Font.BOLD, 20);
		lab_titre.setFont(pol_titre);
		text_wrap.add(lab_titre);
		
		// JLabel description :
		JLabel lab_desc = new JLabel(Langage.getReq_desc(), JLabel.CENTER);
		Font pol_desc = new Font(Configuration.POLICE, Font.PLAIN, 13);
		lab_desc.setFont(pol_desc);
		text_wrap.add(lab_desc);
		
		// ajout du wrapper de texte :
		this.add(text_wrap, BorderLayout.NORTH);
	}

}
