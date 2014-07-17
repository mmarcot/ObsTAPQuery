package interface_plugin;

import java.awt.*;

import javax.swing.*;

import listeners.AuditeurBoutonContrainte;
import listeners.AuditeurBoutonPosition;

import util.Configuration;
import util.Langage;


/**
 * Classe JPanel qui représente le where (vue)
 * @author Mallory Marcot
 *
 */
public class Where extends JPanel {
	
	private GestionnaireDeContraintes gestionnaire;
	
	/**
	 * Constructeur du panneau where
	 */
	public Where() {
		this.setLayout(new BorderLayout());
		
		// Contenueur titre + boutons :
		JPanel wrapper = new JPanel();
		wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
		
		// JLabel de titre : "Where" :
		JLabel lab_where = new JLabel("Where", JLabel.CENTER);
		Font pol_where = new Font(Configuration.POLICE, Font.BOLD, 20);
		lab_where.setFont(pol_where);
		lab_where.setAlignmentX(Component.CENTER_ALIGNMENT);
		wrapper.add(lab_where);
		
		// wrapper de boutons :
		JPanel wrap_but = new JPanel();
		wrap_but.setAlignmentX(Component.CENTER_ALIGNMENT);
		// bouton ajouter :
		JButton but_add_contrainte = new JButton(Langage.getWhere_but_constraint());
		but_add_contrainte.setToolTipText(Langage.getWhere_but_add_tt());
		but_add_contrainte.addActionListener(new AuditeurBoutonContrainte());
		wrap_but.add(but_add_contrainte);
		// bouton position :
		JButton but_position = new JButton(Langage.getPosition());
		but_position.setToolTipText(Langage.getPosition_tt());
		but_position.addActionListener(new AuditeurBoutonPosition());
		wrap_but.add(but_position);
		
		wrapper.add(wrap_but);
		
		
		// Ajout du wrapper au panneau Where
		add(wrapper, BorderLayout.NORTH);
		
		// Ajout du gestionnaire de contraintes :
		gestionnaire = new GestionnaireDeContraintes();
		JScrollPane scroller_gest_cont = new JScrollPane(gestionnaire);
		scroller_gest_cont.getVerticalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_VER);
		scroller_gest_cont.getHorizontalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_HOR);
		add(scroller_gest_cont, BorderLayout.CENTER);
	}
	
	
	
	/**
	 * Getter du gestionnaire de contraintes
	 * @return le gestionnaire de contraintes
	 */
	public GestionnaireDeContraintes getGestionnaire() {
		return gestionnaire;
	}
	
	
	/**
	 * Methode qui enlève toutes les lignes du gestionnaire de contraintes
	 */
	public void toutEnlever() {
		gestionnaire.removeAll();
		gestionnaire.mettreAJour();
	}
	
}
