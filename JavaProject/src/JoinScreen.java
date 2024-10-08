import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JoinScreen extends JFrame {
	private JFrame frame;
	private Connection con = null;
	private static PreparedStatement pstmt = null;
	private static String url = "jdbc:mysql://localhost:3306/shopping";
	private static String user = "root";
	private static String pw = "qkrwhdals7851";
	String sql;
	
	public JoinScreen() {
		//db ����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			
		} catch(Exception e1) {
			System.out.println("Connect Failed");
			e1.printStackTrace();
			
		}
		

		frame = new JFrame();
		frame.setTitle("ȸ������");
		frame.setBounds(100, 100, 600, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel title = new JLabel("ȸ������");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("�޸յձ�������", Font.PLAIN, 50));
		title.setBounds(0, 10, 584, 114);
		frame.getContentPane().add(title);
		
		JLabel idPanel = new JLabel("      ���̵� : ");
		idPanel.setFont(new Font("����", Font.PLAIN, 20));
		idPanel.setBounds(10, 120, 130, 40);
		frame.getContentPane().add(idPanel);
		
		JTextField IdText = new JTextField();
		IdText.setBounds(150, 120, 350, 40);
		frame.getContentPane().add(IdText);
		
		JLabel PwPanel = new JLabel("   ��й�ȣ : ");
		PwPanel.setFont(new Font("����", Font.PLAIN, 20));
		PwPanel.setBounds(10, 190, 130, 40);
		frame.getContentPane().add(PwPanel);
		
		JPasswordField PwText = new JPasswordField();
		PwText.setBounds(150, 190, 350, 40);
		frame.getContentPane().add(PwText);
		
		JLabel NamePanel = new JLabel("         �̸� : ");
		NamePanel.setFont(new Font("����", Font.PLAIN, 20));
		NamePanel.setBounds(10, 260, 130, 40);
		frame.getContentPane().add(NamePanel);
		
		JTextField NameText = new JTextField();
		NameText.setBounds(150, 260, 350, 40);
		frame.getContentPane().add(NameText);
		
		JLabel MailPanel = new JLabel("      �̸��� : ");
		MailPanel.setFont(new Font("����", Font.PLAIN, 20));
		MailPanel.setBounds(10, 330, 130, 40);
		frame.getContentPane().add(MailPanel);
		
		JTextField MailText = new JTextField();
		MailText.setBounds(150, 330, 350, 40);
		frame.getContentPane().add(MailText);

		
		JButton JoinBtn = new JButton("ȸ������");
		JoinBtn.setBounds(60, 405, 200, 50);
		frame.getContentPane().add(JoinBtn);
		
		JButton CancelBtn = new JButton("���");
		CancelBtn.setBounds(300, 405, 200, 50);
		frame.getContentPane().add(CancelBtn);
		
		
		
		// ȸ������ Ŭ�� ��
		JoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql = "INSERT INTO userlogin VALUES (?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, IdText.getText());
					pstmt.setString(2, NameText.getText());
					pstmt.setString(3, PwText.getText());
					pstmt.setString(4, MailText.getText());
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog
					(null, "ȸ�������� �Ϸ�Ǿ����ϴ�");
					frame.setVisible(false);
					pstmt.close();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog
					(null, "ȸ�������� �����Ͽ����ϴ�");
					frame.setVisible(false);
				}
			}
		});
		
		
		
		// cancel ��ư Ŭ�� ��
		CancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
			}
		});
	}
}
