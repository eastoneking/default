delete from yl_ghtaizhang;
delete from yl_ghshoufei;
delete from yl_yszhenduan;
delete from yl_yszdyaopin;


select
    id as `zlfwId`,
    name as `name`,
    `value` as `value`
from sys_parameter
where `type_code`='ZLFW'
order by `orders`
;