package ver08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
//import java.util.Iterator;
import ver06.MenuSelectException;


public class PhoneBookManager {
		
		//private int numOfmember;//정보를 추가할 때 마다 +1증가
		//set컬렉션 생성
		HashSet<PhoneInfo> list;
		
		//생성자
		public PhoneBookManager() {
			
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/ver08/PhoneBook.obj"));
				
				list = (HashSet<PhoneInfo>)in.readObject();
			}
			catch (Exception e) {
				list = new HashSet<PhoneInfo>();
		    }
		}
		//메뉴생성
		public void printMenu() {
			Scanner scan = new Scanner(System.in);
			while(true) {
				int choice=0;
				
						System.out.println("선택하세요..");
						System.out.println("1.데이터 입력");
						System.out.println("2.데이터 검색");
						System.out.println("3.데이터 삭제");
						System.out.println("4.주소록 출력");
						System.out.println("5.프로그램 종료");
						System.out.print("선택 : ");
						
					try {
						choice = scan.nextInt();
						
						if(choice<1 || choice>5) {
							MenuSelectException selectEx = new MenuSelectException();
							throw selectEx;
						}
						
						switch (choice) {
						case MenuItem.INPUT:
							dataInput();
							break;
						case MenuItem.SEARCH:
							dataSearch();
							break;
						case MenuItem.DELETE:
							dateDelete();
							break;
						case MenuItem.SHOW:
							dataAllshow();
							break;
						case MenuItem.END:
							savePhoneBook();
							System.out.println("프로그램을 종료합니다.");
							return;
						default:
							System.out.println("다시입력해주세요");
							printMenu();
						}
					
				}
				catch(MenuSelectException e) {
					System.out.println(e.getMessage());
				}
				catch(InputMismatchException e) {
					System.out.println("문자형태로 입력하면 안되요.");
					scan.nextLine();
				}
			}
		}
		//이름 중복
		public void OverlapCheck(String name, String phone, PhoneInfo phoneInfo) {
			Scanner scan = new Scanner(System.in);
			
			
			boolean a = list.add(phoneInfo);//ture면 저장됨.
			
			if(a == false) {
				System.out.println("같은 이름이 있습니다. 덮어쓰시겠습니까? 덮어쓰기:1, 취소:2 ");
				int choice03 = scan.nextInt();
				if(choice03 == 1) {
					list.remove(phoneInfo);
					list.add(phoneInfo);
				}else {
					dataInput();
				}
			}else{
			}
		}
		//데이터 입력
		public void dataInput() {
			try {
					//인스턴스를 파일에 저장하기 위한 스트림을 생성한다.
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/ver08/phonebook.obj"));
					
					Scanner scan = new Scanner(System.in);
					String cName, cPhone, cBirth;
					
					try {
						System.out.println("데이터 입력을 시작합니다...");
						System.out.println("1.일반, 2.동창, 3.회사");
						System.out.println("선택>>");
						int choice02 = scan.nextInt();
						scan.nextLine();
						if(choice02<1 || choice02>3) {
							MenuSelectException selectEx = new MenuSelectException();
							throw selectEx;
						}
						
						//이름, 전화번호
						System.out.println("이름 : ");
						cName = scan.nextLine();
						
						System.out.println("전화번호 : ");
						cPhone = scan.nextLine();
						
						if(choice02==SubMenuItem.GENERAL) {
							//일반 입력받기
							PhoneInfo phoneInfo = new PhoneInfo(cName, cPhone);
							OverlapCheck(cName, cPhone, phoneInfo);
							
						}else if(choice02==SubMenuItem.MAJOR) {
							//동창 입력받기
							System.out.println("전공 : ");
							String major = scan.nextLine();
							System.out.println("학년 : ");
							int hak = scan.nextInt();
							
							PhoneInfo school = new PhoneSchoolInfo(cName, cPhone, major, hak);
							OverlapCheck(cName, cPhone, school);
							
						}else if(choice02==SubMenuItem.COMPANY) {
							//회사 입력받기
							System.out.println("회사 : ");
							String company = scan.nextLine();
							
							PhoneInfo companyIn = new PhoneCompanyInfo(cName, cPhone, company);
							OverlapCheck(cName, cPhone, companyIn);
							
						}
						System.out.println("데이터 입력이 완료되었습니다.");
				}catch(MenuSelectException e) {
					System.out.println("[예외발생] 1~3사이의 숫자를 입력하세요");
					dataInput();
				}
				catch(InputMismatchException e) {
					System.out.println("문자형태로 입력하면 안되요.");
					scan.nextLine();
					dataInput();
				}
				}catch (FileNotFoundException e) {
					
				}catch (IOException e) {
					
				}
				
			}

		//데이터 검색
		private void dataSearch() {
			Scanner scan = new Scanner(System.in);
			//이름으로 검색
			System.out.println("검색 할 이름을 입력하세요 : ");
			String searchName = scan.nextLine();
			
			//검색결과 유무 확인	
			
			boolean searchFlag = false;//검색결과 유무 확인	
			
			Iterator<PhoneInfo> ir = list.iterator();
			while(ir.hasNext()) {
				PhoneInfo phoneInfo = ir.next();
				if(searchName.endsWith(phoneInfo.name)) {
					//검색결과가 있다면 플래그를 변경
					searchFlag = true;
					System.out.println(phoneInfo);
				}
			}
			if(searchFlag == true) {
				System.out.println("검색을 하였습니다.");
			}else {
				System.out.println("요청하신 정보가 없습니다.");
			}
				
		}//end of dataSearch

		
		//데이터 삭제
		private void dateDelete() {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("삭제할 이름을 입력하세요 : ");
			String deleteName = scan.nextLine();
			//scan.nextLine();
			boolean searchFlag = false;//검색결과 유무 확인	
			
			Iterator<PhoneInfo> ir = list.iterator();
			while(ir.hasNext()) {
				PhoneInfo phoneInfo = ir.next();
				if(deleteName.equals(phoneInfo.name)) {
					//검색결과가 있다면 플래그를 변경
					searchFlag = true;
					System.out.println(phoneInfo);
					ir.remove();
				}
			}
			if(searchFlag == true) {
				System.out.println("삭제를 하였습니다.");
			}else {
				System.out.println("요청하신 정보가 없습니다.");
			}

		}//end of deteDelete
		//주소록 전체 출력, 파일에 있는 정보 출력
		private void dataAllshow() {
//			try {
//				ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/ver08/PhoneBook.obj"));
//
//				PhoneInfo readInfo = (PhoneInfo)in.readObject();
//				readInfo.showPhoneInfo();
				System.out.println("[최초 전체 정보출력]");
				    for(PhoneInfo info : list)
				    {
				        info.showPhoneInfo();      
				    }
//			}catch (ClassNotFoundException e) {
//		    }catch (FileNotFoundException e) {
//		    }catch (IOException e) {
//		    }
			     
		}
		
		//파일형태로 저장하기
		public void savePhoneBook() {
			try {
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("src/ver08/PhoneBook.obj"));
				
				out.writeObject(list);
						
			}catch(Exception e) {
				System.out.println("예외발생");
				e.printStackTrace();
			}
		}
}//end of PhoneBookManager



















