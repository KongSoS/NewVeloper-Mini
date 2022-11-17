package pl.view;

import java.util.Scanner;



public class PL_Menu {

	private PL_ReserveMenu remenu = new PL_ReserveMenu();
	private PL_UserInfoMenu plUserInfoMenu = new PL_UserInfoMenu();
	private subView sv = new subView();
	
	/**
	 * @param userId 
	 * @Method Name : mainMenu
	 * @작성일 : 2022. 11. 11.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 : 처음 보여지는 메뉴
	 */
		
	public void mainMenu(String userId) {
		
		// 수정 
		System.out.println(userId);
		//
		Scanner sc = new Scanner(System.in);

		do { // 메인메뉴를 보여주는 반복문
			System.out.println("=========== PLACE LIST ===========");
			System.out.println("1. 추천 장소");
			System.out.println("2. 내 장소");
			System.out.println("3. 내 장소에 새로운 장소 등록하기");
			System.out.println("4. 내 장소 내보내기");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 내 예약");
			System.out.println("0. 로그아웃");
			System.out.println("==================================");
			System.out.print("메뉴 관리 번호를 입력하세요 : ");
			int no = sc.nextInt();

			switch (no) {
			case 1:selectSort(); break;
			case 2:sv.myPlaceList(userId); break;
			case 3:sv.addPlaceList(userId); break;
			case 4:sv.fileOut(userId); break;
			case 5:plUserInfoMenu.userInfoMenu(userId); break;
			case 6:remenu.reserveMine(); break;
			case 0:System.out.println("프로그램을 종료합니다. "); return;
			default:System.out.println("잘못 입력하셨습니다 다시 입력하세요 "); break;
			}

		} while (true);
	}

	/**
	 * @FileName : PLMenu.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소에 관련된 메소드
	 */
	private void selectSort() {
		
		Scanner sc = new Scanner(System.in);
		
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
			case 1 : sv.selectAllName(); break;
			case 2 : sv.selectAllAddress(); break;
			case 3 : sv.selectAllScore(); break;
			case 4 : sv.selectAllCategory(); break;
			case 0 : return;
			default : System.out.println("잘못 입력하셨습니다 다시 입력하세요 "); break;
			}
		} while (true);
	}
	
}
