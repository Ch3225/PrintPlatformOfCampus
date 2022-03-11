/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.28 : Database - pfpsc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pfpsc` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `pfpsc`;

/*Table structure for table `c_chargefunction` */

DROP TABLE IF EXISTS `c_chargefunction`;

CREATE TABLE `c_chargefunction` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `function` text NOT NULL,
  `referenceNum` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `c_chargefunction` */

/*Table structure for table `c_reference` */

DROP TABLE IF EXISTS `c_reference`;

CREATE TABLE `c_reference` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `c_chargefunction_id` int unsigned NOT NULL,
  `referenceno` int NOT NULL,
  `varname` char(64) NOT NULL,
  `referencename` varchar(64) DEFAULT NULL,
  `referencedescription` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `c_chargefunction_id` (`c_chargefunction_id`),
  CONSTRAINT `c_reference_ibfk_1` FOREIGN KEY (`c_chargefunction_id`) REFERENCES `c_chargefunction` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `c_reference` */

/*Table structure for table `f_file` */

DROP TABLE IF EXISTS `f_file`;

CREATE TABLE `f_file` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `sha256` char(64) NOT NULL,
  `name` varchar(1024) NOT NULL,
  `addtime` datetime DEFAULT NULL,
  `expiretime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `f_file` */

/*Table structure for table `g_defaultprintmethod` */

DROP TABLE IF EXISTS `g_defaultprintmethod`;

CREATE TABLE `g_defaultprintmethod` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `m_printmethod_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `g_defaultprintmethod_ibfk_2` (`m_printmethod_id`),
  CONSTRAINT `g_defaultprintmethod_ibfk_1` FOREIGN KEY (`id`) REFERENCES `u_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `g_defaultprintmethod_ibfk_2` FOREIGN KEY (`m_printmethod_id`) REFERENCES `m_printmethod` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `g_defaultprintmethod` */

/*Table structure for table `g_defaultshop` */

DROP TABLE IF EXISTS `g_defaultshop`;

CREATE TABLE `g_defaultshop` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `s_shop_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `s_shop_id` (`s_shop_id`),
  CONSTRAINT `g_defaultshop_ibfk_1` FOREIGN KEY (`id`) REFERENCES `u_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `g_defaultshop_ibfk_2` FOREIGN KEY (`s_shop_id`) REFERENCES `s_shop` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `g_defaultshop` */

/*Table structure for table `g_preferenceposition` */

DROP TABLE IF EXISTS `g_preferenceposition`;

CREATE TABLE `g_preferenceposition` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `u_user_id` int unsigned NOT NULL,
  `p_position_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_user_id` (`u_user_id`,`p_position_id`),
  KEY `p_position_id` (`p_position_id`),
  CONSTRAINT `g_preferenceposition_ibfk_1` FOREIGN KEY (`u_user_id`) REFERENCES `u_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `g_preferenceposition_ibfk_2` FOREIGN KEY (`p_position_id`) REFERENCES `p_position` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `g_preferenceposition` */

/*Table structure for table `g_preferenceprintmethod` */

DROP TABLE IF EXISTS `g_preferenceprintmethod`;

CREATE TABLE `g_preferenceprintmethod` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `u_user_id` int unsigned NOT NULL,
  `m_printmethod_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_user_id` (`u_user_id`,`m_printmethod_id`),
  KEY `m_printmethod_id` (`m_printmethod_id`),
  CONSTRAINT `g_preferenceprintmethod_ibfk_1` FOREIGN KEY (`u_user_id`) REFERENCES `u_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `g_preferenceprintmethod_ibfk_2` FOREIGN KEY (`m_printmethod_id`) REFERENCES `m_printmethod` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `g_preferenceprintmethod` */

/*Table structure for table `g_preferenceshop` */

DROP TABLE IF EXISTS `g_preferenceshop`;

CREATE TABLE `g_preferenceshop` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `u_user_id` int unsigned NOT NULL,
  `s_shop_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_user_id` (`u_user_id`,`s_shop_id`),
  KEY `s_shop_id` (`s_shop_id`),
  CONSTRAINT `g_preferenceshop_ibfk_1` FOREIGN KEY (`u_user_id`) REFERENCES `u_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `g_preferenceshop_ibfk_2` FOREIGN KEY (`s_shop_id`) REFERENCES `s_shop` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `g_preferenceshop` */

/*Table structure for table `m_chartitem` */

DROP TABLE IF EXISTS `m_chartitem`;

CREATE TABLE `m_chartitem` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `m_printmethod_id` int unsigned NOT NULL,
  `m_printchoice_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `m_printmethod_id` (`m_printmethod_id`),
  KEY `m_printchoice_id` (`m_printchoice_id`),
  CONSTRAINT `m_chartitem_ibfk_1` FOREIGN KEY (`m_printmethod_id`) REFERENCES `m_printmethod` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `m_chartitem_ibfk_2` FOREIGN KEY (`m_printchoice_id`) REFERENCES `m_printchoice` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `m_chartitem` */

