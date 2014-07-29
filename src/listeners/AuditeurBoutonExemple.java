package listeners;

import interface_plugin.PluginLayout;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import metier.GestionnaireExemples;
import util.Configuration;
import util.Langage;


/**
 * Classe qui réagit aux clics de l'utilisateur sur le bouton exemple
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonExemple implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		PluginLayout plug_lay = (PluginLayout) but_src.getParent().getParent().getParent().getParent();
		
		// création de la fenetre et du panel :
		final JFrame fen_ex = new JFrame(Langage.getExemple());
		JPanel wrapper = new JPanel(new BorderLayout());
		
		// création de la JList :
		JPanel pan_list = new JPanel();
		JList<String> jlist = new JList<String>(GestionnaireExemples.getTab_exemples()); 
		jlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		jlist.setVisibleRowCount(-1);
		pan_list.add(jlist, BorderLayout.CENTER);
		
		// ajout du titre de la JList :
		wrapper.add(new JLabel(Langage.getPreselectedFields()), BorderLayout.NORTH);
		
		// ajout d'un scroller :
		JScrollPane listScroller = new JScrollPane(pan_list);
		listScroller.getVerticalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_VER);
		listScroller.getHorizontalScrollBar().setUnitIncrement(Configuration.VITESSE_SCROLL_HOR);
		listScroller.setPreferredSize(new Dimension(500, pan_list.getPreferredSize().height+20));
		listScroller.setBorder(null);
		wrapper.add(listScroller, BorderLayout.CENTER);
		
		// panneau de boutons :
		JPanel pan_but = new JPanel();
		JButton but_ok = new JButton(Langage.getOk());
		but_ok.addActionListener(new AuditeurBoutonOkExemple(plug_lay, jlist));
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











