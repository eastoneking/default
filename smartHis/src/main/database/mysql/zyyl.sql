/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : zyyl

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-01-12 08:48:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for document_code
-- ----------------------------
DROP TABLE IF EXISTS `document_code`;
CREATE TABLE `document_code` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `code_pattern` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `code_year` int(11) DEFAULT NULL,
  `RUNNING_NUMBER_COUNT` int(11) DEFAULT NULL,
  `CURRENT_RUNNING_NUMBER` int(11) DEFAULT NULL,
  `usage_dept` int(11) DEFAULT NULL,
  `is_red` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of document_code
-- ----------------------------

-- ----------------------------
-- Table structure for filemodel
-- ----------------------------
DROP TABLE IF EXISTS `filemodel`;
CREATE TABLE `filemodel` (
  `id` int(20) DEFAULT NULL,
  `file_path` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '文件路径',
  `file_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '文件名字',
  `file_imp_time` date DEFAULT NULL COMMENT '文件上传时间',
  `file_imp_personNo` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '文件上传人员工号',
  `file_imp_person` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '文件上传人姓名',
  `file_title` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '文件标题',
  `file_num` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '文件编号',
  `file_deptname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `file_deptid` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `file_deptnum` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `file_flag` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '模板状态 0 正常 1 废弃 2 删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of filemodel
-- ----------------------------

-- ----------------------------
-- Table structure for fileupload
-- ----------------------------
DROP TABLE IF EXISTS `fileupload`;
CREATE TABLE `fileupload` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file` blob,
  `oldfileName` varchar(200) DEFAULT NULL,
  `currentfilepathName` varchar(300) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `tableName` varchar(200) DEFAULT NULL,
  `fkid` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fileupload
-- ----------------------------

-- ----------------------------
-- Table structure for sys1_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys1_dept`;
CREATE TABLE `sys1_dept` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys1_dept
-- ----------------------------
INSERT INTO `sys1_dept` VALUES ('1', '金佳币', '0', null, '1');
INSERT INTO `sys1_dept` VALUES ('2', '外部用户', '0', null, '2');
INSERT INTO `sys1_dept` VALUES ('4', 'IT', '0', null, '2');

-- ----------------------------
-- Table structure for sys1_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys1_permission`;
CREATE TABLE `sys1_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `permission` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys1_permission
-- ----------------------------
INSERT INTO `sys1_permission` VALUES ('45', '系统管理', 'SYSTEM', '0', null, '1');
INSERT INTO `sys1_permission` VALUES ('46', '用户管理', 'YHGL', '0', '45', '2');
INSERT INTO `sys1_permission` VALUES ('47', '权限管理', 'QXGL', '0', '45', '3');
INSERT INTO `sys1_permission` VALUES ('49', '角色管理', 'JSGL', '0', '45', '5');
INSERT INTO `sys1_permission` VALUES ('50', '系统菜单', 'SYS_CD', '0', '45', '6');
INSERT INTO `sys1_permission` VALUES ('51', '系统参数', 'SYS_CS', '0', '45', '7');
INSERT INTO `sys1_permission` VALUES ('67', '挂号管理', 'YLGL', '0', null, '3');
INSERT INTO `sys1_permission` VALUES ('68', '初始挂号', 'GHGL', '0', '67', '1');
INSERT INTO `sys1_permission` VALUES ('69', '药局管理', 'YJGL', '0', null, '4');
INSERT INTO `sys1_permission` VALUES ('70', '医生看病', 'YSKB', '0', null, '5');
INSERT INTO `sys1_permission` VALUES ('71', '药品入库', 'YPCK_RK', '0', '69', '1');
INSERT INTO `sys1_permission` VALUES ('72', '医生开药', 'YSKY', '0', '70', '1');
INSERT INTO `sys1_permission` VALUES ('73', '收费管理', 'SFGL', '0', '67', '2');
INSERT INTO `sys1_permission` VALUES ('74', '药品出库', 'YPCK_CK', '0', '69', '2');
INSERT INTO `sys1_permission` VALUES ('75', '医疗系统', 'YLSYS', '0', null, '6');
INSERT INTO `sys1_permission` VALUES ('76', '科室管理', 'KSWH', '0', '75', '1');
INSERT INTO `sys1_permission` VALUES ('77', '药品类别', 'YPLB', '0', '75', '2');
INSERT INTO `sys1_permission` VALUES ('78', '药品编码', 'YPBM', '0', '75', '3');
INSERT INTO `sys1_permission` VALUES ('79', '药品库存', 'YPCK', '0', '69', '3');
INSERT INTO `sys1_permission` VALUES ('80', '综合查询', 'ZHCX', '0', null, '7');
INSERT INTO `sys1_permission` VALUES ('81', '药品出库查询', 'YPCKCX', '0', '80', '0');
INSERT INTO `sys1_permission` VALUES ('82', '挂号收费查询', 'GHSFCX', '0', '80', '1');
INSERT INTO `sys1_permission` VALUES ('83', '医生开药查询', 'YSKYCX', '0', '80', '3');
INSERT INTO `sys1_permission` VALUES ('84', '挂号记录查询', 'GHJLCX', '0', '80', '2');
INSERT INTO `sys1_permission` VALUES ('85', '编码规则', 'BMGZ', '0', '75', '4');
INSERT INTO `sys1_permission` VALUES ('87', '药品利润', 'YPLR', '0', '69', '4');
INSERT INTO `sys1_permission` VALUES ('88', '医生利润', 'YSLR', '0', '70', '2');

-- ----------------------------
-- Table structure for sys1_role
-- ----------------------------
DROP TABLE IF EXISTS `sys1_role`;
CREATE TABLE `sys1_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys1_role
-- ----------------------------
INSERT INTO `sys1_role` VALUES ('1', '管理员');
INSERT INTO `sys1_role` VALUES ('2', '外网用户');
INSERT INTO `sys1_role` VALUES ('13', '超级管理员');
INSERT INTO `sys1_role` VALUES ('14', '药局');
INSERT INTO `sys1_role` VALUES ('15', '挂号');
INSERT INTO `sys1_role` VALUES ('16', '医生');

-- ----------------------------
-- Table structure for sys1_user
-- ----------------------------
DROP TABLE IF EXISTS `sys1_user`;
CREATE TABLE `sys1_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `display_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `phone_number` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `note` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `salt` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys1_user
-- ----------------------------
INSERT INTO `sys1_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '超级管理员', '1', '18341913136', '123456@qq.com', '', null, null, '2014-12-17 14:44:16', null);
INSERT INTO `sys1_user` VALUES ('2', 'zhang', 'e10adc3949ba59abbe56e057f20f883e', 'ewww', '0', '13101020304', '', '', null, null, '2014-12-17 14:42:30', '1');
INSERT INTO `sys1_user` VALUES ('3', '123456', 'e10adc3949ba59abbe56e057f20f883e', 'dfdfff', '0', '13101020304', '', '', null, null, '2014-12-17 14:49:57', '1');
INSERT INTO `sys1_user` VALUES ('4', '1111', 'e10adc3949ba59abbe56e057f20f883e', 'abc', '0', '13101020304', '111@ee.cc', '1', null, null, '2014-12-17 14:50:54', '2');
INSERT INTO `sys1_user` VALUES ('5', 'yaoju', 'e10adc3949ba59abbe56e057f20f883e', '药局', '0', '13001020304', '', '', null, null, '2014-12-29 10:24:16', '14');
INSERT INTO `sys1_user` VALUES ('6', 'guahao', 'e10adc3949ba59abbe56e057f20f883e', '挂号', '0', '13001020304', '', '', null, null, '2014-12-29 15:23:03', null);
INSERT INTO `sys1_user` VALUES ('7', 'yisheng', 'e10adc3949ba59abbe56e057f20f883e', '医生', '0', '13001020304', '', '', null, null, '2014-12-29 10:25:24', '16');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_code` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '部门编码',
  `dept_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '部门名称',
  `dept_level` int(11) DEFAULT NULL COMMENT '部门级别',
  `dept_person` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '部门负责人',
  `virtual` char(2) COLLATE utf8_bin DEFAULT NULL COMMENT '是否虚拟（Y/N）',
  `up_dept` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '上级部门',
  `address` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '通讯地址',
  `postal_code` int(10) DEFAULT NULL COMMENT '邮政编码',
  `tel` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '部门电话',
  `fax` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '传真',
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `dept_duty` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '部门职责',
  `organization_id` int(11) NOT NULL DEFAULT '0' COMMENT '上级组织ID',
  `enable_flag` char(1) COLLATE utf8_bin NOT NULL,
  `dept_create_time` datetime DEFAULT NULL,
  `create_user` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `create_timestamp` datetime NOT NULL,
  `last_update_user` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `last_update_timestamp` datetime DEFAULT NULL,
  `last_update_remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hr_fk_sysdept` (`organization_id`) USING BTREE,
  CONSTRAINT `sys_dept_ibfk_1` FOREIGN KEY (`organization_id`) REFERENCES `sys_organization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `user_code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `user_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `oper_behavior` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `oper_timestamp` datetime NOT NULL,
  `oper_ip` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `type` char(5) COLLATE utf8_bin DEFAULT NULL COMMENT '用于分别各个操作',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='此处记录日志，不应与其他表关联，因此里面的字段如单位名称直接存储名称为不是id';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log_new
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_new`;
CREATE TABLE `sys_log_new` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_id` int(11) NOT NULL COMMENT '用户所在部门ID',
  `unit_name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '用户所在部门名称',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `user_code` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户编码',
  `user_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户名称',
  `modul_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '操作的模块名称',
  `oper_behavior` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '操作行为',
  `oper_timestamp` datetime NOT NULL COMMENT '操作时间',
  `oper_ip` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '所在IP地址',
  `type` char(5) COLLATE utf8_bin DEFAULT NULL COMMENT '用于分别各个操作',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='此处记录日志，不应与其他表关联，因此里面的字段如单位名称直接存储名称为不是id';

