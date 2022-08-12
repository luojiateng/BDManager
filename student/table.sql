/*
 Navicat Premium Data Transfer

 Source Server         : 57版本
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : abc

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 31/12/2021 03:08:13
*/
drop database if exists abc;
create database abc;
use abc;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ap_type
-- ----------------------------
DROP TABLE IF EXISTS `ap_type`;
CREATE TABLE `ap_type`
(
    `ap_id`   int(4)                                                 NOT NULL AUTO_INCREMENT,
    `ap_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`ap_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ap_type
-- ----------------------------
INSERT INTO `ap_type`
VALUES (1, '奖励');
INSERT INTO `ap_type`
VALUES (2, '处罚');

-- ----------------------------
-- Table structure for award_punish
-- ----------------------------
DROP TABLE IF EXISTS `award_punish`;
CREATE TABLE `award_punish`
(
    `ap_id`      int(4)                                                  NOT NULL AUTO_INCREMENT,
    `student_id` int(4)                                                  NOT NULL,
    `ap_type`    int(4)                                                  NOT NULL,
    `time`       date                                                    NOT NULL,
    `desc`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`ap_id`) USING BTREE,
    INDEX `e` (`ap_type`) USING BTREE,
    INDEX `ap_student` (`student_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 38
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of award_punish
-- ----------------------------
INSERT INTO `award_punish`
VALUES (2, 2, 2, '2020-06-28', '处罚2');
INSERT INTO `award_punish`
VALUES (3, 3, 2, '2022-05-28', '处罚3');
INSERT INTO `award_punish`
VALUES (4, 4, 2, '2021-08-28', '处罚4');
INSERT INTO `award_punish`
VALUES (5, 5, 2, '2021-06-28', '处罚5');
INSERT INTO `award_punish`
VALUES (6, 6, 2, '2016-12-28', '处罚6');
INSERT INTO `award_punish`
VALUES (7, 7, 2, '2019-12-28', '处罚7');
INSERT INTO `award_punish`
VALUES (8, 8, 2, '2021-09-28', '处罚8');
INSERT INTO `award_punish`
VALUES (9, 9, 2, '2021-06-25', '处罚9');
INSERT INTO `award_punish`
VALUES (10, 1, 1, '2021-07-25', '奖励12');
INSERT INTO `award_punish`
VALUES (11, 2, 1, '2019-06-23', '奖励10');
INSERT INTO `award_punish`
VALUES (12, 3, 1, '2019-12-28', '奖励6');
INSERT INTO `award_punish`
VALUES (13, 4, 1, '2020-06-28', '奖励1');
INSERT INTO `award_punish`
VALUES (14, 5, 1, '2021-06-25', '奖励8');
INSERT INTO `award_punish`
VALUES (15, 6, 1, '2021-06-28', '奖励4');
INSERT INTO `award_punish`
VALUES (16, 7, 1, '2021-07-25', '奖励9');
INSERT INTO `award_punish`
VALUES (17, 8, 1, '2021-08-28', '奖励3');
INSERT INTO `award_punish`
VALUES (18, 9, 1, '2021-09-28', '奖励7');
INSERT INTO `award_punish`
VALUES (19, 10, 1, '2021-12-24', '奖励11');
INSERT INTO `award_punish`
VALUES (20, 11, 1, '2022-05-28', '奖励2');
INSERT INTO `award_punish`
VALUES (21, 7, 1, '2001-01-03', '哦哦哦哦哦哦');
INSERT INTO `award_punish`
VALUES (23, 8, 1, '2019-06-06', 'rrrrrr');
INSERT INTO `award_punish`
VALUES (26, 1, 1, '2021-12-12', '啦啦啦啦啦啦啦啦');
INSERT INTO `award_punish`
VALUES (29, 11, 1, '2020-02-02', '111');
INSERT INTO `award_punish`
VALUES (33, 1, 0, '2020-03-03', '333');
INSERT INTO `award_punish`
VALUES (34, 1, 0, '2020-01-03', '标志程序在');
INSERT INTO `award_punish`
VALUES (35, 230, 1, '2021-03-03', '阿斯蒂芬');
INSERT INTO `award_punish`
VALUES (36, 1, 1, '2021-03-03', '1');

-- ----------------------------
-- Table structure for classinfo
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo`
(
    `class_id`   int(5)                                                       NOT NULL AUTO_INCREMENT,
    `name`       varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `stu_number` int(5)                                                       NULL DEFAULT 0,
    `major_id`   int(5)                                                       NOT NULL,
    PRIMARY KEY (`class_id`) USING BTREE,
    INDEX `c_m` (`major_id`) USING BTREE,
    CONSTRAINT `c_m` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classinfo
-- ----------------------------
INSERT INTO `classinfo`
VALUES (1, '计科1901', 11, 1);
INSERT INTO `classinfo`
VALUES (2, '计科1902', 5, 1);
INSERT INTO `classinfo`
VALUES (3, '软件1901', 4, 2);
INSERT INTO `classinfo`
VALUES (4, '软件1902', 5, 2);
INSERT INTO `classinfo`
VALUES (5, '机械1901', 5, 3);
INSERT INTO `classinfo`
VALUES (6, '机械1902', 2, 3);
INSERT INTO `classinfo`
VALUES (7, '土木1901', 4, 4);
INSERT INTO `classinfo`
VALUES (8, '土木1902', 2, 4);
INSERT INTO `classinfo`
VALUES (9, '国贸1901', 5, 5);
INSERT INTO `classinfo`
VALUES (10, '国贸1902', 2, 5);
INSERT INTO `classinfo`
VALUES (11, '会计1901', 5, 5);
INSERT INTO `classinfo`
VALUES (13, '通信1901', 0, 2);
INSERT INTO `classinfo`
VALUES (14, '通信1902', 0, 5);
INSERT INTO `classinfo`
VALUES (16, '中文1901', 0, 8);
INSERT INTO `classinfo`
VALUES (17, '化工1901', 0, 9);
INSERT INTO `classinfo`
VALUES (18, '111', 0, 10);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `course_id`   int(5)                                                 NOT NULL AUTO_INCREMENT,
    `course_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course`
VALUES (1, 'Java');
INSERT INTO `course`
VALUES (2, 'python');
INSERT INTO `course`
VALUES (3, 'C');
INSERT INTO `course`
VALUES (4, 'C++');
INSERT INTO `course`
VALUES (5, '数据结构');
INSERT INTO `course`
VALUES (6, '通信原理');

-- ----------------------------
-- Table structure for faculty
-- ----------------------------
DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty`
(
    `faculty_id`   int(5)                                                 NOT NULL AUTO_INCREMENT,
    `faculty_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`faculty_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of faculty
-- ----------------------------
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
INSERT INTO `faculty`
VALUES (8, '石油学院');
INSERT INTO `faculty`
VALUES (9, '大发大');
INSERT INTO `faculty`
VALUES (10, '123');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`
(
    `major_id`   int(5)                                                 NOT NULL AUTO_INCREMENT,
    `major_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `faculty_id` int(5)                                                 NOT NULL,
    PRIMARY KEY (`major_id`) USING BTREE,
    INDEX `m_f` (`faculty_id`) USING BTREE,
    CONSTRAINT `m_f` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`faculty_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
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
INSERT INTO `major`
VALUES (10, '123123', 10);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`
(
    `stu_id`    int(5) NOT NULL,
    `course_id` int(5) NOT NULL,
    `score`     double NOT NULL,
    INDEX `s_stu` (`stu_id`) USING BTREE,
    INDEX `s_course` (`course_id`) USING BTREE,
    CONSTRAINT `s_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `s_stu` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score`
VALUES (2, 1, 66);
INSERT INTO `score`
VALUES (3, 1, 78);
INSERT INTO `score`
VALUES (4, 1, 43);
INSERT INTO `score`
VALUES (5, 1, 69);
INSERT INTO `score`
VALUES (6, 1, 77);
INSERT INTO `score`
VALUES (7, 1, 28);
INSERT INTO `score`
VALUES (8, 1, 92);
INSERT INTO `score`
VALUES (9, 1, 76);
INSERT INTO `score`
VALUES (10, 1, 94);
INSERT INTO `score`
VALUES (11, 1, 88);
INSERT INTO `score`
VALUES (12, 1, 64);
INSERT INTO `score`
VALUES (13, 1, 60);
INSERT INTO `score`
VALUES (14, 1, 61);
INSERT INTO `score`
VALUES (15, 1, 65);
INSERT INTO `score`
VALUES (16, 1, 77);
INSERT INTO `score`
VALUES (17, 1, 94);
INSERT INTO `score`
VALUES (18, 1, 58);
INSERT INTO `score`
VALUES (19, 1, 59);
INSERT INTO `score`
VALUES (20, 1, 68);
INSERT INTO `score`
VALUES (21, 1, 74);
INSERT INTO `score`
VALUES (22, 1, 68);
INSERT INTO `score`
VALUES (23, 1, 100);
INSERT INTO `score`
VALUES (24, 1, 64);
INSERT INTO `score`
VALUES (25, 1, 44);
INSERT INTO `score`
VALUES (26, 1, 87);
INSERT INTO `score`
VALUES (27, 1, 62);
INSERT INTO `score`
VALUES (28, 1, 68);
INSERT INTO `score`
VALUES (29, 1, 0);
INSERT INTO `score`
VALUES (30, 1, 58);
INSERT INTO `score`
VALUES (31, 1, 59);
INSERT INTO `score`
VALUES (32, 1, 64);
INSERT INTO `score`
VALUES (33, 1, 60);
INSERT INTO `score`
VALUES (34, 1, 93);
INSERT INTO `score`
VALUES (35, 1, 75);
INSERT INTO `score`
VALUES (36, 1, 46);
INSERT INTO `score`
VALUES (37, 1, 76);
INSERT INTO `score`
VALUES (38, 1, 73);
INSERT INTO `score`
VALUES (39, 1, 77);
INSERT INTO `score`
VALUES (40, 1, 65);
INSERT INTO `score`
VALUES (41, 1, 77);
INSERT INTO `score`
VALUES (42, 1, 65);
INSERT INTO `score`
VALUES (43, 1, 57);
INSERT INTO `score`
VALUES (44, 1, 79);
INSERT INTO `score`
VALUES (45, 1, 94);
INSERT INTO `score`
VALUES (46, 1, 37);
INSERT INTO `score`
VALUES (47, 1, 99);
INSERT INTO `score`
VALUES (48, 1, 66);
INSERT INTO `score`
VALUES (49, 1, 88);
INSERT INTO `score`
VALUES (50, 1, 78);
INSERT INTO `score`
VALUES (51, 1, 94);
INSERT INTO `score`
VALUES (1, 2, 51);
INSERT INTO `score`
VALUES (2, 2, 55);
INSERT INTO `score`
VALUES (3, 2, 70);
INSERT INTO `score`
VALUES (4, 2, 66);
INSERT INTO `score`
VALUES (5, 2, 56);
INSERT INTO `score`
VALUES (6, 2, 59);
INSERT INTO `score`
VALUES (7, 2, 66);
INSERT INTO `score`
VALUES (8, 2, 90);
INSERT INTO `score`
VALUES (9, 2, 87);
INSERT INTO `score`
VALUES (10, 2, 61);
INSERT INTO `score`
VALUES (11, 2, 95);
INSERT INTO `score`
VALUES (12, 2, 74);
INSERT INTO `score`
VALUES (13, 2, 77);
INSERT INTO `score`
VALUES (14, 2, 68);
INSERT INTO `score`
VALUES (15, 2, 89);
INSERT INTO `score`
VALUES (16, 2, 65);
INSERT INTO `score`
VALUES (17, 2, 95);
INSERT INTO `score`
VALUES (18, 2, 84);
INSERT INTO `score`
VALUES (19, 2, 73);
INSERT INTO `score`
VALUES (20, 2, 54);
INSERT INTO `score`
VALUES (21, 2, 52);
INSERT INTO `score`
VALUES (22, 2, 60);
INSERT INTO `score`
VALUES (23, 2, 68);
INSERT INTO `score`
VALUES (24, 2, 88);
INSERT INTO `score`
VALUES (25, 2, 77);
INSERT INTO `score`
VALUES (26, 2, 45);
INSERT INTO `score`
VALUES (27, 2, 98);
INSERT INTO `score`
VALUES (28, 2, 78);
INSERT INTO `score`
VALUES (29, 2, 65);
INSERT INTO `score`
VALUES (30, 2, 59);
INSERT INTO `score`
VALUES (31, 2, 51);
INSERT INTO `score`
VALUES (32, 2, 54);
INSERT INTO `score`
VALUES (33, 2, 85);
INSERT INTO `score`
VALUES (34, 2, 87);
INSERT INTO `score`
VALUES (35, 2, 48);
INSERT INTO `score`
VALUES (36, 2, 84);
INSERT INTO `score`
VALUES (37, 2, 69);
INSERT INTO `score`
VALUES (38, 2, 77);
INSERT INTO `score`
VALUES (39, 2, 73);
INSERT INTO `score`
VALUES (40, 2, 88);
INSERT INTO `score`
VALUES (41, 2, 87);
INSERT INTO `score`
VALUES (42, 2, 61);
INSERT INTO `score`
VALUES (43, 2, 54);
INSERT INTO `score`
VALUES (44, 2, 45);
INSERT INTO `score`
VALUES (45, 2, 46);
INSERT INTO `score`
VALUES (46, 2, 25);
INSERT INTO `score`
VALUES (47, 2, 54);
INSERT INTO `score`
VALUES (48, 2, 76);
INSERT INTO `score`
VALUES (49, 2, 79);
INSERT INTO `score`
VALUES (50, 2, 60);
INSERT INTO `score`
VALUES (51, 2, 44);
INSERT INTO `score`
VALUES (1, 3, 49);
INSERT INTO `score`
VALUES (2, 3, 40);
INSERT INTO `score`
VALUES (3, 3, 46);
INSERT INTO `score`
VALUES (4, 3, 47);
INSERT INTO `score`
VALUES (5, 3, 54);
INSERT INTO `score`
VALUES (6, 3, 59);
INSERT INTO `score`
VALUES (7, 3, 52);
INSERT INTO `score`
VALUES (8, 3, 53);
INSERT INTO `score`
VALUES (9, 3, 58);
INSERT INTO `score`
VALUES (10, 3, 61);
INSERT INTO `score`
VALUES (11, 3, 63);
INSERT INTO `score`
VALUES (12, 3, 68);
INSERT INTO `score`
VALUES (13, 3, 66);
INSERT INTO `score`
VALUES (14, 3, 64);
INSERT INTO `score`
VALUES (15, 3, 72);
INSERT INTO `score`
VALUES (16, 3, 79);
INSERT INTO `score`
VALUES (17, 3, 71);
INSERT INTO `score`
VALUES (18, 3, 76);
INSERT INTO `score`
VALUES (19, 3, 77);
INSERT INTO `score`
VALUES (20, 3, 84);
INSERT INTO `score`
VALUES (21, 3, 86);
INSERT INTO `score`
VALUES (22, 3, 88);
INSERT INTO `score`
VALUES (23, 3, 89);
INSERT INTO `score`
VALUES (24, 3, 83);
INSERT INTO `score`
VALUES (25, 3, 91);
INSERT INTO `score`
VALUES (26, 3, 99);
INSERT INTO `score`
VALUES (27, 3, 96);
INSERT INTO `score`
VALUES (28, 3, 95);
INSERT INTO `score`
VALUES (29, 3, 92);
INSERT INTO `score`
VALUES (30, 3, 49);
INSERT INTO `score`
VALUES (31, 3, 56);
INSERT INTO `score`
VALUES (32, 3, 68);
INSERT INTO `score`
VALUES (33, 3, 75);
INSERT INTO `score`
VALUES (34, 3, 89);
INSERT INTO `score`
VALUES (35, 3, 56);
INSERT INTO `score`
VALUES (36, 3, 68);
INSERT INTO `score`
VALUES (37, 3, 78);
INSERT INTO `score`
VALUES (38, 3, 96);
INSERT INTO `score`
VALUES (39, 3, 43);
INSERT INTO `score`
VALUES (40, 3, 59);
INSERT INTO `score`
VALUES (41, 3, 85);
INSERT INTO `score`
VALUES (42, 3, 74);
INSERT INTO `score`
VALUES (43, 3, 93);
INSERT INTO `score`
VALUES (44, 3, 85);
INSERT INTO `score`
VALUES (45, 3, 66);
INSERT INTO `score`
VALUES (46, 3, 53);
INSERT INTO `score`
VALUES (47, 3, 92);
INSERT INTO `score`
VALUES (48, 3, 59);
INSERT INTO `score`
VALUES (49, 3, 78);
INSERT INTO `score`
VALUES (50, 3, 90);
INSERT INTO `score`
VALUES (51, 3, 80);
INSERT INTO `score`
VALUES (2, 4, 55);
INSERT INTO `score`
VALUES (3, 4, 89);
INSERT INTO `score`
VALUES (4, 4, 67);
INSERT INTO `score`
VALUES (5, 4, 84);
INSERT INTO `score`
VALUES (6, 4, 72);
INSERT INTO `score`
VALUES (7, 4, 62);
INSERT INTO `score`
VALUES (8, 4, 63);
INSERT INTO `score`
VALUES (9, 4, 86);
INSERT INTO `score`
VALUES (10, 4, 53);
INSERT INTO `score`
VALUES (11, 4, 87);
INSERT INTO `score`
VALUES (12, 4, 57);
INSERT INTO `score`
VALUES (13, 4, 73);
INSERT INTO `score`
VALUES (14, 4, 88);
INSERT INTO `score`
VALUES (15, 4, 79);
INSERT INTO `score`
VALUES (16, 4, 99);
INSERT INTO `score`
VALUES (17, 4, 60);
INSERT INTO `score`
VALUES (18, 4, 100);
INSERT INTO `score`
VALUES (19, 4, 83);
INSERT INTO `score`
VALUES (20, 4, 55);
INSERT INTO `score`
VALUES (21, 4, 59);
INSERT INTO `score`
VALUES (22, 4, 73);
INSERT INTO `score`
VALUES (23, 4, 84);
INSERT INTO `score`
VALUES (24, 4, 61);
INSERT INTO `score`
VALUES (25, 4, 77);
INSERT INTO `score`
VALUES (26, 4, 50);
INSERT INTO `score`
VALUES (27, 4, 58);
INSERT INTO `score`
VALUES (28, 4, 72);
INSERT INTO `score`
VALUES (29, 4, 69);
INSERT INTO `score`
VALUES (30, 4, 93);
INSERT INTO `score`
VALUES (31, 4, 85);
INSERT INTO `score`
VALUES (32, 4, 66);
INSERT INTO `score`
VALUES (33, 4, 53);
INSERT INTO `score`
VALUES (34, 4, 92);
INSERT INTO `score`
VALUES (35, 4, 59);
INSERT INTO `score`
VALUES (36, 4, 78);
INSERT INTO `score`
VALUES (37, 4, 90);
INSERT INTO `score`
VALUES (38, 4, 80);
INSERT INTO `score`
VALUES (39, 4, 63);
INSERT INTO `score`
VALUES (40, 4, 55);
INSERT INTO `score`
VALUES (41, 4, 89);
INSERT INTO `score`
VALUES (42, 4, 67);
INSERT INTO `score`
VALUES (43, 4, 84);
INSERT INTO `score`
VALUES (44, 4, 72);
INSERT INTO `score`
VALUES (45, 4, 62);
INSERT INTO `score`
VALUES (46, 4, 63);
INSERT INTO `score`
VALUES (47, 4, 86);
INSERT INTO `score`
VALUES (48, 4, 53);
INSERT INTO `score`
VALUES (49, 4, 87);
INSERT INTO `score`
VALUES (50, 4, 57);
INSERT INTO `score`
VALUES (51, 4, 93);
INSERT INTO `score`
VALUES (1, 5, 85);
INSERT INTO `score`
VALUES (2, 5, 66);
INSERT INTO `score`
VALUES (3, 5, 53);
INSERT INTO `score`
VALUES (4, 5, 92);
INSERT INTO `score`
VALUES (5, 5, 59);
INSERT INTO `score`
VALUES (6, 5, 78);
INSERT INTO `score`
VALUES (7, 5, 90);
INSERT INTO `score`
VALUES (8, 5, 80);
INSERT INTO `score`
VALUES (9, 5, 63);
INSERT INTO `score`
VALUES (10, 5, 55);
INSERT INTO `score`
VALUES (11, 5, 89);
INSERT INTO `score`
VALUES (12, 5, 67);
INSERT INTO `score`
VALUES (13, 5, 84);
INSERT INTO `score`
VALUES (14, 5, 93);
INSERT INTO `score`
VALUES (15, 5, 85);
INSERT INTO `score`
VALUES (16, 5, 66);
INSERT INTO `score`
VALUES (17, 5, 53);
INSERT INTO `score`
VALUES (18, 5, 92);
INSERT INTO `score`
VALUES (19, 5, 59);
INSERT INTO `score`
VALUES (20, 5, 78);
INSERT INTO `score`
VALUES (21, 5, 90);
INSERT INTO `score`
VALUES (22, 5, 80);
INSERT INTO `score`
VALUES (23, 5, 63);
INSERT INTO `score`
VALUES (24, 5, 55);
INSERT INTO `score`
VALUES (25, 5, 89);
INSERT INTO `score`
VALUES (26, 5, 93);
INSERT INTO `score`
VALUES (27, 5, 85);
INSERT INTO `score`
VALUES (28, 5, 66);
INSERT INTO `score`
VALUES (29, 5, 53);
INSERT INTO `score`
VALUES (30, 5, 92);
INSERT INTO `score`
VALUES (31, 5, 59);
INSERT INTO `score`
VALUES (32, 5, 78);
INSERT INTO `score`
VALUES (33, 5, 90);
INSERT INTO `score`
VALUES (34, 5, 80);
INSERT INTO `score`
VALUES (35, 5, 63);
INSERT INTO `score`
VALUES (36, 5, 55);
INSERT INTO `score`
VALUES (37, 5, 89);
INSERT INTO `score`
VALUES (38, 5, 67);
INSERT INTO `score`
VALUES (39, 5, 84);
INSERT INTO `score`
VALUES (40, 5, 72);
INSERT INTO `score`
VALUES (41, 5, 62);
INSERT INTO `score`
VALUES (42, 5, 93);
INSERT INTO `score`
VALUES (43, 5, 85);
INSERT INTO `score`
VALUES (44, 5, 66);
INSERT INTO `score`
VALUES (45, 5, 53);
INSERT INTO `score`
VALUES (46, 5, 92);
INSERT INTO `score`
VALUES (47, 5, 59);
INSERT INTO `score`
VALUES (48, 5, 78);
INSERT INTO `score`
VALUES (49, 5, 90);
INSERT INTO `score`
VALUES (50, 5, 80);
INSERT INTO `score`
VALUES (51, 5, 63);
INSERT INTO `score`
VALUES (1, 6, 55);
INSERT INTO `score`
VALUES (2, 6, 89);
INSERT INTO `score`
VALUES (3, 6, 67);
INSERT INTO `score`
VALUES (4, 6, 84);
INSERT INTO `score`
VALUES (5, 6, 72);
INSERT INTO `score`
VALUES (6, 6, 62);
INSERT INTO `score`
VALUES (7, 6, 93);
INSERT INTO `score`
VALUES (8, 6, 85);
INSERT INTO `score`
VALUES (9, 6, 66);
INSERT INTO `score`
VALUES (10, 6, 53);
INSERT INTO `score`
VALUES (11, 6, 92);
INSERT INTO `score`
VALUES (12, 6, 59);
INSERT INTO `score`
VALUES (13, 6, 78);
INSERT INTO `score`
VALUES (14, 6, 90);
INSERT INTO `score`
VALUES (15, 6, 80);
INSERT INTO `score`
VALUES (16, 6, 63);
INSERT INTO `score`
VALUES (17, 6, 55);
INSERT INTO `score`
VALUES (18, 6, 89);
INSERT INTO `score`
VALUES (19, 6, 67);
INSERT INTO `score`
VALUES (20, 6, 84);
INSERT INTO `score`
VALUES (21, 6, 72);
INSERT INTO `score`
VALUES (22, 6, 62);
INSERT INTO `score`
VALUES (23, 6, 63);
INSERT INTO `score`
VALUES (24, 6, 86);
INSERT INTO `score`
VALUES (25, 6, 53);
INSERT INTO `score`
VALUES (26, 6, 87);
INSERT INTO `score`
VALUES (27, 6, 93);
INSERT INTO `score`
VALUES (28, 6, 85);
INSERT INTO `score`
VALUES (29, 6, 66);
INSERT INTO `score`
VALUES (30, 6, 53);
INSERT INTO `score`
VALUES (31, 6, 92);
INSERT INTO `score`
VALUES (32, 6, 59);
INSERT INTO `score`
VALUES (33, 6, 78);
INSERT INTO `score`
VALUES (34, 6, 90);
INSERT INTO `score`
VALUES (35, 6, 80);
INSERT INTO `score`
VALUES (36, 6, 63);
INSERT INTO `score`
VALUES (37, 6, 93);
INSERT INTO `score`
VALUES (38, 6, 85);
INSERT INTO `score`
VALUES (39, 6, 66);
INSERT INTO `score`
VALUES (40, 6, 53);
INSERT INTO `score`
VALUES (41, 6, 92);
INSERT INTO `score`
VALUES (42, 6, 59);
INSERT INTO `score`
VALUES (43, 6, 78);
INSERT INTO `score`
VALUES (44, 6, 90);
INSERT INTO `score`
VALUES (45, 6, 80);
INSERT INTO `score`
VALUES (46, 6, 63);
INSERT INTO `score`
VALUES (47, 6, 55);
INSERT INTO `score`
VALUES (48, 6, 89);
INSERT INTO `score`
VALUES (49, 6, 67);
INSERT INTO `score`
VALUES (50, 6, 84);
INSERT INTO `score`
VALUES (20, 3, 20);
INSERT INTO `score`
VALUES (20, 3, 20);
INSERT INTO `score`
VALUES (20, 3, 99.8);
INSERT INTO `score`
VALUES (1, 1, 99);
INSERT INTO `score`
VALUES (1, 4, 99);
INSERT INTO `score`
VALUES (230, 1, 99);
INSERT INTO `score`
VALUES (230, 4, 99);
INSERT INTO `score`
VALUES (230, 5, 99);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `stu_id`   int(5)                                                 NOT NULL AUTO_INCREMENT,
    `stu_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `gender`   varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `class_id` int(5)                                                 NOT NULL,
    PRIMARY KEY (`stu_id`) USING BTREE,
    INDEX `s_c` (`class_id`) USING BTREE,
    CONSTRAINT `s_c` FOREIGN KEY (`class_id`) REFERENCES `classinfo` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 233
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student`
VALUES (1, '霍凯杰', '女', 9);
INSERT INTO `student`
VALUES (2, '甄秋', '男', 10);
INSERT INTO `student`
VALUES (3, '柳玉瑶', '女', 11);
INSERT INTO `student`
VALUES (4, '乌菲', '男', 11);
INSERT INTO `student`
VALUES (5, '武义', '男', 1);
INSERT INTO `student`
VALUES (6, '黄波', '女', 1);
INSERT INTO `student`
VALUES (7, '刘峰', '男', 1);
INSERT INTO `student`
VALUES (8, '包凯蓉', '男', 1);
INSERT INTO `student`
VALUES (9, '满彬', '男', 9);
INSERT INTO `student`
VALUES (10, '昌文', '女', 7);
INSERT INTO `student`
VALUES (11, '柳金萍', '男', 1);
INSERT INTO `student`
VALUES (12, '庄易友', '女', 16);
INSERT INTO `student`
VALUES (13, '游被芬', '男', 16);
INSERT INTO `student`
VALUES (14, '辕令瑗', '男', 4);
INSERT INTO `student`
VALUES (15, '益华', '女', 2);
INSERT INTO `student`
VALUES (16, '荣义珊', '男', 3);
INSERT INTO `student`
VALUES (17, '郁和', '女', 4);
INSERT INTO `student`
VALUES (18, '薛栋', '男', 5);
INSERT INTO `student`
VALUES (19, '娄钰友', '女', 6);
INSERT INTO `student`
VALUES (20, '延羊秀', '男', 7);
INSERT INTO `student`
VALUES (21, '庞杰', '女', 8);
INSERT INTO `student`
VALUES (22, '荣礼瑾', '男', 9);
INSERT INTO `student`
VALUES (23, '霍婵', '女', 2);
INSERT INTO `student`
VALUES (24, '戴莺', '男', 11);
INSERT INTO `student`
VALUES (25, '施金洁', '女', 5);
INSERT INTO `student`
VALUES (26, '门呼上维', '女', 1);
INSERT INTO `student`
VALUES (27, '山易亨', '男', 2);
INSERT INTO `student`
VALUES (28, '弓菊', '女', 3);
INSERT INTO `student`
VALUES (29, '张飞', '男', 4);
INSERT INTO `student`
VALUES (30, '雪河', '女', 5);
INSERT INTO `student`
VALUES (31, '嘉城', '男', 6);
INSERT INTO `student`
VALUES (32, '文文', '男', 5);
INSERT INTO `student`
VALUES (33, '采集', '男', 8);
INSERT INTO `student`
VALUES (34, '荣礼瑾', '女', 9);
INSERT INTO `student`
VALUES (35, '霍婵', '男', 10);
INSERT INTO `student`
VALUES (36, '戴莺', '女', 11);
INSERT INTO `student`
VALUES (37, '施金洁', '男', 11);
INSERT INTO `student`
VALUES (38, '门呼上维', '男', 1);
INSERT INTO `student`
VALUES (39, '束纯', '女', 1);
INSERT INTO `student`
VALUES (40, '山易亨', '男', 1);
INSERT INTO `student`
VALUES (41, '弓菊', '男', 1);
INSERT INTO `student`
VALUES (42, '岑电真', '男', 9);
INSERT INTO `student`
VALUES (43, '陈超', '女', 7);
INSERT INTO `student`
VALUES (44, '时琬', '男', 1);
INSERT INTO `student`
VALUES (45, '鲁学', '女', 16);
INSERT INTO `student`
VALUES (46, '封华', '男', 16);
INSERT INTO `student`
VALUES (47, '崔雅', '男', 4);
INSERT INTO `student`
VALUES (48, '郁马弘', '女', 2);
INSERT INTO `student`
VALUES (49, '邓义启', '男', 3);
INSERT INTO `student`
VALUES (50, '刁中艳', '女', 4);
INSERT INTO `student`
VALUES (51, '韶忠芳', '男', 5);
INSERT INTO `student`
VALUES (52, '张能', '男', 2);
INSERT INTO `student`
VALUES (230, '阿道夫', '女', 3);
INSERT INTO `student`
VALUES (232, 'AAAA', '女', 2);

-- ----------------------------
-- View structure for allstu_view
-- ----------------------------
DROP VIEW IF EXISTS `allstu_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `allstu_view` AS
select `s`.`stu_id`       AS `id`,
       `s`.`stu_name`     AS `studentname`,
       `s`.`gender`       AS `gender`,
       `c`.`name`         AS `className`,
       `m`.`major_name`   AS `major`,
       `f`.`faculty_name` AS `faculty`
from (((`student` `s` join `classinfo` `c` on ((`c`.`class_id` = `s`.`class_id`))) join `major` `m` on ((`m`.`major_id` = `c`.`major_id`)))
         join `faculty` `f` on ((`f`.`faculty_id` = `m`.`faculty_id`)))
order by `s`.`stu_id`;

-- ----------------------------
-- View structure for class_view
-- ----------------------------
DROP VIEW IF EXISTS `class_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `class_view` AS
select `classinfo`.`class_id`   AS `class_id`,
       `classinfo`.`name`       AS `classname`,
       `classinfo`.`stu_number` AS `stu_number`,
       `m`.`major_name`         AS `major_name`,
       `f`.`faculty_name`       AS `faculty_name`
from ((`classinfo` join `major` `m` on ((`m`.`major_id` = `classinfo`.`major_id`)))
         join `faculty` `f` on ((`f`.`faculty_id` = `m`.`faculty_id`)))
order by `classinfo`.`class_id`;

-- ----------------------------
-- View structure for faculty_view
-- ----------------------------
DROP VIEW IF EXISTS `faculty_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `faculty_view` AS
select `abc`.`faculty`.`faculty_id`   AS `faculty_id`,
       `abc`.`faculty`.`faculty_name` AS `faculty_name`,
       `aaaa`.`stuCount`              AS `stuCount`,
       `aaaa`.`girlCount`             AS `girlCount`,
       `aaaa`.`boyCount`              AS `boyCount`
from (`abc`.`faculty`
         left join (select `abc`.`faculty`.`faculty_id`   AS `faculty_id`,
                           `abc`.`faculty`.`faculty_name` AS `faculty_name`,
                           `al`.`acount`                  AS `stuCount`,
                           `g`.`gcount`                   AS `girlCount`,
                           `b`.`bcount`                   AS `boyCount`
                    from (((select count(0) AS `gcount`, `f`.`faculty_id` AS `gid`
                            from (((`abc`.`student` `s` join `abc`.`classinfo` `c` on ((`c`.`class_id` = `s`.`class_id`))) join `abc`.`major` `m` on ((`m`.`major_id` = `c`.`major_id`)))
                                     join `abc`.`faculty` `f` on ((`f`.`faculty_id` = `m`.`faculty_id`)))
                            where (`s`.`gender` = '女')
                            group by `f`.`faculty_id`)) `g`
                             left join (((select count(0) AS `bcount`, `f`.`faculty_id` AS `bid`
                                          from (((`abc`.`student` `s` join `abc`.`classinfo` `c` on ((`c`.`class_id` = `s`.`class_id`))) join `abc`.`major` `m` on ((`m`.`major_id` = `c`.`major_id`)))
                                                   join `abc`.`faculty` `f` on ((`f`.`faculty_id` = `m`.`faculty_id`)))
                                          where (`s`.`gender` = '男')
                                          group by `f`.`faculty_id`)) `b` left join (((select count(0) AS `acount`, `f`.`faculty_id` AS `aid`
                                                                                       from (((`abc`.`student` `s` join `abc`.`classinfo` `c` on ((`c`.`class_id` = `s`.`class_id`))) join `abc`.`major` `m` on ((`m`.`major_id` = `c`.`major_id`)))
                                                                                                join `abc`.`faculty` `f` on ((`f`.`faculty_id` = `m`.`faculty_id`)))
                                                                                       group by `f`.`faculty_id`)) `al` left join `abc`.`faculty` on ((`al`.`aid` = `abc`.`faculty`.`faculty_id`))) on ((`b`.`bid` = `abc`.`faculty`.`faculty_id`)))
                                       on ((`g`.`gid` = `abc`.`faculty`.`faculty_id`)))) `aaaa`
                   on ((`abc`.`faculty`.`faculty_id` = `aaaa`.`faculty_id`)))
order by `abc`.`faculty`.`faculty_id`;

-- ----------------------------
-- View structure for major_view
-- ----------------------------
DROP VIEW IF EXISTS `major_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `major_view` AS
select `abc`.`major`.`major_id`   AS `major_id`,
       `abc`.`major`.`major_name` AS `majorname`,
       `allm`.`stuNumber`         AS `stuNumber`,
       `allm`.`girlNumber`        AS `girlNumber`,
       `allm`.`boyNumber`         AS `boyNumber`,
       `allm`.`faculty_name`      AS `faculty_name`
from (`abc`.`major`
         left join (select `abc`.`major`.`major_id`   AS `id`,
                           `abc`.`major`.`major_name` AS `majorName`,
                           `a`.`allStu`               AS `stuNumber`,
                           `g`.`allStu`               AS `girlNumber`,
                           `b`.`allStu`               AS `boyNumber`,
                           `f2`.`faculty_name`        AS `faculty_name`
                    from ((((select count(0) AS `allStu`, `m`.`major_id` AS `gid`
                             from (((`abc`.`student` `s` join `abc`.`classinfo` `c` on ((`c`.`class_id` = `s`.`class_id`))) join `abc`.`major` `m` on ((`m`.`major_id` = `c`.`major_id`)))
                                      join `abc`.`faculty` `f` on ((`f`.`faculty_id` = `m`.`faculty_id`)))
                             where (`s`.`gender` = '女')
                             group by `m`.`major_name`)) `g` left join (((select count(0) AS `allStu`, `m`.`major_id` AS `bid`
                                                                          from (((`abc`.`student` `s` join `abc`.`classinfo` `c` on ((`c`.`class_id` = `s`.`class_id`))) join `abc`.`major` `m` on ((`m`.`major_id` = `c`.`major_id`)))
                                                                                   join `abc`.`faculty` `f` on ((`f`.`faculty_id` = `m`.`faculty_id`)))
                                                                          where (`s`.`gender` = '男')
                                                                          group by `m`.`major_name`)) `b` left join (((select count(0) AS `allStu`, `m`.`major_id` AS `aid`
                                                                                                                       from (((`abc`.`student` `s` join `abc`.`classinfo` `c` on ((`c`.`class_id` = `s`.`class_id`))) join `abc`.`major` `m` on ((`m`.`major_id` = `c`.`major_id`)))
                                                                                                                                join `abc`.`faculty` `f` on ((`f`.`faculty_id` = `m`.`faculty_id`)))
                                                                                                                       group by `m`.`major_name`)) `a` left join `abc`.`major` on ((`abc`.`major`.`major_id` = `a`.`aid`))) on ((`b`.`bid` = `abc`.`major`.`major_id`))) on ((`g`.`gid` = `abc`.`major`.`major_id`)))
                             join `abc`.`faculty` `f2` on ((`f2`.`faculty_id` = `abc`.`major`.`faculty_id`)))
                    order by `id`) `allm` on ((`abc`.`major`.`major_id` = `allm`.`id`)));

-- ----------------------------
-- View structure for stu_ap
-- ----------------------------
DROP VIEW IF EXISTS `stu_ap`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `stu_ap` AS
select `award_punish`.`ap_id`      AS `ap_id`,
       `award_punish`.`student_id` AS `student_id`,
       `s`.`stu_name`              AS `stu_name`,
       `a`.`ap_type`               AS `ap_type`,
       `award_punish`.`time`       AS `time`,
       `award_punish`.`desc`       AS `desc`
from ((`award_punish` join `ap_type` `a` on ((`a`.`ap_id` = `award_punish`.`ap_type`)))
         join `student` `s` on ((`s`.`stu_id` = `award_punish`.`student_id`)))
order by `s`.`stu_id`;

-- ----------------------------
-- View structure for stu_score
-- ----------------------------
DROP VIEW IF EXISTS `stu_score`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `stu_score` AS
select `abc`.`student`.`stu_id`   AS `stu_id`,
       `abc`.`student`.`stu_name` AS `stu_name`,
       `ss`.`course_name`         AS `course_name`,
       `ss`.`score`               AS `score`
from (`abc`.`student`
         left join (select `stu`.`stu_id`     AS `stu_id`,
                           `stu`.`stu_name`   AS `stu_name`,
                           `c2`.`course_name` AS `course_name`,
                           `s`.`score`        AS `score`
                    from (((`abc`.`student` `stu` join `abc`.`score` `s` on ((`s`.`stu_id` = `stu`.`stu_id`))) join `abc`.`classinfo` `c` on ((`stu`.`class_id` = `c`.`class_id`)))
                             join `abc`.`course` `c2` on ((`s`.`course_id` = `c2`.`course_id`)))
                    order by `stu`.`stu_id`) `ss` on ((`ss`.`stu_id` = `abc`.`student`.`stu_id`)));

-- ----------------------------
-- Procedure structure for faculty_show
-- ----------------------------
DROP PROCEDURE IF EXISTS `faculty_show`;
delimiter ;;
CREATE PROCEDURE `faculty_show`()
begin
    select faculty_id, faculty_name, al.acount as stuCount, g.gcount as girlCount, b.bcount as boyCount
    from faculty
             right outer join (select count(*) as acount, f.faculty_id as aid
                               from student s
                                        inner join classinfo c on c.class_id = s.class_id
                                        inner join major m on m.major_id = c.major_id
                                        inner join faculty f on f.faculty_id = m.faculty_id
                               group by f.faculty_id) al
                              on al.aid = faculty.faculty_id
             right outer join (select count(*) as bcount, f.faculty_id as bid
                               from student s
                                        inner join classinfo c on c.class_id = s.class_id
                                        inner join major m on m.major_id = c.major_id
                                        inner join faculty f on f.faculty_id = m.faculty_id
                               where s.gender = '男'
                               group by f.faculty_id) b
                              on b.bid = faculty.faculty_id
             right outer join (select count(*) as gcount, f.faculty_id as gid
                               from student s
                                        inner join classinfo c on c.class_id = s.class_id
                                        inner join major m on m.major_id = c.major_id
                                        inner join faculty f on f.faculty_id = m.faculty_id
                               where s.gender = '女'
                               group by f.faculty_id) g
                              on g.gid = faculty.faculty_id
    order by faculty_id;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for major_show
-- ----------------------------
DROP PROCEDURE IF EXISTS `major_show`;
delimiter ;;
CREATE PROCEDURE `major_show`()
begin
    select major_id   as id,
           major_name as majorName,
           a.allStu   as stuNumber,
           g.allStu   as girlNumber,
           b.allStu   as boyNumber,
           faculty_name
    from major
             right outer join (select count(*) as allStu, m.major_id as aid
                               from student s
                                        inner join classinfo c on c.class_id = s.class_id
                                        inner join major m on m.major_id = c.major_id
                                        inner join faculty f on f.faculty_id = m.faculty_id
                               group by major_name) a
                              on major.major_id = a.aid
             right outer join (select count(*) as allStu, m.major_id as bid
                               from student s
                                        inner join classinfo c on c.class_id = s.class_id
                                        inner join major m on m.major_id = c.major_id
                                        inner join faculty f on f.faculty_id = m.faculty_id
                               where s.gender = '男'
                               group by major_name) b
                              on b.bid = major.major_id
             right outer join (select count(*) as allStu, m.major_id as gid
                               from student s
                                        inner join classinfo c on c.class_id = s.class_id
                                        inner join major m on m.major_id = c.major_id
                                        inner join faculty f on f.faculty_id = m.faculty_id
                               where s.gender = '女'
                               group by major_name) g
                              on g.gid = major.major_id
             inner join faculty f2 on f2.faculty_id = major.faculty_id
    order by id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table student
-- ----------------------------
DROP TRIGGER IF EXISTS `gender__check`;
delimiter ;;
CREATE TRIGGER `gender__check`
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
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table student
-- ----------------------------
DROP TRIGGER IF EXISTS `add_stu_number`;
delimiter ;;
CREATE TRIGGER `add_stu_number`
    AFTER INSERT
    ON `student`
    FOR EACH ROW
begin
    update classinfo set stu_number=stu_number + 1 where class_id = NEW.class_id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table student
-- ----------------------------
DROP TRIGGER IF EXISTS `delete_stu_number`;
delimiter ;;
CREATE TRIGGER `delete_stu_number`
    AFTER DELETE
    ON `student`
    FOR EACH ROW
begin
    update classinfo set stu_number=stu_number - 1 where class_id = OLD.class_id;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
