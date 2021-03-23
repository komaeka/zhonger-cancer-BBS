ALTER TABLE `bbs`.`comment`
    ADD COLUMN `comment_count` int NULL DEFAULT 0 AFTER `content`;