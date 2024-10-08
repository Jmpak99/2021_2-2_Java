import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginScreen extends JFrame {
	private Connection con = null;
	private static PreparedStatement pstmt = null;
	private ResultSet rs;
	String url = "jdbc:mysql://localhost:3306/shopping";
	String user = "root";
	String pw = "qkrwhdals7851";
	private JFrame frame;
	
	public LoginScreen() {
		//db����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
		} catch (Exception e1) {
			System.out.println("Connect Failed");
			e1.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setTitle("�α��� ȭ��");
		frame.setBounds(100,100,600,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel login = new JLabel("�ϼ����� ���θ�");
		login.setFont(new Font("�޸յձ�������", Font.PLAIN, 50));
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setBounds(0,52,584,114);
		frame.getContentPane().add(login);
		
		JLabel idPanel = new JLabel("ID");
		idPanel.setFont(new Font("����", Font.PLAIN, 20));
		idPanel.setBounds(56, 223, 32, 40);
		frame.getContentPane().add(idPanel);
		
		JTextField IdText = new JTextField();
		IdText.setBounds(119, 223, 429, 40);
		frame.getContentPane().add(IdText);
		
		JLabel PwPanel = new JLabel("PW");
		PwPanel.setFont(new Font("����", Font.PLAIN, 20));
		PwPanel.setBounds(56, 289, 36, 40);
		frame.getContentPane().add(PwPanel);

		JPasswordField PwField = new JPasswordField();
		PwField.setBounds(119, 290, 429, 40);
		frame.getContentPane().add(PwField);

		JButton LoginBtn = new JButton("�α���");
		LoginBtn.setBounds(56, 368, 492, 38);
		frame.getContentPane().add(LoginBtn);

		JButton SignupBtn = new JButton("ȸ������");
		SignupBtn.setBounds(56, 425, 492, 38);
		frame.getContentPane().add(SignupBtn);
		
		//�α��� ��ư Ŭ����
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = 
							"SELECT user_PASSWORD FROM userlogin WHERE user_ID = ? ";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, IdText.getText());
					rs = pstmt.executeQuery();
					if (rs.next()) {
						if(rs.getString(1).contentEquals(PwField.getText())) {
							JOptionPane.showMessageDialog
							(null, "�α����� �����߽��ϴ�");
							new maindisplay();
							frame.setVisible(false);
							pstmt.close();
							con.close();
						} else {
							JOptionPane.showMessageDialog
							(null, "��й�ȣ�� Ʋ���ϴ�");
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog
					(null, "�α����� �����Ͽ����ϴ�");
				}
			}
		});
		
		// ȸ������ ��ư Ŭ�� ��
		SignupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinScreen();
			}
		});
	}
}
