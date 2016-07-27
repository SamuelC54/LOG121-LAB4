package model.commande;

import java.util.ArrayList;

public class GestionnaireCommande {
	private ArrayList<Commande> listCommande = new  ArrayList<Commande>();
	
	public void add(Commande c){
		listCommande.add(c);
	}
	
	public void executeAll(){
		for (Commande cmd : listCommande){
			cmd.execute();
		}
	}
}
