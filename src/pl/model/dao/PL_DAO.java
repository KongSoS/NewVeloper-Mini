package pl.model.dao;

import java.util.ArrayList;
import java.util.List;

import common.SearchUserStandard;

import pl.model.dto.PL_UserDTO;
import pl.model.dto.PL_ListAndReserveDTO;
import pl.model.dto.PL_ListAllDTO;
import pl.model.dto.PL_ReservationDTO;

/**
  * @FileName : PlaceListDAO.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 :DB와 직접적으로 접근하며 SQL구문을 실행하는 클래스
  */
public interface PL_DAO {
  
	/**
	  * @Method Name : 리스트 출력
	  * @작성일 : 2022. 11. 14.
	  * @작성자 : jihee
	  */
	/*내 장소의 전체 리스트 출력*/
	ArrayList<PL_ListAllDTO> selectAllPlace();

	/*추천 장소 이름순으로 정렬된 리스트 출력*/
	ArrayList<PL_ListAllDTO> selectAllName();

	/*추천 장소 주소순으로 정렬된 리스트 출력*/
	ArrayList<PL_ListAllDTO> selectAllAddress();

	/*추천 장소 별점순으로 정렬된 리스트 출력*/
	ArrayList<PL_ListAllDTO> selectAllScore();

	/*추천 장소 카테고리순으로 정렬된 리스트 출력*/
	ArrayList<PL_ListAllDTO> selectAllCategory();
	
	/*관리자)추천 장소 삭제*/
	int deletePlaceList(int plNo);

	/*관리자)추천 장소 수정*/
	int updatePlaceList(PL_ListAllDTO place);
	
	/**
	  * @Method Name : 내 장소 등록, 수정, 삭제
	  * @작성일 : 2022. 11. 14.
	  * @작성자 : heojaehong
	  */
	/*내 장소에 새로운 장소 등록*/
	int insertPlace(PL_ListAllDTO dto);

	/*내 장소에 저장된 리스트의 내용을 수정 */
	int updateMyList(PL_ListAllDTO placDTO);
	
	/*추천장소리스트에서 내 장소리스트로 장소 정보를 저장*/
	int saveMyList(PL_ListAllDTO myList);

	/*내 장소에 저장된 리스트의 내용을 삭제 */
	int deleteMyList(int plNo);
	
	/**
	  * @Method Name :
	  * @작성일 : 2022. 11. 14.
	  * @작성자 : Yuri
	  */
	List<PL_ListAndReserveDTO> reserveMine();

	PL_ListAndReserveDTO reserveInfo(int num);

	int editReserve(PL_ReservationDTO re);

	int cancelReserve(int num);

	int addReserve(PL_ReservationDTO re);
	
	/**
	  * @Method Name : 관리자 및 사용자의 정보 조회, 수정
	  * @작성일 : 2022. 11. 16.
	  * @작성자 : siker
	  */
	/*아이디 중복 확인*/
	PL_UserDTO userIdOverlapCheck(String userId);
	
	/*비밀번호 중복 확인*/
	PL_UserDTO userPwdOverlapCheck(String userPwd);

	/*회원가입*/
	int registUser(PL_UserDTO user);

	/*사용자 정보 확인*/
	PL_UserDTO selectMyInfo(String userId);

	/*회원 정보 수정*/
	int updateUserinfo(PL_UserDTO user);

	/*회원 탈퇴*/
	int withdrawalUserOne(String userId);
	
	/*관리자)회원 삭제*/
	int deleteUserOne(int userId);

	/*관리자)회원 전체 조회*/
	List<PL_UserDTO> selectUserList();
	
	/*관리자)회원 선택 조회*/
	PL_UserDTO selectUserOne(SearchUserStandard searchUserStandard);
	
}
