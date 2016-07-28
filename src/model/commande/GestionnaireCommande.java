/******************************************************
Cours:   LOG121
Session: E2016
Groupe:  01
Projet: Laboratoire #4
Étudiant(e)s: 
              Philippe Torres-Brisebois
              Laurent Theroux-Bombardier
              Samuel Croteau
              Nelson Chao
Professeur : Francis Cardinal
Nom du fichier: GestionnaireCommande.java
Date créé: 2016-07-27
Date dern. modif. 2016-07-27
*******************************************************
Historique des modifications
*******************************************************
2016-07-27 Version initiale
*******************************************************/

package model.commande;

import java.util.ArrayList;

public class GestionnaireCommande {
	private static GestionnaireCommande instance = null;
	private ArrayList<Commande> listCommande = new ArrayList<Commande>();

	/**
	 * Private constructor for the singleton pattern
	 */
	private GestionnaireCommande() {
		// to block constructor
	}

	/**
	 * Get the instance of the class
	 * 
	 * @return a caretaker of command
	 */
	public static GestionnaireCommande getInstance() {
		if (instance == null) {
			instance = new GestionnaireCommande();
		}
		return instance;
	}

	public void add(Commande c) {
		listCommande.add(c);
	}

	public void executeAll() {
		for (Commande cmd : listCommande) {
			cmd.execute();
		}
		listCommande.clear();
	}
}
