ALTER TABLE `qualitysystem`.`products` 
   ADD COLUMN `hotdeploy_svn` VARCHAR(255) NULL AFTER `trunk_svn`, 
   ADD COLUMN `svn_user` VARCHAR(255) NULL AFTER `hotdeploy_svn`, 
   ADD COLUMN `svn_password` VARCHAR(255) NULL AFTER `svn_user`;
ALTER TABLE `qualitysystem`.`deploy` 
   ADD COLUMN `svn_revision` INT(11) NULL AFTER `log`;

