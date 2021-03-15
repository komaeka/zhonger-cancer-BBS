CREATE TABLE `bbs`.`comment`  (
                                   `id` bigint NOT NULL AUTO_INCREMENT,
                                   `parent_id` bigint NOT NULL COMMENT '父类ID',
                                   `type` int NOT NULL COMMENT '父类类型',
                                   `commentator` int NOT NULL COMMENT '评论人ID',
                                   `gmt_create` bigint NOT NULL COMMENT '创建时间',
                                   `gmt_modified` bigint NOT NULL COMMENT '更新时间',
                                   `like_count` bigint NOT NULL COMMENT '点赞数',
                                   PRIMARY KEY (`id`)
);