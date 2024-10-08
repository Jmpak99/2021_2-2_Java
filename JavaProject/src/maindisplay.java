import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class maindisplay extends JFrame {
	private JFrame frame;
	
	public maindisplay() {
		frame = new JFrame();
		frame.setTitle("메인 화면");
		frame.setBounds(100,100,600,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel title = new JLabel("일석이조 쇼핑몰");
		title.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 50));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0,30,584,114);
		frame.getContentPane().add(title);
		
		JButton TimeBtn = new JButton("방문시간 예약");
		TimeBtn.setBounds(43,222,492,50);
		frame.getContentPane().add(TimeBtn);
		
		JButton PdBtn = new JButton("상품 예약");
		PdBtn.setBounds(43,327,492,50);
		frame.getContentPane().add(PdBtn);
		
		JButton NoticeBtn = new JButton("공지사항");
		NoticeBtn.setBounds(43,425,492,50);
		frame.getContentPane().add(NoticeBtn);
		
		//방문시간 예약 버튼 클릭시
		TimeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new reservation();
			}
		});
		
		//상품 예약 버튼 클릭 시
		PdBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Layout3(new ShoppingDao().selectName(null));
				frame.dispose();
				
			}
		});
		
		//공지사항 버튼 클릭 시
		NoticeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new notice();
				frame.dispose();
			}
		});
	}
	
}





