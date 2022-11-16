package pl.view;

import java.util.ArrayList;
import java.util.Scanner;

import common.SearchUserStandard;
import pl.controller.PL_Controller;
import pl.model.dto.PL_ListAllDTO;
import pl.model.dto.PL_UserDTO;

/**
 * @FileName : PLManagerMenu.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 16.
 * @작성자 : 성식
 * @변경이력 :
 * @프로그램 설명 : 로그인 화면에서 관리자 로그인 정보를 입력 시 이동되는 화면, 회원 관리 및 추천장소 관리가 가능하다.
 */
public class PL_ManagerMenu {
	PL_Controller plController = new PL_Controller();
	/**
	 * @Method Name : managerMenu
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 관리자 메인 메뉴, 회원 및 추천장소 관리화면으로 이동 가능
	 */
	public void managerMenu() {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("=========== Manager Menu ===========");
			System.out.println("1. 회원 관리 ");
			System.out.println("2. 추천장소 관리 ");
			System.out.println("0. 로그아웃");
			System.out.println("====================================");
			System.out.print("메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();

			switch (no) {
			case 1:
				userManagementMenu();
				break;
			case 2:
				placeManagementMenu();
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
		Scanner sc = new Scanner(System.in);
		
//		PL_Controller plController = new PL_Controller();
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
		Scanner sc = new Scanner(System.in);
		
		String condition = null;
		String value = null;
		
		System.out.print("검색 기준을 입력해주세요(이름 or 아이디) : ");
		//sc.nextLine();
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
	private PL_UserDTO inputUserInfo() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("변경하려는 사용자 아이디를 입력하세요 : ");
		sc.nextLine();
		String userId = sc.nextLine();
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
	
	/**
	 * @Method Name : inputId
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 사용자 아이디를 입력받고 전달한다.
	 */
	private int inputUserNo() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 회원번호를 입력하세요 : ");
		sc.nextLine();
		Integer userNo = sc.nextInt();
		
		return userNo;
	}

	/**
	 * @FileName : PL_ManagerMenu.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 17.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	private void placeManagementMenu() {
		
		int no;
		
		Scanner sc = new Scanner(System.in);
		PL_Controller plController = new PL_Controller();
		
		ArrayList<PL_ListAllDTO> placeList = plController.selectAllName();

		if(placeList != null) {
			System.out.println("=========== 추천장소 리스트 ===========");
			for(PL_ListAllDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.println(list.getPl_name());
			}
			System.out.println("====================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			System.out.println("0. 이전 메뉴로");
			no = sc.nextInt();
			if(no == 0) {
				return;
			}
			else if( no > 0 && no <= placeList.size()){
				selectOne(placeList,no);
			}
			else {
				System.out.println("잘못 입력하셨습니다 다시 입력하세요 ");
			}
			
		} else {
			System.out.println("에러발생");
		}
		
	}

	/**
	 * @FileName : PL_ManagerMenu.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 17.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	private void selectOne(ArrayList<PL_ListAllDTO> placeList, int no) {
		
		int choice;
		
		Scanner sc = new Scanner(System.in);
		PL_Controller plController = new PL_Controller();
		
		System.out.println(placeList.get(no));
		System.out.println("==================== 장소 정보 ====================");
		System.out.println("매장명 : " + placeList.get(no - 1).getPl_name());
		System.out.println("주소 : " + placeList.get(no - 1).getPl_address());
		System.out.println("전화번호 : " + placeList.get(no - 1).getPl_tel());
		System.out.println("별점 : " + placeList.get(no - 1).getScore() + "점");
		System.out.println("카테고리 : " + placeList.get(no - 1).getCategory().getCategory_name());
		System.out.println("태그 : " + placeList.get(no - 1).getTag().getTag_name());
		System.out.println("예약가능여부 : " + placeList.get(no - 1).getPl_reserve());
		System.out.println();
		System.out.println();
		System.out.println("1. 장소 수정하기");
		System.out.println("2. 장소 삭제하기");
//		System.out.println("0. 이전 메뉴로");
//		System.out.println("9. 메인 메뉴로");
		System.out.println("=================================================");
		System.out.print("번호를 입력하세요 : ");
		choice = sc.nextInt();
		sc.nextLine();
		
		switch (choice) {
		case 1:updatePlaceList(placeList.get(no - 1)); break;
		case 2:plController.deletePlaceList(placeList.get(choice).getPl_no()); break;
		case 0: return;
		//case 9:new PLMenu().mainMenu(); break;
		default:System.out.println("잘못입력하셨습니다."); break;

		}
		
	}

	/**
	 * @FileName : PL_ManagerMenu.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 17.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	private void updatePlaceList(PL_ListAllDTO place) {
		int category;
		int tag;
		
		Scanner sc = new Scanner(System.in);
		PL_Controller plController = new PL_Controller();
		
		//System.out.println("renamePL에 있는 DTO : " + place.getPl_no());
		System.out.println("==================== 장소 수정 ====================");
		System.out.println("변경될 이름을 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		place.setPl_name(sc.nextLine());
		System.out.println("변경될 주소를 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		place.setPl_address(sc.nextLine());
		System.out.println("변경될 전화번호를 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		place.setPl_tel(sc.nextLine());
		System.out.println("변경될 별점를 입력하세요 (필수입력) : ");
		place.setScore(sc.nextInt());
		System.out.println("1. 한식, 2. 중식, 3. 일식, 4. 양식, 5. 분식, 6. 카페&디저트");
		System.out.println("변경될 카테고리를 입력하세요 (필수입력) : ");
		category = sc.nextInt();
		sc.nextLine();
		System.out.println("변경될 예약여부를 입력하세요 (Y/N) (건너뛰기 -> 빈칸입력) : ");
		place.setPl_reserve(sc.nextLine().toUpperCase());
		System.out.println("1. 맛있는, 2. 분위기 좋은, 3. 친절한, 4. 깨끗한, 5. 양이 많은");
		System.out.println("변경될 태그를 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		tag = sc.nextInt();
		sc.nextLine();
		switch (category) {
		case 1:place.setPl_catecode("C1");break;
		case 2:place.setPl_catecode("C2");break;
		case 3:place.setPl_catecode("C3");break;
		case 4:place.setPl_catecode("C4");break;
		case 5:place.setPl_catecode("C5");break;
		case 6:place.setPl_catecode("C6");break;
		}
		// 태그생성
		switch (tag) {
		case 1:place.setPl_tagcode("T1"); break;
		case 2:place.setPl_tagcode("T2"); break;
		case 3:place.setPl_tagcode("T3"); break;
		case 4:place.setPl_tagcode("T4"); break;
		case 5:place.setPl_tagcode("T5"); break;
		}
		
		plController.updatePlaceList(place);
		
	}
}
