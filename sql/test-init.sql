CREATE DATABASE IF NOT EXISTS `test`
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_0900_ai_ci;

USE `test`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `user_id`     INT          NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `username`    VARCHAR(64)  NOT NULL COMMENT '账号',
    `password`    VARCHAR(100) NOT NULL COMMENT '密码',
    `phone`       VARCHAR(20)           DEFAULT NULL COMMENT '联系电话',
    `create_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `is_deleted`  TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '是否删除',
    `version`     INT          NOT NULL DEFAULT 0 COMMENT '版本',
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `uk_user_username` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  COMMENT = '用户表';

INSERT INTO `user` (`username`, `password`, `phone`, `is_deleted`, `version`)
VALUES ('test-user-01', '$2a$12$5Lm7tJEPZhGEqs58iZkF0u.VGcEpCQ2u1nHIzaZeHH2U2YadeM.t.', '13900000001', 0, 0),
       ('test-user-02', '$2a$12$5Lm7tJEPZhGEqs58iZkF0u.VGcEpCQ2u1nHIzaZeHH2U2YadeM.t.', '13900000002', 0, 0),
       ('deleted-user', '$2a$12$5Lm7tJEPZhGEqs58iZkF0u.VGcEpCQ2u1nHIzaZeHH2U2YadeM.t.', '13900000003', 1, 0);
