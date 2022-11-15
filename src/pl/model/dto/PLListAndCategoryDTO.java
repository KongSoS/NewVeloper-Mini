/**
 * 
 */
package pl.model.dto;

/**
 * @author jihee
 *
 */
public class PLListAndCategoryDTO {
	
	private int pl_no;
	private String pl_name;
	private String pl_address;
	private String pl_tel;
	private int score;
	private String pl_catecode;
	private String pl_reserve;
	private int rownum;
	private PLCategoryDTO category;
	
	public PLListAndCategoryDTO() {
		//기본생성자
	}
	/**
	 * @param pl_no
	 * @param pl_name
	 * @param pl_address
	 * @param pl_tel
	 * @param score
	 * @param pl_catecode
	 * @param pl_reserve
	 * @param rownum
	 * @param category
	 */
	public PLListAndCategoryDTO(int pl_no, String pl_name, String pl_address, String pl_tel, int score,
			String pl_catecode, String pl_reserve, int rownum, PLCategoryDTO category) {
		super();
		this.pl_no = pl_no;
		this.pl_name = pl_name;
		this.pl_address = pl_address;
		this.pl_tel = pl_tel;
		this.score = score;
		this.pl_catecode = pl_catecode;
		this.pl_reserve = pl_reserve;
		this.rownum = rownum;
		this.category = category;
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
	 * @return the category
	 */
	public PLCategoryDTO getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(PLCategoryDTO category) {
		this.category = category;
	}
	
	
	
	
	
	
	
	
	
	
	

}