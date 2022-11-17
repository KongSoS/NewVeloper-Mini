package pl.view;

import java.util.Scanner;

/**
 * @FileName : PLMenu.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 16.
 * @작성자 : heojaehong
 * @프로그램 설명 : 로그인 후 메인메뉴를 출력해주는 화면
 */
public class PL_Menu {

	private PL_ReserveMenu remenu = new PL_ReserveMenu();
	private PL_UserInfoMenu plUserInfoMenu = new PL_UserInfoMenu();
	private PL_ListView plListView = new PL_ListView();
	
	/**
	 * @Method Name : mainMenu
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : heojaehong
	 * @Method 설명 : 로그인 메뉴
	 */
	public void mainMenu(String userId) {
		
		Scanner sc = new Scanner(System.in);

		do {
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
				case 1:
					selectSort(userId);
					break;
				case 2:
					plListView.myPlaceList(userId);
					break;
				case 3:
					plListView.addPlaceList(userId);
					break;
				case 4:
					plListView.fileOut(userId);
					break;
				case 5:
					plUserInfoMenu.userInfoMenu(userId);
					break;
				case 6:
					remenu.reserveMine();
					break;
				case 0:
					System.out.println("로그인 화면으로 돌아갑니다. ");
					return;
				default :
					System.out.println("잘못 입력하셨습니다 다시 입력하세요 ");
					break;
			}
		} while (true);
		
	}

	/**
	 * @param userId 
	 * @FileName : PLMenu.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @프로그램 설명 : 추천 장소에 관련된 메소드
	 */
	private void selectSort(String userId) {
		
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
				case 1:
					plListView.selectAllName(userId);
					break;
				case 2:
					plListView.selectAllAddress(userId);
					break;
				case 3:
					plListView.selectAllScore(userId);
					break;
				case 4:
					plListView.selectAllCategory(userId);
					break;
				case 0:
					return;
				default :
					System.out.println("잘못 입력하셨습니다 다시 입력하세요 ");
					break;
			}
		} while (true);
		
	}
	
}
