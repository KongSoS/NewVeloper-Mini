/**
  * 
  */
package pl.view;

import pl.model.dto.PLListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;

/**
  * @FileName : MoreInfoView.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 15. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 :
  */
public class MoreInfoView {
	
	/**
	  * @Method Name : MoreInfo
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 내 장소 상세 페이지
	  * @param plMyListDTO
	  */
	public void MoreInfo(PLListAndCategoryDTO plListAndCategoryDTO) {
		int num;
		System.out.println("==================== 장소 정보 ====================");
		System.out.println("이름 : " + plListAndCategoryDTO.getPl_name());
		System.out.println("장소 : " + plListAndCategoryDTO.getPl_address());
		System.out.println("예약 : " + plListAndCategoryDTO.getPl_reserve());
		System.out.println("별점 : " + plListAndCategoryDTO.getScore());
		System.out.println("태그 : ");
		System.out.println("전화번호 : " + plListAndCategoryDTO.getPl_tel());
		System.out.println();
		System.out.println();
		System.out.println("1. 장소 수정");
		System.out.println("2. 장소 삭제");
		System.out.println("0. 이전 메뉴로");
		System.out.println("00. 메인 메뉴로");
		System.out.println("=================================================");
	}
}
