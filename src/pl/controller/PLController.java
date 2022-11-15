/**
  * 
  */
package pl.controller;

import java.util.ArrayList;
import java.util.List;

import pl.model.dto.PLMyListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLRservationDTO;
import pl.serivce.PLService;
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

	public PLController() {
		plService = new PLService();
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

}
