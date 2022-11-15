/**
  * 
  */
package pl.view;

import java.util.ArrayList;
import java.util.List;

import pl.controller.PLController;
import pl.model.dto.PLMyListDTO;

/**
 * @FileName : ResultView.java
 * @Project : NewVeloper_mini
 * @Date : 2022. 11. 15.
 * @작성자 : heojaehong
 * @변경이력 :
 * @프로그램 설명 :
 */
public class ResultView {
	
	/**
	  * @Method Name : MoreInfo
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :해당 장소의 상세 정보 출력하는 메소드
	  * @param plMyListDTO
	  */
	public void MoreInfo(PLMyListDTO pd) {
		int num;
		System.out.println("==================== 장소 정보 ====================");
		System.out.println("이름 : " + pd.getPl_name());
		System.out.println("장소 : " + pd.getPl_address());
		System.out.println("예약 : " + pd.getPl_reserve());
		System.out.println("별점 : " + pd.getScore());
		System.out.println("태그 : ");
		System.out.println("전화번호 : " + pd.getPl_tel());
		System.out.println();
		System.out.println();
		System.out.println("1. 장소 수정");
		System.out.println("2. 장소 삭제");
		System.out.println("0. 이전 메뉴로");
		System.out.println("00. 메인 메뉴로");
		System.out.println("=================================================");
		
	}

}
