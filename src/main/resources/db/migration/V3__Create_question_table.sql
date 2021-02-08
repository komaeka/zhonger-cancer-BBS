CREATE TABLE `bbs`.`question`  (
                                   `id` int  AUTO_INCREMENT,
                                   `title` varchar(50),
                                   `description` text,
                                   `gmt_create` bigint,
                                   `gmt_modified` bigint,
                                   `creator` int ,
                                   `comment_count` int  DEFAULT 0,
                                   `view_count` int  DEFAULT 0,
                                   `like_count` int  DEFAULT 0,
                                   `tag` varchar(256) ,
                                   PRIMARY KEY (`id`)
);