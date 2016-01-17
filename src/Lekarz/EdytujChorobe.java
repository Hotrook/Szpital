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

public class EdytujChorobe extends JFrame {

	private JPanel contentPane;
	private JTextField stopien;
	private JTextField nazwa;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EdytujChorobe frame = new EdytujChorobe();
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
	public EdytujChorobe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPodajDane = new JLabel("Choroba");
		lblPodajDane.setBounds(209, 6, 81, 16);
		contentPane.add(lblPodajDane);
		
		JLabel lblNazwa = new JLabel("Nazwa:");
		lblNazwa.setBounds(81, 91, 81, 16);
		contentPane.add(lblNazwa);
		
		JLabel lblStopieZagroenia = new JLabel("Stopień zagrożenia");
		lblStopieZagroenia.setBounds(81, 119, 146, 16);
		contentPane.add(lblStopieZagroenia);
		
		stopien = new JTextField();
		stopien.setBounds(239, 114, 130, 26);
		contentPane.add(stopien);
		stopien.setColumns(10);
		
		nazwa = new JTextField();
		nazwa.setBounds(239, 86, 130, 26);
		contentPane.add(nazwa);
		nazwa.setColumns(10);
		
		JButton ok = new JButton("Edytuj");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nazw = nazwa.getText();
				String stop = stopien.getText();
				String query = "UPDATE Choroba SET Stopien_Zagrozenia = " + stop + " WHERE Nazwa  = '" + nazw + "'";
				System.out.println(query);
				
				Mquery.main();
				Mquery.update(query);
				
				JOptionPane.showMessageDialog(contentPane, "Chroba edytowana");
				setVisible(false);
			}
		});
		
		ok.setBounds(185, 269, 130, 29);
		contentPane.add(ok);
		
		JButton btnWyszukaj = new JButton("Wyszukaj");
		btnWyszukaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nazw = nazwa.getText();
				String query = "SELECT Stopien_Zagrozenia FROM Choroba WHERE Nazwa = '" + nazw + "'";
				System.out.println(query);
				
				Mquery.main();
				ResultSet rs = Mquery.query(query);
				
				String stop = null;
				
				try {
					if( rs.next() ){
						stop = rs.getString(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				stopien.setText(stop);
			}
		});
		btnWyszukaj.setBounds(364, 86, 130, 29);
		contentPane.add(btnWyszukaj);
		
		JButton btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(364, 314, 117, 29);
		contentPane.add(btnWr);
	}

}
