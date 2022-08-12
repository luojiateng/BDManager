/*
 Navicat Premium Data Transfer

 Source Server         : 57版本
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : oil_field

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 01/01/2022 08:16:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accident
-- ----------------------------
DROP TABLE IF EXISTS `accident`;
CREATE TABLE `accident`  (
  `Cnumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Indepth` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Endepth` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Encoding` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Gfloor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Stratum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Octime` datetime(0) NULL DEFAULT NULL,
  `Retime` datetime(0) NULL DEFAULT NULL,
  `Lossmoney` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Cnumber`) USING BTREE,
  CONSTRAINT `well_id` FOREIGN KEY (`Cnumber`) REFERENCES `well` (`cnumber`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of accident
-- ----------------------------
INSERT INTO `accident` VALUES ('P010001', '2500', '2599', 'P01', '栖霞层', '石灰层', '2009-10-21 14:54:37', '2010-01-06 14:54:49', '520000', '进行切割时，操作不当，使得油井发生火灾');
INSERT INTO `accident` VALUES ('P010002', '2601', '2500', 'P01', '栖霞层', '石灰岩', '2006-02-04 05:51:08', '2006-05-06 22:47:30', '51600', '在液柱压力没有平衡地层压力的情况下，进行拆井口作业 ，然后爆炸');
INSERT INTO `accident` VALUES ('P010003', '3166', '3222', 'P01', '第四系层', '生物灰岩', '2004-06-18 04:21:58', '2004-07-12 23:28:35', '254100', '进行作业时电路出现问题擦出火花，引起火灾。');
INSERT INTO `accident` VALUES ('P010005', '11', '112', '0', '11', '11', '2001-01-01 00:00:00', '2001-03-03 00:00:00', '1', '1111				');
INSERT INTO `accident` VALUES ('P020001', '1562', '1649', 'P02', '泥土粘层', '页层', '2006-05-27 08:40:19', '2007-01-20 22:40:40', '98000', '该井射孔通知单注明射孔层位的油气显示综合解释结构为油层及低压油层。射孔采用电缆输送方式共七炮。当完成第一炮射孔，电缆提出100米时，发生井涌，随后进行剪切射孔电缆、抢关放炮闸门失败，导致井喷失控，之后着火。');
INSERT INTO `accident` VALUES ('P030001', '6321', '6599', 'P03', '珍珠冲层 ', '泥岩', '2006-03-05 06:02:12', '2007-12-13 03:02:32', '960000', '计量罐内因射孔、高能气体压裂产生的高浓CO气体，造成违章进入计量罐内的三人中毒死亡。');
INSERT INTO `accident` VALUES ('P030002', '2223', '2339', 'P03', ' 第三系层', '砂岩', '2013-07-08 03:39:19', '2013-07-28 08:28:42', '256000', ' 施工步骤出错，导致设备故障。');
INSERT INTO `accident` VALUES ('p030003', '111', '1111', '0', '111', '111', '2001-01-01 00:00:00', '2001-03-03 00:00:00', '111', '的');
INSERT INTO `accident` VALUES ('P040001', '2211', '2311', 'P04', '第三系层', '砂岩', '2003-02-05 05:18:18', '2003-04-11 23:24:40', '520000', '进行钻井时，钻具转不动，持续两分钟发生塌方。');
INSERT INTO `accident` VALUES ('P060001', '2301', '2390', 'P06', '泥盆层', '粉砂岩', '2008-09-01 04:12:27', '2008-12-30 03:57:47', '260000', '在进行作业时，机器突然散落');
INSERT INTO `accident` VALUES ('P060002', '4233', '4451', 'P06', '上白垩系', '生物灰岩', '2009-05-06 23:31:46', '2009-05-29 04:25:00', '632000', '进行钻井时，设备未仔细检查，操作错误，造成人员伤亡。');
INSERT INTO `accident` VALUES ('P070001', '5600', '5920', 'P07', '雷一层', '泥灰岩', '2005-03-29 05:04:26', '2005-09-21 03:52:48', '490000', '进行焊接时，回收水罐突然发生爆炸。');

-- ----------------------------
-- Table structure for encoding
-- ----------------------------
DROP TABLE IF EXISTS `encoding`;
CREATE TABLE `encoding`  (
  `Encoding_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '事故类型编码',
  `Apattern` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '事故类型',
  PRIMARY KEY (`Encoding_id`) USING BTREE,
  INDEX `Encoding_id`(`Encoding_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of encoding
-- ----------------------------
INSERT INTO `encoding` VALUES ('P01', '火灾事故');
INSERT INTO `encoding` VALUES ('P02', '爆炸事故');
INSERT INTO `encoding` VALUES ('P03', '设备事故');
INSERT INTO `encoding` VALUES ('P04', '生产事故');
INSERT INTO `encoding` VALUES ('P05', '交通事故');
INSERT INTO `encoding` VALUES ('P06', '人身事故');
INSERT INTO `encoding` VALUES ('P07', '其他事故');

-- ----------------------------
-- Table structure for processes
-- ----------------------------
DROP TABLE IF EXISTS `processes`;
CREATE TABLE `processes`  (
  `Cnumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Trprocesses` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Cnumber`) USING BTREE,
  CONSTRAINT `accident_id` FOREIGN KEY (`Cnumber`) REFERENCES `accident` (`Cnumber`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of processes
-- ----------------------------
INSERT INTO `processes` VALUES ('P010001', '及时将伤者送往医院救助，对伤者进行安抚，医药费的赔付，安全隐患的加大力度排查');
INSERT INTO `processes` VALUES ('P010002', '及时将伤者送往医院救助，及时总结教训，对违章行为严厉打击');
INSERT INTO `processes` VALUES ('P010003', '及时将伤者送往医院救助，对危险进行排查，以最快的速度进行安全的保障');
INSERT INTO `processes` VALUES ('P010005', '1111');
INSERT INTO `processes` VALUES ('P020001', '及时将伤者送往医院救助，加大力度对安全工作的保障');
INSERT INTO `processes` VALUES ('P030001', '及时将伤者送往医院救助，对伤者进行赔付，对事件造成者进行处罚');
INSERT INTO `processes` VALUES ('P030002', '及时将伤者送往医院救助，并及时对损失进行弥补，分析事故的原由并加强防范。');
INSERT INTO `processes` VALUES ('p030003', ' 第三次');
INSERT INTO `processes` VALUES ('P040001', '及时将伤者送往医院救助，及时对机器进行修复，对安全隐患进行一一排查');
INSERT INTO `processes` VALUES ('P060001', '及时将伤者送往医院救助，在有效地时间内进行工作的总结教训。');
INSERT INTO `processes` VALUES ('P060002', '及时将伤者送往医院救助，对伤者进行安抚，医药费的赔付，安全隐患的加大力度排查');
INSERT INTO `processes` VALUES ('P070001', '及时将伤者送往医院救助，加强管控，对事故的发生经行分析');

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign`  (
  `Cnumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Symbol` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  INDEX `Snumber`(`Time`) USING BTREE,
  INDEX `accident`(`Cnumber`) USING BTREE,
  CONSTRAINT `accident_id1` FOREIGN KEY (`Cnumber`) REFERENCES `accident` (`Cnumber`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES ('p010002', 'Before', '没有制定安全防护和应急措施   错误处理');
INSERT INTO `sign` VALUES ('p010002', 'Before', '转不动钻具，泵压忽高忽低');
INSERT INTO `sign` VALUES ('p020001', 'Before', '电压不稳，未仔细检查');
INSERT INTO `sign` VALUES ('p010002', 'Before', '错误操作');
INSERT INTO `sign` VALUES ('p010002', 'After', '油田部分坍塌');
INSERT INTO `sign` VALUES ('p020001', 'After', '气温突变冷');
INSERT INTO `sign` VALUES ('p020001', 'After', '空气湿度增加');
INSERT INTO `sign` VALUES ('P010001', 'Before', '切割作业不能进行');
INSERT INTO `sign` VALUES ('P070001', 'After', '甲方未到场，乙方未按规定进行高风险作业，没有制定安全保护措施');

-- ----------------------------
-- Table structure for well
-- ----------------------------
DROP TABLE IF EXISTS `well`;
CREATE TABLE `well`  (
  `cnumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `wnumber` int(11) NULL DEFAULT NULL,
  `oname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cnumber`) USING BTREE,
  INDEX `cnumber`(`cnumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of well
-- ----------------------------
INSERT INTO `well` VALUES ('P010001', 65, '西北油田');
INSERT INTO `well` VALUES ('p010002', 111, '大庆油田');
INSERT INTO `well` VALUES ('p010003', 112, '延长油田');
INSERT INTO `well` VALUES ('P010004', 111, '大庆油田');
INSERT INTO `well` VALUES ('P010005', 111, '大庆油田');
INSERT INTO `well` VALUES ('p020001', 111, '大庆油田');
INSERT INTO `well` VALUES ('p030001', 114, '辽河油田');
INSERT INTO `well` VALUES ('p030002', 111, '大庆油田');
INSERT INTO `well` VALUES ('p030003', 111, '111');
INSERT INTO `well` VALUES ('p040001', 116, '长庆油田');
INSERT INTO `well` VALUES ('p060001', 117, '塔里木油田');
INSERT INTO `well` VALUES ('p060002', 118, '大庆油田');
INSERT INTO `well` VALUES ('p070001', 119, '塔里木油田');

-- ----------------------------
-- View structure for well_accident
-- ----------------------------
DROP VIEW IF EXISTS `well_accident`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `well_accident` AS select `well`.`cnumber` AS `cnumber`,`well`.`wnumber` AS `wnumber`,`well`.`oname` AS `oname`,`a`.`Indepth` AS `Indepth`,`a`.`Endepth` AS `Endepth`,`a`.`Encoding` AS `Encoding`,`a`.`Gfloor` AS `Gfloor`,`a`.`Stratum` AS `Stratum`,`a`.`Octime` AS `Octime`,`a`.`Retime` AS `Retime`,`a`.`Lossmoney` AS `Lossmoney`,`a`.`pass` AS `pass`,`e`.`Apattern` AS `Apattern` from ((`accident` `a` left join `well` on((`well`.`cnumber` = `a`.`Cnumber`))) join `encoding` `e` on((`a`.`Encoding` = convert(`e`.`Encoding_id` using utf8mb4))));

-- ----------------------------
-- Procedure structure for dateDiff
-- ----------------------------
DROP PROCEDURE IF EXISTS `dateDiff`;
delimiter ;;
CREATE PROCEDURE `dateDiff`(in cnumber varchar(255))
begin
    SELECT CONCAT(
                   FLOOR(seconds / 86400), '天',
                   FLOOR(seconds % 86400 / 3600), '小时',
                   FLOOR((seconds % 3600) / 60), '分钟',
                   FLOOR((seconds % 3600) % 60), '秒'
               ) AS RTS
    FROM (
             SELECT IFNULL(TIMESTAMPDIFF(SECOND, Octime, Retime), 0) AS seconds
             FROM accident
             where accident.Cnumber = cnumber
         ) AS t;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for show_oliAccient
-- ----------------------------
DROP PROCEDURE IF EXISTS `show_oliAccient`;
delimiter ;;
CREATE PROCEDURE `show_oliAccient`(in oilname varchar(30))
begin
    select count(*) as AccidentCount, oname
    from accident
             inner join well on accident.Cnumber = well.cnumber
    where oname = oilname
    group by oname;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for show_wellAccident
-- ----------------------------
DROP PROCEDURE IF EXISTS `show_wellAccident`;
delimiter ;;
CREATE PROCEDURE `show_wellAccident`(in wellNumber int(11))
begin
    select count(*) as AccidentCount, wnumber
    from accident
             inner join well w on accident.Cnumber = w.cnumber
    where wnumber = wellNumber
    group by wnumber;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
