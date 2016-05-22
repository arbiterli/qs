DROP TABLE IF EXISTS `qualitysystem`.`score_owner_mapping`;
CREATE TABLE `qualitysystem`.`score_owner_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `score_name` varchar(255) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_id` (`product_id`,`score_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1