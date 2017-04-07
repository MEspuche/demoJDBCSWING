package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.ClientExistePasException;
import metier.Client;
import service.ClientService;
import service.IClientService;

public class Fenetre2 extends JFrame {

	
	
	private JLabel jlID = new JLabel ("ID");
	private JLabel jlID2 = new JLabel ("ID");
	private JTextField jtfID1 = new JTextField(12);
	private JTextField jtfIDmodif = new JTextField(12);
	private JLabel jl1 = new JLabel("Nom");
	private JLabel jl10 = new JLabel("Nom");
	private JTextField jtf1 = new JTextField(12);
	private JTextField jtfnommodif = new JTextField(12);
	private JLabel jl2 = new JLabel("Prenom");
	private JLabel jl20 = new JLabel("Prenom");
	private JTextField jtf2 = new JTextField(12);
	private JTextField jtfprenommodif = new JTextField(12);
	private JLabel jl3 = new JLabel("Couleur des yeux");
	private JTextField jtf3 = new JTextField(12);
	private static JButton jb1 = new JButton("ajouter");
	private static JButton jbsupprimer = new JButton("supprimer");
	private static JButton jbsmodifier = new JButton("modifier");
	
	//liste composants onglet 4
	private JLabel motcle = new JLabel("mot clé");
	private JTextField jtfmotcle = new JTextField(12);
	private static JButton jblister = new JButton("lister");
	private JScrollPane jsp; // gerer le defilement du tableau
	private JTable JtableClient;
	private JPanel jpN = new JPanel();
	private ClientModele model;
	
	
	private IClientService s = new ClientService();
	Client c = new Client ();
	
	public Fenetre2 (String nom){
		
	// TODO Auto-generated constructor stub
	super(nom);
	setSize(800,600);
	//disposition de la fenetre principale
	this.setLayout(new BorderLayout());//ligne par ligne
	
	
	JTabbedPane onglets = new JTabbedPane (SwingConstants.TOP);
	
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
	
	JPanel onglet1 = new JPanel ();
	
	onglet1.setBackground(Color.BLACK);
	
	onglet1.add(jp5,BorderLayout.NORTH);
	

	
	
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
	onglets.addTab("ajouter", onglet1);
	
	JPanel jpsupprimer = new JPanel ();
	jpsupprimer.setLayout(new FlowLayout());
	jpsupprimer.add(jlID);
	jpsupprimer.add(jtfID1);
	jpsupprimer.add(jbsupprimer);
	
	JPanel onglet2 = new JPanel ();
	onglet2.setBackground(Color.pink);
	
	onglet2.add(jpsupprimer,BorderLayout.NORTH);
	
	jbsupprimer.addActionListener(new ActionListener() {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			int id = Integer.parseInt(jtfID1.getText());
			c.setId(id);
			try {
				s.supprimerClient(id);
			} catch (ClientExistePasException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//vider les champs apres ajout en base
			jtfID1.setText("");
		
			
			
		}
	});	
	
	onglets.addTab("supprimer", onglet2);
	
	
	
	JPanel jp10 = new JPanel ();
	jp10.setLayout(new FlowLayout());//les uns a la suite des autres
	jp10.add(jlID2);
	jp10.add(jtfIDmodif);
	
	
	JPanel jp20 = new JPanel ();
	jp20.setLayout(new FlowLayout());
	jp20.add(jl10);
	jp20.add(jtfnommodif);
	
	
	JPanel jp30 = new JPanel ();
	jp30.setLayout(new FlowLayout());
	jp30.add(jl20);
	jp30.add(jtfprenommodif);
	
	
	JPanel jp40 = new JPanel ();
	jp40.setLayout(new FlowLayout());
	jp40.add(jbsmodifier);
	

	JPanel jp50 = new JPanel ();
	jp50.setLayout(new BoxLayout(jp50, BoxLayout.Y_AXIS));
	jp50.add(jp10);
	jp50.add(jp20);
	jp50.add(jp30);
	jp50.add(jp40);
	
	JPanel onglet3 = new JPanel ();
	
	onglet3.add(jp50,BorderLayout.NORTH);
	onglet3.setBackground(Color.RED);
	
	jbsmodifier.addActionListener(new ActionListener() {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			int id = Integer.parseInt(jtfIDmodif.getText());
			String nom = jtfnommodif.getText();
			String prenom = jtfprenommodif.getText();
			s.modifierClient(id, nom, prenom);
			
			//vider les champs apres ajout en base
			jtfIDmodif.setText("");
			jtfnommodif.setText("");
			jtfprenommodif.setText("");
			
			
		}
	});	
	
	onglets.addTab("modifier", onglet3);
	
	
	
	jpN.setLayout(new FlowLayout());
	jpN.add(motcle);
	jpN.add(jtfmotcle);
	jpN.add(jblister);
	
	JPanel onglet4 = new JPanel ();
	onglet4.setLayout(new BoxLayout(onglet4, BoxLayout.PAGE_AXIS));
	onglet4.setBackground(Color.CYAN);
	onglet4.add(jpN,BorderLayout.NORTH);
	
	//ajout tableau
	model = new ClientModele();
	JtableClient = new JTable(model);
	jsp = new JScrollPane(JtableClient);
	onglet4.add(jsp, BorderLayout.NORTH);
	jsp.setBackground(Color.green);
	JtableClient.setBackground(Color.yellow);
	jblister.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String mc = jtfmotcle.getText();
			model.setData((List<Client>) s.chercherParMC(mc));
			
			//vider les champs apres ajout en base
			jtfmotcle.setText("");
			
	
		}
		});	
	
	onglets.addTab("chercher par mot clé", onglet4);
	
	
	this.getContentPane().add(onglets);
	}

	
	
	


public static void main(String[] args) {
	// TODO Auto-generated method stub

	Fenetre2 f = new Fenetre2("MA FENETRE");
	f.setVisible(true);
	
	
	
}
	
}
