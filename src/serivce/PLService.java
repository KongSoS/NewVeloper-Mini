/**
  * 
  */
package serivce;


import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import static serivce.PLTemplate.getSession;
import pl.model.dto.PLUserDTO;

/**
  * @FileName : PLService.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 :
  */
public class PLService {
	
	private PLMapper mapper;
	/**
	  * @Method Name : myPlaceList
	  * @작성일 : 2022. 11. 11.
	  * @작성자 : heojaehong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @return
	  */
	public ArrayList<PLUserDTO> myPlaceList() {
		SqlSession session = getSession();
		mapper = session.getMapper(PLMapper.class);
		ArrayList<PLUserDTO> Plist = mapper.selectAllPlace();
		return Plist;
	}

}
