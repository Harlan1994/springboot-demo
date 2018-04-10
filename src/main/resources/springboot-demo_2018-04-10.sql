# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.20)
# Database: springboot-demo
# Generation Time: 2018-04-10 11:07:31 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table tb_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;

INSERT INTO `tb_role` (`id`, `role_name`)
VALUES
	(1,'ROLE_USER'),
	(2,'ROLE_ADMIN');

/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `locked` bit(1) NOT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;

INSERT INTO `tb_user` (`id`, `password`, `username`, `avatar`, `birthday`, `locked`, `real_name`)
VALUES
	(1,'123','harlan1','/avater','1994-02-02 00:00:00',b'0','Harlan1_real'),
	(2,'123','harlan2','/avater','1994-02-02 00:00:00',b'0','Harlan2_real'),
	(3,'123','harlan3','/avater','1994-02-02 00:00:00',b'0','Harlan3_real'),
	(4,'123','harlan4','/avater','1994-02-02 00:00:00',b'0','Harlan4_real'),
	(5,'123','harlan5','/avater','1994-02-02 00:00:00',b'0','Harlan5_real'),
	(6,'123','harlan6','/avater','1994-02-02 00:00:00',b'0','Harlan6_real'),
	(7,'pass','999',NULL,'1993-02-02 00:00:00',b'0','real'),
	(8,'passwordvalue','usernamevalue',NULL,'1993-02-02 00:00:00',b'0','realNamevalue'),
	(10,'passwordvalue','usernamevalue1',NULL,'1993-02-02 00:00:00',b'0','realNamevalue');

/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `foreign_key_user_role_user` (`user_id`),
  KEY `foreign_key_user_role_role` (`role_id`),
  CONSTRAINT `foreign_key_user_role_role` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`),
  CONSTRAINT `foreign_key_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_user_role` WRITE;
/*!40000 ALTER TABLE `tb_user_role` DISABLE KEYS */;

INSERT INTO `tb_user_role` (`user_id`, `role_id`)
VALUES
	(2,1),
	(4,1),
	(1,1),
	(3,1),
	(5,1),
	(6,1),
	(1,2),
	(2,2);

/*!40000 ALTER TABLE `tb_user_role` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
