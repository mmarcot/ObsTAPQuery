package interface_plugin;

import java.awt.*;

import javax.swing.*;

import util.Configuration;

public class PartieGauche extends JPanel {
	
	private Select pan_select;
	private From pan_from;


	/**
	 * Constructeur du panneau de gauche (vue)
	 */
	public PartieGauche() {
		this.setLayout(new BorderLayout());
		
		// JLabel "Select" :
		JLabel lab_select = new JLabel("     Select");
		Font pol_select = new Font(Configuration.POLICE, Font.BOLD, 20);
		lab_select.setFont(pol_select);
		add(lab_select, BorderLayout.NORTH);
		
		// Panneau select :
		pan_select = new Select();
		JScrollPane scroller = new JScrollPane(pan_select);
		scroller.getVerticalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_VER);
		scroller.getHorizontalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_HOR);
		add(scroller,BorderLayout.CENTER);
		
		// Panneau From :
		pan_from = new From();
		add(pan_from, BorderLayout.SOUTH);
	}
	
	
	/**
	 * @return the pan_from
	 */
	public From getFrom() {
		return pan_from;
	}


	/**
	 * @return the pan_select
	 */
	public Select getSelect() {
		return pan_select;
	}
}
