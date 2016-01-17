package Recepcja;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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

public class NowaWizytaSpecjalista extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;
	private JTextField dzien;
	private JTextField miesiac;
	private JTextField rok;
	private JTextField specjalista;
	private JScrollPane sp;
	private String komunikat;
	private String idLekarza;
	private boolean czyJest;
	private JTextField imie;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NowaWizytaSpecjalista frame = new NowaWizytaSpecjalista();
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
	public NowaWizytaSpecjalista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 462);
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
		
		JLabel lblPodajImiLekarza = new JLabel("Podaj specjaliste");
		lblPodajImiLekarza.setBounds(48, 174, 345, 16);
		contentPane.add(lblPodajImiLekarza);
		
		JLabel Specjalista = new JLabel("Specjalista");
		Specjalista.setBounds(94, 202, 75, 16);
		contentPane.add(Specjalista);
		
		specjalista = new JTextField();
		specjalista.setColumns(10);
		specjalista.setBounds(167, 197, 130, 26);
		contentPane.add(specjalista);
		
		JLabel lblWolneGodziny = new JLabel("Wolne godziny:");
		lblWolneGodziny.setBounds(167, 271, 103, 16);
		//contentPane.add(lblWolneGodziny);
		
		JTextArea godziny1 = new JTextArea();
		godziny1.setBounds(167, 299, 103, 42);
		//contentPane.add(godziny1);
		
		JTextField wprowadzonaGodzina = new JTextField();
		wprowadzonaGodzina.setBounds(167, 353, 103, 26);
		//contentPane.add(wprowadzonaGodzina);
		wprowadzonaGodzina.setColumns(10);
		
		JLabel lblGodzina = new JLabel("Godzina:");
		lblGodzina.setBounds(94, 358, 61, 16);
		//contentPane.add(lblGodzina);
		
		
		JButton btnZatwierd = new JButton("Zatwierdź");
		//contentPane.add(btnZatwierd);
		btnZatwierd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("tu jestem");
				String d = dzien.getText();
				String m = miesiac.getText();
				String r = rok.getText();
				String specjalizacja = specjalista.getText();
				String idPacjenta = imie.getText();
				String godzina = wprowadzonaGodzina.getText();
				
				
				String query = "INSERT INTO Wizyta (Data_Wizyty,Lekarz,Pacjent) "
						+ "VALUES ('"+r+"-"+m+"-"+d + " "+godzina+":00:00'," + idLekarza + ","+idPacjenta+")";
				
				System.out.println(query);
				Mquery.update(query);
				setVisible(false);
			}
		});
		btnZatwierd.setBounds(167, 391, 103, 29);
		//contentPane.add(btnZatwierd);
		JButton ok = new JButton("ok");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String d = dzien.getText();
				String m = miesiac.getText();
				String r = rok.getText();
				String specjalizacja = specjalista.getText() ;
				String query = "SELECT id FROM Lekarz WHERE Specjalizacja = '" + specjalizacja + "'";
				System.out.println(query);
				String id = null;
				
				Mquery.main();
				ResultSet rs = Mquery.query(query);
				try {
					if( rs.next()){
						id = rs.getString(1);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				idLekarza = id;
				query = "Select HOUR(Data_Wizyty) as godzina from Wizyta WHERE Lekarz = " + id + " and DATE(Data_Wizyty) = '" + r + "-" + m + "-" + d +"'" ;
				
				Mquery.main();
				rs = Mquery.query(query);
				
				int[] godziny = {8,9,10,11,12,13,14,15,16,17,18,19};
				
				
				if( rs == null){
					JOptionPane.showMessageDialog(contentPane, "Brak wolnych terminów");
					dzien.setText("");
					miesiac.setText("");
					rok.setText("");
				}
				else{
					System.out.println("tu jestme");
					contentPane.add(lblGodzina);
					contentPane.add(lblWolneGodziny);
					contentPane.add(wprowadzonaGodzina);
					contentPane.add(btnZatwierd);
					sp = new JScrollPane(godziny1);
					sp.setBounds(167, 299, 103, 42);
					contentPane.add(sp);
					contentPane.revalidate(); 
 					contentPane.repaint();
					
					int wolne = 0;
					try {
						while(rs.next()){
							wolne = Integer.parseInt(rs.getString(1));
							godziny[wolne-8] = 0;
 						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					for( int i = 0 ; i < 12 ; ++i) {
						if( godziny[i] != 0 ){
							godziny1.setText(godziny1.getText() + godziny[i] + "\n"); 
						}
					}
//					
				}
			}
		});
		ok.setBounds(167, 230, 100, 29);
		contentPane.add(ok);
		
		imie = new JTextField();
		imie.setColumns(10);
		imie.setBounds(167, 136, 130, 26);
		contentPane.add(imie);
		
		JLabel lblImi = new JLabel("ID pacjenta:");
		lblImi.setBounds(94, 141, 75, 16);
		contentPane.add(lblImi);
		
		JButton btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(318, 391, 117, 29);
		contentPane.add(btnWr);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 6, 383, 310);
		
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
	}

}
