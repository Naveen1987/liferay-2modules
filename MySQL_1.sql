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
/*Table structure for table `istruzioni_per_la_compilazione` */

DROP TABLE IF EXISTS `istruzioni_per_la_compilazione`;

CREATE TABLE `istruzioni_per_la_compilazione` (
  `Istruzioni_per_id` bigint(20) NOT NULL,
  `purpose` varchar(2000) DEFAULT NULL,
  `MainTitle` varchar(500) DEFAULT NULL,
  `Tilte` varchar(1000) DEFAULT NULL,
  `SubTitle` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`Istruzioni_per_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `istruzioni_per_la_compilazione` */

insert  into `istruzioni_per_la_compilazione`(`Istruzioni_per_id`,`purpose`,`MainTitle`,`Tilte`,`SubTitle`) values (1,'The purpose of home and hospital instruction is to provide instruction to a student with a temporary disability in the student’s home or in a hospital or other residential health facility, excluding state hospitals','Hospital Instruction Program','Purpose','Instructions');

/*Table structure for table `istruzioni_per_la_compilazione_child` */

DROP TABLE IF EXISTS `istruzioni_per_la_compilazione_child`;

CREATE TABLE `istruzioni_per_la_compilazione_child` (
  `Ins_id` bigint(20) NOT NULL,
  `Instruction` varchar(4000) DEFAULT NULL,
  `Istruzioni_per_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Ins_id`),
  KEY `FK_istruzioni_per_la_compilazione_child` (`Istruzioni_per_id`),
  CONSTRAINT `FK_istruzioni_per_la_compilazione_child` FOREIGN KEY (`Istruzioni_per_id`) REFERENCES `istruzioni_per_la_compilazione` (`Istruzioni_per_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `istruzioni_per_la_compilazione_child` */

insert  into `istruzioni_per_la_compilazione_child`(`Ins_id`,`Instruction`,`Istruzioni_per_id`) values (1,'School districts shall notify parents at the beginning of a school term of the availability of individualized instruction for pupils with a temporary disability. (EC sections 48206.3[d] and 48980)',1),(2,'A student with a temporary disability who is in a hospital or other residential health facility, excluding a state hospital, located outside of the school district in which the student’s parent or guardian resides, shall be deemed to have complied with the residency requirements for school attendance in the school district in which the hospital in located. (EC Section 48207)',1),(41277,'It is the primary responsibility of the parent or guardian of a student with a temporary disability to notify the school district in which the student is deemed to reside of the student’s presence in a qualifying hospital. Within five working days following notification from the parent or guardian, the school district shall determine whether the student will be able to receive individualized instruction, and, if the determination is positive, when the individualized instruction may begin. Individualized instruction shall start no later than five working days after the positive determination has been made. (EC Section 48208)',1),(41279,'EC Section 48206.3 specifies that for attendance accounting each clock hour of individualized instruction counts as one day of attendance. No student shall be credited with more than five days of attendance per calendar week or credited with more than the total number of calendar days that regular classes are offered by the district in any fiscal year.',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
