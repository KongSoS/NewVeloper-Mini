/**
  * 
  */
package pl.view;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import pl.controller.PL_Controller;
import pl.model.dto.PL_ListAllDTO;
import pl.model.dto.PL_ReservationDTO;


/**
 * @FileName : subView.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 15.
 * @작성자 : heojaehong
 * @변경이력 :
 * @프로그램 설명 : 서브 메뉴 뷰

 */
public class subView {
	private PL_Controller controller = new PL_Controller();
	private MoreInfoView mv = new MoreInfoView();

	/**
	 * @Method Name : myPlaceList
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 : 내 장소의 전체 리스트를 보여주는 메소드
	 */
	public void myPlaceList() {
		/*
		 * 리스트번호, 입력값을 받는
		 * 정수형 변수 선언
		 * */
		int num = 0; 
		int input;
		
		Scanner sc = new Scanner(System.in);
		
		List<PL_ListAllDTO> list = controller.myPlaceList();
		
		System.out.println(list.size());
		System.out.println("=========== 내 장소 ===========");
		for(PL_ListAllDTO pd : list) {
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
			mv.MoreInfo(list.get(input - 1), num);
		}

	}

	/**
	 * @Method Name : addPlaceList
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 : 장소 추가하는 메소드
	 * @return
	 */
	public void addPlaceList() {
		/*
		 * 카테고리, 테그의 정보를 입력받는
		 * 정수형 변수 선언
		 * */
		int category;
		int tag;
		
		Scanner sc = new Scanner(System.in);
		PL_ListAllDTO dto = new PL_ListAllDTO();
		
		List<PL_ListAllDTO> PLList = new ArrayList<>();
		
		do {
			System.out.println("=========== 장소 추가 ===========");
			System.out.print("장소이름을 입력하세요 : ");
			dto.setPl_name(sc.nextLine());
			System.out.print("장소주소을 입력하세요 : ");
			dto.setPl_address(sc.nextLine());
			System.out.print("전화번호을 입력하세요(- 포함) : ");
			dto.setPl_tel(sc.nextLine());
			System.out.print("별점을 입력하세요(1~5) : ");
			dto.setScore(sc.nextInt());
//			System.out.print("태그를 입력하세요(, 로 공백없이 입력): ");
//			plTagDTO.setTag_name(sc.next());
			System.out.println("1. 한식, 2. 중식, 3. 일식, 4. 양식, 5. 분식, 6. 카페&디저트");
			System.out.println("카테고리를 입력하세요 : ");
			category = sc.nextInt();
			sc.nextLine();
			System.out.print("예약여부을 입력하세요(Y/N) : ");
			dto.setPl_reserve(sc.nextLine().toUpperCase());
			System.out.println("1. 맛있는, 2. 분위기 좋은, 3. 친절한, 4. 깨끗한, 5. 양이 많은");
			System.out.println("태그를 입력하세요 : ");
			tag = sc.nextInt();
			System.out.println("===============================");
			/* 입력받은 변수마다 카테고리 코드 setter로 저장 */
			switch (category) {
			case 1:dto.setPl_catecode("C1"); break;
			case 2:dto.setPl_catecode("C2"); break;
			case 3:dto.setPl_catecode("C3"); break;
			case 4:dto.setPl_catecode("C4"); break;
			case 5:dto.setPl_catecode("C5"); break;
			case 6:dto.setPl_catecode("C6"); break;
			}
			/* 입력받은 변수마다 테그코드 setter로 저장 */
			switch (tag) {
			case 1:dto.setPl_tagcode("T1"); break;
			case 2:dto.setPl_tagcode("T2"); break;
			case 3:dto.setPl_tagcode("T3"); break;
			case 4:dto.setPl_tagcode("T4"); break;
			case 5:dto.setPl_tagcode("T5"); break;
			}
			if (category >= 1 && category <= 6 && tag >= 1 && tag <= 5) {
				break;
			} else {
				System.out.println("잘못입력하셨습니다, 처음으로 돌아갑니다.");
				return;
			}

		} while (true);

		controller.addPlaceList(dto);
	}

	public void printReserveList(List<PL_ReservationDTO> reserveList, PL_ListAllDTO pd) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=============내 예약===============");
		for (int i = 1; i <= reserveList.size(); i++) {
			/* 예약된 길이만큼 i를 반복해야함
			/* if() my_no와 pl_no가 같으면 */
			System.out.println(i + ". " + pd.getPl_name());
			/* dto에서 장소 이름을 받아와야함*/
		}
		System.out.println("0. 이전 메뉴로");
		System.out.println("=================================");
		System.out.print("번호를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.println();

		if (num == 0) {
			return;
		} else if (num <= reserveList.size()) {
			PL_ReserveMenu rm = new PL_ReserveMenu();
			rm.reserveInfo();

		} else {
			System.out.println("잘못 입력하셨습니다.");
			return;// 이 리턴 어디로 가는건지
		}

	}

