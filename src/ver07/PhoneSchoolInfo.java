package ver07;

public class PhoneSchoolInfo  extends PhoneInfo{
	
	String major;
	int hak;
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int hak) {
		super(name, phoneNumber);
		this.major = major;
		this.hak = hak;
	}
	@Override
	public void showPhoneInfo() {
		System.out.println("===동창===");
		super.showPhoneInfo();
		System.out.println("전공: "+ major);
		System.out.println("학년: "+ hak);
		
	}
	
	
}
