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
import pl.model.dto.PLListAndReserveDTO;
import pl.model.dto.PLListAllDTO;
import pl.model.dto.PLReservationDTO;

/**
  * @FileName : PLService.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 : service 클래스
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
	public ArrayList<PLListAllDTO> myPlaceList() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		ArrayList<PLListAllDTO> Plist = mapper.selectAllPlace();
		
		session.close();
		return Plist;
	}
	
	/**
	  * @Method Name : addPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 새로운 장소를 등록할 sql문에 접근하는 메소드
	  * @return
	  */
	public void addPlaceList(PLListAllDTO dto) {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		System.out.println("service의 dto : " + dto);
		int result = mapper.insertPlace(dto);
		
		if(result > 0) {
			System.out.println("장소등록 성공!");
			session.commit();
		}else {
			System.out.println("장소등록 실패!");
			session.rollback();			
		}
		session.close();
	}

	public List<PLListAndReserveDTO> reserveMine() {
		
		
		SqlSession session = getSession();
		
		mapper = session.getMapper(PLDAO.class);
		
		List<PLListAndReserveDTO> reserveList = mapper.reserveMine();
		
		session.close();
		
		return reserveList;
}


	public PLListAndReserveDTO reserveInfo(int num) {
		SqlSession session = getSession();
	
		mapper = session.getMapper(PLDAO.class);
		PLListAndReserveDTO menu = mapper.reserveInfo(num);
	
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
	public ArrayList<PLListAllDTO> selectAllName() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAllDTO> placeList = mapper.selectAllName();
		
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
	public ArrayList<PLListAllDTO> selectAllAddress() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAllDTO> placeList = mapper.selectAllAddress();
		
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
	public ArrayList<PLListAllDTO> selectAllScore() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAllDTO> placeList = mapper.selectAllScore();
		
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
	public ArrayList<PLListAllDTO> selectAllCategory() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAllDTO> placeList = mapper.selectAllCategory();
		
		session.close();
		
		return placeList;
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

	/**
	  * @Method Name : renamePL
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param placDTO
	  */
	public void renamePL(PLListAllDTO placDTO) {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		int result = mapper.renamePL(placDTO);
		
		if(result > 0) {
			System.out.println("수정 성공!");
			session.commit();
		}else {
			System.out.println("수정 실패!");
			session.rollback();
		}
	}

	public boolean addReserve(PLReservationDTO re) {
		SqlSession session = getSession();
		
		mapper = session.getMapper(PLDAO.class);
		int result = mapper.addReserve(re);
	
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
	public boolean saveMyList(PLListAllDTO myList) {
		
		SqlSession session = getSession();
		
		mapper = session.getMapper(PLDAO.class);
		int result = mapper.saveMyList(myList);
	
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
	public boolean deleteMyList(int plNo) {
		SqlSession session = getSession();
		
		mapper = session.getMapper(PLDAO.class);
		int result = mapper.deleteMyList(plNo);
	
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result > 0? true: false;
	}
}
