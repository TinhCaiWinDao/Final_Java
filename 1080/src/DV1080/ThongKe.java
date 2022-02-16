package DV1080;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class ThongKe extends JFrame{
	private JFrame jfr;
	private JTextField jtfsearch;
	private Connection conn;
	private Statement stml;
	private ResultSet rs;
	private DefaultTableModel model;
	private JTable tbl;
	public ThongKe() {
		// TODO Auto-generated constructor stub
		jfr = new JFrame("Thống kê");
		jfr.setDefaultCloseOperation(jfr.EXIT_ON_CLOSE);
		jfr.setBounds(100, 100, 863, 567);
		
		JPanel Main = new JPanel();
		Main.setLayout(null);
		jfr.add(Main);
		
		JPanel Top = new JPanel();
		Top.setBounds(0, 0, 849, 198);
		Main.add(Top);
		Top.setLayout(null);
		
		JPanel Bot = new JPanel();
		Bot.setBounds(0, 198, 849, 332);
		Bot.setLayout(new BorderLayout());
		Main.add(Bot);
		
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
		
		JButton jbtsearch = new JButton("Search");
		jbtsearch.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jbtsearch.setBounds(530, 90, 85, 21);
		Top.add(jbtsearch);
		
		jbtsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					DefaultTableModel model = (DefaultTableModel)tbl.getModel();
					model.setRowCount(0);
					String sql = "select ID, Name, SDT, COUNT(SDT) AS SoLanGoi, DichVu from DanhSach where ID = '"+jtfsearch.getText()+"' OR Name = N'"+jtfsearch.getText()+"' OR SDT = N'"+jtfsearch.getText()+"' OR DichVu = N'"+jtfsearch.getText()+"' group by ID, Name, SDT, DichVu";
					rs = stml.executeQuery(sql);
					while (rs.next()) {
						model.addRow(new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}
			}
			
		});
		
		JButton jbtreturn = new JButton("Return");
		jbtreturn.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jbtreturn.setBounds(702, 145, 85, 21);
		Top.add(jbtreturn);
		
		jbtreturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfr.dispose();
				new Login();
			}
			
		});
		
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Họ Tên");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Số Lần Gọi");
		model.addColumn("Dịch Vụ");
		
		tbl = new JTable(model);
		
		Connection();
		
		JScrollPane sc = new JScrollPane(tbl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Bot.add(sc);
		
		jfr.setVisible(true);
		jfr.setLocationRelativeTo(null);
	}
	public void Connection() {	
		try {
			String connectionURL = "jdbc:sqlserver://DESKTOP-QHHHUUQ:1433;databaseName=DichVu_1080;integratedSecurity=true";
			conn = DriverManager.getConnection(connectionURL, "sa", "sa");
			//JOptionPane.showMessageDialog(null, "Kết nối thành công!!");
			stml = conn.createStatement();
			String sql = "select ID, Name, SDT, COUNT(SDT) AS SoLanGoi, DichVu from DanhSach group by ID, Name, SDT, DichVu";
			rs = stml.executeQuery(sql);
			while (rs.next()) {
				model.addRow(new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
}
