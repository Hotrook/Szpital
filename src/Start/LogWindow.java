package Start;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogWindow {

	private JFrame frame;
	static LogWindow window;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new LogWindow();
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
	public LogWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea login = new JTextArea();
		login.setBounds(6, 97, 438, 16);
		frame.getContentPane().add(login);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(200, 69, 61, 16);
		frame.getContentPane().add(lblLogin);
		
		JPasswordField haslo = new JPasswordField();
		haslo.setBounds(6, 159, 438, 16);
		frame.getContentPane().add(haslo);
		
		JLabel lblHaso = new JLabel("Hasło");
		lblHaso.setBounds(200, 131, 61, 16);
		frame.getContentPane().add(lblHaso);
		
		JButton zaloguj = new JButton("Zaloguj");
		zaloguj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String log = login.getText();
				String blad = "Podales niepoprawne dane! Sproboj jeszcze raz";
				char[] has = haslo.getPassword();
				
				if( log.equals(String.valueOf(has)) ){
					switch( log ){
					case "admin" :
						AdminGUI.main();
						window.frame.setVisible(false);
						break;
					case "pielegniarka":
						PielegniarkiGUI.main();
						window.frame.setVisible(false);
						break;
					case "lekarz":
						LekarzeGUI.main();
						window.frame.setVisible(false);
						break;
					case "kadry":
						KadryGUI.main();
						window.frame.setVisible(false);
						break;
					case "recepcja":
						RecepcjaGUI.main();
						window.frame.setVisible(false);
						break;
					default:
						JOptionPane.showMessageDialog(frame, blad);
						break;
					
					}
				}
				else{
					JOptionPane.showMessageDialog(frame, blad);
					login.setText("");
					haslo.setText("");
				}
				
				
			}
		});
		
		zaloguj.setBounds(162, 209, 117, 29);
		frame.getContentPane().add(zaloguj);
		
		JLabel lblWitajWPanelu = new JLabel("Witaj w panelu logowania szpitala psychiatrycznego!");
		lblWitajWPanelu.setBounds(58, 21, 346, 16);
		frame.getContentPane().add(lblWitajWPanelu);
	}
}
