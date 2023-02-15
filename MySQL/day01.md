### SQL分类

DDL: 数据定义语言, 包括数据库相关和表相关的一些SQL语句

DML: 数据操作语言, 包括数据的增删改查相关SQL

DQL: 数据查询语言, 只包含和查询相关的SQL

TCL: 事务控制语言 

DCL: 数据控制语言,包含用户创建以及权限分配相关的SQL语句 

### DDL(数据库相关)

- 创建数据库  CREATE DATABASE 数据库名 CHARSET=utf8/gbk;
- 查询所有数据库 SHOW DATABASES;     
- 删除数据库 DROP DATABASE 数据库名;
- 查看数据库信息 SHOW CREATE DATABASE 数据库名;
- 使用数据库  USE 数据库名;

练习:

1. 创建mydb1和mydb2数据库 字符集分别为utf8 和 gbk
   
   CREATE DATABASE mydb1 CHARSET=utf8;
   
   CREATE DATABASE mydb2 CHARSET=gbk;

2. 查询所有数据库 检查是否创建成功
   
   SHOW DATABASES;

3. 查看两个数据库的字符集信息
   
   SHOW CREATE DATABASE mydb1;
   
   SHOW CREATE DATABASE mydb2;

4. 先使用mydb2 再使用mydb1
   
   USE mydb2;
   
   USE mydb1;

5. 删除两个数据库

​        DROP DATABASE mydb1;

​        DROP DATABASE mydb2;

### DDL(表相关SQL)

- 执行表相关的SQL语句之前必须使用了某个数据库否则报错

- 创建表 CREATE TABLE 表名(字段1名 类型,字段2名 类型)CHARSET=utf8/gbk;

- 查询所有表  SHOW TABLES;

- 查看表信息 SHOW CREATE TABLE 表名;

- 删除表   DROP TABLE 表名;

- 修改表名 RENAME TABLE 原名 TO 新名;

- 添加表字段 ALTER TABLE 表名 ADD 字段名 类型 FIRST/AFTER XXX;  

- 删除表字段 ALTER TABLE 表名 DROP 字段名;

- 修改表字段 ALTER TABLE 表名 CHANGE 原名 新名 新类型;

​            ALTER TABLE t1 CHANGE name age int;  

- 查看表字段  DESC 表名;

练习:

```mysql
1. 创建数据库mydb4 字符集utf8并使用
CREATE DATABASE mydb4 CHARSET=utf8;
USE mydb4;
2. 创建teacher表 字段:名字name    字符集utf8
CREATE TABLE teacher(name VARCHAR(20));
3. 添加表字段:  最后面添加age   最前面添加id  age前面添加工资salary
ALTER TABLE teacher ADD age int;
ALTER TABLE teacher ADD id int FIRST;
ALTER TABLE teacher ADD salary int AFTER name; 
4. 删除age字段    ALTER TABLE teacher DROP age;
5. 修改表名为t    RENAME TABLE teacher TO t;
6. 修改salary字段为工作job字段 ALTER TABLE t CHANGE salary job varchar(20);
7. 删除表 DROP TABLE t;
8. 删除数据库 DROP DATABASE mydb4;
```

https://gitee.com/IvanLiuGB/2210jsd03-t.git

### DML(数据相关SQL)

- 增  INSERT INTO 表名(字段1名,字段2名,字段3名) VALUES(值1,值2,值3);
- 删 DELETE FROM 表名 WHERE 条件; 
- 改 UPDATE 表名 SET 字段1名=值,字段2名=值 WHERE 条件;
- 查 SELECT 字段名  FROM 表名 WHERE 条件;

练习: 

