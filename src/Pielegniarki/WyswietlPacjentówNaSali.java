package Pielegniarki;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Start.Mquery;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class WyswietlPacjentówNaSali extends JFrame {

	private JPanel contentPane;
	private JTextField sala;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WyswietlPacjentówNaSali frame = new WyswietlPacjentówNaSali();
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
	public WyswietlPacjentówNaSali() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPodajNumerSali = new JLabel("Podaj numer sali: ");
		lblPodajNumerSali.setBounds(66, 36, 141, 16);
		contentPane.add(lblPodajNumerSali);
		
		sala = new JTextField();
		sala.setBounds(208, 31, 170, 26);
		contentPane.add(sala);
		sala.setColumns(10);
		
		JButton btnWyszukaj = new JButton("Wyszukaj");
		btnWyszukaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sala1 = sala.getText();
				String query = "SELECT Imie,Nazwisko,Sala FROM Pacjent WHERE Sala = '" + sala1 + "'";
				System.out.println(query);
				
				Mquery.main();
				ResultSet rs = Mquery.query(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
		});
		btnWyszukaj.setBounds(401, 31, 130, 29);
		contentPane.add(btnWyszukaj);
		
		JButton btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(235, 295, 130, 29);
		contentPane.add(btnWr);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 98, 400, 134);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
