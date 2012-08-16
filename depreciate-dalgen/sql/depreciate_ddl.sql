drop database db_depreciate;

create database db_depreciate;
use db_depreciate;
-- 系统表

CREATE TABLE IF NOT EXISTS `db_depreciate`.`depreciate_seq` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增字段' ,
  `name` VARCHAR(32) NOT NULL COMMENT 'seq名字，为日后清理和统计用' ,
  `raw_add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `uk_depreciate_seq_id` (`ID` ASC) )
ENGINE = InnoDB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = '系统表，用于生成序列号';

-- 业务表
CREATE TABLE IF NOT EXISTS `db_depreciate`.`depreciate_user` (
  `id` VARCHAR(16) NOT NULL COMMENT 'ID格式：日期+自增(8位)' ,
  `user_name` VARCHAR(32) NULL COMMENT '用户名' ,
  `user_passwd` VARCHAR(32) NULL COMMENT '用户密码名称' ,
  `user_email` VARCHAR(128) NULL COMMENT '用户Email' ,
  `status` VARCHAR(16) NOT NULL COMMENT '状态 (INIT:初始化)' ,
  `raw_add_time` DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间' ,
  `raw_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) ,
  INDEX `EMAIL_INDEX` (`user_email` ASC))
ENGINE = InnoDB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = '用户表';

CREATE TABLE IF NOT EXISTS `db_depreciate`.`depreciate_user_attention` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增字段' ,
  `user_id` VARCHAR(16) NOT NULL COMMENT '用户ID' ,
  `user_attention_product_id` VARCHAR(2048) NULL COMMENT '用户关注产品id' ,
  `product_alias_name` VARCHAR(128) NULL COMMENT '商品别名' ,
  `status` VARCHAR(16) NOT NULL COMMENT '状态 (FO/UNFO)' ,
  `raw_add_time` DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间' ,
  `raw_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
  PRIMARY KEY (`ID`) ,
  INDEX `USER_ID_INDEX` (`user_id` ASC))
ENGINE = InnoDB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = '用户表关注商品映射表';

CREATE TABLE IF NOT EXISTS `db_depreciate`.`depreciate_product` (
  `id` VARCHAR(16) NOT NULL COMMENT 'ID格式：日期+自增(8位)' ,
  `track_category` VARCHAR(32) NULL COMMENT '网站类别' ,
  `product_name` VARCHAR(128) NULL COMMENT '商品名称-通常是商家的title里面的名字' ,
  `product_serial_no` VARCHAR(64) NULL COMMENT '商品序列号' ,
  `status` VARCHAR(16) NOT NULL COMMENT '状态 (INIT:初始化)' ,
  `product_current_price` DECIMAL COMMENT '商品当前价格(单位分)' ,
  `product_url` VARCHAR(2048) NOT NULL COMMENT 'URL' ,
  `raw_add_time` DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间' ,
  `raw_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) ,
  INDEX `TRACK_CATEGORY_INDEX` (`track_category` ASC))
ENGINE = InnoDB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = '商品表';

CREATE TABLE IF NOT EXISTS `db_depreciate`.`depreciate_product_pic` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增字段' ,
  `product_id` VARCHAR(64) NULL COMMENT '商品ID' ,
  `pic_name` VARCHAR(32) NULL COMMENT '图片名字' ,
  `track_category` VARCHAR(32) NULL COMMENT '网站类别' ,
  `pic_source_url` VARCHAR(2048) NOT NULL COMMENT '图片源地址' ,
  `raw_add_time` DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间' ,
  `raw_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
  PRIMARY KEY (`ID`) ,
  INDEX `PRODUCT_ID_INDEX` (`product_id` ASC))
ENGINE = InnoDB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = '商品表图片';

CREATE TABLE IF NOT EXISTS `db_depreciate`.`depreciate_product_change_log` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增字段' ,
  `product_id` VARCHAR(16) NOT NULL COMMENT '商品表ID' ,
  `product_current_price` DECIMAL NOT NULL COMMENT '商品当前价格(单位分)' ,
  `product_change_price` DECIMAL NOT NULL COMMENT '商品变化价格(单位分)' ,
  `raw_add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) )
ENGINE = InnoDB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = '商品价格变动表';

CREATE TABLE IF NOT EXISTS `db_depreciate`.`depreciate_delay` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增字段' ,
  `product_url` VARCHAR(2048) NOT NULL COMMENT 'URL' ,
  `user_email` VARCHAR(128) NULL COMMENT '用户Email' ,
  `status` VARCHAR(16) NOT NULL COMMENT '状态 (INIT:初始化)' ,
  `raw_add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) )
ENGINE = InnoDB
CHARACTER SET utf8
COLLATE utf8_general_ci
COMMENT = '商品';

--  dml