1. ```mysql
   1. 创建数据mydb5 字符集utf8,并使用
   CREATE DATABASE mydb5 CHARSET=utf8;
   USE mydb5;
   2. 在数据库中创建员工表emp 字段:id,name,sal(工资),deptId(部门id) 
   CREATE TABLE emp(id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(30),sal INT,deptId INT);
   3. 创建部门表dept 字段:id,name,loc(部门地址) 
   CREATE TABLE dept(id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),loc VARCHAR(20));
   4. 部门表插入以下数据: 1 神仙部 天庭 2 妖怪部 盘丝洞 
   INSERT INTO dept VALUES(NULL,'神仙部','天庭'),(NULL,'妖怪部','盘丝洞');
   5. 员工表插入一下数据: 1 悟空 5000 1 , 2 八戒 2000 1 ,3 蜘蛛精 8000 2 , 4 白骨精 9000 2
   INSERT INTO emp VALUES(NULL,'悟空',5000,1),(NULL,'八戒',2000,1),(NULL,'蜘蛛精',8000,2),(NULL,'白骨精',9000,2);
   6. 查询工资6000以下的员工姓名和工资
   SELECT name,sal FROM emp WHERE sal<6000;
   7. 修改神仙部的名字为取经部
   UPDATE dept SET name='取经部' WHERE name='神仙部';
   8.  给员工表添加奖金comm字段
   ALTER TABLE emp ADD comm INT;
   9. 修改员工表中部门id为1的奖金为500
   UPDATE emp SET comm=500 WHERE deptId=1;
   10. 把取经部的地址改成五台山 
   UPDATE dept SET loc='五台山' WHERE name='取经部';
   11. 修改奖金字段为性别gender字段 类型为varchar(5)  ,修改孙悟空和猪八戒性别为男
   ALTER TABLE emp CHANGE comm gender varchar(5);
   UPDATE emp SET gender='男' WHERE id<3;
   12. 删除没有性别的员工
   DELETE FROM emp WHERE gender is NULL;
   ```

### 导入*.sql批处理文件

- 从老师工程里面得到emp.zip 压缩包 然后将其解压到某个盘的根目录下面

- 打开开始菜单中的MySQL/MariaDB里面的MySQL Client  , 然后输入密码 回车建立连接

- 在终端中执行以下指令,  执行完之后  再执行show tables;  如果显示emp和dept说明导入成功 
  
     source 路径     

### AND     OR     NOT

1. 查询1号部门工资高于2000的员工信息
   
   SELECT * FROM emp WHERE dept_id=1 AND sal>2000;

2. 查询3号部门员工或者工作是销售的员工
   
   SELECT * FROM emp WHERE dept_id=3 OR job='销售';

3. 查询有上级领导的员工信息
   
   SELECT * FROM emp WHERE manager IS NOT NULL;

### BETWEEN X AND Y   在两者之间

1. 查询工资在2000-3000之间的员工信息
   
   SELECT * FROM emp WHERE sal>=2000 AND sal<=3000;
   
   SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;
   
   通过NOT实现两者之外
   
   SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000;

### IN

- 当查询某个字段的数据为多个值的时候使用 
1. 查询工资为1500,3000和5000的员工信息
   
   SELECT * FROM emp WHERE sal=1500 OR sal=3000 OR sal=5000;
   
   SELECT * FROM emp WHERE sal IN(1500,3000,5000);

### 模糊查询 LIKE

- %: 代表0或多个未知字符

- _:代表1个未知字符

- 举例:
  - 以x开头       x%
  - 以x结尾       %x
  - 包含x           %x%
  - 以x开头以y结尾     x%y
  - 第二个字符是x              _x%
  - 倒数第三个是y              %y__
1. 查询姓孙的员工信息
   
   SELECT * FROM emp WHERE name LIKE  '孙%';

2. 查询名字中包含僧的员工信息
   
   SELECT * FROM emp WHERE name LIKE '%僧%';

3. 查询名字以精结尾的员工姓名
   
   SELECT * FROM emp WHERE name LIKE '%精';

4. 查询工作中包含销售并且工资大于1500的员工信息
   
   SELECT * FROM emp WHERE job LIKE '%销售%' AND sal>1500;

5. 查询工作中第二个字是售的员工姓名和工作
   
   SELECT name,job FROM emp WHERE job LIKE '_售%';

6. 查询1号和2号部门中工作以市开头的员工信息
   
   SELECT * FROM emp WHERE dept_id in(1,2) AND job LIKE '市%';

### 去重 distinct

1. 查询1号部门中出现了哪几种不同的工作
   
   SELECT DISTINCT job FROM emp WHERE dept_id=1;

2. 查询员工表中出现了几种不同的部门id
   
   SELECT DISTINCT dept_id FROM emp;

### 综合练习题

- 查询2号部门工资高于1000的员工信息
  
  SELECT * FROM emp WHERE dept_id=2 AND sal>1000;

- 查询3号部门或工资等于5000的员工信息
  
  SELECT * FROM emp WHERE dept_id=3 OR sal=5000;

- 查询工资在1000到2000之间的员工姓名和工资
  
  SELECT name,sal FROM emp WHERE sal BETWEEN 1000 AND 2000;

- 查询工资不等于3000和5000的员工信息
  
  SELECT * FROM emp sal NOT IN(3000,5000);

- 查询3号部门有哪几种不同的工作
  
  SELECT DISTINCT job FROM emp WHERE dept_id=3;

- 查询1号部门没有领导的员工姓名
  
  SELECT name FROM emp WHERE dept_id=1 AND manager IS NULL;

