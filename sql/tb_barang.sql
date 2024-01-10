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

 Date: 10/01/2024 16:50:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_barang
-- ----------------------------
DROP TABLE IF EXISTS `tb_barang`;
CREATE TABLE `tb_barang`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cbarang` char(4) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `vnama_barang` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `banalisa` tinyint(1) NULL DEFAULT 0,
  `breduct` tinyint(1) NULL DEFAULT 0,
  `breg` tinyint(1) NULL DEFAULT 0,
  `baktif` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 38 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_barang
-- ----------------------------
INSERT INTO `tb_barang` VALUES (1, '001', 'Produk 001', 0, 0, 0, 1);
INSERT INTO `tb_barang` VALUES (2, '002', 'Produk 002', 0, 0, 0, 1);
INSERT INTO `tb_barang` VALUES (3, '003', 'Produk 003', 0, 0, 0, 1);
INSERT INTO `tb_barang` VALUES (4, '004', 'Produk 004', 0, 0, 0, 1);
INSERT INTO `tb_barang` VALUES (5, '005', 'Produk 005', 0, 0, 0, 1);
INSERT INTO `tb_barang` VALUES (6, '006', 'Produk 006', 0, 0, 0, 1);
INSERT INTO `tb_barang` VALUES (7, '007', 'Produk 007', 0, 0, 0, 1);
INSERT INTO `tb_barang` VALUES (8, '008', 'Produk 008', 0, 0, 0, 1);
INSERT INTO `tb_barang` VALUES (9, '009', 'Produk 009', 0, 0, 0, 1);
INSERT INTO `tb_barang` VALUES (10, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (11, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (12, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (13, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (14, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (15, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (16, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (17, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (18, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (19, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (20, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (21, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (22, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (23, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (24, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (25, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (26, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (27, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (28, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (29, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (30, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (31, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (32, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (33, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (34, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (35, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (36, '010', 'Produk 010', 0, 0, 0, 0);
INSERT INTO `tb_barang` VALUES (37, '010', 'Produk 010', 0, 0, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
