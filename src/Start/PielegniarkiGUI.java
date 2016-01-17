package Start;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Pielegniarki.EdytujPacjenta;
import Pielegniarki.WyswietlPacjentówNaSali;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PielegniarkiGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PielegniarkiGUI frame = new PielegniarkiGUI();
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
	public PielegniarkiGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton sala = new JButton("Wyświetl pacjentów na sali");
		sala.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WyswietlPacjentówNaSali.main();
			}
		});
		sala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sala.setBounds(150, 218, 300, 53);
		contentPane.add(sala);
		
		JButton btnEdytujSalPacjenta = new JButton("Edytuj salę pacjenta");
		btnEdytujSalPacjenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EdytujPacjenta.main();
			}
		});
		btnEdytujSalPacjenta.setBounds(150, 103, 300, 53);
		contentPane.add(btnEdytujSalPacjenta);
		
		JButton btnZamknij = new JButton("Zamknij");
		btnZamknij.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnZamknij.setBounds(235, 361, 130, 29);
		contentPane.add(btnZamknij);
	}

}
