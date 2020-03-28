package ver09;

import java.sql.SQLException;

public class Statement extends ConnectDB{
	public Statement() {
		super("kosmo","1234");
	}
	
	@Override
	public void dataSearch() {
		try {
			
			String sql = "SELECT * FROM phonebook_tb "
						+ "WHERE name LIKE '%'||?||'%'";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, scanValue("검색할 이름"));
			rs= psmt.executeQuery();
			while(rs.next()) {
				 String name = rs.getString(1);
				 String phone = rs.getString(2);
				 String birth = rs.getString(3);
					 
					  
				 System.out.printf("%s %s %s\n",
							name, phone, birth);
			}
			if(psmt.executeUpdate()==0) {
				System.out.println("이름을 검색할수 없습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	@Override
	public void dataAllshow() {
		try {
			
			String sql = "SELECT * FROM phonebook_tb ";
			psmt = con.prepareStatement(sql);
			//psmt.setString(1, scanValue("검색할 이름"));
			rs= psmt.executeQuery();
			while(rs.next()) {
				 String name = rs.getString(1);
				 String phone = rs.getString(2);
				 String birth = rs.getString(3);
					 
					  
				 System.out.printf("%s %s %s\n",
							name, phone, birth);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

}
