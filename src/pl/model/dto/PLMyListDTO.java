/**
  * 
  */
package pl.model.dto;

/**
  * @FileName : PLMyListDTO.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 14. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 : 장소에 관련된 DTO
  */
public class PLMyListDTO {
	private int pl_no;
	private String pl_name;
	private String pl_address;
	private String pl_tel;
	private int score;
	private String pl_catecode;
	private String pl_reserve;
	
	/**
	 * 
	 */
	public PLMyListDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pl_no 장소번호
	 * @param pl_name 매장명
	 * @param pl_address 매장주소
	 * @param pl_tel 매장연락처
	 * @param score 별점
	 * @param pl_catecode 카테고리코드
	 * @param pl_reserve 예약가능여부
	 */
	public PLMyListDTO(int pl_no, String pl_name, String pl_address, String pl_tel, int score, String pl_catecode,
			String pl_reserve) {
		super();
		this.pl_no = pl_no;
		this.pl_name = pl_name;
		this.pl_address = pl_address;
		this.pl_tel = pl_tel;
		this.score = score;
		this.pl_catecode = pl_catecode;
		this.pl_reserve = pl_reserve;
	}

	/**
	 * @return the pl_no
	 */
	public int getPl_no() {
		return pl_no;
	}

	/**
	 * @param pl_no the pl_no to set
	 */
	public void setPl_no(int pl_no) {
		this.pl_no = pl_no;
	}

	/**
	 * @return the pl_name
	 */
	public String getPl_name() {
		return pl_name;
	}

	/**
	 * @param pl_name the pl_name to set
	 */
	public void setPl_name(String pl_name) {
		this.pl_name = pl_name;
	}

	/**
	 * @return the pl_address
	 */
	public String getPl_address() {
		return pl_address;
	}

	/**
	 * @param pl_address the pl_address to set
	 */
	public void setPl_address(String pl_address) {
		this.pl_address = pl_address;
	}

	/**
	 * @return the pl_tel
	 */
	public String getPl_tel() {
		return pl_tel;
	}

	/**
	 * @param pl_tel the pl_tel to set
	 */
	public void setPl_tel(String pl_tel) {
		this.pl_tel = pl_tel;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the pl_catecode
	 */
	public String getPl_catecode() {
		return pl_catecode;
	}

	/**
	 * @param pl_catecode the pl_catecode to set
	 */
	public void setPl_catecode(String pl_catecode) {
		this.pl_catecode = pl_catecode;
	}

	/**
	 * @return the pl_reserve
	 */
	public String getPl_reserve() {
		return pl_reserve;
	}

	/**
	 * @param pl_reserve the pl_reserve to set
	 */
	public void setPl_reserve(String pl_reserve) {
		this.pl_reserve = pl_reserve;
	}

	@Override
	public String toString() {
		return "PLMyListDTO [pl_no=" + pl_no + ", pl_name=" + pl_name + ", pl_address=" + pl_address + ", pl_tel="
				+ pl_tel + ", score=" + score + ", pl_catecode=" + pl_catecode + ", pl_reserve=" + pl_reserve + "]";
	}
	
	
	
}
