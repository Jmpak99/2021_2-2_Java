import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Layout3 extends JFrame implements MouseListener {
	JTable table;
	String[][] total; //��ǰ���� �����ϴ� ���̺� ShoppingDao�� selectName�޼ҵ�� ����
	JTextField text1; // �˻��� �ܾ� �Է�â
	JPanel SearchPanel, Searchdown; //�˻� �гΰ� ���̺� �г�
	DefaultTableModel model; //���̺��� �����ϱ����� ��
	String[] colnames = { "��ǰ ���" };
	
	public Layout3(ArrayList<String> sa) {
		super("��ǰ ����");
		
		total = new String[sa.size()][1];
		
		for (int i = 0; i<sa.size(); i++) {
			total[i][0] = sa.get(i);
		}
		
		setLocation(250, 120);
		setLayout(new BorderLayout());
		text1 = new JTextField(30);
		JButton btn = new JButton("�˻�");
		// ��ư ������ (�˻� ����)
		btn.addActionListener(new MyActionListener());
		
		//��� �˻�â
		JLabel label1 = new JLabel("��ǰ��");
		setLayout(new FlowLayout());
		SearchPanel = new JPanel();
		Searchdown = new JPanel();
		SearchPanel.add(label1);
		SearchPanel.add(text1);
		SearchPanel.add(btn);
		add(SearchPanel, new BorderLayout().NORTH);
		
		//���̺� ����
		setTable();

		Searchdown.add(new JScrollPane(table), BorderLayout.CENTER);
		add(Searchdown, BorderLayout.CENTER);

		table.setFillsViewportHeight(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(600, 550);
		
	}
	
	// ���̺� ����
	private void setTable() {
		// TODO Auto-generated method stub
		model = new DefaultTableModel(total, colnames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// ��� �� ���� �Ұ���
				return false;
			}
		};

		table = new JTable(model);
		// ���� �Ѱ��� ����
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ���콺������ �߰�
		table.addMouseListener(this);

	}
	
	public void mouseClicked(MouseEvent me) { // ���콺 Ŭ�� ������
		int row = table.getSelectedRow();// ���õ� ���̺� �� ������ ����
		new DetailFlow((String) table.getValueAt(row, 0)); // ������ ���̾ƿ��� ���� �ڵ�
		
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
	
	private class MyActionListener implements ActionListener { // ��ư Ŭ�� ������
		@Override
		public void actionPerformed(ActionEvent e) {

			ArrayList<String> al = new ArrayList<>(); // �߰��� �˻������ �����ϴ� �迭
			String[][] sb; // model�� �ֱ� ���� �� �迭�� 2�����迭�� ��ȯ
			
			
			if (e.getActionCommand().equals("�˻�")) { // ��ư �ؽ�Ʈ�� �˻��̸� ����
				
				String word = text1.getText();
				
				if (!word.equals("")) { //�ؽ�Ʈ�ʵ忡 ���� ������ �˻� ����/���� ������ ���� ���̺�� ����
					model.setNumRows(0); //���̺� �ʱ�ȭ
					al = new ShoppingDao().selectName(text1.getText()); //db�����ؼ� sql�� ���� 
					sb = new String[al.size()][1];
					
					for (int i = 0; i < al.size(); i++) {
						sb[i][0] = al.get(i);
					}
					for (int i = 0; i < sb.length; i++) {
						model.addRow(sb[i]);
					}
				} else {
					model.setNumRows(0);
					for (int i = 0; i < total.length; i++) {
						model.addRow(total[i]);
					}
				}
			}

		}
	}
}
