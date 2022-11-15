package pl.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import common.SearchUserStandard;
import pl.controller.PLController;
import pl.model.dto.PLUserDTO;
import pl.serivce.PLService;


public class PLManagerMenu {
	
	Scanner sc = new Scanner(System.in);
	
	public void managerMenu() {
		
		
		PLController plController = new PLController();

		do {
			System.out.println("=========== Manager Menu ===========");
			System.out.println("1. 회원 관리 ");
			System.out.println("2. 추천장소 관리 ");
			System.out.println("0. 프로그램 종료");
			System.out.println("====================================");
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
	
	private void userManagementMenu() {
		
		//Scanner sc = new Scanner(System.in);
		PLService plService = new PLService();
		do {
			System.out.println("=========== 회원 관리 ============");
			System.out.println("1. 회원 목록 조회");
			System.out.println("2. 회원 정보 수정");
			System.out.println("0. 이전 메뉴로");
			System.out.print("메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 :
					plService.selectUserList(inputSearchUser());
					break;
				case 2 :
					//plService.updateUserInformation(inputSearchCriteria());
					break;
				case 0 :
					return;
			}
		} while(true);
	}
	
	private SearchUserStandard inputSearchUser() {
		
		//Scanner sc = new Scanner(System.in);
		System.out.print("검색 기준을 입력해주세요('user_name' or 'user_id') : ");
		String condition = sc.nextLine();
		System.out.print("검색어를 입력해주세요 : ");
		String value = sc.nextLine();
		
		return new SearchUserStandard(condition, value);
		
	}
	
//	private Map<String, Object> inputChangeInfo() {
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("변경할 메뉴 코드를 입력하세요 : ");
//		int code = sc.nextInt();
//		System.out.print("변경할 메뉴 이름을 입력하세요 : ");
//		sc.nextLine();
//		String name = sc.nextLine();
//		System.out.print("변경할 카테고리 코드를 입력하세요 : ");
//		int categoryCode = sc.nextInt();
//		System.out.print("판매 여부를 결정해주세요(Y/N) : ");
//		sc.nextLine();
//		String orderableStatus = sc.nextLine();
//		
//		Map<String, Object> changeInfo = new HashMap<>();
//		changeInfo.put("code", code);
//		changeInfo.put("name", name);
//		changeInfo.put("categoryCode", categoryCode);
//		changeInfo.put("orderableStatus", orderableStatus);
//		
//		return changeInfo;
//	}
	
//	private Map<String, String> inputId() {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("아이디를 입력하세요 : ");
//		String userId = sc.nextLine();
//		
//		Map<String, String> parameter = new HashMap<>();
//		parameter.put("userId", userId);
//		
//		return parameter;
//	}

}
