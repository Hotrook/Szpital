package Kadry;

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

public class DodajLekarza extends JFrame {

	private JPanel contentPane;
	private JTextField specjalizacja1;
	private JTextField stopien;
	private JTextField nazwisko;
	private JTextField imie;
	private JButton btnOk;
	private JButton btnWr;
	private JTextField pensja;
	private JLabel lblStanowisko;
	private JTextField stanowisko;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajLekarza frame = new DodajLekarza();
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
	public DodajLekarza() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPodajDane = new JLabel("Podaj dane:");
		lblPodajDane.setBounds(173, 6, 100, 16);
		contentPane.add(lblPodajDane);
		
		JLabel lblImie = new JLabel("Imie:");
		lblImie.setBounds(64, 42, 61, 16);
		contentPane.add(lblImie);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(64, 70, 73, 16);
		contentPane.add(lblNazwisko);
		
		JLabel lblSpecjalizacja = new JLabel("Stopien:");
		lblSpecjalizacja.setBounds(64, 98, 90, 16);
		contentPane.add(lblSpecjalizacja);
		
		JLabel lblCzwarteGwno = new JLabel("Specjalizacja:");
		lblCzwarteGwno.setBounds(64, 126, 117, 16);
		contentPane.add(lblCzwarteGwno);
		
		specjalizacja1 = new JTextField();
		specjalizacja1.setBounds(203, 121, 130, 26);
		contentPane.add(specjalizacja1);
		specjalizacja1.setColumns(10);
		
		stopien = new JTextField();
		stopien.setBounds(203, 93, 130, 26);
		contentPane.add(stopien);
		stopien.setColumns(10);
		
		nazwisko = new JTextField();
		nazwisko.setBounds(203, 65, 130, 26);
		contentPane.add(nazwisko);
		nazwisko.setColumns(10);
		
		imie = new JTextField();
		imie.setBounds(203, 37, 130, 26);
		contentPane.add(imie);
		imie.setColumns(10);
		
		btnOk = new JButton("ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String im = imie.getText();
				String nazw = nazwisko.getText();
				String stop = stopien.getText();
				String spec = specjalizacja1.getText();
				String stan = stanowisko.getText();
				String zar = pensja.getText();
				
				String query = "INSERT INTO Lekarz (Imie,Nazwisko,Stopien,Specjalizacja) VALUES ('"+ im + "','"+nazw+"','"+stop+"','"+spec+"')";
				System.out.println(query);
				
				Mquery.main();
				Mquery.update(query);
				
				query = "SELECT MAX(ID) FROM Lekarz";
				System.out.println(query);
				
				Mquery.main();
				ResultSet rs = Mquery.query(query);
				
				String id = null;
				
				try {
					if(rs.next()){
						id = rs.getString(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				query = "INSERT INTO Zarobki (id_pracownika, Profesja, Stanowisko,Miesiecznie) VALUES ("+ id + ",'lekarz','"+stan+"'," + zar+")";
				System.out.println(query);
				
				Mquery.main();
				Mquery.update(query);
				
				JOptionPane.showMessageDialog(contentPane, "Lekarz dodany");
				setVisible(false);
			}
		});
		btnOk.setBounds(161, 217, 117, 29);
		contentPane.add(btnOk);
		
		btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(327, 232, 117, 29);
		contentPane.add(btnWr);
		
		JLabel lblPensja = new JLabel("Pensja:");
		lblPensja.setBounds(64, 154, 117, 16);
		contentPane.add(lblPensja);
		
		pensja = new JTextField();
		pensja.setColumns(10);
		pensja.setBounds(203, 149, 130, 26);
		contentPane.add(pensja);
		
		lblStanowisko = new JLabel("Stanowisko:");
		lblStanowisko.setBounds(64, 182, 117, 16);
		contentPane.add(lblStanowisko);
		
		stanowisko = new JTextField();
		stanowisko.setColumns(10);
		stanowisko.setBounds(203, 177, 130, 26);
		contentPane.add(stanowisko);
	}
}
