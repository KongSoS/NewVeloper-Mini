package pl.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import common.PrintUserResult;
import common.SearchUserStandard;
import pl.model.dto.PL_ListAllDTO;
import pl.model.dto.PL_ListAndReserveDTO;
import pl.model.dto.PL_MyListDTO;
import pl.model.dto.PL_ReservationDTO;
import pl.model.dto.PL_UserDTO;
import pl.serivce.PL_Service;
import pl.view.PL_ManagerMenu;
import pl.view.PL_MemberMenu;
import pl.view.PL_Menu;

/**
 * @FileName : PLController.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 11.
 * @작성자 : heojaehong
 * @프로그램 설명 : 사용자의 요청을 처리하는 controller view에서 받은 자료를 serivce에 전달
 */
public class PL_Controller {
	
	private final PL_Service plService;
	private final PL_MemberMenu plMemberMenu;
	private final PrintUserResult printUserResult;

	public PL_Controller() {
		
		plService = new PL_Service();
		plMemberMenu = new PL_MemberMenu();
		printUserResult = new PrintUserResult();
		
	}

   /**
    * @MethodName : selectAllName
    * @작성일 : 2022. 11. 15.
    * @작성자 : jihee
    * @Method 설명 : 이름을 기준으로 추천 장소를 정렬하는 메소드
    */
	public ArrayList<PL_ListAllDTO> selectAllName() {
		
		ArrayList<PL_ListAllDTO> placeList = plService.selectAllName();
		
		return placeList;
		
	}

   /**
    * @MethodName : selectAllAddress
    * @작성일 : 2022. 11. 15.
    * @작성자 : jihee
    * @Method 설명 : 주소를 기준으로 추천 장소를 정렬하는 메소드
    */
	public ArrayList<PL_ListAllDTO> selectAllAddress() {
		
		ArrayList<PL_ListAllDTO> placeList = plService.selectAllAddress();
		
		return placeList;
		
	}

   /**
    * @MethodName : selectAllScore
    * @작성일 : 2022. 11. 15.
    * @작성자 : jihee
    * @Method 설명 : 별점를 기준으로 추천 장소를 정렬하는 메소드 
    */
	public ArrayList<PL_ListAllDTO> selectAllScore() {
		
		ArrayList<PL_ListAllDTO> placeList = plService.selectAllScore();
		
		return placeList;
		
	}

   /**
    * @MethodName : selectAllCategory
    * @작성일 : 2022. 11. 15.
    * @작성자 : jihee
    * @Method 설명 : 카테고리를 기준으로 추천 장소를 정렬하는 메소드 
    */
	public ArrayList<PL_ListAllDTO> selectAllCategory() {
		
		ArrayList<PL_ListAllDTO> placeList = plService.selectAllCategory();
		
		return placeList;
		
	}
	
   /**
    * @MethodName : saveMyList
    * @작성일 : 2022. 11. 15.
    * @작성자 : jihee
    * @Method 설명 : 추천장소 리스트에서 내 장소 리스트로 저장하는 메소드
    */
	public void saveMyList(PL_ListAllDTO parameter, int userNo) {
		
		String name = parameter.getPl_name();
		String address = parameter.getPl_address();
		String tel = parameter.getPl_tel();
		int score = parameter.getScore();
		String catecode = parameter.getCategory().getCategory_code();
		String tagcode = parameter.getTag().getTag_code();
		String reserve = parameter.getPl_reserve();
		
		PL_MyListDTO myList = new PL_MyListDTO();
		myList.setUser_no(userNo);
		myList.setPl_name(name);
		myList.setPl_address(address);
		myList.setPl_tel(tel);
		myList.setScore(score);
		myList.setPl_catecode(catecode);
		myList.setPl_tagcode(tagcode);
		myList.setPl_reserve(reserve);
		
		if(plService.saveMyList(myList)) {
			System.out.println("저장 완료");
		}
		else {
			System.out.println("저장 실패");
		}
		
	}
 
   /**
    * @MethodName : myPlaceList
    * @작성일 : 2022. 11. 11.
    * @작성자 : heojaehong
    * @Method 설명 : 내가 저장한 장소를 전체 출력
    */
	public List<PL_MyListDTO> myPlaceList(int userNO) {
		
		ArrayList<PL_MyListDTO> placeList = plService.myPlaceList(userNO);
		
		if (!placeList.isEmpty()) {
			System.out.println("내 장소 조회 성공");
		}else {
			System.out.println("내 장소가 비어있습니다.");
		}
		
		return placeList;
		
	}

