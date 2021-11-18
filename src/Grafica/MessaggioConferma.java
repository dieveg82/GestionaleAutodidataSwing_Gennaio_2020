package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessaggioConferma {

	public JFrame frmMessaggioConferma;
	public JLabel lblNewLabel ;

	public MessaggioConferma() {
		initialize();
	}


	private void initialize() {
		frmMessaggioConferma = new JFrame();
		frmMessaggioConferma.setTitle("Gestionale .....");
		frmMessaggioConferma.setBounds(500, 300, 248, 169);
		frmMessaggioConferma.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmMessaggioConferma.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Operazione avvenuta con successo !!");
		lblNewLabel.setBounds(37, 28, 187, 43);
		frmMessaggioConferma.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMessaggioConferma.dispose();
			}
		});
		btnNewButton.setBounds(74, 82, 89, 23);
		frmMessaggioConferma.getContentPane().add(btnNewButton);
		frmMessaggioConferma.setVisible(true);
	}

}
