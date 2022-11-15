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
  * @프로그램 설명 : 태그 DTO
  */
public class PLTagDTO {
	private String tag_code;
	private String tag_name;
	/**
	 * @param tag_code 테그 코드
	 * @param tag_name 테그 이름
	 */
	/**
	 * 
	 */
	public PLTagDTO() {
		// TODO Auto-generated constructor stub
	}
	public PLTagDTO( String tag_code, String tag_name) {
		super();
		this.tag_code = tag_code;
		this.tag_name = tag_name;
	}
	/**
	 * @return the tag_name
	 */
	public String getTag_name() {
		return tag_name;
	}
	/**
	 * @param tag_name the tag_name to set
	 */
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
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
		return "PLTagDTO [tag_code=" + tag_code + ", tag_name=" + tag_name + "]";
	}
	
	
	
	
	
}
