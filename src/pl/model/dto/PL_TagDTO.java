package pl.model.dto;

/**
  * @FileName : PLPlaceDTO.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 14. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 : 태그 DTO
  */
public class PL_TagDTO {
	
	private String tag_code;
	private String tag_name;

	public PL_TagDTO(){
	}
	
	public PL_TagDTO( String tag_code, String tag_name) {
		super();
		this.tag_code = tag_code;
		this.tag_name = tag_name;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	public String getTag_code() {
		return tag_code;
	}

	public void setTag_code(String tag_code) {
		this.tag_code = tag_code;
	}
	
	@Override
	public String toString() {
		return "PLTagDTO [tag_code=" + tag_code + ", tag_name=" + tag_name + "]";
	}
	
}
