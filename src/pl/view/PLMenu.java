package pl.view;

import java.util.Scanner;

import pl.controller.PLController;

public class PLMenu{

	private Scanner sc = new Scanner(System.in);
	private PLController plController = new PLController();
	private PLReserveMenu remenu = new PLReserveMenu();
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
				remenu.reserveMine();  //클래스를 분리 안하자니 int num을 공유해야 하는데 방법을 모르겠다.
				
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
	
	
	
		
}
