-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: shopping
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `userlogin`
--

DROP TABLE IF EXISTS `userlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userlogin` (
  `user_ID` varchar(30) NOT NULL,
  `user_name` text NOT NULL,
  `user_PASSWORD` varchar(30) NOT NULL,
  `user_mail` varchar(30) NOT NULL,
  PRIMARY KEY (`user_ID`),
  UNIQUE KEY `user_ID_UNIQUE` (`user_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogin`
--

LOCK TABLES `userlogin` WRITE;
/*!40000 ALTER TABLE `userlogin` DISABLE KEYS */;
INSERT INTO `userlogin` VALUES ('bgj585858','박과제','jaejaejae14','bgj585858@www.com'),('bockdong12','조복동','bockdodo5','bockdong12@www.com'),('chulsu3','김철수','chilachil2','su4444@www.com'),('duck10','장철덕','chulchul12','duck10@www.com'),('ghdrlfehd','홍길동','honghong1','honghong@www.com'),('hong64','홍옥돌','hogngn8','hong64@www.com'),('hoy3838','박호열','oyoyh10','hoy3838@www.com'),('jmp','박종민','123','jmpak@www.com'),('jmpak','박종민','1234','jmp@www.com'),('jmpak5','1234','12345','1234'),('jumal1818','주말사','joomalmal15','jumal1818@www.com'),('ksg404040','김세금','sgsgsggs13','ksg404040@www.com'),('mirae30','한미래','hanhanhan11','mirae30@www.com');
/*!40000 ALTER TABLE `userlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `상품예약`
--

DROP TABLE IF EXISTS `상품예약`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `상품예약` (
  ` ID` int NOT NULL,
  `상품명` varchar(45) NOT NULL,
  `reservation` int NOT NULL,
  PRIMARY KEY (`상품명`),
  UNIQUE KEY ` ID_UNIQUE` (` ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `상품예약`
--

LOCK TABLES `상품예약` WRITE;
/*!40000 ALTER TABLE `상품예약` DISABLE KEYS */;
INSERT INTO `상품예약` VALUES (9,'기모베기',0),(2,'단추니트',0),(3,'뒷트임패딩',0),(1,'레이스나시',0),(5,'밴딩 슬랙스',0),(4,'스웨트 셔츠',1),(8,'스웨트 팬츠',0),(7,'와이드 데님 팬츠',0),(6,'후드 스웨트 집업',0);
/*!40000 ALTER TABLE `상품예약` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `상품종합정보`
--

DROP TABLE IF EXISTS `상품종합정보`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `상품종합정보` (
  `ID` int NOT NULL,
  `상품명` varchar(45) NOT NULL,
  `사이즈` text,
  `가격` varchar(45) NOT NULL,
  `분류` text NOT NULL,
  `색상` text NOT NULL,
  PRIMARY KEY (`상품명`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `상품종합정보`
--

LOCK TABLES `상품종합정보` WRITE;
/*!40000 ALTER TABLE `상품종합정보` DISABLE KEYS */;
INSERT INTO `상품종합정보` VALUES (9,'기모베기','s','36,000','상의','카키'),(2,'단추니트',NULL,'27,000','니트','네이비'),(3,'뒷트임패딩','XL','96,000','패딩','아이보리'),(1,'레이스나시','','17,000','나시','먹색'),(5,'밴딩 슬랙스','L','32.000','하의','그레이'),(4,'스웨트 셔츠','L','21.000','상의','블랙'),(8,'스웨트 팬츠','M','26,000','하의','블랙'),(7,'와이드 데님 팬츠','L','40,000','청바지','청'),(6,'후드 스웨트 집업',NULL,'43,000','집업','베이지');
/*!40000 ALTER TABLE `상품종합정보` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `시간예약`
--

DROP TABLE IF EXISTS `시간예약`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `시간예약` (
  `1112` int NOT NULL,
  `1214` int NOT NULL,
  `1416` int NOT NULL,
  `1618` int NOT NULL,
  `1819` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `시간예약`
--

LOCK TABLES `시간예약` WRITE;
/*!40000 ALTER TABLE `시간예약` DISABLE KEYS */;
INSERT INTO `시간예약` VALUES (0,0,0,1,0),(0,1,0,0,0),(1,0,0,0,0),(0,0,3,0,0);
/*!40000 ALTER TABLE `시간예약` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-18 19:46:44
