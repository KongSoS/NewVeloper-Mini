/**
  * 
  */
package serivce;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import pl.model.dto.PLUserDTO;

/**
  * @FileName : PLMapper.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 :
  */
public interface PLMapper {

	/**
	  * @Method Name : selectAllPlace
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 : 내저장소에 있는 장소를 다 보여준다.
	  * @return
	  */
	@Select("SELECT NAME FROM NEWVELOPER")
	ArrayList<PLUserDTO> selectAllPlace();

}
