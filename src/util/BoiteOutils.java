package util;

import java.io.*;
import java.util.Scanner;

import javax.swing.*;


/**
 * Ensemble de fonctions statiques utilitaires 
 * @author Mallory Marcot
 *
 */
public class BoiteOutils {
	
	
	
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
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Methode qui lit le fichier et retourne son contenu en entier
	 * @return Le contenu du fichier
	 */
	public static String lireLeFichier(File fichier) {
		Scanner sc = null;

		try {
			sc = new Scanner(fichier);
		} catch (FileNotFoundException e) {
			erreur(Langage.getFileNotFound());
			e.printStackTrace();
		}
		
		return sc.useDelimiter("\\A").next();
	}
	
	
	
	/**
	 * Methode statique permettant d'afficher une erreur (JOptionPane)
	 * @param message Le message d'erreur
	 */
	public static void erreur(String message) {
		JOptionPane.showMessageDialog(null, message, Langage.getErreur(), JOptionPane.ERROR_MESSAGE);
	}

	
}

















