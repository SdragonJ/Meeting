package Blind_date;

public class Foxbot extends Customer {


	public Foxbot(String name, int age, String hobby) {
		super(name, age, hobby);
	}

	public void refuse() { // 오버라이드
		super.refuse();
		System.out.println();
		System.out.println("--------------------");
		System.out.println(this.getName() + "님이 무시합니다.");
	}

	public void introduce() { // 여우 소개
		System.out.println(getName() + "회원님");
		System.out.println("나이 : " + getAge());
		System.out.println("취미 : " + getHobby());
		System.out.println("안녕하세요 여우에요 ♤♠");
		System.out.println("--------------------");
	}

	public void foxstop() { // 여우 지연
		try {
			System.out.println("전달중..");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
