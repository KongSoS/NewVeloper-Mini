/**
  * 
  */
package pl.serivce;


import static common.PLTemplate.getSession;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SearchUserStandard;
import pl.model.dao.PLDAO;
import pl.model.dto.PLUserDTO;
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

	/**
	  * @Method Name : reserveMine
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : Yuri
	  * @변경이력 : 
	  * @Method 설명 : 내 예약 리스트를 보여주는 메소드
	  * @return
	  */

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
	 * @FileName Name : selectAllName
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소의 리스트를 이름으로 정렬
	 */
	public ArrayList<PLListAllDTO> selectAllName() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAllDTO> placeList = mapper.selectAllName();
		
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
	public ArrayList<PLListAllDTO> selectAllAddress() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAllDTO> placeList = mapper.selectAllAddress();
		
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
	public ArrayList<PLListAllDTO> selectAllScore() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAllDTO> placeList = mapper.selectAllScore();
		
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
	public ArrayList<PLListAllDTO> selectAllCategory() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLDAO.class);
		
		ArrayList<PLListAllDTO> placeList = mapper.selectAllCategory();
		
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
	 * @FileName Name : deleteMyList
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 내 장소에 있는 리스트를 삭제 하는 메소드
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
	
	
	/**
	 * @Method Name : userIdOverlapCheck
	 * @작성일 : 2022. 11. 15.
	 * @작성자 : 성식
	 * @변경이력 :
	 * @Method 설명 : 입력받은 아이디를 매퍼에 전달, 결과 값을 반환
	 */
	public PLUserDTO userIdOverlapCheck(String userId) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PLDAO.class);
		PLUserDTO check = mapper.userIdOverlapCheck(userId);
		
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
	public PLUserDTO userPwdOverlapCheck(String userPwd) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PLDAO.class);
		PLUserDTO check = mapper.userPwdOverlapCheck(userPwd);
		
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
	public boolean registUser(PLUserDTO user) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PLDAO.class);
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
	public List<PLUserDTO> selectUserList() {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PLDAO.class);
		
		List<PLUserDTO> menuList = mapper.selectUserList();
		
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
	public PLUserDTO selectUserOne(SearchUserStandard searchUserStandard) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PLDAO.class);
		
		PLUserDTO user = mapper.selectUserOne(searchUserStandard);
		
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
	public boolean updateUserInfo(PLUserDTO user) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PLDAO.class);
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
		
		mapper = sqlSession.getMapper(PLDAO.class);
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
		
		mapper = sqlSession.getMapper(PLDAO.class);
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
	public PLUserDTO selectMyInfo(String userId) {
		SqlSession sqlSession = getSession();
		
		mapper = sqlSession.getMapper(PLDAO.class);
		
		PLUserDTO user = mapper.selectMyInfo(userId);
		
		sqlSession.close();
		
		return user;
	}
	
}
