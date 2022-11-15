package pl.view;

import java.util.Scanner;

import pl.controller.PLController;

public class PLReserveMenu {
	private Scanner sc = new Scanner(System.in);
	int num = 0;
	private PLController controller = new PLController();
	public void reserveMine() {
		System.out.println("=============내 예약===============");
//		for(int i = 1 ; i<3/*length*/ ; i++) {
//			//예약된 길이만큼 i를 반복해야함
//			System.out.println(i+". "/*+getPL_Name(i)*/);
//			//dto에서 장소 이름을 받아와야함
//		}
		//print 새로 내고 근데 출력형태 보고 결정해야함
		controller.reserveMine();
		System.out.println("0. 이전 메뉴로");
		System.out.println("=================================");
		System.out.print("번호를 입력하세요 : ");
		num = sc.nextInt();
		System.out.println();
		
		if(num==0) {
			//PlaceList호출
		}
		else if(num <3 /*length*/){
			//예약목록에 해당할 때만
			reserveInfo();
			
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
	}

	private void reserveInfo() {
		// TODO Auto-generated method stub
		System.out.println("==============예약정보==============");
//		System.out.println("가게 이름 : "/*+getPLName(num)*/);
//		//가게 이름을 소환해야함
//		System.out.println("날짜 : "/*+getReserveDay(num)*/);
//		//날짜를 소환해야 하는데 형태를 자바의 구문으로 맞출지 아니면 그냥 맞출지///
//		System.out.println("시간 : "/*+getReserveTime(num)*/);
//		//시간 형태 받는 것도 고민해봐야함
		controller.reserveInfo(num);
		System.out.println();
		System.out.println("1. 예약 변경");
		System.out.println("2. 예약 취소");
		System.out.println("0. 이전 메뉴로");
		System.out.println("00. 메인 메뉴로");
		System.out.println("=================================");
		System.out.print("번호를 입력하세요 : ");
		
		String num2 = sc.next();
		System.out.println();
		
		switch(num2) {
		case "1":
			editReserve();
			break;
		case "2":
			cancelReserve();
			break;
		case "0":
			reserveMine();
			break;
		case "00":
			//PlaceList호출
			break;
		default:
			System.out.println("잘못 입력하셨습니다");
			return;
		}
		
	}

	

	private void editReserve() {
		
		 System.out.println("=============예약 변경==========");
		 System.out.println("Ex) 날짜 : 2022/01/01 -> 220101");
		 System.out.println("Ex) 시간 : 오후 2시 반 -> 1430");
		 System.out.print("날짜 : ");
		 String day = sc.nextLine();

		 System.out.println();
		 System.out.print("시간 : ");
		 String time = sc.nextLine();
		 System.out.println();
		 System.out.println("==============================");

		 controller.editReserve(num, day, time);
	}
	
	private void cancelReserve() {
		
		System.out.println("===========예약 =============");
		System.out.print("정말 취소하시겠습니까? (Y, N) : ");
		char cancel = sc.next().charAt(0);
		System.out.println("============================");
		switch(cancel) {
		case 'y', 'Y':
			controller.cancelReserve(num);
			break;
		case 'n', 'N':
			reserveInfo();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
	}
}
