/**
  * 
  */
package pl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.PrintUserResult;
import common.SearchUserStandard;
import pl.model.dto.PLCategoryDTO;
import pl.model.dto.PLListAndCategoryDTO;
import pl.model.dto.PLMyListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLRservationDTO;
import pl.model.dto.PLUserDTO;
import pl.serivce.PLService;
import pl.view.PLManagerMenu;
import pl.view.PLMemberMenu;
import pl.view.PLMenu;
import pl.view.ResultView;

/**
  * @FileName : PLController.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 : 사용자의 요청을 처리하는 controller view에서 받은 자료를 serivce에 전달
  */
public class PLController {
	
	private final PLService plService;
	private final PLMemberMenu plMemberMenu;
	private final PrintUserResult printUserResult;

	public PLController() {
		plService = new PLService();
		plMemberMenu = new PLMemberMenu();
		printUserResult = new PrintUserResult();
	}

	/**
	  * @return 
	 * @Method Name : myPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 내가 저장한 장소를 전체 출력
	  */
	public List<PLMyListDTO> myPlaceList() {
		int number = 1; // 내 저장소 번호
		ArrayList<PLMyListDTO> list = plService.myPlaceList();
		
	
		return list;
	}

	/**
	  * @param list 
	 * @Method Name : addPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  */
	public void addPlaceList(List<PLMyListAndCategoryDTO> list) {
		list = plService.addPlaceList();
	}

