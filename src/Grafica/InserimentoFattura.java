package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import Query.QueryDatabase;
import Query.QueryFattura;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InserimentoFattura {

	private JDialog frmInserimentoFattura;
	public String cognomeString;
	public String nomeString;
	public String dataFatturaString;
	public String trattamentoString;
	public String trattamento2sString;
	public String trattamento3String;
	public String impString;
	public String empapString;
	public String bolloString;
	public String totaleFatturaString;
	public String metodoPagamentoString;
	private JTextField cognome_textField;
	public 	JTextField nome_textfield;
	private JTextField dataFattura;
	private JTextField trattamento;
	private JTextField trattamento2;
	private JTextField trattamento3;
	private JTextField imponibile_text;
	private JTextField empap;
	private JTextField bollo_text;
	private JTextField totaleFattura_text;
	public Anagrafica anagrafica;
	public int numeroFattura = 0;
	public boolean modifica = false;
	public ResultSet rSet;
	private JTextField metodoPagamento_text;
	public boolean erroreCognome = false;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public InserimentoFattura() {
	
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmInserimentoFattura = new JDialog();
		frmInserimentoFattura.setTitle("Dott.ssa ....");
		frmInserimentoFattura.setBounds(400, 200, 492, 400);
		frmInserimentoFattura.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmInserimentoFattura.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome\r\n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(31, 44, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblNewLabel);
		
		JLabel lblTrattamento = new JLabel("Data Fattura");
		lblTrattamento.setForeground(Color.RED);
		lblTrattamento.setBounds(31, 69, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblTrattamento);
		
		JLabel lblTrattamento_1 = new JLabel("Trattamento");
		lblTrattamento_1.setForeground(Color.RED);
		lblTrattamento_1.setBounds(31, 94, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblTrattamento_1);
		
		JLabel lblTrattamento_2 = new JLabel("Trattamento\r\n");
		lblTrattamento_2.setBounds(31, 119, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblTrattamento_2);
		
		JLabel lblTrattamento_3 = new JLabel("Trattamento\r\n");
		lblTrattamento_3.setBounds(31, 144, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblTrattamento_3);
		
		JLabel lblNewLabel_4_1 = new JLabel("Imponibile\r\n");
		lblNewLabel_4_1.setBounds(31, 169, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Rivalsa Empap\r\n");
		lblNewLabel_4_1_1.setBounds(31, 194, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Bollo");
		lblNewLabel_4_1_1_1.setBounds(31, 219, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Totale Fattura");
		lblNewLabel_4_1_1_1_1.setForeground(Color.RED);
		lblNewLabel_4_1_1_1_1.setBounds(31, 244, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblNewLabel_4_1_1_1_1);
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anagrafica = new Anagrafica();
				QueryDatabase selezione = new QueryDatabase();			
				try {
					ResultSet rSet = selezione.selezioneAnagrafica();
					anagrafica.initialize();
					anagrafica.dtmDefaultTableModel(rSet);
					anagrafica.frmAnagrafica.dispose();
					anagrafica.frmAnagrafica.setModal(true);
					anagrafica.frmAnagrafica.setVisible(true);
				
					nome_textfield.setText(anagrafica.nome);
					cognome_textField.setText(anagrafica.cognome);
					
					nome_textfield.getText();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Diego\\Desktop\\cerca_find.gif"));
		btnNewButton.setBounds(371, 19, 53, 35);
		frmInserimentoFattura.getContentPane().add(btnNewButton);
		
		cognome_textField = new JTextField();
		cognome_textField.setColumns(10);
		cognome_textField.setBounds(132, 13, 228, 20);
		frmInserimentoFattura.getContentPane().add(cognome_textField);
		
		nome_textfield = new JTextField();
		nome_textfield.setBounds(132, 41, 228, 20);
		frmInserimentoFattura.getContentPane().add(nome_textfield);
		nome_textfield.setColumns(10);
		
		dataFattura = new JTextField();
		dataFattura.setColumns(10);
		dataFattura.setBounds(132, 66, 228, 20);
		frmInserimentoFattura.getContentPane().add(dataFattura);
		
		
		trattamento = new JTextField();
		trattamento.setColumns(10);
		trattamento.setBounds(132, 91, 228, 20);
		frmInserimentoFattura.getContentPane().add(trattamento);
		
		trattamento2 = new JTextField();
		trattamento2.setColumns(10);
		trattamento2.setBounds(132, 116, 228, 20);
		frmInserimentoFattura.getContentPane().add(trattamento2);
		
		trattamento3 = new JTextField();
		trattamento3.setColumns(10);
		trattamento3.setBounds(132, 141, 228, 20);
		frmInserimentoFattura.getContentPane().add(trattamento3);
		
		imponibile_text = new JTextField();
		imponibile_text.setEditable(false);
		imponibile_text.setColumns(10);
		imponibile_text.setBounds(132, 166, 228, 20);
		frmInserimentoFattura.getContentPane().add(imponibile_text);
		
		empap = new JTextField();
		empap.setEditable(false);
		empap.setColumns(10);
		empap.setBounds(132, 191, 228, 20);
		frmInserimentoFattura.getContentPane().add(empap);
		
		bollo_text = new JTextField();
		bollo_text.setEditable(false);
		bollo_text.setColumns(10);
		bollo_text.setBounds(132, 216, 228, 20);
		frmInserimentoFattura.getContentPane().add(bollo_text);
		
		totaleFattura_text = new JTextField();
		totaleFattura_text.setColumns(10);
		totaleFattura_text.setBounds(132, 241, 228, 20);
		frmInserimentoFattura.getContentPane().add(totaleFattura_text);
		
		metodoPagamento_text = new JTextField();
		metodoPagamento_text.setColumns(10);
		metodoPagamento_text.setBounds(132, 266, 228, 20);
		frmInserimentoFattura.getContentPane().add(metodoPagamento_text);
		
		JButton btnNewButton_1 = new JButton("Calcola");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				double totaleFattura = Double.parseDouble(totaleFattura_text.getText());
				double imponibileNoEnpap = totaleFattura - (totaleFattura * 2 /100 );
				imponibileNoEnpap = arrotonda(imponibileNoEnpap, 2);
				double rivalsa = imponibileNoEnpap * 2/100;
				rivalsa = arrotonda(rivalsa, 2);
				double imponibile = totaleFattura - rivalsa ;
				if ( totaleFattura > 77.41) {
					totaleFattura = totaleFattura + 2 ;	
					String totaleFatturaString = String.valueOf(totaleFattura);
					bollo_text.setText("2");
					totaleFattura_text.setText(totaleFatturaString);
				}
				String rivalString = String.valueOf(rivalsa);
				String imponibiString = String.valueOf(imponibile);
				imponibile_text.setText(imponibiString);
				empap.setText(rivalString);
				imponibile_text.getText();
				empap.getText();
				
			} 
		});
		btnNewButton_1.setBounds(132, 308, 89, 23);
		frmInserimentoFattura.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Salva");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			QueryFattura salvaFattura = new QueryFattura();
				if (modifica == true) {
					
					
				cognomeString = cognome_textField.getText();
				nomeString = nome_textfield.getText();
				dataFatturaString = dataFattura.getText();
				trattamentoString = trattamento.getText();
				trattamento2sString = trattamento2.getText();
				trattamento3String = trattamento3.getText();
				impString = imponibile_text.getText();
				empapString = empap.getText();
				bolloString = bollo_text.getText();
				totaleFatturaString = totaleFattura_text.getText();
				metodoPagamentoString = metodoPagamento_text.getText();
			
				
				try {
						salvaFattura.modificaFattura(numeroFattura, dataFatturaString, cognomeString, nomeString, trattamentoString, trattamento2sString, trattamento3String, impString, empapString, bolloString, totaleFatturaString,metodoPagamentoString);
						
						if ( salvaFattura.errore == true) {
							erroreCognome = true;
						}
						frmInserimentoFattura.dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
				
				else {
				try {
					
					salvaFattura.inserimentoFattura(dataFattura.getText(),anagrafica.cognome , anagrafica.nome , anagrafica.codiceFiscale , anagrafica.via , anagrafica.numeroCivico , anagrafica.codicePostale , anagrafica.citta , anagrafica.capoluogo ,trattamento.getText(), trattamento2.getText(), trattamento3.getText(), imponibile_text.getText(), empap.getText(), bollo_text.getText(), totaleFattura_text.getText(),metodoPagamento_text.getText());
					
					frmInserimentoFattura.dispose();
					
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			}
		});
		btnNewButton_1_1.setBounds(271, 308, 89, 23);
		frmInserimentoFattura.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("In rosso campi obbligatori");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(31, 342, 329, 14);
		frmInserimentoFattura.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setForeground(Color.RED);
		lblCognome.setBounds(31, 19, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblCognome);
		
		JLabel lblMetodoPagamento = new JLabel("Metodo Pagamento");
		lblMetodoPagamento.setBounds(31, 269, 102, 14);
		frmInserimentoFattura.getContentPane().add(lblMetodoPagamento);
		
	
		
		
		
		if (modifica == true) {
			QueryFattura modifica = new QueryFattura ();
			
				try {
					rSet = modifica.selezioneidFattura(numeroFattura);
		
				while (rSet.next()) {
					nome_textfield.setText(rSet.getString(4));
					cognome_textField.setText(rSet.getString(3));
					dataFattura.setText(rSet.getString(2));
					trattamento.setText(rSet.getString(11));
					trattamento2.setText(rSet.getString(12));
					trattamento3.setText(rSet.getString(13));
					imponibile_text.setText(rSet.getString(14));
					empap.setText(rSet.getString(15));
					bollo_text.setText(rSet.getString(16));
					totaleFattura_text.setText(rSet.getString(17));
					metodoPagamento_text.setText(rSet.getString(18));
					
				}
					nome_textfield.getText();
				
				} catch (SQLException e1) {	e1.printStackTrace();	}	
							}
		frmInserimentoFattura.setModal(true);
		frmInserimentoFattura.setVisible(true);
	}


		static public double arrotonda ( double numero, int nCifreDecimali ){
		return Math.round( numero * Math.pow( 10, nCifreDecimali ) )/Math.pow( 10, nCifreDecimali );
				}
}