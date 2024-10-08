import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class notice extends JFrame {
	private JFrame frame;
	
	public notice() {
		frame = new JFrame();
		frame.setTitle("공지사항");
		frame.setBounds(100,100,600,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel title = new JLabel("공지사항");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 50));
		title.setBounds(0,10,584,114);
		frame.getContentPane().add(title);
		
		JLabel subtitle1 = new JLabel("   공지");
		subtitle1.setFont(new Font("굴림", Font.PLAIN, 20));
		subtitle1.setBounds(0,134,165,38);
		frame.getContentPane().add(subtitle1);
		
		JTextField NoticeText1 = new JTextField();
		NoticeText1.setBounds(32, 182, 500, 80);
		frame.getContentPane().add(NoticeText1);
		
		JLabel subtitle2 = new JLabel("   공지");
		subtitle2.setFont(new Font("굴림", Font.PLAIN, 20));
		subtitle2.setBounds(0,310,165,38);
		frame.getContentPane().add(subtitle2);
		
		JTextField NoticeText2 = new JTextField();
		NoticeText2.setBounds(32,358,500,80);
		frame.getContentPane().add(NoticeText2);
		
		JButton mainBtn = new JButton("메인화면");
		mainBtn.setBounds(192, 450, 200, 40);
		frame.getContentPane().add(mainBtn);
		
		
		//메인화면으로
		mainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new maindisplay();
				frame.dispose();
			}
		});
		
	}

}
