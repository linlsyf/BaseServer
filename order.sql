/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : order

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2019-11-02 19:26:38
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` text,
  `content` text,
  `email` text,
  `imgId` text,
  `title` text,
  `createTime` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='意见';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('eer', 'testcomter1', null, null, null, null);

-- ----------------------------
-- Table structure for `dict`
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dict
-- ----------------------------

-- ----------------------------
-- Table structure for `dicttype`
-- ----------------------------
DROP TABLE IF EXISTS `dicttype`;
CREATE TABLE `dicttype` (
  `typecode` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dicttype
-- ----------------------------

-- ----------------------------
-- Table structure for `favour`
-- ----------------------------
DROP TABLE IF EXISTS `favour`;
CREATE TABLE `favour` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `hint` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of favour
-- ----------------------------

-- ----------------------------
-- Table structure for `filelist`
-- ----------------------------
DROP TABLE IF EXISTS `filelist`;
CREATE TABLE `filelist` (
  `id` text,
  `refid` text,
  `filePath` text,
  `name` text,
  `creator` text,
  `createTime` date DEFAULT NULL,
  `path` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filelist
-- ----------------------------
INSERT INTO `filelist` VALUES ('7e24a8b2-fed6-41f5-a472-e3280704038b', '7112c29b-7791-4c84-b086-7ea9235a92a2', null, '7e24a8b2-fed6-41f5-a472-e3280704038b.png', null, null, null);
INSERT INTO `filelist` VALUES ('d4b4db84-c690-4dae-bbc6-b09dd3801fe3', 'ea5b2355-b196-4235-8904-190ba4bef76b', null, 'd4b4db84-c690-4dae-bbc6-b09dd3801fe3.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('2c88cc47-f2ce-4838-a970-79c197f476d5', 'c77fe8e1-c188-47bd-86ab-33c032bccc3d', null, '2c88cc47-f2ce-4838-a970-79c197f476d5.jpg', null, null, null);
INSERT INTO `filelist` VALUES ('62d7a707-a106-47d3-90e6-27c6c63ae5bb', '1d995081-af21-4e60-9160-1c311f6610b0', null, '62d7a707-a106-47d3-90e6-27c6c63ae5bb.jpg', null, null, null);

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` text CHARACTER SET utf8 NOT NULL,
  `name` text CHARACTER SET utf8,
  `imageId` text CHARACTER SET utf8,
  `creator` text,
  `colorName` text CHARACTER SET utf8,
  `colorNum` text CHARACTER SET utf8,
  `price` double DEFAULT NULL,
  `content` text CHARACTER SET utf8,
  `createTime` date DEFAULT NULL,
  `path` text,
  `status` text COMMENT '办理状态'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('7112c29b-7791-4c84-b086-7ea9235a92a2', 'huujju', '7e24a8b2-fed6-41f5-a472-e3280704038b', null, null, null, '0', null, '2018-04-03', null, '1');
INSERT INTO `goods` VALUES ('3a94f066-6130-4130-a0dd-86ea60d5968d', 'uuu', 'd4b4db84-c690-4dae-bbc6-b09dd3801fe3', null, null, null, '0', null, '2018-04-03', null, '1');
INSERT INTO `goods` VALUES ('ea5b2355-b196-4235-8904-190ba4bef76b', 'uuu', 'd4b4db84-c690-4dae-bbc6-b09dd3801fe3', null, null, null, '0', null, '2018-04-03', null, '1');
INSERT INTO `goods` VALUES ('c77fe8e1-c188-47bd-86ab-33c032bccc3d', 'dge', '2c88cc47-f2ce-4838-a970-79c197f476d5', null, null, null, '0', null, '2018-04-03', null, '1');
INSERT INTO `goods` VALUES ('1d995081-af21-4e60-9160-1c311f6610b0', '商品2', '62d7a707-a106-47d3-90e6-27c6c63ae5bb', null, null, null, '0', null, '2018-04-03', null, '1');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` text,
  `name` text,
  `code` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('admin', 'admin', '1');

-- ----------------------------
-- Table structure for `roleuser`
-- ----------------------------
DROP TABLE IF EXISTS `roleuser`;
CREATE TABLE `roleuser` (
  `id` text NOT NULL,
  `roleId` text,
  `roleName` text,
  `userName` text,
  `userId` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roleuser
-- ----------------------------
INSERT INTO `roleuser` VALUES ('admin', 'admin', 'admin', 'ldh', 'admin');

-- ----------------------------
-- Table structure for `shopcart`
-- ----------------------------
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart` (
  `id` text,
  `orderId` text,
  `createTime` text,
  `creator` text,
  `status` text,
  `userId` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcart
-- ----------------------------

-- ----------------------------
-- Table structure for `shoporder`
-- ----------------------------
DROP TABLE IF EXISTS `shoporder`;
CREATE TABLE `shoporder` (
  `id` text CHARACTER SET utf8 NOT NULL,
  `goodsId` text CHARACTER SET utf8,
  `type` text,
  `creator` text,
  `createTime` date DEFAULT NULL,
  `creatorId` text,
  `total` double DEFAULT NULL,
  `num` double DEFAULT NULL,
  `status` text COMMENT '办理状态'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shoporder
-- ----------------------------
INSERT INTO `shoporder` VALUES ('4a2b7b8e-547a-4abf-86b6-84135902bd6d', 'c77fe8e1-c188-47bd-86ab-33c032bccc3d', '1', 'admin', '2018-04-03', 'admin', '0', '0', '1');
INSERT INTO `shoporder` VALUES ('9c772e12-427c-493e-98f8-4ac1f08910ab', '1d995081-af21-4e60-9160-1c311f6610b0', '1', 'admin', '2018-04-03', 'admin', '0', '2', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) CHARACTER SET utf8 NOT NULL,
  `name` text CHARACTER SET utf8,
  `sex` text,
  `birthday` date DEFAULT NULL,
  `address` text,
  `registerId` text,
  `pwd` text NOT NULL,
  `loginId` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('a349881c-e8c4-4e0d-a9dd-bc9726e680c2', '然后给', null, null, null, null, 'a123456', '15217636960');
INSERT INTO `user` VALUES ('admin', 'admin', null, null, null, null, 'ldh', 'ldh');
INSERT INTO `user` VALUES ('qwer', '123', null, null, null, '15217636961', '123456', '123');
INSERT INTO `user` VALUES ('test1', 'test1', null, null, null, 'test1', '123', 'test1');
INSERT INTO `user` VALUES ('test2', 'test2', null, null, null, 'test2', '123', 'test2');
INSERT INTO `user` VALUES ('wet', '1', null, null, null, null, 'a', 'a');
INSERT INTO `user` VALUES ('王二娃4', '1', null, null, null, null, '1', '1');
