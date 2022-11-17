package pl.view;

import java.util.List;
import java.util.Scanner;

import pl.controller.PL_Controller;
import pl.model.dto.PL_ListAndReserveDTO;
import pl.model.dto.PL_ReservationDTO;
import pl.model.dto.PL_UserDTO;

/**
 * @FileName : PLReserveMenu.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 16.
 * @작성자 : Yuri
 * @프로그램 설명 : 예약을 관리하는 클래스. 예약 리스트를 조회하고, 한 장소의 예약정보를 조회할 수 있다. 
 * 				 조회한 예약 정보를 통해 예약을 변경하거나 취소할 수 있다.
 */
public class PL_ReserveMenu {
	
	private PL_Controller plController = new PL_Controller();
	private PL_ReservationDTO reservation = new PL_ReservationDTO();
	private PL_ListAndReserveDTO reservationList = new PL_ListAndReserveDTO();
  
	/**  
	* @Title: reserveMine  
	* @Description: 내 예약 목록 조회
	* @Params:       
	* @Return: void      
	* @Throws    
	*/
	public void reserveMine() {
		
		Scanner sc = new Scanner(System.in);
		
		List<PL_ListAndReserveDTO> reserveList = plController.reserveMine();
		
		System.out.println("=============내 예약===============");
		for (int i = 1; i <= reserveList.size(); i++) {
			System.out.println(i + ". " + reserveList.get(i-1).getMyPlace().getPl_name());
		}
		System.out.println("0. 이전 메뉴로");
		System.out.println("=================================");
		System.out.print("번호를 입력하세요 : ");
		int no = sc.nextInt();

		if (no == 0) {
			return;
		} else if (no <= reserveList.size()) {
			PL_ReserveMenu rm = new PL_ReserveMenu();
			rm.reserveInfo(reserveList.get(no-1));
		} else {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
	}
	
	public void reserveInfo(PL_ListAndReserveDTO reserve) {
		
		Scanner sc = new Scanner(System.in);
		
		plController.reserveInfo(reserve);
		
		System.out.println("==============예약정보==============");
		System.out.println("가게 이름 : "+reserve.getMyPlace().getPl_name());

		System.out.println("날짜 : " + reserve.getReserve_day().substring(0, 10));
		String time = reserve.getReserve_time().substring(0, 2);
		String minute = reserve.getReserve_time().substring(2);

		int nTime = Integer.parseInt(time);
		int nMinute = Integer.parseInt(minute);
		if (nMinute >= 0 && nMinute < 60) {
			if (nTime > 12 && nTime < 24) {
				System.out.println("시간 : 오후 " + (nTime - 12) + "시 " + nMinute + "분");
			} else if (nTime >= 0 && nTime < 12) {
				System.out.println("시간 : 오전 " + nTime + "시 " + nMinute + "분");
			} else if (nTime==12)
				System.out.println("시간 : 오후 " + nTime + "시 " + nMinute + "분");
		} else {
			System.out.println("다시 입력해주세요");
			
			return;
		}

		System.out.println();
		System.out.println("1. 예약 변경");
		System.out.println("2. 예약 취소");
		System.out.println();
		System.out.println("0. 이전 메뉴로");
		System.out.println("=================================");
		System.out.print("번호를 입력하세요 : ");
		int no = sc.nextInt();
		
		switch (no) {
		case 1:
			reservation.setReserve_no(reserve.getReserve_no());
			reservation.setUser_no(reserve.getUser_no());
			reservation.setMy_no(reserve.getMy_no());
			reservation.setReserve_day(reserve.getReserve_day());
			reservation.setReserve_time(reserve.getReserve_time());
			editReserve(reservation);
			break;
		case 2:
			reservation.setReserve_no(reserve.getReserve_no());
			reservation.setUser_no(reserve.getUser_no());
			reservation.setMy_no(reserve.getMy_no());
			reservation.setReserve_day(reserve.getReserve_day());
			reservation.setReserve_time(reserve.getReserve_time());
			cancelReserve(reservation);
			break;
		case 0:
			return;
		default :
			System.out.println("잘못 입력하셨습니다");
			return;
		}
			
	}
		
	
	public void addReserve(int my_no, String userId) {
		
		Scanner sc = new Scanner(System.in);
		
		reservation.setUser_no(selectUserInfo(userId));
		reservation.setMy_no(my_no);
		
		System.out.println("==========예약하기===========");
		System.out.println("Ex) 날짜 : 2022/01/01 -> 220101");
		System.out.println("Ex) 시간 : 오후 2시 반 -> 1430");
		System.out.print("날짜 : ");
		reservation.setReserve_day(sc.nextLine());
		System.out.print("시간 : ");
		reservation.setReserve_time(sc.nextLine()); 
		System.out.println("==============================");

		plController.addReserve(reservation);
		
	}
	
	public int selectUserInfo (String userId) {
		
		PL_UserDTO userInfo = new PL_UserDTO();
		userInfo.setUser_id(userId);
		PL_UserDTO user = plController.selectUserInfo(userInfo);
		
		return user.getUser_no();
	
	}

	public void editReserve(PL_ReservationDTO reservation) {
		
		Scanner sc = new Scanner(System.in);
		
		 System.out.println("=============예약 변경==========");
		 System.out.println("Ex) 날짜 : 2022/01/01 -> 220101");
		 System.out.println("Ex) 시간 : 오후 2시 반 -> 1430");
		 System.out.print("날짜 : ");
		 reservation.setReserve_day(sc.nextLine());
		 System.out.print("시간 : ");
		 reservation.setReserve_time(sc.nextLine());
		 System.out.println("==============================");
		 
		 plController.editReserve(reservation);
		 
	}
	
	public void cancelReserve(PL_ReservationDTO reservation) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===========예약 =============");
		System.out.print("정말 취소하시겠습니까? (Y, N) : ");
		char cancel = sc.next().charAt(0);
		System.out.println("============================");
		switch(cancel) {
		case 'y', 'Y':
			plController.cancelReserve(reservation.getReserve_no());
			break;
		case 'n', 'N':
			reserveInfo(reservationList);
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
	}
}