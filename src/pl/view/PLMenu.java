package pl.view;

import java.util.Scanner;

import pl.controller.PLController;

public class PLMenu{

	private Scanner sc = new Scanner(System.in);
	private PLController plController = new PLController();
	/**
	 * @Method Name : mainMenu
	 * @작성일 : 2022. 11. 11.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 : 처음 보여지는 메뉴
	 */
	public void mainMenu() {

		do { // 메인메뉴를 보여주는 반복문
			System.out.println("=========== PLACE LIST ===========");
			System.out.println("1. 추천 장소");
			System.out.println("2. 장소 추가");
			System.out.println("3. 내 장소");
			System.out.println("4. 저장소 내보내기");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 내 예약");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 관리 번호를 입력하세요 : ");
			int no = sc.nextInt();

			switch (no) {
			case 1:

				break;
			case 2:
				plController.addPlaceList();
				break;
			case 3:
				plController.myPlaceList();
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				//reserveMine();  //클래스를 분리 안하자니 int num을 공유해야 하는데 방법을 모르겠다.
				//plController.reserveMine(reserveMine()); 여기서 create을 할게 아니니까 이렇게 쓸수는 없음.
				break;
			case 0:
				System.out.println("프로그램을 종료합니다. ");
				return;
			default:
				System.out.println("잘못 입력하셨습니다 다시 입력하세요 ");
				break;
			}

		} while (true);
		
		
	}
	
	
	
		
//	public void reserveMine() {
//		System.out.println("=============내 예약===============");
//		for(int i = 1 ; i<3/*length*/ ; i++) {
//			//예약된 길이만큼 i를 반복해야함
//			System.out.println(i+". "/*+getPL_Name(i)*/);
//			//dto에서 장소 이름을 받아와야함
//		}
//		System.out.println("0. 이전 메뉴로");
//		System.out.println("=================================");
//		System.out.print("번호를 입력하세요 : ");
//		num = sc.nextInt();
//		System.out.println();
//		
//		if(num==0) {
//			//PlaceList호출
//		}
//		else if(num <3 /*length*/){
//			//예약목록에 해당할 때만
//			reserveInfo();
//			
//		}
//		else {
//			System.out.println("잘못 입력하셨습니다.");
//			return;
//		}
//	}
//
//	private void reserveInfo() {
//		// TODO Auto-generated method stub
//		System.out.println("==============예약정보==============");
//		System.out.println("가게 이름 : "/*+getPLName(num)*/);
//		//가게 이름을 소환해야함
//		System.out.println("날짜 : "/*+getReserveDay(num)*/);
//		//날짜를 소환해야 하는데 형태가 진짜 개 걱정됨 이거 date으로 받아올 수 있나?
//		System.out.println("시간 : "/*+getReserveTime(num)*/);
//		//시간 형태 받는 것도 고민해봐야함
//		System.out.println();
//		System.out.println("1. 예약 변경");
//		System.out.println("2. 예약 취소");
//		System.out.println("0. 이전 메뉴로");
//		System.out.println("00. 메인 메뉴로");
//		System.out.println("=================================");
//		System.out.print("번호를 입력하세요 : ");
//		
//		String num2 = sc.next();
//		System.out.println();
//		
//		switch(num2) {
//		case "1":
//			reserveEdit();
//			break;
//		case "2":
//			reserveCancel();
//			break;
//		case "0":
//			reserveMine();
//			break;
//		case "00":
//			//PlaceList호출
//			break;
//		default:
//			System.out.println("잘못 입력하셨습니다");
//			return;
//		}
//		
//	}
//
//	
//
//	private void reserveEdit() {
//		// 진짜로 예약을 바꿔야함
//		 System.out.println("=============예약 변경==========");
//		 System.out.println("Ex) 날짜 : 2022/01/01 -> 220101");
//		 System.out.println("Ex) 시간 : 오후 2시 반 -> 1430");
//		 System.out.print("날짜 : ");
//		 String day = sc.nextLine();
//		 //이거 스트링으로 받아도 되는건가
//		 System.out.println();
//		 System.out.print("시간 : ");
//		 String time = sc.nextLine();
//		 System.out.println();
//		 System.out.println("==============================");
//		 
//		 plController.reserveEdit(day, time);
//	}
//	private void reserveCancel() {
//		// 진짜로 예약이 취소되야함
//		System.out.println("===========예약 =============");
//		System.out.print("정말 취소하시겠습니까? (Y, N) : ");
//		char cancel = sc.next().charAt(0);
//		System.out.println("============================");
//		switch(cancel) {
//		case 'y', 'Y':
//			//예약을 취소하러 가야함 진짜임진짜임
//			plController.reserveCancel(num);
//			break;
//		case 'n', 'N':
//			reserveInfo();
//			break;
//		default:
//			System.out.println("잘못 입력하셨습니다.");
//			return;
//		}
//	}

}