insert into `T_Organization` (`OrgId`, `ParentId`, `OrgName`, `Foreign`, `Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('5dd8e181-f636-11e4-8bec-0601ebfb89fd', '','鸿泽', 1, '', now(), 'init', now(), 'init', 0);

insert into `T_User` (`UserId`, `FirstName`, `MiddleName`, `LastName`, `Birthday`, `Sex`, `Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('8d2b5d7c-f637-11e4-8bec-0601ebfb89fd','运维人员','','', str_to_date('20150501','%Y%m%d'), 0, '', now(), 'init', now(), 'init', 0);

insert into `R_OrgUser` (`RefId`, `OrgId`, `UserId`, `Interim`, `InvalidateDate`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values (uuid(), '5dd8e181-f636-11e4-8bec-0601ebfb89fd','8d2b5d7c-f637-11e4-8bec-0601ebfb89fd',1,str_to_date('21151212','%Y%m%d'), now(), 'init', now(), 'init', 0);

insert into `T_Account` (`AccountId`,`LoginName`,`Password`,`Status`, `Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('11900b5d-f639-11e4-8bec-0601ebfb89fd', 'maintain', 'ebfc7910077770c8340f63cd2dca2ac1f120444f', '0000', '', now(), 'init', now(), 'init', 0);

insert into `T_Role` (`RoleId`,`RoleName`,`Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('79d5498d-f63f-11e4-8bec-0601ebfb89fd','运维人员', '', now(), 'init', now(), 'init', 0);

insert into `R_UserRole` (`UserId`, `RoleId`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('5dd8e181-f636-11e4-8bec-0601ebfb89fd', '79d5498d-f63f-11e4-8bec-0601ebfb89fd',now(), 'init', now(), 'init', 0);

insert into `T_Privilege` (`PriId`,`PriName`,`Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('48f78205-f640-11e4-8bec-0601ebfb89fd','实施', '', now(), 'init', now(), 'init', 0);

insert into `R_RolePrivilege` (`RoleId`, `PriId`, `Grantable`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('79d5498d-f63f-11e4-8bec-0601ebfb89fd', '48f78205-f640-11e4-8bec-0601ebfb89fd', 1, now(), 'init', now(), 'init', 0);

insert into `T_Action` (`ActId`, `ActName`, `Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('0cb4892c-f642-11e4-8bec-0601ebfb89fd','全部', '', now(), 'init', now(), 'init', 0);

insert into `T_Action` (`ActId`, `ActName`, `Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('0cb4897b-f642-11e4-8bec-0601ebfb89fd','查询', '', now(), 'init', now(), 'init', 0);

insert into `T_Action` (`ActId`, `ActName`, `Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('8b046cc4-f642-11e4-8bec-0601ebfb89fd','新建', '', now(), 'init', now(), 'init', 0);

insert into `T_Action` (`ActId`, `ActName`, `Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('8b046d19-f642-11e4-8bec-0601ebfb89fd','修改', '', now(), 'init', now(), 'init', 0);

insert into `T_Action` (`ActId`, `ActName`, `Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('1504990e-f643-11e4-8bec-0601ebfb89fd','删除', '', now(), 'init', now(), 'init', 0);

insert into `T_Action` (`ActId`, `ActName`, `Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('4fb54a21-f643-11e4-8bec-0601ebfb89fd','废弃', '', now(), 'init', now(), 'init', 0);

insert into `D_ResClass` (`ResClassId`, `ResClassName`,`Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('52a6895e-0b07-0710-3b16-4a77757f877c','菜单', '', now(), 'init', now(), 'init', 0);

insert into `D_ResClass` (`ResClassId`, `ResClassName`,`Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('639c5771-9976-1fc7-6774-6300af88e601','数据项', '', now(), 'init', now(), 'init', 0);

insert into `D_ResClass` (`ResClassId`, `ResClassName`,`Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('2ae1fd6c-5896-fa4c-0f7c-9b45a29f9401','数据范围', '', now(), 'init', now(), 'init', 0);

insert into `D_ResClass` (`ResClassId`, `ResClassName`,`Description`, `CreateTime`, `Creator`, `ModifyTime`, `Operator`, `Test`)
values ('411a9e66-30ea-fa41-5a94-b81e0d235145','功能', '', now(), 'init', now(), 'init', 0);















