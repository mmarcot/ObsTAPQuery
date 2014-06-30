package interface_plugin;

import java.awt.*;

import javax.swing.*;

import listeners.AuditeurBoutonClear;
import listeners.AuditeurBoutonGenererReq;
import listeners.AuditeurBoutonHelp;
import listeners.AuditeurBoutonPerform;

import util.Configuration;
import util.Langage;


/**
 * Classe JPanel qui modélise la vue sur la requete résultante
 * @author Mallory Marcot
 *
 */
public class Requete extends JPanel {
	
	private JTextArea text_area;
	
	
	/**
	 * Constructeur du panneau requete
	 */
	public Requete() {
		this.setLayout(new BorderLayout());
		
		initTextePan();
		
		// création de la zone de texte :
		text_area = new JTextArea();
		JScrollPane scroller = new JScrollPane(text_area);
		this.add(scroller, BorderLayout.CENTER);
		
		initBoutonsPan();
	}

	
	
	/**
	 * Méthode qui initialise le JPanel de boutons
	 */
	private void initBoutonsPan() {
		// création du panel conteneur :
		JPanel bout_wrap = new JPanel();
		bout_wrap.setLayout(new GridLayout(0, 1, 0, 10));
		
		// création des boutons + tooltip + auditeur :
		JButton but_generer = new JButton(Langage.getReq_generer());
		but_generer.setToolTipText(Langage.getReq_generer_tt());
		but_generer.addActionListener(new AuditeurBoutonGenererReq());
		
		JButton but_executer = new JButton(Langage.getReq_executer());
		but_executer.setToolTipText(Langage.getReq_executer_tt());
		but_executer.addActionListener(new AuditeurBoutonPerform());
		
		JButton but_clear = new JButton(Langage.getReq_clear());
		but_clear.setToolTipText(Langage.getReq_clear_tt());
		but_clear.addActionListener(new AuditeurBoutonClear());
		
		JButton but_help = new JButton(Langage.getReq_help());
		but_help.setToolTipText(Langage.getReq_help_tt());
		but_help.addActionListener(new AuditeurBoutonHelp());
		
		// ajout des boutons au panel de boutons :
		bout_wrap.add(but_generer);
		bout_wrap.add(but_executer);
		bout_wrap.add(but_clear);
		bout_wrap.add(but_help);
		
		// ajout du panel de bouton au panel requete :
		this.add(bout_wrap, BorderLayout.EAST);
	}



	/**
	 * Methode qui initialise le JPanel de texte préliminaire (titre + explication)
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
	
	
	
	/**
	 * Affiche la requete passée en paramêtre dans la zone de texte
	 * de la requete résultante
	 * @param txt Le texte à mettre
	 */
	public void setTexteRequete(String txt) {
		text_area.setText(txt);
	}
	
	
	/**
	 * Methode qui va aujouter du texte à la requete existante
	 * @param txt Le texte à ajouter
	 */
	public void addToTexteRequete(String txt) {
		String texte_actuel = text_area.getText();
		
		text_area.setText( texte_actuel.trim() + "\n" + txt );
	}

}












