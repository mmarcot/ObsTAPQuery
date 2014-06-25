package interface_plugin;

import java.awt.*;

import javax.swing.*;

import util.Configuration;
import util.Langage;


/**
 * Classe JPanel qui représente le where (vue)
 * @author Mallory Marcot
 *
 */
public class Where extends JPanel {
	
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
		wrapper.add(but_add_contrainte);
		
		// Ajout du wrapper au panneau Where
		this.add(wrapper, BorderLayout.NORTH);
		
		// Ajout du gestionnaire de contraintes :
		GestionnaireDeContraintes gest = new GestionnaireDeContraintes();
		JScrollPane scroller_gest_cont = new JScrollPane(gest);
		scroller_gest_cont.getVerticalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_VER);
		scroller_gest_cont.getHorizontalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_HOR);
		this.add(scroller_gest_cont, BorderLayout.CENTER);
		
//		// Gestion de la ScrollBar :
//				Select pan_select = new Select();
//				JScrollPane scroller = new JScrollPane(pan_select);
//				scroller.getVerticalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_VER);
//				scroller.getHorizontalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_HOR);
//				this.add(scroller,BorderLayout.CENTER);
	}

}