- 查询出所有销售,人事和程序员
  
  SELECT * FROM emp WHERE job IN('销售','人事','程序员');

- 查询出刘关张三个人的工资
  
  SELECT sal FROM emp WHERE name in('刘备','关羽','张飞');

### 排序 ORDER BY

- ORDER BY 排序的字段名  ASC(升序,默认值)/DESC降序
1. 查询所有员工的姓名和工资,按照工资升序排序
   
   SELECT name,sal FROM emp ORDER BY sal;

2. 查询所有员工的姓名和工资,按照工资降序排序
   
   SELECT name,sal FROM emp ORDER BY sal DESC;

3. 查询工资高于2000的员工姓名和工资, 按照工资降序排序

​        SELECT name,sal FROM emp WHERE sal>2000 ORDER BY sal DESC;

4. 查询所有员工的姓名,工资和部门id 按照部门id升序排序,如果部门id一致则按照工资降序排序(多字段排序)
   
   SELECT name,sal,dept_id FROM emp ORDER BY dept_id,sal DESC;

### 分页查询 LIMIT

- LIMIT 跳过的条数((请求的页数-1)*每页条数),请求的条数(每页的条数)

- 举例:
  
  - 第1页的5条数据           0,5
  - 第2页的5条数据           5,5   
  - 第8页的5条数据           35,5
  - 第9页的7条数据           56,7
1. 查询id,姓名,工资和工作,按照工资升序排序 请求第1页的5条数据
   
   SELECT id,name,sal,job FROM emp ORDER BY sal LIMIT 0,5;

2. 查询所有员工的姓名和工资,按照工资升序排序,请求第2页的5条数据
   
   SELECT name,sal FROM emp ORDER BY sal LIMIT 5,5;

3. 查询工资最高的员工信息
   
   SELECT * FROM emp ORDER BY sal DESC LIMIT 0,1;

4. 按照入职日期排序 查询第2页的3条数据
   
   SELECT * FROM emp ORDER BY hiredate LIMIT 3,3;

5. 按照工资升序排序查询第3页的2条数据
   
   SELECT * FROM emp ORDER BY sal LIMIT 4,2;

### 别名

SELECT name AS '姓名' FROM emp;

SELECT name '姓名' FROM emp;

SELECT name 姓名 FROM emp;

### 综合练习题

1. 查询员工表中 3 号部门工资高于 1500 的员工信息
   
   SELECT * FROM emp WHERE dept_id=3 AND sal>1500;

2. 查询 2 号部门员工或者没有领导的员工信息
   
   SELECT * FROM emp WHERE dept_id=2 OR manager IS NULL;

3. 查询有领导的员工姓名,工资按照工资降序排序
   
   SELECT * FROM emp WHERE manager IS NOT NULL ORDER BY sal DESC;

4. 查询 2 号和 3 号部门的员工姓名和入职日期 hiredate 按照入职日期降序排序
   
   SELECT name,hiredate FROM emp WHERE dept_id IN(2,3) ORDER BY hiredate DESC;

5. 查询名字中包含僧和包含精的员工姓名
   
   SELECT * FROM emp WHERE name LIKE '%僧%' or name LIKE '%精%';

6. 查询工资高于 2000 的工作有哪几种?
   
   SELECT DISTINCT job FROM emp WHERE sal>2000;

7. 查询工资升序第 4 页的 2 条数据
   
   SELECT * FROM emp ORDER BY sal LIMIT 6,2;

### 聚合函数

- 可以对查询的多条数据进行统计查询,  包括: 平均值,最大值,最小值,求和,计数

- 平均值AVG(字段名)
  
  - 查询1号部门的平均工资
    
    SELECT AVG(sal) FROM emp WHERE dept_id=1;

- 最大值MAX(字段名)
  
  - 查询2号部门的最高工资
    
    SELECT MAX(sal) FROM emp WHERE dept_id=2;

- 最小值MIN(字段名)
  
  - 查询2号部门的最低工资
    
    SELECT MIN(sal) FROM emp WHERE dept_id=2;

- 求和SUM(字段名)
  
  - 查询程序员的工资总和
    
    SELECT SUM(sal) FROM emp WHERE job='程序员';

- 计数COUNT(*)
  
  - 查询销售的人数
    
    SELECT COUNT(*) FROM emp WHERE job='销售';

### 聚合函数练习题:

1. 查询销售的平均工资
   
   SELECT AVG(sal) FROM emp WHERE job='销售';

2. 查询程序员的最高工资
   
   SELECT MAX(sal) FROM emp WHERE job='程序员';

