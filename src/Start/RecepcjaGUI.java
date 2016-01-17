package Start;
import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;

import Recepcja.NowaWizyta;
import Recepcja.OdwolajWizyte;
import Recepcja.PrzeniesWizyte;
import Recepcja.WypiszPacjenta;
import Recepcja.ZarejestrujPacjenta;

import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecepcjaGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecepcjaGUI window = new RecepcjaGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RecepcjaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		
		
		JButton nowaWizyta = new JButton("Nowa wizyta");
		nowaWizyta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NowaWizyta.main();
			}
		});
		nowaWizyta.setBackground(Color.GREEN);
		nowaWizyta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nowaWizyta.setBounds(150, 110, 500, 60);
		frame.getContentPane().add(nowaWizyta);
		
		JLabel lblNewLabel = new JLabel("Witaj na recepcji! Wybierz opcję:");
		lblNewLabel.setBounds(298, 45, 202, 38);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JButton odwolajWizyte = new JButton("Odwołaj wizytę");
		odwolajWizyte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OdwolajWizyte.main();
			}
		});
		odwolajWizyte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		odwolajWizyte.setBounds(150, 210, 500, 60);
		frame.getContentPane().add(odwolajWizyte);
		
		JButton rejestracja = new JButton("Zarejejestruj pacjenta");
		rejestracja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZarejestrujPacjenta.main();
			}
		});
		rejestracja.setBounds(150, 310, 500, 60);
		frame.getContentPane().add(rejestracja);
		
		JButton button = new JButton("Wypisz Pacjenta");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WypiszPacjenta.main();
			}
		});
		button.setBounds(150, 410, 500, 60);
		frame.getContentPane().add(button);
		
		JButton btnZakocz = new JButton("Zakończ");
		btnZakocz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnZakocz.setBounds(340, 505, 120, 29);
		frame.getContentPane().add(btnZakocz);
	}
}
