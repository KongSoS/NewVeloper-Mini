/**
  * 
  */
package pl.serivce;


import static common.PLTemplate.getSession;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import pl.model.dao.PLDAO;
import pl.model.dto.PLMyListDTO;
import pl.model.dto.PLRservationDTO;

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
	
	
	
	
	
	
	
	
	
	
	
	
	public List<PLRservationDTO> reserveMine() {
		
		
		SqlSession session = getSession();
		
		mapper = session.getMapper(PLDAO.class);
		
		List<PLRservationDTO> reserveList = mapper.reserveMine();
		
		session.close();
		
		return reserveList;
}

	public PLRservationDTO reserveInfo(int num) {
		SqlSession session = getSession();
	
		mapper = session.getMapper(PLDAO.class);
		PLRservationDTO menu = mapper.reserveInfo(num);
	
		session.close();
	
		return menu;
	}

	public boolean editReserve(PLRservationDTO re) {
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
