/**
  * 
  */
package pl.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import pl.controller.PLController;
import pl.model.dto.PLListAndCategoryDTO;

/**
  * @FileName : MoreInfoView.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 15. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 :
  */
public class MoreInfoView {
	Scanner sc = new Scanner(System.in);
	PLMenu pm = new PLMenu();
	PLController controller = new PLController();
	PLListAndCategoryDTO placDTO = new PLListAndCategoryDTO();
	/**
	  * @Method Name : MoreInfo
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 내 장소 상세 페이지
	  * @param 
	  */
	public void MoreInfo(PLListAndCategoryDTO placDTO) {
		int num;
		System.out.println("==================== 장소 정보 ====================");
		System.out.println("이름 : " + placDTO.getPl_name());
		System.out.println("장소 : " + placDTO.getPl_address());
		System.out.println("예약 : " + placDTO.getPl_reserve());
		System.out.println("별점 : " + placDTO.getScore());
		System.out.println("태그 : ");
		System.out.println("전화번호 : " + placDTO.getPl_tel());
		System.out.println();
		System.out.println();
		System.out.println("1. 장소 수정");
		System.out.println("2. 장소 삭제");
		System.out.println("0. 메인 메뉴로");
		System.out.println("=================================================");
		System.out.print("번호를 입력하세요 : " );
		num = sc.nextInt();
		sc.nextLine();
		switch (num) {
		case 1:
			renamePL(placDTO);
			break;
		case 2:
			delPL();
			break;			
		case 0:
//			pm.mainMenu();
			break;
			
			
		default:
			break;
		}
		
	}
	
	

	/**
	  * @Method Name : renamePL
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param placDTO2
	  */
	private void renamePL(PLListAndCategoryDTO placDTO) {
		// TODO Auto-generated method stub
		int category;
		System.out.println("renamePL에 있는 DTO : " + placDTO.getPl_no());
		System.out.println("==================== 장소 수정 ====================");
		System.out.println("이름을 입력하세요 : ");
		placDTO.setPl_name(sc.next());
		System.out.println("주소를 입력하세요 : ");
		placDTO.setPl_address(sc.next());
		System.out.println("전화번호를 입력하세요 : ");
		placDTO.setPl_tel(sc.next());
		System.out.println("별점를 입력하세요 : ");
		placDTO.setScore(sc.nextInt());
		System.out.println("1. 한식, 2. 중식, 3. 일식, 4. 양식, 5. 분식, 6. 카페&디저트");
		System.out.println("카테고리를 입력하세요 : ");
		category = sc.nextInt();
		System.out.println("예약여부를 입력하세요 (Y/N): ");
		placDTO.setPl_reserve(sc.next().toUpperCase());
		switch (category) {
		case 1:
			placDTO.setPl_catecode("C1");
			break;
		case 2:
			placDTO.setPl_catecode("C2");
			break;
		case 3:
			placDTO.setPl_catecode("C3");
			break;
		case 4:
			placDTO.setPl_catecode("C4");
			break;
		case 5:
			placDTO.setPl_catecode("C5");
			break;
		case 6:
			placDTO.setPl_catecode("C6");
			break;
		}
		controller.renamePL(placDTO);
		
	}



	/**
	  * @Method Name : delPL
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 장소 삭제 메소드
	  */
	private void delPL() {
		// TODO Auto-generated method stub
		
	}
	
}
