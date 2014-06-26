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
	
	private GestionnaireDeContraintes gest;
	
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
		gest = new GestionnaireDeContraintes();
		JScrollPane scroller_gest_cont = new JScrollPane(gest);
		scroller_gest_cont.getVerticalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_VER);
		scroller_gest_cont.getHorizontalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_HOR);
		this.add(scroller_gest_cont, BorderLayout.CENTER);
	}
	
	
	/**
	 * Permet d'ajouter une ligne au gestionnaire de contraintes
	 */
	public void ajouterLigne() {
		this.gest.ajouterLigne();
	}

}
