import java.sql.*;
import java.util.*;

public class ShoppingDao {
	
	private static Connection con = null;
	private static String url = "jdbc:mysql://localhost:3306/shopping";
	private static String user = "root";
	private static String passwd = "qkrwhdals7851";
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	//생성자 DB연결
	public ShoppingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);

		} catch (Exception e) {
			System.out.println("Connect Failed!");
			e.printStackTrace();
		}
	}

	//db를 닫는 메소드
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
	
	// 상품종합정보 테이블에서 상품명 속성 레코드를 가져오는 메소드
	public ArrayList<String> selectName(String a) {
		//레코드를 저장하는 ArrayList배열
		ArrayList<String> ra_arr = new ArrayList<>();
		
		//마지막에 반환할 2차원 배열
		String[][] total = new String[199][1];
		String sql;
		
		//값이 null 이면 전체 다 가져오기
		if(a==null) {
			sql = "select * from 상품종합정보";
		}
		//String 값이 있으면 상품명명에 'a'가 있는 레코드만 가져오기
		else {
			sql="select * from 상품종합정보 where 상품명 like '%"+a+"%'";
		}
		
		pstmt = null;
		rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 배열에 가져온 레코드 추가
				ra_arr.add(rs.getString("상품명"));
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
