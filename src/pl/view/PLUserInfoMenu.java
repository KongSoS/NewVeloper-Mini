package pl.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import common.SearchUserStandard;
import pl.controller.PLController;
import pl.model.dto.PLUserDTO;
import pl.serivce.PLService;

/**
 * @FileName : PLUserInfoMenu.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 16.
 * @작성자 : 성식
 * @변경이력 :
 * @프로그램 설명 : 메인 메뉴에서 회원 정보 수정을 통해 이동, 회원 정보 조작 가능
 */
public class PLUserInfoMenu {
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * @Method Name : userInfoMenu
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 사용자 정보 확인 메뉴, 정보 조작 가능
	 */
	public void userInfoMenu(String userId) {
		PLController plController = new PLController();
		
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
				plController.withdrawalUserOne(userId);
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 선택하셨습니다. 다시 입력하세요.");
				break;
			}
		} while (true);

	}
	
	/**
	 * @Method Name : inputUserInfo
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 사용자 정보 선택적으로 수정 가능
	 */
	private PLUserDTO inputUserInfo(String userId) {
		
		sc.nextLine();
		System.out.print("변경될 사용자 비밀번호를 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		String userPwd = sc.nextLine();
		System.out.print("변경될 사용자 이름을 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		String userName = sc.nextLine();
		System.out.print("변경될 사용자 전화번호를 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		String userPhone = sc.nextLine();
		
		PLUserDTO parameter = new PLUserDTO();
		parameter.setUser_id(userId);
		parameter.setUser_pwd(userPwd);
		parameter.setUser_name(userName);
		parameter.setPhone(userPhone);
		
		return parameter;
	}

}
