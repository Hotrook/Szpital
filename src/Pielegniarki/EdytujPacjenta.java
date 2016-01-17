package Pielegniarki;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Start.Mquery;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EdytujPacjenta extends JFrame {

	private JPanel contentPane;
	private JTextField sala;
	private JTextField nazwisko;
	private JTextField imie;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EdytujPacjenta frame = new EdytujPacjenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EdytujPacjenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImi = new JLabel("Imię:");
		lblImi.setBounds(92, 68, 61, 16);
		contentPane.add(lblImi);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(92, 96, 74, 16);
		contentPane.add(lblNazwisko);
		
		JLabel lblChoroba = new JLabel("Sala:");
		lblChoroba.setBounds(92, 124, 61, 16);
		contentPane.add(lblChoroba);
		
		sala = new JTextField();
		sala.setBounds(200, 119, 130, 26);
		contentPane.add(sala);
		sala.setColumns(10);
		
		nazwisko = new JTextField();
		nazwisko.setBounds(200, 91, 130, 26);
		contentPane.add(nazwisko);
		nazwisko.setColumns(10);
		
		imie = new JTextField();
		imie.setBounds(200, 63, 130, 26);
		contentPane.add(imie);
		imie.setColumns(10);
		
		JButton btnNewButton = new JButton("Wyszukaj");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String im = imie.getText();
				String nazw = nazwisko.getText();
				String query = "SELECT Sala FROM Pacjent WHERE Imie = '" + im + "' AND Nazwisko = '" + nazw + "'";
				System.out.println(query);
				
				Mquery.main();
				ResultSet rs = Mquery.query(query);
				
				String sala1 = null;
				
				try {
					if( rs.next() ){
						sala1 = rs.getString(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				sala.setText(sala1);
				
			}
		});
		btnNewButton.setBounds(353, 91, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edytuj");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String im = imie.getText();
				String nazw = nazwisko.getText();
				String sala1 = sala.getText();
				String query = "UPDATE Pacjent SET Sala = "+ sala1 + " WHERE Imie = '" + im + "' AND Nazwisko = '" + nazw + "'";
				System.out.println(query);
				
				Mquery.main();
				Mquery.update(query);
				
				JOptionPane.showMessageDialog(contentPane, "Zmiany zostaly wprowadzone");
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(235, 274, 130, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblEdycjaPacjenta = new JLabel("Edycja pacjenta:");
		lblEdycjaPacjenta.setBounds(235, 6, 130, 16);
		contentPane.add(lblEdycjaPacjenta);
		
		JButton btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(477, 329, 117, 29);
		contentPane.add(btnWr);
	}

}
