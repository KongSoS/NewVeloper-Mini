/**
 * 
 */
package pl.model.dto;

/**
 * @author jihee
 *
 */
public class PL_MyListDTO {
	
	private int rownum;
	private int pl_no;
	private String pl_name;
	private String pl_address;
	private String pl_tel;
	private int score;
	private String pl_catecode;
	private String pl_tagcode;
	private String pl_reserve;
	private PL_CategoryDTO category;
	private PL_TagDTO tag;
	private int user_no;
	
	public PL_MyListDTO() {
		//기본생성자
	}

	/**
	 * @param rownum 정렬 기준을 잡기위한 변수
	 * @param pl_no 장소 번호 PK
	 * @param pl_name 장소 이름
	 * @param pl_address 장소 주소
	 * @param pl_tel 장소 전화번호
	 * @param score 장소 별점
	 * @param pl_catecode 장소 카테고리
	 * @param pl_reserve 장소 예약 유무
	 * @param category 카테고리DTO
	 * @param tag 테그DTO
	 * @param tag user_no 유저 번호
	 */
	public PL_MyListDTO(int rownum, int pl_no, String pl_name, String pl_address, String pl_tel, int score,
			String pl_catecode, String pl_tagcode, String pl_reserve, PL_CategoryDTO category, PL_TagDTO tag, int user_no) {
		super();
		this.rownum = rownum;
		this.pl_no = pl_no;
		this.pl_name = pl_name;
		this.pl_address = pl_address;
		this.pl_tel = pl_tel;
		this.score = score;
		this.pl_catecode = pl_catecode;
		this.pl_tagcode = pl_tagcode;
		this.pl_reserve = pl_reserve;
		this.category = category;
		this.tag = tag;
		this.user_no = user_no;
	}

	/**
	 * @return the pl_tagcode
	 */
	public String getPl_tagcode() {
		return pl_tagcode;
	}

	/**
	 * @param pl_tagcode the pl_tagcode to set
	 */
	public void setPl_tagcode(String pl_tagcode) {
		this.pl_tagcode = pl_tagcode;
	}

	/**
	 * @return the rownum
	 */
	public int getRownum() {
		return rownum;
	}

	/**
	 * @param rownum the rownum to set
	 */
	public void setRownum(int rownum) {
		this.rownum = rownum;
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

	/**
	 * @return the category
	 */
	public PL_CategoryDTO getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(PL_CategoryDTO category) {
		this.category = category;
	}

	/**
	 * @return the tag
	 */
	public PL_TagDTO getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(PL_TagDTO tag) {
		this.tag = tag;
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
	
	
}
