/**
  * 
  */
package pl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pl.view.subView;
import pl.model.dto.PLListAndCategoryDTO;
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
	private final PLListAndCategoryDTO placDTO;

	public PLController() {
		plService = new PLService();
		placDTO = new PLListAndCategoryDTO();
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
		
		return list;
	}

	/**
	  * @param dto 
	 * @Method Name : addPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  */
	public void addPlaceList(PLListAndCategoryDTO dto) {
		// System.out.println("컨트롤러의 dto" + dto);
		plService.addPlaceList(dto);
	
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
	 * @return 
	 * @FileName : PLController.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public ArrayList<PLListAndCategoryDTO> selectAllName() {
		
		ArrayList<PLListAndCategoryDTO> placeList = plService.selectAllName();
		
		return placeList;
		
	}

	/**
	 * @return 
	 * @FileName : PLController.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public ArrayList<PLListAndCategoryDTO> selectAllAddress() {
		ArrayList<PLListAndCategoryDTO> placeList = plService.selectAllAddress();
		
		return placeList;
		
	}

	/**
	 * @return 
	 * @FileName : PLController.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public ArrayList<PLListAndCategoryDTO> selectAllScore() {
		ArrayList<PLListAndCategoryDTO> placeList = plService.selectAllScore();
		
		return placeList;
	}

	/**
	 * @return 
	 * @FileName : PLController.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public ArrayList<PLListAndCategoryDTO> selectAllCategory() {
		ArrayList<PLListAndCategoryDTO> placeList = plService.selectAllCategory();
		
		return placeList;
		
	}

	/**
	 * @param plListAndCategoryDTO 
	 * @FileName : PLController.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void saveMyList(PLListAndCategoryDTO parameter) {
		
		String name = parameter.getPl_name();
		String address = parameter.getPl_address();
		String tel = parameter.getPl_tel();
		int score = parameter.getScore();
		String catecode = parameter.getCategory().getCategory_code();
		String reserve = parameter.getPl_reserve();
		
		PLMyListDTO myList = new PLMyListDTO();
		myList.setPl_name(name);
		myList.setPl_address(address);
		myList.setPl_tel(tel);
		myList.setScore(score);
		myList.setPl_catecode(catecode);
		myList.setPl_reserve(reserve);
		
		
		if(plService.saveMyList(myList)) {
			System.out.println("저장 완료");
		}
		else {
			System.out.println("저장 실패");
		}
		
	}

	/**
	 * @param plNo 
	 * @FileName : PLController.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void deleteMyList(int plNo) {
		
		if(plService.deleteMyList(plNo)) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제 실패");
		}
		
		
	}


	/**
	  * @Method Name : renamePL
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param inputRename
	  */
	public void renamePL(PLListAndCategoryDTO placDTO) {
		plService.renamePL(placDTO);
		
			
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
