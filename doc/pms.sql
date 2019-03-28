-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: pms
-- ------------------------------------------------------
-- Server version	5.7.21-1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_area`
--

DROP TABLE IF EXISTS `sys_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_area` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) COLLATE utf8_bin NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `code` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '区域编码',
  `type` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '区域类型',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`) USING BTREE,
  KEY `sys_area_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='区域表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_area`
--

LOCK TABLES `sys_area` WRITE;
/*!40000 ALTER TABLE `sys_area` DISABLE KEYS */;
INSERT INTO `sys_area` VALUES (1,0,'0,','中国',8,'1000001','0','2013-05-27 08:00:00','2019-03-17 00:33:28',NULL,'0'),(2,1,'0,1,','山东省',20,'110000','2','2013-05-27 08:00:00','2013-05-27 08:00:00',NULL,'0'),(3,2,'0,1,2,','济南市',30,'110101','3','2013-05-27 08:00:00','2013-05-27 08:00:00',NULL,'0'),(4,3,'0,1,2,3,','历城区',40,'110102','4','2013-05-27 08:00:00','2013-05-27 08:00:00',NULL,'0'),(5,3,'0,1,2,3,','历下区',50,'110104','4','2013-05-27 08:00:00','2013-05-27 08:00:00',NULL,'0'),(6,3,'0,1,2,3,','高新区',60,'110105','4','2013-05-27 08:00:00','2013-05-27 08:00:00',NULL,'0'),(7,1,'0,1,','陕西省',1,'1231','1','2019-03-17 00:12:27','2019-03-17 00:19:38',NULL,'1'),(8,1,'0,1,','北京市',0,'2121',NULL,'2019-03-17 00:20:33',NULL,NULL,'0'),(9,1,'0,1,','美国',0,'122','0','2019-03-17 00:20:56','2019-03-17 00:21:01',NULL,'1');
/*!40000 ALTER TABLE `sys_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES (1,'公司','compony',0,'org_type','2019-01-13 22:18:35','2019-01-13 22:18:37','0'),(2,'部门','department',1,'org_type','2019-01-13 22:19:23',NULL,'0'),(3,'小组','team',2,'org_type','2019-01-13 22:20:07',NULL,NULL);
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `app_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '系统id',
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
) ENGINE=InnoDB AUTO_INCREMENT=6799 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` varchar(45) DEFAULT NULL,
  `parent_ids` varchar(1000) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '菜单类型',
  `sort` int(11) DEFAULT '0' COMMENT '本组排序',
  `system_code` varchar(45) DEFAULT NULL COMMENT '所属系统标识',
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
  `permission` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (2,'菜单管理',NULL,NULL,'menu',2,'pms_sys','/menu',NULL,'transfer-right',NULL,NULL,'0',NULL,NULL,'2019-03-27 01:36:27','0',''),(5,'模块管理',NULL,NULL,'menu',1,'pms_sys',' /system',NULL,'home2',NULL,NULL,'0',NULL,NULL,'2019-03-27 20:45:35','0',NULL),(6,'用户管理',NULL,NULL,'menu',1,'pms_sys',NULL,NULL,'link',NULL,NULL,'0',NULL,NULL,'2019-03-27 00:51:36','0',NULL),(7,'区域管理',NULL,NULL,'menu',3,'pms_sys',NULL,NULL,'link',NULL,NULL,'0',NULL,NULL,'2019-03-27 00:51:45','0',NULL),(8,'角色管理',NULL,NULL,'menu',4,'pms_sys',NULL,NULL,'link',NULL,NULL,'0',NULL,NULL,'2019-03-27 00:51:51','0',NULL),(9,'机构管理',NULL,NULL,'menu',5,'pms_sys',NULL,NULL,'link',NULL,NULL,'0',NULL,NULL,'2019-03-27 00:51:57','0',NULL),(10,'系统监控',NULL,NULL,'menu',6,'pms_sys',NULL,NULL,'link',NULL,NULL,'0',NULL,NULL,'2019-03-27 00:52:02','0',NULL),(11,'字典管理',NULL,NULL,'menu',7,'pms_sys',NULL,NULL,'link',NULL,NULL,'0',NULL,NULL,'2019-03-27 00:52:08','0',NULL),(14,'菜单列表','2',',2,','menu',1,'pms_sys','/menutable',NULL,'link',NULL,NULL,'0',NULL,NULL,'2019-03-22 15:19:13','0',NULL),(16,'文章管理',NULL,NULL,NULL,0,'cms',NULL,NULL,NULL,NULL,NULL,'0',NULL,NULL,'2019-03-17 00:52:51','0',NULL),(21,'菜单编辑','2',',2,',NULL,1,'pms_sys','1',NULL,'link',NULL,NULL,'1',NULL,'2019-03-14 00:48:36','2019-03-14 01:30:04','1',NULL),(22,'asd','21',',2,21,',NULL,1,'pms_sys','asd',NULL,'asd',NULL,NULL,'1',NULL,'2019-03-14 00:54:30','2019-03-14 01:30:04','1',NULL),(23,'模块列表','5',',5,','menu',0,'pms_sys','/systemtable',NULL,'link',NULL,NULL,'0',NULL,'2019-03-15 00:02:47','2019-03-22 15:19:24','0',NULL),(24,'用户列表','6',',6,','button',0,'pms_sys','/usertable',NULL,'linnk',NULL,NULL,'0',NULL,'2019-03-15 15:55:25','2019-03-27 23:29:48','0',NULL),(25,'区域列表','7',',7,',NULL,0,'pms_sys','areatable',NULL,'link',NULL,NULL,'0',NULL,'2019-03-15 18:09:17','2019-03-22 15:19:43','0',NULL),(26,'机构列表','9',',9,',NULL,0,'pms_sys','/orgtable',NULL,'link',NULL,NULL,'0',NULL,'2019-03-19 18:28:00','2019-03-22 10:36:34','0',NULL),(27,'角色列表','8',',8,',NULL,0,'pms_sys','/roletable',NULL,'link',NULL,NULL,'0',NULL,'2019-03-20 16:04:39','2019-03-22 15:19:52','0',NULL),(28,'日志管理',NULL,NULL,'menu',8,'pms_sys',NULL,NULL,'align-flex',NULL,NULL,'0',NULL,'2019-03-23 14:03:39','2019-03-27 00:52:10','0',NULL),(29,'日志列表','28',',28,',NULL,0,'pms_sys','/logtable',NULL,'link',NULL,NULL,'0',NULL,'2019-03-23 14:04:04','2019-03-26 13:13:07','0','user:admin'),(30,'在线用户','10',',10,',NULL,0,'pms_sys','/sessiontable',NULL,'link',NULL,NULL,'0',NULL,'2019-03-25 19:03:56','2019-03-25 22:17:14','0',NULL),(31,'服务监控','10',',10,',NULL,0,'pms_sys',NULL,NULL,NULL,NULL,NULL,'1',NULL,'2019-03-25 19:17:05','2019-03-25 19:17:17','0',NULL),(32,'字典列表','11',',11,','menu',1,'pms_sys','/dicttable',NULL,'link',NULL,NULL,'0',NULL,'2019-03-25 19:41:42','2019-03-25 19:43:09','0',NULL),(33,'首页',NULL,NULL,'menu',0,'pms_sys','/dashboard/monitor',NULL,'home2',NULL,NULL,'0',NULL,'2019-03-27 20:35:31','2019-03-27 20:38:01','0',NULL);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_organization`
--

DROP TABLE IF EXISTS `sys_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_organization`
--

LOCK TABLES `sys_organization` WRITE;
/*!40000 ALTER TABLE `sys_organization` DISABLE KEYS */;
INSERT INTO `sys_organization` VALUES (1,'北京总公司',NULL,NULL,8,'0',NULL,'2019-03-22 14:43:06',NULL,'0'),(2,'技术部','1',',1,',8,'1',NULL,'2019-03-23 21:40:48',NULL,'0');
/*!40000 ALTER TABLE `sys_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'超级管理员','super_admin','0','0',NULL,'2019-01-10 08:00:00','2019-03-21 15:32:57','0'),(2,'公司管理员','admin',NULL,NULL,NULL,'2019-03-21 15:17:27',NULL,'1'),(3,'公司管理员','company_manager',NULL,NULL,NULL,'2019-03-21 15:33:40',NULL,'1'),(4,'公司管理员','compony_manage','1',NULL,NULL,'2019-03-21 08:00:00','2019-03-21 15:37:20','0'),(5,'12','122','1',NULL,NULL,'2019-03-21 15:38:06',NULL,'1');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (126,14,1),(127,2,1),(128,32,1),(129,11,1),(130,30,1),(131,31,1),(132,10,1),(133,26,1),(134,9,1),(135,27,1),(136,8,1),(137,25,1),(138,7,1),(139,24,1),(140,6,1),(141,23,1),(142,5,1),(143,29,1),(144,28,1),(145,33,1);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_org`
--

DROP TABLE IF EXISTS `sys_role_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_org` (
  `role_id` bigint(20) NOT NULL,
  `org_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_org`
--

LOCK TABLES `sys_role_org` WRITE;
/*!40000 ALTER TABLE `sys_role_org` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_system`
--

DROP TABLE IF EXISTS `sys_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_system` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '系统名称',
  `useable` char(1) DEFAULT NULL COMMENT '时候启用',
  `code` varchar(64) DEFAULT NULL COMMENT '系统标识码',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `def_flag` varchar(45) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_system`
--

LOCK TABLES `sys_system` WRITE;
/*!40000 ALTER TABLE `sys_system` DISABLE KEYS */;
INSERT INTO `sys_system` VALUES (1,'权限管理系统','1','pms_sys',NULL,NULL,'0'),(2,'CMS系统','1','cms',NULL,'2019-03-15 15:31:20','0'),(3,'测试系统','1','asda','2019-03-15 15:09:57','2019-03-15 15:13:52','1'),(4,'qwe',NULL,NULL,'2019-03-20 18:21:42','2019-03-20 18:24:28','1');
/*!40000 ALTER TABLE `sys_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_user_login_name` (`login_name`) USING BTREE,
  KEY `sys_user_del_flag` (`del_flag`) USING BTREE,
  KEY `sys_user_organization_id` (`organization_id`) USING BTREE,
  KEY `sys_user_department_id` (`department_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'asdafdf4235rwfsdfsdfsdf','1','2','super_admin','bc2e5b801bca91685ea176c096dc2420a162bfeca1dc6675817b5c07','0001','系统管理员','yueyaka@foxmail.com','8675','8675',NULL,NULL,'192.168.13.235','2018-01-30 08:00:00','1','2013-05-27 08:00:00','2019-03-23 21:44:13','最高管理员','0'),(2,'asdtyjdf893rw9efhndkosj','1','2','admin','0b20c3a122a412e220115e706d224cc583d786d91e635e936b1b1bb7','0002','管理员',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','2013-05-27 08:00:00','2013-05-27 08:00:00',NULL,'0');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (8,4,4),(11,2,1),(12,5,4),(13,1,1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-29  0:33:08
