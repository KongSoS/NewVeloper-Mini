/**
  * 
  */
package pl.model.dao;

import java.util.ArrayList;
import java.util.List;

import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLRservationDTO;

/**
  * @FileName : PlaceListDAO.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 :DB와 직접적으로 접근하며 SQL구문을 실행하는 클래스
  */
public interface PLDAO {

	/**
	  * @Method Name : selectAllPlace
	  * @작성일 : 2022. 11. 14.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @return
	  */
	ArrayList<PLMyListDTO> selectAllPlace();

	List<PLRservationDTO> reserveMine();

	PLRservationDTO reserveInfo(int num);

	int editReserve(PLRservationDTO re);

	int cancelReserve(int num);

	
}
