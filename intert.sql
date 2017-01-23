/*
SQLyog Community Edition- MySQL GUI v7.02 
MySQL - 5.7.17-log : Database - demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `demo`;

/*Table structure for table `fuel_comp_result` */

DROP TABLE IF EXISTS `fuel_comp_result`;

CREATE TABLE `fuel_comp_result` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CAR_TYPE` varchar(10) DEFAULT NULL,
  `FUEL` double DEFAULT NULL,
  `TIME_CONSUMED` decimal(10,0) DEFAULT NULL,
  `MILE_DRIVEN` decimal(10,0) DEFAULT NULL,
  `ADITION_vehicle` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `fuel_comp_result` */

insert  into `fuel_comp_result`(`ID`,`CAR_TYPE`,`FUEL`,`TIME_CONSUMED`,`MILE_DRIVEN`,`ADITION_vehicle`) values (1,'car',2,'4','80','bike');

/*Table structure for table `shiping_event_log` */

DROP TABLE IF EXISTS `shiping_event_log`;

CREATE TABLE `shiping_event_log` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `STATUS` varchar(30) DEFAULT NULL,
  `EVENTARRIVALLOCATION` varchar(30) DEFAULT NULL,
  `EVENTCITY` varchar(30) DEFAULT NULL,
  `EVENTCOUNTRY` varchar(30) DEFAULT NULL,
  `EVENTDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `EVENTDESCRIPTION` varchar(100) DEFAULT NULL,
  `EVENTSTATE` varchar(2) DEFAULT NULL,
  `EVENTSTATUSEXCEPTIONCODE` varchar(100) DEFAULT NULL,
  `EVENTSTATUSEXCEPTIONDESC` varchar(100) DEFAULT NULL,
  `EVENTTYPE` varchar(100) DEFAULT NULL,
  `EVENTZIP` varchar(20) DEFAULT NULL,
  `INVOICE_NO` varchar(30) DEFAULT NULL,
  `TRACKING_NUMBER` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

/*Data for the table `shiping_event_log` */

insert  into `shiping_event_log`(`ID`,`STATUS`,`EVENTARRIVALLOCATION`,`EVENTCITY`,`EVENTCOUNTRY`,`EVENTDATE`,`EVENTDESCRIPTION`,`EVENTSTATE`,`EVENTSTATUSEXCEPTIONCODE`,`EVENTSTATUSEXCEPTIONDESC`,`EVENTTYPE`,`EVENTZIP`,`INVOICE_NO`,`TRACKING_NUMBER`) values (87,NULL,'Harrison','Harrison','US','2017-01-20 21:18:26','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','P','72601','123','123456789012'),(89,NULL,'Harrison','Harrison','US','2017-01-20 21:18:26','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','P','72601','123','123456789012'),(91,NULL,'Harrison','Harrison','US','2017-01-20 21:18:26','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','P','72601','123','123456789012'),(93,NULL,'Harrison','Harrison','US','2017-01-20 21:18:26','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','P','72601','123','123456789012');

/*Table structure for table `shiping_event_log_archive` */

DROP TABLE IF EXISTS `shiping_event_log_archive`;

CREATE TABLE `shiping_event_log_archive` (
  `ARCHIVE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `ID` int(10) DEFAULT NULL,
  `STATUS` varchar(30) DEFAULT NULL,
  `EVENTARRIVALLOCATION` varchar(30) DEFAULT NULL,
  `EVENTCITY` varchar(30) DEFAULT NULL,
  `EVENTCOUNTRY` varchar(30) DEFAULT NULL,
  `EVENTDATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `EVENTDESCRIPTION` varchar(100) DEFAULT NULL,
  `EVENTSTATE` varchar(2) DEFAULT NULL,
  `EVENTSTATUSEXCEPTIONCODE` varchar(100) DEFAULT NULL,
  `EVENTSTATUSEXCEPTIONDESC` varchar(100) DEFAULT NULL,
  `EVENTTYPE` varchar(100) DEFAULT NULL,
  `EVENTZIP` varchar(20) DEFAULT NULL,
  `INVOICE_NO` varchar(30) DEFAULT NULL,
  `TRACKING_NUMBER` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ARCHIVE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

/*Data for the table `shiping_event_log_archive` */

insert  into `shiping_event_log_archive`(`ARCHIVE_ID`,`ID`,`STATUS`,`EVENTARRIVALLOCATION`,`EVENTCITY`,`EVENTCOUNTRY`,`EVENTDATE`,`EVENTDESCRIPTION`,`EVENTSTATE`,`EVENTSTATUSEXCEPTIONCODE`,`EVENTSTATUSEXCEPTIONDESC`,`EVENTTYPE`,`EVENTZIP`,`INVOICE_NO`,`TRACKING_NUMBER`) values (1,1,'DELIVERED','Harrison','Harrison','US','2017-01-20 21:18:26','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','123456789012'),(2,2,'DELIVERED','Harrison','Harrison','US','2017-01-20 21:23:02','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(4,1,'DELIVERED','Harrison','Harrison','US','2017-01-20 21:18:26','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','123456789012'),(5,2,'DELIVERED','Harrison','Harrison','US','2017-01-22 12:16:18','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(7,4,'DELIVERED','Harrison','Harrison','US','2017-01-20 21:18:26','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','123456789012'),(8,5,'DELIVERED','Harrison','Harrison','US','2017-01-20 21:23:02','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(9,6,'DELIVERED','Harrison','Harrison','US','2017-01-20 21:18:26','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','123456789012'),(10,7,'DELIVERED','Harrison','Harrison','US','2017-01-22 12:16:18','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(11,12,'DELIVERED','Harrison','Harrison','US','2017-01-22 12:29:47','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(12,14,'DELIVERED','Harrison','Harrison','US','2017-01-22 12:29:47','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(14,19,'DELIVERED','Harrison','Harrison','US','2017-01-22 12:30:33','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(15,21,'DELIVERED','Harrison','Harrison','US','2017-01-22 12:30:33','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(16,23,'DELIVERED','Harrison','Harrison','US','2017-01-22 12:30:33','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(17,25,'DELIVERED','Harrison','Harrison','US','2017-01-22 12:30:33','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(18,26,'DELIVERED','Harrison','Harrison','US','2017-01-22 12:30:33','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(19,27,'DELIVERED','Harrison','Harrison','US','2017-01-22 12:30:33','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(20,26,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(21,28,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(22,30,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(23,32,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(24,33,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(25,34,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(26,35,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(27,36,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(28,37,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(29,38,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(30,39,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(31,40,'DELIVERED','Harrison','Harrison','US','2017-01-23 10:17:28','Delivered','AR','Left at front door. Package delivered to recipient address - release authorized','Testing','DL','72601','123','790604097962'),(35,72,'DELIVERED','q','q','q','2017-01-23 10:39:18','q','q','gg','Testing','DL','gg','123','790604097962'),(36,13,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 10:48:34','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(37,11,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:11:27','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(38,88,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(39,90,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(40,92,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(41,94,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(42,95,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(43,96,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(44,97,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(45,98,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(46,99,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(47,100,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(48,101,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(49,102,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(50,103,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(51,104,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(52,105,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(53,106,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(54,107,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(55,108,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(56,109,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(57,110,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(58,111,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(59,112,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(60,113,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(61,114,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(62,115,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(63,116,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962'),(64,117,'DELIVERED',NULL,'DOWNINGTOWN','US','2017-01-23 11:14:47','Delivered','PA','02','Left at front door. Package delivered to recipient address - release authorized','DL','19335','123','790604097962');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
