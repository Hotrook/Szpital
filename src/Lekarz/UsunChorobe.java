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

public class UsunChorobe extends JFrame {

	private JPanel contentPane;
	private JTextField nazwa;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsunChorobe frame = new UsunChorobe();
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
	public UsunChorobe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPodajDane = new JLabel("Choroba");
		lblPodajDane.setBounds(209, 6, 81, 16);
		contentPane.add(lblPodajDane);
		
		JLabel lblNazwa = new JLabel("Nazwa:");
		lblNazwa.setBounds(149, 91, 81, 16);
		contentPane.add(lblNazwa);
		
		nazwa = new JTextField();
		nazwa.setBounds(239, 86, 130, 26);
		contentPane.add(nazwa);
		nazwa.setColumns(10);
		
		JButton ok = new JButton("Usuń");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nazw = nazwa.getText();
				String query = "DELETE FROM Choroba WHERE Nazwa = '" + nazw + "'";
				System.out.println(query);
				
				Mquery.main();
				Mquery.update(query);
				
				JOptionPane.showMessageDialog(contentPane, "Choroba usunieta");
				setVisible(false);
			}
		});
		ok.setBounds(185, 180, 130, 29);
		contentPane.add(ok);
		
		JButton btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(377, 227, 117, 29);
		contentPane.add(btnWr);
	}

}
