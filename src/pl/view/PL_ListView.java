package pl.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.controller.PL_Controller;
import pl.model.dto.PL_ListAllDTO;
import pl.model.dto.PL_MyListDTO;

/**
 * @FileName : subView.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 15.
 * @작성자 : heojaehong 
 * @프로그램설명 : 서브 메뉴 뷰
 */
public class PL_ListView {
	
	private PL_Controller plController = new PL_Controller();
	private PL_DetailView plDetailView = new PL_DetailView();
	private PL_MyListDTO myPlace = new PL_MyListDTO();
	private PL_ReserveMenu reserveMenu = new PL_ReserveMenu();

   /**
    * @MethodName : selectAllName
    * @작성일 : 2022. 11. 15.
    * @작성자 : jihee
    * @Method설명 : 매장명을 기준으로 리스트를 정렬하는 메소드
    */
	public void selectAllName(String userId) {
		
		int no;
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<PL_ListAllDTO> placeList = plController.selectAllName();
	
		if (placeList != null) {
			System.out.println("=========== 매장명으로 정렬 ===========");
			for(PL_ListAllDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.println(list.getPl_name());
			}
			System.out.println();
			System.out.println("0. 이전 메뉴로");
			System.out.println("====================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			no = sc.nextInt();
			
			if (no == 0) {
				return;
			} else if ( no > 0 && no <= placeList.size()) {
				plDetailView.selectOne(placeList.get(no-1), no, userId);
			} else {
				System.out.println("잘못 입력하셨습니다 다시 입력하세요 ");
			}
		} else {
			System.out.println("에러발생");
		}
	
	}

   /**
    * @MethodName : selectAllAddress
    * @작성일 : 2022. 11. 15.
    * @작성자 : jihee
    * @Method설명 : 주소를 기준으로 리스트를 정렬하는 메소드
    */
	public void selectAllAddress(String userId) {
		
		int no;
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<PL_ListAllDTO> placeList = plController.selectAllAddress();
	
		if (placeList != null) {
			System.out.println("=========== 주소로 정렬 ===========");
			for(PL_ListAllDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getPl_address());
			}
			System.out.println();
			System.out.println("0. 이전 메뉴로");
			System.out.println("====================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			no = sc.nextInt();
			
			if (no == 0) {
				return;
			} else if ( no > 0 && no <= placeList.size()) {
				plDetailView.selectOne(placeList.get(no-1), no, userId);
			} else {
				System.out.println("잘못 입력하셨습니다 다시 입력하세요 ");
			}
		} else {
			System.out.println("에러발생");
		}
		
	}

   /**
    * @MethodName : selectAllScore
    * @작성일 : 2022. 11. 15.
    * @작성자 : jihee
    * @Method설명 : 별점을 기준으로 리스트를 정렬하는 메소드
    */
	public void selectAllScore(String userId) {
		
		int no;
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<PL_ListAllDTO> placeList = plController.selectAllScore();
	
		if(placeList != null) {
			System.out.println("=========== 별점으로 정렬 ===========");
			for(PL_ListAllDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getScore() + "점");
			}
			System.out.println();
			System.out.println("0. 이전 메뉴로");
			System.out.println("====================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			no = sc.nextInt();
			
			if (no == 0) {
				return;
			} else if ( no > 0 && no <= placeList.size()) {
				plDetailView.selectOne(placeList.get(no-1), no, userId);
			} else {
				System.out.println("잘못 입력하셨습니다 다시 입력하세요 ");
			}
		} else {
			System.out.println("에러발생");
		}
		
	}

   /**
    * @MethodName : selectAllCategory
    * @작성일 : 2022. 11. 15.
    * @작성자 : jihee
    * @Method설명 : 카테고리를 기준으로 리스트를 정렬하는 메소드
    */
	public void selectAllCategory(String userId) {
		
		int no; 
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<PL_ListAllDTO> placeList = plController.selectAllCategory();
	
		if (placeList != null) {
			System.out.println("=========== 카테고리로 정렬 ===========");
			for(PL_ListAllDTO list : placeList) {
				System.out.print(list.getRownum() + " ");
				System.out.print(list.getPl_name() + " | ");
				System.out.println(list.getCategory().getCategory_name());
			}
			System.out.println();
			System.out.println("0. 이전 메뉴로");
			System.out.println("====================================");
			System.out.println("원하는 매장번호를 입력하세요 : ");
			no = sc.nextInt();
			
			if (no == 0) {
				return;
			} else if ( no > 0 && no <= placeList.size()) {
				plDetailView.selectOne(placeList.get(no-1), no, userId);
			} else {
				System.out.println("잘못 입력하셨습니다 다시 입력하세요 ");
			}
		} else {
			System.out.println("에러발생");
		}
		
	}

   /**
    * @MethodName : myPlaceList
    * @작성일 : 2022. 11. 15.
    * @작성자 : heojaehong
    * @Method 설명 : 내 장소의 전체 리스트를 보여주는 메소드
    */
	public void myPlaceList(String userId) {
		
		/* 리스트번호, 입력값을 받는정수형 변수 선언 */
		int num = 0; 
		
		/* 설정 */
		int userNo = reserveMenu.selectUserInfo(userId);
		myPlace.setUser_no(userNo);

		Scanner sc = new Scanner(System.in);
		
		List<PL_MyListDTO> placeList = plController.myPlaceList(myPlace.getUser_no());
		
		if (placeList.isEmpty()) {
			return;
		}
		
		System.out.println("=========== 내 장소 ===========");
		for(PL_MyListDTO pd : placeList) {
			num++;
			System.out.println(num + ". " + pd.getPl_name());
		}
		System.out.println();
		System.out.println("0. 메인 메뉴로 ");
		System.out.println("==============================");
		System.out.print("번호를 입력하세요 : ");
		int no = sc.nextInt();

		if (no == 0) {
			return;
		} else {
			plDetailView.MoreInfo(placeList.get(no - 1), userId);
		}

	}

   /**
    * @MethodName : addPlaceList
    * @작성일 : 2022. 11. 15.
    * @작성자 : heojaehong
    * @Method 설명 : 장소 추가하는 메소드
    */
	public void insertMyPlace(String userId) {
		
		/* 카테고리, 테그의 정보를 입력받는 정수형 변수 선언 */
		int category;
		int tag;
		
		Scanner sc = new Scanner(System.in);
		
		PL_MyListDTO myPlace = new PL_MyListDTO();
		
		int userNo = reserveMenu.selectUserInfo(userId);
		myPlace.setUser_no(userNo);

		do {
			System.out.println("=========== 장소 추가 ===========");
			System.out.print("장소이름을 입력하세요 : ");
			myPlace.setPl_name(sc.nextLine());
			System.out.print("장소주소을 입력하세요 : ");
			myPlace.setPl_address(sc.nextLine());
			System.out.print("전화번호을 입력하세요(- 포함) : ");
			myPlace.setPl_tel(sc.nextLine());
			System.out.print("별점을 입력하세요(1~5) : ");
			myPlace.setScore(sc.nextInt());
			System.out.println("1. 한식, 2. 중식, 3. 일식, 4. 양식, 5. 분식, 6. 카페&디저트");
			System.out.println("카테고리를 입력하세요 : ");
			category = sc.nextInt();
			sc.nextLine();
			System.out.print("예약여부을 입력하세요(Y/N) : ");
			myPlace.setPl_reserve(sc.nextLine().toUpperCase());
			System.out.println("1. 맛있는, 2. 분위기 좋은, 3. 친절한, 4. 깨끗한, 5. 양이 많은");
			System.out.println("태그를 입력하세요 : ");
			tag = sc.nextInt();
			System.out.println("===============================");
			
			/* 입력받은 변수마다 카테고리 코드 setter로 저장 */
			switch (category) {
				case 1:
					myPlace.setPl_catecode("C1"); 
					break;
				case 2:
					myPlace.setPl_catecode("C2"); 
					break;
				case 3:
					myPlace.setPl_catecode("C3"); 
					break;
				case 4:
					myPlace.setPl_catecode("C4"); 
					break;
				case 5:
					myPlace.setPl_catecode("C5"); 
					break;
				case 6:
					myPlace.setPl_catecode("C6"); 
					break;
			}
			
			/* 입력받은 변수마다 테그코드 setter로 저장 */
			switch (tag) {
			case 1:
				myPlace.setPl_tagcode("T1"); 
				break;
			case 2:
				myPlace.setPl_tagcode("T2"); 
				break;
			case 3:
				myPlace.setPl_tagcode("T3"); 
				break;
			case 4:
				myPlace.setPl_tagcode("T4"); 
				break;
			case 5:
				myPlace.setPl_tagcode("T5"); 
				break;
			}
			if (category >= 1 && category <= 6 && tag >= 1 && tag <= 5) {
				break;
			} else {
				System.out.println("잘못입력하셨습니다, 처음으로 돌아갑니다.");
				return;
			}

		} while (true);

		plController.insertMyPlace(myPlace);
		
	}

   /**
    * @MethodName : fileOut
    * @작성일 : 2022. 11. 15.
    * @작성자 : heojaehong
    * @Method설명 : 내장소에 저장된 장소 리스트를 txt파일로 내보내는 메소드
    */
	public void fileOut(String userId) {
		
		Scanner sc = new Scanner(System.in);
		
		int userNo = reserveMenu.selectUserInfo(userId);
		myPlace.setUser_no(userNo);
		
		System.out.println("=========== 내 장소 내보내기 ===========");
		System.out.println("현재 저장된 내 장소리스트를 파일로 저장하시겠습니까?(Y/N)");
		System.out.println("====================================");
		System.out.println("입력하세요 : ");
		String answer = sc.nextLine().toUpperCase();
		
		if (answer.equals("Y")) {
			plController.fileOut(myPlace.getUser_no());
		}else {
			return;
		}
		
	}
	
}
