package pl.model.dto;

public class PL_ListAllDTO {
	
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
	
	public PL_ListAllDTO() {
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
	 */
	public PL_ListAllDTO(int rownum, int pl_no, String pl_name, String pl_address, String pl_tel, int score,
			String pl_catecode, String pl_tagcode, String pl_reserve, PL_CategoryDTO category, PL_TagDTO tag) {
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
	}

	public String getPl_tagcode() {
		return pl_tagcode;
	}

	public void setPl_tagcode(String pl_tagcode) {
		this.pl_tagcode = pl_tagcode;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getPl_no() {
		return pl_no;
	}

	public void setPl_no(int pl_no) {
		this.pl_no = pl_no;
	}

	public String getPl_name() {
		return pl_name;
	}

	public void setPl_name(String pl_name) {
		this.pl_name = pl_name;
	}

	public String getPl_address() {
		return pl_address;
	}

	public void setPl_address(String pl_address) {
		this.pl_address = pl_address;
	}

	public String getPl_tel() {
		return pl_tel;
	}

	public void setPl_tel(String pl_tel) {
		this.pl_tel = pl_tel;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPl_catecode() {
		return pl_catecode;
	}

	public void setPl_catecode(String pl_catecode) {
		this.pl_catecode = pl_catecode;
	}

	public String getPl_reserve() {
		return pl_reserve;
	}

	public void setPl_reserve(String pl_reserve) {
		this.pl_reserve = pl_reserve;
	}

	public PL_CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(PL_CategoryDTO category) {
		this.category = category;
	}

	public PL_TagDTO getTag() {
		return tag;
	}

	public void setTag(PL_TagDTO tag) {
		this.tag = tag;
	}
	
}
