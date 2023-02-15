# HAVING关键字：
SELECT dept_id, AVG(sal) FROM emp GROUP BY dept_id HAVING AVG(sal)>2000;
SELECT job, COUNT(*) FROM emp GROUP BY job HAVING COUNT(*)>1;
SELECT dept_id, SUM(sal) FROM emp WHERE manager IS NOT NULL GROUP BY dept_id HAVING SUM(sal)>5400;
SELECT dept_id, AVG(sal) FROM emp WHERE sal BETWEEN 1000 AND 3000 GROUP BY dept_id HAVING AVG(sal)>=2000;

#子查询
SELECT * FROM emp WHERE sal>(SELECT AVG(sal) FROM emp WHERE dept_id=2);
SELECT * FROM emp WHERE sal>(SELECT MAX(sal) FROM emp WHERE job="程序员");
SELECT * FROM emp WHERE sal=(SELECT MAX(sal) FROM emp);
SELECT * FROM emp WHERE job=(SELECT job FROM emp WHERE NAME="孙悟空") AND NAME!="孙悟空";

SELECT * FROM emp WHERE dept_id=(
    SELECT dept_id FROM emp WHERE sal=(
        SELECT MIN(sal) FROM emp
    )) AND sal!=(
    SELECT MIN(sal) FROM emp
);

# 数值计算
SELECT NAME, sal, 5*sal 年终奖 FROM emp;
# 给2号部门的员工涨薪5块钱
UPDATE emp SET sal=sal+5 WHERE dept_id=2;

# 关联查询
# 等值连接
SELECT e.name, d.name, d.loc FROM emp e, dept d WHERE e.dept_id=d.id AND d.id=1;
SELECT e.name, e.sal, d.name FROM emp e, dept d WHERE e.dept_id=d.id AND e.sal>2000;
SELECT d.loc FROM emp e, dept d WHERE e.dept_id=d.id AND e.name="孙悟空";
# 内连接
SELECT e.name, d.name, d.loc FROM emp e JOIN dept d ON e.dept_id=d.id WHERE e.dept_id=1;
SELECT e.name, e.sal, d.name FROM emp e JOIN dept d ON e.dept_id=d.id WHERE e.sal>2000;
SELECT d.loc FROM emp e JOIN dept d ON e.dept_id=d.id WHERE e.name="孙悟空";
# 外连接
INSERT INTO emp(NAME, sal) VALUES("灭霸", 5);
SELECT e.name, d.name FROM emp e LEFT JOIN dept d ON e.dept_id=d.id;
SELECT d.loc, e.name, e.job FROM dept d LEFT JOIN emp e ON d.id=e.dept_id;

#综合练习
SELECT * FROM emp WHERE sal>(SELECT AVG(sal) FROM emp WHERE job="程序员");
SELECT job FROM emp WHERE job IS NOT NULL GROUP BY job HAVING COUNT(*)=1;
SELECT e.name, d.name FROM emp e JOIN dept d ON e.dept_id=d.id WHERE d.id IN(1, 2) AND e.sal>2000;
SELECT e.name, e.sal, d.* FROM emp e LEFT JOIN dept d ON e.dept_id=d.id;
SELECT job FROM emp WHERE job IS NOT NULL GROUP BY job HAVING COUNT(*)=2;
SELECT d.name FROM emp e JOIN dept d ON e.dept_id=d.id WHERE sal=(SELECT MAX(sal) FROM emp);

