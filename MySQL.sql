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
/*Table structure for table `wiki_comment_table` */

DROP TABLE IF EXISTS `wiki_comment_table`;

CREATE TABLE `wiki_comment_table` (
  `comment_ID` bigint(20) NOT NULL,
  `Comment_data` text,
  `Comment_User` varchar(500) DEFAULT NULL,
  `Comment_Date` varchar(1000) DEFAULT NULL,
  `PageID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`comment_ID`),
  KEY `FK_wiki_comment_table` (`PageID`),
  CONSTRAINT `FK_wiki_comment_table` FOREIGN KEY (`PageID`) REFERENCES `wiki_page_table` (`PageID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wiki_comment_table` */

insert  into `wiki_comment_table`(`comment_ID`,`Comment_data`,`Comment_User`,`Comment_Date`,`PageID`) values (1,'This is me','Test','6/9/2017',1);

/*Table structure for table `wiki_node_table` */

DROP TABLE IF EXISTS `wiki_node_table`;

CREATE TABLE `wiki_node_table` (
  `NodeID` bigint(20) NOT NULL,
  `NodeName` varchar(500) DEFAULT NULL,
  `NodeDescription` varchar(1000) DEFAULT NULL,
  `NodeCreationDate` varchar(200) DEFAULT NULL,
  `NodeCreator` varchar(200) DEFAULT NULL,
  `NodeModificationDate` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`NodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wiki_node_table` */

insert  into `wiki_node_table`(`NodeID`,`NodeName`,`NodeDescription`,`NodeCreationDate`,`NodeCreator`,`NodeModificationDate`) values (1,'Main','This is my First','6/9/2017','Test','6/9/2017'),(2,'Second',NULL,NULL,NULL,NULL);

/*Table structure for table `wiki_page_table` */

DROP TABLE IF EXISTS `wiki_page_table`;

CREATE TABLE `wiki_page_table` (
  `PageID` bigint(20) NOT NULL,
  `PageName` varchar(500) DEFAULT NULL,
  `PageDescription` varchar(1000) DEFAULT NULL,
  `PageRating` varchar(100) DEFAULT NULL,
  `PageVersion` varchar(100) DEFAULT NULL,
  `NodeID` bigint(20) DEFAULT NULL,
  `Page_Creation_Date` varchar(500) DEFAULT NULL,
  `Page_creator` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`PageID`),
  KEY `FK_wiki_page_table` (`NodeID`),
  CONSTRAINT `FK_wiki_page_table` FOREIGN KEY (`NodeID`) REFERENCES `wiki_node_table` (`NodeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wiki_page_table` */

insert  into `wiki_page_table`(`PageID`,`PageName`,`PageDescription`,`PageRating`,`PageVersion`,`NodeID`,`Page_Creation_Date`,`Page_creator`) values (1,'ONE','This is One Page','5','2',1,'6/9/2017','TEST'),(2,'TWO','This is Two Page','5','1',1,'6/9/2017','TEST');

/*Table structure for table `wiki_pagedata_table` */

DROP TABLE IF EXISTS `wiki_pagedata_table`;

CREATE TABLE `wiki_pagedata_table` (
  `Page_ModID` bigint(20) NOT NULL,
  `PageData` text,
  `PageEdit_User` varchar(500) DEFAULT NULL,
  `Page_editDate` varchar(500) DEFAULT NULL,
  `Page_Version` varchar(500) DEFAULT NULL,
  `PageID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Page_ModID`),
  KEY `FK_wiki_pagedata_table` (`PageID`),
  CONSTRAINT `FK_wiki_pagedata_table` FOREIGN KEY (`PageID`) REFERENCES `wiki_page_table` (`PageID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wiki_pagedata_table` */

insert  into `wiki_pagedata_table`(`Page_ModID`,`PageData`,`PageEdit_User`,`Page_editDate`,`Page_Version`,`PageID`) values (1,'Hello','Test','6/9/2017','1',1),(2,'Hello Bye','Test','6/9/2017','2',1),(3,'this is two','Test','6/9/2017','3',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
