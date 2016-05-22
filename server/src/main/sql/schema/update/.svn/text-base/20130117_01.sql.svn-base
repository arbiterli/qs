USE `qualitysystem`;
DROP TABLE IF EXISTS `score_email`;
CREATE TABLE `score_email` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `product_id` INT(11) NOT NULL,
  `score_name` VARCHAR(250) NOT NULL,
  `email` VARCHAR(250) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `alert`;
CREATE TABLE `alert` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `product_id` int(11) default NULL,
  `server_id` int(11) default NULL,
  `type` varchar(250) default NULL,
  `info` varchar(250) default NULL,
  `start_time` datetime default NULL,
  `end_time` datetime default NULL,
  `created_at` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;