/*Table structure for table `m_printchoice` */

DROP TABLE IF EXISTS `m_printchoice`;

CREATE TABLE `m_printchoice` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `m_printkey_id` int unsigned NOT NULL,
  `choicename` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `m_printkey_id` (`m_printkey_id`),
  CONSTRAINT `m_printchoice_ibfk_1` FOREIGN KEY (`m_printkey_id`) REFERENCES `m_printkey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `m_printchoice` */

/*Table structure for table `m_printkey` */

DROP TABLE IF EXISTS `m_printkey`;

CREATE TABLE `m_printkey` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `keyname` varchar(64) NOT NULL,
  `m_printchoice_id` int unsigned NOT NULL COMMENT 'default method',
  PRIMARY KEY (`id`),
  KEY `m_printkey_ibfk_1` (`m_printchoice_id`),
  CONSTRAINT `m_printkey_ibfk_1` FOREIGN KEY (`m_printchoice_id`) REFERENCES `m_printchoice` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `m_printkey` */

/*Table structure for table `m_printmethod` */

DROP TABLE IF EXISTS `m_printmethod`;

CREATE TABLE `m_printmethod` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `m_printmethod` */

/*Table structure for table `o_order` */

DROP TABLE IF EXISTS `o_order`;

CREATE TABLE `o_order` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `o_orderstate_id` int unsigned NOT NULL,
  `u_user_id_customer` int unsigned NOT NULL,
  `u_user_id_shopper` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `o_orderstate_id` (`o_orderstate_id`),
  KEY `u_user_id_customer` (`u_user_id_customer`),
  KEY `u_user_id_shopper` (`u_user_id_shopper`),
  CONSTRAINT `o_order_ibfk_1` FOREIGN KEY (`o_orderstate_id`) REFERENCES `o_orderstate` (`id`),
  CONSTRAINT `o_order_ibfk_2` FOREIGN KEY (`u_user_id_customer`) REFERENCES `u_user` (`id`),
  CONSTRAINT `o_order_ibfk_3` FOREIGN KEY (`u_user_id_shopper`) REFERENCES `u_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `o_order` */

/*Table structure for table `o_orderitem` */

DROP TABLE IF EXISTS `o_orderitem`;

