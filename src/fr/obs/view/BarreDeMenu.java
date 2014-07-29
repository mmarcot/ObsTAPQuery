package fr.obs.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import fr.obs.listener.AuditeurMenuLoadQuery;
import fr.obs.listener.AuditeurMenuSaveQuery;
import fr.obs.listener.AuditeurRadioButtonLimit;
import fr.obs.util.BoiteOutils;
import fr.obs.util.Configuration;
import fr.obs.util.Langage;


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
		JMenu menu_limit = new JMenu(Langage.getLimit());
		
		// création d'un groupe de radio button :
		ButtonGroup group = new ButtonGroup();
		
		// instanciation des MenuItem :
		JRadioButtonMenuItem limit_100 = new JRadioButtonMenuItem("100");
		JRadioButtonMenuItem limit_500 = new JRadioButtonMenuItem("500");
		JRadioButtonMenuItem limit_1000 = new JRadioButtonMenuItem("1 000");
		JRadioButtonMenuItem limit_5000 = new JRadioButtonMenuItem("5 000");
		JRadioButtonMenuItem limit_10000 = new JRadioButtonMenuItem("10 000");
		JRadioButtonMenuItem limit_50000 = new JRadioButtonMenuItem("50 000");
		JRadioButtonMenuItem limit_100000 = new JRadioButtonMenuItem("100 000");
		JRadioButtonMenuItem no_limit = new JRadioButtonMenuItem(Langage.getNoLimit());
		JMenuItem saisie_limit = new JMenuItem(Langage.getMenuItemEnterLimitValue());
		
		// ajout des listeners :
		limit_100.addActionListener(new AuditeurRadioButtonLimit());
		limit_500.addActionListener(new AuditeurRadioButtonLimit());
		limit_1000.addActionListener(new AuditeurRadioButtonLimit());
		limit_5000.addActionListener(new AuditeurRadioButtonLimit());
		limit_10000.addActionListener(new AuditeurRadioButtonLimit());
		limit_50000.addActionListener(new AuditeurRadioButtonLimit());
		limit_100000.addActionListener(new AuditeurRadioButtonLimit());
		no_limit.addActionListener(new AuditeurRadioButtonLimit());
		saisie_limit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String limit_str = JOptionPane.showInputDialog(plug_lay, Langage.getLimitInputMessage());
				if(limit_str != null) {
					try {
						Configuration.LIMIT = Integer.parseInt(limit_str.trim());
					}
					catch(NumberFormatException ex) {
						BoiteOutils.erreur(plug_lay, Langage.getErreurEntrezNombreEntier());
						ex.printStackTrace();
					}
				}
			}
		});
		
		// selection par défaut :
		limit_1000.setSelected(true);
		
		// on les ajoutent au groupe :
		group.add(limit_100);
		group.add(limit_500);
		group.add(limit_1000);
		group.add(limit_5000);
		group.add(limit_10000);
		group.add(limit_50000);
		group.add(limit_100000);
		group.add(no_limit);
		
		// on les ajoutent au JMenu :
		menu_limit.add(limit_100);
		menu_limit.add(limit_500);
		menu_limit.add(limit_1000);
		menu_limit.add(limit_5000);
		menu_limit.add(limit_10000);
		menu_limit.add(limit_50000);
		menu_limit.add(limit_100000);
		menu_limit.add(no_limit);
		menu_limit.addSeparator();
		menu_limit.add(saisie_limit);
		
		// on l'affiche dans le JMenu Option :
		option.add(menu_limit);
	}
	
	
}















