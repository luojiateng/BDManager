#查看教师的学校信息
select tea_id, tea_name, gender, email, depName, titleName, positionName
from teacher
         inner join dept
                    on dept.dep_id = teacher.dept_id
         inner join title
                    on title.titleId = teacher.title_id
         inner join postion
                    on postion.positionId = people.teacher.postion_id

#查看教师的学籍经历

select tea_edu.tea_id, tea_name,school_name, edu_name, btime, etime
from teacher
         right join tea_edu on teacher.tea_id = tea_edu.tea_id
         right join edu_type
                    on edu_type.edu_id = tea_edu.edu_type
        right join school s on tea_edu.school_id = s.school_id
order by tea_id;

#查看教师的家庭关系
select teacher.tea_id, tea_name, fam_type_name, memer_name
from teacher
         right join family
                    on teacher.tea_id = family.teacher_id
         right join fam_type
                    on fam_type.fam_id = family.home_member
order by teacher_id;

use people;
#查看教师的奖惩信息
select teacher_id, tea_name,ap_type,time,`desc`
from teacher
         right join award_punish
                    on teacher.tea_id = award_punish.teacher_id
         right join ap_type on award_punish.type = ap_type.ap_id
order by teacher_id;
#查看各部门教职工数量

###触发器：增加教职工时，增加响应部门的人数
-- Triggers structure for table student
DROP TRIGGER IF EXISTS `email__check`;
delimiter ;;
CREATE TRIGGER `email__check`
    BEFORE INSERT
    ON `teacher`
    FOR EACH ROW
begin
    if (new.email regexp '^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$') then
        set new.email = new.email;
    else
        set new.email = 'null';
    end if;
end
;;
delimiter ;

-- Triggers structure for table student
DROP TRIGGER IF EXISTS `add_teaNumber`;
delimiter ;;
CREATE TRIGGER `add_teaNumber`
    AFTER INSERT
    ON `teacher`
    FOR EACH ROW
begin
    update dept set teaNum=teaNum + 1 where dep_id = NEW.dept_id;
end
;;
delimiter ;

-- Triggers structure for table student
DROP TRIGGER IF EXISTS `delete_teaNumber`;
delimiter ;;
CREATE TRIGGER `delete_teaNumber`
    AFTER DELETE
    ON `teacher`
    FOR EACH ROW
begin
    update dept set teaNum=dept.teaNum - 1 where dep_id = OLD.dept_id;
end
;;
delimiter ;

###触发器：保证email输入正确
###

#家庭成员视图


drop procedure if exists dept_show;
delimiter $$
create procedure dept_show(in deptName varchar(30))
begin
    select dep_id, depName, titleName, count(*) as titNumber
    from teacher
             right join title t on t.titleId = teacher.title_id
             right join dept d on d.dep_id = teacher.dept_id
    where depName = deptName
    group by t.titleName;
end;
$$
delimiter ;

call dept_show('计算机学院');

