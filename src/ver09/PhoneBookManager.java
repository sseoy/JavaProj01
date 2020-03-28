package ver09;
import java.util.Scanner;


public class PhoneBookManager  {
	
	//생성자
		public PhoneBookManager() {
			
		}
		//메뉴
		public void printMenu() {
			Scanner scan = new Scanner(System.in);
			
			while(true) {
				System.out.println("선택하세요..");
				System.out.println("1.데이터 입력");
				System.out.println("2.데이터 검색");
				System.out.println("3.데이터 삭제");
				System.out.println("4.주소록 출력");
				System.out.println("5.프로그램 종료");
				System.out.print("선택 : ");
				int choice = scan.nextInt();
				scan.nextLine(); //버퍼날림
			
				switch (choice) {
				case 1:
					dataInput();
					break;
				case 2:
					dataSearch();
					break;
				case 3:
					dateDelete();
					break;
				case 4:
					dataAllshow();
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("다시입력해주세요");
					printMenu();
				}
			}
		}//end of printMenu
	
		//데이터 입력
		public void dataInput() {
			new PraparedStatement().dataInput();
			
		}//end of dataInput
		//데이터 검색
		private void dataSearch() {
			new Statement().dataSearch();
		
		}//end of dataSearch
		
		//데이터 삭제
		private void dateDelete() {
			new PraparedStatement().dataDelete();
		
		}//end of deleDlelete
		//주소록 전체 출력
		private void dataAllshow() {
			new Statement().dataAllshow();
			
		}
}
