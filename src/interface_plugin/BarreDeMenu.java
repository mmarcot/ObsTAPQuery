package interface_plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import util.Langage;


/**
 * Classe qui représente notre barre de menu haute (JMenuBar)
 * @author Mallory Marcot
 *
 */
public class BarreDeMenu extends JMenuBar {
	
	
	/**
	 * Constructeur de notre barre de menu haute
	 */
	public BarreDeMenu() {
		initMenuFichier();
		initMenuOption();
		initMenuHelp();
	}
	
	
	/**
	 * Permet d'initialiser le JMenu fichier
	 */
	private void initMenuFichier() {
		JMenu fichier = new JMenu(Langage.getMenuFichier());
		
		JMenuItem enr_req = new JMenuItem(Langage.getMenuItemEnrReq());
		
		fichier.add(enr_req);
		add(fichier);
	}
	
	
	/**
	 * Permet d'initialiser le JMenu option
	 */
	private void initMenuOption() {
		JMenu option = new JMenu(Langage.getMenuOption());
		
		JMenuItem url_bdd = new JMenuItem(Langage.getMenuItemUrlBDD());
		url_bdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame fen = new JFrame(Langage.getTitreConfServeur());
				
				PanneauConfServeur pan_conf = new PanneauConfServeur();
				
				fen.setContentPane(pan_conf);
				fen.pack();
				fen.setVisible(true);
				fen.setLocationRelativeTo(null);
			}
		});
		
		option.add(url_bdd);
		add(option);
	}
	
	
	
	/**
	 * Permet d'initialiser le JMenu d'aide
	 */
	private void initMenuHelp() {
		JMenu help = new JMenu(Langage.getMenuHelp());
		
		JMenuItem documentation = new JMenuItem(Langage.getMenuItemDocu());
		JMenuItem about = new JMenuItem(Langage.getMenuItemAbout());
		
		help.add(documentation);
		help.add(about);
		add(help);
	}
	
	
}















