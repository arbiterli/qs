/*
SQLyog Community Edition- MySQL GUI v8.17 
MySQL - 5.1.37-community : Database - qualitysystem
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qualitysystem` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `qualitysystem`;

/*Table structure for table `hotdeploy_config` */

DROP TABLE IF EXISTS `hotdeploy_config`;

CREATE TABLE `hotdeploy_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hotdeploy_svn` varchar(255) DEFAULT NULL,
  `svn_password` varchar(255) DEFAULT NULL,
  `svn_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hotdeploy_config` */

/*Table structure for table `issue_track` */

DROP TABLE IF EXISTS `issue_track`;

CREATE TABLE `issue_track` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `issue_track_base_url` varchar(255) DEFAULT NULL,
  `issue_track_password` varchar(255) DEFAULT NULL,
  `issue_track_product_name` varchar(255) DEFAULT NULL,
  `issue_track_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `issue_track` */

/*Table structure for table `testrail` */

DROP TABLE IF EXISTS `testrail`;

CREATE TABLE `testrail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `testrail_password` varchar(255) DEFAULT NULL,
  `testrail_product_id` bigint(20) DEFAULT NULL,
  `testrail_server` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `testrail` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
 
INSERT INTO `qualitysystem`.`issue_track` (issue_track_base_url, issue_track_product_name, issue_track_username, issue_track_password) (SELECT issue_track_base_url, issue_track_product_name, issue_track_username, issue_track_password FROM products);

INSERT INTO `qualitysystem`.`testrail` (testrail_server,testrail_product_id,testrail_password) (SELECT testrail_server,testrail_product_id,testrail_password FROM products);

INSERT INTO `qualitysystem`.`hotdeploy_config` (hotdeploy_svn,svn_user,svn_password) (SELECT hotdeploy_svn,svn_user,svn_password FROM products);


alter table `products` drop column `default_version`, 
drop column `default_configuration`, drop column `issue_track_base_url`,
drop column `issue_track_product_name`, drop column `issue_track_username`,
drop column `issue_track_password`, drop column `hotdeploy_svn`,
drop column `svn_user`, drop column `svn_password`,
drop column `testrail_server`, drop column `testrail_product_id`,
drop column `testrail_password`;

ALTER TABLE `products` ADD COLUMN `hotdeploy_config_id` bigint(20) NOT NULL, ADD COLUMN `issue_track_id` bigint(20) NOT NULL, ADD COLUMN `testrail_id` bigint(20) NOT NULL;

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    PROCEDURE `qualitysystem`.`updateProduct`()
    /*LANGUAGE SQL
    | [NOT] DETERMINISTIC
    | { CONTAINS SQL | NO SQL | READS SQL DATA | MODIFIES SQL DATA }
    | SQL SECURITY { DEFINER | INVOKER }
    | COMMENT 'string'*/
    BEGIN
        DECLARE i INT DEFAULT 1;
        DECLARE n INT;
        SET n=(SELECT COUNT(*) FROM hotdeploy_config);
        WHILE i <= n DO
            UPDATE `products` SET hotdeploy_config_id=i, issue_track_id=i, testrail_id=i WHERE id=i;
            SET i=i+1;
        END WHILE;

    END$$

DELIMITER ;

call updateProduct();

DROP PROCEDURE `qualitysystem`.`updateProduct`;

ALTER TABLE `products` ADD CONSTRAINT `FKC42BD1646583B29D` FOREIGN KEY (`hotdeploy_config_id`) REFERENCES `hotdeploy_config` (`id`), ADD CONSTRAINT `FKC42BD1644DC57A20` FOREIGN KEY (`testrail_id`) REFERENCES `testrail` (`id`),
ADD CONSTRAINT `FKC42BD1645C5A5A6D` FOREIGN KEY (`issue_track_id`) REFERENCES `issue_track` (`id`);

