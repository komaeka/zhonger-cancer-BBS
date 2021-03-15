ALTER TABLE `bbs`.`comment`
    ADD COLUMN `content` varchar(1024) NOT NULL AFTER `like_count`;