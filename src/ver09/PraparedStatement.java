package ver09;

import java.util.Scanner;

public class PraparedStatement extends ConnectDB{
	
	public PraparedStatement() {
		super("kosmo", "1234");
	}
	//데이터 입력
	@Override
	public void dataInput() {
	      try {
	    	  //값의 세팅이 필요한 부분을 ?로 대체한다.
	         String query = "INSERT into phonebook_tb values (?, ?, ?)";
	         
	         //쿼리문을 인자로 전달
	         psmt = con.prepareStatement(query);
	         
	         //DB에 입력할 값을 사용자로부터 입력받음.
	         Scanner scan = new Scanner(System.in);
	         System.out.print("이름 : ");
	         String name = scan.nextLine();
	         System.out.print("전화번호 : ");
	         String phonnum = scan.nextLine();
	         System.out.print("생년월일 : ");
	         String birth = scan.nextLine();
	         
	         //1부터 시작.
	         psmt.setString(1, name);
	         psmt.setString(2, phonnum);
	         psmt.setString(3, birth);
	         
//	         java.util.Date utilDate = new java.util.Date();
//	         java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//	         psmt.setDate(3, sqlDate);
	         
	      
	         //쿼리실행을 위해  prepared객체를 실행한다.
	         int affected = psmt.executeUpdate();
	         System.out.println(affected + "행이 입력되었습니다.");
	         
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         close();
	      }
	}
	//데이터 삭제
	@Override
	public void dataDelete() {
		try {
			connect("kosmo", "1234");
			
			String query = "delete from phonebook_tb where name=?";
			
			psmt= con.prepareStatement(query);
	         //인파라미터 값 설정
	        psmt.setString(1, scanValue("삭제할 아이디"));
	         //쿼리실행후 결과값 반환
	        System.out.println(psmt.executeUpdate()+"행이 삭제되었습니다");
		}catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	}
	
}
