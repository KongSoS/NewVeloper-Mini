/**
  * 
  */
package pl.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.controller.PLController;
import pl.model.dto.PLListAndCategoryDTO;
import pl.model.dto.PLMyListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLTagDTO;

/**
 * @FileName : ResultView.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 15.
 * @작성자 : heojaehong
 * @변경이력 :
 * @프로그램 설명 :
 */
public class subView {
	private PLController controller = new PLController();
	private MoreInfoView mv = new MoreInfoView();
	private Scanner sc = new Scanner(System.in);
	/**
	  * @Method Name : myPlaceList
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  */
	public void myPlaceList() {
		int num=0;
		int input;
		List<PLListAndCategoryDTO> list = controller.myPlaceList();
		System.out.println(list.size());
		System.out.println("=========== 내 장소 ===========");
		for(PLListAndCategoryDTO pd : list) {
			num++;
			System.out.println(num + "." + pd.getPl_name());			
		}
		
		System.out.println("==============================");
		System.out.print("번호를 입력하세요 : ");
		input = sc.nextInt();
		
		mv.MoreInfo(list.get(input-1));
		
	}
	/**
	  * @Method Name : selectSort
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : jihee
	  * @변경이력 : 
	  * @Method 설명 :
	  */
	public void selectSort() {

		do {
			System.out.println("=========== PLACE LIST ===========");
			System.out.println("1. 매장명으로 정렬");
			System.out.println("2. 주소로 정렬");
			System.out.println("3. 별점으로 정렬");
			System.out.println("4. 카테고리로 정렬");
			System.out.println("0. 이전 메뉴로");
			System.out.print("원하는 정렬 번호를 입력하세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : controller.selectAllName(); break;
			case 2 : controller.selectAllAddress(); break;
			case 3 : controller.selectAllScore(); break;
			case 4 : controller.selectAllCategory(); break;
			case 0 : return;
			default : System.out.println("잘못 입력하셨습니다 다시 입력하세요 "); break;
			}
		} while (true);
		
		// 리스트 출력한 뒤, 원하는 장소에 대한 정보도 출력해야함
		// 정렬기준 선택 후 번호입력하면 장소 정보 출력
		// 번호입력을 어디서 받아야 할까?
	}
	/**
	  * @Method Name : addPlaceList
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @return 
	  */
	public void addPlaceList() {
		int category;
		PLMyListAndCategoryDTO dto = new PLMyListAndCategoryDTO();
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
//			System.out.print("태그를 입력하세요(, 로 공백없이 입력): ");
//			plTagDTO.setTag_name(sc.next());
			System.out.println("1. 한식, 2. 중식, 3. 일식, 4. 양식, 5. 분식, 6. 카페&디저트");
			System.out.println("카테고리를 입력하세요 : ");
			category = sc.nextInt();
			sc.nextLine();
			System.out.print("예약여부을 입력하세요(Y/N) : ");
			dto.setPl_reserve(sc.next().toUpperCase());
			System.out.println("===============================");
			// 카테고리에 맞는 코드 저장
			switch (category) {
			case 1:
				dto.setPl_catecode("C1");
				break;
			case 2:
				dto.setPl_catecode("C2");
				break;
			case 3:
				dto.setPl_catecode("C3");
				break;
			case 4:
				dto.setPl_catecode("C4");
				break;
			case 5:
				dto.setPl_catecode("C5");
				break;
			}
			if(category >= 1 && category <= 5) {
				break;				
			}else {
				System.out.println("잘못입력하셨습니다, 처음으로 돌아갑니다.");
				return;
			}
			
		}while(true);
		// 태그를 ,로 나눠서 list에 저장
//		String[] tag = plTagDTO.getTag_name().split(",");
//		for(int i=0; i<list.size(); i++) {
//			list.add(tag[i]);
//		}
//		dto.setTagList(list);
		
		PLList.add(dto);
		
		controller.addPlaceList(PLList);
	}
	
	

}
