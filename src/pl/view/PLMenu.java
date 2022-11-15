package pl.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.controller.PLController;
import pl.model.dto.PLMyListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLTagDTO;

public class PLMenu {

	private Scanner sc = new Scanner(System.in);
	private PLController plController = new PLController();
	private PLMyListDTO myListDTO;

	/**
	 * @Method Name : mainMenu
	 * @작성일 : 2022. 11. 11.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 : 처음 보여지는 메뉴
	 */
	public void mainMenu() {

		do { // 메인메뉴를 보여주는 반복문
			System.out.println("=========== PLACE LIST ===========");
			System.out.println("1. 추천 장소");
			System.out.println("2. 내 장소");
			System.out.println("3. 내 장소에 새로운 장소 등록하기");
			System.out.println("4. 내 장소 내보내기");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 내 예약");
			System.out.println("0. 프로그램 종료");
			System.out.println("==================================");
			System.out.print("메뉴 관리 번호를 입력하세요 : ");
			int no = sc.nextInt();

			switch (no) {
			case 1:

				break;
			case 2:
				plController.myPlaceList();
				break;
			case 3:
				plController.addPlaceList(inputSubMenu());
				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 0:
				System.out.println("프로그램을 종료합니다. ");
				return;
			default:
				System.out.println("잘못 입력하셨습니다 다시 입력하세요 ");
				break;
			}

		} while (true);

	}

	/**
	 * @param myListDTO
	 * @Method Name : inputPlace
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 :
	 * @return
	 */
	private List<PLMyListAndCategoryDTO> inputSubMenu() {
		PLMyListAndCategoryDTO dto = new PLMyListAndCategoryDTO();
		PLTagDTO plTagDTO = new PLTagDTO();
		List<String> list = new ArrayList<>();
		List<PLMyListAndCategoryDTO> PLList = new ArrayList<>();
		do {
			System.out.println("=========== 장소 추가 ===========");
			System.out.print("장소이름을 입력하세요 : ");
			dto.setPl_name(sc.next());
			System.out.print("장소주소을 입력하세요 : ");
			dto.setPl_address(sc.next()); 
			System.out.print("전화번호을 입력하세요(- 포함) : ");
			dto.setPl_tel(sc.next());
			System.out.print("별점을 입력하세요(1~5) : ");
			dto.setScore(sc.nextInt());
			System.out.print("태그를 입력하세요(, 로 공백없이 입력): ");
			plTagDTO.setTag_name(sc.next());
			System.out.print("예약여부을 입력하세요(Y/N) : ");
			dto.setPl_reserve(sc.next().toUpperCase());
			sc.nextLine();
			System.out.println("===============================");
			break;
		}while(true);
		// 태그를 ,로 나눠서 list에 저장
		String[] tag = plTagDTO.getTag_name().split(",");
		for(int i=0; i<list.size(); i++) {
			list.add(tag[i]);
		}
		dto.setTagList(list);
		PLList.add(dto);
		
		return PLList;
	}

}
