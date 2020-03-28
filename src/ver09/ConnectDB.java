package ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectDB implements IConnect {
	 public Connection con;
	 public PreparedStatement psmt;
	 public ResultSet rs;
	
	public  ConnectDB() {
	}
	public ConnectDB(String user, String pass) {
	      //System.out.println("ConnectDB 인자생성자 호출");
	      try {
	    	  //드라이버로드
	         Class.forName(ORACLE_DRIVER);
	         //DB연결
	         connect(user, pass);
	      } 
	      catch (ClassNotFoundException e) {
	         System.out.println("드라이버 로딩 실패");
	         e.printStackTrace();
	      }
	   }
	//DB에 실제 접속
	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
			
		}catch(SQLException e) {
			System.out.println("데이터베이스 연결오류");
			e.printStackTrace();
		}
	}
	
	@Override
	public void close() {
		try {
			if(con != null) con.close();
			if(psmt != null) psmt.close();
			if(rs != null) rs.close();
		}catch(Exception e) {
			System.out.println("자원 반납 시 오류발생");
			e.printStackTrace();
		}
	}
	//사용자로부터 입력값을 받기 위한 메소드??
	@Override
	public String scanValue(String title) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(title + " 입력해주세요 : ");
		String inputStr = scan.nextLine();
		
		return inputStr;
	}
	//오버라이딩 하는 목적으로만 정의, 쿼리실행은 각 클래스에서 진행
	@Override
	public void dataInput() {
		
	}
	@Override
	public void dataDelete() {
		
	}
	@Override
	public void dataSearch() {
		
	}
	@Override
	public void dataAllshow() {
		
	}
}
