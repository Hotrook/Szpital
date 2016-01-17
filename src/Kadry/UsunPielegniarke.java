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

public class UsunPielegniarke extends JFrame {

	private JPanel contentPane;
	private JTextField nazwisko;
	private JTextField imie;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsunPielegniarke frame = new UsunPielegniarke();
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
	public UsunPielegniarke() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPodajDane = new JLabel("Podaj dane:");
		lblPodajDane.setBounds(184, 6, 82, 16);
		contentPane.add(lblPodajDane);
		
		JLabel lblImie = new JLabel("Imie:");
		lblImie.setBounds(93, 66, 82, 16);
		contentPane.add(lblImie);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(93, 94, 82, 16);
		contentPane.add(lblNazwisko);
		
		nazwisko = new JTextField();
		nazwisko.setBounds(184, 89, 130, 26);
		contentPane.add(nazwisko);
		nazwisko.setColumns(10);
		
		imie = new JTextField();
		imie.setBounds(184, 61, 130, 26);
		contentPane.add(imie);
		imie.setColumns(10);
		
		JButton btnOk = new JButton("Usuń");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String im = imie.getText();
				String nazw = nazwisko.getText();
				String query = "DELETE FROM Pielegniarka WHERE Imie = '" + im +"' AND Nazwisko = '" + nazw + "'";
				System.out.println(query);
				
				Mquery.main();
				Mquery.update(query);
				
				JOptionPane.showMessageDialog(contentPane, "Pielegniarka usunięta");
				setVisible(false);
			}
		});
		btnOk.setBounds(165, 189, 120, 29);
		contentPane.add(btnOk);
		
		JButton btnWr = new JButton("Wróć");
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
