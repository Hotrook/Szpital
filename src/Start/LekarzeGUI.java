package Start;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lekarz.DodajChorobe;
import Lekarz.EdytujChorobe;
import Lekarz.EdytujPacjenta;
import Lekarz.PrzeniesDoProsektorium;
import Lekarz.UsunChorobe;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LekarzeGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LekarzeGUI frame = new LekarzeGUI();
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
	public LekarzeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Przenieś do prosektorium");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrzeniesDoProsektorium.main();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(99, 72, 400, 53);
		contentPane.add(btnNewButton);
		
		JButton btnEdytujInormacjeO = new JButton("Edytuj inormacje o pacjencie");
		btnEdytujInormacjeO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EdytujPacjenta.main();
			}
		});
		btnEdytujInormacjeO.setBounds(99, 137, 400, 53);
		contentPane.add(btnEdytujInormacjeO);
		
		JButton btnDodajChorob = new JButton("Dodaj chorobę");
		btnDodajChorob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DodajChorobe.main();
			}
		});
		btnDodajChorob.setBounds(99, 202, 400, 53);
		contentPane.add(btnDodajChorob);
		
		JButton btnUsuChorob = new JButton("Usuń chorobę");
		btnUsuChorob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UsunChorobe.main();
			}
		});
		btnUsuChorob.setBounds(99, 268, 400, 53);
		contentPane.add(btnUsuChorob);
		
		JButton btnEdytujChorob = new JButton("Edytuj Chorobę");
		btnEdytujChorob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EdytujChorobe.main();
			}
		});
		btnEdytujChorob.setBounds(99, 333, 400, 53);
		contentPane.add(btnEdytujChorob);
		
		JButton btnZamknij = new JButton("Zamknij");
		btnZamknij.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnZamknij.setBounds(240, 436, 120, 29);
		contentPane.add(btnZamknij);
	}

}
