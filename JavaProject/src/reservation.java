import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class reservation extends JFrame {
	private JFrame frame;
	private Connection con = null;
	private static PreparedStatement pstmt = null;
	private static String url = "jdbc:mysql://localhost:3306/shopping";
	private String user ="root";
	private String pw = "qkrwhdals7851";
	String sql;
	
	public reservation() {
		//db 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			
		} catch(Exception e1) {
			System.out.println("Connect Failed");
			e1.printStackTrace();
			
		}
		
		
		frame = new JFrame();
		frame.setBounds(800, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("방문시간 예약");
		frame.setVisible(true);
		
		JLabel title = new JLabel("방문시간 예약");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 50));
		title.setBounds(0, 0, 584, 114);
		frame.getContentPane().add(title);
		
		JLabel subtitle = new JLabel("버튼을 클릭하면 예약이 됩니다");
		subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		subtitle.setFont(new Font("휴먼편지체", Font.BOLD, 23));
		subtitle.setBounds(0, 83, 584, 65);
		frame.getContentPane().add(subtitle);
		
		JButton Btn1 = new JButton("오전 11:00 ~ 12:00");
		Btn1.setBounds(187,158,200,32);
		frame.getContentPane().add(Btn1);
		
		JButton Btn2 = new JButton("오전 12:00 ~ 14:00");
		Btn2.setBounds(187,208,200,32);
		frame.getContentPane().add(Btn2);
		
		JButton Btn3 = new JButton("오후 14:00 ~ 16:00");
		Btn3.setBounds(187, 258, 200, 32);
		frame.getContentPane().add(Btn3);
		
		JButton Btn4 = new JButton("오후 16:00 ~ 18:00");
		Btn4.setBounds(187, 308, 200, 32);
		frame.getContentPane().add(Btn4);
		
		JButton Btn5 = new JButton("오후 18:00 ~ 19:00");
		Btn5.setBounds(187, 358, 200, 32);
		frame.getContentPane().add(Btn5);
		
		JButton MainBtn = new JButton("메인화면");
		MainBtn.setBounds(187, 451, 200, 40);
		frame.getContentPane().add(MainBtn);
		
		// 메인화면
		MainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new maindisplay();
				frame.setVisible(false);
				
				
			}
		});
		
		//11-12시 버튼 클릭시
		Btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO 시간예약 VALUES(?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "1");
					pstmt.setString(2, "0");
					pstmt.setString(3, "0");
					pstmt.setString(4, "0");
					pstmt.setString(5, "0");
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "오전 11:00 ~ 12:00 예약이 완료되었습니다");
					pstmt.close();
					con.close();
				} catch(SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "예약을 실패하였습니다");
					frame.setVisible(false);
				}
			}
		});
		
		//12-14시 버튼 클릭시
		Btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO 시간예약 VALUES(?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "0");
					pstmt.setString(2, "1");
					pstmt.setString(3, "0");
					pstmt.setString(4, "0");
					pstmt.setString(5, "0");
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "오후 12:00 ~ 14:00 예약이 완료되었습니다");
					pstmt.close();
					con.close();
				} catch(SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "예약을 실패하였습니다");
					frame.setVisible(false);
				}
			}
		});
		
		//14-16시 버튼 클릭시
		Btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO 시간예약 VALUES(?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "0");
					pstmt.setString(2, "0");
					pstmt.setString(3, "3");
					pstmt.setString(4, "0");
					pstmt.setString(5, "0");
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "오후 14:00 ~ 16:00 예약이 완료되었습니다");
					pstmt.close();
					con.close();
				} catch(SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "예약을 실패하였습니다");
					frame.setVisible(false);
				}
			}
		});
		
		//16-18시 버튼 클릭시
		Btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO 시간예약 VALUES(?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "0");
					pstmt.setString(2, "0");
					pstmt.setString(3, "0");
					pstmt.setString(4, "1");
					pstmt.setString(5, "0");
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "오후 16:00 ~ 18:00 예약이 완료되었습니다");
					pstmt.close();
					con.close();
				} catch(SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "예약을 실패하였습니다");
					frame.setVisible(false);
				}
			}
		});
		
		//18-19시 버튼 클릭시
		Btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO 시간예약 VALUES(?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "0");
					pstmt.setString(2, "0");
					pstmt.setString(3, "0");
					pstmt.setString(4, "0");
					pstmt.setString(5, "1");
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "오후 18:00 ~ 19:00 예약이 완료되었습니다");
					pstmt.close();
					con.close();
				} catch(SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "예약을 실패하였습니다");
					frame.setVisible(false);
				}
			}
		});
	}
}
		

	

	
	
	
