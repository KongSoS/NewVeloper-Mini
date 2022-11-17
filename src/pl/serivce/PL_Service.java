/**
  * 
  */
package pl.serivce;


import static common.PL_Template.getSession;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SearchUserStandard;
import pl.model.dao.PL_DAO;
import pl.model.dto.PL_UserDTO;
import pl.model.dto.PL_CategoryDTO;
import pl.model.dto.PL_ListAndReserveDTO;
import pl.model.dto.PL_ListAllDTO;
import pl.model.dto.PL_ReservationDTO;

/**
  * @FileName : PLService.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 : service 클래스
  */
public class PL_Service {
	  
	private PL_DAO mapper;
	/**
	  * @Method Name : myPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 내 장소 전체를 보여주는 메소드
	  * @return
	  */
	public ArrayList<PL_ListAllDTO> myPlaceList() {
		SqlSession session = getSession();
		mapper = session.getMapper(PL_DAO.class);
		ArrayList<PL_ListAllDTO> placeList = mapper.selectAllPlace();
		
		session.close();
		return placeList;
	}
	
	/**
	  * @Method Name : addPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 새로운 장소를 등록할 sql문에 접근하는 메소드
	  * @return
	  */
	public void addPlaceList(PL_ListAllDTO place) {
		SqlSession session = getSession();
		mapper = session.getMapper(PL_DAO.class);
		System.out.println("service의 dto : " + place);
		int result = mapper.insertPlace(place);
		
		if(result > 0) {
			System.out.println("장소등록 성공!");
			session.commit();
		}else {
			System.out.println("장소등록 실패!");
			session.rollback();			
		}
		session.close();
	}
	
	/**
	  * @Method Name : updateMyList
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param placDTO
	  */
	public void updateMyList(PL_ListAllDTO place) {
		SqlSession session = getSession();
		mapper = session.getMapper(PL_DAO.class);
		int result = mapper.updateMyList(place);
		
		if(result > 0) {
			System.out.println("수정 성공!");
			session.commit();
		}else {
			System.out.println("수정 실패!");
			session.rollback();
		}
	}

	/**
	  * @Method Name : reserveMine
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : Yuri
	  * @변경이력 : 
	  * @Method 설명 : 내 예약 리스트를 보여주는 메소드
	  * @return
	  */

	public List<PL_ListAndReserveDTO> reserveMine() {
		
		
		SqlSession session = getSession();
		
		mapper = session.getMapper(PL_DAO.class);
		
		List<PL_ListAndReserveDTO> reserveList = mapper.reserveMine();
		
		session.close();
		
		return reserveList;
}


	public void reserveInfo(PL_ListAndReserveDTO reserve) {
		SqlSession session = getSession();
	
		mapper = session.getMapper(PL_DAO.class);
		mapper.reserveInfo(reserve);
	
		session.close();
	
		
	}
//public MenuDTO selectMenuByCode(int code) {
//		
//		SqlSession sqlSession = getSqlSession();
//		
//		MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
//		MenuDTO menu = menuMapper.selectMenuByCode(code);
//		
//		sqlSession.close();
//		
//		return menu;
//	}

	public boolean editReserve(PL_ReservationDTO rd2) {
		SqlSession session = getSession();
	
		mapper = session.getMapper(PL_DAO.class);
		int result = mapper.editReserve(rd2);
	
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
	
		mapper = session.getMapper(PL_DAO.class);
		int result = mapper.cancelReserve(num);
	
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result > 0? true: false;
	}
	
