-- 数据库名	dbHStudent
-- 版本		SQLServer2008R2
-- 学生表
create table Student
(
	ID		varchar(20)		not null,
	Name	varchar(40)		not null,
	primary key(ID)
);

insert into Student values('101',N'张三');
insert into Student values('102',N'李四');
insert into Student values('103',N'王五');