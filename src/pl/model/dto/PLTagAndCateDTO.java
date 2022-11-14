/**
  * 
  */
package pl.model.dto;

/**
  * @FileName : PLPlaceDTO.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 14. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 : 태그와 카테고리에 관련된 DTO
  */
public class PLTagAndCateDTO {
	private String category_code; 
	private String category_name;
	private String pl_no;
	private String tag_code;
	/**
	 * @param category_code 카테고리 코드
	 * @param category_name 카테고리 이름
	 * @param tag_code 장소 번호
	 */
	public PLTagAndCateDTO(String category_code, String category_name, String tag_code) {
		super();
		this.category_code = category_code;
		this.category_name = category_name;
		this.tag_code = tag_code;
	}
	/**
	 * @return the category_code
	 */
	public String getCategory_code() {
		return category_code;
	}
	/**
	 * @param category_code the category_code to set
	 */
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	/**
	 * @return the category_name
	 */
	public String getCategory_name() {
		return category_name;
	}
	/**
	 * @param category_name the category_name to set
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	/**
	 * @return the pl_no
	 */
	public String getPl_no() {
		return pl_no;
	}
	/**
	 * @param pl_no the pl_no to set
	 */
	public void setPl_no(String pl_no) {
		this.pl_no = pl_no;
	}
	/**
	 * @return the tag_code
	 */
	public String getTag_code() {
		return tag_code;
	}
	/**
	 * @param tag_code the tag_code to set
	 */
	public void setTag_code(String tag_code) {
		this.tag_code = tag_code;
	}
	@Override
	public String toString() {
		return "PLTagAndCateDTO [category_code=" + category_code + ", category_name=" + category_name + ", pl_no="
				+ pl_no + ", tag_code=" + tag_code + "]";
	}
	
	
	
}
