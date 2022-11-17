package pl.model.dto;

public class PL_ListAndReserveDTO {
	
	private int reserve_no;
	private int user_no;
	private int my_no;
	private String reserve_day;
	private String reserve_time;
	private PL_ListAllDTO listDTO;
	
	/* 예약 가게이름을 조회하기 위한 dto */
	public PL_ListAndReserveDTO() {
	}  
	
	/**
	 * @param reserve_no 예약번호
	 * @param user_no 유저번호
	 * @param my_no 장소번호
	 * @param reserve_day 예약일
	 * @param reserve_time 예약시간
	 * @param listDTO PLlistDTO
	 * 
	 */
	public PL_ListAndReserveDTO(int reserve_no, int user_no, int my_no, String reserve_day, String reserve_time,
			PL_ListAllDTO listDTO) {
		super();
		this.reserve_no = reserve_no;
		this.user_no = user_no;
		this.my_no = my_no;
		this.reserve_day = reserve_day;
		this.reserve_time = reserve_time;
		this.listDTO = listDTO;
	}

	public int getReserve_no() {
		return reserve_no;
	}

	public PL_ListAllDTO getListDTO() {
		return listDTO;
	}

	public void setListDTO(PL_ListAllDTO listDTO) {
		this.listDTO = listDTO;
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
