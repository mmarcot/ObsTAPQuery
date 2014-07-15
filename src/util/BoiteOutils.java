package util;

import java.io.*;

import javax.swing.*;


/**
 * Ensemble de fonctions statiques utilitaires 
 * @author Mallory Marcot
 *
 */
public class BoiteOutils {
	
	
	/**
	 * Permet de choisir un fichier et d'écrire le texte passé
	 * en parametre dedans
	 * @param p_txt Le texte à écrire
	 */
	public static void ecrireDansUnFichier(String p_txt) {
		String chemin = JOptionPane.showInputDialog(Langage.getPath());
		File fichier = new File(chemin); 
		
		try {
			fichier.createNewFile();
			FileWriter writer = new FileWriter(fichier);
			
			try {
				writer.write(p_txt);
			} 
			finally {
				// quoiqu'il arrive, on ferme le fichier
				writer.close();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Permet d'écrire le texte passé en parametre dans le fichier 
	 * passé en parametre
	 * @param fichier Le fichier dans lequel il faut écrire
	 * @param p_txt Le texte à écrire
	 */
	public static void ecrireDansLeFichier(File fichier	, String p_txt) {
		
		try {
			fichier.createNewFile();
			FileWriter writer = new FileWriter(fichier);
			
			try {
				writer.write(p_txt);
			} 
			finally {
				// quoiqu'il arrive, on ferme le fichier
				writer.close();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
