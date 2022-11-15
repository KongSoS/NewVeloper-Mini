/**
  * 
  */
package pl.model.dao;

import java.util.ArrayList;
import java.util.List;

import common.SearchUserStandard;
import pl.model.dto.PLCategoryDTO;
import pl.model.dto.PLListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLRservationDTO;
import pl.model.dto.PLUserDTO;

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

	/**
	 * @FileName : PLDAO.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	ArrayList<PLListAndCategoryDTO> selectAllName();

	/**
	 * @FileName : PLDAO.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	ArrayList<PLListAndCategoryDTO> selectAllAddress();

	/**
	 * @FileName : PLDAO.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	ArrayList<PLListAndCategoryDTO> selectAllScore();

	/**
	 * @FileName : PLDAO.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	ArrayList<PLListAndCategoryDTO> selectAllCategory();

//	/**
//	 * @FileName : PLDAO.java
//	 * @Project : NewVeloper_mini
//	 * @Date : 2022. 11. 15.
//	 * @작성자 : jihee
//	 * @변경이력 :
//	 * @프로그램 설명 : 
//	 */
//	ArrayList<PLCategoryDTO> selectOnlyCategory();

	

	List<PLRservationDTO> reserveMine();

	PLRservationDTO reserveInfo(int num);

	int editReserve(PLRservationDTO re);

	int cancelReserve(int num);

	
	
	
	
	PLUserDTO userIdOverlapCheck(String userId);
	
	PLUserDTO userPwdOverlapCheck(String userPwd);

	int registUser(PLUserDTO user);

	List<PLUserDTO> selectUserList(SearchUserStandard searchUserStandard);
	
}
