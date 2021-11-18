package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Query.QueryDatabase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Filtro {

	private JDialog frmFiltro;
	private JTextField textField;
	public ResultSet rSet;
	public DefaultTableModel dtmFiltroDefaultTableModel ;
	public Filtro() {
		
	}

	public void initialize() {
		frmFiltro = new JDialog();
		frmFiltro.setTitle("Gestionale .......");
		frmFiltro.setBounds(400, 200, 316, 180);
		frmFiltro.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmFiltro.getContentPane().setLayout(null);
		
		final String[] filtro = { "Nome", "Cognome", "Codice Fiscale", "Via", "Numero Civico", "Codice Postale", "Citta", "Capoluogo"};
		
		final JComboBox comboBox = new JComboBox(filtro);
		comboBox.setBounds(95, 26, 102, 22);
		frmFiltro.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(49, 59, 186, 20);
		frmFiltro.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QueryDatabase queryDatabase = new QueryDatabase();
				
				int l = dtmFiltroDefaultTableModel.getRowCount() - 1;
				for ( int i = 0 ; i <= l ; i ++) {
				dtmFiltroDefaultTableModel.removeRow(0);
					}
				
					try {
						rSet =queryDatabase.selezionefiltro(filtro[comboBox.getSelectedIndex()], textField.getText());
						frmFiltro.dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
			 
			}
		});
		btnNewButton.setBounds(95, 90, 89, 23);
		frmFiltro.getContentPane().add(btnNewButton);
		
		frmFiltro.setModal(true);
		frmFiltro.setVisible(true);
		
	
	
	}
}
