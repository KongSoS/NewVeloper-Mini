package common;

import java.util.List;

import pl.model.dto.PL_UserDTO;

/**
 * @FileName : PrintUserResult.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 16.
 * @작성자 : 성식
 * @프로그램 설명 : 회원과 관련된 메소드의 결과를 출력해주는 클래스
 */
public class PrintUserResult {
	
	/**
	 * @MethodName : printUserList
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식 
	 * @Method 설명 : 리스트에 저장된 사용자 값을 반복문을 통해 출력하는 메소드
	 */
	public void printUserList(List<PL_UserDTO> userList) {
		
		for(PL_UserDTO user : userList) {
			System.out.println(user);
		}
		
	}
	
	/**
	 * @MethodName : printUser
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식 
	 * @Method 설명 : 전달받은 사용자 값을 출력하는 메소드
	 */
	public void printUser(PL_UserDTO user) {
		
		System.out.println(user);
		
	}
	
	/**
	 * @MethodName : printUser
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식 
	 * @Method 설명 : 사용자가 정보 조회 시 출력되는 사용자 전용 출력 메소드
	 */
	public void printMyInfo(PL_UserDTO user) {
		
		System.out.println("========= 회원정보 ========= \n회원번호 : " + user.getUser_id() + "\n비밀번호 : " + user.getUser_pwd() + "\n이름 : "
			      + user.getUser_name() + "\n전화번호 : " + user.getPhone() + "\n가입일 : " + user.getEnroll_date());
		
	}

	/**
	 * @MethodName : printSuccessMessage
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식 
	 * @Method 설명 : 실행 실패 시 호출되는 메세지 메소드
	 */
	public void printSuccessMessage(String successCode) {
		
		String successMessage = "";
		switch(successCode) {
			case "insert" :
				successMessage = "신규 회원 등록에 성공하셨습니다.";
				break;
			case "update" :
				successMessage = "회원 정보 수정에 성공하셨습니다.";
				break;
			case "delete" :
				successMessage = "회원 삭제에 성공하셨습니다.";
				break;
			case "withdrawal" :
				successMessage = "회원 탈퇴 처리에 성공하셨습니다.\n로그인 화면으로 돌아갑니다.";
				break;
		}
		System.out.println(successMessage);
		
	}
	
	/**
	 * @MethodName : printErrorMessage
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식 
	 * @Method 설명 : 실행 실패 시 호출되는 메세지 메소드
	 */
	public void printErrorMessage(String errorCode) {// 각 메소드에서 호출시케이스마다 추가하면서 하자
		
		String errorMessage = "";
		switch(errorCode) {
			case "selectList" :
				errorMessage = "회원 목록 조회에 실패하셨습니다.";
				break;
			case "selectOne" :
				errorMessage = "회원 조회에 실패하셨습니다.";
				break;
			case "insert" :
				errorMessage = "신규 회원 등록에 실패하셨습니다.";
				break;
			case "update" :
				errorMessage = "회원 정보 수정에 실패하셨습니다.";
				break;
			case "delete" :
				errorMessage = "회원 삭제에 실패하셨습니다.";
				break;
			case "withdrawal" :
				errorMessage = "회원 탈퇴 처리에 실패하셨습니다.";
				break;
		}
		System.out.println(errorMessage);
		
	}
	
}
