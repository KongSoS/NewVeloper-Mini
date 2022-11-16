/**
  * 
  */
package pl.model.dto;

import java.sql.Date;

/**
  * @FileName : PlaceListDTO.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 : 변수들을 선언하고 SQL문의 값들과 매치가 되야 한다.
  */
public class PLUserDTO {
	private int user_no;		
	private String user_id;		
	private String user_pwd;	
	private String user_name;	
	private String phone;		
	private Date enroll_date;
	private Date del_date;		
	private String status;		
	private String manager;		
	
	/**
	 * 기본 생성자
	 */
	public PLUserDTO() {
		// TODO Auto-generated constructor stub
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
	public PLUserDTO(int user_no, String user_id, String user_pwd, String user_name, String phone, Date enroll_date,
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
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the user_pwd
	 */
	public String getUser_pwd() {
		return user_pwd;
	}

	/**
	 * @param user_pwd the user_pwd to set
	 */
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the enroll_date
	 */
	public Date getEnroll_date() {
		return enroll_date;
	}

	/**
	 * @param enroll_date the enroll_date to set
	 */
	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	/**
	 * @return the del_date
	 */
	public Date getDel_date() {
		return del_date;
	}

	/**
	 * @param del_date the del_date to set
	 */
	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "PLUserDTO [user_no=" + user_no + ", user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_name="
				+ user_name + ", phone=" + phone + ", enroll_date=" + enroll_date + ", del_date=" + del_date
				+ ", status=" + status + ", manager=" + manager + "]";
	}
	
	
}
