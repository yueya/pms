/*
Navicat MySQL Data Transfer

Source Server         : local2
Source Server Version : 50635
Source Host           : localhost:3308
Source Database       : pms

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-01-31 21:55:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_area
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) COLLATE utf8_bin NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `sort` int(11) NOT NULL COMMENT '排序',
  `code` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '区域编码',
  `type` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '区域类型',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`) USING BTREE,
  KEY `sys_area_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='区域表';

-- ----------------------------
-- Records of sys_area
-- ----------------------------
INSERT INTO `sys_area` VALUES ('1', '0', '0,', '中国', '10', '100000', '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_area` VALUES ('2', '1', '0,1,', '山东省', '20', '110000', '2', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_area` VALUES ('3', '2', '0,1,2,', '济南市', '30', '110101', '3', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_area` VALUES ('4', '3', '0,1,2,3,', '历城区', '40', '110102', '4', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_area` VALUES ('5', '3', '0,1,2,3,', '历下区', '50', '110104', '4', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_area` VALUES ('6', '3', '0,1,2,3,', '高新区', '60', '110105', '4', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(500) DEFAULT NULL COMMENT '字典名称',
  `code` varchar(255) DEFAULT NULL COMMENT '字典标识',
  `sort` int(11) DEFAULT NULL COMMENT '排序字段',
  `type` varchar(255) DEFAULT NULL COMMENT '字典类型',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '公司', 'compony', '0', 'org_type', '2019-01-13 22:18:35', '2019-01-13 22:18:37', '0');
INSERT INTO `sys_dict` VALUES ('2', '部门', 'department', '1', 'org_type', '2019-01-13 22:19:23', null, '0');
INSERT INTO `sys_dict` VALUES ('3', '小组', 'team', '2', 'org_type', '2019-01-13 22:20:07', null, null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `app_id` bigint(20) DEFAULT NULL COMMENT '系统id',
  `type` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '日志标题',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) COLLATE utf8_bin DEFAULT NULL COMMENT '操作方式',
  `params` text COLLATE utf8_bin COMMENT '操作提交的数据',
  `exception` text COLLATE utf8_bin COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`) USING BTREE,
  KEY `sys_log_request_uri` (`request_uri`) USING BTREE,
  KEY `sys_log_type` (`type`) USING BTREE,
  KEY `sys_log_create_date` (`create_date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('2', null, '1', null, null, '2019-01-07 16:17:32', '127.0.0.1', 'PostmanRuntime/7.4.0', '/a/index', 'POST', 0x757365726E616D653D79756579613B70617373776F72643D61646D696E3B, null);
INSERT INTO `sys_log` VALUES ('3', null, '1', null, null, '2019-01-07 16:20:55', '127.0.0.1', 'PostmanRuntime/7.4.0', '/a/index', 'POST', 0x757365726E616D653D79756579612670617373776F72643D61646D696E26, null);
INSERT INTO `sys_log` VALUES ('4', null, '1', null, 'yueya', '2019-01-07 16:23:59', '127.0.0.1', 'PostmanRuntime/7.4.0', '/a/index', 'POST', 0x757365726E616D653D79756579612670617373776F72643D61646D696E26, null);
INSERT INTO `sys_log` VALUES ('5', null, '1', null, 'yueya', '2019-01-12 17:36:06', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36', '/a/index;JSESSIONID=afd76f76-477b-4a78-bc5a-292884045b47', 'GET', '', null);
INSERT INTO `sys_log` VALUES ('6', null, '1', null, 'yueya', '2019-01-13 07:05:06', '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36', '/a/index;JSESSIONID=b6e4c570-f63d-4640-be46-2eee100be42a', 'GET', '', null);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` varchar(45) DEFAULT NULL,
  `parent_ids` varchar(1000) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '菜单类型',
  `tree_sort` int(11) DEFAULT NULL COMMENT '本组排序',
  `system_code` varchar(45) DEFAULT NULL COMMENT '所属系统标识',
  `all_sort` int(11) DEFAULT NULL COMMENT '才所有菜单中的排序',
  `href` varchar(1000) DEFAULT NULL COMMENT '链接',
  `target` varchar(45) DEFAULT NULL COMMENT '目标',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `color` varchar(45) DEFAULT NULL COMMENT '颜色',
  `weight` decimal(4,0) DEFAULT NULL COMMENT '权重',
  `useable` char(1) DEFAULT NULL COMMENT '是否可用',
  `remarks` varchar(500) DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `parent_id` varchar(255) DEFAULT NULL COMMENT '父级id',
  `parent_ids` varchar(255) DEFAULT NULL COMMENT '所有父级id',
  `area_id` bigint(20) DEFAULT NULL COMMENT '区域id',
  `type` char(1) DEFAULT NULL COMMENT '类型',
  `level` char(1) DEFAULT NULL COMMENT '级别',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `def_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `type` varchar(255) DEFAULT NULL COMMENT '权限类型',
  `identification` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `system_code` varchar(255) DEFAULT NULL COMMENT '所属系统标识',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序号',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `en_name` varchar(255) DEFAULT NULL COMMENT '角色英文名',
  `role_type` varchar(255) DEFAULT NULL COMMENT '角色类型',
  `sort` varchar(45) DEFAULT NULL COMMENT '排序号',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'super_admin', 'manage', '0', null, '2019-01-10 22:53:31', '2019-01-10 22:53:34', '0');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_org`;
CREATE TABLE `sys_role_org` (
  `role_id` bigint(20) NOT NULL,
  `org_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_org
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` bigint(11) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_system
-- ----------------------------
DROP TABLE IF EXISTS `sys_system`;
CREATE TABLE `sys_system` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '系统名称',
  `useable` char(1) DEFAULT NULL COMMENT '时候启用',
  `code` varchar(64) DEFAULT NULL COMMENT '系统标识码',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `def_flag` varchar(45) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_system
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_code` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '用户标识码',
  `organization_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '归属组织',
  `department_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '登录名',
  `password` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `user_no` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '工号',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `email` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '手机',
  `user_type` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '用户类型',
  `photo` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_flag` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '是否可登录',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_user_login_name` (`login_name`) USING BTREE,
  KEY `sys_user_del_flag` (`del_flag`) USING BTREE,
  KEY `sys_user_organization_id` (`organization_id`) USING BTREE,
  KEY `sys_user_department_id` (`department_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, '1', '2', 'yueya', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0001', '系统管理员', 'thinkgem@163.com', '8675', '8675', null, null, '192.168.13.235', '2018-01-30 11:52:24', '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', '最高管理员', '0');
INSERT INTO `sys_user` VALUES ('2', null, '1', '2', 'sd_admin', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0002', '管理员', null, null, null, null, null, null, null, '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('3', null, '1', '3', 'sd_zhb', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0003', '综合部', null, null, null, null, null, null, null, '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('4', null, '1', '4', 'sd_scb', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0004', '市场部', null, null, null, null, null, null, null, '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('5', null, '1', '5', 'sd_jsb', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0005', '技术部', null, null, null, null, null, null, null, '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('6', null, '1', '6', 'sd_yfb', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0006', '研发部', null, null, null, null, null, null, null, '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('7', null, '7', '8', 'jn_admin', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0007', '济南领导', null, null, null, null, null, null, null, '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('8', null, '7', '9', 'jn_zhb', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0008', '济南综合部', null, null, null, null, null, null, null, '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('9', null, '7', '10', 'jn_scb', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0009', '济南市场部', null, null, null, null, null, null, null, '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('10', null, '7', '11', 'jn_jsb', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0010', '济南技术部', null, null, null, null, null, null, null, '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('11', null, '12', '13', 'lc_admin', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', '0011', '济南历城领导', null, null, null, null, null, null, null, '1', '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('12', null, '12', '18', 'lx_admin', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', null, '济南历下领导', 'asddddddddd', null, null, null, null, null, null, null, '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_user` VALUES ('13', null, '22', '23', 'gx_admin', '0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7', null, '济南高新领导', 'asddddddddd', null, null, null, null, null, null, null, '2013-05-27 08:00:00', '2013-05-27 08:00:00', null, '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
