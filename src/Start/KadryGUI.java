package Start;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kadry.LekarzeOpcje;
import Kadry.PielegniarkiOpcje;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KadryGUI extends JFrame {

	private JPanel contentPane;
	private JPanel lekarze;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KadryGUI frame = new KadryGUI();
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
	public KadryGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JButton Lekarze = new JButton("Lekarze");
		Lekarze.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LekarzeOpcje.main();
			}
		});
		Lekarze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Lekarze.setBounds(110, 43, 230, 43);
		contentPane.add(Lekarze);
		
		JButton btnPielgniarki = new JButton("Pielęgniarki");
		btnPielgniarki.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PielegniarkiOpcje.main();
			}
		});
		btnPielgniarki.setBounds(110, 112, 230, 43);
		contentPane.add(btnPielgniarki);
		
		JButton btnZarobki = new JButton("Zarobki");
		btnZarobki.setBounds(110, 178, 230, 43);
		contentPane.add(btnZarobki);
		
		JButton btnZamknij = new JButton("Zamknij");
		btnZamknij.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnZamknij.setBounds(165, 233, 120, 29);
		contentPane.add(btnZamknij);
		
		
	}

}
