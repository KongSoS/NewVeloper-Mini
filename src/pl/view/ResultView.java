/**
  * 
  */
package pl.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import pl.controller.PLController;
import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLReservationDTO;

/**
 * @FileName : ResultView.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 15.
 * @작성자 : heojaehong
 * @변경이력 :
 * @프로그램 설명 :
 */
public class ResultView {
	
	/**
	  * @Method Name : MoreInfo
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :해당 장소의 상세 정보 출력하는 메소드
	  * @param plMyListDTO
	  */
	public void MoreInfo(PLMyListDTO pd) {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("==================== 장소 정보 ====================");
		System.out.println("이름 : " + pd.getPl_name());
		System.out.println("장소 : " + pd.getPl_address());
		System.out.println("예약 : " + pd.getPl_reserve());
		System.out.println("별점 : " + pd.getScore());
		System.out.println("태그 : ");
		System.out.println("전화번호 : " + pd.getPl_tel());
		System.out.println();
		System.out.println();
		System.out.println("1. 장소 수정");
		System.out.println("2. 장소 삭제");
		switch(pd.getPl_reserve()) {
		case "Y":
			System.out.println("3. 예약하기");
			break;
		}
		System.out.println("0. 이전 메뉴로");
		System.out.println("00. 메인 메뉴로");
		System.out.println("=================================================");
		String num2 = sc.next();
		
		
		switch(num2) {
		case "1":
			
			break;
		case "2":
			
			break;
		case "3":
			PLReserveMenu rm = new PLReserveMenu();
			PLReservationDTO rd = new PLReservationDTO();
			rm.addReserve(rd.getMy_no());
		case "0":
			PLController controller = new PLController();
			controller.reserveMine();
			break;
		case "00":
			
			break;
		default:
			System.out.println("잘못 입력하셨습니다");
			return;
		}
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
			//PlaceList호출
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
			//PlaceList호출
			break;
		default:
			System.out.println("잘못 입력하셨습니다");
			return;
		}
	}
	
}
