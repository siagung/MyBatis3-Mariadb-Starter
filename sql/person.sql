/*
 Navicat Premium Data Transfer

 Source Server         : SSL
 Source Server Type    : MariaDB
 Source Server Version : 100430 (10.4.30-MariaDB-log)
 Source Host           : localhost:3306
 Source Schema         : db_wgssl_06122023

 Target Server Type    : MariaDB
 Target Server Version : 100430 (10.4.30-MariaDB-log)
 File Encoding         : 65001

 Date: 10/01/2024 16:49:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` int(11) NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birth_date` date NOT NULL,
  `employed` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `occupation` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (1, 'agung s', 'susanto', '2023-12-13', '1', 'suami', 1);
INSERT INTO `person` VALUES (2, 'Dina', 'Wulansari', '2023-12-12', '2', 'istri', 1);

SET FOREIGN_KEY_CHECKS = 1;
