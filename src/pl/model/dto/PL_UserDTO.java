package pl.model.dto;

import java.sql.Date;

/**
  * @FileName : PlaceListDTO.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 : 2022. 11. 16 성식 (toString 설정 변경)
  * @프로그램 설명 : 변수들을 선언하고 SQL문의 값들과 매치가 되야 한다.
  */
public class PL_UserDTO {
	
	private int user_no;		
	private String user_id;		
	private String user_pwd;	
	private String user_name;	
	private String phone;		
	private Date enroll_date;
	private Date del_date;		
	private String status;		
	private String manager;		

	public PL_UserDTO() {
	}
	
	/**
	 * @param user_no 회원번호
	 * @param user_id 아이디
	 * @param user_pwd 비밀번호
	 * @param user_name 이름
	 * @param phone 휴대전화
	 * @param enroll_date 가입일
	 * @param del_date 탈퇴일
	 * @param status 탈퇴여부
	 * @param manager 관리자여부
	 */
	public PL_UserDTO(int user_no, String user_id, String user_pwd, String user_name, String phone, Date enroll_date,
			Date del_date, String status, String manager) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.phone = phone;
		this.enroll_date = enroll_date;
		this.del_date = del_date;
		this.status = status;
		this.manager = manager;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	public Date getDel_date() {
		return del_date;
	}

	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	@Override
	public String toString() {
		return "========= 회원정보 ========= \n회원번호 : " + user_no + "\n아이디 : " + user_id + "\n비밀번호 : " + user_pwd + "\n이름 : "
	            + user_name + "\n전화번호 : " + phone + "\n가입일 : " + enroll_date + "\n탈퇴일 : " + del_date
	            + "\n탈퇴여부 : " + status + "\n관리자 : " + manager;
	}
	
	
}
