use pas;
/****table1 insert 老师基本信息表**********************/
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19860209', '金明辉', '教授', 1, '1981-7-5', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19820501', '张龙辉', '教授', 1, '1982-8-4', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19820202', '王军围', '副教授', 1, '1982-10-6', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19910401', '李玲辉', '副教授', 1, '1991-12-19', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19860501', '王慧芳', '副教授', 1, '1986-1-19', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19890301', '钱玲芳', '助教', 1, '1989-10-6', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19920001', '魏秀芳', '副教授', 1, '1992-1-9', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19890002', '钱兴玲', '副教授', 1, '1989-8-29', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19900001', '金秀刚', '助教', 2, '1990-12-14', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19880001', '魏永立', '助教', 2, '1988-12-9', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19830302', '赵明立', '助教', 2, '1983-6-8', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19890403', '金玉围', '助教', 2, '1989-9-20', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19800201', '金明强', '教授', 1, '1980-6-2', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19820103', '钱秀辉', '讲师', 1, '1982-4-16', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19810202', '王继辉', '副教授', 1, '1981-12-18', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19800402', '李玲芳', '教授', 1, '1980-9-29', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19860102', '王永', '教授', 1, '1986-5-17', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19880402', '钱玲立', '副教授', 1, '1988-11-29', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19840302', '魏玉刚', '讲师', 1, '1984-3-5', 1, 1);
insert into teacher (teanum, teaName, teatitle, teatypeid, teabtd, pwd, state)
values ('19830503', '张军立', '讲师', 1, '1983-12-6', 1, 1);

/****table2 insert 班级信息表**********************/
insert into classinfo (clsId, clsName, grade, teaNum)
values (38, '计类1班', '2020-9-1', '19830302');
insert into classinfo (clsName, grade, teaNum)
values ('计类2班', '2020-9-1', '19830302');
insert into classinfo (clsName, grade, teaNum)
values ('数科1班', '2020-9-1', '19880001');
insert into classinfo (clsName, grade, teaNum)
values ('数科2班', '2020-9-1', '19880001');
insert into classinfo (clsName, grade, teaNum)
values ('数科3班', '2020-9-1', '19880001');
insert into classinfo (clsName, grade, teaNum)
values ('通信1班', '2020-9-1', '19890403');
insert into classinfo (clsName, grade, teaNum)
values ('通信2班', '2020-9-1', '19890403');
insert into classinfo (clsName, grade, teaNum)
values ('通信3班', '2020-9-1', '19890403');
insert into classinfo (clsName, grade, teaNum)
values ('通信4班', '2020-9-1', '19890403');
insert into classinfo (clsName, grade, teaNum)
values ('通信5班', '2020-9-1', '19900001');
insert into classinfo (clsName, grade, teaNum)
values ('通信6班', '2020-9-1', '19900001');


/****table3 insert 学生信息表**********************/
/*添加学生信息*/
/*添加触发器*/
CREATE TRIGGER studentInsert AFTER INSERT ON student  
FOR EACH ROW 
update classInfo set stuCount = stuCount + 1 where  clsId = NEW.clsId;


insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010101, 38, '霍凯杰', '2001-9-21', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020101, 39, '乐礼佳', '2002-6-20', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030101, 40, '宣雁', '2002-8-21', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020201, 41, '范聪', '2002-10-25', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020301, 42, '俞先', '2002-2-12', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030201, 43, '司寇慧', '2002-1-5', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020401, 44, '江凯慧', '2000-4-6', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020501, 45, '羊上军', '2002-3-9', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020601, 46, '芮宜', '2001-7-5', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030301, 48, '颜马真', '2002-12-7', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010102, 38, '甄秋', '2001-9-3', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020102, 39, '葛承', '2002-12-25', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030102, 40, '柯九倩', '2001-10-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020202, 41, '跋夹易德', '2002-11-29', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020302, 42, '林蓉', '2001-12-4', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030202, 43, '姚英', '2002-3-20', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020402, 44, '茹卿', '2002-12-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020502, 45, '尹被珍', '2001-9-26', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020602, 46, '谷宰卡薇', '2002-8-20', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030302, 48, '沃易月', '2001-1-18', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010103, 38, '柳玉瑶', '2002-8-21', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020103, 39, '云燕', '2002-3-22', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030103, 40, '左玉', '2001-2-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020203, 41, '郁卡裕', '2001-5-9', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020303, 42, '陈松', '2002-2-16', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030203, 43, '花上永', '2002-5-27', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020403, 44, '单于贝伊', '2002-2-21', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020503, 45, '禹士', '1999-6-14', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020603, 46, '雷鹏', '2001-10-29', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030303, 48, '温好婉', '2002-5-8', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010104, 38, '乌菲', '2002-5-25', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020104, 39, '史春', '2002-11-2', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030104, 40, '凤叶', '2002-10-2', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020204, 41, '邵策', '2002-7-1', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020304, 42, '方伊', '2000-8-11', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030204, 43, '金希', '2001-5-9', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020404, 44, '卫九策', '2001-4-17', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020504, 45, '都爽', '2002-2-11', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020604, 46, '弓凯凡', '2000-5-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030304, 48, '井好清', '2002-7-24', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010105, 38, '武义', '2002-2-4', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020105, 39, '殴清', '2000-10-18', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030105, 40, '侯诸都佳', '2002-8-2', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020205, 41, '陶笑和', '2002-6-28', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020305, 42, '殷金妍', '2002-4-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030205, 43, '郁电眉', '2001-3-14', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020405, 44, '成有', '2002-7-24', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020505, 45, '洪彩', '2002-3-7', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020605, 46, '严蓓', '2002-3-2', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030305, 48, '韩瑞', '2001-9-15', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010106, 38, '黄波', '2002-2-13', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020106, 39, '滕伊', '2003-6-26', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030106, 40, '孔智安', '2002-1-15', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020206, 41, '衡玉娟', '2002-8-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020306, 42, '刁谦', '2001-7-24', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030206, 43, '梁段友荣', '2000-9-3', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020406, 44, '邱叶', '2001-9-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020506, 45, '殷智乐', '2002-12-7', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020606, 46, '湛孝绍', '2002-12-26', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030306, 48, '毕邦', '2002-5-17', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010107, 38, '刘峰', '2002-5-7', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020107, 39, '满马蕊', '2001-1-26', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030107, 40, '景电航', '2000-3-6', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020207, 41, '耿九行', '2001-1-18', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020307, 42, '东方嘉', '2002-8-9', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030207, 43, '严瑗', '2002-10-8', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020407, 44, '乔无旭', '2002-1-1', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020507, 45, '西门维', '1999-1-18', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020607, 46, '容金泰', '2002-4-22', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030307, 48, '缪俊', '2002-1-21', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010108, 38, '包凯蓉', '2002-11-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020108, 39, '骆昌', '2003-11-18', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030108, 40, '门南金凡', '2002-2-28', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020208, 41, '傅春', '2002-3-25', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020308, 42, '柳易璧', '2002-10-27', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030208, 43, '林香', '2002-10-4', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020408, 44, '凤凯宜', '2001-1-29', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020508, 45, '高仁振', '1999-9-14', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020608, 46, '孙中震', '2001-3-4', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030308, 48, '殷笑梅', '2002-8-11', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010109, 38, '满彬', '2002-1-26', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020109, 39, '车澜', '2001-9-12', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030109, 40, '贝莉', '2002-6-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020209, 41, '孔元', '2001-2-21', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020309, 42, '东易和', '2000-9-22', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030209, 43, '关叶', '2002-12-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020409, 44, '殴金庆', '2000-3-1', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020509, 45, '弓器翔', '2003-5-19', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020609, 46, '冀聪', '2002-4-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030309, 48, '庄忠静', '2001-7-4', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010110, 38, '昌文', '2002-6-1', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020110, 39, '寿琼', '2002-11-26', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030110, 40, '东郭器海', '2002-10-10', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020210, 41, '薛平', '2002-4-23', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020310, 42, '计贝哲', '2002-8-25', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030210, 43, '苍卡克', '2002-1-17', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020410, 44, '叶炎', '2001-10-12', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020510, 45, '满好蓓', '2001-11-15', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020610, 46, '双婵', '2002-4-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030310, 48, '封星', '2002-7-10', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010111, 38, '柳金萍', '2002-9-15', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020111, 39, '尤庆', '2002-8-21', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030111, 40, '岑无艺', '2002-10-24', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020211, 41, '童有', '2002-1-12', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020311, 42, '潘凝', '2000-7-10', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030211, 43, '黄萍', '2002-3-23', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020411, 44, '范电香', '2003-11-10', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020511, 45, '孔友娟', '2002-7-29', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020611, 46, '邴谦', '2002-11-29', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030311, 48, '尤礼丹', '2002-4-6', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010112, 38, '庄易友', '2002-4-19', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020112, 39, '万策', '2002-12-2', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030112, 40, '石笑卿', '2002-6-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020212, 41, '苍都玲', '2002-9-12', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020312, 42, '夹谷昌', '2002-5-29', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030212, 43, '文贵', '2002-11-24', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020412, 44, '甄被辰', '2002-7-13', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020512, 45, '崔瑾', '2002-5-20', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020612, 46, '缪国', '2002-10-9', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030312, 48, '乐政', '2001-7-24', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010113, 38, '游被芬', '2000-6-2', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020113, 39, '裴友国', '2001-3-2', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030113, 40, '汪贝羽', '2002-1-6', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020213, 41, '殴金林', '2002-10-28', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020313, 42, '董都伯', '2002-5-10', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030213, 43, '褚霭', '2002-8-18', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020413, 44, '翁君', '2002-3-12', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020513, 45, '朱瑾', '2002-2-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020613, 46, '国茗', '2002-3-11', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030313, 48, '红彬', '2002-1-30', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010114, 38, '辕令瑗', '2001-11-20', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020114, 39, '刘琦', '2002-6-4', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030114, 40, '江欢', '2002-2-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020214, 41, '和信绍', '2002-10-4', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020314, 42, '谷友凝', '2002-10-7', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030214, 43, '常上宁', '2001-11-18', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020414, 44, '陶上江', '2002-10-14', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020514, 45, '茹荷', '2002-7-12', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020614, 46, '国信', '2000-12-21', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030314, 48, '包卡莺', '2002-6-11', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010115, 38, '益华', '2002-2-12', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020115, 39, '刁维', '2001-1-12', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030115, 40, '劳致', '2002-4-16', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020215, 41, '卫枫', '2002-4-5', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020315, 42, '殴金希', '2002-1-27', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030215, 43, '强竹', '2002-2-21', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020415, 44, '姜仁宁', '2002-3-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020515, 45, '公冶琳', '2001-5-14', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020615, 46, '季忠雁', '2002-3-21', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030315, 48, '冉娴', '2002-12-26', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010116, 38, '荣义珊', '2002-1-26', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020116, 39, '荣凯琛', '2002-5-7', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030116, 40, '巴静', '2002-11-8', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020216, 41, '左巧', '2002-9-25', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020316, 42, '居星', '2001-1-18', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030216, 43, '乌秀', '2002-8-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020416, 44, '万器霞', '2002-1-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020516, 45, '符电环', '2002-11-30', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020616, 46, '红燕', '2000-12-27', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030316, 48, '张卡霭', '2002-5-18', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010117, 38, '郁和', '2002-5-19', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020117, 39, '侯诸蓓', '2002-3-5', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030117, 40, '马公珊', '2002-6-28', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020217, 41, '邬行', '2002-5-26', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020317, 42, '盖上颖', '2001-9-30', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030217, 43, '韩歌策', '2002-10-28', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020417, 44, '龚礼蓓', '2002-2-3', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020517, 45, '东明', '2001-8-10', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020617, 46, '温电彩', '2002-12-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030317, 48, '甫尉加谦', '2002-8-6', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010118, 38, '薛栋', '2002-7-18', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020118, 39, '田器雅', '2002-11-26', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030118, 40, '燕信江', '2002-6-24', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020218, 41, '景义璐', '2002-9-26', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020318, 42, '盛易韵', '2002-3-16', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030218, 43, '贝菊', '2002-8-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020418, 44, '向忠羽', '2002-6-3', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020518, 45, '屈鹏', '2001-10-27', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020618, 46, '熊瑗', '2002-7-18', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030318, 48, '姜敬', '2002-11-15', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010119, 38, '娄钰友', '2002-12-29', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020119, 39, '尤钰荣', '2002-7-29', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030119, 40, '终孝澜', '2000-3-3', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020219, 41, '程孝莉', '2002-4-11', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020319, 42, '百里仁栋', '2001-3-29', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030219, 43, '荀善', '2002-6-14', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020419, 44, '郑信馥', '2002-9-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020519, 45, '奚都蓓', '2000-6-19', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020619, 46, '钟爽', '2002-1-6', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030319, 48, '宣力', '2000-5-15', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010120, 38, '延羊秀', '2002-10-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020120, 39, '国谦', '2002-8-27', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030120, 40, '宰加贵', '2001-8-6', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020220, 41, '狄礼妍', '2002-4-8', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020320, 42, '雷无聪', '2002-5-16', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030220, 43, '沃家', '2002-7-27', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020420, 44, '符宜', '2002-3-23', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020520, 45, '冉晨', '2001-3-22', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020620, 46, '江婕', '2002-2-25', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030320, 48, '郁马莲', '2002-12-30', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010121, 38, '庞杰', '2002-3-19', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020121, 39, '步以', '2002-2-28', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030121, 40, '童竹', '2002-10-3', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020221, 41, '鲁钰翔', '2002-3-11', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020321, 42, '都菊', '2002-12-23', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030221, 43, '董妍', '2001-2-18', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020421, 44, '乔智成', '2002-2-16', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020521, 45, '周易华', '2002-8-3', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020621, 46, '毕龙', '2001-9-29', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030321, 48, '西漆莉', '2002-1-7', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010122, 38, '荣礼瑾', '2002-2-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020122, 39, '胡友馨', '1999-1-29', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030122, 40, '薛冰', '2002-9-4', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020222, 41, '霍易琴', '2002-2-7', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020322, 42, '席进', '2002-3-20', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030222, 43, '季忠莲', '2003-5-26', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020422, 44, '危嘉', '2002-3-18', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020522, 45, '童钰静', '2002-8-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020622, 46, '顾中', '2002-1-9', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030322, 48, '安红', '2002-9-10', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010123, 38, '霍婵', '2002-3-14', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020123, 39, '许礼成', '2002-3-28', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030123, 40, '吕信泽', '2001-9-16', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020223, 41, '诸葛以', '2002-7-19', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020323, 42, '干利', '2002-6-10', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030223, 43, '宋仁素', '2002-8-21', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020423, 44, '曹歌枫', '2002-3-20', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020523, 45, '双玉咏', '2002-8-12', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020623, 46, '罗刚', '2002-5-7', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030323, 48, '金玉善', '2000-1-7', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010124, 38, '戴莺', '2001-3-22', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020124, 39, '乌姣', '2002-12-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030124, 40, '顾顺', '2001-4-17', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020224, 41, '刘霭', '2001-5-14', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020324, 42, '宗梁', '2002-8-18', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030224, 43, '端木友秀', '2002-12-23', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020424, 44, '益霭', '2001-6-18', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020524, 45, '洪加蓉', '2001-5-19', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020624, 46, '强仪', '2000-10-29', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030324, 48, '都荔', '2001-8-25', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010125, 38, '施金洁', '2000-4-12', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020125, 39, '高中信', '2002-10-24', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030125, 40, '冀电轮', '2002-1-23', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020225, 41, '申屠策', '2002-4-17', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020325, 42, '巴珠', '2001-8-14', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030225, 43, '童被玲', '2002-6-27', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020425, 44, '计筠', '2002-8-7', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020525, 45, '洪树', '2002-1-9', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020625, 46, '计凡', '2000-2-22', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030325, 48, '梅岩', '2001-6-12', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010126, 38, '门呼上维', '2002-4-7', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020126, 39, '戚瑾', '2002-7-25', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030126, 40, '甄被腾', '2002-6-24', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020226, 41, '奚仁思', '2002-1-21', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020326, 42, '孙被维', '2002-10-10', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030226, 43, '姜贝茗', '2002-11-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020426, 44, '冀澜', '2000-11-28', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020526, 45, '卞都玉', '2002-10-20', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020626, 46, '尹器桂', '2001-9-12', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030326, 48, '林被滢', '2002-5-19', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010127, 38, '束纯', '2002-1-29', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020127, 39, '赵歌妍', '2002-4-6', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030127, 40, '邢贞', '2002-6-9', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020227, 41, '谷宰亚', '2002-12-8', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020327, 42, '松玉哲', '2001-7-17', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030227, 43, '强彬', '2002-4-17', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020427, 44, '危都萍', '2002-5-12', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020527, 45, '阳淳秋', '2002-12-8', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020627, 46, '元玉菁', '2000-3-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030327, 48, '贺被素', '2002-7-8', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010128, 38, '山易亨', '2002-9-8', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020128, 39, '巴伊', '2002-5-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030128, 40, '谷贵', '2002-12-28', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020228, 41, '劳钰秀', '2002-10-29', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020328, 42, '安欣', '2001-3-30', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030228, 43, '景静', '2000-5-2', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020428, 44, '戴歌玲', '2002-5-8', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020528, 45, '单才', '2001-2-5', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020628, 46, '路器心', '2000-10-6', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030328, 48, '邓义', '2001-6-21', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010129, 38, '弓菊', '2002-7-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020129, 39, '符笑强', '2002-4-7', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030129, 40, '牛义昭', '2002-3-21', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020229, 41, '舌微世', '2002-1-26', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020329, 42, '杭凤', '2002-9-9', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030229, 43, '安国', '2002-12-10', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020429, 44, '祁莉', '2002-9-14', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020529, 45, '韦凯珍', '2001-7-10', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020629, 46, '袁晶', '2000-12-23', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030329, 48, '平亮', '2002-7-5', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010130, 38, '岑电真', '2002-2-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020130, 39, '牧卡珠', '2002-2-14', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030130, 40, '邵会', '2001-9-13', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020230, 41, '通壮', '2002-6-4', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020330, 42, '吕广', '2002-5-8', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030230, 43, '牛舒', '2002-2-5', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020430, 44, '侯礼蓉', '2002-3-26', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020530, 45, '鲍伊', '2002-8-22', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020630, 46, '苍中贞', '2000-8-24', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030330, 48, '翁菁', '2002-9-14', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010131, 38, '陈超', '2000-8-9', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020131, 39, '卜卿', '2002-6-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030131, 40, '岑好顺', '2002-6-5', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020231, 41, '包友', '2001-1-22', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020331, 42, '诸电冰', '2001-6-5', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030231, 43, '宁器晶', '2002-4-2', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020431, 44, '屈中先', '2002-11-18', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020531, 45, '益慧', '2002-9-28', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020631, 46, '苍钰勇', '2002-12-23', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030331, 48, '东郭佳', '2001-2-28', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010132, 38, '时琬', '2002-1-11', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020132, 39, '芮器学', '2002-2-14', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030132, 40, '滑荔', '2002-5-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020232, 41, '闻人器蓓', '2002-4-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020332, 42, '韶被义', '2000-4-30', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030232, 43, '成都文', '2001-8-4', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020432, 44, '唐克', '2002-9-25', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020532, 45, '司徒元', '2002-11-2', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020632, 46, '伍茂', '2002-6-7', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030332, 48, '符鹏', '2002-2-5', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010133, 38, '鲁学', '2002-8-25', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020133, 39, '淳于琛', '2002-6-25', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030133, 40, '褚信诚', '2002-8-6', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020233, 41, '储天', '2002-12-2', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020333, 42, '卞孝龙', '2002-6-23', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030233, 43, '庞孝义', '2002-7-26', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020433, 44, '姚薇', '2001-6-14', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020533, 45, '隗智国', '2002-6-12', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020633, 46, '颛孙桂', '2002-8-7', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030333, 48, '包义', '2002-5-14', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010134, 38, '封华', '2000-9-23', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020134, 39, '晋都星', '2002-3-15', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030134, 40, '水加妍', '2002-3-15', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020234, 41, '云卡叶', '2002-3-14', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020334, 42, '林无思', '2001-2-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030234, 43, '钱庆', '2002-5-30', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020434, 44, '屈锦', '2002-4-2', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020534, 45, '邬冠', '2002-6-20', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020634, 46, '宰珊', '2002-10-7', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030334, 48, '喻炎', '2001-2-19', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010135, 38, '崔雅', '2002-4-6', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020135, 39, '奚飞', '2002-11-21', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030135, 40, '罗都叶', '2003-7-27', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020235, 41, '冉娴', '2002-6-13', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020335, 42, '官欧上盛', '2002-11-14', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007030235, 43, '许真', '2001-8-24', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020435, 44, '盛凯滢', '2000-9-29', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020535, 45, '卢孝昌', '2000-8-27', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007020635, 46, '董珊', '2001-3-5', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010201, 47, '郁马弘', '2001-12-1', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010202, 47, '邓义启', '2002-6-2', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010203, 47, '刁中艳', '2002-5-19', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010204, 47, '韶忠芳', '2002-8-21', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010205, 47, '红马广', '2002-9-1', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010206, 47, '钟离马榕', '2001-7-15', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010207, 47, '宣新', '2001-1-1', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010208, 47, '逄民', '2002-2-22', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010209, 47, '萧友刚', '2002-5-18', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010210, 47, '甄九贞', '2002-5-23', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010211, 47, '牛上武', '2002-11-11', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010212, 47, '葛孝平', '2002-4-15', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010213, 47, '左振', '2002-6-3', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010214, 47, '王文', '2001-2-22', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010215, 47, '隗凯力', '2002-7-1', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010216, 47, '屈林', '2001-4-10', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010217, 47, '陶仁洁', '2002-2-27', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010218, 47, '田卡冰', '2002-7-30', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010219, 47, '梅瑞', '2002-3-8', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010220, 47, '云君', '2002-1-23', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010221, 47, '容霞', '2002-1-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010222, 47, '罗飘', '2002-10-22', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010223, 47, '粱怡', '2001-7-16', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010224, 47, '呼延金义', '2002-7-14', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010225, 47, '顾士', '2002-11-11', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010226, 47, '韶贝融', '2001-7-17', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010227, 47, '龚电滢', '2002-4-1', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010228, 47, '贺凡', '2000-12-4', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010229, 47, '龙豪', '2002-2-2', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010230, 47, '左贝艺', '2000-5-9', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010231, 47, '符俊', '2002-3-26', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010232, 47, '弓歌时', '2002-8-11', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010233, 47, '芮忠义', '2002-7-22', 1, 1, 1);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010234, 47, '方艳', '2002-1-21', 1, 1, 0);
insert into student (stunum, clsid, stuname, stubtd, pwd, state, sex)
values (202007010235, 47, '边君', '1999-10-13', 1, 1, 0);


