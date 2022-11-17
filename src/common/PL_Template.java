package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
  * @FileName : PLTemplate.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong 
  * @프로그램 설명 : DB 마이바티스 연동 클래스
  */
public class PL_Template {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSession() {
		
		if(sqlSessionFactory == null) {
			String resource = "PL-config.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sqlSessionFactory.openSession(false);
		
	}
}
