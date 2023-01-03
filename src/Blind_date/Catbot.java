package Blind_date;

public class Catbot extends Customer {

	public Catbot(String name, int age, String hobby) {
		super(name, age, hobby);
	}

	public void refuse() { // 오버라이드
		super.refuse();
		System.out.println();
		System.out.println("--------------------");
		System.out.println(this.getName() + "님이 도망칩니다.");
	}

	public void introduce() { // 고양이 소개
		System.out.println(getName() + "회원님");
		System.out.println("나이 : " + getAge());
		System.out.println("취미 : " + getHobby());
		System.out.println("안녕하세요 고양이에요 ♥~");
		System.out.println("--------------------");
	}

	public void catstop() { // 고양이 지연
		try {
			System.out.println("전달중..");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
