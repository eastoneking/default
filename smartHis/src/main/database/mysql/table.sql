--车辆：ID、车型、牌号、车架号、保险公司、保险到期日、年审到期日、车辆状态
create table car_information
(
   id                   int not null,
   car_type             varchar(100),
   car_number           varchar(20),
   vin                  varchar(20),
   insurance_company    varchar(100),
   insurance_due_date   timestamp,
   examined_due_date    timestamp,
   status               int,
   primary key (id)
);

﻿--车辆使用信息：ID、车辆ID、使用人、创建时间、创建人、备注
create table car_usage_information
(
   id                   int not null,
   car_id               int,
   user_id              int,
   create_time          timestamp,
   create_user          int,
   note                 varchar(200),
   primary key (id)
)

--通讯录：ID、员工ID、手机号2、分机号、邮箱、办公地点、员工状态
create table contacts
(
   id                   int not null,
   user_id              int not null,
   phone_number2        int,
   extension_number     int,
   qq_number            varchar(15),
   note                 varchar(200),
   primary key (id)
);

--用户表：员工ID、姓名、性别、职务ID、部门ID、手机号、<!--分机号、-->邮箱、办公地点、员工状态
create table SYS_USER
(
   user_id              int not null,
   user_name            varchar(10),
   sex                  int,
   position_id          int,
   dept_id              int,
   phone_number         int,
 --extension_number     int,
   email                varchar(200),
   workplace            varchar(50),
   status               int,
   primary key (user_id)
);

--固定资产:ID、编号、物品分类、所在位置、使用部门、使用人、购入日期、资产状态、备注
create table office_assets
(
   id                   int not null,
   assets_code          varchar(50),
   assets_type          int,
   position             varchar(50),
   usage_dept           int,
   usage_person         int,
   create_time          timestamp,
   usage_status         int,
   note                 varchar(200),
   primary key (id)
);

--固定资产:ID、物品名称、规格、备注、上级类别、物品类别标志
create table office_assets_type
(
   id                   int not null,
   assets_name          varchar(50),
   assets_model         varchar(50),
   parent_id            int,
   is_assets_type       int,
   primary key (id)
);

--系统参数：ID、类别、类别代码、名称、值、状态、上级参数、顺序
create table sys_parameter
(
   id                   int not null,
   type                 varchar(50),
   type_code             varchar(50),
   name                 varchar(50),
   value                varchar(50),
   status               int,
   parent_id             int,
   orders               int,
   primary key (id)
);
insert into sys_parameter values(1, '状态', 'STATUS', '可用', '0', 0, 0, 1);
insert into sys_parameter values(2, '状态', 'STATUS', '不可用', '1', 0, 0, 2);
insert into sys_parameter values(3, '使用状态', 'USAGE_STATUS', '闲置', '0', 0, 0, 1);
insert into sys_parameter values(4, '使用状态', 'USAGE_STATUS', '使用中', '1', 0, 0, 2);
insert into sys_parameter values(5, '性别', 'SEX', '男', '0', 0, 0, 1);
insert into sys_parameter values(6, '性别', 'SEX', '女', '1', 0, 0, 2);
insert into sys_parameter values(7, '通用标识：是否', 'COMMON_YN', '否', '0', 0, 0, 1);
insert into sys_parameter values(8, '通用标识：是否', 'COMMON_YN', '是', '1', 0, 0, 2);