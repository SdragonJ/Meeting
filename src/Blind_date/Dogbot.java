package Blind_date;

public class Dogbot extends Customer {

	public Dogbot(String name, int age, String hobby) {
		super(name, age, hobby);
	}

	public void refuse() { // 오버라이드
		super.refuse();
		System.out.println();
		System.out.println("--------------------");
		System.out.println(this.getName() + "님이 싫어합니다.");
	}

	public void introduce() { // 개 소개
		System.out.println(getName() + "회원님");
		System.out.println("나이 : " + getAge());
		System.out.println("취미 : " + getHobby());
		System.out.println("안녕하세요 강아지에요 !♡");
		System.out.println("--------------------");
	}

	public void dogstop() { // 개 지연
		try {
			System.out.println("전달중..");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
