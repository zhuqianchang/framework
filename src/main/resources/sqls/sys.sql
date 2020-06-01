DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
	`id` INT (11) NOT NULL AUTO_INCREMENT,
	`account` VARCHAR (40) NOT NULL COMMENT '用户名',
	`password` VARCHAR (255) NOT NULL COMMENT '密码',
	`nickname` VARCHAR (60) DEFAULT NULL COMMENT '昵称',
	`email` VARCHAR (40) DEFAULT NULL COMMENT '邮箱',
	`phone` VARCHAR (11) DEFAULT NULL COMMENT '电话',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
	`create_user` INT (11) DEFAULT NULL COMMENT '创建人',
	`modify_time` datetime DEFAULT NULL COMMENT '修改时间',
	`modify_user` INT (11) DEFAULT NULL COMMENT '修改人',
	PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4;