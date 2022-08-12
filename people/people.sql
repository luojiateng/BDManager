/*
 Navicat Premium Data Transfer

 Source Server         : 57版本
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : people

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 30/12/2021 19:37:53
*/

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
    `teacher_id` int(4)                                                  NOT NULL,
    `type`       int(4)                                                  NOT NULL,
    `time`       date                                                    NOT NULL,
    `desc`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`ap_id`) USING BTREE,
    INDEX `e` (`type`) USING BTREE,
    CONSTRAINT `e` FOREIGN KEY (`type`) REFERENCES `ap_type` (`ap_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 23
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of award_punish
-- ----------------------------
INSERT INTO `award_punish`
VALUES (2, 2, 2, '2022-05-28', '处罚2');
INSERT INTO `award_punish`
VALUES (3, 3, 2, '2021-08-28', '处罚3');
INSERT INTO `award_punish`
VALUES (4, 4, 2, '2021-06-28', '处罚4');
INSERT INTO `award_punish`
VALUES (5, 5, 2, '2016-12-28', '处罚5');
INSERT INTO `award_punish`
VALUES (6, 6, 2, '2019-12-28', '处罚6');
INSERT INTO `award_punish`
VALUES (7, 7, 2, '2021-09-28', '处罚7');
INSERT INTO `award_punish`
VALUES (8, 8, 2, '2021-06-25', '处罚8');
INSERT INTO `award_punish`
VALUES (9, 9, 2, '2019-06-28', '处罚9');
INSERT INTO `award_punish`
VALUES (10, 1, 1, '2019-05-28', '奖励12');
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

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`
(
    `dep_id`  int(4)                                                 NOT NULL AUTO_INCREMENT,
    `depName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `teaNum`  int(4)                                                 NULL DEFAULT 0,
    PRIMARY KEY (`dep_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept`
VALUES (1, '计算机学院', 1);
INSERT INTO `dept`
VALUES (2, '机械学院', 2);
INSERT INTO `dept`
VALUES (3, '经济管理学院', 3);
INSERT INTO `dept`
VALUES (4, '人文学院', 3);
INSERT INTO `dept`
VALUES (5, '化工学院', 3);
INSERT INTO `dept`
VALUES (6, '石油学院', 3);
INSERT INTO `dept`
VALUES (7, 'BBB', 0);
INSERT INTO `dept`
VALUES (9, '7777', 0);

-- ----------------------------
-- Table structure for edu_type
-- ----------------------------
DROP TABLE IF EXISTS `edu_type`;
CREATE TABLE `edu_type`
(
    `edu_id`   int(4)                                                 NOT NULL AUTO_INCREMENT,
    `edu_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`edu_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_type
-- ----------------------------
INSERT INTO `edu_type`
VALUES (1, '本科阶段');
INSERT INTO `edu_type`
VALUES (2, '硕士阶段');
INSERT INTO `edu_type`
VALUES (3, '博士阶段');

-- ----------------------------
-- Table structure for fam_type
-- ----------------------------
DROP TABLE IF EXISTS `fam_type`;
CREATE TABLE `fam_type`
(
    `fam_id`        int(4)                                                 NOT NULL AUTO_INCREMENT COMMENT '成员类型编号',
    `fam_type_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '成员名称',
    PRIMARY KEY (`fam_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fam_type
-- ----------------------------
INSERT INTO `fam_type`
VALUES (1, '父亲');
INSERT INTO `fam_type`
VALUES (2, '母亲');
INSERT INTO `fam_type`
VALUES (3, '兄弟');
INSERT INTO `fam_type`
VALUES (4, '姐妹');
INSERT INTO `fam_type`
VALUES (5, '儿子');
INSERT INTO `fam_type`
VALUES (6, '女儿');
INSERT INTO `fam_type`
VALUES (7, '配偶');

-- ----------------------------
-- Table structure for family
-- ----------------------------
DROP TABLE IF EXISTS `family`;
CREATE TABLE `family`
(
    `teacher_id`  int(4)                                                 NOT NULL,
    `home_member` int(4)                                                 NOT NULL COMMENT '家庭成员关系',
    `memer_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of family
-- ----------------------------
INSERT INTO `family`
VALUES (1, 1, '霍凯杰');
INSERT INTO `family`
VALUES (1, 2, '甄秋');
INSERT INTO `family`
VALUES (1, 3, '柳玉瑶');
INSERT INTO `family`
VALUES (1, 4, '乌菲');
INSERT INTO `family`
VALUES (2, 1, '武义');
INSERT INTO `family`
VALUES (2, 4, '黄波');
INSERT INTO `family`
VALUES (2, 5, '刘峰');
INSERT INTO `family`
VALUES (2, 6, '包凯蓉');
INSERT INTO `family`
VALUES (3, 7, '满彬');
INSERT INTO `family`
VALUES (3, 2, '昌文');
INSERT INTO `family`
VALUES (3, 3, '柳金萍');
INSERT INTO `family`
VALUES (3, 4, '庄易友');
INSERT INTO `family`
VALUES (4, 1, '游被芬');
INSERT INTO `family`
VALUES (4, 2, '辕令瑗');
INSERT INTO `family`
VALUES (4, 3, '益华');
INSERT INTO `family`
VALUES (4, 4, '荣义珊');
INSERT INTO `family`
VALUES (5, 1, '老王');
INSERT INTO `family`
VALUES (5, 2, '薛栋');
INSERT INTO `family`
VALUES (5, 3, '娄钰友');
INSERT INTO `family`
VALUES (6, 1, '庞杰');
INSERT INTO `family`
VALUES (6, 2, '荣礼瑾');
INSERT INTO `family`
VALUES (6, 3, '霍婵');
INSERT INTO `family`
VALUES (6, 4, '戴莺');
INSERT INTO `family`
VALUES (7, 4, '施金洁');
INSERT INTO `family`
VALUES (7, 5, '门呼上维');
INSERT INTO `family`
VALUES (7, 6, '束纯');
INSERT INTO `family`
VALUES (7, 7, '山易亨');
INSERT INTO `family`
VALUES (8, 1, '弓菊');
INSERT INTO `family`
VALUES (8, 2, '岑电真');
INSERT INTO `family`
VALUES (8, 3, '陈超');
INSERT INTO `family`
VALUES (8, 4, '时琬');
INSERT INTO `family`
VALUES (9, 1, '鲁学');
INSERT INTO `family`
VALUES (9, 2, '封华');
INSERT INTO `family`
VALUES (9, 3, '崔雅');
INSERT INTO `family`
VALUES (9, 4, '郁马弘');
INSERT INTO `family`
VALUES (10, 1, '邓义启');
INSERT INTO `family`
VALUES (10, 4, '刁中艳');
INSERT INTO `family`
VALUES (10, 5, '韶忠芳');
INSERT INTO `family`
VALUES (10, 6, '红马广');
INSERT INTO `family`
VALUES (11, 7, '钟离马榕');
INSERT INTO `family`
VALUES (11, 2, '宣新');
INSERT INTO `family`
VALUES (11, 3, '逄民');
INSERT INTO `family`
VALUES (11, 4, '萧友刚');
INSERT INTO `family`
VALUES (12, 1, '甄九贞');
INSERT INTO `family`
VALUES (12, 2, '牛上武');
INSERT INTO `family`
VALUES (12, 3, '葛孝平');
INSERT INTO `family`
VALUES (12, 4, '左振');
INSERT INTO `family`
VALUES (13, 1, '王文');
INSERT INTO `family`
VALUES (13, 2, '隗凯力');
INSERT INTO `family`
VALUES (13, 3, '屈林');
INSERT INTO `family`
VALUES (13, 4, '陶仁洁');
INSERT INTO `family`
VALUES (14, 4, '田卡冰');
INSERT INTO `family`
VALUES (14, 5, '梅瑞');
INSERT INTO `family`
VALUES (14, 6, '云君');
INSERT INTO `family`
VALUES (14, 7, '容霞');
INSERT INTO `family`
VALUES (15, 1, '罗飘');
INSERT INTO `family`
VALUES (15, 2, '粱怡');
INSERT INTO `family`
VALUES (15, 3, '呼延金义');
INSERT INTO `family`
VALUES (15, 4, '顾士');
INSERT INTO `family`
VALUES (16, 1, '韶贝融');
INSERT INTO `family`
VALUES (16, 2, '龚电滢');
INSERT INTO `family`
VALUES (16, 3, '贺凡');
INSERT INTO `family`
VALUES (16, 4, '龙豪');
INSERT INTO `family`
VALUES (17, 4, '左贝艺');
INSERT INTO `family`
VALUES (17, 5, '符俊');
INSERT INTO `family`
VALUES (17, 6, '弓歌时');
INSERT INTO `family`
VALUES (17, 7, '芮忠义');
INSERT INTO `family`
VALUES (18, 1, '方艳');
INSERT INTO `family`
VALUES (18, 2, '边君');
INSERT INTO `family`
VALUES (18, 3, '乐礼佳');
INSERT INTO `family`
VALUES (18, 4, '葛承');
INSERT INTO `family`
VALUES (19, 1, '云燕');
INSERT INTO `family`
VALUES (19, 2, '史春');
INSERT INTO `family`
VALUES (19, 3, '殴清');
INSERT INTO `family`
VALUES (19, 4, '满马蕊');
INSERT INTO `family`
VALUES (20, 1, '骆昌');
INSERT INTO `family`
VALUES (20, 2, '车澜');
INSERT INTO `family`
VALUES (20, 3, '寿琼');
INSERT INTO `family`
VALUES (20, 4, '尤庆');
INSERT INTO `family`
VALUES (25, 1, '阿萨德刚');

-- ----------------------------
-- Table structure for postion
-- ----------------------------
DROP TABLE IF EXISTS `postion`;
CREATE TABLE `postion`
(
    `positionId`   int(4)                                                 NOT NULL AUTO_INCREMENT,
    `positionName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`positionId`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of postion
-- ----------------------------
INSERT INTO `postion`
VALUES (1, '书记');
INSERT INTO `postion`
VALUES (2, '院长');
INSERT INTO `postion`
VALUES (3, '副书记');
INSERT INTO `postion`
VALUES (4, '副院长');
INSERT INTO `postion`
VALUES (5, '教师');
INSERT INTO `postion`
VALUES (6, '辅导员');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`
(
    `school_id`   int(4)                                                 NOT NULL AUTO_INCREMENT,
    `school_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`school_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school`
VALUES (1, '西安石油大学');
INSERT INTO `school`
VALUES (2, '西安电子科技大学');
INSERT INTO `school`
VALUES (3, '清华大学');
INSERT INTO `school`
VALUES (4, '北京大学');
INSERT INTO `school`
VALUES (5, '西安交通大学');

-- ----------------------------
-- Table structure for tea_edu
-- ----------------------------
DROP TABLE IF EXISTS `tea_edu`;
CREATE TABLE `tea_edu`
(
    `tea_id`    int(4) NOT NULL,
    `edu_type`  int(4) NOT NULL,
    `school_id` int(4) NULL DEFAULT NULL,
    `btime`     date   NULL DEFAULT NULL,
    `etime`     date   NULL DEFAULT NULL,
    INDEX `t_t` (`tea_id`) USING BTREE,
    CONSTRAINT `t_t` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tea_edu
-- ----------------------------
INSERT INTO `tea_edu`
VALUES (1, 1, 3, '2001-03-05', '2004-12-26');
INSERT INTO `tea_edu`
VALUES (2, 1, 2, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (3, 1, 3, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (4, 1, 4, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (5, 1, 5, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (6, 1, 1, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (7, 1, 2, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (8, 1, 3, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (9, 1, 4, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (10, 1, 5, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (11, 1, 1, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (12, 1, 2, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (13, 1, 3, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (14, 1, 4, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (15, 1, 5, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (16, 1, 1, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (17, 1, 2, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (18, 1, 3, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (19, 1, 4, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (20, 1, 5, '2010-09-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (1, 2, 1, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (2, 2, 2, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (3, 2, 3, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (4, 2, 4, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (5, 2, 5, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (6, 2, 1, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (7, 2, 2, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (8, 2, 3, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (9, 2, 4, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (10, 2, 5, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (11, 2, 1, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (12, 2, 2, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (13, 2, 3, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (14, 2, 4, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (15, 2, 5, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (16, 2, 1, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (17, 2, 2, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (18, 2, 3, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (19, 2, 4, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (20, 2, 5, '2014-12-28', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (1, 3, 1, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (2, 3, 2, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (3, 3, 3, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (4, 3, 4, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (5, 3, 5, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (6, 3, 1, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (7, 3, 2, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (8, 3, 3, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (9, 3, 4, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (10, 3, 5, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (11, 3, 1, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (12, 3, 2, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (13, 3, 3, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (14, 3, 4, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (15, 3, 5, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (16, 3, 1, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (17, 3, 2, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (18, 3, 3, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (19, 3, 4, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (20, 3, 5, '2018-01-01', '2014-06-28');
INSERT INTO `tea_edu`
VALUES (25, 1, 1, '2001-01-01', '2009-01-01');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`
(
    `tea_id`     int(4)                                                 NOT NULL AUTO_INCREMENT,
    `tea_name`   varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `gender`     varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `email`      varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `dept_id`    int(4)                                                 NOT NULL,
    `postion_id` int(4)                                                 NOT NULL,
    `title_id`   int(4)                                                 NOT NULL,
    PRIMARY KEY (`tea_id`) USING BTREE,
    INDEX `dep` (`dept_id`) USING BTREE,
    INDEX `t` (`title_id`) USING BTREE,
    INDEX `p` (`postion_id`) USING BTREE,
    CONSTRAINT `dep` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dep_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `p` FOREIGN KEY (`postion_id`) REFERENCES `postion` (`positionId`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `t` FOREIGN KEY (`title_id`) REFERENCES `title` (`titleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 26
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher`
VALUES (1, '金金', '女', '111@qq.com', 1, 3, 1);
INSERT INTO `teacher`
VALUES (2, '李玲芳', '女', '111@qq.com', 2, 5, 1);
INSERT INTO `teacher`
VALUES (3, '王继辉', '男', '112@qq.com', 3, 5, 1);
INSERT INTO `teacher`
VALUES (4, '钱秀辉', '男', '113@qq.com', 4, 5, 1);
INSERT INTO `teacher`
VALUES (5, '王军围', '女', '114@qq.com', 5, 5, 1);
INSERT INTO `teacher`
VALUES (6, '张龙辉', '男', '115@qq.com', 6, 5, 2);
INSERT INTO `teacher`
VALUES (7, '赵明立', '男', '116@qq.com', 1, 5, 2);
INSERT INTO `teacher`
VALUES (8, '张军立', '女', '117@qq.com', 2, 5, 2);
INSERT INTO `teacher`
VALUES (9, '魏玉刚', '男', '222@qq.com', 3, 3, 3);
INSERT INTO `teacher`
VALUES (10, '王永', '男', '2222@qq.com', 4, 5, 3);
INSERT INTO `teacher`
VALUES (11, '金明辉', '男', '224@qq.com', 5, 5, 3);
INSERT INTO `teacher`
VALUES (12, '王慧芳', '女', '2243@qq.com', 6, 2, 3);
INSERT INTO `teacher`
VALUES (13, '魏永立', '男', '2221@qq.com', 1, 5, 4);
INSERT INTO `teacher`
VALUES (14, '钱玲立', '男', '122@qq.com', 2, 5, 5);
INSERT INTO `teacher`
VALUES (15, '钱兴玲', '男', '1233@qq.com', 3, 5, 4);
INSERT INTO `teacher`
VALUES (16, '钱玲芳', '女', '123123@qq.com', 4, 5, 4);
INSERT INTO `teacher`
VALUES (17, '金玉围', '男', '3213@qq.com', 5, 5, 5);
INSERT INTO `teacher`
VALUES (18, '金秀刚', '男', '123@qq.com', 6, 5, 5);
INSERT INTO `teacher`
VALUES (19, '李玲辉', '女', '1231@qq.com', 1, 5, 5);
INSERT INTO `teacher`
VALUES (20, '魏秀芳', '男', '543@qq.com', 1, 5, 5);
INSERT INTO `teacher`
VALUES (21, 'adf', '男', '654@qq.com', 1, 1, 1);
INSERT INTO `teacher`
VALUES (25, '打啊', '男', 'null', 2, 2, 1);

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title`
(
    `titleId`   int(4)                                                 NOT NULL AUTO_INCREMENT,
    `titleName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`titleId`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title`
VALUES (1, '讲师');
INSERT INTO `title`
VALUES (2, '教授');
INSERT INTO `title`
VALUES (3, '副教授');
INSERT INTO `title`
VALUES (4, '助教');
INSERT INTO `title`
VALUES (5, '教授');

-- ----------------------------
-- View structure for tea_ap
-- ----------------------------
DROP VIEW IF EXISTS `tea_ap`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `tea_ap` AS
select `award_punish`.`ap_id`      AS `ap_id`,
       `award_punish`.`teacher_id` AS `teacher_id`,
       `teacher`.`tea_name`        AS `tea_name`,
       `ap_type`.`ap_type`         AS `ap_type`,
       `award_punish`.`time`       AS `time`,
       `award_punish`.`desc`       AS `desc`
from (`ap_type`
         left join (`award_punish` left join `teacher` on ((`teacher`.`tea_id` = `award_punish`.`teacher_id`)))
                   on ((`award_punish`.`type` = `ap_type`.`ap_id`)))
order by `award_punish`.`teacher_id`;

-- ----------------------------
-- View structure for tea_dept
-- ----------------------------
DROP VIEW IF EXISTS `tea_dept`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `tea_dept` AS
select `teacher`.`tea_id`       AS `tea_id`,
       `teacher`.`tea_name`     AS `tea_name`,
       `teacher`.`gender`       AS `gender`,
       `teacher`.`email`        AS `email`,
       `dept`.`depName`         AS `depName`,
       `title`.`titleName`      AS `titleName`,
       `postion`.`positionName` AS `positionName`
from (((`teacher` join `dept` on ((`dept`.`dep_id` = `teacher`.`dept_id`))) join `title` on ((`title`.`titleId` = `teacher`.`title_id`)))
         join `postion` on ((`postion`.`positionId` = `teacher`.`postion_id`)))
order by `teacher`.`tea_id`;

-- ----------------------------
-- View structure for tea_education
-- ----------------------------
DROP VIEW IF EXISTS `tea_education`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `tea_education` AS
select `tea_edu`.`tea_id`    AS `tea_id`,
       `teacher`.`tea_name`  AS `tea_name`,
       `s`.`school_name`     AS `school_name`,
       `edu_type`.`edu_name` AS `edu_name`,
       `tea_edu`.`btime`     AS `btime`,
       `tea_edu`.`etime`     AS `etime`
from (`school` `s`
         left join (`edu_type` left join (`tea_edu` left join `teacher` on ((`teacher`.`tea_id` = `tea_edu`.`tea_id`))) on ((`edu_type`.`edu_id` = `tea_edu`.`edu_type`)))
                   on ((`tea_edu`.`school_id` = `s`.`school_id`)))
order by `tea_edu`.`tea_id`;

-- ----------------------------
-- View structure for tea_family
-- ----------------------------
DROP VIEW IF EXISTS `tea_family`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `tea_family` AS
select `teacher`.`tea_id`         AS `tea_id`,
       `teacher`.`tea_name`       AS `tea_name`,
       `fam_type`.`fam_type_name` AS `fam_type_name`,
       `family`.`memer_name`      AS `member_name`
from (`fam_type`
         left join (`family` left join `teacher` on ((`teacher`.`tea_id` = `family`.`teacher_id`)))
                   on ((`fam_type`.`fam_id` = `family`.`home_member`)))
order by `family`.`teacher_id`;

-- ----------------------------
-- Procedure structure for dept_show
-- ----------------------------
DROP PROCEDURE IF EXISTS `dept_show`;
delimiter ;;
CREATE PROCEDURE `dept_show`(in deptName varchar(30))
begin
    select dep_id, depName, titleName, count(*) as titNumber
    from teacher
             right join title t on t.titleId = teacher.title_id
             right join dept d on d.dep_id = teacher.dept_id
    where depName = deptName
    group by t.titleName;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table teacher
-- ----------------------------
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

-- ----------------------------
-- Triggers structure for table teacher
-- ----------------------------
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

SET FOREIGN_KEY_CHECKS = 1;
