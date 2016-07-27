package model.commande;

import java.util.ArrayList;

public class GestionnaireCommande {
	private static GestionnaireCommande instance = null;
	private ArrayList<Commande> listCommande = new ArrayList<Commande>();

	private GestionnaireCommande() {
		// to block constructor
	}

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
