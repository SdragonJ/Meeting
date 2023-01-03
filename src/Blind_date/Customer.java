package Blind_date;

public class Customer {

	private String name; // 이름
	private int age; // 나이
	private String hobby; // 취미
	private String id; // id
	private String pw; // pw

	public Customer(String name, int age, String hobby) { // 파라미터가 있는 생성자
		super();
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() { // 게터세터
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void refuse() {

	}

	public void introduce() {

	}

	public String toString() {
		return "[이름 = " + name + ", 나이 = " + age + ", 취미 = " + hobby + ", id = " + id + ", pw = " + pw + "]";
	}

}