   /**
    * @MethodName : myPlaceList
    * @작성일 : 2022. 11. 11.
    * @작성자 : heojaehong
    * @Method 설명 : 새로운 장소를 직접 등록하는 메소드
    */	
	public void insertMyPlace(PL_MyListDTO place) {
		
		plService.insertMyPlace(place);
	
	}
	
   /**
    * @MethodName : myPlaceList
    * @작성일 : 2022. 11. 15.
    * @작성자 : heojaehong
    * @Method 설명 : 내가 선택한 장소를 삭제하는 메소드
    */	
	public void deleteMyList(int plNo) {
		
		if(plService.deleteMyList(plNo)) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제 실패");
		}
		
	}
 
   /**
    * @MethodName : myPlaceList
    * @작성일 : 2022. 11. 15.
    * @작성자 : heojaehong
    * @Method 설명 : 내 리스트에 저장된 장소를 수정하는 메소드
    */	
	public void updateMyList(PL_MyListDTO place) {
		
		plService.updateMyList(place);
	
	}
 
   /**
    * @MethodName : myPlaceList
    * @작성일 : 2022. 11. 15.
    * @작성자 : heojaehong
    * @Method 설명 : 내 리스트의 정보를 txt파일로 내보내는 메소드
    */	
	public void fileOut(int userNO) {
		
		try {
			OutputStream out = null;
			File file = new File("MyPLFile.txt");
			file.createNewFile();
			
			System.out.println("파일 생성 완료! " + file);
			out = new BufferedOutputStream(new FileOutputStream(file));
			List<PL_MyListDTO> fList = plService.myPlaceList(userNO);

			System.out.println("list에 값 넣기 : " + fList);
			for(int i = 0; i < fList.size(); i++) {
				System.out.println("list의 값: " + fList);
				String contents = "가게 이름 : " + fList.get(i).getPl_name() + ", 주소 : " + fList.get(i).getPl_address() 
						+ ", 전화번호 : " + fList.get(i).getPl_tel() + ", 별점 : " + fList.get(i).getScore() + "\n";
				
				byte[] b = contents.getBytes();
				
				out.write(b);
			}
			
			out.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public List<PL_ListAndReserveDTO> reserveMine() {
		
		List<PL_ListAndReserveDTO> reserveList = plService.reserveMine();
		
		if (!reserveList.isEmpty()) {
			System.out.println("예약 목록 조회 성공");
		} else {
			System.out.println("예약 목록이 비어있습니다.");
		}
		
		return reserveList;
		
	}

	public void reserveInfo(PL_ListAndReserveDTO reserve) {

		plService.reserveInfo(reserve);
		
		if (reserve != null) {
			System.out.println("예약 내역 조회 성공");
		} else {
			System.out.println("예약 내역이 없습니다.");
		}

	}

	public void editReserve(PL_ReservationDTO reserve) {
		
		if (plService.editReserve(reserve)) {
			System.out.println("예약 변경 성공");
		} else {
			System.out.println("예약 변경 실패");
		}
		
	}
	
	public void cancelReserve(int num) {
		
		if (plService.cancelReserve(num)) {
			System.out.println("예약 취소 성공");
		} else {
			System.out.println("예약 취소 실패");
		}
		
	}
	
	public void addReserve(PL_ReservationDTO reserve) {
		
		if (plService.addReserve(reserve)) {
			System.out.println("예약 성공");
		} else {
			System.out.println("예약 실패");
		}
		
	}

	/**
	 * @MethodName : selectUserInfo
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : Yuri 
	 * @Method 설명 : 로그인한 아이디를 받아서 전달하고, 사용자 정보를 반환
	 */
	public PL_UserDTO selectUserInfo (PL_UserDTO parameter) {
		
		String userId = parameter.getUser_id();
		PL_UserDTO user = plService.selectUserInfo(userId);
		
		return user;
		
	}
	
	/**
	 * @MethodName : userLogin
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식 
	 * @Method 설명 : 입력받은 아이디와 비밀번호의 존재 여부 확인하여 처리한 뒤 상황에 맞는 메세지 출력 후 화면이동
	 */
	public void userLogin(PL_UserDTO parameter) {
		
		String userId = parameter.getUser_id();
		String userPwd = parameter.getUser_pwd();
		
		/* 아이디 중복 체크 확인하는 메소드 통해 반환 */
		PL_UserDTO checkId = plService.userIdOverlapCheck(userId);
		
		/*아이디 중복 아닐 경우 실행*/
		if(checkId != null) {
			
			/*비밀번호 중복 체크 확인하는 메소드 통해 반환*/
			PL_UserDTO checkPwd = plService.userPwdOverlapCheck(userPwd);
			
			/*비밀번호 중복일때 실행하여 안내문 출력*/
			if(checkPwd == null) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				plMemberMenu.roginMenu();
			} else {
				/*로그인 정보가 관리자일때 관리자 전용 화면으로 이동*/
				if(userId.equals("manager") && userPwd.equals("manager")) {
					System.out.println("관리자 로그인 성공!");
					new PL_ManagerMenu().managerMenu();
				} else {
					/*로그인 정보가 정상적으로 입력됐을때 메인 화면으로 이동*/
					System.out.println("로그인 성공!");
					plMemberMenu.wellcome();
					new PL_Menu().mainMenu(userId);
				}
			}
		} else {
			/*아이디, 비밀번호 모두 일치하는 정보가 없는 경우 안내문 출력*/
			System.out.println("일치하는 로그인 정보가 없습니다.");
			plMemberMenu.roginMenu();
			
		}
		
	}
	
	/**
	 * @MethodName : registUser
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식 
	 * @Method 설명 : 회원가입에 필요한 데이터를 plService.registUser에 전달하여 반환 값에 따라 메세지 출력 및 처리
	 */
	public void registUser(PL_UserDTO parameter) {
		
		if(plService.registUser(parameter)) {
			printUserResult.printSuccessMessage("insert");
		} else {
			printUserResult.printErrorMessage("insert");
		}
		
	}
	
	/**
	 * @MethodName : checkId
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식 
	 * @Method 설명 : 회원가입 시 입력받은 아이디가 이미 존재하는지 확인 후 상황에 맞는 메세지 출력 및 처리
	 */
	public String checkId(String parameter) {
		
		/*회원가입 시 입력한 아이디가 이미 존재하는지 확인*/
		PL_UserDTO check = plService.userIdOverlapCheck(parameter);
		
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
	 * @MethodName : selectUserList
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식 
	 * @Method 설명 : 관리자)사용자 목록 조회 시 전달받은 값으로 판단 후 상황에 맞는 메세지 출력 및 처리
	 */
	public void selectUserList() {
		
		List<PL_UserDTO> userList = plService.selectUserList();
		
		if(userList != null && userList.size() > 0) {
			printUserResult.printUserList(userList);
		} else {
			printUserResult.printErrorMessage("selectList");
		}
		
	}
	
	/**
	 * @MethodName : selectUserOne
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식 
	 * @Method 설명 : 관리자)사용자 단일 조회 시 전달받은 값으로 판단 후 상황에 맞는 메세지 출력 및 처리
	 */
	public void selectUserOne(SearchUserStandard searchUserStandard) {
		
		PL_UserDTO user = plService.selectUserOne(searchUserStandard);
		
		if(user != null) {
			printUserResult.printUser(user);
		} else {
			printUserResult.printErrorMessage("selectOne");
		}
		
	}
	
	/**
	 * @MethodName : updateUserInfo
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식 
	 * @Method 설명 : 사용자 정보 변경 시 전달받은 값으로 판단 후 상황에 맞는 메세지 출력 및 처리
	 */
	public void updateUserInfo(PL_UserDTO parameter) {
		
		if(plService.updateUserInfo(parameter)) {
			printUserResult.printSuccessMessage("update");
		} else {
			printUserResult.printErrorMessage("update");
		}
		
	}
	
	/**
	 * @MethodName : withdrawalUserOne
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식 
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
	 * @MethodName : deleteUserOne
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식 
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
	 * @MethodName : selectMyInfo
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식 
	 * @Method 설명 : 사용자 정보 조회 시 전달받은 값으로 판단 후 상황에 맞는 메세지 출력 및 처리
	 */
	public void selectMyInfo(String parameter) {
		
		PL_UserDTO user = plService.selectMyInfo(parameter);
		
		if (user != null) {
			printUserResult.printMyInfo(user);
		} else {
			printUserResult.printErrorMessage("selectOne");
		}
		
	}

	/**
	 * @MethodName : deletePlaceList.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 17.
	 * @작성자 : jihee
	 * @프로그램 설명 : 관리자) 추천장소 리스트에서 장소를 삭제
	 */
	public void deletePlaceList(int plNo) {
		
		if (plService.deletePlaceList(plNo)) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제 실패");
		}
		
	}

	/**
	 * @MethodName : updatePlaceList.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 17.
	 * @작성자 : jihee 
	 * @프로그램 설명 : 관리자) 추천 장소 수정
	 */
	public void updatePlaceList(PL_ListAllDTO place) {
		
		plService.updatePlaceList(place);
		
	}
	
}
