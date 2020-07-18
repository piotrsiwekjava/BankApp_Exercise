-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: ba
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `actab`
--

DROP TABLE IF EXISTS `actab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actab` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  `LastName` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  `LoginName` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  `AccountNumber` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  `Funds` double DEFAULT NULL,
  `Country` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  `Address` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  `Phone` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  `Gender` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  `Password` varchar(45) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actab`
--

LOCK TABLES `actab` WRITE;
/*!40000 ALTER TABLE `actab` DISABLE KEYS */;
INSERT INTO `actab` VALUES (1,'Peter','Gryfin','PGryfin126','14519001990148446996392264',415161,'Danmark','Wawa1234','1234','male','123451'),(2,'Piotr','Francicz','PFrancicz860','14069142300129008701396804',1241125,'Danmark','Frass 12','123333213','male','123451'),(5,'Anna','Dymna','ADymna996','14309494020807540227080493',122141,'Finland','Track 12,Grrfa12','5135511552152','famale','123451'),(11,'Jarosław','Gowin','JGowin183','14098352414653415691100477',100000,'Poland','Wiecki 12','12345511','male','123451'),(12,'Iza','Tak','ITak867','14876663415470154226091822',14125,'Poland','WawaLove','3211223','famale','123'),(16,'Ola','Moja','OMoja551','14528677341204443999906506',368.5,'France','frafas','12314215','famale','87654321'),(17,'Damian','Świerk','DSwierk194','14306070673069507761622831',0,'France','Drasnj 5,10','64613525151','male','87654321'),(18,'Damian','Świst','DSwist6','14728345030439099789815953',38,'Czechia','Namsdaf12,2442','441412412424','male','87654321');
/*!40000 ALTER TABLE `actab` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-16 15:14:12
