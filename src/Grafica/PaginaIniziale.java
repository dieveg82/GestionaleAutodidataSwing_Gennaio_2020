package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ConnessioneDatabase.Connettore;
import Query.QueryDatabase;
import Query.QueryFattura;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.Query;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

public class PaginaIniziale {

	private JFrame frmPaginaIniziale;
	public InserimentoClienti anagraficaClienti;
	public ResultSet resultSet;
	public DefaultTableModel dtmPaginaIniziale;
	public Connection con;
	public PaginaIniziale() throws SQLException {
		Connettore connettore = new Connettore();
		try {
			connettore.connessione();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
			
		
	}

	
	public void initialize() throws SQLException {
		frmPaginaIniziale = new JFrame();
		frmPaginaIniziale.setTitle("Gestionale");
		frmPaginaIniziale.setBounds(400, 200, 417, 279);
		frmPaginaIniziale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaginaIniziale.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestionale");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(59, 45, 266, 39);
		frmPaginaIniziale.getContentPane().add(lblNewLabel);
		
		frmPaginaIniziale.setVisible(true);
		
		JButton btnNewButton = new JButton("Inserisci Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserimentoClienti anagrafica = new InserimentoClienti ();
				anagrafica.initialize();
				
			}
		});
		btnNewButton.setBounds(59, 106, 137, 23);
		frmPaginaIniziale.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fattura");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFattura menuFattura;
				try {
					menuFattura = new MenuFattura();
					QueryFattura queryFattura  = new QueryFattura();
					try {
						menuFattura.initialize();
						resultSet = queryFattura.selezioneFattura();
						menuFattura.dtmDefaultTableModel(resultSet);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
				
			}
		});
		btnNewButton_1.setBounds(206, 106, 131, 23);
		frmPaginaIniziale.getContentPane().add(btnNewButton_1);
		
		JButton btnAnagrafica = new JButton("Anagrafica");
		btnAnagrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anagrafica anagrafica = new Anagrafica();
				QueryDatabase inserimentoAnagrafica = new QueryDatabase();
				try {
					anagrafica.initialize();
					resultSet = inserimentoAnagrafica.selezioneAnagrafica();
					anagrafica.dtmDefaultTableModel(resultSet);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnAnagrafica.setBounds(59, 140, 137, 23);
		frmPaginaIniziale.getContentPane().add(btnAnagrafica);
		
		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Agenda agenda = new Agenda();
				agenda.inserimentoGiorniDefaultTableModel();
				agenda.dtmTableModel.getTableModelListeners();
			}
		});
		btnAgenda.setBounds(206, 140, 131, 23);
		frmPaginaIniziale.getContentPane().add(btnAgenda);
	}
}