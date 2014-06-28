package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * Classe auditrice qui réalise les actions suite à un clic sur 
 * le bouton "générer la requete resultante"
 * @author Mallory Marcot
 *
 */
public class AuditeurBoutonGenererReq implements ActionListener{

	@Override
  public void actionPerformed(ActionEvent e) {
		JButton but_src = (JButton) e.getSource();
		
  }

}
