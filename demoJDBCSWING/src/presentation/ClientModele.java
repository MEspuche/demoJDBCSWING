package presentation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import metier.Client;

public class ClientModele extends AbstractTableModel {
	
	
	
	private Vector<String[]> tablesvalues = new Vector <String[]>(); // attribut lignes de la table
	private String[] tableColumnNames = new String [] {"id",
            "nom",
            "prenom",
            "couleur Yeux"}; // attribut colonnes de la table
	
	//Nombre de colonnes
	public int getColumnCount(){
		
		return tableColumnNames.length;  
	}


	//nombre de lignes
	@Override
	public int getRowCount() {
		
		return tablesvalues.size();
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return tablesvalues.get(rowIndex)[columnIndex];
	}
	
	//retourne le nom de la colonne
	public String getColumnName(int columnIndex){
		return tableColumnNames[columnIndex];
	}
	
	
	//remplir le tableau avec les donnees issues de la BDD
	public void setData (List<Client> clients)
	{
		tablesvalues = new Vector<String[]>();
		for (Client c : clients)
		{
			tablesvalues.add(new String[]{String.valueOf(c.getId()), c.getNom(), c.getPrenom(), c.getCouleurYeux()});
		}
		fireTableChanged(null);
	}
	

	
}
	

	
	
	
	
	
	
	
	
	/*for (Client c : col3) 
	{
	Object[][] data = {
		    {c.getId(), c.getNom(),
		     c.getPrenom()},
		  };
	
	
	JTable table = new JTable(data, columnNames);
	
	
	table.setFillsViewportHeight(true);
	}
	
}*/
