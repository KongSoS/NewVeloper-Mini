package pl.model.dto;

/**
 * @FileName : PLReservationDTO.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 14. 
 * @작성자 : Yuri 
 * @프로그램 설명 : 예약정보와 내 장소를 관리하는 DTO
 */
public class PL_ListAndReserveDTO {
	
	private int reserve_no;
	private int user_no;
	private int my_no;
	private String reserve_day;
	private String reserve_time;
	private PL_MyListDTO myPlace;
	
	/* 예약 가게이름을 조회하기 위한 dto */
	public PL_ListAndReserveDTO() {
	}  
	
	/**
	 * @param reserve_no 예약번호
	 * @param user_no 유저번호
	 * @param my_no 장소번호
	 * @param reserve_day 예약일
	 * @param reserve_time 예약시간
	 * @param myPlace 내 장소 
	 */
	public PL_ListAndReserveDTO(int reserve_no, int user_no, int my_no, String reserve_day, String reserve_time,
			PL_MyListDTO myPlace) {
		super();
		this.reserve_no = reserve_no;
		this.user_no = user_no;
		this.my_no = my_no;
		this.reserve_day = reserve_day;
		this.reserve_time = reserve_time;
		this.myPlace = myPlace;
	}

	public int getReserve_no() {
		return reserve_no;
	}

	public PL_MyListDTO getMyPlace() {
		return myPlace;
	}

	public void setMyPlace(PL_MyListDTO myPlace) {
		this.myPlace = myPlace;
	}

	public void setReserve_no(int reserve_no) {
		this.reserve_no = reserve_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getMy_no() {
		return my_no;
	}

	public void setMy_no(int my_no) {
		this.my_no = my_no;
	}

	public String getReserve_day() {
		return reserve_day;
	}

	public void setReserve_day(String reserve_day) {
		this.reserve_day = reserve_day;
	}

	public String getReserve_time() {
		return reserve_time;
	}

	public void setReserve_time(String reserve_time) {
		this.reserve_time = reserve_time;
	}
	
}
