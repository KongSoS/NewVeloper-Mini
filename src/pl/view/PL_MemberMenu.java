package pl.view;

import java.util.Scanner;
import pl.controller.PL_Controller;
import pl.model.dto.PL_UserDTO;

/**
 * @FileName : PLMemberMenu.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 15.
 * @작성자 : 성식
 * @변경이력 :
 * @프로그램 설명 : 사용자는 중복되지 않는 아이디로 회원가입을 통해 로그인을 해야하고, 로그인 시 메인메뉴 화면으로 이동된다.
 * @프로그램 설명 : 첫번째 화면
 */
public class PL_MemberMenu {
	
	/**
	 * @Method Name : roginMenu
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 로그인 메뉴
	 */
	public void roginMenu() {

		Scanner sc = new Scanner(System.in);
		PL_Controller plController = new PL_Controller();

		do { // 메인메뉴를 보여주는 반복문
			System.out.println("=========== PLACE LIST ===========");
			System.out.println("1. 로그인 ");
			System.out.println("2. 회원 가입 ");
			System.out.println("0. 프로그램 종료");
			System.out.println("==================================");
			System.out.print("메뉴 번호를 입력하세요 : ");
			
			int no = sc.nextInt();

			switch (no) {
			case 1:
				plController.userLogin(inputLogin());
				break;
			case 2:
				plController.registUser(inputUser());
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못 선택하셨습니다. 다시 입력하세요.");
				break;
			}
		} while (true);
		
	}

	/**
	 * @Method Name : inputLogin
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 사용자 로그인 정보 입력 메소드
	 * @return : 입력받은 아이디를 Map 변수에 담아 반환
	 */
	private PL_UserDTO inputLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디를 입력하세요 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String userPwd = sc.nextLine();
		
		PL_UserDTO parameter = new PL_UserDTO();
		parameter.setUser_id(userId);
		parameter.setUser_pwd(userPwd);
		
		return parameter;
		
	}

	/**
	 * @Method Name : inputUser
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 회원가입 정보 입력 메소드
	 * @return : 입력받은 아이디를 Map 변수에 담아 반환
	 */
	private PL_UserDTO inputUser() {
		
		Scanner sc = new Scanner(System.in);
		PL_Controller plController = new PL_Controller();
		
		System.out.println("=========== 회원 가입 ============");
		
		/*입력한 아이디가 이미 존재하는지 중복 체크*/
		String userId = plController.checkId(inputId());

		System.out.print("비밀번호를 입력하세요 : ");
		String userPwd = sc.nextLine();
		System.out.print("이름을 입력하세요 : ");
		String userName = sc.nextLine();
		System.out.print("전화번호를 입력하세요 : ");
		String userPhone = sc.nextLine();
		
		PL_UserDTO parameter = new PL_UserDTO();
		parameter.setUser_id(userId);
		parameter.setUser_pwd(userPwd);
		parameter.setUser_name(userName);
		parameter.setPhone(userPhone);
		
		return parameter;
		
	}
		
	/**
	 * @Method Name : inputId
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 아이디 중복 체크 확인용 정보 입력 메소드
	 * @return : 입력받은 아이디를 Map 변수에 담아 반환
	 */
	private String inputId() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디를 입력하세요 : ");
		String userId = sc.nextLine();
		
		return userId;
		
	}

	/**
	 * @Method Name : wellcome
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 로그인 성공 시 출력될 환영 문구
	 */
	public void wellcome() {
		
		try {
			System.out.println(" ____    __     ____  _______  __       __        ______   ______   .___  ___.  _______ ");
			Thread.sleep(700);
			System.out.println(" \\   \\  /  \\  /    / |   ____||  |     |  |      /      | /  __  \\  |   \\/   | |   ____|");
			Thread.sleep(700);
			System.out.println("  \\   \\/    \\/    /  |  |__   |  |     |  |     |  ,----'|  |  |  | |  \\  /  | |  |__   ");
			Thread.sleep(700);
			System.out.println("   \\             /   |   __|  |  |     |  |     |  |     |  |  |  | |  |\\/|  | |   __|  ");
			Thread.sleep(700);
			System.out.println("    \\    /\\     /    |  |____ |  `----.|  `----.|  `----.|  `--'  | |  |  |  | |  |____ ");
			Thread.sleep(700);
			System.out.println("     \\__/  \\__ /     |_______||_______||_______| \\______| \\______/  |__|  |__| |_______|");
			Thread.sleep(1000);
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
