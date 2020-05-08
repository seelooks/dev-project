/*
Navicat MySQL Data Transfer

Source Server         : local_root_see
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : dev_db

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-04-09 09:32:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `parent_id` varchar(32) NOT NULL COMMENT '父部门',
  `parent_ids` varchar(500) NOT NULL COMMENT '父ids，按层级逗号分隔',
  `name` varchar(100) NOT NULL COMMENT '部门名称',
  
  
  
  `sort` int(10) NOT NULL COMMENT '排序',
  `create_by` varchar(32) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(32) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `create_date` (`create_date`),
  KEY `create_by` (`create_by`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='组织机构';










