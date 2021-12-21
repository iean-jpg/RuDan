/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : ep

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 21/12/2021 18:51:36
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `cat_id`   int                                                     NOT NULL AUTO_INCREMENT COMMENT '分类编号\r\n',
    `cat_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`cat_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fback
-- ----------------------------
DROP TABLE IF EXISTS `fback`;
CREATE TABLE `fback`
(
    `fback_id`       int                                                     NOT NULL AUTO_INCREMENT,
    `fback_title`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `fback_content`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `user_id`        int                                                     NOT NULL,
    `fback_datatime` datetime                                                NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`fback_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`
(
    `news_id`       int                                                     NOT NULL AUTO_INCREMENT,
    `news_title`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `news_content`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `news_datetime` datetime                                                NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`news_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`
(
    `prod_id`    int                                                     NOT NULL AUTO_INCREMENT,
    `cat_id`     int UNSIGNED NOT NULL,
    `prod_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `prod_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `prod_price` float(15, 2
) NOT NULL,
  `prod_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prod_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `prod_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `prod_firstshow` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`prod_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `user_id`       int                                                     NOT NULL AUTO_INCREMENT,
    `user_name`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `user_rname`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `user_pwd`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `user_email`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `user_company`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `user_tel`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `user_fax`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `user_datetime` datetime                                                NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    `user_right`    int                                                     NOT NULL DEFAULT 1,
    PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET
FOREIGN_KEY_CHECKS = 1;
