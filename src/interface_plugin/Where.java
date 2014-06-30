package interface_plugin;

import java.awt.*;

import javax.swing.*;

import listeners.AuditeurBoutonAdd;

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
		
		// JButton ajouter :
		JButton but_add_contrainte = new JButton(Langage.getWhere_but_add());
		but_add_contrainte.setAlignmentX(Component.CENTER_ALIGNMENT);
		but_add_contrainte.setToolTipText(Langage.getWhere_but_add_tt());
		but_add_contrainte.addActionListener(new AuditeurBoutonAdd());
		wrapper.add(but_add_contrainte);
		
		// Ajout du wrapper au panneau Where
		this.add(wrapper, BorderLayout.NORTH);
		
		// Ajout du gestionnaire de contraintes :
		gestionnaire = new GestionnaireDeContraintes();
		JScrollPane scroller_gest_cont = new JScrollPane(gestionnaire);
		scroller_gest_cont.getVerticalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_VER);
		scroller_gest_cont.getHorizontalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_HOR);
		this.add(scroller_gest_cont, BorderLayout.CENTER);
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
