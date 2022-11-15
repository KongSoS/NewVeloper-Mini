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
				selectSort();
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
				break;
			default:
				System.out.println("잘못 입력하셨습니다 다시 입력하세요 ");
				break;
			}

		} while (true);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void selectSort() {
		do {
			System.out.println("=========== PLACE LIST ===========");
			System.out.println("1. 매장명으로 정렬");
			System.out.println("2. 주소로 정렬");
			System.out.println("3. 별점으로 정렬");
			System.out.println("4. 카테고리로 정렬");
			System.out.println("0. 이전 메뉴로");
			System.out.print("원하는 정렬 번호를 입력하세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : plController.selectAllName(); break;
			case 2 : plController.selectAllAddress(); break;
			case 3 : plController.selectAllScore(); break;
			case 4 : plController.selectAllCategory(); break;
			case 0 : return;
			default : System.out.println("잘못 입력하셨습니다 다시 입력하세요 "); 	break;
			}
		} while (true);
		
		// 리스트 출력한 뒤, 원하는 장소에 대한 정보도 출력해야함
		// 정렬기준 선택 후 번호입력하면 장소 정보 출력
		// 번호입력을 어디서 받아야 할까?
	}
	

}