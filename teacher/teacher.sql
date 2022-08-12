/*
 Navicat Premium Data Transfer

 Source Server         : 57版本
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : teacher

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 02/01/2022 15:06:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for award_punish
-- ----------------------------
DROP TABLE IF EXISTS `award_punish`;
CREATE TABLE `award_punish`  (
  `apNumber` int(4) NOT NULL AUTO_INCREMENT,
  `teacherNumber` int(4) NOT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `time` date NOT NULL,
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`apNumber`) USING BTREE,
  INDEX `e`(`type`) USING BTREE,
  INDEX `ap_t`(`teacherNumber`) USING BTREE,
  CONSTRAINT `ap_t` FOREIGN KEY (`teacherNumber`) REFERENCES `teacher` (`teacherNumber`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of award_punish
-- ----------------------------
INSERT INTO `award_punish` VALUES (2, 2, '处罚', '2022-05-28', '这是处罚');
INSERT INTO `award_punish` VALUES (3, 3, '处罚', '2021-08-28', '这是处罚');
INSERT INTO `award_punish` VALUES (4, 4, '处罚', '2021-06-28', '这是处罚');
INSERT INTO `award_punish` VALUES (6, 6, '处罚', '2019-12-28', '这是处罚');
INSERT INTO `award_punish` VALUES (7, 7, '处罚', '2021-09-28', '这是处罚');
INSERT INTO `award_punish` VALUES (8, 8, '处罚', '2021-06-25', '这是处罚');
INSERT INTO `award_punish` VALUES (9, 9, '处罚', '2019-06-28', '这是处罚');
INSERT INTO `award_punish` VALUES (10, 1, '奖励', '2019-05-28', '这是奖励');
INSERT INTO `award_punish` VALUES (11, 2, '奖励', '2019-06-23', '这是奖励');
INSERT INTO `award_punish` VALUES (12, 3, '奖励', '2019-12-28', '这是奖励');
INSERT INTO `award_punish` VALUES (13, 4, '奖励', '2020-06-28', '这是奖励');
INSERT INTO `award_punish` VALUES (14, 5, '奖励', '2021-06-25', '这是奖励');
INSERT INTO `award_punish` VALUES (15, 6, '奖励', '2021-06-28', '这是奖励');
INSERT INTO `award_punish` VALUES (16, 7, '奖励', '2021-07-25', '这是奖励');
INSERT INTO `award_punish` VALUES (17, 8, '奖励', '2021-08-28', '这是奖励');
INSERT INTO `award_punish` VALUES (19, 10, '奖励', '2021-12-24', '这是奖励');
INSERT INTO `award_punish` VALUES (20, 11, '奖励', '2022-05-28', '这是奖励');
INSERT INTO `award_punish` VALUES (21, 10, '奖励', '2022-03-03', '大发');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `deptNumber` int(4) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `teacherNum` int(4) NULL DEFAULT 0,
  PRIMARY KEY (`deptNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '教务处', 1);
INSERT INTO `department` VALUES (2, '后勤处', 0);
INSERT INTO `department` VALUES (3, '学生处', 3);
INSERT INTO `department` VALUES (4, '保卫处', 3);
INSERT INTO `department` VALUES (5, '招生办', 3);
INSERT INTO `department` VALUES (6, '人事部', 3);
INSERT INTO `department` VALUES (10, '财务部', 0);
INSERT INTO `department` VALUES (11, '后勤部', 0);
INSERT INTO `department` VALUES (12, '请求', 0);
INSERT INTO `department` VALUES (13, '1111', 0);

-- ----------------------------
-- Table structure for education
-- ----------------------------
DROP TABLE IF EXISTS `education`;
CREATE TABLE `education`  (
  `eduNumber` int(4) NOT NULL AUTO_INCREMENT,
  `eduName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`eduNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of education
-- ----------------------------
INSERT INTO `education` VALUES (1, '本科阶段');
INSERT INTO `education` VALUES (2, '硕士');
INSERT INTO `education` VALUES (3, '博士及博士后');

-- ----------------------------
-- Table structure for education_exper
-- ----------------------------
DROP TABLE IF EXISTS `education_exper`;
CREATE TABLE `education_exper`  (
  `teacherNumber` int(4) NOT NULL,
  `educationNumber` int(4) NOT NULL,
  `schoolNumber` int(4) NULL DEFAULT NULL,
  `begin` date NULL DEFAULT NULL,
  `end` date NULL DEFAULT NULL,
  INDEX `e_e`(`educationNumber`) USING BTREE,
  INDEX `e_t`(`teacherNumber`) USING BTREE,
  INDEX `e_s`(`schoolNumber`) USING BTREE,
  CONSTRAINT `e_e` FOREIGN KEY (`educationNumber`) REFERENCES `education` (`eduNumber`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `e_s` FOREIGN KEY (`schoolNumber`) REFERENCES `school` (`schoolNumber`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `e_t` FOREIGN KEY (`teacherNumber`) REFERENCES `teacher` (`teacherNumber`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of education_exper
-- ----------------------------
INSERT INTO `education_exper` VALUES (1, 1, 1, '2001-03-05', '2004-12-26');
INSERT INTO `education_exper` VALUES (2, 1, 2, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (3, 1, 3, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (4, 1, 4, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (5, 1, 5, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (6, 1, 1, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (7, 1, 2, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (8, 1, 3, '2010-09-28', '2014-06-29');
INSERT INTO `education_exper` VALUES (9, 1, 4, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (10, 1, 5, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (11, 1, 1, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (12, 1, 2, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (13, 1, 3, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (14, 1, 4, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (15, 1, 5, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (16, 1, 1, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (17, 1, 2, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (18, 1, 3, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (19, 1, 4, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (20, 1, 5, '2010-09-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (1, 2, 1, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (2, 2, 2, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (3, 2, 3, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (4, 2, 4, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (5, 2, 5, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (6, 2, 1, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (7, 2, 2, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (8, 2, 3, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (9, 2, 4, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (10, 2, 5, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (11, 2, 1, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (12, 2, 2, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (13, 2, 3, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (14, 2, 4, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (15, 2, 5, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (16, 2, 1, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (17, 2, 2, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (18, 2, 3, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (19, 2, 4, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (20, 2, 5, '2014-12-28', '2014-06-28');
INSERT INTO `education_exper` VALUES (1, 3, 1, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (2, 3, 2, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (3, 3, 3, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (4, 3, 4, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (5, 3, 5, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (6, 3, 1, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (7, 3, 2, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (8, 3, 3, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (9, 3, 4, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (10, 3, 5, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (11, 3, 1, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (12, 3, 2, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (13, 3, 3, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (14, 3, 4, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (15, 3, 5, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (16, 3, 1, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (17, 3, 2, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (18, 3, 3, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (19, 3, 4, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (20, 3, 5, '2018-01-01', '2014-06-28');
INSERT INTO `education_exper` VALUES (27, 1, 1, '2020-01-01', '2021-12-12');

-- ----------------------------
-- Table structure for family
-- ----------------------------
DROP TABLE IF EXISTS `family`;
CREATE TABLE `family`  (
  `teacherNumber` int(4) NOT NULL,
  `relation` int(4) NOT NULL COMMENT '家庭成员关系',
  `fName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of family
-- ----------------------------
INSERT INTO `family` VALUES (1, 1, '霍凯杰');
INSERT INTO `family` VALUES (1, 2, '甄秋');
INSERT INTO `family` VALUES (1, 3, 'qqqq');
INSERT INTO `family` VALUES (1, 4, '乌菲');
INSERT INTO `family` VALUES (2, 1, '武义');
INSERT INTO `family` VALUES (2, 4, '黄波');
INSERT INTO `family` VALUES (2, 5, 'uu');
INSERT INTO `family` VALUES (2, 6, '包凯蓉');
INSERT INTO `family` VALUES (3, 7, '满彬');
INSERT INTO `family` VALUES (3, 2, '昌文');
INSERT INTO `family` VALUES (3, 3, '柳金萍');
INSERT INTO `family` VALUES (3, 4, '庄易友');
INSERT INTO `family` VALUES (4, 1, '游被芬');
INSERT INTO `family` VALUES (4, 2, '辕令瑗');
INSERT INTO `family` VALUES (4, 3, '益华');
INSERT INTO `family` VALUES (4, 4, '荣义珊');
INSERT INTO `family` VALUES (5, 1, '老王');
INSERT INTO `family` VALUES (5, 2, '薛栋');
INSERT INTO `family` VALUES (5, 3, '娄钰友');
INSERT INTO `family` VALUES (6, 1, '庞杰');
INSERT INTO `family` VALUES (6, 2, '荣礼瑾');
INSERT INTO `family` VALUES (6, 3, '霍婵');
INSERT INTO `family` VALUES (6, 4, '戴莺');
INSERT INTO `family` VALUES (7, 4, '施金洁');
INSERT INTO `family` VALUES (7, 5, '门呼上维');
INSERT INTO `family` VALUES (7, 6, '束纯');
INSERT INTO `family` VALUES (7, 7, '山易亨');
INSERT INTO `family` VALUES (8, 1, '弓菊');
INSERT INTO `family` VALUES (8, 2, '岑电真');
INSERT INTO `family` VALUES (8, 3, '陈超');
INSERT INTO `family` VALUES (8, 4, '时琬');
INSERT INTO `family` VALUES (9, 1, '鲁学');
INSERT INTO `family` VALUES (9, 2, '封华');
INSERT INTO `family` VALUES (9, 3, '崔雅');
INSERT INTO `family` VALUES (9, 4, '郁马弘');
INSERT INTO `family` VALUES (10, 1, '邓义启');
INSERT INTO `family` VALUES (10, 4, '刁中艳');
INSERT INTO `family` VALUES (10, 5, '韶忠芳');
INSERT INTO `family` VALUES (10, 6, '红马广');
INSERT INTO `family` VALUES (11, 7, '钟离马榕');
INSERT INTO `family` VALUES (11, 2, '宣新');
INSERT INTO `family` VALUES (11, 3, '逄民');
INSERT INTO `family` VALUES (11, 4, '111');
INSERT INTO `family` VALUES (12, 1, '甄九贞');
INSERT INTO `family` VALUES (12, 2, '牛上武');
INSERT INTO `family` VALUES (12, 3, '葛孝平');
INSERT INTO `family` VALUES (12, 4, '左振');
INSERT INTO `family` VALUES (13, 1, '王文');
INSERT INTO `family` VALUES (13, 2, '隗凯力');
INSERT INTO `family` VALUES (13, 3, '屈林');
INSERT INTO `family` VALUES (13, 4, '陶仁洁');
INSERT INTO `family` VALUES (14, 4, '田卡冰');
INSERT INTO `family` VALUES (14, 5, '梅瑞');
INSERT INTO `family` VALUES (14, 6, '云君');
INSERT INTO `family` VALUES (14, 7, '容霞');
INSERT INTO `family` VALUES (15, 1, '罗飘');
INSERT INTO `family` VALUES (15, 2, '粱怡');
INSERT INTO `family` VALUES (15, 3, '呼延金义');
INSERT INTO `family` VALUES (15, 4, '顾士');
INSERT INTO `family` VALUES (16, 1, '韶贝融');
INSERT INTO `family` VALUES (16, 2, '龚电滢');
INSERT INTO `family` VALUES (16, 3, '贺凡');
INSERT INTO `family` VALUES (16, 4, '龙豪');
INSERT INTO `family` VALUES (17, 4, '左贝艺');
INSERT INTO `family` VALUES (17, 5, '符俊');
INSERT INTO `family` VALUES (17, 6, '弓歌时');
INSERT INTO `family` VALUES (17, 7, '芮忠义');
INSERT INTO `family` VALUES (18, 1, '方艳');
INSERT INTO `family` VALUES (18, 2, '边君');
INSERT INTO `family` VALUES (18, 3, '乐礼佳');
INSERT INTO `family` VALUES (18, 4, '葛承');
INSERT INTO `family` VALUES (19, 1, '云燕');
INSERT INTO `family` VALUES (19, 2, '史春');
INSERT INTO `family` VALUES (19, 3, '殴清');
INSERT INTO `family` VALUES (19, 4, '满马蕊');
INSERT INTO `family` VALUES (20, 1, '骆昌');
INSERT INTO `family` VALUES (20, 2, '车澜');
INSERT INTO `family` VALUES (20, 3, '寿琼');
INSERT INTO `family` VALUES (20, 4, '尤庆');
INSERT INTO `family` VALUES (25, 1, '阿萨德刚');
INSERT INTO `family` VALUES (26, 2, 'aaa');
INSERT INTO `family` VALUES (27, 1, 'uuuu');
INSERT INTO `family` VALUES (27, 2, 'uuujbhb');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `positionNumber` int(4) NOT NULL AUTO_INCREMENT,
  `positionName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`positionNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '书记');
INSERT INTO `position` VALUES (2, '副书记');
INSERT INTO `position` VALUES (3, '主任');
INSERT INTO `position` VALUES (4, '科长');
INSERT INTO `position` VALUES (5, '教师');
INSERT INTO `position` VALUES (6, '导助');
INSERT INTO `position` VALUES (8, '请求');

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation`  (
  `relationNumber` int(4) NOT NULL AUTO_INCREMENT COMMENT '成员类型编号',
  `familys` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '成员名称',
  PRIMARY KEY (`relationNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relation
-- ----------------------------
INSERT INTO `relation` VALUES (1, '父亲');
INSERT INTO `relation` VALUES (2, '母亲');
INSERT INTO `relation` VALUES (3, '儿子');
INSERT INTO `relation` VALUES (4, '女儿');
INSERT INTO `relation` VALUES (5, '配偶');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`  (
  `schoolNumber` int(4) NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`schoolNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES (1, '西安石油大学');
INSERT INTO `school` VALUES (2, '西安电子科技大学');
INSERT INTO `school` VALUES (3, '清华大学');
INSERT INTO `school` VALUES (4, '北京大学');
INSERT INTO `school` VALUES (5, '西安交通大学');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacherNumber` int(4) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gender` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `birth` date NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `deptNumber` int(4) NOT NULL,
  `postionNumber` int(4) NOT NULL,
  `titleNumber` int(4) NOT NULL,
  PRIMARY KEY (`teacherNumber`) USING BTREE,
  INDEX `dep`(`deptNumber`) USING BTREE,
  INDEX `t`(`titleNumber`) USING BTREE,
  INDEX `p`(`postionNumber`) USING BTREE,
  CONSTRAINT `dep` FOREIGN KEY (`deptNumber`) REFERENCES `department` (`deptNumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `p` FOREIGN KEY (`postionNumber`) REFERENCES `position` (`positionNumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t` FOREIGN KEY (`titleNumber`) REFERENCES `title` (`titleNumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '韩瑞', '男', '1980-01-01', '111@qq.com', 1, 3, 1);
INSERT INTO `teacher` VALUES (2, '毕邦', '女', '1980-01-01', '111@qq.com', 2, 5, 1);
INSERT INTO `teacher` VALUES (3, '缪俊', '男', '1980-01-01', '112@qq.com', 3, 5, 1);
INSERT INTO `teacher` VALUES (4, '殷笑梅', '男', '1980-01-01', '113@qq.com', 4, 5, 1);
INSERT INTO `teacher` VALUES (5, '庄忠静', '女', '1980-01-01', '114@qq.com', 5, 5, 1);
INSERT INTO `teacher` VALUES (6, '封星', '男', '1980-01-01', '115@qq.com', 6, 5, 2);
INSERT INTO `teacher` VALUES (7, '尤礼丹', '男', '1980-01-01', '116@qq.com', 1, 5, 2);
INSERT INTO `teacher` VALUES (8, '乐政', '女', '1980-01-01', '117@qq.com', 2, 4, 5);
INSERT INTO `teacher` VALUES (9, '红彬', '男', '1980-01-01', '222@qq.com', 3, 3, 3);
INSERT INTO `teacher` VALUES (10, '包卡莺', '男', '1980-01-01', '2222@qq.com', 4, 5, 3);
INSERT INTO `teacher` VALUES (11, '冉娴', '男', '1980-01-01', '224@qq.com', 1, 5, 3);
INSERT INTO `teacher` VALUES (12, '张卡霭', '男', '1980-01-01', '2243@qq.com', 6, 2, 1);
INSERT INTO `teacher` VALUES (13, '甫尉加谦', '男', '1980-01-01', '2221@qq.com', 1, 5, 4);
INSERT INTO `teacher` VALUES (14, '姜敬', '男', '1980-01-01', '122@qq.com', 2, 5, 5);
INSERT INTO `teacher` VALUES (15, '宣力', '男', '1980-01-01', '1233@qq.com', 3, 5, 4);
INSERT INTO `teacher` VALUES (16, '郁马莲', '女', '1980-01-01', '123123@qq.com', 4, 5, 4);
INSERT INTO `teacher` VALUES (17, '西漆莉', '男', '1980-01-01', '3213@qq.com', 5, 5, 5);
INSERT INTO `teacher` VALUES (18, '安红', '男', '1980-01-01', '123@qq.com', 6, 5, 5);
INSERT INTO `teacher` VALUES (19, '金玉善', '女', '1980-01-01', '1231@qq.com', 1, 5, 5);
INSERT INTO `teacher` VALUES (20, '张', '男', '1980-01-01', '543@qq.com', 1, 5, 5);
INSERT INTO `teacher` VALUES (27, '梅岩', '女', '1980-01-01', '2020@qq.com', 1, 6, 1);
INSERT INTO `teacher` VALUES (29, '111', '男', '2001-03-03', 'null', 1, 1, 3);

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title`  (
  `titleNumber` int(4) NOT NULL AUTO_INCREMENT,
  `titleName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`titleNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title` VALUES (1, '讲师');
INSERT INTO `title` VALUES (2, '教授');
INSERT INTO `title` VALUES (3, '副教授');
INSERT INTO `title` VALUES (4, '助教');
INSERT INTO `title` VALUES (5, '教授');
INSERT INTO `title` VALUES (6, '助理是');

-- ----------------------------
-- View structure for familyinfo
-- ----------------------------
DROP VIEW IF EXISTS `familyinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `familyinfo` AS select `teacher`.`teacherNumber` AS `teacherNumber`,`teacher`.`teacherName` AS `teacherName`,`relation`.`familys` AS `familys`,`f`.`fName` AS `fName` from (`relation` left join (`teacher` join `family` `f` on((`f`.`teacherNumber` = `teacher`.`teacherNumber`))) on((`relation`.`relationNumber` = `f`.`relation`))) order by `teacher`.`teacherNumber`;

-- ----------------------------
-- View structure for teacherap
-- ----------------------------
DROP VIEW IF EXISTS `teacherap`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `teacherap` AS select `ap`.`apNumber` AS `apNumber`,`teacher`.`teacherNumber` AS `teacherNumber`,`teacher`.`teacherName` AS `teacherName`,`ap`.`type` AS `type`,`ap`.`time` AS `time`,`ap`.`describe` AS `describe` from (`teacher` join `award_punish` `ap` on((`teacher`.`teacherNumber` = `ap`.`teacherNumber`))) order by `ap`.`apNumber`;

-- ----------------------------
-- View structure for teacheredu
-- ----------------------------
DROP VIEW IF EXISTS `teacheredu`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `teacheredu` AS select `teacher`.`teacherNumber` AS `teacherNumber`,`teacher`.`teacherName` AS `teacherName`,`e`.`eduName` AS `eduName`,`ee`.`begin` AS `begin`,`ee`.`end` AS `end`,`s`.`schoolName` AS `schoolName` from (((`teacher` join `education_exper` `ee` on((`teacher`.`teacherNumber` = `ee`.`teacherNumber`))) join `education` `e` on((`ee`.`educationNumber` = `e`.`eduNumber`))) join `school` `s` on((`ee`.`schoolNumber` = `s`.`schoolNumber`))) order by `teacher`.`teacherNumber`;

-- ----------------------------
-- View structure for teacherinfo
-- ----------------------------
DROP VIEW IF EXISTS `teacherinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `teacherinfo` AS select `teacher`.`teacherNumber` AS `teacherNumber`,`teacher`.`teacherName` AS `teacherName`,`teacher`.`gender` AS `gender`,`teacher`.`birth` AS `birth`,`teacher`.`email` AS `email`,`t`.`titleName` AS `titleName`,`d`.`deptName` AS `deptName`,`p`.`positionName` AS `positionName` from (((`teacher` join `department` `d` on((`teacher`.`deptNumber` = `d`.`deptNumber`))) join `position` `p` on((`teacher`.`postionNumber` = `p`.`positionNumber`))) join `title` `t` on((`teacher`.`titleNumber` = `t`.`titleNumber`))) order by `teacher`.`teacherNumber`;

-- ----------------------------
-- Procedure structure for deptInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `deptInfo`;
delimiter ;;
CREATE PROCEDURE `deptInfo`(in IndeptName varchar(30))
begin
    select d.deptNumber, deptName, titleName, count(*) as titleCount
    from teacher
             right join title t on teacher.titleNumber = t.titleNumber
             right join department d on d.deptNumber = teacher.deptNumber
    where deptName = IndeptName
    group by t.titleName;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table teacher
-- ----------------------------
DROP TRIGGER IF EXISTS `email__check`;
delimiter ;;
CREATE TRIGGER `email__check` BEFORE INSERT ON `teacher` FOR EACH ROW begin
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
DROP TRIGGER IF EXISTS `add_teaNumber`;
delimiter ;;
CREATE TRIGGER `add_teaNumber` AFTER INSERT ON `teacher` FOR EACH ROW begin
    update department set teacherNum=teacherNum + 1 where deptNumber = NEW.deptNumber;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table teacher
-- ----------------------------
DROP TRIGGER IF EXISTS `delete_teaNumber`;
delimiter ;;
CREATE TRIGGER `delete_teaNumber` AFTER DELETE ON `teacher` FOR EACH ROW begin
    update department set teacherNum=teacherNum - 1 where deptNumber = OLD.deptNumber;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
