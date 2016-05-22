ALTER TABLE `qualitysystem`.`products`
MODIFY `svn_password` VARCHAR(512),
MODIFY `issue_track_password` VARCHAR(512),
MODIFY `testrail_password` VARCHAR(512);

ALTER TABLE `qualitysystem`.`server`
MODIFY `password` VARCHAR(512),
MODIFY `nagios_password` VARCHAR(512);