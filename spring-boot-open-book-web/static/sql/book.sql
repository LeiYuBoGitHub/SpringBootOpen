/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.12 : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `book`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `state` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `author` */

insert  into `author`(`id`,`author_name`,`state`,`create_time`,`update_time`) values (1,'刘慈欣',0,'2020-05-13 19:05:25','2020-05-13 19:05:27');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `author_id` int(8) DEFAULT NULL,
  `book_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `state` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `book` */

insert  into `book`(`id`,`author_id`,`book_name`,`state`,`create_time`,`update_time`) values (1,NULL,'奥古斯都',0,'2019-11-22 21:19:40','2019-11-22 21:19:42'),(2,NULL,'房思琪的初恋乐园',0,'2019-11-22 21:19:53','2019-11-22 21:19:55'),(3,NULL,'我们一无所有',0,'2019-11-22 21:20:10','2019-11-22 21:20:12'),(4,NULL,'梦的化石',0,'2019-11-22 21:20:25','2019-11-22 21:20:27'),(5,NULL,'解忧杂货店',0,'2019-11-22 21:20:50','2019-11-22 21:20:52'),(6,NULL,'活着',0,'2019-11-22 21:21:15','2019-11-22 21:21:17'),(7,NULL,'野性的呼唤',0,'2019-11-25 18:45:12','2019-11-25 18:45:12'),(8,NULL,'呼吸',0,'2019-12-19 15:09:31','2019-12-19 15:09:31'),(9,NULL,'伦敦人',0,'2019-12-19 19:29:17','2019-12-19 19:29:17'),(10,1,'三体',0,'2020-05-13 19:07:04','2020-05-13 19:07:06');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `account` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `state` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`account`,`password`,`name`,`state`,`create_time`,`update_time`) values (1,'admin','admin','星际穿越33',0,'2019-08-08 16:31:58','2019-08-08 16:32:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
