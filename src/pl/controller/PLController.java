/**
  * 
  */
package pl.controller;

import java.util.ArrayList;
import java.util.List;
import pl.view.subView;
import pl.model.dto.PLListAndCategoryDTO;
import pl.model.dto.PLMyListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLReservationDTO;
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
	  * @return 
	 * @Method Name : myPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 내가 저장한 장소를 전체 출력
	  */
	public List<PLListAndCategoryDTO> myPlaceList() {
		ArrayList<PLListAndCategoryDTO> list = plService.myPlaceList();
		
		if(list != null) {
			System.out.println("내 장소 호출 성공!");
		}else {
			System.out.println("저장한 장소가 없습니다.");
		}
	
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
		
		if(list != null) {
			System.out.println("내 장소 호출 성공!");
		}else {
			System.out.println("저장한 장소가 없습니다.");
		}
	
	}

	public void reserveMine() {
		subView print = new subView();
		List<PLReservationDTO> reserveList = plService.reserveMine();
		PLMyListDTO pd = new PLMyListDTO();
		if(reserveList != null) {
			print.printReserveList(reserveList, pd);
		} else {
			System.out.println("예약 목록 조회 실패");
		}
	}
	public void reserveInfo(int num) {
		subView print = new subView();
		PLReservationDTO menu = plService.reserveInfo(num);
		
		if(menu != null) {
			menu.setReserve_no(num);
			print.printMenu(menu);
		} else {
			System.out.println("예약 내역 조회 실패");
		
	}

}
	public void editReserve(int num, String day, String time) {
		// TODO Auto-generated method stub
		PLReservationDTO re = new PLReservationDTO();
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
		// cancel에는 num을 setter로 전달하지 않은 상태이다.... 예시가 달라서 전달해야할 것 같기도..
		PLReservationDTO re = new PLReservationDTO();
		re.setReserve_no(num);
		if(plService.cancelReserve(num)) {
			
			System.out.println("예약 취소 성공");
		} else {
			System.out.println("예약 취소 실패");
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

	public void addReserve(int num, String day, String time) {
		// TODO Auto-generated method stub
		PLReservationDTO re = new PLReservationDTO();
		re.setReserve_no(num);
		re.setReserve_day(day);
		re.setReserve_time(time);
		
		if(plService.addReserve(re)) {
			System.out.println("예약 성공");
		} else {
			System.out.println("예약 실패");
		}
	}

}
