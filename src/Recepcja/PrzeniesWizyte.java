package Recepcja;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Start.Mquery;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrzeniesWizyte extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;
	private JTextField dzien;
	private JTextField miesiac;
	private JTextField rok;
	private JTextField id;
	private String komunikat;
	private boolean czyJest;
	private JTextField godzina;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrzeniesWizyte frame = new PrzeniesWizyte();
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
	public PrzeniesWizyte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(null);
		
		JLabel dzienLabel = new JLabel("Dzień:");
		dzienLabel.setBounds(94, 59, 61, 16);
		contentPane.add(dzienLabel);
		
		JLabel miesiacLabel = new JLabel("Miesiąc:");
		miesiacLabel.setBounds(94, 87, 61, 16);
		contentPane.add(miesiacLabel);
		
		JLabel rokLabel = new JLabel("Rok:");
		rokLabel.setBounds(94, 113, 61, 16);
		contentPane.add(rokLabel);
		
		dzien = new JTextField();
		dzien.setBounds(167, 54, 130, 26);
		contentPane.add(dzien);
		dzien.setColumns(10);
		
		miesiac = new JTextField();
		miesiac.setBounds(167, 82, 130, 26);
		contentPane.add(miesiac);
		miesiac.setColumns(10);
		
		rok = new JTextField();
		rok.setBounds(167, 108, 130, 26);
		contentPane.add(rok);
		rok.setColumns(10);
		
		JLabel lblPodajDatWizyty = new JLabel("Podaj datę wizyty:");
		lblPodajDatWizyty.setBounds(48, 31, 345, 16);
		contentPane.add(lblPodajDatWizyty);
		
		JLabel lblPodajImiLekarza = new JLabel("Podaj identyfikator lekarza");
		lblPodajImiLekarza.setBounds(48, 176, 345, 16);
		contentPane.add(lblPodajImiLekarza);
		
		JLabel Imie = new JLabel("ID lekarza:");
		Imie.setBounds(94, 200, 75, 16);
		contentPane.add(Imie);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(167, 195, 130, 26);
		contentPane.add(id);
		
		JButton ok = new JButton("ok");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = Integer.parseInt(dzien.getText());
				int m = Integer.parseInt(miesiac.getText());
				int r = Integer.parseInt(rok.getText());
				int g = Integer.parseInt(godzina.getText());
				String idLekarza = id.getText();
				String query =  "SELECT DATE(Data_Wizyty) , HOUR(Data_Wizyty) FROM Wizyta where Lekarz = " + idLekarza + " SORT BY Data_Wizyty LIMIT 1";
				System.out.println(query);
				Mquery.main();
				ResultSet rs = Mquery.update(query);
				String g2 = null;
				String nowaData;
				try {
					rs.next();
					nowaData = rs.getString(1);
					rs.next();
					g2 = rs.getString(2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if( Integer.parseInt(g2) == 19 ) {
					g2 = "08";
					//nowaData
				}
				
				// todo: 
				// wysłanie do sql glupiego
				// odebranie 
				// komunikat
				query = "DELETE FROM Wizyta WHERE Data_Wizyty = '" + r + "-" + m + "-" + d + " " + g + ":00:00' AND Lekarz = " + idLekarza;
				System.out.println(query);
				Mquery.main();
				Mquery.update(query);
				dzien.setText("");
				miesiac.setText("");
				rok.setText("");
				//setContentPane(contentPane2);
			}
		});
		ok.setBounds(170, 265, 100, 29);
		contentPane.add(ok);
		
		godzina = new JTextField();
		godzina.setColumns(10);
		godzina.setBounds(167, 136, 130, 26);
		contentPane.add(godzina);
		
		JLabel Godzina = new JLabel("Godzina:");
		Godzina.setBounds(94, 141, 61, 16);
		contentPane.add(Godzina);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 6, 383, 310);
		
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
	}
}
