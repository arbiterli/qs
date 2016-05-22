DELIMITER $$

USE `qualitysystem`$$

DROP PROCEDURE IF EXISTS `updateProductRole`$$

CREATE PROCEDURE `updateProductRole`(IN productName VARCHAR(50), IN BOEmails VARCHAR(200), IN BOAmount INT(5), IN TMEmail VARCHAR(50))
BEGIN
        DECLARE i INT DEFAULT 1;
        DECLARE pId INT DEFAULT 0;
        DECLARE TMId INT DEFAULT 0;
        DECLARE BOId INT DEFAULT 0;
        DECLARE roleAmount INT DEFAULT 0;
        DECLARE userName VARCHAR(255) DEFAULT '';
        DECLARE BOEmail VARCHAR(255) DEFAULT '';
        
        SET pId = (SELECT `id` FROM products WHERE `name`=productName);
        IF pId IS NOT NULL THEN
            SET TMId = (SELECT `id` FROM `users` WHERE `email`=TMEmail);
            IF TMId IS NULL THEN 
                SET userName = REVERSE(SUBSTRING_INDEX(REVERSE(SUBSTRING_INDEX(TMEmail,'@',1)),'@',1));
                INSERT INTO `users` (`name`,email,`created_at`,`login`) VALUES (userName,TMEmail,NOW(),userName);
                SET TMId = (SELECT `id` FROM users WHERE `email`=TMEmail);
            END IF;
			SET roleAmount = (SELECT COUNT(*) FROM role WHERE `name`='ROLE_TECHNICALMANAGER' AND `product_id`=pId);
            IF roleAmount<1 THEN
                INSERT INTO `role`(`product_id`,`user_id`,`name`) VALUES (pId,TMId,'ROLE_TECHNICALMANAGER');
            ELSE
                UPDATE `role` SET `user_id`=TMId WHERE `name`='ROLE_TECHNICALMANAGER' AND `product_id`=pId ;
            END IF;
                 
            WHILE i<=BOAmount DO
                SET BOEmail = SUBSTRING_INDEX(SUBSTRING_INDEX(BOEmails, ',', i), ',', -1);
                SET BOId = (SELECT `id` FROM users WHERE `email`=BOEmail);
                IF BOId IS NULL THEN
                    SET userName = REVERSE(SUBSTRING_INDEX(REVERSE(SUBSTRING_INDEX(BOEmail,'@',1)),'@',1));  
                    INSERT INTO `users` (`name`,email,`created_at`,`login`) VALUES (userName,BOEmail,NOW(),userName);
                    SET BOId = (SELECT `id` FROM users WHERE `email`=BOEmail);
                END IF;
				IF i=1 THEN
				    SET roleAmount = (SELECT COUNT(*) FROM role WHERE `name` = 'ROLE_BUSINESSOWNER' AND `product_id`=pId);
                    IF roleAmount<1 THEN
                        INSERT INTO `role`(`product_id`,`user_id`,`name`) VALUES (pId,BOId,'ROLE_BUSINESSOWNER');
                    ELSE
                       UPDATE `role` SET `user_id`=BOId WHERE `name` = 'ROLE_BUSINESSOWNER' AND `product_id`=pId;
                    END IF;
				ELSE
                    INSERT INTO `role`(`product_id`,`user_id`,`name`) VALUES (pId,BOId,'ROLE_BUSINESSOWNER');
                END IF;					
                SET i=i+1;
            END WHILE;
        END IF;    
            
    END$$

DELIMITER ;


call updateProductRole('QualitySystem','xu.qingsong@glority.com,xu.xiaodong@glority.com',2,'xu.xiaodong@glority.com');
call updateProductRole('TimeTrackingServer','pan.yue@glority.com,xu.xiaodong@glority.com',2,'xu.xiaodong@glority.com');
call updateProductRole('JavaZipSendServer','chen.mingquan@glority.com',1,'xu.weifeng@glority.com');
call updateProductRole('ESignature','xu.qingsong@glority.com',1,'xu.qingsong@glority.com');
call updateProductRole('Courier45','chen.mingquan@glority.com',1,'xiao.heng@glority.com');
call updateProductRole('WinZip_Win8','chen.mingquan@glority.com',1,'martin.li@glority.com');
call updateProductRole('PersonalCenter','pan.yue@glority.com,xu.xiaodong@glority.com',2,'xu.xiaodong@glority.com');
call updateProductRole('EMC_14X','xu.qingsong@glority.com',1,'xu.qingsong@glority.com');

DROP PROCEDURE IF EXISTS `updateProductRole`;