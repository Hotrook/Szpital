package Kadry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LekarzeOpcje extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LekarzeOpcje frame = new LekarzeOpcje();
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
	public LekarzeOpcje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DodajLekarza.main();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(150, 50, 150, 29);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Dodaj lekarza");
		button.setBounds(150, 50, 150, 29);
		contentPane.add(button);
		
		JButton btnUsuLekarza = new JButton("Usuń");
		btnUsuLekarza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UsunLekarza.main();
				setVisible(false);
			}
		});
		btnUsuLekarza.setBounds(150, 105, 150, 29);
		contentPane.add(btnUsuLekarza);
		
		JButton btnZmieZarobkiLub = new JButton("Zmień zarobki");
		btnZmieZarobkiLub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ZarobkiLekarza.main();
				setVisible(false);
			}
		});
		btnZmieZarobkiLub.setBounds(150, 162, 150, 29);
		contentPane.add(btnZmieZarobkiLub);
		
		JButton btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(312, 221, 117, 29);
		contentPane.add(btnWr);
	}

}