/****table5 insert 课程基本信息表**********************/
insert into lesson(lesname,context, score, hours) values ('Java','Java',4,56);
insert into lesson(lesname,context, score, hours) values ('python','python',3,48);
insert into lesson(lesname,context, score, hours) values ('C','C',3,48);
insert into lesson(lesname,context, score, hours) values ('C++','C++',4,56);
insert into lesson(lesname,context, score, hours) values ('数据结构','数据结构',3,45);
insert into lesson(lesname,context, score, hours) values ('通信原理','通信原理',1,48);

/****table6 insert 课程安排**********************/
use pas;
-- Java课程计科2个班 数科3个班 开
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (1, '19800201', 38, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (1, '19800201', 39, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (1, '19800402', 40, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (1, '19800402', 41, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (1, '19800402', 42, 2020, 1);
-- C语言所有班开
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19810202', 38, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19810202', 39, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19810202', 40, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19820103', 41, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19820103', 42, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19820103', 43, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19820103', 44, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19820202', 45, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19820202', 46, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19820202', 47, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (3, '19820202', 48, 2020, 1);
-- python只有数科开
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (2, '19920001', 40, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (2, '19920001', 41, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (2, '19920001', 42, 2020, 1);
-- 通讯原理只有通信开
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (6, '19800402', 43, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (6, '19800402', 44, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (6, '19810202', 45, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (6, '19810202', 46, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (6, '19820202', 47, 2020, 1);
insert into coursearrangement(lesId,teaNum,clsId,year,semester) values (6, '19820202', 48, 2020, 1);


/****table7 insert 考试安排表**********************/

insert into examschedule(caId, examDate, state, context) values (1,'2020-6-3',0,'计类java语言考试');
insert into examschedule(caId, examDate, state, context) values (2,'2020-6-3',0,'计类java语言考试');
insert into examschedule(caId, examDate, state, context) values (3,'2020-6-3',0,'数科java语言考试');
insert into examschedule(caId, examDate, state, context) values (4,'2020-6-3',0,'数科java考试');
insert into examschedule(caId, examDate, state, context) values (5,'2020-6-3',0,'数科java考试');

insert into examschedule(caId, examDate, state, context) values (6,'2020-6-13',0,'C考试');
insert into examschedule(caId, examDate, state, context) values (7,'2020-6-13',0,'C考试');
insert into examschedule(caId, examDate, state, context) values (8,'2020-6-13',0,'C考试');
insert into examschedule(caId, examDate, state, context) values (9,'2020-6-13',0,'C考试');
insert into examschedule(caId, examDate, state, context) values (10,'2020-6-13',0,'C考试');
insert into examschedule(caId, examDate, state, context) values (11,'2020-6-15',0,'C考试');
insert into examschedule(caId, examDate, state, context) values (12,'2020-6-15',0,'C考试');
insert into examschedule(caId, examDate, state, context) values (13,'2020-6-15',0,'C考试');
insert into examschedule(caId, examDate, state, context) values (14,'2020-6-15',0,'C考试');
insert into examschedule(caId, examDate, state, context) values (15,'2020-6-15',0,'C考试');
insert into examschedule(caId, examDate, state, context) values (16,'2020-6-15',0,'C考试');

insert into examschedule(caId, examDate, state, context) values (17,'2020-6-15',0,'python');
insert into examschedule(caId, examDate, state, context) values (18,'2020-6-15',0,'python');
insert into examschedule(caId, examDate, state, context) values (19,'2020-6-15',0,'python');

insert into examschedule(caId, examDate, state, context) values (20,'2020-6-18',0,'通信考试');
insert into examschedule(caId, examDate, state, context) values (21,'2020-6-18',0,'通信考试');
insert into examschedule(caId, examDate, state, context) values (22,'2020-6-18',0,'通信考试');
insert into examschedule(caId, examDate, state, context) values (23,'2020-6-18',0,'通信考试');
insert into examschedule(caId, examDate, state, context) values (24,'2020-6-18',0,'通信考试');
insert into examschedule(caId, examDate, state, context) values (25,'2020-6-18',0,'通信考试');



/****table8 insert 成绩表**********************/
/*计科一班java考试*/
insert into score(esid, stuNum, score)values(1, 202007010101, 58);
insert into score(esid, stuNum, score)values(1, 202007010102, 66);
insert into score(esid, stuNum, score)values(1, 202007010103, 78);
insert into score(esid, stuNum, score)values(1, 202007010104, 43);
insert into score(esid, stuNum, score)values(1, 202007010105, 69);
insert into score(esid, stuNum, score)values(1, 202007010106, 77);
insert into score(esid, stuNum, score)values(1, 202007010107, 28);
insert into score(esid, stuNum, score)values(1, 202007010108, 92);
insert into score(esid, stuNum, score)values(1, 202007010109, 76);
insert into score(esid, stuNum, score)values(1, 202007010110, 94);
insert into score(esid, stuNum, score)values(1, 202007010111, 88);
insert into score(esid, stuNum, score)values(1, 202007010112, 64);
insert into score(esid, stuNum, score)values(1, 202007010113, 60);
insert into score(esid, stuNum, score)values(1, 202007010114, 61);
insert into score(esid, stuNum, score)values(1, 202007010115, 65);
insert into score(esid, stuNum, score)values(1, 202007010116, 77);
insert into score(esid, stuNum, score)values(1, 202007010117, 94);
insert into score(esid, stuNum, score)values(1, 202007010118, 58);
insert into score(esid, stuNum, score)values(1, 202007010119, 59);
insert into score(esid, stuNum, score)values(1, 202007010120, 68);
insert into score(esid, stuNum, score)values(1, 202007010121, 74);
insert into score(esid, stuNum, score)values(1, 202007010122, 68);
insert into score(esid, stuNum, score)values(1, 202007010123, 100);
insert into score(esid, stuNum, score)values(1, 202007010124, 64);
insert into score(esid, stuNum, score)values(1, 202007010125, 44);
insert into score(esid, stuNum, score)values(1, 202007010126, 87);
insert into score(esid, stuNum, score)values(1, 202007010127, 62);
insert into score(esid, stuNum, score)values(1, 202007010128, 68);
insert into score(esid, stuNum, score)values(1, 202007010129, 0);
insert into score(esid, stuNum, score)values(1, 202007010130, 58);
insert into score(esid, stuNum, score)values(1, 202007010131, 59);
insert into score(esid, stuNum, score)values(1, 202007010132, 64);
insert into score(esid, stuNum, score)values(1, 202007010133, 60);
/*计科2班Java考试*/
/*计科2班java考试(5号，34号缺考)*/
insert into score(esid, stuNum, score)
values (2, 202007020101, 93);
insert into score(esid, stuNum, score)
values (2, 202007020102, 75);
insert into score(esid, stuNum, score)
values (2, 202007020103, 46);
insert into score(esid, stuNum, score)
values (2, 202007020104, 76);
insert into score(esid, stuNum, score)
values (2, 202007020106, 73);
insert into score(esid, stuNum, score)
values (2, 202007020107, 77);
insert into score(esid, stuNum, score)
values (2, 202007020108, 65);
insert into score(esid, stuNum, score)
values (2, 202007020109, 77);
insert into score(esid, stuNum, score)
values (2, 202007020110, 65);
insert into score(esid, stuNum, score)
values (2, 202007020111, 57);
insert into score(esid, stuNum, score)
values (2, 202007020112, 79);
insert into score(esid, stuNum, score)
values (2, 202007020113, 94);
insert into score(esid, stuNum, score)
values (2, 202007020114, 37);
insert into score(esid, stuNum, score)
values (2, 202007020115, 99);
insert into score(esid, stuNum, score)
values (2, 202007020116, 66);
insert into score(esid, stuNum, score)
values (2, 202007020117, 88);
insert into score(esid, stuNum, score)
values (2, 202007020118, 78);
insert into score(esid, stuNum, score)
values (2, 202007020119, 94);
insert into score(esid, stuNum, score)
values (2, 202007020120, 51);
insert into score(esid, stuNum, score)
values (2, 202007020121, 55);
insert into score(esid, stuNum, score)
values (2, 202007020122, 70);
insert into score(esid, stuNum, score)
values (2, 202007020123, 66);
insert into score(esid, stuNum, score)
values (2, 202007020124, 56);
insert into score(esid, stuNum, score)
values (2, 202007020125, 59);
insert into score(esid, stuNum, score)
values (2, 202007020126, 66);
insert into score(esid, stuNum, score)
values (2, 202007020127, 90);
insert into score(esid, stuNum, score)
values (2, 202007020128, 87);
insert into score(esid, stuNum, score)
values (2, 202007020129, 61);
insert into score(esid, stuNum, score)
values (2, 202007020130, 95);
insert into score(esid, stuNum, score)
values (2, 202007020131, 74);
insert into score(esid, stuNum, score)
values (2, 202007020132, 77);
insert into score(esid, stuNum, score)
values (2, 202007020133, 68);
insert into score(esid, stuNum, score)
values (2, 202007020135, 89);
/*数科1班Java考试 班号40 数科1班  java考试 */
insert into score(esid, stuNum, score)values (3, 202007030101, 65);
insert into score(esid, stuNum, score)values (3, 202007030102, 95);
insert into score(esid, stuNum, score)values (3, 202007030103, 84);
insert into score(esid, stuNum, score)values (3, 202007030104, 73);
insert into score(esid, stuNum, score)values (3, 202007030105, 54);
insert into score(esid, stuNum, score)values (3, 202007030106, 52);
insert into score(esid, stuNum, score)values (3, 202007030107, 60);
insert into score(esid, stuNum, score)values (3, 202007030108, 68);
insert into score(esid, stuNum, score)values (3, 202007030109, 88);
insert into score(esid, stuNum, score)values (3, 202007030110, 77);
insert into score(esid, stuNum, score)values (3, 202007030111, 45);
insert into score(esid, stuNum, score)values (3, 202007030112, 98);
insert into score(esid, stuNum, score)values (3, 202007030113, 78);
insert into score(esid, stuNum, score)values (3, 202007030114, 65);
insert into score(esid, stuNum, score)values (3, 202007030115, 59);
insert into score(esid, stuNum, score)values (3, 202007030116, 51);
insert into score(esid, stuNum, score)values (3, 202007030117, 54);
insert into score(esid, stuNum, score)values (3, 202007030118, 85);
insert into score(esid, stuNum, score)values (3, 202007030119, 87);
insert into score(esid, stuNum, score)values (3, 202007030120, 48);
insert into score(esid, stuNum, score)values (3, 202007030121, 84);
insert into score(esid, stuNum, score)values (3, 202007030122, 69);
insert into score(esid, stuNum, score)values (3, 202007030123, 77);
insert into score(esid, stuNum, score)values (3, 202007030124, 73);
insert into score(esid, stuNum, score)values (3, 202007030125, 88);
insert into score(esid, stuNum, score)values (3, 202007030126, 87);
insert into score(esid, stuNum, score)values (3, 202007030127, 61);
insert into score(esid, stuNum, score)values (3, 202007030128, 54);
insert into score(esid, stuNum, score)values (3, 202007030129, 45);
insert into score(esid, stuNum, score)values (3, 202007030130, 46);
insert into score(esid, stuNum, score)values (3, 202007030131, 25);
insert into score(esid, stuNum, score)values (3, 202007030132, 54);
insert into score(esid, stuNum, score)values (3, 202007030133, 76);
insert into score(esid, stuNum, score)values (3, 202007030134, 79);
insert into score(esid, stuNum, score)values (3, 202007030135, 60);

/*数科2班Java考试*/
insert into score(esid, stuNum, score) values (4, 202007020201, 44);
insert into score(esid, stuNum, score) values (4, 202007020202, 49);
insert into score(esid, stuNum, score) values (4, 202007020203, 40);
insert into score(esid, stuNum, score) values (4, 202007020204, 46);
insert into score(esid, stuNum, score) values (4, 202007020205, 47);
insert into score(esid, stuNum, score) values (4, 202007020206, 54);
insert into score(esid, stuNum, score) values (4, 202007020207, 59);
insert into score(esid, stuNum, score) values (4, 202007020208, 52);
insert into score(esid, stuNum, score) values (4, 202007020209, 53);
insert into score(esid, stuNum, score) values (4, 202007020210, 58);
insert into score(esid, stuNum, score) values (4, 202007020211, 61);
insert into score(esid, stuNum, score) values (4, 202007020212, 63);
insert into score(esid, stuNum, score) values (4, 202007020213, 68);
insert into score(esid, stuNum, score) values (4, 202007020214, 66);
insert into score(esid, stuNum, score) values (4, 202007020215, 64);
insert into score(esid, stuNum, score) values (4, 202007020216, 72);
insert into score(esid, stuNum, score) values (4, 202007020217, 79);
insert into score(esid, stuNum, score) values (4, 202007020218, 71);
insert into score(esid, stuNum, score) values (4, 202007020219, 76);
insert into score(esid, stuNum, score) values (4, 202007020220, 77);
insert into score(esid, stuNum, score) values (4, 202007020221, 84);
insert into score(esid, stuNum, score) values (4, 202007020222, 86);
insert into score(esid, stuNum, score) values (4, 202007020223, 88);
insert into score(esid, stuNum, score) values (4, 202007020224, 89);
insert into score(esid, stuNum, score) values (4, 202007020225, 83);
insert into score(esid, stuNum, score) values (4, 202007020226, 91);
insert into score(esid, stuNum, score) values (4, 202007020227, 99);
insert into score(esid, stuNum, score) values (4, 202007020228, 96);
insert into score(esid, stuNum, score) values (4, 202007020229, 95);
insert into score(esid, stuNum, score) values (4, 202007020230, 92);
insert into score(esid, stuNum, score) values (4, 202007020231, 49);
insert into score(esid, stuNum, score) values (4, 202007020232, 56);
insert into score(esid, stuNum, score) values (4, 202007020233, 68);
insert into score(esid, stuNum, score) values (4, 202007020234, 75);
insert into score(esid, stuNum, score) values (4, 202007020235, 89);

/*数科3班Java考试*/
insert into score(esid,stuNum,score) values (5, 202007020301, 56);
insert into score(esid,stuNum,score) values (5, 202007020302, 68);
insert into score(esid,stuNum,score) values (5, 202007020303, 78);
insert into score(esid,stuNum,score) values (5, 202007020304, 96);
insert into score(esid,stuNum,score) values (5, 202007020305, 43);
insert into score(esid,stuNum,score) values (5, 202007020306, 59);
insert into score(esid,stuNum,score) values (5, 202007020308, 85);
insert into score(esid,stuNum,score) values (5, 202007020309, 74);
insert into score(esid,stuNum,score) values (5, 202007020310, 93);
insert into score(esid,stuNum,score) values (5, 202007020311, 85);
insert into score(esid,stuNum,score) values (5, 202007020312, 66);
insert into score(esid,stuNum,score) values (5, 202007020314, 53);
insert into score(esid,stuNum,score) values (5, 202007020315, 92);
insert into score(esid,stuNum,score) values (5, 202007020316, 59);
insert into score(esid,stuNum,score) values (5, 202007020318, 78);
insert into score(esid,stuNum,score) values (5, 202007020319, 90);
insert into score(esid,stuNum,score) values (5, 202007020320, 80);
insert into score(esid,stuNum,score) values (5, 202007020322, 63);
insert into score(esid,stuNum,score) values (5, 202007020323, 55);
insert into score(esid,stuNum,score) values (5, 202007020324, 89);
insert into score(esid,stuNum,score) values (5, 202007020325, 67);
insert into score(esid,stuNum,score) values (5, 202007020327, 84);
insert into score(esid,stuNum,score) values (5, 202007020328, 72);
insert into score(esid,stuNum,score) values (5, 202007020329, 62);
insert into score(esid,stuNum,score) values (5, 202007020330, 63);
insert into score(esid,stuNum,score) values (5, 202007020331, 86);
insert into score(esid,stuNum,score) values (5, 202007020332, 53);
insert into score(esid,stuNum,score) values (5, 202007020333, 87);
insert into score(esid,stuNum,score) values (5, 202007020334, 57);

/*计科1班C语言考试*/
insert into score(esid, stuNum, score) values (6, '202007010101', 73); 
insert into score(esid, stuNum, score) values (6, '202007010102', 88);
insert into score(esid, stuNum, score) values (6, '202007010103', 79);
insert into score(esid, stuNum, score) values (6, '202007010104', 99);
insert into score(esid, stuNum, score) values (6, '202007010105', 60);
insert into score(esid, stuNum, score) values (6, '202007010106', 100);
insert into score(esid, stuNum, score) values (6, '202007010107', 83);
insert into score(esid, stuNum, score) values (6, '202007010108', 55);
insert into score(esid, stuNum, score) values (6, '202007010109', 59);
insert into score(esid, stuNum, score) values (6, '202007010110', 73);
insert into score(esid, stuNum, score) values (6, '202007010111', 84);
insert into score(esid, stuNum, score) values (6, '202007010112', 61);
insert into score(esid, stuNum, score) values (6, '202007010113', 77);
insert into score(esid, stuNum, score) values (6, '202007010114', 50);
insert into score(esid, stuNum, score) values (6, '202007010115', 58);
insert into score(esid, stuNum, score) values (6, '202007010116', 72);
insert into score(esid, stuNum, score) values (6, '202007010117', 69);
insert into score(esid, stuNum, score) values (6, '202007010118', 78);
insert into score(esid, stuNum, score) values (6, '202007010119', 88);
insert into score(esid, stuNum, score) values (6, '202007010120', 81);
insert into score(esid, stuNum, score) values (6, '202007010121', 79);
insert into score(esid, stuNum, score) values (6, '202007010122', 89);
insert into score(esid, stuNum, score) values (6, '202007010123', 95);
insert into score(esid, stuNum, score) values (6, '202007010124', 93);
insert into score(esid, stuNum, score) values (6, '202007010125', 76);
insert into score(esid, stuNum, score) values (6, '202007010126', 70);
insert into score(esid, stuNum, score) values (6, '202007010127', 46);
insert into score(esid, stuNum, score) values (6, '202007010128', 58);
insert into score(esid, stuNum, score) values (6, '202007010129', 66);
insert into score(esid, stuNum, score) values (6, '202007010130', 55);
insert into score(esid, stuNum, score) values (6, '202007010131', 88);
insert into score(esid, stuNum, score) values (6, '202007010132', 99);
insert into score(esid, stuNum, score) values (6, '202007010133', 100);
insert into score(esid, stuNum, score) values (6, '202007010134', 75);
insert into score(esid, stuNum, score) values (6, '202007010135', 60);

/*计科2班C语言考试*/
insert into score(esid,stuNum, score) values(7,'202007020101',73);
insert into score(esid,stuNum, score) values(7,'202007020102',83);
insert into score(esid,stuNum, score) values(7,'202007020103',90);
insert into score(esid,stuNum, score) values(7,'202007020104',91);
insert into score(esid,stuNum, score) values(7,'202007020105',60);
insert into score(esid,stuNum, score) values(7,'202007020106',68);
insert into score(esid,stuNum, score) values(7,'202007020107',70);
insert into score(esid,stuNum, score) values(7,'202007020108',84);
insert into score(esid,stuNum, score) values(7,'202007020109',87);
insert into score(esid,stuNum, score) values(7,'202007020110',43);
insert into score(esid,stuNum, score) values(7,'202007020111',94);
insert into score(esid,stuNum, score) values(7,'202007020112',78);
insert into score(esid,stuNum, score) values(7,'202007020113',81);
insert into score(esid,stuNum, score) values(7,'202007020114',84);
insert into score(esid,stuNum, score) values(7,'202007020115',79);
insert into score(esid,stuNum, score) values(7,'202007020116',65);
insert into score(esid,stuNum, score) values(7,'202007020117',64);
insert into score(esid,stuNum, score) values(7,'202007020118',59);
insert into score(esid,stuNum, score) values(7,'202007020119',72);
insert into score(esid,stuNum, score) values(7,'202007020120',89);
insert into score(esid,stuNum, score) values(7,'202007020121',88);
insert into score(esid,stuNum, score) values(7,'202007020122',66);
insert into score(esid,stuNum, score) values(7,'202007020123',71);
insert into score(esid,stuNum, score) values(7,'202007020124',84);
insert into score(esid,stuNum, score) values(7,'202007020125',90);
insert into score(esid,stuNum, score) values(7,'202007020126',58);
insert into score(esid,stuNum, score) values(7,'202007020127',87);
insert into score(esid,stuNum, score) values(7,'202007020128',65);
insert into score(esid,stuNum, score) values(7,'202007020129',83);
insert into score(esid,stuNum, score) values(7,'202007020130',90);
insert into score(esid,stuNum, score) values(7,'202007020131',91);
insert into score(esid,stuNum, score) values(7,'202007020132',79);
insert into score(esid,stuNum, score) values(7,'202007020133',76);
insert into score(esid,stuNum, score) values(7,'202007020134',95);
insert into score(esid,stuNum, score) values(7,'202007020135',33);

/*数科1班C语言考试*/
insert into score(esid, stuNum, score)  values(8, '202007030101' , 90);
insert into score(esid, stuNum, score)  values(8, '202007030102' , 98);
insert into score(esid, stuNum, score)  values(8, '202007030103' , 60);
insert into score(esid, stuNum, score)  values(8, '202007030104' , 84);
insert into score(esid, stuNum, score)  values(8, '202007030105' , 75);
insert into score(esid, stuNum, score)  values(8, '202007030106' , 65);
insert into score(esid, stuNum, score)  values(8, '202007030107' , 49);
insert into score(esid, stuNum, score)  values(8, '202007030108' , 79);
insert into score(esid, stuNum, score)  values(8, '202007030109' , 67);
insert into score(esid, stuNum, score)  values(8, '202007030110' , 84);
insert into score(esid, stuNum, score)  values(8, '202007030111' , 77);
insert into score(esid, stuNum, score)  values(8, '202007030112' , 63);
insert into score(esid, stuNum, score)  values(8, '202007030113' , 91);
insert into score(esid, stuNum, score)  values(8, '202007030114' , 89);
insert into score(esid, stuNum, score)  values(8, '202007030115' , 74);
insert into score(esid, stuNum, score)  values(8, '202007030116' , 71);
insert into score(esid, stuNum, score)  values(8, '202007030117' , 62);
insert into score(esid, stuNum, score)  values(8, '202007030118' , 83);
insert into score(esid, stuNum, score)  values(8, '202007030119' , 78);
insert into score(esid, stuNum, score)  values(8, '202007030120' , 94);
insert into score(esid, stuNum, score)  values(8, '202007030121' , 99);
insert into score(esid, stuNum, score)  values(8, '202007030122' , 38);
insert into score(esid, stuNum, score)  values(8, '202007030123' , 46);
insert into score(esid, stuNum, score)  values(8, '202007030124' , 55);
insert into score(esid, stuNum, score)  values(8, '202007030125' , 60);
insert into score(esid, stuNum, score)  values(8, '202007030126' , 49);
insert into score(esid, stuNum, score)  values(8, '202007030127' , 72);
insert into score(esid, stuNum, score)  values(8, '202007030128' , 79);
insert into score(esid, stuNum, score)  values(8, '202007030129' , 51);
insert into score(esid, stuNum, score)  values(8, '202007030130' , 65);
insert into score(esid, stuNum, score)  values(8, '202007030131' , 76);
insert into score(esid, stuNum, score)  values(8, '202007030132' , 64);
insert into score(esid, stuNum, score)  values(8, '202007030133' , 96);
insert into score(esid, stuNum, score)  values(8, '202007030134' , 83);
insert into score(esid, stuNum, score)  values(8, '202007030135' , 39);



/*数科2班C语言考试*/
insert into score(esid, stuNum, score) values (9, 202007020202, 66);
insert into score(esid, stuNum, score) values (9, 202007020203, 77);
insert into score(esid, stuNum, score) values (9, 202007020204, 90);
insert into score(esid, stuNum, score) values (9, 202007020205, 95);
insert into score(esid, stuNum, score) values (9, 202007020206, 45);
insert into score(esid, stuNum, score) values (9, 202007020207, 67);
insert into score(esid, stuNum, score) values (9, 202007020208, 26);
insert into score(esid, stuNum, score) values (9, 202007020209, 66);
insert into score(esid, stuNum, score) values (9, 202007020210, 75);
insert into score(esid, stuNum, score) values (9, 202007020211, 84);
insert into score(esid, stuNum, score) values (9, 202007020212, 57);
insert into score(esid, stuNum, score) values (9, 202007020213, 43);
insert into score(esid, stuNum, score) values (9, 202007020214, 80);
insert into score(esid, stuNum, score) values (9, 202007020215, 75);
insert into score(esid, stuNum, score) values (9, 202007020216, 78);
insert into score(esid, stuNum, score) values (9, 202007020217, 78);
insert into score(esid, stuNum, score) values (9, 202007020218, 73);
insert into score(esid, stuNum, score) values (9, 202007020219, 95);
insert into score(esid, stuNum, score) values (9, 202007020220, 98);
insert into score(esid, stuNum, score) values (9, 202007020221, 63);
insert into score(esid, stuNum, score) values (9, 202007020222, 26);
insert into score(esid, stuNum, score) values (9, 202007020223, 63);
insert into score(esid, stuNum, score) values (9, 202007020224, 63);
insert into score(esid, stuNum, score) values (9, 202007020225, 33);
insert into score(esid, stuNum, score) values (9, 202007020226, 53);
insert into score(esid, stuNum, score) values (9, 202007020227, 75);
insert into score(esid, stuNum, score) values (9, 202007020228, 77);
insert into score(esid, stuNum, score) values (9, 202007020229, 36);
insert into score(esid, stuNum, score) values (9, 202007020230, 0);
insert into score(esid, stuNum, score) values (9, 202007020231, 53);
insert into score(esid, stuNum, score) values (9, 202007020232, 75);
insert into score(esid, stuNum, score) values (9, 202007020233, 63);
insert into score(esid, stuNum, score) values (9, 202007020234, 99);

/*数科3班C语言考试*/
insert into score(esid, stuNum, score) values (10, 202007020301, 10);
insert into score(esid, stuNum, score) values (10, 202007020302, 55);
insert into score(esid, stuNum, score) values (10, 202007020303, 60);
insert into score(esid, stuNum, score) values (10, 202007020304, 65);
insert into score(esid, stuNum, score) values (10, 202007020305, 91);
insert into score(esid, stuNum, score) values (10, 202007020306, 85);
insert into score(esid, stuNum, score) values (10, 202007020307, 53);
insert into score(esid, stuNum, score) values (10, 202007020308, 67);
insert into score(esid, stuNum, score) values (10, 202007020309, 87);
insert into score(esid, stuNum, score) values (10, 202007020310, 84);
insert into score(esid, stuNum, score) values (10, 202007020311, 76);
insert into score(esid, stuNum, score) values (10, 202007020312, 55);
insert into score(esid, stuNum, score) values (10, 202007020313, 94);
insert into score(esid, stuNum, score) values (10, 202007020314, 93);
insert into score(esid, stuNum, score) values (10, 202007020315, 75);
insert into score(esid, stuNum, score) values (10, 202007020316, 77);
insert into score(esid, stuNum, score) values (10, 202007020317, 90);
insert into score(esid, stuNum, score) values (10, 202007020318, 67);
insert into score(esid, stuNum, score) values (10, 202007020319, 76);
insert into score(esid, stuNum, score) values (10, 202007020320, 81);
insert into score(esid, stuNum, score) values (10, 202007020321, 15);
insert into score(esid, stuNum, score) values (10, 202007020322, 98);
insert into score(esid, stuNum, score) values (10, 202007020323, 2);
insert into score(esid, stuNum, score) values (10, 202007020324, 71);
insert into score(esid, stuNum, score) values (10, 202007020325, 67);
insert into score(esid, stuNum, score) values (10, 202007020326, 95);
insert into score(esid, stuNum, score) values (10, 202007020327, 76);
insert into score(esid, stuNum, score) values (10, 202007020328, 70);
insert into score(esid, stuNum, score) values (10, 202007020329, 76);
/*通信1班C语言考试*/
/*/*-通信1班C语言考试*/
insert into score(esid, stuNum, score)values (11, 202007030201, 60);
insert into score(esid, stuNum, score)values (11, 202007030202, 89);
insert into score(esid, stuNum, score)values (11, 202007030203, 75);
insert into score(esid, stuNum, score)values (11, 202007030204, 66);
insert into score(esid, stuNum, score)values (11, 202007030205, 66);
insert into score(esid, stuNum, score)values (11, 202007030206, 78);
insert into score(esid, stuNum, score)values (11, 202007030207, 62);
insert into score(esid, stuNum, score)values (11, 202007030208, 60);
insert into score(esid, stuNum, score)values (11, 202007030209, 88);
insert into score(esid, stuNum, score)values (11, 202007030210, 90);
insert into score(esid, stuNum, score)values (11, 202007030211, 75);
insert into score(esid, stuNum, score)values (11, 202007030212, 69);
insert into score(esid, stuNum, score)values (11, 202007030213, 71);
insert into score(esid, stuNum, score)values (11, 202007030214, 82);
insert into score(esid, stuNum, score)values (11, 202007030215, 76);
insert into score(esid, stuNum, score)values (11, 202007030216, 67);
insert into score(esid, stuNum, score)values (11, 202007030217, 58);
insert into score(esid, stuNum, score)values (11, 202007030218, 64);
insert into score(esid, stuNum, score)values (11, 202007030219, 35);
insert into score(esid, stuNum, score)values (11, 202007030220, 77);
insert into score(esid, stuNum, score)values (11, 202007030221, 98);
insert into score(esid, stuNum, score)values (11, 202007030222, 100);
insert into score(esid, stuNum, score)values (11, 202007030223, 81);
insert into score(esid, stuNum, score)values (11, 202007030224, 63);
insert into score(esid, stuNum, score)values (11, 202007030225, 49);
insert into score(esid, stuNum, score)values (11, 202007030226, 57);
insert into score(esid, stuNum, score)values (11, 202007030227, 79);
insert into score(esid, stuNum, score)values (11, 202007030228, 86);
insert into score(esid, stuNum, score)values (11, 202007030229, 56);
insert into score(esid, stuNum, score)values (11, 202007030230, 99);

/*通信2班C语言考试*/
insert into score(esid,stuNum, score) values (12,'202007020401',68);
insert into score(esid,stuNum, score) values (12,'202007020402',73);
insert into score(esid,stuNum, score) values (12,'202007020403',72);
insert into score(esid,stuNum, score) values (12,'202007020404',77);
insert into score(esid,stuNum, score) values (12,'202007020405',90);
insert into score(esid,stuNum, score) values (12,'202007020406',83);
insert into score(esid,stuNum, score) values (12,'202007020407',88);
insert into score(esid,stuNum, score) values (12,'202007020408',99);
insert into score(esid,stuNum, score) values (12,'202007020409',30);
insert into score(esid,stuNum, score) values (12,'202007020410',59);
insert into score(esid,stuNum, score) values (12,'202007020411',66);
insert into score(esid,stuNum, score) values (12,'202007020412',53);
insert into score(esid,stuNum, score) values (12,'202007020413',57);
insert into score(esid,stuNum, score) values (12,'202007020414',60);
insert into score(esid,stuNum, score) values (12,'202007020415',73);
insert into score(esid,stuNum, score) values (12,'202007020416',78);
insert into score(esid,stuNum, score) values (12,'202007020417',89);
insert into score(esid,stuNum, score) values (12,'202007020418',79);
insert into score(esid,stuNum, score) values (12,'202007020419',69);
insert into score(esid,stuNum, score) values (12,'202007020420',56);
insert into score(esid,stuNum, score) values (12,'202007020421',66);
insert into score(esid,stuNum, score) values (12,'202007020422',95);
insert into score(esid,stuNum, score) values (12,'202007020423',92);
insert into score(esid,stuNum, score) values (12,'202007020424',59);
insert into score(esid,stuNum, score) values (12,'202007020425',60);
insert into score(esid,stuNum, score) values (12,'202007020426',76);
insert into score(esid,stuNum, score) values (12,'202007020427',86);
insert into score(esid,stuNum, score) values (12,'202007020428',66);
insert into score(esid,stuNum, score) values (12,'202007020429',60);
insert into score(esid,stuNum, score) values (12,'202007020430',94);
insert into score(esid,stuNum, score) values (12,'202007020431',93);
insert into score(esid,stuNum, score) values (12,'202007020432',91);
insert into score(esid,stuNum, score) values (12,'202007020433',29);
insert into score(esid,stuNum, score) values (12,'202007020434',45);
insert into score(esid,stuNum, score) values (12,'202007020435',88);

/*通信3班C语言考试*/
insert into score(esId, stuNum, score) values (13, '202007020501', 83);
insert into score(esId, stuNum, score) values (13, '202007020502', 94);
insert into score(esId, stuNum, score) values (13, '202007020503', 89);
insert into score(esId, stuNum, score) values (13, '202007020504', 65);
insert into score(esId, stuNum, score) values (13, '202007020505', 73);
insert into score(esId, stuNum, score) values (13, '202007020506', 67);
insert into score(esId, stuNum, score) values (13, '202007020507', 76);
insert into score(esId, stuNum, score) values (13, '202007020508', 99);
insert into score(esId, stuNum, score) values (13, '202007020509', 100);
insert into score(esId, stuNum, score) values (13, '202007020510', 61);
insert into score(esId, stuNum, score) values (13, '202007020511', 49);
insert into score(esId, stuNum, score) values (13, '202007020512', 77);
insert into score(esId, stuNum, score) values (13, '202007020513', 86);
insert into score(esId, stuNum, score) values (13, '202007020514', 69);
insert into score(esId, stuNum, score) values (13, '202007020515', 73);
insert into score(esId, stuNum, score) values (13, '202007020516', 45);
insert into score(esId, stuNum, score) values (13, '202007020517', 69);
insert into score(esId, stuNum, score) values (13, '202007020518', 78);
insert into score(esId, stuNum, score) values (13, '202007020519', 89);
insert into score(esId, stuNum, score) values (13, '202007020520', 66);
insert into score(esId, stuNum, score) values (13, '202007020521', 77);
insert into score(esId, stuNum, score) values (13, '202007020522', 81);
insert into score(esId, stuNum, score) values (13, '202007020523', 82);
insert into score(esId, stuNum, score) values (13, '202007020524', 83);
insert into score(esId, stuNum, score) values (13, '202007020525', 75);
insert into score(esId, stuNum, score) values (13, '202007020526', 68);
insert into score(esId, stuNum, score) values (13, '202007020527', 90);
insert into score(esId, stuNum, score) values (13, '202007020528', 83);
insert into score(esId, stuNum, score) values (13, '202007020529', 71);
insert into score(esId, stuNum, score) values (13, '202007020530', 72);
insert into score(esId, stuNum, score) values (13, '202007020531', 91);
insert into score(esId, stuNum, score) values (13, '202007020532', 69);
insert into score(esId, stuNum, score) values (13, '202007020533', 83);
insert into score(esId, stuNum, score) values (13, '202007020534', 88);
insert into score(esId, stuNum, score) values (13, '202007020535', 91);

/*通信4班C语言考试*/
insert into score(esid, stuNum, score) values(14, '202007020601',55);
insert into score(esid, stuNum, score) values(14, '202007020602',66);
insert into score(esid, stuNum, score) values(14, '202007020603',58);
insert into score(esid, stuNum, score) values(14, '202007020604',96);
insert into score(esid, stuNum, score) values(14, '202007020605',75);
insert into score(esid, stuNum, score) values(14, '202007020606',63);
insert into score(esid, stuNum, score) values(14, '202007020607',94);
insert into score(esid, stuNum, score) values(14, '202007020608',98);
insert into score(esid, stuNum, score) values(14, '202007020609',99);
insert into score(esid, stuNum, score) values(14, '202007020610',91);
insert into score(esid, stuNum, score) values(14, '202007020611',68);
insert into score(esid, stuNum, score) values(14, '202007020612',87);
insert into score(esid, stuNum, score) values(14, '202007020613',74);
insert into score(esid, stuNum, score) values(14, '202007020614',75);
insert into score(esid, stuNum, score) values(14, '202007020615',76);
insert into score(esid, stuNum, score) values(14, '202007020616',78);
insert into score(esid, stuNum, score) values(14, '202007020617',68);
insert into score(esid, stuNum, score) values(14, '202007020618',54);
insert into score(esid, stuNum, score) values(14, '202007020619',88);
insert into score(esid, stuNum, score) values(14, '202007020620',94);
insert into score(esid, stuNum, score) values(14, '202007020621',55);
insert into score(esid, stuNum, score) values(14, '202007020622',68);
insert into score(esid, stuNum, score) values(14, '202007020623',84);
insert into score(esid, stuNum, score) values(14, '202007020624',48);
insert into score(esid, stuNum, score) values(14, '202007020625',35);
insert into score(esid, stuNum, score) values(14, '202007020626',98);
insert into score(esid, stuNum, score) values(14, '202007020627',69);
insert into score(esid, stuNum, score) values(14, '202007020628',79);
insert into score(esid, stuNum, score) values(14, '202007020629',71);
insert into score(esid, stuNum, score) values(14, '202007020630',68);
insert into score(esid, stuNum, score) values(14, '202007020631',86);
insert into score(esid, stuNum, score) values(14, '202007020632',37);
insert into score(esid, stuNum, score) values(14, '202007020633',98);
insert into score(esid, stuNum, score) values(14, '202007020634',68);
insert into score(esid, stuNum, score) values(14, '202007020635',88);


/*通信5班C语言考试*/
/*通信5班C语言考试（22号缺考）*/
insert into score(esid, stuNum, score)values (15,'202007010201',56);
insert into score(esid, stuNum, score)values (15,'202007010202',59);
insert into score(esid, stuNum, score)values (15,'202007010203',71);
insert into score(esid, stuNum, score)values (15,'202007010204',79);
insert into score(esid, stuNum, score)values (15,'202007010205',79);
insert into score(esid, stuNum, score)values (15,'202007010206',88);
insert into score(esid, stuNum, score)values (15,'202007010207',84);
insert into score(esid, stuNum, score)values (15,'202007010208',74);
insert into score(esid, stuNum, score)values (15,'202007010209',75);
insert into score(esid, stuNum, score)values (15,'202007010210',98);
insert into score(esid, stuNum, score)values (15,'202007010211',95);
insert into score(esid, stuNum, score)values (15,'202007010212',90);
insert into score(esid, stuNum, score)values (15,'202007010213',91);
insert into score(esid, stuNum, score)values (15,'202007010214',83);
insert into score(esid, stuNum, score)values (15,'202007010215',61);
insert into score(esid, stuNum, score)values (15,'202007010216',60);
insert into score(esid, stuNum, score)values (15,'202007010217',65);
insert into score(esid, stuNum, score)values (15,'202007010218',74);
insert into score(esid, stuNum, score)values (15,'202007010219',75);
insert into score(esid, stuNum, score)values (15,'202007010220',83);
insert into score(esid, stuNum, score)values (15,'202007010221',84);
insert into score(esid, stuNum, score)values (15,'202007010222',0);
insert into score(esid, stuNum, score)values (15,'202007010223',96);
insert into score(esid, stuNum, score)values (15,'202007010224',79);
insert into score(esid, stuNum, score)values (15,'202007010225',89);
insert into score(esid, stuNum, score)values (15,'202007010226',85);
insert into score(esid, stuNum, score)values (15,'202007010227',42);
insert into score(esid, stuNum, score)values (15,'202007010228',35);
insert into score(esid, stuNum, score)values (15,'202007010229',77);
insert into score(esid, stuNum, score)values (15,'202007010230',71);
insert into score(esid, stuNum, score)values (15,'202007010231',70);
insert into score(esid, stuNum, score)values (15,'202007010232',78);
insert into score(esid, stuNum, score)values (15,'202007010233',81);
insert into score(esid, stuNum, score)values (15,'202007010234',85);
insert into score(esid, stuNum, score)values (15,'202007010235',93);

/*通信6班C语言考试*/
insert into score(esid,stuNum,score) values(16,'202007030301',78);
insert into score(esid,stuNum,score) values(16,'202007030302',88);
insert into score(esid,stuNum,score) values(16,'202007030303',65);
insert into score(esid,stuNum,score) values(16,'202007030304',43);
insert into score(esid,stuNum,score) values(16,'202007030305',98);
insert into score(esid,stuNum,score) values(16,'202007030306',73);
insert into score(esid,stuNum,score) values(16,'202007030307',79);
insert into score(esid,stuNum,score) values(16,'202007030308',68);
insert into score(esid,stuNum,score) values(16,'202007030309',58);
insert into score(esid,stuNum,score) values(16,'202007030310',100);
insert into score(esid,stuNum,score) values(16,'202007030311',32);
insert into score(esid,stuNum,score) values(16,'202007030312',98);
insert into score(esid,stuNum,score) values(16,'202007030313',80);
insert into score(esid,stuNum,score) values(16,'202007030314',70);
insert into score(esid,stuNum,score) values(16,'202007030315',75);
insert into score(esid,stuNum,score) values(16,'202007030316',76);
insert into score(esid,stuNum,score) values(16,'202007030317',82);
insert into score(esid,stuNum,score) values(16,'202007030318',86);
insert into score(esid,stuNum,score) values(16,'202007030319',81);
insert into score(esid,stuNum,score) values(16,'202007030320',79);
insert into score(esid,stuNum,score) values(16,'202007030321',91);
insert into score(esid,stuNum,score) values(16,'202007030322',79);
insert into score(esid,stuNum,score) values(16,'202007030323',73);
insert into score(esid,stuNum,score) values(16,'202007030324',80);
insert into score(esid,stuNum,score) values(16,'202007030325',90);
insert into score(esid,stuNum,score) values(16,'202007030326',77);
insert into score(esid,stuNum,score) values(16,'202007030327',88);
insert into score(esid,stuNum,score) values(16,'202007030328',66);
insert into score(esid,stuNum,score) values(16,'202007030329',59);
insert into score(esid,stuNum,score) values(16,'202007030330',45);
insert into score(esid,stuNum,score) values(16,'202007030331',56);
insert into score(esid,stuNum,score) values(16,'202007030333',78);
insert into score(esid,stuNum,score) values(16,'202007030334',97);

/*数科1班python考试*/
/*数科1班python考试成绩*/
insert into Score(esId, stuNum, score) values(17, 202007030101, 79);
insert into Score(esId, stuNum, score) values(17, 202007030102, 83);
insert into Score(esId, stuNum, score) values(17, 202007030103, 62);
insert into Score(esId, stuNum, score) values(17, 202007030104, 96);
insert into Score(esId, stuNum, score) values(17, 202007030105, 75);
insert into Score(esId, stuNum, score) values(17, 202007030106, 85);
insert into Score(esId, stuNum, score) values(17, 202007030107, 77);
insert into Score(esId, stuNum, score) values(17, 202007030108, 66);
insert into Score(esId, stuNum, score) values(17, 202007030109, 91);
insert into Score(esId, stuNum, score) values(17, 202007030110, 61);
insert into Score(esId, stuNum, score) values(17, 202007030111, 57);
insert into Score(esId, stuNum, score) values(17, 202007030112, 89);
insert into Score(esId, stuNum, score) values(17, 202007030113, 90);
insert into Score(esId, stuNum, score) values(17, 202007030114, 64);
insert into Score(esId, stuNum, score) values(17, 202007030115, 79);
insert into Score(esId, stuNum, score) values(17, 202007030116, 76);
insert into Score(esId, stuNum, score) values(17, 202007030117, 59);
insert into Score(esId, stuNum, score) values(17, 202007030118, 69);
insert into Score(esId, stuNum, score) values(17, 202007030119, 55);
insert into Score(esId, stuNum, score) values(17, 202007030120, 99);
insert into Score(esId, stuNum, score) values(17, 202007030121, 43);
insert into Score(esId, stuNum, score) values(17, 202007030122, 82);
insert into Score(esId, stuNum, score) values(17, 202007030123, 95);
insert into Score(esId, stuNum, score) values(17, 202007030124, 97);
insert into Score(esId, stuNum, score) values(17, 202007030125, 90);
insert into Score(esId, stuNum, score) values(17, 202007030126, 80);
insert into Score(esId, stuNum, score) values(17, 202007030127, 68);
insert into Score(esId, stuNum, score) values(17, 202007030128, 54);
insert into Score(esId, stuNum, score) values(17, 202007030129, 77);
insert into Score(esId, stuNum, score) values(17, 202007030130, 71);
insert into Score(esId, stuNum, score) values(17, 202007030131, 61);
insert into Score(esId, stuNum, score) values(17, 202007030132, 100);
insert into Score(esId, stuNum, score) values(17, 202007030133, 76);
insert into Score(esId, stuNum, score) values(17, 202007030134, 87);
insert into Score(esId, stuNum, score) values(17, 202007030135, 97);

/*数科2班python考试*/
insert into score(esId, stuNum, score) values (18, '202007020201', 90);
insert into score(esId, stuNum, score) values (18, '202007020202', 45);
insert into score(esId, stuNum, score) values (18, '202007020203', 68);
insert into score(esId, stuNum, score) values (18, '202007020204', 47);
insert into score(esId, stuNum, score) values (18, '202007020206', 86);
insert into score(esId, stuNum, score) values (18, '202007020207', 79);
insert into score(esId, stuNum, score) values (18, '202007020208', 99);
insert into score(esId, stuNum, score) values (18, '202007020209', 92);
insert into score(esId, stuNum, score) values (18, '202007020210', 45);
insert into score(esId, stuNum, score) values (18, '202007020211', 87);
insert into score(esId, stuNum, score) values (18, '202007020212', 67);
insert into score(esId, stuNum, score) values (18, '202007020213', 98);
insert into score(esId, stuNum, score) values (18, '202007020215', 73);
insert into score(esId, stuNum, score) values (18, '202007020216', 82);
insert into score(esId, stuNum, score) values (18, '202007020217', 62);
insert into score(esId, stuNum, score) values (18, '202007020218', 48);
insert into score(esId, stuNum, score) values (18, '202007020219', 81);
insert into score(esId, stuNum, score) values (18, '202007020220', 60);
insert into score(esId, stuNum, score) values (18, '202007020221', 55);
insert into score(esId, stuNum, score) values (18, '202007020222', 37);
insert into score(esId, stuNum, score) values (18, '202007020223', 68);
insert into score(esId, stuNum, score) values (18, '202007020224', 98);
insert into score(esId, stuNum, score) values (18, '202007020225', 99);
insert into score(esId, stuNum, score) values (18, '202007020226', 96);
insert into score(esId, stuNum, score) values (18, '202007020227', 95);
insert into score(esId, stuNum, score) values (18, '202007020228', 97);
insert into score(esId, stuNum, score) values (18, '202007020229', 76);
insert into score(esId, stuNum, score) values (18, '202007020230', 77);
insert into score(esId, stuNum, score) values (18, '202007020231', 88);
insert into score(esId, stuNum, score) values (18, '202007020232', 66);
insert into score(esId, stuNum, score) values (18, '202007020233', 65);
insert into score(esId, stuNum, score) values (18, '202007020234', 35);


/*数科3班python考试*/
Insert into score(esid,stuNum,score) values(19,'202007020301',67);
Insert into score(esid,stuNum,score) values(19,'202007020302',58);
Insert into score(esid,stuNum,score) values(19,'202007020303',96);
Insert into score(esid,stuNum,score) values(19,'202007020304',67);
Insert into score(esid,stuNum,score) values(19,'202007020305',65);
Insert into score(esid,stuNum,score) values(19,'202007020306',48);
Insert into score(esid,stuNum,score) values(19,'202007020307',96);
Insert into score(esid,stuNum,score) values(19,'202007020308',75);
Insert into score(esid,stuNum,score) values(19,'202007020309',85);
Insert into score(esid,stuNum,score) values(19,'202007020310',48);
Insert into score(esid,stuNum,score) values(19,'202007020311',53);
Insert into score(esid,stuNum,score) values(19,'202007020312',37);
Insert into score(esid,stuNum,score) values(19,'202007020313',68);
Insert into score(esid,stuNum,score) values(19,'202007020314',63);
Insert into score(esid,stuNum,score) values(19,'202007020315',93);
Insert into score(esid,stuNum,score) values(19,'202007020316',27);
Insert into score(esid,stuNum,score) values(19,'202007020317',100);
Insert into score(esid,stuNum,score) values(19,'202007020318',45);
Insert into score(esid,stuNum,score) values(19,'202007020319',73);
Insert into score(esid,stuNum,score) values(19,'202007020320',28);
Insert into score(esid,stuNum,score) values(19,'202007020321',84);
Insert into score(esid,stuNum,score) values(19,'202007020322',91);
Insert into score(esid,stuNum,score) values(19,'202007020323',82);
Insert into score(esid,stuNum,score) values(19,'202007020324',23);
Insert into score(esid,stuNum,score) values(19,'202007020325',97);
Insert into score(esid,stuNum,score) values(19,'202007020326',95);
Insert into score(esid,stuNum,score) values(19,'202007020327',51);
Insert into score(esid,stuNum,score) values(19,'202007020328',67);
Insert into score(esid,stuNum,score) values(19,'202007020329',77);

/*/*-通信1班通信原理考试*/
insert into score(esid, stuNum, score)values (20, 202007030201, 99);
insert into score(esid, stuNum, score)values (20, 202007030202, 89);
insert into score(esid, stuNum, score)values (20, 202007030203, 77);
insert into score(esid, stuNum, score)values (20, 202007030204, 68);
insert into score(esid, stuNum, score)values (20, 202007030205, 69);
insert into score(esid, stuNum, score)values (20, 202007030206, 98);
insert into score(esid, stuNum, score)values (20, 202007030207, 60);
insert into score(esid, stuNum, score)values (20, 202007030208, 61);
insert into score(esid, stuNum, score)values (20, 202007030209, 8);
insert into score(esid, stuNum, score)values (20, 202007030210, 61);
insert into score(esid, stuNum, score)values (20, 202007030211, 35);
insert into score(esid, stuNum, score)values (20, 202007030212, 75);
insert into score(esid, stuNum, score)values (20, 202007030213, 74);
insert into score(esid, stuNum, score)values (20, 202007030214, 88);
insert into score(esid, stuNum, score)values (20, 202007030215, 75);
insert into score(esid, stuNum, score)values (20, 202007030216, 45);
insert into score(esid, stuNum, score)values (20, 202007030217, 58);
insert into score(esid, stuNum, score)values (20, 202007030218, 49);
insert into score(esid, stuNum, score)values (20, 202007030219, 36);
insert into score(esid, stuNum, score)values (20, 202007030220, 77);
insert into score(esid, stuNum, score)values (20, 202007030221, 97);
insert into score(esid, stuNum, score)values (20, 202007030222, 100);
insert into score(esid, stuNum, score)values (20, 202007030223, 81);
insert into score(esid, stuNum, score)values (20, 202007030224, 69);
insert into score(esid, stuNum, score)values (20, 202007030225, 49);
insert into score(esid, stuNum, score)values (20, 202007030226, 57);
insert into score(esid, stuNum, score)values (20, 202007030227, 89);
insert into score(esid, stuNum, score)values (20, 202007030228, 86);
insert into score(esid, stuNum, score)values (20, 202007030229, 56);
insert into score(esid, stuNum, score)values (20, 202007030230, 56);
insert into score(esid, stuNum, score)values (20, 202007030231, 52);
insert into score(esid, stuNum, score)values (20, 202007030232, 94);
insert into score(esid, stuNum, score)values (20, 202007030233, 63);
insert into score(esid, stuNum, score)values (20, 202007030234, 56);
/*通信二*/
insert into score(esid,stuNum,score) values (21,'202007020401',88);
insert into score(esid,stuNum,score) values (21,'202007020402',45);
insert into score(esid,stuNum,score) values (21,'202007020403',66);
insert into score(esid,stuNum,score) values (21,'202007020404',60);
insert into score(esid,stuNum,score) values (21,'202007020405',89);
insert into score(esid,stuNum,score) values (21,'202007020406',78);
insert into score(esid,stuNum,score) values (21,'202007020407',88);
insert into score(esid,stuNum,score) values (21,'202007020408',68);
insert into score(esid,stuNum,score) values (21,'202007020409',90);
insert into score(esid,stuNum,score) values (21,'202007020410',60);
insert into score(esid,stuNum,score) values (21,'202007020411',59);
insert into score(esid,stuNum,score) values (21,'202007020412',81);
insert into score(esid,stuNum,score) values (21,'202007020413',62);
insert into score(esid,stuNum,score) values (21,'202007020414',65);
insert into score(esid,stuNum,score) values (21,'202007020415',87);
insert into score(esid,stuNum,score) values (21,'202007020416',59);
insert into score(esid,stuNum,score) values (21,'202007020417',77);
insert into score(esid,stuNum,score) values (21,'202007020418',87);
insert into score(esid,stuNum,score) values (21,'202007020419',60);
insert into score(esid,stuNum,score) values (21,'202007020420',60);
insert into score(esid,stuNum,score) values (21,'202007020421',73);
insert into score(esid,stuNum,score) values (21,'202007020422',67);
insert into score(esid,stuNum,score) values (21,'202007020423',88);
insert into score(esid,stuNum,score) values (21,'202007020424',76);
insert into score(esid,stuNum,score) values (21,'202007020425',47);
insert into score(esid,stuNum,score) values (21,'202007020426',78);
insert into score(esid,stuNum,score) values (21,'202007020427',54);
insert into score(esid,stuNum,score) values (21,'202007020428',66);
insert into score(esid,stuNum,score) values (21,'202007020429',76);
insert into score(esid,stuNum,score) values (21,'202007020430',99);
insert into score(esid,stuNum,score) values (21,'202007020431',77);
insert into score(esid,stuNum,score) values (21,'202007020432',67);
insert into score(esid,stuNum,score) values (21,'202007020433',69);
insert into score(esid,stuNum,score) values (21,'202007020434',88);
insert into score(esid,stuNum,score) values (21,'202007020435',67);

/*通信3班通信原理考试*/
insert into score(esId, stuNum, score) values (22, '202007020501', 76);
insert into score(esId, stuNum, score) values (22, '202007020502', 91);
insert into score(esId, stuNum, score) values (22, '202007020503', 82);
insert into score(esId, stuNum, score) values (22, '202007020504', 58);
insert into score(esId, stuNum, score) values (22, '202007020505', 76);
insert into score(esId, stuNum, score) values (22, '202007020506', 69);
insert into score(esId, stuNum, score) values (22, '202007020507', 76);
insert into score(esId, stuNum, score) values (22, '202007020508', 80);
insert into score(esId, stuNum, score) values (22, '202007020509', 90);
insert into score(esId, stuNum, score) values (22, '202007020510', 71);
insert into score(esId, stuNum, score) values (22, '202007020511', 64);
insert into score(esId, stuNum, score) values (22, '202007020512', 83);
insert into score(esId, stuNum, score) values (22, '202007020513', 67);
insert into score(esId, stuNum, score) values (22, '202007020514', 79);
insert into score(esId, stuNum, score) values (22, '202007020515', 82);
insert into score(esId, stuNum, score) values (22, '202007020516', 71);
insert into score(esId, stuNum, score) values (22, '202007020517', 70);
insert into score(esId, stuNum, score) values (22, '202007020518', 87);
insert into score(esId, stuNum, score) values (22, '202007020519', 78);
insert into score(esId, stuNum, score) values (22, '202007020520', 71);
insert into score(esId, stuNum, score) values (22, '202007020521', 82);
insert into score(esId, stuNum, score) values (22, '202007020522', 91);
insert into score(esId, stuNum, score) values (22, '202007020523', 56);
insert into score(esId, stuNum, score) values (22, '202007020524', 79);
insert into score(esId, stuNum, score) values (22, '202007020525', 85);
insert into score(esId, stuNum, score) values (22, '202007020526', 69);
insert into score(esId, stuNum, score) values (22, '202007020527', 91);
insert into score(esId, stuNum, score) values (22, '202007020528', 92);
insert into score(esId, stuNum, score) values (22, '202007020529', 56);
insert into score(esId, stuNum, score) values (22, '202007020530', 72);
insert into score(esId, stuNum, score) values (22, '202007020531', 51);
insert into score(esId, stuNum, score) values (22, '202007020532', 62);
insert into score(esId, stuNum, score) values (22, '202007020533', 85);
insert into score(esId, stuNum, score) values (22, '202007020534', 91);
insert into score(esId, stuNum, score) values (22, '202007020535', 83);


/*通信4班通讯原理考试*/
insert into score(esid, stuNum, score) values(23, '202007020601',57);
insert into score(esid, stuNum, score) values(23, '202007020602',65);
insert into score(esid, stuNum, score) values(23, '202007020603',54);
insert into score(esid, stuNum, score) values(23, '202007020604',96);
insert into score(esid, stuNum, score) values(23, '202007020605',71);
insert into score(esid, stuNum, score) values(23, '202007020606',68);
insert into score(esid, stuNum, score) values(23, '202007020607',94);
insert into score(esid, stuNum, score) values(23, '202007020608',98);
insert into score(esid, stuNum, score) values(23, '202007020609',99);
insert into score(esid, stuNum, score) values(23, '202007020610',91);
insert into score(esid, stuNum, score) values(23, '202007020611',68);
insert into score(esid, stuNum, score) values(23, '202007020612',87);
insert into score(esid, stuNum, score) values(23, '202007020613',65);
insert into score(esid, stuNum, score) values(23, '202007020614',78);
insert into score(esid, stuNum, score) values(23, '202007020615',76);
insert into score(esid, stuNum, score) values(23, '202007020616',85);
insert into score(esid, stuNum, score) values(23, '202007020617',68);
insert into score(esid, stuNum, score) values(23, '202007020618',66);
insert into score(esid, stuNum, score) values(23, '202007020619',88);
insert into score(esid, stuNum, score) values(23, '202007020620',98);
insert into score(esid, stuNum, score) values(23, '202007020621',55);
insert into score(esid, stuNum, score) values(23, '202007020622',68);
insert into score(esid, stuNum, score) values(23, '202007020623',84);
insert into score(esid, stuNum, score) values(23, '202007020624',48);
insert into score(esid, stuNum, score) values(23, '202007020625',38);
insert into score(esid, stuNum, score) values(23, '202007020626',95);
insert into score(esid, stuNum, score) values(23, '202007020627',67);
insert into score(esid, stuNum, score) values(23, '202007020628',76);
insert into score(esid, stuNum, score) values(23, '202007020629',78);
insert into score(esid, stuNum, score) values(23, '202007020630',64);
insert into score(esid, stuNum, score) values(23, '202007020631',83);
insert into score(esid, stuNum, score) values(23, '202007020632',37);
insert into score(esid, stuNum, score) values(23, '202007020633',94);
insert into score(esid, stuNum, score) values(23, '202007020634',66);
insert into score(esid, stuNum, score) values(23, '202007020635',82);


/*通信5班通讯原理考试（22 23号缺考）*/
insert into score(esid, stuNum, score)values (24,'202007010201',56);
insert into score(esid, stuNum, score)values (24,'202007010202',59);
insert into score(esid, stuNum, score)values (24,'202007010203',70);
insert into score(esid, stuNum, score)values (24,'202007010204',79);
insert into score(esid, stuNum, score)values (24,'202007010205',73);
insert into score(esid, stuNum, score)values (24,'202007010206',88);
insert into score(esid, stuNum, score)values (24,'202007010207',84);
insert into score(esid, stuNum, score)values (24,'202007010208',74);
insert into score(esid, stuNum, score)values (24,'202007010209',77);
insert into score(esid, stuNum, score)values (24,'202007010210',98);
insert into score(esid, stuNum, score)values (24,'202007010211',90);
insert into score(esid, stuNum, score)values (24,'202007010212',91);
insert into score(esid, stuNum, score)values (24,'202007010213',91);
insert into score(esid, stuNum, score)values (24,'202007010214',83);
insert into score(esid, stuNum, score)values (24,'202007010215',61);
insert into score(esid, stuNum, score)values (24,'202007010216',77);
insert into score(esid, stuNum, score)values (24,'202007010217',65);
insert into score(esid, stuNum, score)values (24,'202007010218',74);
insert into score(esid, stuNum, score)values (24,'202007010219',75);
insert into score(esid, stuNum, score)values (24,'202007010220',83);
insert into score(esid, stuNum, score)values (24,'202007010221',84);
insert into score(esid, stuNum, score)values (24,'202007010222',0);
insert into score(esid, stuNum, score)values (24,'202007010223',0);
insert into score(esid, stuNum, score)values (24,'202007010224',79);
insert into score(esid, stuNum, score)values (24,'202007010225',89);
insert into score(esid, stuNum, score)values (24,'202007010226',85);
insert into score(esid, stuNum, score)values (24,'202007010227',42);
insert into score(esid, stuNum, score)values (24,'202007010228',35);
insert into score(esid, stuNum, score)values (24,'202007010229',77);
insert into score(esid, stuNum, score)values (24,'202007010230',71);
insert into score(esid, stuNum, score)values (24,'202007010231',77);
insert into score(esid, stuNum, score)values (24,'202007010232',72);
insert into score(esid, stuNum, score)values (24,'202007010233',88);
insert into score(esid, stuNum, score)values (24,'202007010234',84);
insert into score(esid, stuNum, score)values (24,'202007010235',93);

insert into score(esid,stuNum,score) values(25,'202007030301',68);
insert into score(esid,stuNum,score) values(25,'202007030302',88);
insert into score(esid,stuNum,score) values(25,'202007030303',55);
insert into score(esid,stuNum,score) values(25,'202007030304',43);
insert into score(esid,stuNum,score) values(25,'202007030305',98);
insert into score(esid,stuNum,score) values(25,'202007030306',73);
insert into score(esid,stuNum,score) values(25,'202007030307',79);
insert into score(esid,stuNum,score) values(25,'202007030308',68);
insert into score(esid,stuNum,score) values(25,'202007030309',88);
insert into score(esid,stuNum,score) values(25,'202007030310',95);
insert into score(esid,stuNum,score) values(25,'202007030311',92);
insert into score(esid,stuNum,score) values(25,'202007030312',98);
insert into score(esid,stuNum,score) values(25,'202007030313',80);
insert into score(esid,stuNum,score) values(25,'202007030314',40);
insert into score(esid,stuNum,score) values(25,'202007030315',75);
insert into score(esid,stuNum,score) values(25,'202007030316',76);
insert into score(esid,stuNum,score) values(25,'202007030317',62);
insert into score(esid,stuNum,score) values(25,'202007030318',86);
insert into score(esid,stuNum,score) values(25,'202007030319',81);
insert into score(esid,stuNum,score) values(25,'202007030320',79);
insert into score(esid,stuNum,score) values(25,'202007030321',81);
insert into score(esid,stuNum,score) values(25,'202007030322',79);
insert into score(esid,stuNum,score) values(25,'202007030323',73);
insert into score(esid,stuNum,score) values(25,'202007030324',70);
insert into score(esid,stuNum,score) values(25,'202007030325',90);
insert into score(esid,stuNum,score) values(25,'202007030326',77);
insert into score(esid,stuNum,score) values(25,'202007030327',88);
insert into score(esid,stuNum,score) values(25,'202007030328',66);
insert into score(esid,stuNum,score) values(25,'202007030329',59);
insert into score(esid,stuNum,score) values(25,'202007030330',45);
insert into score(esid,stuNum,score) values(25,'202007030331',36);
insert into score(esid,stuNum,score) values(25,'202007030333',78);
insert into score(esid,stuNum,score) values(25,'202007030334',77);

select * from teacher;
select * from classinfo;
select * from student;
select * from restPwd;
select * from lesson;
select * from coursearrangement;
select * from examschedule;
select * from score;