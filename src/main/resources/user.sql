/*
SQLyog Ultimate v8.32 
MySQL - 5.5.62 : Database - web
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`web` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `web`;

/*Table structure for table `user2` */

DROP TABLE IF EXISTS `user2`;

CREATE TABLE `user2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `bo` tinyint(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1198864464762507265 DEFAULT CHARSET=utf8;

/*Data for the table `user2` */

insert  into `user2`(`id`,`create_time`,`email`,`nickname`,`password`,`update_time`,`bo`,`username`) values (1196737838612353024,'2019-11-19 10:31:49','163.com1','浮动稍等','$2a$10$0xpoCdirIxI5Yak4RwRab.3IZlswWYo39YGVc15FIaM67wG0vnvJa','2019-11-19 10:31:49',0,'admin'),(1196737862859624448,'2019-11-19 10:31:55','163@163.com','浮动稍6666等','$2a$10$SlFM6qb8BIqh5jR08Ztq6.BN0P0ez2DALeQRLSK6dtVZFneE/GtgS','2019-11-19 10:31:49',0,'admin1'),(1197058333920595968,'2019-11-20 07:45:21','163@163.com','浮动稍6666等','$2a$10$i6Yunq22g5h7iQ4AHIcTuOs/klgC0d7yLcZLBgqvRtX2iwZ6pWoEK','2019-11-19 10:31:49',0,'admin2'),(1197082602641690624,'2019-11-20 09:21:47','1211','121','$2a$10$AfmTBo5dRCYzJa6EKYSDuOktmJFknTZGZSm3DgWe3y9rkLnrRpylu','2019-11-25 07:30:54',0,'admin3'),(1197466843028262912,'2019-11-21 10:48:37','qqqq','qqqq','$2a$10$uU9tntaJMCCjYeHofehRgeilYd0bSBgpBGqqCqs5qpW7LlU/Vo1LS','2019-11-19 10:31:49',0,'admin4'),(1198218940661239808,'2019-11-23 12:37:12','aaaaa@163.com','aaa','$2a$10$g.6K7TwxmL3fNxY3lHs3wuhqxUTUTio9waZaVzFITOEaZbM5q/5WW','2019-11-19 10:31:49',0,'admin5'),(1198219646235447296,'2019-11-23 12:40:00','111@63.com','asa','$2a$10$SYNvQ7tGoUOb9XHxZFynNunidN1QY2EH4KOCw9y37wgG0r2itP3..','2019-11-19 10:31:49',0,'admin6'),(1198864464762507264,'2019-11-25 07:22:17','aass','aass','$2a$10$Dd7cG.WM5wVlm8eHVGXEbeXZR.ZIgRVA1xVDg6I/R.Fp4s9T0Szcu','2019-11-25 07:22:17',0,'aass');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
