package Recepcja;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Start.Mquery;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.annotation.processing.Messager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class NowaWizytaLekarz extends JFrame {

	private static Mquery messenger;
	private JScrollPane sp ;
	private JPanel contentPane;
	private JPanel contentPane2;
	private JTextField dzien;
	private JTextField miesiac;
	private JTextField rok;
	private JTextField nazwiskoLekarza;
	private String komunikat;
	private boolean czyJest;
	private JTextField imie;
	int[] godziny;
	private JTextField wprowadzonaGodzina;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NowaWizytaLekarz frame = new NowaWizytaLekarz();
					messenger = new Mquery();
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
	public NowaWizytaLekarz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
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
		
		JLabel lblPodajImiLekarza = new JLabel("Podaj numer identyfikacyjny lekarza:");
		lblPodajImiLekarza.setBounds(48, 202, 345, 16);
		contentPane.add(lblPodajImiLekarza);
		
		JLabel lblNazwisko = new JLabel("ID lekarza");
		lblNazwisko.setBounds(48, 232, 121, 16);
		contentPane.add(lblNazwisko);
		
		nazwiskoLekarza = new JTextField();
		nazwiskoLekarza.setColumns(10);
		nazwiskoLekarza.setBounds(167, 227, 130, 26);
		contentPane.add(nazwiskoLekarza);
		
		JLabel lblWolneGodziny = new JLabel("Wolne godziny:");
		lblWolneGodziny.setBounds(167, 306, 103, 16);
		//contentPane.add(lblWolneGodziny);
		
		JTextArea godziny1 = new JTextArea();
		godziny1.setBounds(167, 334, 103, 42);
		//contentPane.add(godziny1);
		
		JTextField wprowadzonaGodzina = new JTextField();
		wprowadzonaGodzina.setBounds(167, 388, 103, 26);
		//contentPane.add(wprowadzonaGodzina);
		wprowadzonaGodzina.setColumns(10);
		
		JLabel lblGodzina = new JLabel("Godzina:");
		lblGodzina.setBounds(94, 393, 61, 16);
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
				String idLekarza = nazwiskoLekarza.getText() ;
				String idPacjenta = imie.getText();
				String godzina = wprowadzonaGodzina.getText();
				
				
				String query = "INSERT INTO Wizyta (Data_Wizyty,Lekarz,Pacjent) "
						+ "VALUES ('"+r+"-"+m+"-"+d + " "+godzina+":00:00'," + idLekarza + ","+idPacjenta+")";
				
				System.out.println(query);
				Mquery.update(query);
				setVisible(false);
			}
		});
		btnZatwierd.setBounds(167, 419, 130, 29);
		//contentPane.add(btnZatwierd);
		
		JButton ok = new JButton("ok");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String d = dzien.getText();
				String m = miesiac.getText();
				String r = rok.getText();
				String idLekarza = nazwiskoLekarza.getText() ;
				
				String query = "Select HOUR(Data_Wizyty) as godzina from Wizyta WHERE Lekarz = " + idLekarza + " and DATE(Data_Wizyty) = '" + r + "-" + m + "-" + d +"'" ;
				
				Mquery.main();
				ResultSet rs = Mquery.query(query);
				
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
					sp.setBounds(167, 334, 103, 42);
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
				
				
//				contentPane.removeAll();
//				contentPane.add(contentPane2);
//				contentPane.revalidate(); 
//				contentPane.repaint();
			}
		});
		ok.setBounds(170, 265, 100, 29);
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
		btnWr.setBounds(307, 426, 117, 29);
		contentPane.add(btnWr);
		
	
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 6, 383, 310);
		
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
	}
}
