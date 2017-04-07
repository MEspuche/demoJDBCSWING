package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import exceptions.ClientExistePasException;
import metier.Client;

public class Dao implements IDao {

	@Override
	public void ajouterClient(Client c) {
		
		try {
			//1.charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			//2.creer la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			//3.creer la requete
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Client (nom, prenom, couleurYeux) VALUES ('" + c.getNom() + "','"+ c.getPrenom()+ "','"+ c.getCouleurYeux()+ "')");
			// PreparedStatement ps = conn.prepareStatement("INSERT INTO Client (nom, prenom) VALUES (?;?)");
			
			//4.executer la requete
			ps.executeUpdate();
			//ps.setString(1,c.getNom());
			//ps.setString(2,c.getPrenom());
			
			
			//5.afficher le resultat : pas de resultat attendu
			
			//6.fermer la connection 
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		//code qui est execute quelque soit les étapes précédentes	
		}

	}

	@Override
	public void modifierClient(int id, String nom, String prenom) {
		try {
			//1.charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			//2.creer la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			//3.creer la requete
			String s = "UPDATE Client SET NOM = ?, PRENOM = ? WHERE ID = ? ";
			PreparedStatement ps = conn.prepareStatement(s);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, id);
			
			//4.executer la requete
			ps.executeUpdate();
			//5.afficher le resultat : pas de resultat attendu
			
			//6.fermer la connection 
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		//code qui est execute quelque soit les étapes précédentes	
		}


	}

	@Override
	
	
	public void supprimerClient(int id) throws ClientExistePasException {
		try {
		//1.charger le pilote
		Class.forName("com.mysql.jdbc.Driver");
		//2.creer la connexion
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
		//3.creer la requete
		PreparedStatement ps = conn.prepareStatement("DELETE FROM Client WHERE ID = ?");
		ps.setInt(1, id);
		//4.executer la requete
		if(ps.executeUpdate()==0)
		{
		
		 throw new ClientExistePasException("le client dont l'id est " + id + " n'existe pas");
		}
		//5.afficher le resultat : pas de resultat attendu
		
		//6.fermer la connection 
		conn.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	} finally {
	//code qui est execute quelque soit les étapes précédentes	
	}

	}

	@Override
	public Collection<Client> listerClients() {
		Collection<Client> cl = new ArrayList<Client>();
		try {
			//1.charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			//2.creer la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			//3.creer la requete
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Client ");
			//4.executer la requete
			 ps.executeQuery();
			//5.afficher le resultat : pas de resultat attendu
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Client c2= new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),rs.getString("couleurYeux"));
				cl.add(c2);
				
			}
			//6.fermer la connection 
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
		} 
		return cl;
	}

	@Override
	public Collection<Client> chercherParMC (String mc) {
		
		Collection<Client> cl2 = new ArrayList<Client>();
		try {
			//1.charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			//2.creer la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			//3.creer la requete
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Client WHERE UPPER(NOM) LIKE UPPER('%"+ mc +"%')");
			//4.executer la requete
			 ps.executeQuery();
			//5.afficher le resultat : pas de resultat attendu
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Client c2= new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("couleurYeux"));
				cl2.add(c2);
				
			}
			//6.fermer la connection 
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
		return cl2;
		}

	@Override
	public Client chercherClient(int id) throws ClientExistePasException {
		
		Client c3 = new Client();
		try {
			
			//1.charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			//2.creer la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			//3.creer la requete
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Client WHERE ID = ?");
			ps.setInt(1, id);
			//4.executer la requete
			 ps.executeQuery();
			//5.afficher le resultat : pas de resultat attendu
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				c3.setId(rs.getInt("id"));
				c3.setNom(rs.getString("nom"));
				c3.setPrenom(rs.getString("prenom"));
				c3.setCouleurYeux(rs.getString("couleurYeux"));
				
				
			}
			
			else throw new ClientExistePasException("le client dont l'id est " + id + " n'existe pas");
			//6.fermer la connection 
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		return c3;

		


}
	



}
