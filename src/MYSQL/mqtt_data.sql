/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : mqtt_data

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 27/06/2020 09:35:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lighton
-- ----------------------------
DROP TABLE IF EXISTS `lighton`;
CREATE TABLE `lighton`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `treet_number` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `light_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `acquisition_time` date NOT NULL,
  `light_intensity` int(255) NOT NULL,
  `turnonoff` int(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lighton
-- ----------------------------
INSERT INTO `lighton` VALUES (75, 'SCMY00001', 'MY00001', '2020-06-24', 350, 1);
INSERT INTO `lighton` VALUES (76, 'SCMY00001', 'MY00001', '2020-06-24', 350, 0);
INSERT INTO `lighton` VALUES (77, 'SCMY00001', 'MY00001', '2020-06-24', 350, 1);

-- ----------------------------
-- Table structure for mqtt_save
-- ----------------------------
DROP TABLE IF EXISTS `mqtt_save`;
CREATE TABLE `mqtt_save`  (
  `messageid` bigint(20) NOT NULL AUTO_INCREMENT,
  `topic` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Qos` int(10) NOT NULL,
  `message` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`messageid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mqtt_save
-- ----------------------------
INSERT INTO `mqtt_save` VALUES (15, 'sys/cloud/665544332211', 0, '{\"username\": \"wyt\",\"user_mac\":\"41703534\", \"sportcontents\": [{  \"create_time\":\"2019/11/12\",\"tmp\": \"36.6\",\"hr\":\"95\"},{ \"create_time\":\"2019/11/12\", \"tmp\": \"37.5\",\"hr\":\"80\"}]}\n');
INSERT INTO `mqtt_save` VALUES (16, 'sys/cloud/665544332211', 0, '{\"username\": \"wyt\",\"user_mac\":\"41703534\", \"sportcontents\": [{  \"create_time\":\"2019/11/12\",\"tmp\": \"36.6\",\"hr\":\"95\"},{ \"create_time\":\"2019/11/12\", \"tmp\": \"37.5\",\"hr\":\"80\"}]}\n');
INSERT INTO `mqtt_save` VALUES (17, 'sys/cloud/665544332211', 0, '{\"username\": \"wyt\",\"user_mac\":\"41703534\", \"sportcontents\": [{  \"create_time\":\"2019/11/12\",\"tmp\": \"36.6\",\"hr\":\"95\"},{ \"create_time\":\"2019/11/12\", \"tmp\": \"37.5\",\"hr\":\"80\"}]}\n');

-- ----------------------------
-- Table structure for sport_message
-- ----------------------------
DROP TABLE IF EXISTS `sport_message`;
CREATE TABLE `sport_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_mac` int(255) NOT NULL,
  `sportcontent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sportdata
-- ----------------------------
DROP TABLE IF EXISTS `sportdata`;
CREATE TABLE `sportdata`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_mac` int(255) NOT NULL,
  `createtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `temp` float(255, 0) NOT NULL,
  `hr` int(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sportdata
-- ----------------------------
INSERT INTO `sportdata` VALUES (12, 41703624, '2019/10/12', 37, 95);
INSERT INTO `sportdata` VALUES (13, 41703624, '2019/11/12', 37, 80);
INSERT INTO `sportdata` VALUES (14, 41703624, '2020/1/12', 37, 120);
INSERT INTO `sportdata` VALUES (15, 41703624, '2020/1/26', 37, 50);
INSERT INTO `sportdata` VALUES (16, 41703624, '2020/1/2', 37, 95);
INSERT INTO `sportdata` VALUES (17, 41703624, '2020/1/1', 37, 80);
INSERT INTO `sportdata` VALUES (18, 41703624, '2020/2/12', 37, 120);
INSERT INTO `sportdata` VALUES (19, 41703624, '2020/2/26', 37, 160);

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jobs` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES (1, 'wyt', '54', '4456456456456');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wyt', '123456');

SET FOREIGN_KEY_CHECKS = 1;
