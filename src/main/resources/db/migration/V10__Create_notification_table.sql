CREATE TABLE `bbs`.`notification`  (
                                   `id` bigint NOT NULL AUTO_INCREMENT,
                                   `notifier` bigint NOT NULL,
                                   `receiver` bigint NOT NULL,
                                   `outerId` bigint NOT NULL,
                                   `type` int NOT NULL,
                                   `gmt_create` bigint NOT NULL,
                                   `status` int NOT NULL DEFAULT 0,
                                   PRIMARY KEY (`id`)
);