	public void printMenu(PL_ReservationDTO menu) {
		/*
		 * 변수 선언
		 */
		String year;	// 연도
		String month;	// 월
		String day;		// 일
		String time; 	//
		String minute;
		int nYear;		// 연도를 정수로 변환한 값을 저장하는 변수
		int nMonth;		// 월를 정수로 변환한 값을 저장하는 변수
		int nDay;		// 일를 정수로 변환한 값을 저장하는 변수
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("==============예약정보==============");
		System.out.println("가게 이름 : "/* +getPLName(num) */);
		/* 가게 이름을 소환해야함 */
		year = menu.getReserve_day().substring(0, 2);
		month = menu.getReserve_day().substring(2, 2);
		day = menu.getReserve_day().substring(4);
		nYear = Integer.parseInt(year);
		nMonth = Integer.parseInt(month);
		nDay = Integer.parseInt(day);
		Date reDay = new Date(nYear - 1900, nMonth - 1, nDay);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E요일");

		System.out.println("날짜 : " + sdf.format(reDay));

		time = menu.getReserve_time().substring(0, 2);
		minute = menu.getReserve_time().substring(2);

		int nTime = Integer.parseInt(time);
		int nMinute = Integer.parseInt(minute);
		if (nMinute >= 0 && nMinute < 60) {
			if (nTime > 12 && nTime < 24) {
				System.out.println("시간 : 오후" + (nTime - 12) + "시 " + nMinute + "분");
			} else if (nTime >= 0 && nTime <= 12) {
				System.out.println("시간 : 오전" + nTime + "시 " + nMinute + "분");
			}
		} else {
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
		PL_ReserveMenu rm = new PL_ReserveMenu();
		switch (num2) {
		case "1":rm.editReserve(); break;
		case "2":rm.cancelReserve(); break;
		case "0": return;
		default:System.out.println("잘못 입력하셨습니다"); return;
		}
	}

	/**
	 * @param placDTO 
	 * @Method Name : fileOut
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : heojaehong
	 * @변경이력 :
	 * @Method 설명 : 내장소에 저장된 장소 리스트를 txt파일로 내보내는 메소드
	 */
	public void fileOut() {
		
		Scanner sc = new Scanner(System.in);
		
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
	 * @프로그램 설명 : 주소를 기준으로 리스트를 정렬하는 메소드
	 */
	public void selectAllName() {
		
		int no;
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<PL_ListAllDTO> placeList = controller.selectAllName();

		if(placeList != null) {
			System.out.println("=========== 매장명으로 정렬 ===========");
			for(PL_ListAllDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.println(list.getPl_name());
			}
			System.out.println("====================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			System.out.println("0. 이전 메뉴로");
			no = sc.nextInt();
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
	 * @프로그램 설명 : 주소를 기준으로 리스트를 정렬하는 메소드
	 */
	public void selectAllAddress() {
		
		int no;
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<PL_ListAllDTO> placeList = controller.selectAllAddress();

		if(placeList != null) {
			System.out.println("=========== 주소로 정렬 ===========");
			for(PL_ListAllDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getPl_address());
			}
			System.out.println("=================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			System.out.println("0. 이전 메뉴로");
			no = sc.nextInt();
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
	 * @프로그램 설명 : 별점 기준으로 리스트를 정렬하는 메소드
	 */
	public void selectAllScore() {
		
		int no;
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<PL_ListAllDTO> placeList = controller.selectAllScore();

		if(placeList != null) {
			System.out.println("=========== 별점으로 정렬 ===========");
			for(PL_ListAllDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getScore() + "점");
			}
			System.out.println("=================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			System.out.println("0. 이전 메뉴로");
			no = sc.nextInt();
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
	 * @프로그램 설명 : 카테고리 기준으로 리스트를 정렬하는 메소드
	 */
	public void selectAllCategory() {
		
		int no; 
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<PL_ListAllDTO> placeList = controller.selectAllCategory();

		if(placeList != null) {
			System.out.println("=========== 카테고리로 정렬 ===========");
			for(PL_ListAllDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getCategory().getCategory_name());
			}
			System.out.println("====================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			System.out.println("0. 이전 메뉴로");
			no = sc.nextInt();
			if(no == 0) return;
			else mv.selectOne(placeList,no);
			
		} else {
			System.out.println("에러발생");
		}
		
	}
}
