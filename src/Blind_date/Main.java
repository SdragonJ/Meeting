package Blind_date;

// 소개팅'봇'어플
// 사용 기술 : ArrayList, Scanner, Random, HashMap, 상속, for문, while문, flag
//			Thread, Pattern.matches

// 두번쨰 수정본

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 숫자 받아오는 메서드
		ArrayList<Customer> members = new ArrayList<>(); // 회원정보 배열로 저장
		Random r = new Random(); // 접속자 수
		Threadstar star = new Threadstar("*"); // 어플 종료시 별찍기

		HashMap<String, Integer> score = new HashMap<>(); // 궁합점수
		score.put("강아지", r.nextInt(10) + 91); // key,value
		score.put("고양이", r.nextInt(10) + 91);
		score.put("여우",  r.nextInt(10) + 91);

		// Customer클래스 상속받은 Dogbot, Catbot 타입의 메서드 생성, 변수 기입
		Dogbot dogbot = new Dogbot("\'강아지\' ", 20, "짖기");
		Catbot catbot = new Catbot("\'고양이\' ", 22, "눕기");
		Foxbot foxbot = new Foxbot("\'여우\' ", 24, "롤");

		// 중복되는 오류 메시지
		String errMsg = "잘못 입력하였습니다";

		while (true) { // 시작 페이지, 어플 종료전까지 반복
			System.out.println();
			System.out.println("★소개나라에 오신걸 환영합니다★");
			System.out.println("현재 접속자 : " + r.nextInt(5000) + "명");
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.어플 종료");
			System.out.print("입력 >> ");

			int choice = Integer.parseInt(sc.nextLine());

			if (choice == 1) { // 1.회원가입 페이지
				System.out.println("--회원가입 페이지--");
				System.out.print("아이디 : ");
				String id = sc.nextLine();
				System.out.print("비밀번호 : ");
				String pw = sc.nextLine();
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("나이 : ");
				int age = Integer.parseInt(sc.nextLine());
				System.out.print("취미 : ");
				String hobby = sc.nextLine();

				// 한글로 이름 입력 안할시
				boolean isKor = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
				if (!isKor) {
					System.out.println();
					System.out.println("이름은 한글로 입력해주세요.");
					continue;
				}
				// 미성년자 가입 시도시
				if (age < 20) {
					System.out.println();
					System.out.println("미성년자는 가입하실 수 없습니다.");
					continue;
				}

				// 한글로 취미 입력 안할시
				boolean isHobby = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", hobby);
				if (!isHobby) {
					System.out.println();
					System.out.println("취미는 한글로 입력해주세요.");
					continue;
				}

				boolean flag = true; // 깃발꽂기 시작

				// 반복문,if문,배열로 중복된 id찾기
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getId().equals(id)) { // 멤버스의 i번쨰방 안에있는 getId안에
						System.out.println("중복된 아이디가 존재합니다"); // 있는 문자열 값이 id와 같다면
						flag = false; // (flag == false)
						break;
						// 반복문,if문,배열로 중복된 취미 찾기
					}
				}

				if (flag) { // (flag == true)
					Customer c = new Customer();

					c.setId(id); // 받아온 정보들을 c에 추가
					c.setPw(pw);
					c.setName(name);
					c.setAge(age);
					c.setHobby(hobby);

					members.add(c); // 받아온 정보 members에 추가

					System.out.println();
					System.out.println("-- 회원가입 성공! --");
					System.out.println(c.toString());
				}

				// 취미가 같은 봇
				if (catbot.getHobby().equals(hobby) 
				 || dogbot.getHobby().equals(hobby)
				 || foxbot.getHobby().equals(hobby)) {
					System.out.println("-- 취미가 같은 회원분이 계십니다.");
				}

			} else if (choice == 2) { // 로그인

				System.out.println();
				System.out.println("--로그인 페이지--");
				System.out.print("아이디 : ");
				String id = sc.nextLine();
				System.out.print("비밀번호 : ");
				String pw = sc.nextLine();

				for (int i = 0; i < members.size(); i++) {
					if ((members.get(i).getId().equals(id)) && (members.get(i).getPw().equals(pw))) {
						System.out.println();
						System.out.println("☆☆로그인 성공☆☆");
						System.out.println(id + " 님 환영합니다 ~~");

					} else {
						System.out.println("로그인 실패");
						System.out.println("아이디 또는 비밀번호를 확인해주세요.");
						break;
					}
				}
				while (true) { // 로그인시 , 나가기 전까지 반복
					System.out.println();
					System.out.println("1.회원정보 검색");
					System.out.println("2.궁합보기");
					System.out.println("3.짝 찾기");
					System.out.println("4.나가기");

					int choice2 = Integer.parseInt(sc.nextLine());

					if (choice2 == 1) { // 1.회원정보 검색
						System.out.println("--- 회원님 현황 ---");
						dogbot.introduce(); // 개봇 자기소개
						catbot.introduce(); // 고양이봇 자기소개
						foxbot.introduce(); // 여우봇 자기소개
						continue;

					} else if (choice2 == 2) { // 2. 궁합보기
						System.out.println("--- 궁합보기 ---");
						System.out.println("1." + dogbot.getName() + "님과의 궁합보기");
						System.out.println("2." + catbot.getName() + "님과의 궁합보기");
						System.out.println("3." + foxbot.getName() + "님과의 궁합보기");
						System.out.println("4. 나가기");
						System.out.print("입력 >> ");

						int compatibility = Integer.parseInt(sc.nextLine());

						if (compatibility == 1) { // 개봇 궁합
							System.out.println("--------------------");
							System.out.println(dogbot.getName() + "님과의 점수 : " + score.get("강아지") + "점");
						} else if (compatibility == 2) { // 고양이봇 궁합
							System.out.println("--------------------");
							System.out.println(catbot.getName() + "님과의 점수 : " + score.get("고양이") + "점");
						} else if (compatibility == 3) { // 여우봇 궁합
							System.out.println("--------------------");
							System.out.println(foxbot.getName() + "님과의 점수 : " + score.get("여우") + "점");
						} else if (compatibility == 4) { // 나가기

						} else {
							System.out.println(errMsg);
						}

					} else if (choice2 == 3) { // 3. 짝 찾기
						System.out.println();
						System.out.println("----- 접속중 회원님 -----");
						dogbot.introduce();
						catbot.introduce();
						foxbot.introduce();
						System.out.println("1." + dogbot.getName() + "님에게 관심보내기");
						System.out.println("2." + catbot.getName() + "님에게 관심보내기");
						System.out.println("3." + foxbot.getName() + "님에게 관심보내기");
						System.out.println("4. 나가기");
						System.out.print("입력 >> ");

						int choice3 = Integer.parseInt(sc.nextLine());

						if (choice3 == 1) {
							dogbot.dogstop(); // 개 지연...
							dogbot.refuse(); // 개봇 거절
						} else if (choice3 == 2) {
							catbot.catstop(); // 고양이 지연...
							catbot.refuse(); // 고양이봇 거절
						} else if (choice3 == 3) {
							foxbot.foxstop(); // 여우봇 지연...
							foxbot.refuse(); // 여우봇 거절
						} else if (choice3 == 4) { // 나가기

						} else { // 오류시
							System.out.println(errMsg);
						}

					} else if (choice2 == 4) { // 4. 나가기
						break;
					} else {
						System.out.println("다시 입력해주세요");
						continue;
					}
				}

			} else if (choice == 3) { // 3. 어플 종료
				System.out.println();
				System.out.println("어플을 종료합니다.");
				break;

			} else { // 오류시
				System.out.println(errMsg);
			}
			System.out.println();
		}
		System.out.println("-- 안녕히가세요 --");
		star.run(); // 종료시 * 찍기
		sc.close(); // scanner 닫기
	}
}
