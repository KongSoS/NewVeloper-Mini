/**
  * 
  */
package pl.model.dto;

/**
  * @FileName : PLCategoryDTO.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 14. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 : 카테고리 DTO
  */
public class PLCategoryDTO {
	private String category_code; 
	private String category_name;
	
	/**
	 * 
	 */
	public PLCategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param category_code 카테고리 코드
	 * @param category_name 카테고리 이름
	 */
	public PLCategoryDTO(String category_code, String category_name) {
		super();
		this.category_code = category_code;
		this.category_name = category_name;
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

	@Override
	public String toString() {
		return "PLCategoryDTO [category_code=" + category_code + ", category_name=" + category_name + "]";
	}
	
	
}
