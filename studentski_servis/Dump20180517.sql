-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: studentska_sluzba
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `amfiteatar`
--

DROP TABLE IF EXISTS `amfiteatar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `amfiteatar` (
  `amfiteatar_id` int(11) NOT NULL,
  `naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`amfiteatar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amfiteatar`
--

LOCK TABLES `amfiteatar` WRITE;
/*!40000 ALTER TABLE `amfiteatar` DISABLE KEYS */;
/*!40000 ALTER TABLE `amfiteatar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fakultet`
--

DROP TABLE IF EXISTS `fakultet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fakultet` (
  `fakultet_id` int(11) NOT NULL,
  `naziv` varchar(45) DEFAULT NULL,
  `skraceniza` varchar(3) DEFAULT NULL,
  `student_index` int(11) NOT NULL,
  `mesto_mesto_id` int(11) NOT NULL,
  PRIMARY KEY (`fakultet_id`),
  KEY `fk_fakultet_mesto1_idx` (`mesto_mesto_id`),
  CONSTRAINT `fk_fakultet_mesto1` FOREIGN KEY (`mesto_mesto_id`) REFERENCES `mesto` (`mesto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fakultet`
--

LOCK TABLES `fakultet` WRITE;
/*!40000 ALTER TABLE `fakultet` DISABLE KEYS */;
/*!40000 ALTER TABLE `fakultet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ispit`
--

DROP TABLE IF EXISTS `ispit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ispit` (
  `ispit_id` int(11) NOT NULL,
  `naziv_ispita` varchar(150) DEFAULT NULL,
  `vreme_polaganja` datetime DEFAULT NULL,
  `student_index` int(11) NOT NULL,
  `profesor_profesor_id` int(11) NOT NULL,
  `amfiteatar_amfiteatar_id` int(11) NOT NULL,
  `predmet_predmet_id` int(11) NOT NULL,
  PRIMARY KEY (`ispit_id`),
  KEY `fk_ispit_student1_idx` (`student_index`),
  KEY `fk_ispit_profesor1_idx` (`profesor_profesor_id`),
  KEY `fk_ispit_amfiteatar1_idx` (`amfiteatar_amfiteatar_id`),
  KEY `fk_ispit_predmet1_idx` (`predmet_predmet_id`),
  CONSTRAINT `fk_ispit_amfiteatar1` FOREIGN KEY (`amfiteatar_amfiteatar_id`) REFERENCES `amfiteatar` (`amfiteatar_id`),
  CONSTRAINT `fk_ispit_predmet1` FOREIGN KEY (`predmet_predmet_id`) REFERENCES `predmet` (`predmet_id`),
  CONSTRAINT `fk_ispit_profesor1` FOREIGN KEY (`profesor_profesor_id`) REFERENCES `profesor` (`profesor_id`),
  CONSTRAINT `fk_ispit_student1` FOREIGN KEY (`student_index`) REFERENCES `student` (`index`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ispit`
--

LOCK TABLES `ispit` WRITE;
/*!40000 ALTER TABLE `ispit` DISABLE KEYS */;
/*!40000 ALTER TABLE `ispit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesto`
--

DROP TABLE IF EXISTS `mesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mesto` (
  `mesto_id` int(11) NOT NULL,
  `naziv` varchar(45) DEFAULT NULL,
  `postanski_broj` int(11) DEFAULT NULL,
  PRIMARY KEY (`mesto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesto`
--

LOCK TABLES `mesto` WRITE;
/*!40000 ALTER TABLE `mesto` DISABLE KEYS */;
/*!40000 ALTER TABLE `mesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predmet`
--

DROP TABLE IF EXISTS `predmet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `predmet` (
  `predmet_id` int(11) NOT NULL,
  `naziv` varchar(45) DEFAULT NULL,
  `ESPB` int(11) DEFAULT NULL,
  `student_index` int(11) NOT NULL,
  PRIMARY KEY (`predmet_id`),
  KEY `fk_predmet_student_idx` (`student_index`),
  CONSTRAINT `fk_predmet_student` FOREIGN KEY (`student_index`) REFERENCES `student` (`index`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predmet`
--

LOCK TABLES `predmet` WRITE;
/*!40000 ALTER TABLE `predmet` DISABLE KEYS */;
/*!40000 ALTER TABLE `predmet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profesor` (
  `profesor_id` int(11) NOT NULL,
  `ime` varchar(45) DEFAULT NULL,
  `prezime` varchar(45) DEFAULT NULL,
  `pol` varchar(45) DEFAULT NULL,
  `godina_rodjenja` date DEFAULT NULL,
  `seminar` varchar(45) DEFAULT NULL,
  `fakultet_fakultet_id` int(11) NOT NULL,
  PRIMARY KEY (`profesor_id`),
  KEY `fk_profesor_fakultet1_idx` (`fakultet_fakultet_id`),
  CONSTRAINT `fk_profesor_fakultet1` FOREIGN KEY (`fakultet_fakultet_id`) REFERENCES `fakultet` (`fakultet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `index` int(11) NOT NULL,
  `ime` varchar(45) DEFAULT NULL,
  `prezime` varchar(45) DEFAULT NULL,
  `pol` varchar(45) DEFAULT NULL,
  `godina_rodjenja` date DEFAULT NULL,
  `sport` varchar(45) DEFAULT NULL,
  `hobi` varchar(45) DEFAULT NULL,
  `fakultet_fakultet_id` int(11) NOT NULL,
  PRIMARY KEY (`index`),
  KEY `fk_student_fakultet1_idx` (`fakultet_fakultet_id`),
  CONSTRAINT `fk_student_fakultet1` FOREIGN KEY (`fakultet_fakultet_id`) REFERENCES `fakultet` (`fakultet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `username`
--

DROP TABLE IF EXISTS `username`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `username` (
  `username_id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `student_index` int(11) NOT NULL,
  `profesor_profesor_id` int(11) NOT NULL,
  PRIMARY KEY (`username_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_username_student1_idx` (`student_index`),
  KEY `fk_username_profesor1_idx` (`profesor_profesor_id`),
  CONSTRAINT `fk_username_profesor1` FOREIGN KEY (`profesor_profesor_id`) REFERENCES `profesor` (`profesor_id`),
  CONSTRAINT `fk_username_student1` FOREIGN KEY (`student_index`) REFERENCES `student` (`index`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `username`
--

LOCK TABLES `username` WRITE;
/*!40000 ALTER TABLE `username` DISABLE KEYS */;
/*!40000 ALTER TABLE `username` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-17 15:18:54
