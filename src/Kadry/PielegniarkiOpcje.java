package Kadry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PielegniarkiOpcje extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PielegniarkiOpcje frame = new PielegniarkiOpcje();
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
	public PielegniarkiOpcje() {
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
				DodajPielegniarke.main();
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
				UsunPielegniarke.main();
				setVisible(false);
			}
		});
		btnUsuLekarza.setBounds(150, 105, 150, 29);
		contentPane.add(btnUsuLekarza);
		
		JButton btnZmieZarobkiLub = new JButton("Zmień zarobki lub premię");
		btnZmieZarobkiLub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Zarobki.main();
				setVisible(false);
			}
		});
		btnZmieZarobkiLub.setBounds(130, 162, 190, 29);
		contentPane.add(btnZmieZarobkiLub);
		
		JButton btnWr = new JButton("Wróć");
		btnWr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnWr.setBounds(327, 227, 117, 29);
		contentPane.add(btnWr);
	}

}