CREATE TABLE `o_orderitem` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `o_order_id` int unsigned NOT NULL,
  `f_file_id` int unsigned NOT NULL,
  `m_printmethod_id` int unsigned NOT NULL,
  `o_orderitemstate_id` int unsigned NOT NULL,
  `count` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `o_order_id` (`o_order_id`),
  KEY `f_file_id` (`f_file_id`),
  KEY `m_printmethod_id` (`m_printmethod_id`),
  KEY `o_orderitemstate_id` (`o_orderitemstate_id`),
  CONSTRAINT `o_orderitem_ibfk_1` FOREIGN KEY (`o_order_id`) REFERENCES `o_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `o_orderitem_ibfk_2` FOREIGN KEY (`f_file_id`) REFERENCES `f_file` (`id`),
  CONSTRAINT `o_orderitem_ibfk_3` FOREIGN KEY (`m_printmethod_id`) REFERENCES `m_printmethod` (`id`),
  CONSTRAINT `o_orderitem_ibfk_4` FOREIGN KEY (`o_orderitemstate_id`) REFERENCES `o_orderitemstate` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `o_orderitem` */

/*Table structure for table `o_orderitemstate` */

DROP TABLE IF EXISTS `o_orderitemstate`;

CREATE TABLE `o_orderitemstate` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `state` char(128) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `o_orderitemstate` */

/*Table structure for table `o_orderstate` */

DROP TABLE IF EXISTS `o_orderstate`;

CREATE TABLE `o_orderstate` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `state` char(128) NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `o_orderstate` */

/*Table structure for table `p_position` */

DROP TABLE IF EXISTS `p_position`;

CREATE TABLE `p_position` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `positionname` varchar(256) DEFAULT NULL,
  `latitude` decimal(10,6) NOT NULL,
  `longitude` decimal(10,6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `p_position` */

/*Table structure for table `s_reference` */

DROP TABLE IF EXISTS `s_reference`;

CREATE TABLE `s_reference` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `list` char(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `s_reference` */

/*Table structure for table `s_shop` */

DROP TABLE IF EXISTS `s_shop`;

CREATE TABLE `s_shop` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `shopname` varchar(128) NOT NULL,
  `s_shopstate_id` int unsigned NOT NULL,
  `p_position_id` int unsigned NOT NULL,
  `u_user_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `s_shopstate_id` (`s_shopstate_id`),
  KEY `p_position_id` (`p_position_id`),
  KEY `u_user_id` (`u_user_id`),
  CONSTRAINT `s_shop_ibfk_1` FOREIGN KEY (`s_shopstate_id`) REFERENCES `s_shopstate` (`id`),
  CONSTRAINT `s_shop_ibfk_2` FOREIGN KEY (`p_position_id`) REFERENCES `p_position` (`id`),
  CONSTRAINT `s_shop_ibfk_3` FOREIGN KEY (`u_user_id`) REFERENCES `u_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `s_shop` */

/*Table structure for table `s_shopstate` */

DROP TABLE IF EXISTS `s_shopstate`;

CREATE TABLE `s_shopstate` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `s_shopstate` */

/*Table structure for table `s_shopsupport` */

DROP TABLE IF EXISTS `s_shopsupport`;

CREATE TABLE `s_shopsupport` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `s_shop_id` int unsigned NOT NULL,
  `m_printmethod_id` int unsigned NOT NULL,
  `c_chargefunction_id` int unsigned NOT NULL,
  `s_reference` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `s_shop_id` (`s_shop_id`,`m_printmethod_id`),
  KEY `m_printmethod_id` (`m_printmethod_id`),
  KEY `c_chargefunction_id` (`c_chargefunction_id`),
  KEY `s_reference` (`s_reference`),
  CONSTRAINT `s_shopsupport_ibfk_1` FOREIGN KEY (`s_shop_id`) REFERENCES `s_shop` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s_shopsupport_ibfk_2` FOREIGN KEY (`m_printmethod_id`) REFERENCES `m_printmethod` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s_shopsupport_ibfk_3` FOREIGN KEY (`c_chargefunction_id`) REFERENCES `c_chargefunction` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s_shopsupport_ibfk_4` FOREIGN KEY (`s_reference`) REFERENCES `s_reference` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `s_shopsupport` */

/*Table structure for table `u_actor` */

DROP TABLE IF EXISTS `u_actor`;

CREATE TABLE `u_actor` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` char(128) NOT NULL,
  `description` varchar(1024) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

/*Data for the table `u_actor` */

insert  into `u_actor`(`id`,`name`,`description`) values (1,'Customer','客户'),(2,'Shopper','商家'),(3,'Administrator','管理员'),(4,'TempCustomer','临时客户');

/*Table structure for table `u_infosheet` */

DROP TABLE IF EXISTS `u_infosheet`;

CREATE TABLE `u_infosheet` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `rpcId` char(32) DEFAULT NULL,
  `phoneNumber` char(32) NOT NULL,
  `email` char(128) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phonenumber_unique` (`phoneNumber`),
  UNIQUE KEY `rpcid_unique` (`rpcId`),
  UNIQUE KEY `email_unique` (`email`),
  CONSTRAINT `u_infosheet_ibfk_1` FOREIGN KEY (`id`) REFERENCES `u_user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `u_infosheet` */

/*Table structure for table `u_user` */

DROP TABLE IF EXISTS `u_user`;

CREATE TABLE `u_user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `u_actor_id` int unsigned NOT NULL,
  `password` char(64) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `u_actor_id` (`u_actor_id`),
  CONSTRAINT `u_user_ibfk_1` FOREIGN KEY (`u_actor_id`) REFERENCES `u_actor` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `u_user` */

/*Table structure for table `w_user` */

DROP TABLE IF EXISTS `w_user`;

CREATE TABLE `w_user` (
  `id` int unsigned NOT NULL,
  `balance` decimal(11,2) unsigned NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`),
  CONSTRAINT `w_user_ibfk_1` FOREIGN KEY (`id`) REFERENCES `u_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `w_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
