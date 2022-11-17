/**
  * 
  */
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
	  * @Method Name : selectAllPlace
	  * @작성일 : 2022. 11. 14.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 내 장소의 전체 리스트 출력
	  * @return
	  */
	ArrayList<PL_ListAllDTO> selectAllPlace();

	/**
	 * @Method Name : selectAllName
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소 이름순으로 정렬된 리스트 출력
	 */
	ArrayList<PL_ListAllDTO> selectAllName();

	/**
	 * @Method Name : selectAllAddress
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소 주소순으로 정렬된 리스트 출력
	 */
	ArrayList<PL_ListAllDTO> selectAllAddress();

	/**
	 * @Method Name : selectAllScore
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소 별점순으로 정렬된 리스트 출력
	 */
	ArrayList<PL_ListAllDTO> selectAllScore();

	/**
	 * @Method Name : selectAllCategory
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천 장소 카테고리순으로 정렬된 리스트 출력
	 */
	ArrayList<PL_ListAllDTO> selectAllCategory();

	

	List<PL_ListAndReserveDTO> reserveMine();

	PL_ListAndReserveDTO reserveInfo(PL_ListAndReserveDTO reserve);

	int editReserve(PL_ReservationDTO rd2);

	int cancelReserve(int num);

	int addReserve(PL_ReservationDTO re);
	/**
	  * @Method Name : insertPlace
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @프로그램 설명 : 내 장소에 새로운 장소 등록
	  * @return
	  */
	int insertPlace(PL_ListAllDTO dto);

	/**
	  * @Method Name : updateMyList
	  * @작성일 : 2022. 11. 15.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @프로그램 설명 : 내 장소에 저장된 리스트의 내용을 수정
	  */
	int updateMyList(PL_ListAllDTO placDTO);
	/**
	 * @Method Name : deleteMyList
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 추천장소리스트에서 내 장소리스트로 장소 정보를 저장
	 */
	int saveMyList(PL_ListAllDTO myList);

	/**
	 * @Method Name : deleteMyList
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 15.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 내 장소에 저장된 리스트의 내용을 삭제
	 */
	int deleteMyList(int plNo);
	
	
	/*아이디 중복 확인*/
	PL_UserDTO userIdOverlapCheck(String userId);
	
	/*비밀번호 중복 확인*/
	PL_UserDTO userPwdOverlapCheck(String userPwd);

	/*회원가입*/
	int registUser(PL_UserDTO user);

	/*회원 전체 조회*/
	List<PL_UserDTO> selectUserList();
	
	/*회원 선택 조회*/
	PL_UserDTO selectUserOne(SearchUserStandard searchUserStandard);

	/*회원 정보 수정*/
	int updateUserinfo(PL_UserDTO user);

	/*회원 탈퇴*/
	int withdrawalUserOne(String userId);
	
	/*회원 삭제*/
	int deleteUserOne(int userId);

	/*사용자 정보 확인*/
	PL_UserDTO selectMyInfo(String userId);
	
	/**
	 * @FileName : PL_DAO.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 17.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	int deletePlaceList(int plNo);

	/**
	 * @FileName : PL_DAO.java
	 * @Project : NewVeloper_mini
	 * @Date : 2022. 11. 17.
	 * @작성자 : jihee
	 * @변경이력 :
	 * @프로그램 설명 : 
	 */
	int updatePlaceList(PL_ListAllDTO place);
	
	
}
