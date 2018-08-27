/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : i-mr

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-27 16:05:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '用户ID',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `age` int(3) DEFAULT NULL COMMENT '用户年龄',
  `ctime` datetime DEFAULT NULL COMMENT '自定义填充的创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('784972358981328902', '数据库1', '18', '2017-06-25 20:53:33');
INSERT INTO `sys_user` VALUES ('784972358981328903', '数据库1', '18', '2017-06-25 20:53:37');
INSERT INTO `sys_user` VALUES ('903440198509277186', '数据库1', '18', '2017-09-01 10:11:42');
INSERT INTO `sys_user` VALUES ('903441652087271426', '数据库1', '18', '2017-09-01 10:17:29');
INSERT INTO `sys_user` VALUES ('903441884564959234', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885001166849', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885005361154', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885005361155', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885009555458', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885013749761', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885013749762', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885017944066', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885017944067', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885022138370', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885022138371', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885026332673', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885026332674', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885026332675', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885026332676', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885034721282', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885038915586', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885043109889', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885047304193', '数据库1', '18', '2017-09-01 10:18:24');
INSERT INTO `sys_user` VALUES ('903441885047304194', '数据库1', '18', '2017-09-01 10:18:24');
