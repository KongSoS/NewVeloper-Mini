/**
  * 
  */
package pl.serivce;


import static common.PLTemplate.getSession;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import pl.model.dao.PLDAO;
import pl.model.dto.PLCategoryDTO;
import pl.model.dto.PLListAndCategoryDTO;
import pl.model.dto.PLMyListAndCategoryDTO;
import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLReservationDTO;

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
	  * @Method 설명 : 내 장소 전체를 보여주는 메소드
	  * @return
	  */
	public ArrayList<PLMyListDTO> myPlaceList() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		ArrayList<PLMyListDTO> Plist = mapper.selectAllPlace();
		
		session.close();
		return Plist;
	}
	

	public List<PLMyListAndCategoryDTO> addPlaceList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PLReservationDTO> reserveMine() {
		
		
		SqlSession session = getSession();
		
		mapper = session.getMapper(PLDAO.class);
		
		List<PLReservationDTO> reserveList = mapper.reserveMine();
		
		session.close();
		
		return reserveList;
}


	public PLReservationDTO reserveInfo(int num) {
		SqlSession session = getSession();
	
		mapper = session.getMapper(PLDAO.class);
		PLReservationDTO menu = mapper.reserveInfo(num);
	
		session.close();
	
		return menu;
	}

	public boolean editReserve(PLReservationDTO re) {
		SqlSession session = getSession();
	
		mapper = session.getMapper(PLDAO.class);
		int result = mapper.editReserve(re);
	
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
	
		session.close();
	
		return result > 0? true: false;
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

	public boolean cancelReserve(int num) {
		SqlSession session = getSession();
	
		mapper = session.getMapper(PLDAO.class);
		int result = mapper.cancelReserve(num);
	
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result > 0? true: false;
	}
  
  
  
}
