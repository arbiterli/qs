alter table `qualitysystem`.`role` 
   change `product_id` `product_id` int(10) UNSIGNED NOT NULL, 
   change `user_id` `user_id` int(10) UNSIGNED NOT NULL, 
   change `name` `name` varchar(255) character set latin1 collate latin1_swedish_ci NOT NULL,
   drop primary key, 
   add primary key(`id`, `product_id`, `user_id`, `name`)