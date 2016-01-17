package Lekarz;

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

public class PrzeniesDoProsektorium extends JFrame {

	private JPanel contentPane;
	private JTextField nazwisko;
	private JTextField imie;
	private JButton btnWr;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrzeniesDoProsektorium frame = new PrzeniesDoProsektorium();
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
	public PrzeniesDoProsektorium() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImi = new JLabel("Imię:");
		lblImi.setBounds(71, 63, 61, 16);
		contentPane.add(lblImi);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(71, 91, 80, 16);
		contentPane.add(lblNazwisko);
		
		nazwisko = new JTextField();
		nazwisko.setBounds(194, 86, 130, 26);
		contentPane.add(nazwisko);
		nazwisko.setColumns(10);
		
		imie = new JTextField();
		imie.setBounds(194, 58, 130, 26);
		contentPane.add(imie);
		imie.setColumns(10);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String im = imie.getText();
				String nazw = nazwisko.getText();
				String query = "SELECT id FROM Pacjent WHERE Imie = '" + im + "' AND Nazwisko = '" + nazw + "'";
				System.out.println(query);
				
				Mquery.main();
				ResultSet rs = Mquery.query(query);
				
				String id = null ;
				try {
					rs.next();
					id = rs.getString(1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				query = "DELETE FROM Pacjent WHERE Imie = '" + im + "' AND Nazwisko = '" +nazw + "'";
				System.out.println(query);
				
				Mquery.main();
				Mquery.update(query);
				
				query = "INSERT INTO Kostnica (id) VALUES ("+id+")";
				System.out.println(query);
				
				Mquery.main();
				Mquery.update(query);
				
				JOptionPane.showMessageDialog(contentPane, "Pacjent przeniesiony");
				
				setVisible(false);
				
				
			}
		});
		btnNewButton.setBounds(160, 171, 130, 29);
		contentPane.add(btnNewButton);
		
		btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(327, 225, 117, 29);
		contentPane.add(btnWr);
	}

}
