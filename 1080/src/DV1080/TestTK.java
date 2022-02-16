package DV1080;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class TestTK extends JFrame {

	private JPanel Main;
	private JTextField jtfsearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestTK frame = new TestTK();
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
	public TestTK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 567);
		Main = new JPanel();
		Main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Main);
		Main.setLayout(null);
		
		JPanel Bot = new JPanel();
		Bot.setBounds(0, 198, 849, 332);
		Main.add(Bot);
		
		JPanel Top = new JPanel();
		Top.setBounds(0, 0, 849, 198);
		Main.add(Top);
		Top.setLayout(null);
		
		JLabel jlbTB = new JLabel("Th\u1ED1ng K\u00EA");
		jlbTB.setForeground(Color.BLUE);
		jlbTB.setFont(new Font("Times New Roman", Font.BOLD, 30));
		jlbTB.setBounds(323, 10, 138, 31);
		Top.add(jlbTB);
		
		JLabel jlbsearch = new JLabel("T\u00ECm Ki\u1EBFm");
		jlbsearch.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jlbsearch.setBounds(178, 88, 101, 24);
		Top.add(jlbsearch);
		
		jtfsearch = new JTextField();
		jtfsearch.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jtfsearch.setBounds(289, 91, 194, 19);
		Top.add(jtfsearch);
		jtfsearch.setColumns(10);
		
		JButton jbtsearch = new JButton("Search");
		jbtsearch.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jbtsearch.setBounds(530, 90, 85, 21);
		Top.add(jbtsearch);
		
		JButton jbtreturn = new JButton("Return");
		jbtreturn.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jbtreturn.setBounds(702, 145, 85, 21);
		Top.add(jbtreturn);
	}
}
