package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Query.QueryDatabase;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InserimentoClienti {

	private JDialog frmInserimentoClienti;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	public JTextField textField_7;
	public String cognome;
	public String nome;
	public String codiceFiscale;
	public String via;
	public String numeroCivico;
	public String codicePostale;
	public String citta;
	public String capoluogo;
	public boolean modifica = false;
	public ResultSet rSet;
	public int id;
	public InserimentoClienti() {
	
		
		
	}
	public void initialize()  {
		frmInserimentoClienti = new JDialog();
		frmInserimentoClienti.setTitle("Dott.ssa .....\r\n");
		frmInserimentoClienti.setBounds(400, 200, 450, 433);
		frmInserimentoClienti.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmInserimentoClienti.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cognome\r\n");
		lblNewLabel.setBounds(35, 41, 81, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(35, 76, 81, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cod Fiscale");
		lblNewLabel_2_1.setBounds(35, 111, 81, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Via/Viale/Corso");
		lblNewLabel_2_1_1.setBounds(35, 146, 107, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Numero Civico");
		lblNewLabel_2_1_1_1.setBounds(35, 181, 107, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Codice Postale");
		lblNewLabel_2_1_1_1_1.setBounds(35, 216, 107, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Citta");
		lblNewLabel_2_1_1_1_1_1.setBounds(35, 251, 81, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Capoluogo");
		lblNewLabel_2_1_1_1_1_1_1.setBounds(35, 286, 81, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1_1_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(143, 43, 193, 20);
		frmInserimentoClienti.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 78, 193, 20);
		frmInserimentoClienti.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 113, 193, 20);
		frmInserimentoClienti.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(143, 148, 193, 20);
		frmInserimentoClienti.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(143, 183, 193, 20);
		frmInserimentoClienti.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(143, 218, 193, 20);
		frmInserimentoClienti.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(143, 253, 193, 20);
		frmInserimentoClienti.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(143, 288, 193, 20);
		frmInserimentoClienti.getContentPane().add(textField_7);
		
		JButton btnSa = new JButton("Salva");
		btnSa.setBounds(164, 339, 89, 23);
		frmInserimentoClienti.getContentPane().add(btnSa);
		
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryDatabase inserimento = new QueryDatabase();
				if (modifica == true) {
					cognome = textField.getText();
					nome = textField_1.getText();
					codiceFiscale = textField_2.getText();
					via = textField_3.getText();
					numeroCivico = textField_4.getText();
					codicePostale = textField_5.getText();
					citta = textField_6.getText();
					capoluogo = textField_7.getText();
					
					try {
						inserimento.modifica(id, cognome, nome, codiceFiscale, via, numeroCivico, codicePostale, citta, capoluogo);
						frmInserimentoClienti.dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				else {
				cognome = textField.getText();
				nome = textField_1.getText();
				codiceFiscale = textField_2.getText();
				via = textField_3.getText();
				numeroCivico = textField_4.getText();
				codicePostale = textField_5.getText();
				citta = textField_6.getText();
				capoluogo = textField_7.getText();
				
				
				try {
					inserimento.inserimentoAnagrafica (cognome, nome, codiceFiscale, via, numeroCivico, codicePostale, citta, capoluogo);
					frmInserimentoClienti.dispose();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			}
		});
			if (modifica == true) {
				QueryDatabase modifica = new QueryDatabase ();
				
					try {
						rSet = modifica.selezioneid(id);
			
					while (rSet.next()) {
						textField.setText(rSet.getString(2));
						textField_1.setText(rSet.getString(3));
						textField_2.setText(rSet.getString(4));
						textField_3.setText(rSet.getString(5));
						textField_4.setText(rSet.getString(6));
						textField_5.setText(rSet.getString(7));
						textField_6.setText(rSet.getString(8));
						textField_7.setText(rSet.getString(9));
					}
						textField.getText();
					
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				
			}

				
			frmInserimentoClienti.setModal(true);
		frmInserimentoClienti.setVisible(true);
	}
}
