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
		//db연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
		} catch (Exception e1) {
			System.out.println("Connect Failed");
			e1.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setTitle("로그인 화면");
		frame.setBounds(100,100,600,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel login = new JLabel("일석이조 쇼핑몰");
		login.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 50));
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setBounds(0,52,584,114);
		frame.getContentPane().add(login);
		
		JLabel idPanel = new JLabel("ID");
		idPanel.setFont(new Font("굴림", Font.PLAIN, 20));
		idPanel.setBounds(56, 223, 32, 40);
		frame.getContentPane().add(idPanel);
		
		JTextField IdText = new JTextField();
		IdText.setBounds(119, 223, 429, 40);
		frame.getContentPane().add(IdText);
		
		JLabel PwPanel = new JLabel("PW");
		PwPanel.setFont(new Font("굴림", Font.PLAIN, 20));
		PwPanel.setBounds(56, 289, 36, 40);
		frame.getContentPane().add(PwPanel);

		JPasswordField PwField = new JPasswordField();
		PwField.setBounds(119, 290, 429, 40);
		frame.getContentPane().add(PwField);

		JButton LoginBtn = new JButton("로그인");
		LoginBtn.setBounds(56, 368, 492, 38);
		frame.getContentPane().add(LoginBtn);

		JButton SignupBtn = new JButton("회원가입");
		SignupBtn.setBounds(56, 425, 492, 38);
		frame.getContentPane().add(SignupBtn);
		
		//로그인 버튼 클릭시
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
							(null, "로그인을 성공했습니다");
							new maindisplay();
							frame.setVisible(false);
							pstmt.close();
							con.close();
						} else {
							JOptionPane.showMessageDialog
							(null, "비밀번호가 틀립니다");
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog
					(null, "로그인을 실패하였습니다");
				}
			}
		});
		
		// 회원가입 버튼 클릭 시
		SignupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinScreen();
			}
		});
	}
}
