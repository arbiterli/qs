USE `qualitysystem`;
DROP TABLE IF EXISTS `system_error`;
CREATE TABLE `system_error` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `error_from` varchar(50) DEFAULT NULL,
  `info` text,
  `extern_info` varchar(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;