3. 查询名字中包含精的人数
   
   SELECT COUNT(*) FROM emp WHERE name LIKE '%精%';

4. 查询和销售相关的工作,工资总和是多少  
   
   SELECT SUM(sal) FROM emp WHERE job LIKE '%销售%';

5. 查询2号部门的最高工资和 最低工资 起别名
   
   SELECT MAX(sal) 最高工资,MIN(sal) 最低工资 FROM emp WHERE dept_id=2;

### 分组查询 GROUP BY

- 分组查询可以将某个字段相同值的数据划分为一组, 然后以组为单位进行统计查询  
1. 查询每个部门的平均工资
   
   SELECT dept_id,AVG(sal) FROM emp GROUP BY dept_id;

2. 查询每个部门的人数
   
   SELECT dept_id,COUNT(*) FROM emp GROUP BY dept_id;

3. 查询每种工作的人数
   
   SELECT job,COUNT(*) FROM emp GROUP BY job;

4. 查询每个部门工资高于 2000 的人数
   
   SELECT dept_id,COUNT(*) FROM emp WHERE sal>2000 GROUP BY dept_id;

5. 查询 1 号部门和 2 号部门的人数
   
   SELECT dept_id,COUNT(*) FROM emp WHERE dept_id IN(1,2) GROUP BY dept_id;

6. 查询平均工资最高的部门 id 和平均工资
   
   SELECT dept_id,AVG(sal) FROM emp GROUP BY dept_id ORDER BY AVG(sal) DESC LIMIT 0,1;

​       SELECT dept_id,AVG(sal) a FROM emp GROUP BY dept_id ORDER BY a DESC LIMIT 0,1;

