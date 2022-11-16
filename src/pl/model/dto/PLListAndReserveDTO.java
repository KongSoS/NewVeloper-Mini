package pl.model.dto;

public class PLListAndReserveDTO {
	private int reserve_no;
	private int user_no;
	private int my_no;
	private String reserve_day;
	private String reserve_time;
	private PLMyListDTO listDTO;
	
	/**
	 * 예약 가게이름을 조회하기 위한 dto
	 */
	public PLListAndReserveDTO() {
		// 기본생성자
	}
	
	/**
	 * @param reserve_no
	 * @param user_no
	 * @param my_no
	 * @param reserve_day
	 * @param reserve_time
	 * @param listDTO
	 */
	public PLListAndReserveDTO(int reserve_no, int user_no, int my_no, String reserve_day, String reserve_time,
			PLMyListDTO listDTO) {
		super();
		this.reserve_no = reserve_no;
		this.user_no = user_no;
		this.my_no = my_no;
		this.reserve_day = reserve_day;
		this.reserve_time = reserve_time;
		this.listDTO = listDTO;
	}

	/**
	 * @param reserve_no
	 * @param user_no
	 * @param my_no
	 * @param reserve_day
	 * @param reserve_time
	 * @param pl_name
	 */
	

	/**
	 * @return the reserve_no
	 */
	public int getReserve_no() {
		return reserve_no;
	}

	/**
	 * @return the listDTO
	 */
	public PLMyListDTO getListDTO() {
		return listDTO;
	}

	/**
	 * @param listDTO the listDTO to set
	 */
	public void setListDTO(PLMyListDTO listDTO) {
		this.listDTO = listDTO;
	}

	/**
	 * @param reserve_no the reserve_no to set
	 */
	public void setReserve_no(int reserve_no) {
		this.reserve_no = reserve_no;
	}

	/**
	 * @return the user_no
	 */
	public int getUser_no() {
		return user_no;
	}

	/**
	 * @param user_no the user_no to set
	 */
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	/**
	 * @return the my_no
	 */
	public int getMy_no() {
		return my_no;
	}

	/**
	 * @param my_no the my_no to set
	 */
	public void setMy_no(int my_no) {
		this.my_no = my_no;
	}

	/**
	 * @return the reserve_day
	 */
	public String getReserve_day() {
		return reserve_day;
	}

	/**
	 * @param reserve_day the reserve_day to set
	 */
	public void setReserve_day(String reserve_day) {
		this.reserve_day = reserve_day;
	}

	/**
	 * @return the reserve_time
	 */
	public String getReserve_time() {
		return reserve_time;
	}

	/**
	 * @param reserve_time the reserve_time to set
	 */
	public void setReserve_time(String reserve_time) {
		this.reserve_time = reserve_time;
	}

	
	
}
