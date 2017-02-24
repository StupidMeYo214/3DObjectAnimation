package bonus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.hw4.q2.BonusViewer;
import com.hw4.q2.Painter;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.awt.Color;

public class TwoToriGenerator {

	private JFrame frmTwoToriGenerator;
	private JTextField N1Text;
	private JTextField R1Text;
	private JTextField FText;
	private JTextField R2Text;
	private JTextField N2Text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwoToriGenerator window = new TwoToriGenerator();
					window.frmTwoToriGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TwoToriGenerator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTwoToriGenerator = new JFrame();
		frmTwoToriGenerator.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmTwoToriGenerator.setTitle("Two Tori Generator");
		frmTwoToriGenerator.setBounds(100, 100, 480, 504);
		frmTwoToriGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTwoToriGenerator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Value of n1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(50, 13, 138, 42);
		frmTwoToriGenerator.getContentPane().add(lblNewLabel);
		
		N1Text = new JTextField();
		N1Text.setText("30");
		N1Text.setBounds(213, 10, 195, 42);
		frmTwoToriGenerator.getContentPane().add(N1Text);
		N1Text.setColumns(10);
		
		JLabel lblValueOfR = new JLabel("Value of R1");
		lblValueOfR.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblValueOfR.setBounds(50, 78, 138, 42);
		frmTwoToriGenerator.getContentPane().add(lblValueOfR);
		
		R1Text = new JTextField();
		R1Text.setText("5");
		R1Text.setBounds(213, 75, 195, 42);
		frmTwoToriGenerator.getContentPane().add(R1Text);
		R1Text.setColumns(10);
		
		JLabel lblFileName = new JLabel("File Name");
		lblFileName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFileName.setBounds(50, 253, 128, 47);
		frmTwoToriGenerator.getContentPane().add(lblFileName);
		
		FText = new JTextField();
		FText.setText("myToris");
		FText.setBounds(213, 256, 195, 44);
		frmTwoToriGenerator.getContentPane().add(FText);
		FText.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String n1String = N1Text.getText();
				String r1String = R1Text.getText();
				String n2String = N2Text.getText();
				String r2String = R2Text.getText();
				String fsString = FText.getText();
				String fileName = fsString+".dat";
				if(n1String.equals("") || n2String.equals("") || r1String.equals("")|| r2String.equals("") || fsString.equals("")){
					Error error = new Error();
					String [] args = new String[0];
					error.main(args);
				}
				else{
					Integer n1 = Integer.parseInt(n1String);
					Integer R1 = Integer.parseInt(r1String);
					Integer n2 = Integer.parseInt(n2String);
					Integer R2 = Integer.parseInt(r2String);
					
					if( n1 < 3 || n2 < 3 || R1 < 1 || R2 < 1){
						Error error = new Error();
						String [] args = new String[0];
						error.main(args);
					}
					else
					try {
						Toris toris = new Toris(n1, R1, n2, R2, fileName);
						BonusViewer viewer = new BonusViewer(fileName);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				

			}
		});
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGenerate.setBounds(50, 327, 358, 47);
		frmTwoToriGenerator.getContentPane().add(btnGenerate);
		
		R2Text = new JTextField();
		R2Text.setText("3");
		R2Text.setColumns(10);
		R2Text.setBounds(213, 198, 195, 42);
		frmTwoToriGenerator.getContentPane().add(R2Text);
		
		JLabel lblValueOfR_1 = new JLabel("Value of R2");
		lblValueOfR_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblValueOfR_1.setBounds(50, 201, 138, 42);
		frmTwoToriGenerator.getContentPane().add(lblValueOfR_1);
		
		N2Text = new JTextField();
		N2Text.setText("50");
		N2Text.setColumns(10);
		N2Text.setBounds(213, 133, 195, 42);
		frmTwoToriGenerator.getContentPane().add(N2Text);
		
		JLabel lblValueOfN = new JLabel("Value of n2");
		lblValueOfN.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblValueOfN.setBounds(50, 136, 138, 42);
		frmTwoToriGenerator.getContentPane().add(lblValueOfN);
		
		JLabel lblN = new JLabel("n1 > 3");
		lblN.setForeground(Color.RED);
		lblN.setBounds(50, 49, 56, 16);
		frmTwoToriGenerator.getContentPane().add(lblN);
		
		JLabel lblR = new JLabel("R1 >= 1");
		lblR.setForeground(Color.RED);
		lblR.setBounds(50, 121, 56, 16);
		frmTwoToriGenerator.getContentPane().add(lblR);
		
		JLabel lblN_1 = new JLabel("n2 > 3");
		lblN_1.setForeground(Color.RED);
		lblN_1.setBounds(50, 173, 56, 16);
		frmTwoToriGenerator.getContentPane().add(lblN_1);
		
		JLabel lblR_1 = new JLabel("R2 >= 1");
		lblR_1.setForeground(Color.RED);
		lblR_1.setBounds(50, 241, 56, 16);
		frmTwoToriGenerator.getContentPane().add(lblR_1);
		
		JButton btnNewButton = new JButton("Open 3D Object Viewer");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Painter painter = new Painter();
				String [] args = new String[0];
				painter.main(args);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(50, 398, 358, 47);
		frmTwoToriGenerator.getContentPane().add(btnNewButton);
	}
}
