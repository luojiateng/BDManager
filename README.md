> Java、Mysql、JavaGUI、Swing

项目运行前检查：

Jdk 1.8

Mysql 5.7（版本8可以使用）

在项目的中我新建一个lib文件夹，里面是连接数据库的jar包，检查是否加载成功

​                               

拿到项目运行时如果出现乱码，更改Idea或者eclipse的编码集为UTF-8，我是拿Idea写的。

 

使用方式：运行SQL文件，建库建表

更改代码util包下的DBconnect中的密码，我的数据库密码是abc123，将密码改为你的密码，根据实际情况进行修改你的库

找到启动类Begin Or Start这个类，右键屏幕运行，如果数据加载不出来，可能是你数据库的编码集问题

 

 
