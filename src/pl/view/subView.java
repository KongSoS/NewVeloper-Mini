/**
  * 
  */
package pl.view;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import pl.controller.PLController;
import pl.model.dto.PLListAndCategoryDTO;
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
	  * @Method 설명 : 내 장소의 전체 리스트를 보여주는 메소드
	  */
	public void myPlaceList() {
		int num=0;
		int input;
		List<PLListAndCategoryDTO> list = controller.myPlaceList();
		System.out.println(list.size());
		System.out.println("=========== 내 장소 ===========");
		for(PLListAndCategoryDTO pd : list) {
			num++;
			System.out.println(num + ". " + pd.getPl_name());			
		}
		System.out.println("0. 메인 메뉴로 ");
		System.out.println("==============================");
		System.out.print("번호를 입력하세요 : ");
		input = sc.nextInt();
		
		if(input == 0) {
			return;
		}else {
			mv.MoreInfo(list.get(input-1));
		}
		
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
		
		System.out.println();
		
		controller.addPlaceList(dto);
	}
	
	public void printReserveList(List<PLReservationDTO> reserveList, PLMyListDTO pd) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============내 예약===============");
		for(int i = 1 ; i<=reserveList.size(); i++) {
			//예약된 길이만큼 i를 반복해야함
			//if() my_no와 pl_no가 같으면
			System.out.println(i+". "+pd.getPl_name());
			//dto에서 장소 이름을 받아와야함
		}
		System.out.println("0. 이전 메뉴로");
		System.out.println("=================================");
		System.out.print("번호를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.println();
		
		if(num==0) {
			PLMenu menu = new PLMenu();
			menu.mainMenu();//PlaceList호출
		}
		else if(num <=reserveList.size()){
			PLReserveMenu rm = new PLReserveMenu();
			rm.reserveInfo();
			
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
			return;//이 리턴 어디로 가는건지
		}
		
	}
	public void printMenu(PLReservationDTO menu) {
		Scanner sc = new Scanner(System.in);
		System.out.println("==============예약정보==============");
		System.out.println("가게 이름 : "/*+getPLName(num)*/);
		//가게 이름을 소환해야함
		String year = menu.getReserve_day().substring(0,2);
		String month = menu.getReserve_day().substring(2,2);
		String day = menu.getReserve_day().substring(4);
		int nYear = Integer.parseInt(year);
		int nMonth = Integer.parseInt(month);
		int nDay = Integer.parseInt(day);
		Date reDay = new Date(nYear-1900, nMonth-1, nDay);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E요일");
	      
		System.out.println("날짜 : "+sdf.format(reDay));
		
		String time = menu.getReserve_time().substring(0,2);
		String minute = menu.getReserve_time().substring(2);
		
		int nTime = Integer.parseInt(time);
		int nMinute = Integer.parseInt(minute);
		if(nMinute>=0 && nMinute<60) {
			if(nTime > 12 && nTime<24) {
				System.out.println("시간 : 오후"+(nTime-12)+"시 "+nMinute+"분");
			}else if(nTime>=0 && nTime<=12) {
				System.out.println("시간 : 오전"+nTime+"시 "+nMinute+"분");
			}
		}
		else {
			System.out.println("다시 입력해주세요");
			return;
		}
		
		System.out.println();
		System.out.println("1. 예약 변경");
		System.out.println("2. 예약 취소");
		System.out.println("0. 이전 메뉴로");
		System.out.println("00. 메인 메뉴로");
		System.out.println("=================================");
		System.out.print("번호를 입력하세요 : ");
		
		String num2 = sc.next();
		System.out.println();
		PLReserveMenu rm = new PLReserveMenu();
		switch(num2) {
		case "1":
			rm.editReserve();
			break;
		case "2":
			rm.cancelReserve();
			break;
		case "0":
			PLController controller = new PLController();
			controller.reserveMine();
			break;
		case "00":
			PLMenu pl = new PLMenu();
			pl.mainMenu();//PlaceList호출
			break;
		default:
			System.out.println("잘못 입력하셨습니다");
			return;
		}
	}
	

}
