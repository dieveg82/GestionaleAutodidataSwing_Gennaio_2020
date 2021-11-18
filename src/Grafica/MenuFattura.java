package Grafica;

import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnessioneDatabase.Connettore;
import Query.QueryDatabase;
import Query.QueryFattura;


import javax.management.Query;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.SwingConstants;
import java.awt.Font;



public class MenuFattura {

	public JDialog frmMenuFattura;
	private JTable table;
	public DefaultTableModel dtmAnagrafica;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	public int numeroFattura;
	public String dataFattura;
	public String cognome;
	public String nome;
	public String trattamento;
	public String trattamento2;
	public String trattamento3;
	public String imponibile;
	public String totaleFattura;
	public String metodoPagamento;
	private boolean filtro = false;
	public int mouseSelezione =  0;
	public Connection con;
	ResultSet rSet ;

	public MenuFattura() throws SQLException {

	Connettore connetto = new Connettore();
	con = connetto.connessione();

	}


	public void initialize() {
		frmMenuFattura = new JDialog();
		frmMenuFattura.setTitle("Gestionale Dott.ssa Ester Deplano");
		frmMenuFattura.setBounds(100, 100, 1200, 480);
		frmMenuFattura.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmMenuFattura.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 1164, 348);
		frmMenuFattura.getContentPane().add(scrollPane);
		
		table = new JTable();
	
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nr FT", "Data Fattura", "Cognome", "Nome", "Trattamento", "Trattamento", "Trattamento", "Imponibile", "Totale Fattura", "Metodo Pagamento"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(3).setPreferredWidth(107);
		table.getColumnModel().getColumn(7).setPreferredWidth(96);
		table.getColumnModel().getColumn(8).setPreferredWidth(85);
		table.getColumnModel().getColumn(9).setPreferredWidth(233);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Modifica");
		btnNewButton.setBounds(10, 407, 89, 23);
		frmMenuFattura.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			QueryFattura modifica =new  QueryFattura ();
				InserimentoFattura modificaFattura = new InserimentoFattura();
				modificaFattura.modifica = true;
				modificaFattura.numeroFattura = mouseSelezione;
				modificaFattura.initialize();
				if ( modificaFattura.erroreCognome == true) {
					MessaggioConferma errore = new MessaggioConferma();
					errore.lblNewLabel.setText("ERRORE MANCA IL COGNOME ");
					errore.lblNewLabel.setBounds(15, 35, 200, 50);
					errore.frmMessaggioConferma.setBounds(200, 200,250, 180);
				}
						
				int l = dtmAnagrafica.getRowCount() - 1;
				for ( int i = 0 ; i <= l ; i ++) {
				dtmAnagrafica.removeRow(0);}
				
