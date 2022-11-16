package pl.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import common.SearchUserStandard;
import pl.controller.PLController;
import pl.model.dto.PLUserDTO;
import pl.serivce.PLService;

/**
 * @FileName : PLManagerMenu.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 16.
 * @작성자 : 성식
 * @변경이력 :
 * @프로그램 설명 : 로그인 화면에서 관리자 로그인 정보를 입력 시 이동되는 화면, 회원 관리 및 추천장소 관리가 가능하다.
 */
public class PLManagerMenu {
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * @Method Name : managerMenu
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 관리자 메인 메뉴, 회원 및 추천장소 관리화면으로 이동 가능
	 */
	public void managerMenu() {
		do {
			System.out.println("=========== Manager Menu ===========");
			System.out.println("1. 회원 관리 ");
			System.out.println("2. 추천장소 관리 ");
			System.out.println("0. 프로그램 종료");
			System.out.println("====================================");
			System.out.print("메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();

			switch (no) {
			case 1:
				userManagementMenu();
				break;
			case 2:
				//plController.registUser(inputUser());
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
	 * @Method Name : userManagementMenu
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 회원 관리 메뉴(회원에 대한 조회, 수정, 삭제 등이 가능)
	 */
	private void userManagementMenu() {
		
		PLController plController = new PLController();
		do {
			System.out.println("=========== 회원 관리 ============");
			System.out.println("+ 탈퇴 회원은 2, 3번 사용 불가 \n");
			System.out.println("1. 회원 전체 조회");
			System.out.println("2. 회원 선택 조회");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 영구 삭제");
			System.out.println("0. 이전 메뉴로");
			System.out.println("================================");
			System.out.print("메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 :
					plController.selectUserList();
					break;
				case 2 :
					plController.selectUserOne(inputSearchUser());
					break;
				case 3:
					plController.updateUserInfo(inputUserInfo());
					break;
				case 4:
					plController.deleteUserOne(inputUserNo());
					break;
				case 0 :
					return;
			}
		} while(true);
	}
	
	/**
	 * @Method Name : inputSearchUser
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 회원 단일 조회 시 기준이 될 검색어를 한글로 입력받고 DTO에 컬럼명으로 변환하여 전달한다.
	 */
	private SearchUserStandard inputSearchUser() {
		
		String condition = null;
		String value = null;
		
		System.out.print("검색 기준을 입력해주세요(이름 or 아이디) : ");
		sc.nextLine();
		String inputCon = sc.nextLine();
		
		/*입력받은 문자열을 판단하여 condition 변수에 값 대입*/
		switch (inputCon) {
			case "이름" : {
				condition = "user_name";
				break;
			}
			case "아이디" : {
				condition = "user_id";
				break;
			}
			default:
				System.out.println("다시 입력해주세요.");
				condition = null;
		}
		
		if(condition != null) {
			/*정상적으로 입력받은 경우 검색할 값 입력*/
			System.out.print("검색할 " + condition + "을(를) 입력해주세요 : ");
			value = sc.nextLine();
		} else {
			/*해당되는 값 없는 null일 경우 자신을 호출하여 다시 입력*/
			inputSearchUser();
		}
		
		return new SearchUserStandard(condition, value);
		
	}
	
	/**
	 * @Method Name : inputUserInfo
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 회원 정보 수정에 필요한 데이터를 입력받고 전달한다.
	 */
	private PLUserDTO inputUserInfo() {
		
		System.out.print("변경하려는 사용자 아이디를 입력하세요 : ");
		sc.nextLine();
		String userId = sc.nextLine();
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
	
	/**
	 * @Method Name : inputId
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 사용자 아이디를 입력받고 전달한다.
	 */
	private int inputUserNo() {
		
		System.out.print("삭제할 회원번호를 입력하세요 : ");
		sc.nextLine();
		Integer userNo = sc.nextInt();
		
		return userNo;
	}

}
