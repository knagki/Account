package ch00;

import java.util.Scanner;

class Account {
	Scanner sc = new Scanner(System.in);
	private String name;
	private int pw;
	private int money;
	
	public Account() {}
	
	public Account(String name, int pw) {
		this.name = name;
		this.pw = pw;
	}

	public Account(String name, String pw, int money) {
		this.name = name;
		this.money = money;
	}

	// 회원 확인
	public void member() {
		while (true) {
			System.out.println("성명 :");
			String na = sc.next();
			System.out.println("비밀번호");
			int pwd = sc.nextInt();
			if (this.name.equals(na) && this.pw == pwd) {
				System.out.println("환영합니다.");
				break;
			} else if (!this.name.equals(na) && this.pw == pwd) {
				System.out.println("없는 이름입니다.");
			} else if (this.name.equals(na) && this.pw != pwd) {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}
	}

	// 입금 메서드
	public void deposit() {
		System.out.println("얼마 입금하시겠습니까?");
		int inmoney = sc.nextInt();
		if (inmoney < 0) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		} else {
			money += inmoney;
		}
		System.out.println(name + ": 입금 " + inmoney + "원");
	}

	// 출금 메서드
	public void withdraw() {
		System.out.println("얼마 출금하시겠습니까?");
		int outmoney = sc.nextInt();
		if (money < outmoney || money <= 0) {
			System.out.println("잔액이 부족합니다.");
			return;
		} else {
			money -= outmoney;
		}
		System.out.println(name + ": 출금 " + outmoney + "원");
	}

	// 조회 메서드
	public void inquiry() {

		System.out.println(name + ": 조회 남은금액" + money + "원");
	}
}

public class AccountEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account ac = new Account();
		Account ac1 = new Account("강기훈", 1234);
		Account ac2 = new Account("민규동", 4567);
		Account ac3 = new Account("안정민", 9876);

		while (true) {
			System.out.println("성명과 비밀번호를 입력하세요.");
			ac1.member();
			System.out.println("다음중 선택해주세요 1.입금, 2.출금, 3.조회, 4.종료");
			System.out.println("입력 번호: ");
			String command = sc.nextLine();
			if (command.equals("4")) {
				System.out.println("은행 종료");
				break;
			} else if (command.equals("1")) {
				ac1.deposit();
			} else if (command.equals("2")) {
				ac1.withdraw();
			} else if (command.equals("3")) {
				ac1.inquiry();
			}
		}
//		equals와 == 차이점
//		equals 메소드는 비교하고자 하는 대상의 내용 자체를 비교하지만,
//		== 연산자는 비교하고자 하는 대상의 주소값을 비교합니다.
//		ac.withdraw(sc.next(), sc.nextint());		

	}
}