				try {
					rSet = modifica.selezioneFattura();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dtmDefaultTableModel(rSet);			
			}
		});
	
		
		btnNewButton_1 = new JButton("Elimina");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mouseSelezione < dtmAnagrafica.getRowCount()) {
					MessaggioConferma errore = new MessaggioConferma();
					errore.frmMessaggioConferma.setBounds(200, 200, 340, 160);
					errore.lblNewLabel.setBounds(37, 0, 320, 100);
					errore.lblNewLabel.setText("CANCELLARE PRIMA FATTURA PRECEDENTE");
				}
				else {
				QueryFattura elimina = new QueryFattura();
				try {
					elimina.cancellaFattura(mouseSelezione);
					elimina.riposizionaIdFattura(mouseSelezione);
					
					int l = dtmAnagrafica.getRowCount() - 1;
					for ( int i = 0 ; i <= l ; i ++) {
					dtmAnagrafica.removeRow(0);
						}
					
					  rSet = elimina.selezioneFattura();
					  dtmDefaultTableModel(rSet);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			}
		});
		btnNewButton_1.setBounds(122, 407, 89, 23);
		frmMenuFattura.getContentPane().add(btnNewButton_1);
		frmMenuFattura.setVisible(true);
		btnNewButton_2 = new JButton("Filtra");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryFattura filtroDatabase = new QueryFattura();
				Filtro filtrobottone = new Filtro();
				if ( filtro == true ) {
					int l = dtmAnagrafica.getRowCount() - 1;
					for ( int i = 0; i <= l ; i ++) {
					dtmAnagrafica.removeRow(0); }
						try {
							rSet = filtroDatabase.selezioneFattura();
							dtmDefaultTableModel(rSet);
						} catch (SQLException e1) {	e1.printStackTrace();	}
				
					}
					
				filtrobottone.initialize();
				filtrobottone.dtmFiltroDefaultTableModel = dtmAnagrafica;
				dtmDefaultTableModel(filtrobottone.rSet);
				filtro = true;
				
			}
		});
		btnNewButton_2.setBounds(233, 407, 89, 23);
		frmMenuFattura.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Selezionare Riga prima dei comandi Modifica / Elimina / Stampa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 384, 532, 14);
		frmMenuFattura.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Inserisci ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryFattura inseDatabase = new QueryFattura();
				InserimentoFattura fatturaInserimentoDati = new InserimentoFattura();
				fatturaInserimentoDati.initialize();
				int l = dtmAnagrafica.getRowCount() - 1;
				for ( int i = 0; i <= l ; i ++) {
				dtmAnagrafica.removeRow(0); }
				
				try {
					rSet = inseDatabase.selezioneFattura();
					dtmDefaultTableModel(rSet);
				} catch (SQLException e1) {	e1.printStackTrace();	}
		
				MessaggioConferma okConferma = new MessaggioConferma ();
			}
		});
		btnNewButton_3.setBounds(341, 407, 89, 23);
		frmMenuFattura.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Stampa");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					
				try {
					
					
					JasperDesign stampaDesign = JRXmlLoader.load ("C:\\Users\\Diego\\eclipse-workspace\\ProgettoEster\\Blank_A4.jrxml");
					String sql = "SELECT * FROM fattura WHERE `NumeroFattura` = "+mouseSelezione+" ";
					
					JRDesignQuery selezioneJrDesignQuery = new JRDesignQuery();
					selezioneJrDesignQuery.setText(sql);
					stampaDesign.setQuery(selezioneJrDesignQuery);
					
					HashMap<String, Object> mappasqlHashMap = new HashMap<>();
					mappasqlHashMap.put("NumeroFattura", mouseSelezione);
					
				
					JasperReport jsJasperReport = JasperCompileManager.compileReport(stampaDesign);
					JasperPrint jPrint = JasperFillManager.fillReport(jsJasperReport, mappasqlHashMap, con);
					
                                        JasperViewer.viewReport(jPrint, false);
                                        
                                        
					
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		btnNewButton_3_1.setBounds(453, 407, 89, 23);
		frmMenuFattura.getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("Report Fatture\r\n");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					JasperDesign stampaDesign = JRXmlLoader.load ("C:\\Users\\Diego\\eclipse-workspace\\ProgettoEster\\Blank_A4_Landscape.jrxml");
					String sql = "SELECT * FROM fattura ";
					
					JRDesignQuery selezioneJrDesignQuery = new JRDesignQuery();
					selezioneJrDesignQuery.setText(sql);
					stampaDesign.setQuery(selezioneJrDesignQuery);
					
					HashMap <String,Object> mappasqlHashMap = new HashMap<>();
					mappasqlHashMap.put("NumeroFattura", sql);
					
					JasperReport jsJasperReport = JasperCompileManager.compileReport(stampaDesign);
					JasperPrint jPrint = JasperFillManager.fillReport(jsJasperReport, mappasqlHashMap, con);
					JasperViewer.viewReport(jPrint , false);
					
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		btnNewButton_3_1_1.setBounds(564, 407, 112, 23);
		frmMenuFattura.getContentPane().add(btnNewButton_3_1_1);
	
		dtmAnagrafica = (DefaultTableModel) table.getModel();
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2 ) {
					
					numeroFattura = (int) dtmAnagrafica.getValueAt(table.getSelectedRow(), 1);
					dataFattura = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 2);
					cognome = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 3);
					nome = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 4);
					trattamento = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 6);
					trattamento2 = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 7);
					trattamento3 = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 8);
					imponibile = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(),9);
					totaleFattura = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 10);	
					metodoPagamento = (String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 11);
					
					frmMenuFattura.dispose();
					
				}
					else {
				mouseSelezione = (int) dtmAnagrafica.getValueAt(table.getSelectedRow(), 0);
				System.out.println(mouseSelezione);}
			}
		});		
	}

	public void dtmDefaultTableModel (ResultSet rSet) {
		
		try {
		
			while (rSet.next()) {
			Vector rowData = new Vector ();
			rowData.add(rSet.getInt(1));
			rowData.add(rSet.getString(2));
			rowData.add(rSet.getString(3));
			rowData.add(rSet.getString(4));
			rowData.add(rSet.getString(11));
			rowData.add(rSet.getString(12));
			rowData.add(rSet.getString(13));
			rowData.add(rSet.getString(14));
			rowData.add(rSet.getString(17));
			rowData.add(rSet.getString(18));
					
			dtmAnagrafica.addRow(rowData);	
			}
		} catch (SQLException e1) {}

			
	} 
}
