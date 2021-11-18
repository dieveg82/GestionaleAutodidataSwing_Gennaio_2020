package ConnessioneDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;



import Grafica.PaginaIniziale;
import Proprieta.FileProperties;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class MascheraConnessione {

	private JFrame frmMascheraConnessione;
	private JTextField utenteField;
	private JTextField passwordField;
	private JTextField portaField;
	private JTextField serverField;
	private JTextField databaseField;
	private Connection primaConnessione;

	public MascheraConnessione() {
		initialize();
	}

	private void initialize() {
		frmMascheraConnessione = new JFrame();
		frmMascheraConnessione.setTitle("Gestionale Dott.ssa Ester Deplano");
		frmMascheraConnessione.setBounds(100, 100, 247, 250);
		frmMascheraConnessione.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMascheraConnessione.getContentPane().setLayout(null);
		
		final JLabel utenteLabel = new JLabel("Utente\r\n");
		utenteLabel.setBounds(10, 27, 85, 14);
		frmMascheraConnessione.getContentPane().add(utenteLabel);
		
		final JLabel passwordLabel = new JLabel("Password\r\n");
		passwordLabel.setBounds(10, 52, 85, 14);
		frmMascheraConnessione.getContentPane().add(passwordLabel);
		
		final JLabel portaLabel = new JLabel("Porta\r\n");
		portaLabel.setBounds(10, 77, 85, 14);
		frmMascheraConnessione.getContentPane().add(portaLabel);
		
		final JLabel serverLabel = new JLabel("Server\r\n");
		serverLabel.setBounds(10, 102, 85, 14);
		frmMascheraConnessione.getContentPane().add(serverLabel);
		
		final JLabel databaseLabel = new JLabel("Database\r\n");
		databaseLabel.setBounds(10, 127, 85, 14);
		frmMascheraConnessione.getContentPane().add(databaseLabel);
		
		JButton btnNewButton = new JButton("Salva\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connettore primaConnessioneConnettore = new Connettore();
				
			FileProperties fileppp = new FileProperties();				
				fileppp.key = new ArrayList<String>();
				fileppp.value = new ArrayList<String>();
			
				fileppp.key.add(utenteLabel.getText() );
				fileppp.key.add (passwordLabel.getText());
				fileppp.key.add (portaLabel.getText());
				fileppp.key.add (serverLabel.getText());
				fileppp.key.add (databaseLabel.getText());
				fileppp.value.add(utenteField.getText());
				fileppp.value.add(passwordField.getText());
				fileppp.value.add(portaField.getText());
				fileppp.value.add(serverField.getText());
				fileppp.value.add(databaseField.getText());			
				
				fileppp.initialize();
				
				int i = 0;
				i = Integer.parseInt(portaField.getText());
				try {
					primaConnessione  = primaConnessioneConnettore.primaConnessione(utenteField.getText(), passwordField.getText(), i, serverField.getText(), databaseField.getText());
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					frmMascheraConnessione.dispose();
				PaginaIniziale tabella;
				try {
					tabella = new PaginaIniziale();
					tabella.con = primaConnessione ;
					tabella.initialize(); 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(68, 166, 138, 23);
		frmMascheraConnessione.getContentPane().add(btnNewButton);
		
		utenteField = new JTextField();
		utenteField.setBounds(68, 24, 140, 20);
		frmMascheraConnessione.getContentPane().add(utenteField);
		utenteField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(68, 52, 140, 20);
		frmMascheraConnessione.getContentPane().add(passwordField);
		
		portaField = new JTextField();
		portaField.setColumns(10);
		portaField.setBounds(68, 77, 140, 20);
		frmMascheraConnessione.getContentPane().add(portaField);
		
		serverField = new JTextField();
		serverField.setColumns(10);
		serverField.setBounds(68, 102, 140, 20);
		frmMascheraConnessione.getContentPane().add(serverField);
		
		databaseField = new JTextField();
		databaseField.setColumns(10);
		databaseField.setBounds(68, 127, 140, 20);
		frmMascheraConnessione.getContentPane().add(databaseField);
		frmMascheraConnessione.setVisible(true);
	}
}
