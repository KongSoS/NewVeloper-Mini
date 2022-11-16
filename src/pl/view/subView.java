/**
  * 
  */
package pl.view;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import pl.controller.PLController;
import pl.model.dto.PLListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLListAndReserveDTO;
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
	 * @Method 설명 : 내 장소의 전체 리스트를 보여주는 메소드
	 */
	public void myPlaceList() {
		int num = 0;
		int input;
		List<PLListAndCategoryDTO> list = controller.myPlaceList();
		System.out.println(list.size());
		System.out.println("=========== 내 장소 ===========");
		for (PLListAndCategoryDTO pd : list) {
			num++;
			System.out.println(num + ". " + pd.getPl_name());
		}
		System.out.println();
		System.out.println("0. 메인 메뉴로 ");
		System.out.println("==============================");
		System.out.print("번호를 입력하세요 : ");
		input = sc.nextInt();

		if (input == 0) {
			return;
		} else {
			mv.MoreInfo(list.get(input - 1));
		}

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
		PLListAndCategoryDTO dto = new PLListAndCategoryDTO();
		List<PLListAndCategoryDTO> PLList = new ArrayList<>();
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
			case 6:
				dto.setPl_catecode("C6");
				break;
			}
			if (category >= 1 && category <= 5) {
				break;
			} else {
				System.out.println("잘못입력하셨습니다, 처음으로 돌아갑니다.");
				return;
			}

		} while (true);
		// 태그를 ,로 나눠서 list에 저장
//		String[] tag = plTagDTO.getTag_name().split(",");
//		for(int i=0; i<list.size(); i++) {
//			list.add(tag[i]);
//		}
//		dto.setTagList(list);

		System.out.println();

		controller.addPlaceList(dto);
	}

	

	/**
	 * @param placDTO 
	 * @Method Name : fileOut
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 :
	 */
	public void fileOut() {

		System.out.println("=========== 내 장소 내보내기 ===========");
		System.out.println("현재 저장된 내 장소리스트를 파일로 저장하시겠습니까?(Y/N)");
		System.out.println("====================================");
		System.out.println("입력하세요 : ");
		String answer = sc.nextLine().toUpperCase();
		if (answer.equals("Y")) {
			controller.fileOut();
		}else {
			return;
		}
	}

	
	
	
	
	
	/**
	 * @FileName : subView.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void selectAllName() {
		ArrayList<PLListAndCategoryDTO> placeList = controller.selectAllName();

		if(placeList != null) {
			System.out.println("=========== 매장명으로 정렬 ===========");
			for(PLListAndCategoryDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.println(list.getPl_name());
			}
			System.out.println("=================================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			System.out.println("0. 이전 메뉴로");
			int no = sc.nextInt();
			if(no == 0) return;
			else mv.selectOne(placeList,no);
			
		} else {
			System.out.println("에러발생");
		}

		
	}

	/**
	 * @FileName : subView.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void selectAllAddress() {
		ArrayList<PLListAndCategoryDTO> placeList = controller.selectAllAddress();

		if(placeList != null) {
			System.out.println("=========== 주소로 정렬 ===========");
			for(PLListAndCategoryDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getPl_address());
			}
			System.out.println("=================================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			System.out.println("0. 이전 메뉴로");
			int no = sc.nextInt();
			if(no == 0) return;
			else mv.selectOne(placeList,no);
			
		} else {
			System.out.println("에러발생");
		}
		
	}

	/**
	 * @FileName : subView.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void selectAllScore() {
		ArrayList<PLListAndCategoryDTO> placeList = controller.selectAllScore();

		if(placeList != null) {
			System.out.println("=========== 별점으로 정렬 ===========");
			for(PLListAndCategoryDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getScore() + "점");
			}
			System.out.println("=================================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			System.out.println("0. 이전 메뉴로");
			int no = sc.nextInt();
			if(no == 0) return;
			else mv.selectOne(placeList,no);
			
		} else {
			System.out.println("에러발생");
		}
		
	}

	/**
	 * @FileName : subView.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void selectAllCategory() {
		ArrayList<PLListAndCategoryDTO> placeList = controller.selectAllCategory();

		if(placeList != null) {
			System.out.println("=========== 카테고리로 정렬 ===========");
			for(PLListAndCategoryDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getCategory().getCategory_name());
			}
			System.out.println("=================================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			System.out.println("0. 이전 메뉴로");
			int no = sc.nextInt();
			if(no == 0) return;
			else mv.selectOne(placeList,no);
			
		} else {
			System.out.println("에러발생");
		}
		
	}
}
