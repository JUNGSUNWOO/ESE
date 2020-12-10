-- Table structure for table `login`
-- 로그인 테이블 : key값 외래키 <- speed 테이블의 speedkey
​
CREATE TABLE login (
    id varchar(20) not null,
    pw varchar(20) not null,
    key_ int(10) not null AUTO_INCREMENT,
    primary key(key_)
);
​
​
-- Dumping data for table `login`
-- User 3명 가정
​
INSERT INTO login(id, pw) VALUES ('JaeHyun', '1111');
INSERT INTO login(id, pw) VALUES ('SunWoo', '2222');
INSERT INTO login(id, pw) VALUES ('YoungJoon', '3333');
​
​
-- Table structure for table `100mspeed`
-- 거리마다 나누는 게 좋을 듯
-- 평균속력은 거리/시간 으로 계산해서 넣어야 됨
​
CREATE TABLE 100mspeed (
    1maxspeed float(10) not null,
    1lowspeed float(10) not null,
    1avespeed float(10) not null,
    1time int(10) not null,
    1speedkey int(10) not null,
    primary key(1speedkey)
);
​
​
-- Dumping data for table `100mspeed`
​
INSERT INTO 100mspeed(1maxspeed, 1lowspeed, 1avespeed, 1time, 1speedkey) VALUES (12.5, 2.3, 7.2, 000052, 1);
INSERT INTO 100mspeed(1maxspeed, 1lowspeed, 1avespeed, 1time, 1speedkey) VALUES (13.2, 4.5, 8.4, 000058, 2);
INSERT INTO 100mspeed(1maxspeed, 1lowspeed, 1avespeed, 1time, 1speedkey) VALUES (10.0, 3.4, 3.9, 000050, 3);
​
SELECT 100mspeed.1maxspeed, 100mspeed.1lowspeed, 100mspeed.1avespeed, 100mspeed.1time,login.id
FROM 100mspeed
JOIN login
ON login.key_ = 100mspeed.1speedkey;
​
-- Table structure for table `1000mspeed`
​
CREATE TABLE 1000mspeed (
    10maxspeed float(10) not null,
    10lowspeed float(10) not null,
    10avespeed float(10) not null,
    10time int(10) not null,
    10speedkey int(10) not null,
    primary key(10speedkey)
);
​
​
-- Dumping data for table `1000mspeed`
​
INSERT INTO 1000mspeed(10maxspeed, 10lowspeed, 10avespeed, 10time, 10speedkey) VALUES (12.0, 2.0, 7.0, 000752, 1);
INSERT INTO 1000mspeed(10maxspeed, 10lowspeed, 10avespeed, 10time, 10speedkey) VALUES (13.0, 4.0, 8.0, 000558, 2);
INSERT INTO 1000mspeed(10maxspeed, 10lowspeed, 10avespeed, 10time, 10speedkey) VALUES (10.0, 3.0, 4.0, 000950, 3);
​
​
-- Table structure for table `3000mspeed`
​
CREATE TABLE 3000mspeed (
    30maxspeed float(10) not null,
    30lowspeed float(10) not null,
    30avespeed float(10) not null,
    30time int(10) not null,
    30speedkey int(10) not null,
    primary key(30speedkey)
);
​
​
-- Dumping data for table `3000mspeed`
​
INSERT INTO 3000mspeed(30maxspeed, 30lowspeed, 30avespeed, 30time, 30speedkey) VALUES (9.0, 1.0, 7.0, 001352, 1);
INSERT INTO 3000mspeed(30maxspeed, 30lowspeed, 30avespeed, 30time, 30speedkey) VALUES (7.0, 2.0, 3.0, 001158, 2);
INSERT INTO 3000mspeed(30maxspeed, 30lowspeed, 30avespeed, 30time, 30speedkey) VALUES (5.0, 3.0, 4.0, 001550, 3);
​
​
-- Table structure for table `realtime`
-- User 늘어날 때마다 nodeJS에서 create 구문으로 동적으로 생성해줘야 될 듯
-- 기본키 안필요할 것 같은데 고민 해봐바(고민하고 이건 지우고)
-- 일단 JaeHyun의 실시간 속도 테이블만 생성
​
CREATE TABLE JHreal (
    realspeed float(10) not null
);
​
​
-- Dumping data for table `realtime`
​
INSERT INTO JHreal(realspeed) VALUES (3.0);
INSERT INTO JHreal(realspeed) VALUES (5.0);
INSERT INTO JHreal(realspeed) VALUES (7.0);
INSERT INTO JHreal(realspeed) VALUES (6.0);
<<<<<<< HEAD
=======

CREATE TABLE information (
    run_date varchar(20) not null,
    distance float(10) not null,
    maxspeed float(10) not null,
    lowspeed float(10) not null,
    avespeed float(10) not null,
    id_key int(10) not null,
    primary key(id_key)
);

INSERT INTO information(run_date, distance, maxspeed, lowspeed, avespeed, id_key) VALUES("2020-12-11", 1000, 20.0,12.5,7.6, 1);
INSERT INTO information(run_date, distance, maxspeed, lowspeed, avespeed, id_key) VALUES("2020-12-10", 1200, 22.0,12.5,7.6, 2);
INSERT INTO information(run_date, distance, maxspeed, lowspeed, avespeed, id_key) VALUES("2020-12-09", 100, 25.0,12.5,7.6, 3);
>>>>>>> 3bde693268876fc9544f194dedeff2723cb6937d
