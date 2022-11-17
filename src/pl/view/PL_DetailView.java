package pl.view;

import java.util.ArrayList;
import java.util.Scanner;

import pl.controller.PL_Controller;
import pl.model.dto.PL_ListAllDTO;
import pl.model.dto.PL_MyListDTO;
import pl.model.dto.PL_ReservationDTO;

/**
 * @FileName : PLDetailView.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 15.
 * @작성자 : heojaehong
 * @프로그램설명 : 상세 정보 페이지 클래스
 */
public class PL_DetailView {
	
	private PL_Controller plController = new PL_Controller();
	private PL_ReserveMenu rm = new PL_ReserveMenu();
	private PL_ReservationDTO rd = new PL_ReservationDTO();
	private PL_ReserveMenu reserveMenu = new PL_ReserveMenu();

   /**
    * @MethodName : MoreInfo
    * @작성일 : 2022. 11. 15.
    * @작성자 : heojaehong
    * @Method설명 : 내 장소 상세 페이지
    */
	public void MoreInfo(PL_MyListDTO place, String userId) {

		int num;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==================== 장소 정보 ====================");
		System.out.println("매장명 : " + place.getPl_name());
		System.out.println("주소 : " + place.getPl_address());
		System.out.println("전화번호 : " + place.getPl_tel());
		System.out.println("별점 : " + place.getScore());
		System.out.println("카테고리 : " + place.getCategory().getCategory_name());
		System.out.println("태그 : " + place.getTag().getTag_name());
		System.out.println("예약가능여부 : " + place.getPl_reserve());
		System.out.println();
		System.out.println();
		System.out.println("1. 장소 수정");
		System.out.println("2. 장소 삭제");
		
		switch (place.getPl_reserve()) {
			case "Y":
				System.out.println("3. 예약하기");
				break;
			}
			System.out.println();
			System.out.println("0. 이전 메뉴로");
			System.out.println("=================================================");
			System.out.print("번호를 입력하세요 : ");
			
			num = sc.nextInt();
			
			switch (num) {
				case 1:
					updateMyList(place);
					break;
				case 2:
					plController.deleteMyList(place.getPl_no());
					break;
				case 3:
					rm.addReserve(place.getPl_no(), userId);
				case 0:
					return;
				default :
					System.out.println("잘못입력하셨습니다.");
					break;
		}

	}
	
   /**
    * @MethodName : updateMyList
    * @작성일 : 2022. 11. 15.
    * @작성자 : heojaehong
    * @Method 설명 : 내 장소리스트에 있는 장소 정보를 수정하는 메소드
    */
	private void updateMyList(PL_MyListDTO place) {

		int category;
		int tag;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("==================== 장소 수정 ====================");
		System.out.println("변경될 이름을 입력하세요 (건너뛰기 -> 빈칸입력) :  ");
		place.setPl_name(sc.nextLine());
		System.out.println("변경될 주소를 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		place.setPl_address(sc.nextLine());
		System.out.println("변경될 전화번호를 입력하세요 (건너뛰기 -> 빈칸입력) : ");
		place.setPl_tel(sc.nextLine());
		System.out.println("변경될 별점를 입력하세요 (필수 입력) : ");
		place.setScore(sc.nextInt());
		System.out.println("1. 한식, 2. 중식, 3. 일식, 4. 양식, 5. 분식, 6. 카페&디저트");
		System.out.println("변경될 카테고리를 입력하세요 (필수 입력) : ");
		category = sc.nextInt();
		sc.nextLine();

		switch (category) {
			case 1:
				place.setPl_catecode("C1");
				break;
			case 2:
				place.setPl_catecode("C2");
				break;
			case 3:
				place.setPl_catecode("C3");
				break;
			case 4:
				place.setPl_catecode("C4");
				break;
			case 5:
				place.setPl_catecode("C5");
				break;
			case 6:
				place.setPl_catecode("C6");
				break;
			default :
				System.out.println("잘못 입력했습니다. 기존 값이 유지됩니다.");
		}
		
		System.out.println("변경될 예약여부를 입력하세요 (Y/N) (건너뛰기 -> 빈칸입력): ");
		place.setPl_reserve(sc.nextLine().toUpperCase());
		System.out.println("1. 맛있는, 2. 분위기 좋은, 3. 친절한, 4. 깨끗한, 5. 양이 많은");
		System.out.println("변경될 태그를 입력하세요 (필수 입력) : ");
		tag = sc.nextInt();
		
		switch (tag) {
			case 1:
				place.setPl_tagcode("T1");
				break;
			case 2:
				place.setPl_tagcode("T2");
				break;
			case 3:
				place.setPl_tagcode("T3");
				break;
			case 4:
				place.setPl_tagcode("T4");
				break;
			case 5:
				place.setPl_tagcode("T5");
				break;
			default :
				System.out.println("잘못 입력했습니다. 기존 값이 유지됩니다.");
		}
		
		plController.updateMyList(place);

	}

   /**
    * @MethodName : selectOne
    * @작성일 : 2022. 11. 15.
    * @작성자 : jihee
    * @Method 설명 : 추천 장소에서 선택한 장소의 상세정보를 보여주는 메소드
    */
	public void selectOne(PL_ListAllDTO place, int no, String userId) {

		int userNo = reserveMenu.selectUserInfo(userId);
		
		int choice;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==================== 장소 정보 ====================");
		System.out.println("매장명 : " + place.getPl_name());
		System.out.println("주소 : " + place.getPl_address());
		System.out.println("전화번호 : " + place.getPl_tel());
		System.out.println("별점 : " + place.getScore() + "점");
		System.out.println("카테고리 : " + place.getCategory().getCategory_name());
		System.out.println("태그 : " + place.getTag().getTag_name());
		System.out.println("예약가능여부 : " + place.getPl_reserve());
		System.out.println();
		System.out.println();
		System.out.println("1. 내 장소에 저장하기");
		System.out.println("0. 이전 메뉴로");
		System.out.println("=================================================");
		System.out.print("번호를 입력하세요 : ");
		choice = sc.nextInt();
		
		switch (choice) {
			case 1:
				plController.saveMyList(place, userNo);
				break;
			case 0:
				return;
			default :
				System.out.println("잘못입력하셨습니다.");
				break;
		}

	}
}
