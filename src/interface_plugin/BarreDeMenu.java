package interface_plugin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import listeners.AuditeurMenuLoadQuery;
import listeners.AuditeurMenuSaveQuery;

import util.BoiteOutils;
import util.Configuration;
import util.Langage;


/**
 * Classe qui représente notre barre de menu haute (JMenuBar)
 * @author Mallory Marcot
 *
 */
public class BarreDeMenu extends JMenuBar {
	
	/** référence au PluginLayout */
	private PluginLayout plug_lay;
	
	
	/**
	 * Constructeur de notre barre de menu haute
	 * @param pluginLayout 
	 */
	public BarreDeMenu(PluginLayout pluginLayout) {
		this.plug_lay = pluginLayout;
		
		initMenuFichier();
		initMenuOption();
		initMenuHelp();
	}
	
	
	/**
	 * Permet d'initialiser le JMenu fichier
	 */
	private void initMenuFichier() {
		JMenu fichier = new JMenu(Langage.getMenuFichier());
		
		// JMenuItem save query :
		JMenuItem enr_req = new JMenuItem(Langage.getMenuItemEnrReq());
		enr_req.addActionListener(new AuditeurMenuSaveQuery(plug_lay));
		
		// JMenuItem load query :
		JMenuItem load_req = new JMenuItem(Langage.getMenuItemLoadReq());
		load_req.addActionListener(new AuditeurMenuLoadQuery(plug_lay));
		
		// JMenuItem quitter :
		JMenuItem quitter = new JMenuItem(Langage.getQuitter());
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((JFrame) getParent().getParent().getParent().getParent()).dispose();
			}
		});
		
		
		fichier.add(enr_req);
		fichier.add(load_req);
		fichier.add(quitter);
		add(fichier);
	}
	
	
	
	/**
	 * Permet d'initialiser le JMenu option
	 */
	private void initMenuOption() {
		JMenu option = new JMenu(Langage.getMenuOption());
		
		// fenetre conf url serveur :
		JMenuItem url_bdd = new JMenuItem(Langage.getMenuItemUrlBDD());
		url_bdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame fen = new JFrame(Langage.getMenuItemUrlBDD());
				PanneauConfServeur pan_conf = new PanneauConfServeur(plug_lay);
				fen.setContentPane(pan_conf);
				fen.pack();
				fen.setVisible(true);
				fen.setLocationRelativeTo(plug_lay);
			}
		});
		option.add(url_bdd);
		
		
		// clause LIMIT :
		initClauseLimit(option);
		
		
		
		
//		limit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String limit_str = JOptionPane.showInputDialog(plug_lay, Langage.getLimitInputMessage());
//				if(limit_str != null) {
//					try {
//						Configuration.LIMIT = Integer.parseInt(limit_str.trim());
//					}
//					catch(NumberFormatException ex) {
//						BoiteOutils.erreur(Langage.getErreurEntrezNombreEntier());
//						ex.printStackTrace();
//					}
//				}
//			}
//		});
		
		
		add(option);
	}
	
	
	
	/**
	 * Permet d'initialiser le JMenu d'aide
	 */
	private void initMenuHelp() {
		JMenu help = new JMenu(Langage.getMenuHelp());
		
		// fenetre de documentation :
		JMenuItem documentation = new JMenuItem(Langage.getMenuItemDocu());
		documentation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame fen_aide = new JFrame(Langage.getReq_help());
				PanneauAide pan_aide = new PanneauAide();
				pan_aide.setPreferredSize(new Dimension(200,200));
				fen_aide.setContentPane(pan_aide);
				fen_aide.pack();
				fen_aide.setVisible(true);
				fen_aide.setLocationRelativeTo(null);
			}
		});
		
		JMenuItem about = new JMenuItem(Langage.getMenuItemAbout());
		
		help.add(documentation);
		help.add(about);
		add(help);
	}
	
	
	
	/**
	 * Procédure d'initialisation du JMenu limit
	 * @param option Référence au JMenu parent (pour add)
	 */
	private void initClauseLimit(JMenu option) {
		JMenu limit = new JMenu(Langage.getLimit());
		
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem limit_1000 = new JRadioButtonMenuItem("1 000");
		JRadioButtonMenuItem limit_5000 = new JRadioButtonMenuItem("5 000");
		JRadioButtonMenuItem limit_10000 = new JRadioButtonMenuItem("10 000");
		JRadioButtonMenuItem limit_50000 = new JRadioButtonMenuItem("50 000");
		JRadioButtonMenuItem limit_100000 = new JRadioButtonMenuItem("100 000");
		JRadioButtonMenuItem limit_500000 = new JRadioButtonMenuItem("500 000");
		JRadioButtonMenuItem limit_1000000 = new JRadioButtonMenuItem("1 000 000");
		JRadioButtonMenuItem no_limit = new JRadioButtonMenuItem(Langage.getNoLimit());
		no_limit.setSelected(true);
		
		group.add(limit_1000);
		group.add(limit_5000);
		group.add(limit_10000);
		group.add(limit_50000);
		group.add(limit_100000);
		group.add(limit_500000);
		group.add(limit_1000000);
		group.add(no_limit);
		
		limit.add(limit_1000);
		limit.add(limit_5000);
		limit.add(limit_10000);
		limit.add(limit_50000);
		limit.add(limit_100000);
		limit.add(limit_500000);
		limit.add(limit_1000000);
		limit.add(no_limit);
		
		option.add(limit);
	}
	
	
}















