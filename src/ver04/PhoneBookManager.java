package ver04;
import java.util.Scanner;

public class PhoneBookManager  {

	private PhoneInfo [] memberbook;
	private int numOfmember;//정보를 추가할 때 마다 +1증가
	
	//생성자
		public PhoneBookManager(int num) {
			memberbook = new PhoneInfo[num];
			numOfmember = 0;
		}
		//메뉴생성
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
		}
		
			//데이터 입력
			public void dataInput() {
				String cName, cPhone, cBirth;
				Scanner scan = new Scanner(System.in);
				
				System.out.println("데이터 입력을 시작합니다...");
				System.out.println("1.일반, 2.동창, 3.회사");
				System.out.println("선택>>");
				int choice02 = scan.nextInt();
				scan.nextLine();
				
				if(choice02==1) {
					//일반 입력받기
					System.out.println("이름 : ");
					cName = scan.nextLine();
					System.out.println("전화번호 : ");
					cPhone = scan.nextLine();
					memberbook[numOfmember++] = 
							new PhoneInfo(cName, cPhone);
				}else if(choice02==2) {
					//동창 입력받기
					System.out.println("이름 : ");
					cName = scan.nextLine();
					System.out.println("전화번호 : ");
					cPhone = scan.nextLine();
					System.out.println("전공 : ");
					String major = scan.nextLine();
					System.out.println("학년 : ");
					int hak = scan.nextInt();
					PhoneSchoolInfo school = new PhoneSchoolInfo
							(cName, cPhone, major, hak);
					memberbook[numOfmember++] = school;
				}else if(choice02==3) {
					//회사 입력받기
					System.out.println("이름 : ");
					cName = scan.nextLine();
					System.out.println("전화번호 : ");
					cPhone = scan.nextLine();
					System.out.println("회사 : ");
					String company = scan.nextLine();
					PhoneCompanyInfo companyIn = new PhoneCompanyInfo
							(cName, cPhone, company);
					memberbook[numOfmember++] = companyIn;
				}
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			//데이터 검색
				private void dataSearch() {
					Scanner scan = new Scanner(System.in);
					System.out.println("검색 할 이름을 입력하세요 : ");
					String searchName = scan.nextLine();
					
					for (int i=0; i<numOfmember; i++) {
						System.out.println("검색중인 이름 :"+ memberbook[i].name);
						if(searchName.compareTo(memberbook[i].name)==0) {
							memberbook[i].showPhoneInfo();
							System.out.println("검색을 하였습니다.");
						}else {
							System.out.println("요청하신 정보가 없습니다.");
						}
					}
				}
			
			//데이터 삭제
			private void dateDelete() {
				Scanner scan = new Scanner(System.in);
				System.out.println("삭제할 이름을 입력하세요 : ");
				String deleteName = scan.nextLine();
				int deleteIndex = -1;
				
				for(int i=0; i<numOfmember; i++) {
					if(deleteName.compareTo(memberbook[i].name)==0) {
						
						memberbook[i]=null;
						deleteIndex =i;
						numOfmember--;
					}
				}
				if(deleteIndex ==-1) {
					System.out.println("==삭제된 데이터가 없습니다.==");
				}
				else{
					for(int i= deleteIndex; i< numOfmember; i++) {
						memberbook[i] = memberbook[i+1];
					}
					System.out.println(deleteName+" 삭제되었습니다.");
				}
			}
			//주소록 전체 출력
				private void dataAllshow() {
					for(int i=0; i< numOfmember; i++) {
						memberbook[i].showPhoneInfo();
					}
					System.out.println("==주소록 전체가 출력되었습니다.==");
				}
		

}
