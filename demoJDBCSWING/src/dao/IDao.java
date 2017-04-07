package dao;

import java.util.Collection;

import exceptions.ClientExistePasException;
import metier.Client;

public interface IDao {

	//Ajouter client
		public void ajouterClient(Client c);
		
		public Client chercherClient (int id) throws ClientExistePasException;
		
		//supprimer un client
		public void supprimerClient (int id) throws ClientExistePasException;
		
		//lister tous les clients
		public Collection <Client> listerClients ();
		
		//chercher les clients par mot clé
		public Collection<Client> chercherParMC (String mc);

		void modifierClient(int id, String nom, String prenom);
		
	
}
