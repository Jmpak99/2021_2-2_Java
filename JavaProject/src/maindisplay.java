import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class maindisplay extends JFrame {
	private JFrame frame;
	
	public maindisplay() {
		frame = new JFrame();
		frame.setTitle("���� ȭ��");
		frame.setBounds(100,100,600,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel title = new JLabel("�ϼ����� ���θ�");
		title.setFont(new Font("�޸յձ�������", Font.PLAIN, 50));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(0,30,584,114);
		frame.getContentPane().add(title);
		
		JButton TimeBtn = new JButton("�湮�ð� ����");
		TimeBtn.setBounds(43,222,492,50);
		frame.getContentPane().add(TimeBtn);
		
		JButton PdBtn = new JButton("��ǰ ����");
		PdBtn.setBounds(43,327,492,50);
		frame.getContentPane().add(PdBtn);
		
		JButton NoticeBtn = new JButton("��������");
		NoticeBtn.setBounds(43,425,492,50);
		frame.getContentPane().add(NoticeBtn);
		
		//�湮�ð� ���� ��ư Ŭ����
		TimeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new reservation();
			}
		});
		
		//��ǰ ���� ��ư Ŭ�� ��
		PdBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Layout3(new ShoppingDao().selectName(null));
				frame.dispose();
				
			}
		});
		
		//�������� ��ư Ŭ�� ��
		NoticeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new notice();
				frame.dispose();
			}
		});
	}
	
}





