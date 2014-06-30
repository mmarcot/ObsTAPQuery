package interface_plugin;

import javax.swing.*;

import util.Configuration;
import util.Langage;

import listeners.AuditeurBoutonRemove;
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
	/** Combo box de la liaison */
	private JComboBox combo_liaison;
	/** Combo box de la colonne obscore */
	private JComboBox combo_col_obs;
	/** Combo box de l'opérateur */
	private JComboBox combo_oper;
	
	
	
	/**
	 * Constructeur d'une ligne de contrainte 
	 * @param liaison Liaison avec la contrainte précédente (AND ou OR)
	 */
	public LigneDeContrainte(boolean liaison) {
		this.operateurDeLiaison = liaison;
		this.compo_between = false;
		
		// Affichage éventuel de la liaison :
		if(operateurDeLiaison) {
			combo_liaison = new JComboBox(Configuration.TAB_LIAISONS);
			this.add(combo_liaison);
		}
		
		// JComboBox colonnes obscore :
		combo_col_obs = new JComboBox(ColonnesObscore.getColonnesObscore().toArray());
		this.add(combo_col_obs);
		
		// JComboBox opérateurs :
		combo_oper = new JComboBox(Configuration.TAB_OPERATEURS_WHERE);
		combo_oper.addActionListener(new AuditeurOperateurs());
		combo_oper.setMaximumRowCount(Configuration.NB_LIGNES_COMBOBOX_OPER);
		this.add(combo_oper);
			
		// JTextField valeur :
		text_valeur = new JTextField(Configuration.TAILLE_JTEXTFIELD_NORMAL);
		this.add(text_valeur);
		
		//JButton remove constraint :
		JButton but_remove = new JButton(Langage.getWhere_but_remove());
		but_remove.setToolTipText(Langage.getWhere_but_remove_tt());
		but_remove.addActionListener(new AuditeurBoutonRemove());
		this.add(but_remove);
		
	}
	
	
	/**
	 * Methode qui compose la ligne pour un between
	 */
	public void toBetweenComposition() {
		
		// suppression grand JTextField :
		this.remove(text_valeur);
		this.text_valeur = null;
		
		// ajoute JTextField 1 :
		text1_between = new JTextField(Configuration.TAILLE_JTEXTFIELD_BETWEEN);
		this.add(text1_between, getComponentCount()-1);
		
		// ajoute JLabel "and" :
		lab_and = new JLabel("AND");
		this.add(lab_and, getComponentCount()-1);
		
		// ajoute JTextField 2 :
		text2_between = new JTextField(Configuration.TAILLE_JTEXTFIELD_BETWEEN);
		this.add(text2_between, getComponentCount()-1);
		
		// MAJ :
		this.compo_between = true;
		this.revalidate();
	}
	
	
	/**
	 * Methode qui compose la ligne pour un opérateur normal
	 */
	public void toRegularComposition() {
		
		// on enlève les composant dont on n'a plus besoin
		this.remove(text1_between);
		this.remove(lab_and);
		this.remove(text2_between);
		this.text1_between = null;
		this.lab_and = null;
		this.text2_between = null;
		
		// et on rajoute le nouveaux :
		// JTextField valeur :
		text_valeur = new JTextField(Configuration.TAILLE_JTEXTFIELD_NORMAL);
		this.add(text_valeur, getComponentCount()-1);
		
		// MAJ :
		this.compo_between = false;
		this.revalidate();
	}
	
	
	
	/**
	 * Permet d'enlever la liaison d'une ligne de contrainte
	 */
	public void enleverLiaison() {
		if(combo_liaison != null ) {
			if(this.operateurDeLiaison) {
				this.operateurDeLiaison = false;
			}
			this.remove(combo_liaison);
			this.revalidate();
		}
	}
	
	
	
	/**
	 * Permet de savoir si la composition actuelle est celle 
	 * du between ou non
	 * @return vrai ou faux
	 */
	public boolean isBetweenCompo() {
		return this.compo_between;
	}
	
	
	
	@Override
	public String toString() {
		String ret = new String();
		
		if(operateurDeLiaison)
			ret += (String)combo_liaison.getSelectedItem() + " ";
		else
			ret += "WHERE ";
		
		ret += (String)combo_col_obs.getSelectedItem() + " ";
		ret += (String)combo_oper.getSelectedItem() + " ";
		
		if(!compo_between) {
			ret += (String) text_valeur.getText() + " ";
		}
		else {
			ret += (String) text1_between.getText() + " ";
			ret += "AND ";
			ret += (String) text2_between.getText() + " ";
		}
		
		return ret;
	}

}


















