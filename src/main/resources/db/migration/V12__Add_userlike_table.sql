
CREATE TABLE `bbs`.`userlike`  (
                                   `id` bigint NOT NULL AUTO_INCREMENT,
                                   `ACCOUNT_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                   `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                   `galgame` int NULL DEFAULT 0,
                                   `animation` int NULL DEFAULT 0,
                                   `fantasy` int NULL DEFAULT 0,
                                   `imaginary` int NULL DEFAULT 0,
                                   `blood` int NULL DEFAULT 0,
                                   `cute` int NULL DEFAULT 0,
                                   `lachrymatory` int NULL DEFAULT 0,
                                   `crossing` int NULL DEFAULT 0,
                                   `campus` int NULL DEFAULT 0,
                                   `comedy` int NULL DEFAULT 0,
                                   `matory` int NULL DEFAULT 0,
                                   `battle` int NULL DEFAULT 0,
                                   `magic` int NULL DEFAULT 0,
                                   PRIMARY KEY (`id`)
);
INSERT INTO `userlike` VALUES (16, '76942722', 'Komaeka', 0, 0 ,0 ,0 , 0, 0 ,0 ,0 , 0, 0 ,0 ,0 ,0);
