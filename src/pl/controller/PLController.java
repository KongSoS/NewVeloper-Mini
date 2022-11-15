/**
  * 
  */
package pl.controller;

import java.util.ArrayList;

import pl.model.dto.PLCategoryDTO;
import pl.model.dto.PLListAndCategoryDTO;
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
