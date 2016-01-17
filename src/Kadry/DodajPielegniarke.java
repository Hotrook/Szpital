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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DodajPielegniarke extends JFrame {

	private JPanel contentPane;
	private JTextField nazwisko;
	private JTextField imie;
	private JButton btnOk;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajPielegniarke frame = new DodajPielegniarke();
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
	public DodajPielegniarke() {
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
				
				String query = "INSERT INTO Pielegniarka (Imie,Nazwisko) VALUES ('"+ im + "','"+nazw+"')";
				System.out.println(query);
				
				Mquery.main();
				Mquery.update(query);
				
				JOptionPane.showMessageDialog(contentPane, "Pielegniarka dodana");
				setVisible(false);
			}
		});
		btnOk.setBounds(161, 190, 117, 29);
		contentPane.add(btnOk);
		
		btnNewButton = new JButton("Wróć");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(327, 243, 117, 29);
		contentPane.add(btnNewButton);
	}

}
