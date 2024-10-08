import java.sql.*;
import java.util.*;

public class ShoppingDao {
	
	private static Connection con = null;
	private static String url = "jdbc:mysql://localhost:3306/shopping";
	private static String user = "root";
	private static String passwd = "qkrwhdals7851";
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	//������ DB����
	public ShoppingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);

		} catch (Exception e) {
			System.out.println("Connect Failed!");
			e.printStackTrace();
		}
	}

	//db�� �ݴ� �޼ҵ�
	public void db_close() {
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// ��ǰ�������� ���̺��� ��ǰ�� �Ӽ� ���ڵ带 �������� �޼ҵ�
	public ArrayList<String> selectName(String a) {
		//���ڵ带 �����ϴ� ArrayList�迭
		ArrayList<String> ra_arr = new ArrayList<>();
		
		//�������� ��ȯ�� 2���� �迭
		String[][] total = new String[199][1];
		String sql;
		
		//���� null �̸� ��ü �� ��������
		if(a==null) {
			sql = "select * from ��ǰ��������";
		}
		//String ���� ������ ��ǰ��� 'a'�� �ִ� ���ڵ常 ��������
		else {
			sql="select * from ��ǰ�������� where ��ǰ�� like '%"+a+"%'";
		}
		
		pstmt = null;
		rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// �迭�� ������ ���ڵ� �߰�
				ra_arr.add(rs.getString("��ǰ��"));
			}
			for (int i = 0; i < ra_arr.size(); i++) {
				total[i][0] = ra_arr.get(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ra_arr;
	}
	
}
