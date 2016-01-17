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

public class ZarobkiLekarza extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField pensja;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZarobkiLekarza frame = new ZarobkiLekarza();
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
	public ZarobkiLekarza() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdLekarza = new JLabel("ID lekarza:");
		lblIdLekarza.setBounds(91, 62, 85, 16);
		contentPane.add(lblIdLekarza);
		
		JLabel lblPensja = new JLabel("Pensja:");
		lblPensja.setBounds(91, 90, 85, 16);
		contentPane.add(lblPensja);
		
		id = new JTextField();
		id.setBounds(188, 57, 109, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		pensja = new JTextField();
		pensja.setColumns(10);
		pensja.setBounds(188, 85, 109, 26);
		contentPane.add(pensja);
		
		JButton btnNewButton = new JButton("Zatwierdź");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idLekarza = id.getText();
				String pen = pensja.getText();
				String query = "UPDATE Zarobki SET Miesiecznie = '" + pen + "' WHERE id_pracownika = " + idLekarza + " AND profesja = 'lekarz'";
				System.out.println(query);
				
				Mquery.main();
				Mquery.update(query);
				
				JOptionPane.showMessageDialog(contentPane, "Zmiany zostaly wprowadzone");
				setVisible(false);
			}
		});
		btnNewButton.setBounds(160, 218, 130, 29);
		contentPane.add(btnNewButton);
		
		JButton btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(333, 243, 117, 29);
		contentPane.add(btnWr);
	}
}
