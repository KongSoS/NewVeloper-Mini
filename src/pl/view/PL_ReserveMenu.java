package pl.view;

import java.util.List;
import java.util.Scanner;

import pl.controller.PL_Controller;
import pl.model.dto.PL_ListAndReserveDTO;
import pl.model.dto.PL_ReservationDTO;
import pl.model.dto.PL_UserDTO;

public class PL_ReserveMenu {
	private PL_Controller controller = new PL_Controller();
	private PL_ReservationDTO rd = new PL_ReservationDTO();
	private PL_ListAndReserveDTO rl = new PL_ListAndReserveDTO();
  
	/**  
		* @Title: reserveMine  
		* @Description: 내 예약 목록 조회
		* @Params:       
		* @Return: void      
		* @Throws    
		*/
	
	public void reserveMine() {
		Scanner sc = new Scanner(System.in);
		
		List<PL_ListAndReserveDTO> reserveList = controller.reserveMine();
		
		System.out.println("=============내 예약===============");
		for (int i = 1; i <= reserveList.size(); i++) {
			// 예약된 길이만큼 i를 반복해야함
			// if() my_no와 pl_no가 같으면
			System.out.println(i + ". " + reserveList.get(i-1).getListDTO().getPl_name());
			// dto에서 장소 이름을 받아와야함
		}//List<PLReservationDTO> reserveList, PLMyListDTO pd
		System.out.println("0. 이전 메뉴로");
		System.out.println("=================================");
		System.out.print("번호를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.println();

		if (num == 0) {
			return;
		} else if (num <= reserveList.size()) {
			PL_ReserveMenu rm = new PL_ReserveMenu();
			
			rm.reserveInfo(reserveList.get(num-1));

		} else {
			System.out.println("잘못 입력하셨습니다.");
			return;// 이 리턴 어디로 가는건지
		}
	}
	
	public void reserveInfo(PL_ListAndReserveDTO reserve) {
		Scanner sc = new Scanner(System.in);

//		//시간 형태 받는 것도 고민해봐야함
		
		
			controller.reserveInfo(reserve);
			System.out.println("==============예약정보==============");
			System.out.println("가게 이름 : "+reserve.getListDTO().getPl_name());
			// 가게 이름을 소환해야함
//			String year = reserve.getReserve_day().substring(0, 1);
//			String month = reserve.getReserve_day().substring(2, 3);
//			String day = reserve.getReserve_day().substring(4);
//			int nYear = Integer.parseInt(year);
//			int nMonth = Integer.parseInt(month);
//			int nDay = Integer.parseInt(day);
//			Date reDay = new Date(nYear - 1900, nMonth - 1, nDay);
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E요일");
//
//			System.out.println("날짜 : " + sdf.format(reDay));
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
				}else if(nTime==12)
					System.out.println("시간 : 오후 " + nTime + "시 " + nMinute + "분");
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
			
			switch (num2) {
			case "1":
				rd.setReserve_no(reserve.getReserve_no());
				rd.setUser_no(reserve.getUser_no());
				rd.setMy_no(reserve.getMy_no());
				rd.setReserve_day(reserve.getReserve_day());
				rd.setReserve_time(reserve.getReserve_time());
				editReserve(rd);
				break;
			case "2":
				rd.setReserve_no(reserve.getReserve_no());
				rd.setUser_no(reserve.getUser_no());
				rd.setMy_no(reserve.getMy_no());
				rd.setReserve_day(reserve.getReserve_day());
				rd.setReserve_time(reserve.getReserve_time());
				cancelReserve(rd);
				break;
			case "0":
				return;
			default:
				System.out.println("잘못 입력하셨습니다");
				return;
			}
			
		}
		
	
	public void addReserve(int my_no, String userId) {
		Scanner sc = new Scanner(System.in);
//		PL_UserDTO userInfo = new PL_UserDTO();
//		userInfo.setUser_id(userId);
//		PL_UserDTO user = controller.selectUserInfo(userInfo);
		
//		rd.setUser_id(userId);
		rd.setUser_no(selectUserInfo(userId));
		rd.setMy_no(my_no);
//		rd.setUser_id(userId);
		//이 클래스는 저장소로부터 불러올 수 있음
		System.out.println("==========예약하기===========");
		System.out.println("Ex) 날짜 : 2022/01/01 -> 220101");
		System.out.println("Ex) 시간 : 오후 2시 반 -> 1430");
		System.out.print("날짜 : ");
		rd.setReserve_day(sc.nextLine());
		//이거 스트링으로 받아도 되는건가
		System.out.println();
		System.out.print("시간 : ");
		rd.setReserve_time(sc.nextLine());
		System.out.println();
		System.out.println("==============================");
		//매개변수로 전달해야하나?????????????/
		controller.addReserve(rd);
		
		}
	
	public int selectUserInfo (String userId) {
		//System.out.println(userId);
		
		PL_UserDTO userInfo = new PL_UserDTO();
		userInfo.setUser_id(userId);
		PL_UserDTO user = controller.selectUserInfo(userInfo);
		
//		userInfo.setUser_id(userId);
		return user.getUser_no();
		
		
	}

	public void editReserve(PL_ReservationDTO rd2) {
		Scanner sc = new Scanner(System.in);
		
		 System.out.println("=============예약 변경==========");
		 System.out.println("Ex) 날짜 : 2022/01/01 -> 220101");
		 System.out.println("Ex) 시간 : 오후 2시 반 -> 1430");
		 System.out.print("날짜 : ");
		 rd2.setReserve_day(sc.nextLine());
		 System.out.println();
		 System.out.print("시간 : ");
		 rd2.setReserve_time(sc.nextLine());
		 System.out.println();
		 System.out.println("==============================");
		 
		 controller.editReserve(rd2);
	}
	
	public void cancelReserve(PL_ReservationDTO rd2) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===========예약 =============");
		System.out.print("정말 취소하시겠습니까? (Y, N) : ");
		char cancel = sc.next().charAt(0);
		System.out.println("============================");
		switch(cancel) {
		case 'y', 'Y':
			controller.cancelReserve(rd2.getReserve_no());
			break;
		case 'n', 'N':
			reserveInfo(rl);
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
	}


}

