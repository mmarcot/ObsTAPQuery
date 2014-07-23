package listeners;

import interface_plugin.PluginLayout;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import util.Configuration;
import util.Langage;


/**
 * Classe qui réagit aux clics de l'utilisateur sur le bouton exemple
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonExemple implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		PluginLayout plug_lay = (PluginLayout) but_src.getParent().getParent().getParent().getParent();
		
		String[] tab_exemples = {
				"Select only cube datasets",
				"Select datasets with central position in a north cap of 10 degrees radius (s_dec > +80)",
				"Select datasets with observation date between modified julian day 55000 and 55100",
				"Select datasets with minimal wavelength between 2E-4 and 8E-4 and maximal wavelength either the same or unknown",
				"Select datasets with observation date between modified julian day 55000 and 55100 , minimal wavelength between 2E-4 and 8E-4 and maximal wavelength either the same or unknown and facility =  ESO"
		};
		
		// création de la fenetre et du panel :
		final JFrame fen_ex = new JFrame(Langage.getExemple());
		JPanel wrapper = new JPanel(new BorderLayout());
		
		
		// création de la JList :
		JPanel pan_list = new JPanel();
		JList<String> jlist = new JList<String>(tab_exemples); 
		jlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		jlist.setVisibleRowCount(-1);
		pan_list.add(jlist, BorderLayout.CENTER);
		
		// ajout d'un scroller :
		JScrollPane listScroller = new JScrollPane(pan_list);
		listScroller.getVerticalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_VER);
		listScroller.getHorizontalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_HOR);
		listScroller.setPreferredSize(new Dimension(500, pan_list.getPreferredSize().height+20));
		wrapper.add(listScroller, BorderLayout.CENTER);
		
		// panneau de boutons :
		JPanel pan_but = new JPanel();
		JButton but_ok = new JButton(Langage.getOk());
		but_ok.addActionListener(new AuditeurBoutonOkExemple(plug_lay));
		JButton but_annuler = new JButton(Langage.getCancel());
		but_annuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fen_ex.dispose();
			}
		});
		pan_but.add(but_ok);
		pan_but.add(but_annuler);
		wrapper.add(pan_but, BorderLayout.SOUTH);
		
		// finalisation JFrame :
		fen_ex.setContentPane(wrapper);
		fen_ex.pack();
		fen_ex.setLocationRelativeTo(plug_lay);
		fen_ex.setVisible(true);
	}

}











