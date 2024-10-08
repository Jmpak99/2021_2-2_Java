import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DetailFlow extends JFrame {
	private JFrame frame;
	private String shoppingDataHost = "jdbc:mysql://localhost:3306/shopping";
	private String shoppingPreferenceHost = "jdbc:mysql://localhost:3306/shopping";
	private Connection shoppingDataConnection, shoppingPreferenceConnection;
	private String username ="root";
	private String pw = "qkrwhdals7851";
	
	private String productName;
	
	private JButton UserRSVBtn, MainBtn;
	private JLabel Category, Size, Color, Price, UserRSV;
	private JLabel ProductName, CategoryName, SizeName, ColorName, PriceName, RSVCount;
	
	public DetailFlow(String shoppingName) {
		this.productName = shoppingName;
		initializeForm();
		ResultSet shoppingData = loadShoppingData();
		ResultSet shoppingPreferenceData = loadShoppingPreference();
		displayData(shoppingData, shoppingPreferenceData);
		
	}
	
	private void initializeForm() {
		frame = new JFrame();
		frame.setBounds(800, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("������");
		frame.setVisible(true);
		UserRSVBtn = new JButton("�����ϱ�");
		UserRSVBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int currentRSVCount = loadRSVCount();
				int updatedRSVCount = currentRSVCount + 1;
				
				boolean isSuccess = updateRSVCount(updatedRSVCount);
				if(isSuccess) {
					RSVCount.setText(String.valueOf(updatedRSVCount));
				} else {
					RSVCount.setText(String.valueOf(currentRSVCount));
				}
			}
		});
		
		MainBtn = new JButton("����ȭ��");
		
		MainBtn.setBounds(300, 480, 200, 40);
		frame.getContentPane().add(MainBtn);
		MainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new maindisplay();
				frame.setVisible(false);
				
				
			}
		});
		
		UserRSVBtn.setBounds(80, 480, 200, 40);
		frame.getContentPane().add(UserRSVBtn);
		
		Category = DefaultComponentFactory.getInstance().createLabel("�з� : ");
		Category.setBounds(14, 79, 105, 18);
		frame.getContentPane().add(Category);
		
		Size = DefaultComponentFactory.getInstance().createLabel("������ : ");
		Size.setBounds(14, 158, 105, 18);
		frame.getContentPane().add(Size);
		
		Color = DefaultComponentFactory.getInstance().createLabel("���� : ");
		Color.setBounds(14, 234, 105, 18);
		frame.getContentPane().add(Color);
		
		Price = DefaultComponentFactory.getInstance().createLabel("���� : ");
		Price.setBounds(14, 314, 105, 18);
		frame.getContentPane().add(Price);
		
		UserRSV = DefaultComponentFactory.getInstance().createLabel("���� : ");
		UserRSV.setBounds(14, 399, 57, 18);
		frame.getContentPane().add(UserRSV);
		
		ProductName = DefaultComponentFactory.getInstance().createLabel("");
		ProductName.setBounds(207, 12, 177, 27);
		frame.getContentPane().add(ProductName);
	
		CategoryName = DefaultComponentFactory.getInstance().createLabel("");
		CategoryName.setBounds(131, 79, 211, 18);
		frame.getContentPane().add(CategoryName);
		
		SizeName = DefaultComponentFactory.getInstance().createLabel("");
		SizeName.setBounds(131, 158, 211, 18);
		frame.getContentPane().add(SizeName);
		
		ColorName = DefaultComponentFactory.getInstance().createLabel("");
		ColorName.setBounds(131, 234, 211, 18);
		frame.getContentPane().add(ColorName);
		
		PriceName = DefaultComponentFactory.getInstance().createLabel("");
		PriceName.setBounds(133, 314, 209, 18);
		frame.getContentPane().add(PriceName);
		
		RSVCount = DefaultComponentFactory.getInstance().createLabel("");
		RSVCount.setBounds(71, 399, 57, 18);
		frame.getContentPane().add(RSVCount);
		
	}
	
	private ResultSet loadShoppingData() {
		try {
			shoppingDataConnection = DriverManager.getConnection(shoppingDataHost, username, pw);
			Statement stmt = shoppingDataConnection.createStatement();
			String query = "SELECT * FROM ��ǰ�������� WHERE ��ǰ��='"+productName+"'";
			ResultSet result = stmt.executeQuery(query);
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private ResultSet loadShoppingPreference() {
		try {
			shoppingPreferenceConnection = DriverManager.getConnection(shoppingPreferenceHost, username, pw);
			Statement stmt = shoppingPreferenceConnection.createStatement();
			String query = "SELECT * FROM ��ǰ���� WHERE ��ǰ��='"+productName+"'";
			ResultSet result = stmt.executeQuery(query);
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void displayData(ResultSet shoppingData, ResultSet shoppingPreferenceData) {
		try {
			while(shoppingData.next()) {
				ProductName.setText(shoppingData.getString("��ǰ��"));
				CategoryName.setText(shoppingData.getString("�з�"));
				SizeName.setText(shoppingData.getString("������"));
				ColorName.setText(shoppingData.getString("����")); 
				PriceName.setText(shoppingData.getString("����"));
			}
			
			while(shoppingPreferenceData.next()) {
				RSVCount.setText(String.valueOf(shoppingPreferenceData.getInt("reservation")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private int loadRSVCount() {
		try {
			Statement stmt = shoppingPreferenceConnection.createStatement();
			String query = "SELECT reservation FROM ��ǰ���� WHERE ��ǰ��='"+productName+"'";
			ResultSet result = stmt.executeQuery(query);
			
			int count = 0;
			while(result.next()) {
				count = result.getInt("reservation");
			}
			
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	private boolean updateRSVCount(int updateCount) {
		try {
			Statement stmt = shoppingPreferenceConnection.createStatement();
			String query = "UPDATE ��ǰ���� SET reservation ='"+updateCount+"' WHERE ��ǰ��='"+productName+"'";
			stmt.executeUpdate(query);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
