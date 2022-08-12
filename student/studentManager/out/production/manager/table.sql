#建库
drop database if exists ssm;
create database ssm;
use ssm;
#建表
-- ----------------------------
-- Table structure for faculty
-- ----------------------------
DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty`
(
    `facultyId`   int(4)                                                 NOT NULL AUTO_INCREMENT,
    `facultyName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`facultyId`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`
(
    `majorId`   int(4)                                                 NOT NULL AUTO_INCREMENT,
    `majorName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `faculty`   int(4)                                                 NOT NULL,
    PRIMARY KEY (`majorId`) USING BTREE,
    INDEX `m_f` (`faculty`) USING BTREE,
    CONSTRAINT `m_f` FOREIGN KEY (`faculty`) REFERENCES `faculty` (`facultyId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for classinfo
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo`
(
    `classId`       int(4)                                                 NOT NULL AUTO_INCREMENT,
    `className`     varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `studentNumber` int(4)                                                 NOT NULL,
    `major`         int(4)                                                 NOT NULL,
    PRIMARY KEY (`classId`) USING BTREE,
    INDEX `c_m` (`major`) USING BTREE,
    CONSTRAINT `c_m` FOREIGN KEY (`major`) REFERENCES `major` (`majorId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `studentId`   int(4)                                                 NOT NULL AUTO_INCREMENT,
    `studentName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `gender`      varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `classInfo`   int(4)                                                 NOT NULL,
    `GPA`         double                                                 NOT NULL,
    `award`       int(4)                                                 NOT NULL,
    `sacution`    int(255)                                               NOT NULL,
    PRIMARY KEY (`studentId`) USING BTREE,
    INDEX `s_c` (`classInfo`) USING BTREE,
    CONSTRAINT `s_c` FOREIGN KEY (`classInfo`) REFERENCES `classinfo` (`classId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 247
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Triggers structure for table student
-- ----------------------------
DROP TRIGGER IF EXISTS `sex__check`;
delimiter $$
CREATE TRIGGER `sex__check`
    BEFORE INSERT
    ON `student`
    FOR EACH ROW
begin
    if (new.gender = '女' or new.gender = '男') then
        set new.gender = new.gender;
    else
        set new.gender = 'null';
    end if;
end
$$
delimiter ;

-- ----------------------------
-- Triggers structure for table student
-- ----------------------------
DROP TRIGGER IF EXISTS `add_studentNumber`;
delimiter ;;
CREATE TRIGGER `add_studentNumber`
    AFTER INSERT
    ON `student`
    FOR EACH ROW
begin
    update classinfo set studentNumber=studentNumber + 1 where classId = NEW.classInfo;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table student
-- ----------------------------
DROP TRIGGER IF EXISTS `delete_studentNumber`;
delimiter ;;
CREATE TRIGGER `delete_studentNumber`
    AFTER DELETE
    ON `student`
    FOR EACH ROW
begin
    update classinfo set studentNumber=studentNumber - 1 where classId = OLD.classInfo;
end
;;
delimiter ;


#创建存储过程
#新建查看专业男女生的存储过程
drop procedure if exists major_show;
delimiter $$
create procedure major_show()
begin
    select major.majorId, major.majorName, a.studentNumber, g.grilNumber, b.boyNumber, faculty.facultyName
    from (select major.majorId, count(*) as boyNumber
          from student
                   inner join classinfo
                   inner join major
                   inner join faculty
          where student.classInfo = classinfo.classId
            and classInfo.major = major.majorId
            and student.gender = '男'
          group by major) b
             inner join (select major.majorId, count(*) as grilNumber
                         from student
                                  inner join classinfo
                                  inner join major
                                  inner join faculty
                         where student.classInfo = classinfo.classId
                           and classInfo.major = major.majorId
                           and student.gender = '女'
                         group by major) g
             inner join(select major.majorId, count(*) as studentNumber
                        from student
                                 inner join classinfo
                                 inner join major
                                 inner join faculty
                        where student.classInfo = classinfo.classId
                          and classInfo.major = major.majorId
                        group by major) a
             inner join faculty
             inner join major
    where a.majorId = major.majorId
      and b.majorId = major.majorId
      and g.majorId = major.majorId
      and major.faculty = faculty.facultyId;
end;
$$
delimiter ;


#创建学院的男女信息存储过程
drop procedure if exists faculty_show;
delimiter $$
create procedure faculty_show()
begin
    select faculty.facultyId, faculty.facultyName, a.studentNumber, g.girlNumber, b.boyNumber
    from (select count(*) as girlNumber, facultyid
          from student
                   inner join classinfo
                   inner join major
                   inner join faculty
          where student.classInfo = classinfo.classId
            and classInfo.major = major.majorId
            and major.faculty = faculty.facultyId
            and student.gender = '女'
          group by faculty) g
             inner join (select count(*) as boyNumber, facultyid
                         from student
                                  inner join classinfo
                                  inner join major
                                  inner join faculty
                         where student.classInfo = classinfo.classId
                           and classInfo.major = major.majorId
                           and major.faculty = faculty.facultyId
                           and student.gender = '男'
                         group by faculty) b
             inner join (select count(*) as studentNumber, facultyid
                         from student
                                  inner join classinfo
                                  inner join major
                                  inner join faculty
                         where student.classInfo = classinfo.classId
                           and classInfo.major = major.majorId
                           and major.faculty = faculty.facultyId
                         group by faculty) a
             inner join classinfo
             inner join major
             inner join faculty
    where a.facultyId = faculty.facultyId
      and g.facultyId = faculty.facultyId
      and b.facultyId = faculty.facultyId
      and classinfo.major = major.majorId
      and major.faculty = faculty.facultyId
    group by facultyName
    order by facultyId;
end;
$$
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
#班级视图创建
drop VIEW if exists classview;
CREATE VIEW `ssm`.`classview` AS
SELECT `ssm`.`classinfo`.`classId`   AS `classId`,
       `ssm`.`classinfo`.`className` AS `className`,
       `a`.`studentNumber`           AS `studentNumber`,
       `g`.`grilNumber`              AS `grilNumber`,
       `b`.`boyNumber`               AS `boyNumber`,
       `ssm`.`major`.`majorName`     AS `majorName`,
       `ssm`.`faculty`.`facultyName` AS `facultyName`
FROM (((((((
    SELECT `ssm`.`student`.`classInfo`   AS `classId`,
           count(0)                      AS `boyNumber`,
           `ssm`.`classinfo`.`className` AS `className`
    FROM (`ssm`.`student`
             JOIN `ssm`.`classinfo` )
    WHERE ((
               `ssm`.`student`.`classInfo` = `ssm`.`classinfo`.`classId`
               )
        AND (`ssm`.`student`.`gender` = '男'))
    GROUP BY `ssm`.`student`.`classInfo`
)) `b`
    JOIN (
        SELECT `ssm`.`student`.`classInfo`   AS `classId`,
               count(0)                      AS `grilNumber`,
               `ssm`.`classinfo`.`className` AS `className`
        FROM (`ssm`.`student`
                 JOIN `ssm`.`classinfo` )
        WHERE ((
                   `ssm`.`student`.`classInfo` = `ssm`.`classinfo`.`classId`
                   )
            AND (`ssm`.`student`.`gender` = '女'))
        GROUP BY `ssm`.`student`.`classInfo`
    ) `g`
    )
    JOIN (
        SELECT `ssm`.`student`.`classInfo`   AS `classId`,
               count(0)                      AS `studentNumber`,
               `ssm`.`classinfo`.`className` AS `className`
        FROM (`ssm`.`student`
                 JOIN `ssm`.`classinfo` )
        WHERE (`ssm`.`student`.`classInfo` = `ssm`.`classinfo`.`classId`)
        GROUP BY `ssm`.`student`.`classInfo`
    ) `a`
    )
    JOIN `ssm`.`classinfo`
    )
    JOIN `ssm`.`major`
          )
         JOIN `ssm`.`faculty`
    )
WHERE ((
           `a`.`classId` = `ssm`.`classinfo`.`classId`
           )
    AND (`b`.`classId` = `ssm`.`classinfo`.`classId`)
    AND (`g`.`classId` = `ssm`.`classinfo`.`classId`)
    AND (`ssm`.`classinfo`.`major` = `ssm`.`major`.`majorId`)
    AND (`ssm`.`major`.`faculty` = `ssm`.`faculty`.`facultyId`));

#专业视图创建
drop VIEW if exists majorview;
CREATE VIEW `ssm`.`majorview` AS
SELECT `ssm`.`major`.`majorId`       AS `majorId`,
       `ssm`.`major`.`majorName`     AS `majorName`,
       `a`.`studentNumber`           AS `studentNumber`,
       `g`.`grilNumber`              AS `grilNumber`,
       `b`.`boyNumber`               AS `boyNumber`,
       `ssm`.`faculty`.`facultyName` AS `facultyName`
FROM ((((((
    SELECT `ssm`.`major`.`majorId` AS `majorId`,
           count(0)                AS `boyNumber`
    FROM ((( `ssm`.`student` JOIN `ssm`.`classinfo` ) JOIN `ssm`.`major` )
             JOIN `ssm`.`faculty` )
    WHERE ((
               `ssm`.`student`.`classInfo` = `ssm`.`classinfo`.`classId`
               )
        AND (`ssm`.`classinfo`.`major` = `ssm`.`major`.`majorId`)
        AND (`ssm`.`student`.`gender` = '男'))
    GROUP BY `ssm`.`classinfo`.`major`
)) `b`
    JOIN (
        SELECT `ssm`.`major`.`majorId` AS `majorId`,
               count(0)                AS `grilNumber`
        FROM ((( `ssm`.`student` JOIN `ssm`.`classinfo` ) JOIN `ssm`.`major` )
                 JOIN `ssm`.`faculty` )
        WHERE ((
                   `ssm`.`student`.`classInfo` = `ssm`.`classinfo`.`classId`
                   )
            AND (`ssm`.`classinfo`.`major` = `ssm`.`major`.`majorId`)
            AND (`ssm`.`student`.`gender` = '女'))
        GROUP BY `ssm`.`classinfo`.`major`
    ) `g`
    )
    JOIN (
        SELECT `ssm`.`major`.`majorId` AS `majorId`,
               count(0)                AS `studentNumber`
        FROM ((( `ssm`.`student` JOIN `ssm`.`classinfo` ) JOIN `ssm`.`major` )
                 JOIN `ssm`.`faculty` )
        WHERE ((
                   `ssm`.`student`.`classInfo` = `ssm`.`classinfo`.`classId`
                   )
            AND (`ssm`.`classinfo`.`major` = `ssm`.`major`.`majorId`))
        GROUP BY `ssm`.`classinfo`.`major`
    ) `a`
    )
    JOIN `ssm`.`faculty`
          )
         JOIN `ssm`.`major`
    )
WHERE ((
           `a`.`majorId` = `ssm`.`major`.`majorId`
           )
    AND (`b`.`majorId` = `ssm`.`major`.`majorId`)
    AND (`g`.`majorId` = `ssm`.`major`.`majorId`)
    AND (`ssm`.`major`.`faculty` = `ssm`.`faculty`.`facultyId`))
ORDER BY `ssm`.`major`.`majorId`;

#学生视图创建
drop VIEW if exists studentview;
CREATE VIEW `ssm`.`studentview` AS
SELECT `student`.`studentId`   AS `studentId`,
       `student`.`studentName` AS `studentName`,
       `student`.`gender`      AS `gender`,
       `classinfo`.`className` AS `className`,
       `major`.`majorName`     AS `majorName`,
       `faculty`.`facultyName` AS `facultyName`,
       `student`.`GPA`         AS `GPA`,
       `student`.`award`       AS `award`,
       `student`.`sacution`    AS `sacution`
FROM ((( `student` JOIN `classinfo` ) JOIN `major` )
         JOIN `faculty` )
WHERE ((
           `student`.`classInfo` = `classinfo`.`classId`
           )
    AND (`classinfo`.`major` = `major`.`majorId`)
    AND (`major`.`faculty` = `faculty`.`facultyId`))
ORDER BY `student`.`studentId`;
#学院视图创建
drop VIEW if exists facultyview;
CREATE VIEW `ssm`.`facultyview` AS
SELECT `ssm`.`faculty`.`facultyId`   AS `facultyId`,
       `ssm`.`faculty`.`facultyName` AS `facultyName`,
       `a`.`studentNumber`           AS `studentNumber`,
       `g`.`girlNumber`              AS `girlNumber`,
       `b`.`boyNumber`               AS `boyNumber`
FROM (((((((
    SELECT count(0)                    AS `girlNumber`,
           `ssm`.`faculty`.`facultyId` AS `facultyid`
    FROM ((( `ssm`.`student` JOIN `ssm`.`classinfo` ) JOIN `ssm`.`major` )
             JOIN `ssm`.`faculty` )
    WHERE ((
               `ssm`.`student`.`classInfo` = `ssm`.`classinfo`.`classId`
               )
        AND (`ssm`.`classinfo`.`major` = `ssm`.`major`.`majorId`)
        AND (`ssm`.`major`.`faculty` = `ssm`.`faculty`.`facultyId`)
        AND (`ssm`.`student`.`gender` = '女'))
    GROUP BY `ssm`.`major`.`faculty`
)) `g`
    JOIN (
        SELECT count(0)                    AS `boyNumber`,
               `ssm`.`faculty`.`facultyId` AS `facultyid`
        FROM ((( `ssm`.`student` JOIN `ssm`.`classinfo` ) JOIN `ssm`.`major` )
                 JOIN `ssm`.`faculty` )
        WHERE ((
                   `ssm`.`student`.`classInfo` = `ssm`.`classinfo`.`classId`
                   )
            AND (`ssm`.`classinfo`.`major` = `ssm`.`major`.`majorId`)
            AND (`ssm`.`major`.`faculty` = `ssm`.`faculty`.`facultyId`)
            AND (`ssm`.`student`.`gender` = '男'))
        GROUP BY `ssm`.`major`.`faculty`
    ) `b`
    )
    JOIN (
        SELECT count(0)                    AS `studentNumber`,
               `ssm`.`faculty`.`facultyId` AS `facultyid`
        FROM ((( `ssm`.`student` JOIN `ssm`.`classinfo` ) JOIN `ssm`.`major` )
                 JOIN `ssm`.`faculty` )
        WHERE ((
                   `ssm`.`student`.`classInfo` = `ssm`.`classinfo`.`classId`
                   )
            AND (`ssm`.`classinfo`.`major` = `ssm`.`major`.`majorId`)
            AND (`ssm`.`major`.`faculty` = `ssm`.`faculty`.`facultyId`))
        GROUP BY `ssm`.`major`.`faculty`
    ) `a`
    )
    JOIN `ssm`.`classinfo`
    )
    JOIN `ssm`.`major`
          )
         JOIN `ssm`.`faculty`
    )
WHERE ((
           `a`.`facultyid` = `ssm`.`faculty`.`facultyId`
           )
    AND (`g`.`facultyid` = `ssm`.`faculty`.`facultyId`)
    AND (`b`.`facultyid` = `ssm`.`faculty`.`facultyId`)
    AND (`ssm`.`classinfo`.`major` = `ssm`.`major`.`majorId`)
    AND (`ssm`.`major`.`faculty` = `ssm`.`faculty`.`facultyId`))
GROUP BY `ssm`.`faculty`.`facultyName`
ORDER BY `ssm`.`faculty`.`facultyId`;
#插入数据
#学院
INSERT INTO `faculty`
VALUES (1, '计算机学院');
INSERT INTO `faculty`
VALUES (2, '机械学院');
INSERT INTO `faculty`
VALUES (3, '经济管理学院');
INSERT INTO `faculty`
VALUES (6, '人文学院');
INSERT INTO `faculty`
VALUES (7, '化工学院');
# 专业
INSERT INTO `major`
VALUES (1, '计算机科学', 1);
INSERT INTO `major`
VALUES (2, '软件工程', 1);
INSERT INTO `major`
VALUES (3, '机械设计的', 2);
INSERT INTO `major`
VALUES (4, '土木工程', 2);
INSERT INTO `major`
VALUES (5, '国际贸易', 3);
INSERT INTO `major`
VALUES (8, '中文', 6);
INSERT INTO `major`
VALUES (9, '化学', 7);
# 班级
INSERT INTO `classinfo`
VALUES (1, '计科1901', 39, 1);
INSERT INTO `classinfo`
VALUES (2, '计科1902', 20, 1);
INSERT INTO `classinfo`
VALUES (3, '软件1901', 14, 2);
INSERT INTO `classinfo`
VALUES (4, '软件1902', 20, 2);
INSERT INTO `classinfo`
VALUES (5, '机械1901', 20, 3);
INSERT INTO `classinfo`
VALUES (6, '机械1902', 14, 3);
INSERT INTO `classinfo`
VALUES (7, '土木1901', 20, 4);
INSERT INTO `classinfo`
VALUES (8, '土木1902', 14, 4);
INSERT INTO `classinfo`
VALUES (9, '国贸1901', 19, 5);
INSERT INTO `classinfo`
VALUES (10, '国贸1902', 8, 5);
INSERT INTO `classinfo`
VALUES (11, '会计1901', 20, 5);
INSERT INTO `classinfo`
VALUES (13, '通信1901', 0, 2);
INSERT INTO `classinfo`
VALUES (14, '通信1902', 2, 5);
INSERT INTO `classinfo`
VALUES (16, '中文1901', 12, 8);
INSERT INTO `classinfo`
VALUES (17, '化工1901', 0, 9);
#学生
INSERT INTO `student`
VALUES (1, '霍凯杰', '男', 4, 2.1, 0, 0);
INSERT INTO `student`
VALUES (2, '甄秋', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (3, '柳玉瑶', '男', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (4, '乌菲', '女', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (5, '武义', '男', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (6, '黄波', '女', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (7, '刘峰', '男', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (8, '包凯蓉', '女', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (9, '满彬', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (10, '昌文', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (11, '柳金萍', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (12, '庄易友', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (13, '游被芬', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (14, '辕令瑗', '男', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (15, '益华', '女', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (16, '荣义珊', '男', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (17, '郁和', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (18, '薛栋', '男', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (19, '娄钰友', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (20, '延羊秀', '男', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (21, '庞杰', '女', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (22, '荣礼瑾', '男', 10, 0, 0, 0);
INSERT INTO `student`
VALUES (23, '霍婵', '女', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (24, '戴莺', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (25, '施金洁', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (26, '门呼上维', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (27, '山易亨', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (28, '弓菊', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (29, '张飞', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (30, '雪河', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (52, '嘉城', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (53, '文文', '女', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (54, '采集', '男', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (55, '荣礼瑾', '男', 4, 2.1, 0, 0);
INSERT INTO `student`
VALUES (56, '霍婵', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (57, '戴莺', '男', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (58, '施金洁', '女', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (59, '门呼上维', '男', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (60, '束纯', '女', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (61, '山易亨', '男', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (62, '弓菊', '女', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (63, '岑电真', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (64, '陈超', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (65, '时琬', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (66, '鲁学', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (67, '封华', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (68, '崔雅', '男', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (69, '郁马弘', '女', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (70, '邓义启', '男', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (71, '刁中艳', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (72, '韶忠芳', '男', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (73, '红马广', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (74, '钟离马榕', '男', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (75, '宣新', '女', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (76, '逄民', '男', 10, 0, 0, 0);
INSERT INTO `student`
VALUES (77, '萧友刚', '女', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (78, '甄九贞', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (79, '牛上武', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (80, '葛孝平', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (81, '左振', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (82, '王文', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (83, '隗凯力', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (84, '屈林', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (85, '陶仁洁', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (86, '田卡冰', '女', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (87, '梅瑞', '男', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (88, '云君', '男', 4, 2.1, 0, 0);
INSERT INTO `student`
VALUES (89, '容霞', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (90, '罗飘', '男', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (91, '粱怡', '女', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (92, '呼延金义', '男', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (93, '顾士', '女', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (94, '韶贝融', '男', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (95, '龚电滢', '女', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (96, '贺凡', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (97, '龙豪', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (98, '左贝艺', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (99, '符俊', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (100, '弓歌时', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (101, '芮忠义', '男', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (102, '方艳', '女', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (103, '边君', '男', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (104, '乐礼佳', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (105, '葛承', '男', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (106, '云燕', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (107, '史春', '男', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (108, '殴清', '女', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (109, '滕伊', '男', 10, 0, 0, 0);
INSERT INTO `student`
VALUES (110, '满马蕊', '女', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (111, '骆昌', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (112, '车澜', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (113, '寿琼', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (114, '尤庆', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (115, '万策', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (116, '裴友国', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (117, '刘琦', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (118, '刁维', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (119, '荣凯琛', '女', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (120, '侯诸蓓', '男', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (121, '田器雅', '男', 4, 2.1, 0, 0);
INSERT INTO `student`
VALUES (122, '尤钰荣', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (123, '国谦', '男', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (124, '步以', '女', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (125, '胡友馨', '男', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (126, '许礼成', '女', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (127, '乌姣', '男', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (128, '高中信', '女', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (129, '戚瑾', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (130, '赵歌妍', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (131, '巴伊', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (132, '符笑强', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (133, '牧卡珠', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (134, '卜卿', '男', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (135, '芮器学', '女', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (136, '淳于琛', '男', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (137, '晋都星', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (138, '奚飞', '男', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (139, '范聪', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (140, '跋夹易德', '男', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (141, '郁卡裕', '女', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (142, '邵策', '男', 10, 0, 0, 0);
INSERT INTO `student`
VALUES (143, '陶笑和', '女', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (144, '衡玉娟', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (145, '耿九行', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (146, '傅春', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (147, '孔元', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (148, '薛平', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (149, '童有', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (150, '苍都玲', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (151, '殴金林', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (152, '和信绍', '女', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (153, '卫枫', '男', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (154, '左巧', '男', 4, 2.1, 0, 0);
INSERT INTO `student`
VALUES (155, '邬行', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (156, '景义璐', '男', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (157, '程孝莉', '女', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (158, '狄礼妍', '男', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (159, '鲁钰翔', '女', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (160, '霍易琴', '男', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (161, '诸葛以', '女', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (162, '刘霭', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (163, '申屠策', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (164, '奚仁思', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (165, '谷宰亚', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (166, '劳钰秀', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (167, '舌微世', '男', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (168, '通壮', '女', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (169, '包友', '男', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (170, '闻人器蓓', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (171, '储天', '男', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (172, '云卡叶', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (173, '冉娴', '男', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (174, '俞先', '女', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (175, '林蓉', '男', 10, 0, 0, 0);
INSERT INTO `student`
VALUES (176, '陈松', '女', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (177, '方伊', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (178, '殷金妍', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (179, '刁谦', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (180, '东方嘉', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (181, '柳易璧', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (182, '东易和', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (183, '计贝哲', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (184, '潘凝', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (185, '夹谷昌', '女', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (186, '董都伯', '男', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (187, '谷友凝', '男', 4, 2.1, 0, 0);
INSERT INTO `student`
VALUES (188, '殴金希', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (189, '居星', '男', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (190, '盖上颖', '女', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (191, '盛易韵', '男', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (192, '百里仁栋', '女', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (193, '雷无聪', '男', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (194, '都菊', '女', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (195, '席进', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (196, '干利', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (197, '宗梁', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (198, '巴珠', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (199, '孙被维', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (200, '松玉哲', '男', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (201, '安欣', '女', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (202, '杭凤', '男', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (203, '吕广', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (204, '诸电冰', '男', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (205, '韶被义', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (206, '卞孝龙', '男', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (207, '林无思', '女', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (208, '官欧上盛', '男', 10, 0, 0, 0);
INSERT INTO `student`
VALUES (209, '江凯慧', '女', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (210, '茹卿', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (211, '单于贝伊', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (212, '卫九策', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (213, '成有', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (214, '邱叶', '男', 1, 2.5, 0, 0);
INSERT INTO `student`
VALUES (215, '乔无旭', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (216, '凤凯宜', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (217, '殴金庆', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (218, '叶炎', '女', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (219, '范电香', '男', 16, 0, 0, 0);
INSERT INTO `student`
VALUES (220, '甄被辰', '男', 4, 2.1, 0, 0);
INSERT INTO `student`
VALUES (221, '翁君', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (222, '陶上江', '男', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (223, '姜仁宁', '女', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (224, '万器霞', '男', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (225, '龚礼蓓', '女', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (226, '向忠羽', '男', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (227, '郑信馥', '女', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (228, '符宜', '男', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (229, '乔智成', '女', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (230, '危嘉', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (231, '曹歌枫', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (232, '益霭', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (233, '计筠', '男', 2, 0, 0, 0);
INSERT INTO `student`
VALUES (234, '冀澜', '女', 3, 0, 0, 0);
INSERT INTO `student`
VALUES (235, '危都萍', '男', 4, 0, 0, 0);
INSERT INTO `student`
VALUES (236, '戴歌玲', '女', 5, 0, 0, 0);
INSERT INTO `student`
VALUES (237, '祁莉', '男', 6, 0, 0, 0);
INSERT INTO `student`
VALUES (238, '侯礼蓉', '女', 7, 0, 0, 0);
INSERT INTO `student`
VALUES (239, '屈中先', '男', 8, 0, 0, 0);
INSERT INTO `student`
VALUES (240, '唐克', '女', 9, 0, 0, 0);
INSERT INTO `student`
VALUES (241, '姚薇', '男', 10, 0, 0, 0);
INSERT INTO `student`
VALUES (242, '屈锦', '女', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (243, '盛凯滢', '男', 11, 0, 0, 0);
INSERT INTO `student`
VALUES (244, '羊上军', '男', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (245, '尹被珍', '女', 1, 0, 0, 0);
INSERT INTO `student`
VALUES (246, '禹士', '男', 1, 2.5, 0, 0);








