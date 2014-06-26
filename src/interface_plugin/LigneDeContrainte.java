package interface_plugin;

import javax.swing.*;

import util.Configuration;
import util.Langage;

import listeners.AuditeurOperateurs;
import metier.ColonnesObscore;

/**
 * Classe qui modélise une unique contrainte du gestionnaire 
 * @author Mallory Marcot
 *
 */
public class LigneDeContrainte extends JPanel {
	
	private boolean operateurDeLiaison;
	private boolean compo_between;
	
	/** zone de texte si pas de between */
	private JTextField text_valeur;
	/** zone de texte 1 si between */
	private JTextField text1_between;
	/** zone de texte 2 si between */
	private JTextField text2_between;
	/** label "AND" entre les 2 valeurs du between */
	private JLabel lab_and;
	
	
	/**
	 * Constructeur d'une ligne de contrainte 
	 * @param liaison Liaison avec la contrainte précédente (AND ou OR)
	 */
	public LigneDeContrainte(boolean liaison) {
		this.operateurDeLiaison = liaison;
		this.compo_between = false;
		
		// Affichage éventuel de la liaison :
		if(operateurDeLiaison) {
			JComboBox combo_liaison = new JComboBox(Configuration.TAB_LIAISONS);
			this.add(combo_liaison);
		}
		
		// JComboBox colonnes obscore :
		JComboBox combo_col_obs = new JComboBox(ColonnesObscore.getColonnesObscore().toArray());
		this.add(combo_col_obs);
		
		// JComboBox opérateurs :
		JComboBox combo_oper = new JComboBox(Configuration.TAB_OPERATEURS_WHERE);
		combo_oper.addActionListener(new AuditeurOperateurs());
		this.add(combo_oper);
			
		// JTextField valeur :
		text_valeur = new JTextField(12);
		this.add(text_valeur);
		
		//JButton remove constraint :
		JButton but_remove = new JButton(Langage.getWhere_but_remove());
		but_remove.setToolTipText(Langage.getWhere_but_remove_tt());
		this.add(but_remove);
		
	}
	
	
	/**
	 * Methode qui compose la ligne pour un between
	 */
	public void toBetweenComposition() {
		int nb_composants = this.getComponents().length;
		
		// suppr grand JTextField :
		this.remove(text_valeur);
		this.text_valeur = null;
		nb_composants--;
		
		// ajoute JTextField 1 :
		text1_between = new JTextField(5);
		this.add(text1_between, nb_composants-1);
		nb_composants++;
		
		// ajoute JLabel "and" :
		lab_and = new JLabel("AND");
		this.add(lab_and, nb_composants-1);
		nb_composants++;
		
		// ajoute JTextField 2 :
		text2_between = new JTextField(5);
		this.add(text2_between, nb_composants-1);
		nb_composants++;
		
		// MAJ :
		this.compo_between = true;
		this.revalidate();
	}
	
	
	/**
	 * Methode qui compose la ligne pour un opérateur normal
	 */
	public void toRegularComposition() {
		int nb_composants = this.getComponents().length;
		
		// on enlève les composant dont on n'a plus besoin
		this.remove(text1_between);
		this.remove(lab_and);
		this.remove(text2_between);
		this.text1_between = null;
		this.lab_and = null;
		this.text2_between = null;
		nb_composants -= 3;
		
		// et on rajoute le nouveaux :
		// JTextField valeur :
		text_valeur = new JTextField(12);
		this.add(text_valeur, nb_composants-1);
		nb_composants++;
		
		// MAJ :
		this.compo_between = false;
		this.revalidate();
	}
	
	
	
	/**
	 * Permet de savoir si la composition actuelle est celle 
	 * du between ou non
	 * @return vrai ou faux
	 */
	public boolean isBetweenCompo() {
		return this.compo_between;
	}

}


















