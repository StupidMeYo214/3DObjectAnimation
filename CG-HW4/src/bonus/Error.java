package bonus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Error {

	private JFrame frmError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Error window = new Error();
					window.frmError.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Error() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmError = new JFrame();
		frmError.setTitle("Error");
		frmError.setBounds(100, 100, 449, 273);
		frmError.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmError.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Something Is Wrong Your Input!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(42, 13, 363, 71);
		frmError.getContentPane().add(lblNewLabel);
		
		JLabel lblPleaseCheckYour = new JLabel(" Please Check Your Input!");
		lblPleaseCheckYour.setForeground(Color.RED);
		lblPleaseCheckYour.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPleaseCheckYour.setBounds(67, 98, 304, 41);
		frmError.getContentPane().add(lblPleaseCheckYour);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmError.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(67, 152, 294, 41);
		frmError.getContentPane().add(btnNewButton);
	}

}
