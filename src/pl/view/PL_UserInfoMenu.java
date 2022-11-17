package pl.view;

import java.util.Scanner;

import pl.controller.PL_Controller;
import pl.model.dto.PL_ReservationDTO;
import pl.model.dto.PL_UserDTO;

/**
 * @FileName : PLUserInfoMenu.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 16.
 * @작성자 : 성식
 * @프로그램 설명 : 메인 메뉴에서 회원 정보 수정을 통해 이동, 회원 정보 조작 가능
 */
public class PL_UserInfoMenu {
	
	PL_Controller plController = new PL_Controller();
	
	/**
	 * @MethodName : userInfoMenu
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @Method 설명 : 사용자 정보 확인 메뉴, 정보 조작 가능
	 */
	public void userInfoMenu(String userId) {
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("=========== My Information Menu ===========");
			System.out.println("1. 회원 정보 조회");
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 회원 탈퇴");
			System.out.println("0. 이전 메뉴로");
			System.out.println("===========================================");
			System.out.print("메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();

			switch (no) {
			case 1:
				plController.selectMyInfo(userId);
				break;
			case 2:
				plController.updateUserInfo(inputUserInfo(userId));
				break;
			case 3:
				checkWith(userId);
				break;
			case 0:
				return;
			default :
				System.out.println("잘못 선택하셨습니다. 다시 입력하세요.");
				break;
			}
		} while (true);

	}
	
	/**
	 * @MethodName : inputUserInfo
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식 
	 * @Method 설명 : 사용자 정보 선택적으로 수정 가능
	 */
	private PL_UserDTO inputUserInfo(String userId) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("최소 한 개 이상의 변경사항을 입력하세요");
		System.out.print("변경될 사용자 비밀번호를 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		String userPwd = sc.nextLine();
		System.out.print("변경될 사용자 이름을 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		String userName = sc.nextLine();
		System.out.print("변경될 사용자 전화번호를 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		String userPhone = sc.nextLine();
		
		PL_UserDTO parameter = new PL_UserDTO();
		parameter.setUser_id(userId);
		parameter.setUser_pwd(userPwd);
		parameter.setUser_name(userName);
		parameter.setPhone(userPhone);
		
		return parameter;
		
	}
	
	public void checkWith(String userId) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정말 탈퇴하시겠습니까? (Y, N) : ");
		char answer = sc.next().toUpperCase().charAt(0);
		System.out.println("============================");
		
		switch(answer) {
		case 'Y':
			plController.withdrawalUserOne(userId);
			System.exit(0);
		case 'N':
			return;
		default :
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
	}

}
