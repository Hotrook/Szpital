package Recepcja;

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

public class WypiszPacjenta extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane2;
	private JTextField imie;
	private JTextField nazwisko;
	private String komunikat;
	private boolean czyJest;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WypiszPacjenta frame = new WypiszPacjenta();
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
	public WypiszPacjenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(null);
		
		JLabel imieLabel = new JLabel("Imię:");
		imieLabel.setBounds(94, 59, 61, 16);
		contentPane.add(imieLabel);
		
		JLabel nazwiskoLabel = new JLabel("Nazwisko:");
		nazwiskoLabel.setBounds(94, 87, 75, 16);
		contentPane.add(nazwiskoLabel);
		
		imie = new JTextField();
		imie.setBounds(167, 54, 130, 26);
		contentPane.add(imie);
		imie.setColumns(10);
		
		nazwisko = new JTextField();
		nazwisko.setBounds(167, 82, 130, 26);
		contentPane.add(nazwisko);
		nazwisko.setColumns(10);
		
		JLabel danePacjenta = new JLabel("Podaj dane pacjenta:");
		danePacjenta.setBounds(48, 31, 345, 16);
		contentPane.add(danePacjenta);
		
		JButton btnOk = new JButton("ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String im = imie.getText();
				String nazw = nazwisko.getText();
				
				String query = "DELETE FROM Pacjent WHERE Imie = '" + im + "' AND Nazwisko = '"+ nazw +"'";
				System.out.println(query);
				Mquery.main();
				Mquery.update(query);
				JOptionPane.showMessageDialog(contentPane, "Pacjent wypisany");
				setVisible(false);
			}
		});
		btnOk.setBounds(175, 135, 100, 29);
		contentPane.add(btnOk);
		
		JButton btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(312, 153, 117, 29);
		contentPane.add(btnWr);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 6, 383, 310);
		
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
	}
}
