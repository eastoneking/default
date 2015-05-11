DROP TABLE IF EXISTS `T_Role`;
CREATE TABLE IF NOT EXISTS `T_Role` (
    `RoleId` varchar(40) COMMENT '角色编号',
    `RoleName` varchar(200) COMMENT '角色名称',
    `Description` varchar(1000) COMMENT '角色描述',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';
DROP TABLE IF EXISTS `T_Account`;
CREATE TABLE IF NOT EXISTS `T_Account` (
    `AccountId` varchar(40) COMMENT '账户唯一标志，UUID',
    `LoginName` varchar(1000) COMMENT '登录名,用于登陆',
    `Password` varchar(512) COMMENT '密码,MD5或SHA-1加密',
    `Status` varchar(4) COMMENT '状态,\n0-正常；1-禁用。',
    `Description` varchar(1000) COMMENT '角色描述',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`AccountId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户';
DROP TABLE IF EXISTS `T_User`;
CREATE TABLE IF NOT EXISTS `T_User` (
    `UserId` varchar(40) COMMENT '用户编号',
    `FirstName` varchar(100) COMMENT '名',
    `MiddleName` varchar(100) COMMENT '中间名',
    `LastName` varchar(100) COMMENT '姓氏',
    `Birthday` date COMMENT '出生日期',
    `Sex` int(1) COMMENT '性别, 0-未填,1-男,2-女',
    `Description` varchar(2000) COMMENT '描述',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';
DROP TABLE IF EXISTS `T_Organization`;
CREATE TABLE IF NOT EXISTS `T_Organization`(
    `OrgId` varchar(40) COMMENT '机构编号',
    `ParentId` varchar(40) COMMENT '属主机构编号',
    `OrgName` varchar(1000) COMMENT '机构名称',
    `Foreign` int(1) COMMENT '是否外部组织',
    `Description` varchar(2000) COMMENT '描述',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`OrgId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构';
DROP TABLE IF EXISTS `T_Privilege`;
CREATE TABLE IF NOT EXISTS `T_Privilege`(
    `PriId` varchar(40) COMMENT '权限编号',
    `PriName` varchar(100) COMMENT '权限名称',
    `Description` varchar(2000) COMMENT '描述',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`PriId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授权信息';
DROP TABLE IF EXISTS `T_Resource`;
CREATE TABLE IF NOT EXISTS `T_Resource`(
    `ResId` varchar(40) COMMENT '资源编号',
    `ResName` varchar(100) COMMENT '资源名称',
    `Uri` varchar(2000) COMMENT '统一资源定位符',
    `ResClassId` varchar(40) COMMENT '资源类型',
    `Description` varchar(2000) COMMENT '描述',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`ResId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源';
DROP TABLE IF EXISTS `T_Action`;
CREATE TABLE IF NOT EXISTS `T_Action`(
    `ActId` varchar(40) COMMENT '活动编号',
    `ActName` varchar(100) COMMENT '活动名称',
    `Description` varchar(2000) COMMENT '描述',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`ActId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动作';

DROP TABLE IF EXISTS `R_OrgUser`;
CREATE TABLE IF NOT EXISTS `R_OrgUser`(
    `RefId` varchar(40) COMMENT '关系编号',
    `OrgId` varchar(40) COMMENT '机构编码',
    `UserId` varchar(40) COMMENT '人员编码',
    `Interim` int(1) COMMENT '是否临时关系',
    `InvalidateDate` date COMMENT '失效日期',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`RefId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构人员关系';

DROP TABLE IF EXISTS `R_UserAccount`;
CREATE TABLE IF NOT EXISTS `R_UserAccount`(
    `RefId` varchar(40) COMMENT '关系编号',
    `UserId` varchar(40) COMMENT '人员编码',
    `AccountId` varchar(40) COMMENT '账户编码',
    `Interim` int(1) COMMENT '是否临时关系',
    `InvalidateTs` timestamp COMMENT '失效日期',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`RefId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员账户关系';

DROP TABLE IF EXISTS `R_UserRole`;
CREATE TABLE IF NOT EXISTS `R_UserRole`(
    `UserId` varchar(40) COMMENT '人员编码',
    `RoleId` varchar(40) COMMENT '角色编码',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`UserId`, `RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员角色关系';

DROP TABLE IF EXISTS `R_RolePrivilege`;
CREATE TABLE IF NOT EXISTS `R_RolePrivilege`(
    `RoleId` varchar(40) COMMENT '角色编码',
    `PriId` varchar(40) COMMENT '权限编码',
    `Grantable` int(0) COMMENT '是否可授权',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`RoleId`, `PriId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系';

DROP TABLE IF EXISTS `R_PrivilegeDetail`;
CREATE TABLE IF NOT EXISTS `R_PrivilegeDetail`(
    `PriId` varchar(40) COMMENT '权限编码',
    `ResId` varchar(40) COMMENT '资源编码',
    `ActId` varchar(40) COMMENT '活动编码',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`PriId`, `ResId`, `ActId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限明细';

DROP TABLE IF EXISTS `L_AccountLogin`;
CREATE TABLE IF NOT EXISTS `L_AccountLogin`(
    `LogId` varchar(40) COMMENT '日志编号',
    `AccountId` varchar(40) COMMENT '账户编号',
    `UserId` varchar(40) COMMENT '用户编号',
    `Passed` int(1) COMMENT '是否成功,0000-成功',
    `ClientIp` varchar(1000) COMMENT '用户所在主机IP',
    `ClientMac` char(17) default '' COMMENT '用户主机MAC地址',
    `ClientPort` int default 0 COMMENT '用户端口', 
    `RecieveTs` timestamp default now() COMMENT '接收到请求的时间',
    `ResponeTs` timestamp default now() COMMENT '返回应答的时间',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`LogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录日志';

DROP TABLE IF EXISTS `L_UserAuth`;
CREATE TABLE IF NOT EXISTS `L_UserAuth`(
    `LogId` varchar(40) COMMENT '日志编号',
    `UserId` varchar(40) COMMENT '用户编号',
    `AccountId` varchar(40) COMMENT '账户编号',
    `PriId` varchar(40) COMMENT '权限编号',
    `Status` varchar(4) COMMENT '是否成功, 0000-成功',
    `ClientIp` varchar(1000) COMMENT '用户所在主机IP',
    `ClientMac` char(17) default '' COMMENT '用户主机MAC地址',
    `ClientPort` int default 0 COMMENT '用户端口',
    `RecieveTs` timestamp default now() COMMENT '接收到请求的时间',
    `ResponeTs` timestamp default now() COMMENT '返回应答的时间',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`LogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='鉴权日志';

DROP TABLE IF EXISTS `D_ResClass`;
CREATE TABLE IF NOT EXISTS `D_ResClass`(
    `ResClassId` varchar(40) COMMENT '资源类型编号',
    `ResClassName` varchar(40) COMMENT '名称',
    `Description` varchar(1000) COMMENT '角色描述',
    `CreateTime` timestamp default now() COMMENT '创建时间',
    `Creator` varchar(40) default '' COMMENT '创建人',
    `ModifyTime` timestamp default now() COMMENT '修改时间',
    `Operator` varchar(40) default '' COMMENT '操作人',
    `Test` int(1) default 0 COMMENT '是否测试数据',
    PRIMARY KEY (`ResClassId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源类型';


