package pl.view;

import java.util.Scanner;

import pl.controller.PLController;
import pl.model.dto.PLListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;

public class PLMenu {

	/**
	 * @Method Name : mainMenu
	 * @작성일 : 2022. 11. 11.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 : 처음 보여지는 메뉴
	 */
	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		PLReserveMenu remenu = new PLReserveMenu();
		PLController controller = new PLController();
		subView sv = new subView();
		PLListAndCategoryDTO placDTO = new PLListAndCategoryDTO();
		
		do { // 메인메뉴를 보여주는 반복문
			System.out.println("=========== PLACE LIST ===========");
			System.out.println("1. 추천 장소");
			System.out.println("2. 내 장소");
			System.out.println("3. 내 장소에 새로운 장소 등록하기");
			System.out.println("4. 내 장소 내보내기");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 내 예약");
			System.out.println("0. 프로그램 종료");
			System.out.println("==================================");
			System.out.print("메뉴 관리 번호를 입력하세요 : ");
			int no = sc.nextInt();

			switch (no) {
			case 1:
				sv.selectSort();
				break;
			case 2:
				sv.myPlaceList();
				break;
			case 3:
				sv.addPlaceList();
				break;
			case 4:
				sv.fileOut();
				break;
			case 5:

				break;
			case 6:
				remenu.reserveMine();
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