	public void reserveMine() {
		// TODO Auto-generated method stub
		List<PLRservationDTO> reserveList = plService.reserveMine();
		if(reserveList != null) {
			//print.printReserveList(reserveList);
		} else {
			System.out.println("예약 목록 조회 실패");
		}
	}
	public void reserveInfo(int num) {
		// TODO Auto-generated method stub
		PLRservationDTO menu = plService.reserveInfo(num);
		if(menu != null) {
			//print.printMenu(menu);
		} else {
			System.out.println("예약 내역 조회 실패");
		
	}

}
	public void editReserve(int num, String day, String time) {
		// TODO Auto-generated method stub
		PLRservationDTO re = new PLRservationDTO();
		re.setReserve_no(num);
		re.setReserve_day(day);
		re.setReserve_time(time);
		
		if(plService.editReserve(re)) {
			System.out.println("예약 변경 성공");
		} else {
			System.out.println("예약 변경 실패");
		}
	}
	public void cancelReserve(int num) {
		// TODO Auto-generated method stub
		if(plService.cancelReserve(num)) {
			System.out.println("예약 취소 성공");
		} else {
			System.out.println("예약 취소 실패");
		}
	}

	
	
	
	
	
	
	
	
	
	/**
	 * @Method Name : userLogin
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 입력받은 아이디와 비밀번호의 존재 여부 확인하여 처리한 뒤 상황에 맞는 메세지 출력 후 화면이동
	 */
	public void userLogin(PLUserDTO parameter) {
		String userId = parameter.getUser_id();
		String userPwd = parameter.getUser_pwd();
		
		/* 아이디 중복 체크 확인하는 메소드 통해 반환 */
		PLUserDTO checkId = plService.userIdOverlapCheck(userId);
		
		/*아이디 중복 아닐 경우 실행*/
		if(checkId != null) {
			
			/*비밀번호 중복 체크 확인하는 메소드 통해 반환*/
			PLUserDTO checkPwd = plService.userPwdOverlapCheck(userPwd);
			
			/*비밀번호 중복일때 실행하여 안내문 출력*/
			if(checkPwd == null) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				plMemberMenu.roginMenu();
			} else {
				/*로그인 정보가 관리자일때 관리자 전용 화면으로 이동*/
				if(userId.equals("manager") && userPwd.equals("manager")) {
					System.out.println("관리자 로그인 성공!");
					new PLManagerMenu().managerMenu();
				} else {
					/*로그인 정보가 정상적으로 입력됐을때 메인 화면으로 이동*/
					System.out.println("로그인 성공!");
					plMemberMenu.wellcome();
					new PLMenu().mainMenu(userId);
				}
			}
		} else {
			/*아이디, 비밀번호 모두 일치하는 정보가 없는 경우 안내문 출력*/
			System.out.println("일치하는 로그인 정보가 없습니다.");
			plMemberMenu.roginMenu();
		}
		
	}
	
	/**
	 * @Method Name : registUser
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 회원가입에 필요한 데이터를 plService.registUser에 전달하여 반환 값에 따라 메세지 출력 및 처리
	 */
	public void registUser(PLUserDTO parameter) {
		if(plService.registUser(parameter)) {
			printUserResult.printSuccessMessage("insert");
		} else {
			printUserResult.printErrorMessage("insert");
		}
		
	}
	
	/**
	 * @Method Name : checkId
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 회원가입 시 입력받은 아이디가 이미 존재하는지 확인 후 상황에 맞는 메세지 출력 및 처리
	 */
	public String checkId(String parameter) {
		/*회원가입 시 입력한 아이디가 이미 존재하는지 확인*/
		PLUserDTO check = plService.userIdOverlapCheck(parameter);
		
		/*입력한 아이디가 이미 존재할 경우 안내문 출력 후 다시 로그인 화면으로 이동*/
		if(check != null) {
			System.out.println("동일한 아이디가 존재합니다. 회원가입 실패");
			plMemberMenu.roginMenu();
		} else {
			/*존재하지 않는 아이디일 경우 안내문 출력 후 정상 진행*/
			System.out.println("아이디 중복 체크 성공");
		}
		
		return parameter;
	}
	
	/**
	 * @Method Name : selectUserList
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 관리자)사용자 목록 조회 시 전달받은 값으로 판단 후 상황에 맞는 메세지 출력 및 처리
	 */
	public void selectUserList() {
		List<PLUserDTO> userList = plService.selectUserList();
		
		if(userList != null && userList.size() > 0) {
			printUserResult.printUserList(userList);
		} else {
			printUserResult.printErrorMessage("selectList");
		}
		
	}
	
	/**
	 * @Method Name : selectUserOne
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 관리자)사용자 단일 조회 시 전달받은 값으로 판단 후 상황에 맞는 메세지 출력 및 처리
	 */
	public void selectUserOne(SearchUserStandard searchUserStandard) {
		PLUserDTO user = plService.selectUserOne(searchUserStandard);
		
		if(user != null) {
			printUserResult.printUser(user);
		} else {
			printUserResult.printErrorMessage("selectOne");
		}
		
	}
	
	/**
	 * @Method Name : updateUserInfo
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 사용자 정보 변경 시 전달받은 값으로 판단 후 상황에 맞는 메세지 출력 및 처리
	 */
	public void updateUserInfo(PLUserDTO parameter) {
		if(plService.updateUserInfo(parameter)) {
			printUserResult.printSuccessMessage("update");
		} else {
			printUserResult.printErrorMessage("update");
		}

		
	}
	
	/**
	 * @Method Name : withdrawalUserOne
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 사용자 탈퇴 처리 시 전달받은 값으로 판단 후 상황에 맞는 메세지 출력 및 처리, 사용자는 로그인 화면으로 이동
	 */
	public void withdrawalUserOne(String parameter) {
		if(plService.withdrawalUserOne(parameter)) {
			printUserResult.printSuccessMessage("withdrawal");
			plMemberMenu.roginMenu();
		} else {
			printUserResult.printErrorMessage("withdrawal");
		}
		
	}
	
	/**
	 * @Method Name : deleteUserOne
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 관리자)사용자 삭제 처리 시 전달받은 값으로 판단 후 상황에 맞는 메세지 출력 및 처리
	 */
	public void deleteUserOne(int parameter) {
		if(plService.deleteUserOne(parameter)) {
			printUserResult.printSuccessMessage("delete");
		} else {
			printUserResult.printErrorMessage("delete");
		}
		
	}
	
	/**
	 * @Method Name : selectMyInfo
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 사용자 정보 조회 시 전달받은 값으로 판단 후 상황에 맞는 메세지 출력 및 처리
	 */
	public void selectMyInfo(String parameter) {
		PLUserDTO user = plService.selectMyInfo(parameter);
		
		if(user != null) {
			printUserResult.printMyInfo(user);
		} else {
			printUserResult.printErrorMessage("selectOne");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @FileName : PLController.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void selectAllName() {
		ArrayList<PLListAndCategoryDTO> placeList = plService.selectAllName();
		
		if(placeList != null) {
			for(PLListAndCategoryDTO list : placeList) {
				System.out.print(list.getPl_no() + " ");
				System.out.println(list.getPl_name());
				// 출력 후에 매장에 대해 선택하는 화면 필요함(print method)
			}
		} else {
			System.out.println("에러발생");
		}
		
	}

	/**
	 * @FileName : PLController.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void selectAllAddress() {
		ArrayList<PLListAndCategoryDTO> placeList = plService.selectAllAddress();
		
		if(placeList != null) {
			for(PLListAndCategoryDTO list : placeList) {
				System.out.print(list.getRownum() + " | ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getPl_address());
				// 출력 후에 매장에 대해 선택하는 화면 필요함(print method)
			}
		} else {
			System.out.println("에러발생");
		}
		
	}

	/**
	 * @FileName : PLController.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void selectAllScore() {
		ArrayList<PLListAndCategoryDTO> placeList = plService.selectAllScore();
		
		if(placeList != null) {
			for(PLListAndCategoryDTO list : placeList) {
				System.out.print(list.getRownum() + " | ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getScore() + "점");
				// 출력 후에 매장에 대해 선택하는 화면 필요함(print method)
			}
		} else {
			System.out.println("에러발생");
		}
	}

	/**
	 * @FileName : PLController.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void selectAllCategory() {
		ArrayList<PLListAndCategoryDTO> placeList = plService.selectAllCategory();
	//	ArrayList<PLCategoryDTO> category = plService.selectOnlyCategory();
		
		if(placeList != null) {
			for(PLListAndCategoryDTO list : placeList) {
					System.out.print(list.getRownum() + " | ");
					System.out.println(list.getPl_name() + " | ");
			}
		} else {
			System.out.println("에러발생");
		}
		
	}

}
