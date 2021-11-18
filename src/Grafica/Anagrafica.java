package Grafica;

import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Query.QueryDatabase;

import javax.management.Query;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Anagrafica {

	public JDialog frmAnagrafica;
	private JTable table;
	public DefaultTableModel dtmAnagrafica;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	public int i =  0;
	public String cognome = " ";
	public String nome = " ";
	public String via = " ";
	public String numeroCivico = " ";
	public String codiceFiscale = " ";
	public String codicePostale = " ";
	public String citta = " ";
	public String capoluogo = " ";
	private boolean filtro = false;
	ResultSet rSet ;

	/**
	 * @wbp.parser.entryPoint
	 */
	public Anagrafica() {
		
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frmAnagrafica = new JDialog();
		frmAnagrafica.setTitle("Gestionale Dott.ssa Ester Deplano");
		frmAnagrafica.setBounds(170, 100, 908, 560);
		frmAnagrafica.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmAnagrafica.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 872, 377);
		frmAnagrafica.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Cognome", "Nome", "Codice Fiscale", "Via", "Numero Civico", "Codice Postale", "Citta", "Capoluogo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(53);
		table.getColumnModel().getColumn(3).setPreferredWidth(107);
		table.getColumnModel().getColumn(4).setPreferredWidth(96);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setPreferredWidth(89);
		table.getColumnModel().getColumn(7).setPreferredWidth(94);
		
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Modifica");
		btnNewButton.setBounds(10, 487, 89, 23);
		frmAnagrafica.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			QueryDatabase modifica =new  QueryDatabase ();
				InserimentoClienti modificaClienti = new InserimentoClienti();
			modificaClienti.modifica = true;
			modificaClienti.id = i;
			
			modificaClienti.initialize();
						
				int l = dtmAnagrafica.getRowCount() - 1;
				for ( int i = 0 ; i <= l ; i ++) {
				dtmAnagrafica.removeRow(0);}
				
				try {
					rSet = modifica.selezioneAnagrafica();
				} catch (SQLException e1) {
						e1.printStackTrace();
				}
				dtmDefaultTableModel(rSet);			
			}
		});
	
		
		btnNewButton_1 = new JButton("Elimina");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryDatabase elimina = new QueryDatabase();
				try {
					elimina.cancella(i);
					
					int l = dtmAnagrafica.getRowCount() - 1;
					for ( int i = 0 ; i <= l ; i ++) {
					dtmAnagrafica.removeRow(0);
						}
					
					  rSet = elimina.selezioneAnagrafica();
					  dtmDefaultTableModel(rSet);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(122, 487, 89, 23);
		frmAnagrafica.getContentPane().add(btnNewButton_1);
		frmAnagrafica.setVisible(true);
		btnNewButton_2 = new JButton("Filtra");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryDatabase filtroDatabase = new QueryDatabase();
				Filtro filtrobottone = new Filtro();
				if ( filtro == true ) {
					int l = dtmAnagrafica.getRowCount() - 1;
					for ( int i = 0; i <= l ; i ++) {
					dtmAnagrafica.removeRow(0); }
						try {
							rSet = filtroDatabase.selezioneAnagrafica();
							dtmDefaultTableModel(rSet);
						} catch (SQLException e1) {	e1.printStackTrace();	}
				
					}
				filtrobottone.dtmFiltroDefaultTableModel = dtmAnagrafica;	
				filtrobottone.initialize();
				filtrobottone.dtmFiltroDefaultTableModel = dtmAnagrafica;
				dtmDefaultTableModel(filtrobottone.rSet);
				filtro = true;
				
			}
		});
		btnNewButton_2.setBounds(233, 487, 89, 23);
		frmAnagrafica.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Selezionare Riga prima di premere i bottoni");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 462, 287, 14);
		frmAnagrafica.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FARE DOPPIO CLICK SUL CLIENTE PER INSERIRE IL DATO IN FATTURA");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 28, 872, 35);
		frmAnagrafica.getContentPane().add(lblNewLabel_1);
	
		dtmAnagrafica = (DefaultTableModel) table.getModel();
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2 ) {
					
					cognome = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 1);
					nome = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 2);
					codiceFiscale = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 3);
					via = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 4);
					numeroCivico = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(),5);
					codicePostale = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 6);
					citta = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 7);
					capoluogo = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 8);
					frmAnagrafica.dispose();
					
				}
					else {
				i = (int) dtmAnagrafica.getValueAt(table.getSelectedRow(), 0);
				System.out.println(i);}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			public void mouseDoubleClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2 ) {
					
					String cognome = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 1);
					String nome = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 2);
					InserimentoFattura dati = new InserimentoFattura();
					
					frmAnagrafica.dispose();
					
				}
			}
		});
		
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void dtmDefaultTableModel (ResultSet rSet) {
		
		try {
		
			while (rSet.next()) {
			Vector rowData = new Vector ();
			rowData.add(rSet.getInt(1));
			rowData.add(rSet.getString(2));
			rowData.add(rSet.getString(3));
			rowData.add(rSet.getString(4));
			rowData.add(rSet.getString(5));
			rowData.add(rSet.getString(6));
			rowData.add(rSet.getString(7));
			rowData.add(rSet.getString(8));
			rowData.add(rSet.getString(9));
					
			dtmAnagrafica.addRow(rowData);	
			}
		} catch (SQLException e1) {}

			
	} 
}
