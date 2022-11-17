package pl.model.dto;

public class PL_ReservationDTO {
	
	private int reserve_no;
	private int user_no;
//	private String user_id;
	private int my_no;
	private String reserve_day;
	private String reserve_time;
	
	public PL_ReservationDTO() {
	}  

	public PL_ReservationDTO(int reserve_no, int user_no, int my_no, String reserve_day, String reserve_time) {
		super();
		this.reserve_no = reserve_no;
		this.user_no = user_no;
		this.my_no = my_no;
		this.reserve_day = reserve_day;
		this.reserve_time = reserve_time;
	}

	public int getReserve_no() {
		return reserve_no;
	}

//	public PL_ReservationDTO(int reserve_no, String user_id, int my_no, String reserve_day, String reserve_time) {
//	super();
//	this.reserve_no = reserve_no;
//	this.user_id = user_id;
//	this.my_no = my_no;
//	this.reserve_day = reserve_day;
//	this.reserve_time = reserve_time;
//}

	public void setReserve_no(int reserve_no) {
		this.reserve_no = reserve_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

//	public String getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(String user_id) {
//		this.user_id = user_id;
//	}

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
