import ver02.PhoneInfo;
import java.util.Scanner;

public class PhoneBookVer02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("선택하세요..");
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램 종료");
			System.out.print("선택 : ");
			int choice = scan.nextInt();
			 scan.nextLine(); //버퍼날림
			if(choice == 1) {
				System.out.println("이름 :");
				String name = scan.nextLine();
				System.out.println("전화번호 : ");
				String phone = scan.nextLine();
				System.out.println("생일 : ");
				String bir = scan.nextLine();
				
				PhoneInfo phoneI = new PhoneInfo(name,phone,bir);
				phoneI.showPhoneInfo();
				
			}else if(choice==2){ 
				break;
			}
			
		}
		
		
	}

}
