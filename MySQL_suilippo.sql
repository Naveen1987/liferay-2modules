/*
SQLyog Ultimate v8.55 
MySQL - 5.7.12-log : Database - liferaynew_1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `suiluppo_application` */

DROP TABLE IF EXISTS `suiluppo_application`;

CREATE TABLE `suiluppo_application` (
  `applicat_id` bigint(20) NOT NULL,
  `applicat_name` varchar(700) DEFAULT NULL,
  `applicat_email` varchar(700) DEFAULT NULL,
  `applicat_phone` varchar(100) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`applicat_id`),
  KEY `FK_suiluppo_application` (`course_id`),
  CONSTRAINT `FK_suiluppo_application` FOREIGN KEY (`course_id`) REFERENCES `suiluppo_course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suiluppo_application` */

/*Table structure for table `suiluppo_course` */

DROP TABLE IF EXISTS `suiluppo_course`;

CREATE TABLE `suiluppo_course` (
  `course_id` bigint(20) NOT NULL,
  `Docente` varchar(500) DEFAULT NULL,
  `Evento_Progetto` varchar(500) DEFAULT NULL,
  `Titolo` varchar(500) DEFAULT NULL,
  `Descrizione` longtext,
  `Figure_Professionali_Coinvolte` varchar(500) DEFAULT NULL,
  `Data_Inizio` varchar(200) DEFAULT NULL,
  `Data_Fine` varchar(200) DEFAULT NULL,
  `Tot_Ore` varchar(200) DEFAULT NULL,
  `Nr_Edizione` varchar(500) DEFAULT NULL,
  `Sede` varchar(500) DEFAULT NULL,
  `Abstract` varchar(500) DEFAULT NULL,
  `Dispensa_corso` varchar(500) DEFAULT NULL,
  `Ammessi_al_corso` bigint(20) DEFAULT NULL,
  `Scadenza_Iscrizioni` varchar(200) DEFAULT NULL,
  `Visibile` varchar(200) DEFAULT NULL,
  `Bloccato` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suiluppo_course` */

/*Table structure for table `suiluppo_equip_allocation` */

DROP TABLE IF EXISTS `suiluppo_equip_allocation`;

CREATE TABLE `suiluppo_equip_allocation` (
  `equip_allocat_id` bigint(20) NOT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `equip_id` bigint(20) DEFAULT NULL,
  `equip_allocat_quantity` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`equip_allocat_id`),
  KEY `FK_suiluppo_equip_allocation` (`course_id`),
  KEY `FK_suiluppo_equip_allocation_` (`equip_id`),
  CONSTRAINT `FK_suiluppo_equip_allocation` FOREIGN KEY (`course_id`) REFERENCES `suiluppo_course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_suiluppo_equip_allocation_` FOREIGN KEY (`equip_id`) REFERENCES `suiluppo_equipment` (`equip_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suiluppo_equip_allocation` */

/*Table structure for table `suiluppo_equipment` */

DROP TABLE IF EXISTS `suiluppo_equipment`;

CREATE TABLE `suiluppo_equipment` (
  `equip_id` bigint(20) NOT NULL,
  `equip_name` varchar(500) DEFAULT NULL,
  `equip_quanity` bigint(20) DEFAULT NULL,
  `equip_description` text,
  PRIMARY KEY (`equip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suiluppo_equipment` */

/*Table structure for table `suiluppo_room` */

DROP TABLE IF EXISTS `suiluppo_room`;

CREATE TABLE `suiluppo_room` (
  `roomID` bigint(20) NOT NULL,
  `room_name` varchar(400) DEFAULT NULL,
  `room_description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suiluppo_room` */

/*Table structure for table `suiluppo_room_allocation` */

DROP TABLE IF EXISTS `suiluppo_room_allocation`;

CREATE TABLE `suiluppo_room_allocation` (
  `room_allocat_id` bigint(20) NOT NULL,
  `roomID` bigint(20) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `room_allocat_date` varchar(200) DEFAULT NULL,
  `room_allocat_duration` bigint(20) DEFAULT NULL,
  `room_allocat_start` varchar(200) DEFAULT NULL,
  `room_allocat_end` varchar(200) DEFAULT NULL,
  `room_allocat_status` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`room_allocat_id`),
  KEY `FK_suiluppo_room_allocation` (`room_id`),
  KEY `FK_suiluppo_room_allocation_` (`course_id`),
  CONSTRAINT `FK_suiluppo_room_allocation` FOREIGN KEY (`roomID`) REFERENCES `suiluppo_room` (`roomID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_suiluppo_room_allocation_` FOREIGN KEY (`course_id`) REFERENCES `suiluppo_course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suiluppo_room_allocation` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
