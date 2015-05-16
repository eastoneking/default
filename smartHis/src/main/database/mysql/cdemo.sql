/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : oadeve

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2014-05-21 17:14:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cdemo`
-- ----------------------------
DROP TABLE IF EXISTS `cdemo`;
CREATE TABLE `cdemo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `number_property` int(11) DEFAULT NULL COMMENT '数字属性',
  `string_property` varchar(20) DEFAULT NULL COMMENT '字符属性',
  `date_property` timestamp DEFAULT NULL COMMENT '日期属性',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cdemo
-- ----------------------------
INSERT INTO `cdemo` VALUES ('1', '名称11', '11', '字符11', null, '备注11');
INSERT INTO `cdemo` VALUES ('2', '名称2', '2', '字符2', null, '备注');
INSERT INTO `cdemo` VALUES ('4', '3', '3', '3', null, '3');
INSERT INTO `cdemo` VALUES ('5', '4', '4', '4', null, '4');
INSERT INTO `cdemo` VALUES ('6', '5', '5', '5', null, '5');
INSERT INTO `cdemo` VALUES ('7', '6', '6', '6', null, '6');
