package service;

import java.util.Collection;

import exceptions.ClientExistePasException;
import metier.Client;

public interface IClientService {
	public void direBonjour();
	public void direAurevoir();
	//public void jesuisVip();
	
	
	//Ajouter client
	public void ajouterClient(Client c);
	
	//modifier client
	public void modifierClient (int id, String nom, String prenom);
	
	//supprimer un client
	public void supprimerClient (int id) throws ClientExistePasException;
	
	//lister tous les clients
	public Collection <Client> listerClients ();
	
	//chercher les clients par mot clé
	public Collection<Client> chercherParMC (String mc);
	
	public Client chercherClient(int id) throws ClientExistePasException;
}