```
### 练习题
1. 查询不是程序员的员工姓名和工作
SELECT NAME, job FROM emp WHERE job NOT IN("程序员");
2. 查询奖金等于 300 的员工姓名,工资和工作
SELECT NAME, sal, job FROM emp WHERE comm=300;
3. 查询 1 号部门工资大于 2000 的员工信息
SELECT * FROM emp WHERE dept_id=1 AND sal>2000;
4. 查询 3 号部门或工资等于 5000 的员工信息
SELECT * FROM emp WHERE dept_id=3 OR sal=5000;
5. 查询出 CEO 和项目经理的名字
SELECT NAME FROM emp WHERE job IN("CEO", "项目经理");
6. 查询工资为 3000,1500 和 5000 的员工信息
SELECT * FROM emp WHERE sal IN(3000, 1500, 5000);
7. 查询工资不等于 3000,1500 和 5000 的员工信息
SELECT * FROM emp WHERE sal NOT IN(3000, 1500, 5000);
8. 查询工资在 1000 到 2000 之间的员工信息
SELECT * FROM emp WHERE sal BETWEEN 1000 AND 2000;
9. 查询工资在 1000 到 2000 以外的员工信息
SELECT * FROM emp WHERE sal NOT BETWEEN 1000 AND 2000;
10. 查询有领导的员工姓名和领导 id
SELECT NAME, manager FROM emp WHERE manager IS NOT NULL;
11. 查询没有领导的员工姓名和工资
SELECT NAME, sal FROM emp WHERE manager IS NULL;
12. 查询员工表中出现了哪几种不同的工作
SELECT DISTINCT job FROM emp;
13. 查询员工表中出现了那几个部门的 id
SELECT DISTINCT dept_id FROM emp;
14. 查询姓孙的员工姓名
SELECT NAME FROM emp WHERE NAME LIKE "孙%";
15. 查询名字最后一个字是精的员工信息
SELECT * FROM emp WHERE NAME LIKE "%精";
16. 查询工作中包含销售的员工信息
SELECT * FROM emp WHERE job LIKE "%销售%";
17. 查询工作中第二个字是售的员工信息
SELECT * FROM emp WHERE job LIKE "_售%";
18. 查询名字中包含僧的员工并且工资高于 2000 的员工信息
SELECT * FROM emp WHERE NAME LIKE "%僧%" AND sal>2000;
19. 查询 1 号和 2 号部门中工作以市开头的员工信息
SELECT * FROM emp WHERE dept_id IN(1, 2) AND job LIKE "市%";
20. 查询所有员工的姓名和工资 按照工资升序排序
SELECT NAME, sal FROM emp ORDER BY sal;
21. 查询所有员工的姓名和工资 按照工资降序排序
SELECT NAME, sal FROM emp ORDER BY sal DESC;
22. 查询所有员工姓名 工资和部门 id 按照部门 id 降序排序,如果部门 id 一致则按照工资升序排序
SELECT NAME, sal, dept_id FROM emp ORDER BY dept_id DESC, sal;
23. 查询员工表中 3 号部门工资高于 1500 的员工信息
SELECT * FROM emp WHERE dept_id=3 AND sal>1500;
24. 查询 2 号部门员工或者没有领导的员工信息
SELECT * FROM emp WHERE dept_id=2 AND manager IS NULL;
25. 查询有领导的员工姓名,工资按照工资降序排序
SELECT NAME FROM emp WHERE manager IS NOT NULL ORDER BY sal DESC;
26. 查询 2 号和 3 号部门的员工姓名和入职日期 hiredate  按照入职日期降序排序
SELECT NAME, hiredate FROM emp WHERE dept_id IN(2, 3) ORDER BY hiredate DESC;
27. 查询名字中包含僧和包含精的员工姓名
SELECT NAME FROM emp WHERE NAME LIKE "%僧%" OR NAME LIKE "%精%";
28. 查询工资高于 2000 的工作有哪几种?
SELECT DISTINCT job FROM emp WHERE sal>2000;
29. 查询工资最高的前三个员工
SELECT * FROM emp ORDER BY sal DESC LIMIT 3;
30. 查询员工表按照 id 排序, 第 2 页的 5 条数据
SELECT * FROM emp ORDER BY id LIMIT 5, 5;
31. 查询员工表按照 id 排序, 第 3 页的 4 条数据
SELECT * FROM emp ORDER BY id LIMIT 8, 4;
32. 查询 3 号部门工资最低的员工姓名和工资
SELECT NAME, sal FROM emp WHERE dept_id=3 ORDER BY sal LIMIT 1;
33. 查询工作不是人事的员工中工资降序第二页的 3 条数据
SELECT * FROM emp WHERE NOT job="人事" ORDER BY sal DESC LIMIT 3, 3;
34. 查询没有领导的员工和 3 号部门的员工,工资降序取前三条
SELECT * FROM emp WHERE manager IS NULL AND dept_id=3 ORDER BY sal DESC LIMIT 3;
35. 查询 2 号部门的最高工资
SELECT MAX(sal) FROM emp WHERE dept_id=2;
36. 查询有领导的员工中工资在 1000 到 2000 之间的人数
SELECT COUNT(*) FROM emp WHERE manager IS NOT NULL AND sal BETWEEN 1000 AND 2000;
37. 查询 3 号部门的工资总和
SELECT SUM(sal) FROM emp WHERE dept_id=3;
38. 查询程序员和销售的总人数
SELECT COUNT(*) FROM emp WHERE job IN("程序员", "销售");
39. 查询 1 号部门有领导的员工的平均工资
SELECT AVG(sal) FROM emp WHERE dept_id=1 AND manager IS NOT NULL;
40. 查询 1 号部门的最低工资和最高工资
SELECT MIN(sal), MAX(sal) FROM emp WHERE dept_id=1;
41. 查询和销售相关的工作人数
SELECT COUNT(*) FROM emp WHERE job LIKE "%销售%";
42. 查询工资不是 1500 和 3000 的员工人数
SELECT COUNT(*) FROM emp WHERE NOT sal IN(1500, 3000);
43. 查询 1 号部门出现了哪几种工作
SELECT DISTINCT job FROM emp WHERE dept_id=1;
44. 查询名字包含精的员工数量
SELECT COUNT(*) FROM emp WHERE NAME LIKE "%精%";
45. 查询和销售相关的工作一个月工资总和
SELECT SUM(sal) FROM emp WHERE job LIKE "%销售%";
46. 查询 2 号部门的最高工资和最低工资起别名
SELECT MAX(sal) 最高工资, MIN(sal) 最低工资 FROM emp WHERE dept_id=2;
47. 查询每种工作的平均工资
SELECT AVG(sal) FROM emp GROUP BY job;
48. 查询每个部门的最高工资
SELECT MAX(sal) FROM emp GROUP BY dept_id;
49. 查询每种工作的最低工资
SELECT MIN(sal) FROM emp GROUP BY job;
50. 查询每个部门工资高于 2000 的人数
SELECT COUNT(*) FROM emp WHERE sal>2000 GROUP BY dept_id;
51. 查询每个部门有领导的员工人数
SELECT COUNT(*) FROM emp WHERE manager IS NOT NULL GROUP BY dept_id;
52. 查询 1 号部门每种工作的最低工资
SELECT MIN(sal) FROM emp WHERE dept_id=1 GROUP BY job;
53. 查询平均工资最高的部门 id 和平均工资
SELECT dept_id, AVG(sal) FROM emp GROUP BY dept_id ORDER BY AVG(sal) DESC LIMIT 1;
```
