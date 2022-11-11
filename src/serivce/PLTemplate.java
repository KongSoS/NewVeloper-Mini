/**
  * 
  */
package serivce;



import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
  * @FileName : PLTemplate.java
  * @Project : NewVeloper_mini
  * @Date : 2022. 11. 11. 
  * @작성자 : heojaehong
  * @변경이력 :
  * @프로그램 설명 : DB 마이바티스 연동 클래스
  */
public class PLTemplate {
	
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:log4jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "NEWVELOPER";
	private static String PASSWORD = "NEWVELOPER";
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSession() {
		
		if(sqlSessionFactory == null) {
			Environment environment = 
					new Environment("NVPL", new JdbcTransactionFactory(), new PooledDataSource(DRIVER, URL, USER, PASSWORD));
			// 환경설정 정보를 가지고 마이바티스 객체 생성
			Configuration configuration = new Configuration(environment);
			// 설정파일에 Mapper 등록
			configuration.addMapper(PLMapper.class);
			
			sqlSessionFactory =  new SqlSessionFactoryBuilder().build(configuration);
		}
		// 인스턴스 객체를 DML로 수행하여 auto commit를 false로 지정
		return sqlSessionFactory.openSession(false);
		
	}
}
