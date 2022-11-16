/**
  * 
  */
package pl.view;

import java.util.ArrayList;
import java.util.Scanner;

import pl.controller.PLController;
import pl.model.dto.PLListAllDTO;
import pl.model.dto.PLReservationDTO;

/**
 * @FileName : MoreInfoView.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 15.
 * @작성자 : heojaehong
 * @변경이력 :
 * @프로그램 설명 : 상세 정보 페이지 클래스

 */
public class MoreInfoView {
	private Scanner sc = new Scanner(System.in);
	private PLController controller = new PLController();
	private PLListAllDTO placDTO = new PLListAllDTO();
	private PLReserveMenu rm = new PLReserveMenu();
	private PLReservationDTO rd = new PLReservationDTO();

	/**
	 * @Method Name : MoreInfo
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 : 내 장소 상세 페이지
	 * @param
	 */

	public void MoreInfo(PLListAllDTO placDTO) {

		int num;
		
		System.out.println("==================== 장소 정보 ====================");
		System.out.println("이름 : " + placDTO.getPl_name());
		System.out.println("주소 : " + placDTO.getPl_address());
		System.out.println("예약 : " + placDTO.getPl_reserve());
		System.out.println("별점 : " + placDTO.getScore());
		System.out.println("카테고리 : " + placDTO.getCategory().getCategory_name());
		System.out.println("태그 : " + placDTO.getTag().getTag_name());
		System.out.println("전화번호 : " + placDTO.getPl_tel());
		System.out.println();
		System.out.println();
		System.out.println("1. 장소 수정");
		System.out.println("2. 장소 삭제");
		switch (placDTO.getPl_reserve()) {
		case "Y":System.out.println("3. 예약하기"); break;
		}
		System.out.println();
		System.out.println("9. 이전 메뉴로");
		System.out.println("0. 메인 메뉴로");
		System.out.println("=================================================");
		System.out.print("번호를 입력하세요 : ");
		num = sc.nextInt();
		sc.nextLine();
		switch (num) {
		case 1:renamePL(placDTO); break;
		case 2:controller.deleteMyList(placDTO.getPl_no()); break;
		case 3:rm.addReserve(rd.getMy_no());
		case 9:new subView().myPlaceList();
		case 0:new PLMenu().mainMenu(); break;

		default:System.out.println("잘못입력하셨습니다."); break;
		}

	}

	/**
	 * @Method Name : renamePL
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 : 내 장소리스트에 있는 장소 정보를 수정하는 메소드
	 * @param placDTO
	 */
	private void renamePL(PLListAllDTO placDTO) {

		int category;
		int tag;
		
		System.out.println("renamePL에 있는 DTO : " + placDTO.getPl_no());
		System.out.println("==================== 장소 수정 ====================");
		System.out.println("이름을 입력하세요 : ");
		placDTO.setPl_name(sc.nextLine());
		System.out.println("주소를 입력하세요 : ");
		placDTO.setPl_address(sc.nextLine());
		System.out.println("전화번호를 입력하세요 : ");
		placDTO.setPl_tel(sc.nextLine());
		System.out.println("별점를 입력하세요 : ");
		placDTO.setScore(sc.nextInt());
		System.out.println("1. 한식, 2. 중식, 3. 일식, 4. 양식, 5. 분식, 6. 카페&디저트");
		System.out.println("카테고리를 입력하세요 : ");
		category = sc.nextInt();
		sc.nextLine();
		System.out.println("예약여부를 입력하세요 (Y/N): ");
		placDTO.setPl_reserve(sc.nextLine().toUpperCase());
		System.out.println("1. 맛있는, 2. 분위기 좋은, 3. 친절한, 4. 깨끗한, 5. 양이 많은");
		System.out.println("태그를 입력하세요 : ");
		tag = sc.nextInt();
		sc.nextLine();
		switch (category) {
		case 1:placDTO.setPl_catecode("C1");break;
		case 2:placDTO.setPl_catecode("C2");break;
		case 3:placDTO.setPl_catecode("C3");break;
		case 4:placDTO.setPl_catecode("C4");break;
		case 5:placDTO.setPl_catecode("C5");break;
		case 6:placDTO.setPl_catecode("C6");break;
		}
		// 태그생성
		switch (tag) {
		case 1:placDTO.setPl_tagcode("T1"); break;
		case 2:placDTO.setPl_tagcode("T2"); break;
		case 3:placDTO.setPl_tagcode("T3"); break;
		case 4:placDTO.setPl_tagcode("T4"); break;
		case 5:placDTO.setPl_tagcode("T5"); break;
		}
		controller.renamePL(placDTO);

	}

	/**
	 * @param placeList
	 * @FileName : MoreInfoView.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소에서 선택한 장소의 상세정보를 보여주는 메소드

	 */

	public void selectOne(ArrayList<PLListAllDTO> placeList, int no) {

		int choice;
		
		System.out.println(placeList.get(no - 1));
		System.out.println("==================== 장소 정보 ====================");
		System.out.println("매장명 : " + placeList.get(no - 1).getPl_name());
		System.out.println("주소 : " + placeList.get(no - 1).getPl_address());
		System.out.println("전화번호 : " + placeList.get(no - 1).getPl_tel());
		System.out.println("별점 : " + placeList.get(no - 1).getScore() + "점");
		System.out.println("카테고리 : " + placeList.get(no - 1).getCategory().getCategory_name());
		System.out.println("태그 : " + placeList.get(no - 1).getTag().getTag_name());
		System.out.println("예약가능여부 : " + placeList.get(no - 1).getPl_reserve());
		System.out.println();
		System.out.println();
		System.out.println("1. 내 장소에 저장하기");
		System.out.println("0. 이전 메뉴로");
		System.out.println("9. 메인 메뉴로");
		System.out.println("=================================================");
		System.out.print("번호를 입력하세요 : ");
		choice = sc.nextInt();
		sc.nextLine();
		
		switch (choice) {
		case 1:controller.saveMyList(placeList.get(no - 1)); break;
		case 0: return;
		case 9:new PLMenu().mainMenu(); break;
		default:System.out.println("잘못입력하셨습니다."); break;

		}

	}

}
