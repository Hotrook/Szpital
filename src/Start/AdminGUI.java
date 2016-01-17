package Start;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI();
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
	public AdminGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton recepcja = new JButton("RecepcjaGUI");
		recepcja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RecepcjaGUI.main();
			}
		});
		recepcja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		recepcja.setBounds(100, 30, 400, 70);
		contentPane.add(recepcja);
		
		JButton kadry = new JButton("KadryGUI");
		kadry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KadryGUI.main();
			}
		});
		kadry.setBounds(100, 120, 400, 70);
		contentPane.add(kadry);
		
		JButton lekarze = new JButton("LekarzeGUI");
		lekarze.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LekarzeGUI.main();
			}
		});
		lekarze.setBounds(100, 210, 400, 70);
		contentPane.add(lekarze);
		
		JButton pielegniarki = new JButton("PielegniarkiGUI");
		pielegniarki.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PielegniarkiGUI.main();
			}
		});
		pielegniarki.setBounds(100, 300, 400, 70);
		contentPane.add(pielegniarki);
		
		JButton btnNewButton = new JButton("Zamknij");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(235, 430, 130, 29);
		contentPane.add(btnNewButton);
	}

}
