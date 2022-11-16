/**
  * 
  */
package pl.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import pl.model.dto.PLListAllDTO;
import pl.model.dto.PLListAndReserveDTO;
import pl.model.dto.PLReservationDTO;
import pl.serivce.PLService;
import pl.view.subView;

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
	private final PLListAllDTO placDTO;

	public PLController() {
		plService = new PLService();
		placDTO = new PLListAllDTO();
	}

	/**
	  * @return 
	 * @Method Name : myPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 내가 저장한 장소를 전체 출력
	  */
	public List<PLListAllDTO> myPlaceList() {
		ArrayList<PLListAllDTO> list = plService.myPlaceList();
		
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
	public void addPlaceList(PLListAllDTO dto) {
		// System.out.println("컨트롤러의 dto" + dto);
		plService.addPlaceList(dto);
	
	}

	
	public List<PLListAndReserveDTO> reserveMine() {
		subView print = new subView();
		List<PLListAndReserveDTO> reserveList = plService.reserveMine();
		PLListAllDTO pd = new PLListAllDTO();

		if(reserveList != null) {
			System.out.println("예약 목록 조회 성공");
		} else {
			System.out.println("예약 목록 조회 실패");
		}
		return reserveList;
		
	}
	public PLListAndReserveDTO reserveInfo(int num) {
//		subView print = new subView();
		PLListAndReserveDTO menu = plService.reserveInfo(num);
		
		if(menu != null) {
			menu.setReserve_no(num);
			System.out.println("예약 내역 조회 성공");
		} else {
			System.out.println("예약 내역 조회 실패");
		
	}
		return menu;

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
	public ArrayList<PLListAllDTO> selectAllName() {
		
		ArrayList<PLListAllDTO> placeList = plService.selectAllName();
		
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
	public ArrayList<PLListAllDTO> selectAllAddress() {
		ArrayList<PLListAllDTO> placeList = plService.selectAllAddress();
		
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
	public ArrayList<PLListAllDTO> selectAllScore() {
		ArrayList<PLListAllDTO> placeList = plService.selectAllScore();
		
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
	public ArrayList<PLListAllDTO> selectAllCategory() {
		ArrayList<PLListAllDTO> placeList = plService.selectAllCategory();
		
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
	public void saveMyList(PLListAllDTO parameter) {
		
		String name = parameter.getPl_name();
		String address = parameter.getPl_address();
		String tel = parameter.getPl_tel();
		int score = parameter.getScore();
		String catecode = parameter.getCategory().getCategory_code();
		String tagcode = parameter.getTag().getTag_code();
		String reserve = parameter.getPl_reserve();
		
		PLListAllDTO myList = new PLListAllDTO();
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
	public void renamePL(PLListAllDTO placDTO) {
		plService.renamePL(placDTO);
		
			
	}

	public void addReserve(int num, String day, String time) {
		// TODO Auto-generated method stub
		PLReservationDTO re = new PLReservationDTO();
		re.setMy_no(num);
		re.setReserve_day(day);
		re.setReserve_time(time);
		
		if(plService.addReserve(re)) {
			System.out.println("예약 성공");
		} else {
			System.out.println("예약 실패");
		}
	}


	/**
	  * @Method Name : fileOut
	  * @작성일 : 2022. 11. 16.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  */
	public void fileOut() {
		try {
			OutputStream out = null;
			File file = new File("MyPLFile.txt");
			file.createNewFile();
			
			System.out.println("파일 생성 완료! " + file);
			out = new BufferedOutputStream(new FileOutputStream(file));
			List<PLListAllDTO> fList = plService.myPlaceList();

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
