CREATE TABLE `user`  (
                         `ID` int NOT NULL AUTO_INCREMENT,
                         `ACCOUNT_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `TOKEN` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `GMT_CREATE` bigint NULL DEFAULT NULL,
                         `GMT_MODIFIED` bigint NULL DEFAULT NULL,
                         PRIMARY KEY (`ID`) USING BTREE
);