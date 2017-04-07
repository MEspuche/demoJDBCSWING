package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import metier.Client;
import service.ClientService;
import service.IClientService;

public class Fenetre extends JFrame {

	private JLabel jl1 = new JLabel("Nom");
	private JTextField jtf1 = new JTextField(12);
	private JLabel jl2 = new JLabel("Prenom");
	private JTextField jtf2 = new JTextField(12);
	private JLabel jl3 = new JLabel("Couleur des yeux");
	private JTextField jtf3 = new JTextField(12);
	private static JButton jb1 = new JButton("ajouter");
	
	private IClientService s = new ClientService();
	Client c = new Client ();
	
	public Fenetre (String nom){
		
	// TODO Auto-generated constructor stub
	super(nom);
	setSize(800,600);
	//disposition de la fenetre principale
	this.setLayout(new BorderLayout());//ligne par ligne
	
	//ajout premiere ligne
	JPanel jp1 = new JPanel ();
	jp1.setLayout(new FlowLayout());//les uns a la suite des autres
	jp1.add(jl1);
	jp1.add(jtf1);
	
	

	
	JPanel jp2 = new JPanel ();
	jp2.setLayout(new FlowLayout());
	jp2.add(jl2);
	jp2.add(jtf2);
	

	
	
	JPanel jp3 = new JPanel ();
	jp3.setLayout(new FlowLayout());
	jp3.add(jl3);
	jp3.add(jtf3);
	
	
	JPanel jp4 = new JPanel ();
	jp4.setLayout(new FlowLayout());
	jp4.add(jb1);
	

	JPanel jp5 = new JPanel ();
	jp5.setLayout(new BoxLayout(jp5, BoxLayout.Y_AXIS));
	jp5.add(jp1);
	jp5.add(jp2);
	jp5.add(jp3);
	jp5.add(jp4);
	
	this.add(jp5,BorderLayout.NORTH);

	
	
	//rendre le button actif en lui donnant une action à réaliser 
	jb1.addActionListener(new ActionListener() {
			
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				String nom = jtf1.getText();
				String prenom = jtf2.getText();
				String couleurYeux = jtf3.getText();
				c.setNom(nom);
				c.setPrenom(prenom);
				c.setCouleurYeux(couleurYeux);
				s.ajouterClient(c);
				
				//vider les champs apres ajout en base
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				
				
			}
		});	
	}

	
	
	


public static void main(String[] args) {
	// TODO Auto-generated method stub

	Fenetre f = new Fenetre("MA FENETRE");
	f.setVisible(true);
	
	
	
}
	
}