	public boolean addReserve(PL_ReservationDTO re) {
		SqlSession session = getSession();
		
		mapper = session.getMapper(PL_DAO.class);
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
	 * @FileName Name : selectAllName
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소의 리스트를 이름으로 정렬
	 */
	public ArrayList<PL_ListAllDTO> selectAllName() {
		SqlSession session = getSession();
		mapper = session.getMapper(PL_DAO.class);
		
		ArrayList<PL_ListAllDTO> placeList = mapper.selectAllName();
		
		session.close();
		
		return placeList;
	}
	
	
	/**
	 * @FileName Name : selectAllAddress
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소의 리스트를 주소로 정렬
	 */
	public ArrayList<PL_ListAllDTO> selectAllAddress() {
		SqlSession session = getSession();
		mapper = session.getMapper(PL_DAO.class);
		
		ArrayList<PL_ListAllDTO> placeList = mapper.selectAllAddress();
		
		session.close();
		
		return placeList;
	}

	/**
	 * @FileName Name : selectAllScore
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소의 리스트를 별점으로 정렬
	 */
	public ArrayList<PL_ListAllDTO> selectAllScore() {
		SqlSession session = getSession();
		mapper = session.getMapper(PL_DAO.class);
		
		ArrayList<PL_ListAllDTO> placeList = mapper.selectAllScore();
		
		session.close();
		
		return placeList;
	}

	/**
	 * @FileName Name : selectAllCategory
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소의 리스트를 카테고리순으로 정렬
	 */
	public ArrayList<PL_ListAllDTO> selectAllCategory() {
		SqlSession session = getSession();
		mapper = session.getMapper(PL_DAO.class);
		
		ArrayList<PL_ListAllDTO> placeList = mapper.selectAllCategory();
		
		session.close();
		
		return placeList;
	}
	
	/**
	 * @FileName Name : saveMyList
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소의 리스트를 내 장소의 리스트로 저장하는 메소드
	 */
	public boolean saveMyList(PL_ListAllDTO myList) {
		
		SqlSession session = getSession();
		
		mapper = session.getMapper(PL_DAO.class);
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
	 * @FileName Name : deleteMyList
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 내 장소에 있는 리스트를 삭제 하는 메소드
	 */
	public boolean deleteMyList(int plNo) {
		SqlSession session = getSession();
		
		mapper = session.getMapper(PL_DAO.class);
		int result = mapper.deleteMyList(plNo);
	
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result > 0? true: false;
	}
	
	
	/**
	 * @Method Name : userIdOverlapCheck
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 입력받은 아이디를 매퍼에 전달, 결과 값을 반환
	 */
	public PL_UserDTO userIdOverlapCheck(String userId) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PL_DAO.class);
		PL_UserDTO check = mapper.userIdOverlapCheck(userId);
		
		sqlSession.close();
		
		return check;
	}
	
	/**
	 * @Method Name : userPwdOverlapCheck
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 입력받은 비밀번호를 매퍼에 전달, 결과 값을 반환
	 */
	public PL_UserDTO userPwdOverlapCheck(String userPwd) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PL_DAO.class);
		PL_UserDTO check = mapper.userPwdOverlapCheck(userPwd);
		
		sqlSession.close();
		
		return check;
	}

	/**
	 * @Method Name : registUser
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 입력받은 회원 정보를 매퍼에 전달하고 반환값의 결과에 따라 트랜젝션 처리
	 */
	public boolean registUser(PL_UserDTO user) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PL_DAO.class);
		int result = mapper.registUser(user);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}

	/**
	 * @Method Name : selectUserList
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 처리된 결과 값을 반환
	 */
	public List<PL_UserDTO> selectUserList() {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PL_DAO.class);
		
		List<PL_UserDTO> menuList = mapper.selectUserList();
		
		sqlSession.close();
		
		return menuList;
	}

	/**
	 * @Method Name : selectUserOne
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 입력받은 기준 검색어를 전달, 처리된 결과 값을 반환
	 */
	public PL_UserDTO selectUserOne(SearchUserStandard searchUserStandard) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PL_DAO.class);
		
		PL_UserDTO user = mapper.selectUserOne(searchUserStandard);
		
		sqlSession.close();
		
		return user;
	}
	
	/**
	 * @Method Name : updateUserinfo
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 전달받은 값을 매퍼에 전달, 결과값에 따라 트랜젝션 처리 및 반환
	 */
	public boolean updateUserInfo(PL_UserDTO user) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PL_DAO.class);
		int result = mapper.updateUserinfo(user);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}
	
	/**
	 * @Method Name : withdrawalUserOne
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 전달받은 값을 매퍼에 전달, 결과값에 따라 트랜젝션 처리 및 반환
	 */
	public boolean withdrawalUserOne(String userId) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PL_DAO.class);
		int result = mapper.withdrawalUserOne(userId);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}
	
	/**
	 * @Method Name : deleteUserOne
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 전달받은 값을 매퍼에 전달, 결과값에 따라 트랜젝션 처리 및 반환
	 */
	public boolean deleteUserOne(int userNo) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PL_DAO.class);
		int result = mapper.deleteUserOne(userNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result > 0? true: false;
	}
	
	/**
	 * @Method Name : selectMyInfo
	 * @작성일 : 2022. 11. 16.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 전달받은 아이디 값을 매퍼에 연결하여 전달, 처리된 결과 값을 반환
	 */
	public PL_UserDTO selectMyInfo(String userId) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PL_DAO.class);
		
		PL_UserDTO user = mapper.selectMyInfo(userId);
		
		sqlSession.close();
		
		return user;
	}
	
	public boolean deletePlaceList(int plNo) {
		SqlSession session = getSession();
		
		mapper = session.getMapper(PL_DAO.class);
		int result = mapper.deletePlaceList(plNo);
	
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result > 0? true: false;
	}

	/**
	 * @FileName : PL_Service.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 17.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	public void updatePlaceList(PL_ListAllDTO place) {
		SqlSession session = getSession();
		mapper = session.getMapper(PL_DAO.class);
		int result = mapper.updatePlaceList(place);
		
		if(result > 0) {
			System.out.println("수정 성공!");
			session.commit();
		}else {
			System.out.println("수정 실패!");
			session.rollback();
		}
		
	}
	
}
