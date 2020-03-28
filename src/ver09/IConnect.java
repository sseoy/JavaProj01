package ver09;

public interface IConnect {
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL ="jdbc:oracle:thin://@localhost:1521:orcl";
	
	//DB연결
	void connect(String user, String pass);
	void close();
	void dataInput();
	void dataDelete();
	void dataSearch();
	void dataAllshow();
	//사용자 입력을 위한 추상메소드 선언
	String scanValue(String title);
	
}
