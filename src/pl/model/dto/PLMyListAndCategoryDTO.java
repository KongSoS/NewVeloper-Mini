/**
  * 
  */
package pl.model.dto;

import java.util.List;

/**
  * @FileName : PLMyListAndCategoryDTO.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 15. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 : 태그와 장소저장DTO
  */
public class PLMyListAndCategoryDTO {
	private String pl_name;
	private String pl_address;
	private String pl_tel;
	private int score;
	private String pl_catecode;
	private String pl_reserve;
	private List<String> tagList;
	
	/**
	 * 
	 */
	public PLMyListAndCategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pl_name 장소이름
	 * @param pl_address 장소주소
	 * @param pl_tel 가게 전화번호
	 * @param score 별점
	 * @param pl_catecode 카테고리 코드
	 * @param pl_reserve 예약 유무
	 * @param tagList 테그를 가지는 리스트
	 */
	public PLMyListAndCategoryDTO(String pl_name, String pl_address, String pl_tel, int score, String pl_catecode,
			String pl_reserve, List<String> tagList) {
		super();
		this.pl_name = pl_name;
		this.pl_address = pl_address;
		this.pl_tel = pl_tel;
		this.score = score;
		this.pl_catecode = pl_catecode;
		this.pl_reserve = pl_reserve;
		this.tagList = tagList;
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
	 * @return the tagList
	 */
	public List<String> getTagList() {
		return tagList;
	}

	/**
	 * @param tagList the tagList to set
	 */
	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}

	@Override
	public String toString() {
		return "PLMyListAndCategoryDTO [pl_name=" + pl_name + ", pl_address=" + pl_address + ", pl_tel=" + pl_tel
				+ ", score=" + score + ", pl_catecode=" + pl_catecode + ", pl_reserve=" + pl_reserve + ", tagList="
				+ tagList + "]";
	}
	
	
	
	
}
