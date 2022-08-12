drop database if exists pas;
create database pas;
use pas;
/****************table1 老师基本信息表*******************/
create table teacher(
   teaNum               char(8)                        not null,
   teaName              varchar(20)                    not null,
   teaTitle             varchar(20)                    not null,
   teaTypeId            varchar(20)                    not null,
   -- 1上课老师 2 导员
   teaBtd               datetime                       not null,
   pwd                  varchar(20)                    not null,
   state                int                            not null,
   roleId               int                            not null,
   key1                 varchar(20)                    null,
   key2                 int                            null
);
alter table teacher  add constraint PK_teaNum  primary key (teaNum);
/*
alter table 表名 change COLUMN 列名
列名 数据类型 default VALUE;
*/
alter table teacher 
change COLUMN roleId
roleId int default 1;

/****************table2 班级表*******************/
drop table if exists classInfo;
create table classInfo (
   clsId                int         auto_increment primary key,
   clsName              char(10)                       not null,
   grade                date                           not null,
   stuCount             int                            not null default 0,
   teaNum               char(8)                        not null,
   key1                 varchar(20)                    null,
   key2                 int                            null
);
alter table classInfo add constraint FK_teacher_classInfo_teaNum
	foreign key(teaNum) references teacher (teaNum);
/*
alter table classInfo  change COLUMN stuCount
stuCount int default 0;*/
/****************table3 学生信息表*******************/
drop table if exists student;
create table student (
   stuNum               char(12)                       not null,
   clsId                int                            not null,
   stuName              varchar(20)                    not null,
   stuBtd               date                           not null,
   pwd                  varchar(20)                    not null,
   state                int                            not null,
   sex                  bool                           not null, 
   roleId               int                            not null,
   key1                 varchar(20)                    null,
   key2                 int                            null
);
alter table student add constraint PK_stuNum
	primary key (stuNum);
alter table student add constraint FK_classInfo_student_clsId
	foreign key (clsId) references classInfo (clsId);
alter table student change COLUMN roleId
roleId int default 1;
/****************table4 找回密码*******************/
create table restPwd (
   stuNum               char(12)                       not null,
   question1            varchar(20)                    null,
   answer1              varchar(20)                    null,
   question2            varchar(20)                    null,
   answer2              varchar(20)                    null,
   question3            varchar(20)                    null,
   answer3              varchar(20)                    null,
   requestCount         int                            null
);
alter table restPwd add constraint PK_restPwd_stuNum
	primary key (stuNum);
alter table restPwd add constraint FK_student_restPwd_stuNum
	foreign key (stuNum) references student(stuNum);
alter table restPwd change COLUMN requestCount
requestCount int default 0;

/****************table5 课程基本信息表*******************/
create table lesson (
   lesId                int  auto_increment primary key,
   lesName              varchar(20)                    not null,
   context              varchar(20)                    not null,
   score                int                            not null,
   hours                int                            not null
);
/****************table6 课程安排表 *******************/
create table courseArrangement (
   caId                 int auto_increment primary key,
   lesId                int                            not null,
   teaNum               char(8)                        not null,
   clsId                int                            not null,
   year                 int                            not null,
   semester             int                            not null
);
alter table courseArrangement add constraint FK_classInfo_ca_clsId
	foreign key (clsId) references classInfo (clsId);
alter table courseArrangement add constraint FK_teacher_ca_teaNum
	foreign key (teaNum) references teacher (teaNum);
alter table courseArrangement add constraint FK_lesson_ca_lesId
	foreign key (lesId) references lesson (lesId);
	
/****************table7 考试安排表 *******************/
create table examSchedule (
   esId                 int    auto_increment primary key,
   caId                 int                            not null,
   examDate             date                           not null,
   state                int                            not null,
   context              varchar(20)                    not null
);
alter table examSchedule add constraint FK_caIdExamSchedule 
	foreign key (caId) references courseArrangement (caId);
	
/****************table8 考试成绩表 *******************/
create table score (
   scoreId              int      auto_increment primary key,
   esId                 int                            not null,
   stuNum               char(12)                       not null,
   score                int                            not null
);

alter table score add constraint FK_esIdScore
	foreign key (esId) references examSchedule (esId);
alter table score add constraint FK_stuNumScore
	foreign key (stuNum) references student (stuNum);

	
	
	













