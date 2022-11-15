package pl.view;

import java.util.Scanner;

import pl.controller.PLController;
import pl.model.dto.PLReservationDTO;

public class PLReserveMenu {
	private Scanner sc = new Scanner(System.in);
	//int num = 0;
	private PLController controller = new PLController();
	private PLReservationDTO rd = new PLReservationDTO();
	public void reserveInfo() {
		// TODO Auto-generated method stub

//		//시간 형태 받는 것도 고민해봐야함
		controller.reserveInfo(rd.getReserve_no());
		
		
	}
	public void addReserve(int my_no) {
		//이 클래스는 저장소로부터 불러올 수 있음
		System.out.println("==========예약하기===========");
		System.out.println("Ex) 날짜 : 2022/01/01 -> 220101");
		System.out.println("Ex) 시간 : 오후 2시 반 -> 1430");
		System.out.print("날짜 : ");
		String day = sc.nextLine();
		//이거 스트링으로 받아도 되는건가
		System.out.println();
		System.out.print("시간 : ");
		String time = sc.nextLine();
		System.out.println();
		System.out.println("==============================");
		//매개변수로 전달해야하나?????????????/
		controller.addReserve(my_no, day, time);
		}
	

	public void editReserve() {
		
		 System.out.println("=============예약 변경==========");
		 System.out.println("Ex) 날짜 : 2022/01/01 -> 220101");
		 System.out.println("Ex) 시간 : 오후 2시 반 -> 1430");
		 System.out.print("날짜 : ");
		 String day = sc.nextLine();

		 System.out.println();
		 System.out.print("시간 : ");
		 String time = sc.nextLine();
		 System.out.println();
		 System.out.println("==============================");
		 
		 controller.editReserve(rd.getReserve_no(), day, time);
	}
	
	public void cancelReserve() {
		
		System.out.println("===========예약 =============");
		System.out.print("정말 취소하시겠습니까? (Y, N) : ");
		char cancel = sc.next().charAt(0);
		System.out.println("============================");
		switch(cancel) {
		case 'y', 'Y':
			controller.cancelReserve(rd.getReserve_no());
			break;
		case 'n', 'N':
			reserveInfo();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
	}
}

