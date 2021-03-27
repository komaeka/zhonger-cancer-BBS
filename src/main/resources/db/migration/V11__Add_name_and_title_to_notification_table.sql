ALTER TABLE `bbs`.`notification`
    ADD COLUMN `notifier_name` varchar(100) NULL AFTER `status`,
ADD COLUMN `outer_title` varchar(255) NULL AFTER `notifier_name`;