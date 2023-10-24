drop table user_details;
drop table status_details;
drop table module_details;
drop table role_details;

desc status_details;
desc user_details;
desc module_details;
desc role_details;

select * from status_details;
select * from user_details;
select * from module_details;
select * from role_details;

DELETE FROM user_details; 


-- insert queries


insert into status_details values(1,'Approved');
insert into status_details values(2,'Reject');
insert into status_details values(3,'New');

insert into role_details values(1,'User');
insert into role_details values(2,'Admin');
insert into role_details values(3,'Account Admin');

insert into module_details values(1,'Module 1');
insert into module_details values(2,'Module 2');
insert into module_details values(3,'Module 3');

commit;





--level 1
select ud.user_id as userId, ud.name as name,(select ROLE_NAME from role_Details where ROLE_ID = ud.role_id ) as role,(select md.MODULE_NAME from module_Details md where md.MODULE_ID = ud.MODILE_ID) as moduleName 
from user_details ud where  
ud.enrolled =(select status_id from status_details where STATUS_NAME like 'Approved') and 
ud.STATUS_LEVEL_I =(select status_id from status_details where STATUS_NAME like 'New');




--//level 2
select ud.user_id as userId, ud.name as name,(select ROLE_NAME from role_Details where ROLE_ID = ud.role_id ) as role,(select md.MODULE_NAME from module_Details md where md.MODULE_ID = ud.MODILE_ID) as moduleName 
from user_details ud where  
ud.enrolled =(select status_id from status_details where STATUS_NAME like 'Approved') and 
ud.STATUS_LEVEL_I =(select status_id from status_details where STATUS_NAME like 'Approved')and
ud.STATUS_LEVEL_II =(select status_id from status_details where STATUS_NAME like 'New');

--level 2
select ud.user_id as userId, ud.name as name,(select ROLE_NAME from role_Details where ROLE_ID = ud.role_id ) as role,(select md.MODULE_NAME from module_Details md where md.MODULE_ID = ud.MODILE_ID) as moduleName   
from user_details ud where 
ud.enrolled =(select status_id from status_details where STATUS_NAME like 'Approved') and 
ud.STATUS_LEVEL_I =(select status_id from status_details where STATUS_NAME like 'Approved')and
ud.STATUS_LEVEL_II =(select status_id from status_details where STATUS_NAME like 'New');


select ud.user_id as userId, ud.name as name,(select ROLE_NAME from role_Details where ROLE_ID = ud.role_id ) as role,(select md.MODULE_NAME from module_Details md where md.MODULE_ID = ud.MODILE_ID) as moduleName  from user_details ud where  ud.enrolled =(select status_id from status_details where STATUS_NAME like 'Approved') and  ud.STATUS_LEVEL_I =(select status_id from status_details where STATUS_NAME like 'Approved')and ud.STATUS_LEVEL_II =(select status_id from status_details where STATUS_NAME like 'New')
