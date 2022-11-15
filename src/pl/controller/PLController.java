/**
  * 
  */
package pl.controller;

import java.util.ArrayList;

import pl.model.dto.PLMyListDTO;
import pl.serivce.PLService;

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
	  * @Method Name : myPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 내가 저장한 장소를 전체 출력
	  */
	public void myPlaceList() {
		int number = 1; // 내 저장소 번호
		ArrayList<PLMyListDTO> list = plService.myPlaceList();
		
		for(PLMyListDTO pd : list) {
			System.out.println("내저장소의 값 :" +number + ":"+ pd );
		}
	}

	/**
	  * @Method Name : addPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  */
	public void addPlaceList() {
		
	}

	public void reserveEdit(String day, String time) {
		// TODO Auto-generated method stub
		//day를 date으로 가져와서 저장해야하는데
	}

	public void reserveCancel(int num) {
		// TODO Auto-generated method stub
		//
	}

}
