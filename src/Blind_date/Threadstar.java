package Blind_date;

class Threadstar extends Thread {

	public Threadstar(String name) {
		super(name);
	}

	@Override
	public void run() { // 종료시 * 찍기
		for (int i = 1; i <= 7; i++) {
			System.out.print("* ");
			try {
				sleep(500); // 0.5초 일시 정지
			} catch (InterruptedException e) {

			}
		}
	}
}
