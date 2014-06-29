package listeners;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import util.Langage;


/**
 * Classe qui détermine les actions à réaliser lors du clic sur le 
 * bouton 'aide'
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonHelp implements ActionListener {

	@Override
  public void actionPerformed(ActionEvent e) {
		JFrame fen_aide = new JFrame(Langage.getReq_help());
		
		JPanel pan = new JPanel();
		pan.setPreferredSize(new Dimension(200,200));
		
		fen_aide.setContentPane(pan);
		fen_aide.pack();
		fen_aide.setVisible(true);
  }

}
