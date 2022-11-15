package common;

import java.util.List;

import pl.model.dto.PLUserDTO;

public class PrintUserResult {
	
	public void printUserList(List<PLUserDTO> userList) {
		
		for(PLUserDTO user : userList) {
			System.out.println(user);
		}
	}
	
	public void printUser(PLUserDTO user) {
		System.out.println(user);
	}
	
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
		}
		
		System.out.println(successMessage);
	}
	
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
		}
		
		System.out.println(errorMessage);
	}
	
	
	
}
