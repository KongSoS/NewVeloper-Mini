INSERT INTO MY_LIST VALUES(SEQ_MY_NO.NEXTVAL, '카츠오모이', '서울특별시 강동구', '02-222-7778', 5, 'C3', 'N');
INSERT INTO MY_LIST VALUES(SEQ_MY_NO.NEXTVAL, '서울족발', '서울특별시 구로구', '02-212-7668', 4, 'C1', 'Y');

DELETE my_list
WHERE my_name = '카츠오모이';

SELECT *
FROM MY_LIST ml;

UPDATE MY_LIST SET
MY_NAME = '입이가짬뽕' ,
MY_ADDRESS = '서초구' 
WHERE MY_NAME = '이비가짬뽕';

SELECT *
FROM MY_LIST ml 