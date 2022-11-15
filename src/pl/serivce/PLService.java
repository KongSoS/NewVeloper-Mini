/**
  * 
  */
package pl.serivce;


import static common.PLTemplate.getSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import pl.model.dao.PLDAO;
import pl.model.dto.PLCategoryDTO;
import pl.model.dto.PLListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;

/**
  * @FileName : PLService.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 :
  */
public class PLService {
	
	private PLDAO mapper;
	/**
	  * @Method Name : myPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @return
	  */
	public ArrayList<PLMyListDTO> myPlaceList() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		ArrayList<PLMyListDTO> Plist = mapper.selectAllPlace();
		return Plist;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @FileName : PLService.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public ArrayList<PLListAndCategoryDTO> selectAllName() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAndCategoryDTO> placeList = mapper.selectAllName();
		
		session.close();
		
		return placeList;
	}
	
	
	/**
	 * @FileName : PLService.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public ArrayList<PLListAndCategoryDTO> selectAllAddress() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAndCategoryDTO> placeList = mapper.selectAllAddress();
		
		session.close();
		
		return placeList;
	}

	/**
	 * @FileName : PLService.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public ArrayList<PLListAndCategoryDTO> selectAllScore() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAndCategoryDTO> placeList = mapper.selectAllScore();
		
		session.close();
		
		return placeList;
	}

	/**
	 * @FileName : PLService.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public ArrayList<PLListAndCategoryDTO> selectAllCategory() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAndCategoryDTO> placeList = mapper.selectAllCategory();
		
		session.close();
		
		return placeList;
	}



//	/**
//	 * @FileName : PLService.java
//	 * @Project : NewVeloper_mini
//	 * @Date : 2022. 11. 15.
//	 * @작성자 : jihee
//	 * @변경이력 :
//	 * @프로그램 설명 : 
//	 */
//	public ArrayList<PLCategoryDTO> selectOnlyCategory() {
//		SqlSession session = getSession();
//		mapper = session.getMapper(PLDAO.class);
//		
//		ArrayList<PLCategoryDTO> category = mapper.selectOnlyCategory();
//		
//		session.close();
//		
//		return category;
//	}

	
	
}
