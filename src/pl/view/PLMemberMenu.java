/**
  * 
  */
package pl.view;

import java.util.Scanner;

/**
 * @FileName : PLMemberMenu.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 11.
 * @작성자 : heojaehong
 * @변경이력 :
 * @프로그램 설명 :
 */
public class PLMemberMenu {
	private Scanner sc = new Scanner(System.in);
	PLMenu PMenu = new PLMenu();

	/**
	 * @Method Name : roginMenu
	 * @작성일 : 2022. 11. 11.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 : 로그인 화면
	 */
	public void roginMenu() {

		do { // 메인메뉴를 보여주는 반복문
			System.out.println("=========== PLACE LIST ===========");
			System.out.println("1. 로그인");
			System.out.println("2. 회원 가입");
			System.out.println("==================================");
			int no = sc.nextInt();

			switch (no) {
			case 1:
				PMenu.mainMenu();
				break;

			case 2:

				break;
			default:
				break;
			}
		} while (true);

	}

}