-- ----------------------------
-- Records of sys_log_new
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `icon` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '', '45', '0', null, '15', 'icon-setup');
INSERT INTO `sys_menu` VALUES ('2', '系统菜单', 'sysMenu/sysMenuList', '50', '0', '1', '20', 'icon-weixiu');
INSERT INTO `sys_menu` VALUES ('36', '用户管理', 'system/sysUser/sysUserList', '46', '0', '1', '16', '');
INSERT INTO `sys_menu` VALUES ('37', '角色管理', 'system/sysRole/sysRoleList', '49', '0', '1', '17', '');
INSERT INTO `sys_menu` VALUES ('38', '权限管理', 'system/sysPermission/sysPermissionList', '47', '0', '1', '18', '');
INSERT INTO `sys_menu` VALUES ('40', '系统参数', 'system/sysParameter/sysParameterList', '51', '0', '1', '21', '');
INSERT INTO `sys_menu` VALUES ('91', '挂号管理', '', '67', '0', null, '2', null);
INSERT INTO `sys_menu` VALUES ('92', '门诊挂号', 'guahao\\guahaoguanli\\guahaoList', '68', '0', '91', '1', null);
INSERT INTO `sys_menu` VALUES ('93', '收费管理', 'guahao\\shoufeiguanli\\shoufeiList', '73', '0', '91', '2', null);
INSERT INTO `sys_menu` VALUES ('94', '药局管理', '', '69', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('95', '药品入库', 'yaoju\\yaopinruku\\rukuList', '71', '0', '94', '1', null);
INSERT INTO `sys_menu` VALUES ('96', '药品出库', 'yaoju\\yaopinchuku\\chukuList', '74', '0', '94', '2', null);
INSERT INTO `sys_menu` VALUES ('97', '医生看病', '', '70', '0', null, '3', null);
INSERT INTO `sys_menu` VALUES ('98', '医生诊病', 'yisheng\\zhenduan\\zhenduanList', '72', null, '97', '1', null);
INSERT INTO `sys_menu` VALUES ('99', '医疗系统', '', '75', '0', null, '4', null);
INSERT INTO `sys_menu` VALUES ('100', '科室管理', 'keshi\\keshiweihu\\keshiList', '76', '0', '99', '1', null);
INSERT INTO `sys_menu` VALUES ('101', '药品类别', 'ypsys\\yaopinleibie\\leibieList', '77', '0', '99', '2', null);
INSERT INTO `sys_menu` VALUES ('102', '药品编码', 'ypsys\\yaopinbianma\\bianmaList', '78', '0', '99', '3', null);
INSERT INTO `sys_menu` VALUES ('103', '药品库存', 'yaoju\\dangqiankucun\\kucunList', '79', '0', '94', '3', null);
INSERT INTO `sys_menu` VALUES ('104', '综合查询', '', '80', '0', null, '5', null);
INSERT INTO `sys_menu` VALUES ('105', '药品出库查询', 'zonghechaxun\\kucun\\chukuqueryList', '81', '0', '104', '0', null);
INSERT INTO `sys_menu` VALUES ('106', '挂号收费查询', 'zonghechaxun\\guahao\\shoufeiList', '82', '0', '104', '1', null);
INSERT INTO `sys_menu` VALUES ('107', '医生开药查询', 'zonghechaxun\\yisheng\\kaiyaoList', '83', '0', '104', '3', null);
INSERT INTO `sys_menu` VALUES ('108', '挂号记录查询', 'zonghechaxun/guahao/guahaoList', '84', '0', '104', '2', null);
INSERT INTO `sys_menu` VALUES ('109', '编码规则', '', '85', '0', '99', '4', null);
INSERT INTO `sys_menu` VALUES ('110', '药品利润', 'yaoju\\lirun\\lirunList', '87', '0', '94', '4', null);
INSERT INTO `sys_menu` VALUES ('111', '医生利润', 'yisheng\\lirun\\lirunList', '88', null, '97', '2', null);

-- ----------------------------
-- Table structure for sys_modules
-- ----------------------------
DROP TABLE IF EXISTS `sys_modules`;
CREATE TABLE `sys_modules` (
  `modules_id` int(11) NOT NULL,
  `modules_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_userid` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_userid` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `enable_flag` char(1) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`modules_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_modules
-- ----------------------------

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '组织名称',
  `organization_level` int(11) NOT NULL COMMENT '组织级别',
  `p_organization_id` int(11) DEFAULT NULL COMMENT '上级架构',
  `legal_person` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '法定代表人',
  `organization_person` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '组织负责人',
  `organization_code` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '组织编码',
  `address` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '登记注册地区地址',
  `contact_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `postal_code` int(10) DEFAULT NULL COMMENT '邮政编码',
  `fax` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '传真',
  `phone` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `company_profile` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '公司简介',
  `remark` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `enable_flag` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '标记该记录的启用状态1：正常，0：禁用（已删除）',
  `create_user` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_timestamp` datetime NOT NULL COMMENT '创建时间',
  `last_update_user` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '最后修改人',
  `last_update_timestamp` datetime DEFAULT NULL COMMENT '最后修改时间',
  `last_update_remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '最后修改备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='组织架构表 ';

-- ----------------------------
-- Records of sys_organization
-- ----------------------------

-- ----------------------------
-- Table structure for sys_parameter
-- ----------------------------
DROP TABLE IF EXISTS `sys_parameter`;
CREATE TABLE `sys_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `type_code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `value` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_parameter
-- ----------------------------
INSERT INTO `sys_parameter` VALUES ('1', '状态', 'STATUS', '可用', '0', '0', '0', '1');
INSERT INTO `sys_parameter` VALUES ('2', '状态', 'STATUS', '不可用', '1', '0', '0', '2');
INSERT INTO `sys_parameter` VALUES ('5', '性别', 'SEX', '男', '0', '0', '0', '1');
INSERT INTO `sys_parameter` VALUES ('6', '性别', 'SEX', '女', '1', '0', '0', '2');
INSERT INTO `sys_parameter` VALUES ('7', '判断', 'JUDGE', '否', '0', '0', '0', '1');
INSERT INTO `sys_parameter` VALUES ('8', '判断', 'JUDGE', '是', '1', '0', '0', '2');
INSERT INTO `sys_parameter` VALUES ('77', '挂号类别', 'GHLB', '普通号', '0', '0', null, '0');
INSERT INTO `sys_parameter` VALUES ('78', '挂号类别', 'GHLB', '专家号', '1', '0', null, '1');
INSERT INTO `sys_parameter` VALUES ('79', '挂号状态', 'GHZT', '已挂号', '0', '0', null, '0');
INSERT INTO `sys_parameter` VALUES ('80', '挂号状态', 'GHZT', '已诊断', '1', '0', null, '1');
INSERT INTO `sys_parameter` VALUES ('81', '挂号状态', 'GHZT', '已收款', '2', '0', null, '2');
INSERT INTO `sys_parameter` VALUES ('82', '挂号状态', 'GHZT', '已取药', '3', '0', null, '3');
INSERT INTO `sys_parameter` VALUES ('83', '诊断状态', 'ZDZT', '未收款', '0', '0', null, '0');
INSERT INTO `sys_parameter` VALUES ('84', '诊断状态', 'ZDZT', '已收款', '1', '0', null, '1');
INSERT INTO `sys_parameter` VALUES ('85', '付药状态', 'FYZT', '已付药', '1', null, null, '1');
INSERT INTO `sys_parameter` VALUES ('86', '付药状态', 'FYZT', '未付药', '0', null, null, '0');

-- ----------------------------
-- Table structure for sys_personnel
-- ----------------------------
DROP TABLE IF EXISTS `sys_personnel`;
CREATE TABLE `sys_personnel` (
  `personnel_id` int(11) NOT NULL,
  `personnel_code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `personnel_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `personnel_identityCode` varchar(18) COLLATE utf8_bin DEFAULT NULL,
  `personnel_enableFlag` char(1) COLLATE utf8_bin DEFAULT NULL,
  `personnel_emial` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `personnel_state` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`personnel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_personnel
-- ----------------------------

-- ----------------------------
-- Table structure for sys_personnel_role_concern
-- ----------------------------
DROP TABLE IF EXISTS `sys_personnel_role_concern`;
CREATE TABLE `sys_personnel_role_concern` (
  `personnel_role_concern_id` int(11) NOT NULL,
  `personnel_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_userid` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_userid` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `enable_flag` char(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`personnel_role_concern_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_personnel_role_concern
-- ----------------------------

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_code` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '职务编号',
  `post_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '职务名称',
  `post_level` int(3) DEFAULT NULL COMMENT '职务等级',
  `remark` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `status` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '启用、禁用',
  `enable_flag` char(1) COLLATE utf8_bin NOT NULL,
  `create_user` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `create_timestamp` datetime NOT NULL,
  `last_update_user` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `last_update_timestamp` datetime DEFAULT NULL,
  `last_update_remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `post_create_time` datetime DEFAULT NULL,
  `organization_id` int(11) DEFAULT NULL COMMENT '所属组织ID',
  `dept_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '职务上级组织 ——部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='职务表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `enable_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '1' COMMENT '标记该记录的启用状态1：正常，0：禁用（已删除）',
  `create_user` varchar(50) COLLATE utf8_bin NOT NULL,
  `create_timestamp` datetime NOT NULL,
  `last_update_user` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `last_update_timestamp` datetime DEFAULT NULL,
  `last_update_remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色 权限 表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1422 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1191', '1', '45');
INSERT INTO `sys_role_permission` VALUES ('1192', '1', '46');
INSERT INTO `sys_role_permission` VALUES ('1193', '1', '47');
INSERT INTO `sys_role_permission` VALUES ('1194', '1', '49');
INSERT INTO `sys_role_permission` VALUES ('1195', '1', '50');
INSERT INTO `sys_role_permission` VALUES ('1196', '1', '51');
INSERT INTO `sys_role_permission` VALUES ('1197', '1', '67');
INSERT INTO `sys_role_permission` VALUES ('1198', '1', '68');
INSERT INTO `sys_role_permission` VALUES ('1199', '1', '73');
INSERT INTO `sys_role_permission` VALUES ('1200', '1', '69');
INSERT INTO `sys_role_permission` VALUES ('1201', '1', '71');
INSERT INTO `sys_role_permission` VALUES ('1202', '1', '74');
INSERT INTO `sys_role_permission` VALUES ('1203', '1', '70');
INSERT INTO `sys_role_permission` VALUES ('1204', '1', '72');
INSERT INTO `sys_role_permission` VALUES ('1205', '1', '75');
INSERT INTO `sys_role_permission` VALUES ('1206', '1', '76');
INSERT INTO `sys_role_permission` VALUES ('1207', '1', '77');
INSERT INTO `sys_role_permission` VALUES ('1208', '1', '78');
INSERT INTO `sys_role_permission` VALUES ('1322', '14', '69');
INSERT INTO `sys_role_permission` VALUES ('1323', '14', '71');
INSERT INTO `sys_role_permission` VALUES ('1324', '14', '74');
INSERT INTO `sys_role_permission` VALUES ('1325', '14', '79');
INSERT INTO `sys_role_permission` VALUES ('1326', '14', '80');
INSERT INTO `sys_role_permission` VALUES ('1327', '14', '81');
INSERT INTO `sys_role_permission` VALUES ('1328', '15', '67');
INSERT INTO `sys_role_permission` VALUES ('1329', '15', '68');
INSERT INTO `sys_role_permission` VALUES ('1330', '15', '73');
INSERT INTO `sys_role_permission` VALUES ('1331', '15', '80');
INSERT INTO `sys_role_permission` VALUES ('1332', '15', '82');
INSERT INTO `sys_role_permission` VALUES ('1333', '15', '84');
INSERT INTO `sys_role_permission` VALUES ('1390', '13', '45');
INSERT INTO `sys_role_permission` VALUES ('1391', '13', '46');
INSERT INTO `sys_role_permission` VALUES ('1392', '13', '47');
INSERT INTO `sys_role_permission` VALUES ('1393', '13', '49');
INSERT INTO `sys_role_permission` VALUES ('1394', '13', '50');
INSERT INTO `sys_role_permission` VALUES ('1395', '13', '51');
INSERT INTO `sys_role_permission` VALUES ('1396', '13', '67');
INSERT INTO `sys_role_permission` VALUES ('1397', '13', '68');
INSERT INTO `sys_role_permission` VALUES ('1398', '13', '73');
INSERT INTO `sys_role_permission` VALUES ('1399', '13', '69');
INSERT INTO `sys_role_permission` VALUES ('1400', '13', '71');
INSERT INTO `sys_role_permission` VALUES ('1401', '13', '74');
INSERT INTO `sys_role_permission` VALUES ('1402', '13', '79');
INSERT INTO `sys_role_permission` VALUES ('1403', '13', '87');
INSERT INTO `sys_role_permission` VALUES ('1404', '13', '70');
INSERT INTO `sys_role_permission` VALUES ('1405', '13', '72');
INSERT INTO `sys_role_permission` VALUES ('1406', '13', '88');
INSERT INTO `sys_role_permission` VALUES ('1407', '13', '75');
INSERT INTO `sys_role_permission` VALUES ('1408', '13', '76');
INSERT INTO `sys_role_permission` VALUES ('1409', '13', '77');
INSERT INTO `sys_role_permission` VALUES ('1410', '13', '78');
INSERT INTO `sys_role_permission` VALUES ('1411', '13', '85');
INSERT INTO `sys_role_permission` VALUES ('1412', '13', '80');
INSERT INTO `sys_role_permission` VALUES ('1413', '13', '81');
INSERT INTO `sys_role_permission` VALUES ('1414', '13', '82');
INSERT INTO `sys_role_permission` VALUES ('1415', '13', '83');
INSERT INTO `sys_role_permission` VALUES ('1416', '13', '84');
INSERT INTO `sys_role_permission` VALUES ('1417', '16', '70');
INSERT INTO `sys_role_permission` VALUES ('1418', '16', '72');
INSERT INTO `sys_role_permission` VALUES ('1419', '16', '88');
INSERT INTO `sys_role_permission` VALUES ('1420', '16', '80');
INSERT INTO `sys_role_permission` VALUES ('1421', '16', '83');

-- ----------------------------
-- Table structure for sys_role_permissions_concern
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permissions_concern`;
CREATE TABLE `sys_role_permissions_concern` (
  `role_permissioin_concern_id` int(11) NOT NULL,
  `permissions_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_userid` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_userid` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `enable_flag` char(1) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`role_permissioin_concern_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_role_permissions_concern
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `sys_user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '账号',
  `user_passwd` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `user_realname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '真实姓名',
  `user_state` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '标记该记录的员工状态0：在职，1：离职，2：退休，3：试用，4：实习',
  `dept_id` int(11) DEFAULT '2' COMMENT '部门ID',
  `enable_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '1' COMMENT '标记该记录的启用状态1：正常，0：禁用（已删除）',
  `create_user` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_timestamp` datetime NOT NULL COMMENT '创建时间',
  `last_update_user` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '最后修改人',
  `last_update_timestamp` datetime DEFAULT NULL COMMENT '最后修改时间',
  `last_update_remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '最后修改备注',
  PRIMARY KEY (`sys_user_id`),
  KEY `hr_fk_sysuser` (`dept_id`) USING BTREE,
  CONSTRAINT `sys_user_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT=' 用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user1
-- ----------------------------
DROP TABLE IF EXISTS `sys_user1`;
CREATE TABLE `sys_user1` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `workplace` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `extension_number` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '分机号',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_user1
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户 职务 关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_post_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post_dept`;
CREATE TABLE `sys_user_post_dept` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `org_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户-职务-部门-组织 关联表';

-- ----------------------------
-- Records of sys_user_post_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(4) DEFAULT NULL,
  `role_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hr_fk_userid` (`user_id`) USING BTREE,
  KEY `hr_fk_roleid` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户 角色 关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('91', '2', '1');
INSERT INTO `sys_user_role` VALUES ('93', '3', '1');
INSERT INTO `sys_user_role` VALUES ('94', '4', '2');
INSERT INTO `sys_user_role` VALUES ('96', '1', '13');
INSERT INTO `sys_user_role` VALUES ('97', '5', '14');
INSERT INTO `sys_user_role` VALUES ('99', '7', '16');
INSERT INTO `sys_user_role` VALUES ('100', '6', '15');

-- ----------------------------
-- Table structure for ylsys_keshi
-- ----------------------------
DROP TABLE IF EXISTS `ylsys_keshi`;
CREATE TABLE `ylsys_keshi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ksname` varchar(100) DEFAULT NULL,
  `ksnumber` varchar(100) DEFAULT NULL,
  `ksaddress` varchar(100) DEFAULT NULL,
  `ksorder` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='科室表';

-- ----------------------------
-- Records of ylsys_keshi
-- ----------------------------
INSERT INTO `ylsys_keshi` VALUES ('21', '全科', 'ks001', 'A座八楼', '001');
-- INSERT INTO `ylsys_keshi` VALUES ('22', '耳鼻喉科', 'ks002', '', '1');

-- ----------------------------
-- Table structure for ylsys_ypbianma
-- ----------------------------
DROP TABLE IF EXISTS `ylsys_ypbianma`;
CREATE TABLE `ylsys_ypbianma` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ypbmname` varchar(100) DEFAULT NULL COMMENT '药品编码名字',
  `ypbmnumber` varchar(100) DEFAULT NULL COMMENT '药品编码编号',
  `yppihao` varchar(100) DEFAULT NULL COMMENT '药品批号',
  `ypbmshengchanshang` varchar(100) DEFAULT NULL COMMENT '生产商',
  `ypbmleibieid` varchar(100) DEFAULT NULL COMMENT '类别',
  `ypbmleibiename` varchar(100) DEFAULT NULL COMMENT '类别名字',
  `ypbmorder` varchar(100) DEFAULT NULL COMMENT '顺序号',
  `ypbmstatus` varchar(100) DEFAULT NULL COMMENT '状态',
  `ypbmdanwei` varchar(100) DEFAULT NULL COMMENT '药品单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='药品编码表';

alter table `ylsys_ypbianma` add column `useMethod` varchar(100) default '' comment '使用方式';
alter table `ylsys_ypbianma` add column `useAmount` varchar(100) default '' comment '使用数量';
alter table `ylsys_ypbianma` add column `useFrequence` varchar(100) default '' comment '使用频率';
-- ----------------------------
-- Records of ylsys_ypbianma
-- ----------------------------
INSERT INTO `ylsys_ypbianma` VALUES ('28', '铺地蓝软胶囊', '010021', 'PC001', '太极药业', '19', '发热', null, '0', '盒（36片）');
INSERT INTO `ylsys_ypbianma` VALUES ('29', '脉通', '009002', '000299', '东北制药厂', '20', '心脑血管', null, '0', '盒（72片）');

-- ----------------------------
-- Table structure for ylsys_ypleibie
-- ----------------------------
DROP TABLE IF EXISTS `ylsys_ypleibie`;
CREATE TABLE `ylsys_ypleibie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yplbname` varchar(100) DEFAULT NULL,
  `yplbnumber` varchar(100) DEFAULT NULL,
  `yplborder` varchar(100) DEFAULT NULL,
  `yplbstatus` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='药品编码表';

-- ----------------------------
-- Records of ylsys_ypleibie
-- ----------------------------
INSERT INTO `ylsys_ypleibie` VALUES ('19', '发热', 'yplb001', '001', '0');
INSERT INTO `ylsys_ypleibie` VALUES ('20', '心脑血管', 'xnxg', '2', '0');

-- ----------------------------
-- Table structure for yl_ghshoufei
-- ----------------------------
DROP TABLE IF EXISTS `yl_ghshoufei`;
CREATE TABLE `yl_ghshoufei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ghsf_zdid` varchar(100) DEFAULT NULL,
  `ghsf_ghid` int(11) DEFAULT NULL,
  `ghsf_ghnumber` varchar(100) DEFAULT NULL,
  `ghsf_ysjine` varchar(100) DEFAULT NULL,
  `ghsf_ssjine` varchar(100) DEFAULT NULL,
  `ghsf_zljine` varchar(100) DEFAULT NULL,
  `ghsf_heji` varchar(100) DEFAULT NULL,
  `ghsf_sktime` varchar(100) DEFAULT NULL COMMENT '收款时间',
  `ghsf_skpersonid` int(11) DEFAULT NULL,
  `ghsf_skperson` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='挂号收费结算表';

-- ----------------------------
-- Records of yl_ghshoufei
-- ----------------------------
INSERT INTO `yl_ghshoufei` VALUES ('1', '27', '19', 'BL1229', '1.0', '1', '0', '1.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('2', '24', '18', 'bl001', '14.0', '15', '1', '14.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('3', '30', '21', 'BL521', '175.0', '200', '25', '175.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('4', '29', '20', 'BL520', '175.0', '175', '0', '175.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('5', '28', '18', 'bl001', '70.0', '70', '0', '70.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('6', '33', '21', 'BL521', '3.0', '3', '0', '3.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('7', '33', '21', 'BL521', '3.0', '3', '0', '3.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('8', '35', '22', '222', '0.0', '33', '33', '0.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('9', '35', '22', '222', '0.0', '33', '33', '0.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('10', '35', '22', '222', '0.0', '333333', '333333', '0.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('11', '35', '22', '222', '0.0', '33333', '33333', '0.0', '2014-12-29', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('12', '36', '23', '1230', '1000.0', '1000', '0', '1000.0', '2014-12-30', '1', '超级管理员');
INSERT INTO `yl_ghshoufei` VALUES ('13', '37', '23', '1230', '70.0', '70', '0', '70.0', '2014-12-31', '1', '超级管理员');

-- ----------------------------
-- Table structure for yl_ghtaizhang
-- ----------------------------
DROP TABLE IF EXISTS `yl_ghtaizhang`;
CREATE TABLE `yl_ghtaizhang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ghnumber` varchar(100) DEFAULT NULL,
  `ghname` varchar(100) DEFAULT NULL,
  `ghsex` varchar(100) DEFAULT NULL,
  `ghage` varchar(100) DEFAULT NULL,
  `ghkeshiid` varchar(100) DEFAULT NULL,
  `ghkeshiname` varchar(100) DEFAULT NULL,
  `ghtype` varchar(100) DEFAULT NULL,
  `ghstatus` varchar(100) DEFAULT NULL,
  `ghyishengid` int(11) DEFAULT NULL,
  `ghyisheng` varchar(100) DEFAULT NULL,
  `ghriqi` varchar(100) DEFAULT NULL,
  `ghypfeiyong` varchar(100) DEFAULT NULL,
  `ghfeiyong` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='挂号台账表-病例表';

-- ----------------------------
-- Records of yl_ghtaizhang
-- ----------------------------
INSERT INTO `yl_ghtaizhang` VALUES ('18', 'bl001', '张三', '0', '35', '21', '发烧科', '0', '0', null, null, '2014-12-29', null, '5');
INSERT INTO `yl_ghtaizhang` VALUES ('19', 'BL1229', '李四', '0', '22', '22', '耳鼻喉科', '0', '0', null, null, '2014-12-29', null, '3');
INSERT INTO `yl_ghtaizhang` VALUES ('20', 'BL520', '郑毅', '0', '25', '21', '发烧科', '1', '0', null, null, '2014-12-29', null, '10');
INSERT INTO `yl_ghtaizhang` VALUES ('21', 'BL521', '张', '0', '27', '22', '耳鼻喉科', '1', '0', null, null, '2014-12-29', null, '10');
INSERT INTO `yl_ghtaizhang` VALUES ('22', '222', '2222', '0', '222', '21', '发烧科', '0', '0', null, null, '2014-12-29 17:17:53', null, '222');
INSERT INTO `yl_ghtaizhang` VALUES ('23', '1230', '张世玺', '0', '30', '22', '耳鼻喉科', '0', '0', null, null, '2014-12-30 16:45:15', null, '3');

-- ----------------------------
-- Table structure for yl_kc
-- ----------------------------
DROP TABLE IF EXISTS `yl_kc`;
CREATE TABLE `yl_kc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kc_ypbmid` varchar(100) DEFAULT NULL,
  `kc_ypbmnumber` varchar(100) DEFAULT NULL,
  `kc_ypleibie` varchar(100) DEFAULT NULL,
  `kc_ypname` varchar(100) DEFAULT NULL,
  `kc_yppihao` varchar(100) DEFAULT NULL,
  `kc_scpici` varchar(100) DEFAULT NULL,
  `kc_scriqi` varchar(100) DEFAULT NULL COMMENT '生产日期',
  `kc_version` varchar(100) DEFAULT NULL,
  `kc_yxriqi` varchar(100) DEFAULT NULL COMMENT '有效日期',
  `kc_cbjiage` varchar(100) DEFAULT NULL,
  `kc_zdjiage` varchar(100) DEFAULT NULL,
  `kc_lsjiage` varchar(100) DEFAULT NULL,
  `kc_rkriqi` varchar(100) DEFAULT NULL,
  `kc_laiyuan` varchar(100) DEFAULT NULL,
  `kc_shengchanshang` varchar(100) DEFAULT NULL,
  `kc_danwei` varchar(100) DEFAULT NULL,
  `kc_shuliang` varchar(100) DEFAULT NULL,
  `kc_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='当前库存表';

-- ----------------------------
-- Records of yl_kc
-- ----------------------------
INSERT INTO `yl_kc` VALUES ('16', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', 'pc002', '2014-12-29', null, '2016-12-29', '1', '2', '3', '2014-12-29', '1', '太极药业', '盒（36片）', '-2', null);
INSERT INTO `yl_kc` VALUES ('17', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', 'q', '2014-12-12', null, '2014-12-04', '1', '1', '1', '2014-12-19', 'q', '太极药业', '盒（36片）', '-2', null);
INSERT INTO `yl_kc` VALUES ('18', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', '1', '2014-12-19', null, '2014-12-10', '1', '11', '11', '2014-12-18', '1', '太极药业', '盒（36片）', '-1', null);
INSERT INTO `yl_kc` VALUES ('19', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', 'PC', '2014-12-11', null, '2014-12-11', '19', '23', '35', '2014-12-25', '11122321321', '太极药业', '盒（36片）', '134', null);
INSERT INTO `yl_kc` VALUES ('20', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', '1', '2014-12-18', null, '2014-12-17', '1', '11', '1', '2014-12-24', '1', '太极药业', '盒（36片）', '-5', null);
INSERT INTO `yl_kc` VALUES ('21', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', '1', '2014-12-11', null, '2014-12-24', '1', '1', '1', null, '1', '太极药业', '盒（36片）', '222', null);
INSERT INTO `yl_kc` VALUES ('22', '29', '009002', '心脑血管', '脉通', '000299', 'pc001', '2014-12-30', null, '2016-12-30', '30', '200', '500', null, '采购', '东北制药厂', '盒（72片）', '198', null);

-- ----------------------------
-- Table structure for yl_kcck
-- ----------------------------
DROP TABLE IF EXISTS `yl_kcck`;
CREATE TABLE `yl_kcck` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zdyp_zdid` varchar(100) DEFAULT NULL,
  `zdyp_ghid` varchar(100) DEFAULT NULL,
  `zdyp_ghnumber` varchar(100) DEFAULT NULL,
  `zdyp_ypid` varchar(100) DEFAULT NULL,
  `zdyp_ypbmid` char(10) DEFAULT NULL,
  `zdyp_ypbmnumber` varchar(100) DEFAULT NULL,
  `zdyp_ypname` varchar(100) DEFAULT NULL,
  `zdyp_ypshuliang` varchar(100) DEFAULT NULL,
  `zdyp_ypdanwei` varchar(100) DEFAULT NULL,
  `zdyp_ypshengchanshang` varchar(100) DEFAULT NULL,
  `zdyp_ypleibie` varchar(100) DEFAULT NULL,
  `zdyp_ypcbjiage` varchar(100) DEFAULT NULL,
  `zdyp_yplsjiage` varchar(100) DEFAULT NULL,
  `zdyp_ypzdjiage` varchar(100) DEFAULT NULL,
  `zdyp_ypcktime` datetime DEFAULT NULL,
  `zdyp_ypbcxsjiage` varchar(100) DEFAULT NULL,
  `zdyp_danxiangjine` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='医生诊断从表-开药表';

-- ----------------------------
-- Records of yl_kcck
-- ----------------------------
INSERT INTO `yl_kcck` VALUES ('1', '27', '19', 'BL1229', '17', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '1', '1', null, '1', '1');
INSERT INTO `yl_kcck` VALUES ('2', '24', '18', 'bl001', '16', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '3', '2', null, '3', '3');
INSERT INTO `yl_kcck` VALUES ('3', '24', '18', 'bl001', '18', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '11', '11', null, '11', '11');
INSERT INTO `yl_kcck` VALUES ('4', '30', '21', 'BL521', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('5', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('6', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('7', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('8', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('9', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('10', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('11', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('12', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('13', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('14', '30', '21', 'BL521', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('15', '24', '18', 'bl001', '16', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '3', '2', null, '3', '3');
INSERT INTO `yl_kcck` VALUES ('16', '24', '18', 'bl001', '18', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '11', '11', null, '11', '11');
INSERT INTO `yl_kcck` VALUES ('17', '28', '18', 'bl001', '19', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '35');
INSERT INTO `yl_kcck` VALUES ('18', '28', '18', 'bl001', '19', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '35');
INSERT INTO `yl_kcck` VALUES ('19', '33', '21', 'BL521', '20', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '1', '11', null, '1', '1');
INSERT INTO `yl_kcck` VALUES ('20', '33', '21', 'BL521', '20', '28', '010021', '铺地蓝软胶囊', '2', '盒（36片）', '太极药业', '发热', '1', '1', '11', null, '1', '2');
INSERT INTO `yl_kcck` VALUES ('21', '31', '21', 'BL521', '16', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '3', '2', null, '3', '3');
INSERT INTO `yl_kcck` VALUES ('22', '31', '21', 'BL521', '16', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '3', '2', null, '3', '3');
INSERT INTO `yl_kcck` VALUES ('23', '27', '19', 'BL1229', '17', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '1', '1', null, '1', '1');
INSERT INTO `yl_kcck` VALUES ('24', '27', '19', 'BL1229', '17', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '1', '1', null, '1', '1');
INSERT INTO `yl_kcck` VALUES ('25', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '23', null, '35', '175');
INSERT INTO `yl_kcck` VALUES ('26', '33', '21', 'BL521', '20', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '1', '11', null, '1', '1');
INSERT INTO `yl_kcck` VALUES ('27', '33', '21', 'BL521', '20', '28', '010021', '铺地蓝软胶囊', '2', '盒（36片）', '太极药业', '发热', '1', '1', '11', null, '1', '2');
INSERT INTO `yl_kcck` VALUES ('28', '31', '21', 'BL521', '16', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '3', '2', null, '3', '3');
INSERT INTO `yl_kcck` VALUES ('29', '28', '18', 'bl001', '19', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '19', '35', '23', '2014-12-30 09:44:23', '35', '35');
INSERT INTO `yl_kcck` VALUES ('30', '28', '18', 'bl001', '19', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '19', '35', '23', '2014-12-30 09:44:23', '35', '35');
INSERT INTO `yl_kcck` VALUES ('31', '36', '23', '1230', '22', '29', '009002', '脉通', '2', '盒（72片）', '东北制药厂', '心脑血管', '30', '500', '200', '2014-12-30 16:48:15', '500', '1000');
INSERT INTO `yl_kcck` VALUES ('32', '37', '23', '1230', '19', '28', '010021', '铺地蓝软胶囊', '2', '盒（36片）', '太极药业', '发热', '19', '35', '23', '2014-12-31 11:00:08', '35', '70');

-- ----------------------------
-- Table structure for yl_kcrk
-- ----------------------------
DROP TABLE IF EXISTS `yl_kcrk`;
CREATE TABLE `yl_kcrk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kc_id` varchar(100) DEFAULT NULL,
  `kc_ypbmid` varchar(100) DEFAULT NULL,
  `kc_ypbmnumber` varchar(100) DEFAULT NULL,
  `kc_ypleibie` varchar(100) DEFAULT NULL,
  `kc_ypname` varchar(100) DEFAULT NULL,
  `kc_yppihao` varchar(100) DEFAULT NULL,
  `kc_scpici` varchar(100) DEFAULT NULL,
  `kc_scriqi` varchar(100) DEFAULT NULL,
  `kc_yxriqi` varchar(100) DEFAULT NULL,
  `kc_cbjiage` varchar(100) DEFAULT NULL,
  `kc_zdjiage` varchar(100) DEFAULT NULL,
  `kc_rkriqi` varchar(100) DEFAULT NULL,
  `kc_danwei` varchar(100) DEFAULT NULL,
  `kc_laiyuan` varchar(100) DEFAULT NULL,
  `kc_shengchanshang` varchar(100) DEFAULT NULL,
  `kc_shuliang` varchar(100) DEFAULT NULL,
  `kc_lsjiage` varchar(100) DEFAULT NULL,
  `kc_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='入库台账表-台账';

-- ----------------------------
-- Records of yl_kcrk
-- ----------------------------
INSERT INTO `yl_kcrk` VALUES ('22', '16', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', 'pc002', '2014-12-29', '2016-12-29', '1', '2', '2014-12-29', '盒（36片）', '1', '太极药业', '100', '3', null);
INSERT INTO `yl_kcrk` VALUES ('23', '17', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', 'q', '2014-12-12', '2014-12-04', '1', '1', '2014-12-19', '盒（36片）', 'q', '太极药业', '100', '1', null);
INSERT INTO `yl_kcrk` VALUES ('24', '18', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', '1', '2014-12-19', '2014-12-10', '1', '11', '2014-12-18', '盒（36片）', '1', '太极药业', '1', '11', null);
INSERT INTO `yl_kcrk` VALUES ('25', '19', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', 'PC', '2014-12-11', '2014-12-11', '19', '23', '2014-12-25', '盒（36片）', '11122321321', '太极药业', '200', '35', null);
INSERT INTO `yl_kcrk` VALUES ('26', '20', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', '1', '2014-12-18', '2014-12-17', '1', '11', '2014-12-24', '盒（36片）', '1', '太极药业', '1', '1', null);
INSERT INTO `yl_kcrk` VALUES ('27', '21', '28', '010021', '发热', '铺地蓝软胶囊', 'PC001', '1', '2014-12-11', '2014-12-24', '1', '1', '2014-12-29 17:14:39', '盒（36片）', '1', '太极药业', '222', '1', null);
INSERT INTO `yl_kcrk` VALUES ('28', '22', '29', '009002', '心脑血管', '脉通', '000299', 'pc001', '2014-12-30', '2016-12-30', '30', '200', '2014-12-30 16:47:21', '盒（72片）', '采购', '东北制药厂', '200', '500', null);

-- ----------------------------
-- Table structure for yl_yszdyaopin
-- ----------------------------
DROP TABLE IF EXISTS `yl_yszdyaopin`;
CREATE TABLE `yl_yszdyaopin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zdyp_zdid` varchar(100) DEFAULT NULL,
  `zdyp_ghid` varchar(100) DEFAULT NULL,
  `zdyp_ghnumber` varchar(100) DEFAULT NULL,
  `zdyp_ypid` varchar(100) DEFAULT NULL,
  `zdyp_ypbmid` char(10) DEFAULT NULL,
  `zdyp_ypbmnumber` varchar(100) DEFAULT NULL,
  `zdyp_ypname` varchar(100) DEFAULT NULL,
  `zdyp_ypshuliang` varchar(100) DEFAULT NULL,
  `zdyp_ypdanwei` varchar(100) DEFAULT NULL,
  `zdyp_ypshengchanshang` varchar(100) DEFAULT NULL,
  `zdyp_ypleibie` varchar(100) DEFAULT NULL,
  `zdyp_ypcbjiage` varchar(100) DEFAULT NULL,
  `zdyp_yplsjiage` varchar(100) DEFAULT NULL,
  `zdyp_ypbcxsjiage` varchar(100) DEFAULT NULL,
  `zdyp_danxiangjine` varchar(100) DEFAULT NULL,
  `zdyp_ypzdjiage` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='医生诊断从表-开药表';

-- ----------------------------
-- Records of yl_yszdyaopin
-- ----------------------------
INSERT INTO `yl_yszdyaopin` VALUES ('15', '24', '18', 'bl001', '16', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '3', '3', '3', '2');
INSERT INTO `yl_yszdyaopin` VALUES ('16', '25', '18', 'bl001', '16', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '3', '3', '3', '2');
INSERT INTO `yl_yszdyaopin` VALUES ('17', '27', '19', 'BL1229', '17', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '1', '1', '1', '1');
INSERT INTO `yl_yszdyaopin` VALUES ('18', '24', '18', 'bl001', '18', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '11', '11', '11', '11');
INSERT INTO `yl_yszdyaopin` VALUES ('19', '28', '18', 'bl001', '19', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '19', '35', '35', '35', '23');
INSERT INTO `yl_yszdyaopin` VALUES ('20', '28', '18', 'bl001', '19', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '19', '35', '35', '35', '23');
INSERT INTO `yl_yszdyaopin` VALUES ('21', '29', '20', 'BL520', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '35', '175', '23');
INSERT INTO `yl_yszdyaopin` VALUES ('22', '30', '21', 'BL521', '19', '28', '010021', '铺地蓝软胶囊', '5', '盒（36片）', '太极药业', '发热', '19', '35', '35', '175', '23');
INSERT INTO `yl_yszdyaopin` VALUES ('23', '31', '21', 'BL521', '16', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '3', '3', '3', '2');
INSERT INTO `yl_yszdyaopin` VALUES ('25', '33', '21', 'BL521', '20', '28', '010021', '铺地蓝软胶囊', '1', '盒（36片）', '太极药业', '发热', '1', '1', '1', '1', '11');
INSERT INTO `yl_yszdyaopin` VALUES ('26', '33', '21', 'BL521', '20', '28', '010021', '铺地蓝软胶囊', '2', '盒（36片）', '太极药业', '发热', '1', '1', '1', '2', '11');
INSERT INTO `yl_yszdyaopin` VALUES ('27', '36', '23', '1230', '22', '29', '009002', '脉通', '2', '盒（72片）', '东北制药厂', '心脑血管', '30', '500', '500', '1000', '200');
INSERT INTO `yl_yszdyaopin` VALUES ('28', '34', '18', 'bl001', '22', '29', '009002', '脉通', '11', '盒（72片）', '东北制药厂', '心脑血管', '30', '500', '500', '5500', '200');
INSERT INTO `yl_yszdyaopin` VALUES ('29', '37', '23', '1230', '19', '28', '010021', '铺地蓝软胶囊', '2', '盒（36片）', '太极药业', '发热', '19', '35', '35', '70', '23');

-- ----------------------------
-- Table structure for yl_yszhenduan
-- ----------------------------
DROP TABLE IF EXISTS `yl_yszhenduan`;
CREATE TABLE `yl_yszhenduan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zd_yishengid` int(11) DEFAULT NULL,
  `zd_ghid` int(11) DEFAULT NULL,
  `zd_yishengname` varchar(100) DEFAULT NULL,
  `zd_riqi` varchar(100) DEFAULT NULL,
  `zd_ghtype` varchar(100) DEFAULT NULL,
  `zd_ghnumber` varchar(100) DEFAULT NULL,
  `zd_ghname` varchar(100) DEFAULT NULL,
  `zd_ghsex` varchar(100) DEFAULT NULL,
  `zd_ghage` varchar(100) DEFAULT NULL,
  `zd_fystatus` varchar(100) DEFAULT NULL,
  `zd_status` varchar(100) DEFAULT NULL,
  `zd_ghks` varchar(100) DEFAULT NULL,
  `zd_version` varchar(100) DEFAULT NULL,
  `zd_ghriqi` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='医生诊断表-看病表';

alter table yl_yszhenduan add column zdContent varchar(1000) default '';
-- ----------------------------
-- Records of yl_yszhenduan
-- ----------------------------
INSERT INTO `yl_yszhenduan` VALUES ('24', '1', '18', '超级管理员', '2014-12-29', '普通号', 'bl001', '张三', '男', '35', '0', '1', '发烧科', '1', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('25', '7', '18', '医生', '2014-12-11', '普通号', 'bl001', '张三', '男', '35', '0', '1', '发烧科', '0', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('26', '7', '18', '医生', '2014-12-29', '普通号', 'bl001', '张三', '男', '35', '0', '1', '发烧科', '1', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('27', '1', '19', '超级管理员', '2014-12-29', '普通号', 'BL1229', '李四', '男', '22', '0', '1', '耳鼻喉科', '1', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('28', '7', '18', '医生', '2014-12-29', '普通号', 'bl001', '张三', '男', '35', '1', '1', '发烧科', '2', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('29', '7', '20', '医生', '2014-12-29', '专家号', 'BL520', '郑毅', '男', '25', '1', '1', '发烧科', '7', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('30', '1', '21', '超级管理员', '2014-12-29', '专家号', 'BL521', '张', '男', '27', '0', '1', '耳鼻喉科', '1', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('31', '1', '21', '超级管理员', '2014-12-29', '专家号', 'BL521', '张', '男', '27', '1', '1', '耳鼻喉科', '2', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('32', '1', '21', '超级管理员', '2014-12-29', '专家号', 'BL521', '张', '男', '27', '1', '1', '耳鼻喉科', '2', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('33', '1', '21', '超级管理员', '2014-12-29', '专家号', 'BL521', '张', '男', '27', '1', '1', '耳鼻喉科', '2', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('34', '1', '18', '超级管理员', '2014-12-23', '普通号', 'bl001', '张三', '男', '35', '0', '0', '发烧科', '0', '2014-12-29');
INSERT INTO `yl_yszhenduan` VALUES ('35', '1', '22', '超级管理员', '2014-12-29 17:19:53', '普通号', '222', '2222', '男', '222', null, '0', '发烧科', '0', '2014-12-29 17:17:53');
INSERT INTO `yl_yszhenduan` VALUES ('36', '1', '23', '超级管理员', '2014-12-30 16:45:33', '普通号', '1230', '张世玺', '男', '30', '1', '1', '耳鼻喉科', '2', '2014-12-30 16:45:15');
INSERT INTO `yl_yszhenduan` VALUES ('37', '1', '23', '超级管理员', '2014-12-31 10:59:13', '普通号', '1230', '张世玺', '男', '30', '1', '1', '耳鼻喉科', '2', '2014-12-30 16:45:15');


DROP TABLE IF EXISTS `dict_base`;
CREATE TABLE `dict_base` (
  `id` varchar(36),
  `text` varchar(100),
  `class` varchar(100),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

insert into `dict_base` (`id`,`text`,`class`) values ('2d40d0fe-fdd4-11e4-ac83-e60c8472ae15','口服','药品使用方式');
insert into `dict_base` (`id`,`text`,`class`) values ('555d6052-fdd4-11e4-ac83-e60c8472ae15','注射','药品使用方式');


select uuid();