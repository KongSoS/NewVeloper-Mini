--VIEW (뷰)
--SELECT 쿼리문을 저장한 객체이다
--실질적인 데이터를 저장하고 있지않음
--테이블을 사용하는 것과 동일하게 사용할수있다.
--매번 자주 사용하는 쿼리문을 정의 해 두고 싶을때 뷰를 생성
--VIEW 를 한번 만들어두고 마치 테이블처럼 사용한다고 생각!
--CREATE [OR REPLACE] VIEW 뷰이름 AS 서브쿼리 
--[OR REPLACE]: 뷰 생성시 기존에 중복된 뷰가 있다면 해당뷰를 변경하고 기존에 중복된 뷰가 없다면 새로 뷰를 생성


GRANT CREATE VIEW TO EMPLOYEE;

CREATE OR REPLACE VIEW V_EMP
		(사번, 이름, 부서)
		AS
		SELECT EMP_ID, EMP_NAME, DEPT_CODE
    FROM EMPLOYEE;
   
SELECT * FROM V_EMP;
DROP VIEW V_EMP;

-- 사번 , 이름 , 직급명, 부서명 , 근무지역을 조회하고, 
--그결과를 V_RESULT_EMP 라는 뷰를 생성해서 저장하세요

CREATE OR REPLACE VIEW V_RESULT_EMP
	(사번, 이름, 직급명, 부서명, 근무지역)
	AS 
	SELECT 
		e.EMP_ID, 
		e.EMP_NAME, 
		j.JOB_NAME, 
		d.DEPT_TITLE, 
		l.LOCAL_NAME 
	FROM EMPLOYEE e
	JOIN JOB j ON e.JOB_CODE = j.JOB_CODE 
	JOIN DEPARTMENT d ON e.DEPT_CODE = d.DEPT_ID 
	JOIN LOCATION l ON d.LOCATION_ID = l.LOCAL_CODE ;
	

SELECT * 
FROM V_RESULT_EMP;


SELECT * FROM USER_VIEWS;
COMMIT;

SELECT * 
FROM V_RESULT_EMP  
WHERE 사번 = '205';

UPDATE EMPLOYEE 
SET EMP_NAME = '정중앙'
WHERE EMP_ID = '205';

ROLLBACK;

DROP VIEW V_RESULT_EMP ;

-- 연산결과도 view에 반영이 될 수 있다.
CREATE OR REPLACE VIEW V_EMP_JOB
(사번, 이름 , 직급명, 성별, 근무년수)
AS
SELECT     
	A.EMP_ID    
, A.EMP_NAME    
, B.JOB_NAME    
, DECODE(SUBSTR(A.EMP_NO, 8,1),1,'남', '여'),   
EXTRACT(YEAR FROM SYSDATE)- EXTRACT(YEAR FROM A.HIRE_DATE)
FROM EMPLOYEE A    
LEFT JOIN JOB B ON A.JOB_CODE = B.JOB_CODE ;

CREATE OR REPLACE VIEW V_JOB
AS
SELECT
	JOB_CODE,
	JOB_NAME
FROM JOB;

SELECT * FROM V_EMP_JOB ;
SELECT * FROM V_JOB ;


INSERT INTO V_JOB
 VALUES ('j8', '인턴') 

 UPDATE V_JOB 
 SET JOB_NAME = '알바'
 WHERE JOB_CODE = 'j8';

-- DML 명령어로 조작이 불가능한 경우
-- 1. 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
-- 2. 뷰에 포함되지 않은 컬럼 중에,
--    베이스가 되는 테이블 컬럼이 NOT NULL 제약조건이 지정된 경우
-- 3. 산술표현식으로 정의된 경우
-- 4. JOIN을 이용해 여러 테이블을 연결한 경우
-- 5. DISTINCT 포함한 경우
-- 6. 그룹함수나 GROUP BY 절을 포함한 경우

 

DELETE FROM V_JOB WHERE job_code = 'j8';