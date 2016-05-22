USE `qualitysystem`;
DROP TABLE IF EXISTS `product_extend_property`;
CREATE TABLE `product_extend_property` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `property_name` varchar(50) DEFAULT NULL,
  `property_value` varchar(50) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
