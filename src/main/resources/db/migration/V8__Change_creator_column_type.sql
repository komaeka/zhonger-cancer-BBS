ALTER TABLE `bbs`.`comment`
    MODIFY COLUMN `commentator` bigint NOT NULL;
ALTER TABLE `bbs`.`question`
    MODIFY COLUMN `creator` bigint NULL DEFAULT NULL AFTER `gmt_modified`;