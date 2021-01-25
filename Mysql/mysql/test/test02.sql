/*1. 查询工资大于 12000 的员工姓名和工资*/
SELECT concat(first_name, ' ', last_name) AS 姓名
     , salary                             AS 工资
  FROM employees
 WHERE salary > 12000
;

/*2. 查询员工号为 176 的员工的姓名和部门号和年薪*/
SELECT concat(first_name, ' ', last_name) AS 姓名
     , d.department_name
     , salary * (1 + commission_pct) * 12 AS 工资
  FROM employees   e
     , departments d
 WHERE d.department_id = e.department_id
   AND e.employee_id = 176
;

/*3. 选择工资不在 5000 到 12000 的员工的姓名和工资*/
SELECT concat(first_name, ' ', last_name) AS 姓名
     , salary                             AS 工资
  FROM employees
 WHERE salary > 12000
    OR salary < 5000
;

/*4. 选择在 20 或 50 号部门工作的员工姓名和部门号*/
SELECT concat(first_name, ' ', last_name) AS 姓名
     , e.department_id
  FROM employees e
 WHERE e.department_id IN (20, 50)
;

/*5. 选择公司中没有管理者的员工姓名及 job_id*/
SELECT concat(first_name, ' ', last_name) AS 姓名
     , e.job_id
  FROM employees e
 WHERE e.manager_id IS NULL
;

/*6. 选择公司中有奖金的员工姓名，工资和奖金级别*/
CREATE TABLE job_grades
(
    grade_level VARCHAR(3),
    lowest_sal  INT,
    highest_sal INT
)
;

INSERT
  INTO job_grades
VALUES ( 'A', 1000, 2999 )
;

INSERT
  INTO job_grades
VALUES ( 'B', 3000, 5999 )
;

INSERT
  INTO job_grades
VALUES ( 'C', 6000, 9999 )
;

INSERT
  INTO job_grades
VALUES ( 'D', 10000, 14999 )
;

INSERT
  INTO job_grades
VALUES ( 'E', 15000, 24999 )
;

INSERT
  INTO job_grades
VALUES ( 'F', 25000, 40000 )
;

SELECT concat(first_name, ' ', last_name)  AS 姓名
     , e.salary
     , ( SELECT g.grade_level
           FROM job_grades g
          WHERE g.lowest_sal < e.salary
            AND g.highest_sal >= e.salary ) AS grade_level
  FROM employees e
 WHERE e.commission_pct IS NOT NULL
;

/*7. 选择员工姓名的第三个字母是 a 的员工姓名*/
SELECT concat(first_name, ' ', last_name)  AS 姓名
     , e.salary
     , ( SELECT g.grade_level
           FROM job_grades g
          WHERE g.lowest_sal < e.salary
            AND g.highest_sal >= e.salary ) AS grade_level
  FROM employees e
 WHERE e.first_name like '__a%'
;

/*8. 选择姓名中有字母 a 和 e 的员工姓名*/
SELECT concat(first_name, ' ', last_name)  AS 姓名
     , e.salary
     , ( SELECT g.grade_level
           FROM job_grades g
          WHERE g.lowest_sal < e.salary
            AND g.highest_sal >= e.salary ) AS grade_level
  FROM employees e
 WHERE e.first_name like '%a%' or e.first_name like '%e%'
;

/*9. 显示出表 employees 表中 first_name 以 'e'结尾的员工信息*/
SELECT concat(first_name, ' ', last_name)  AS 姓名
     , e.salary
     , ( SELECT g.grade_level
           FROM job_grades g
          WHERE g.lowest_sal < e.salary
            AND g.highest_sal >= e.salary ) AS grade_level
  FROM employees e
 WHERE e.first_name like '%e'
;

/*10. 显示出表 employees 部门编号在 80-100 之间 的姓名、职位*/
SELECT concat(first_name, ' ', last_name)  AS 姓名
     , e.job_id
     , ( SELECT g.job_title
           FROM jobs g
          WHERE g.job_id = e.job_id) AS job_title
  FROM employees e
 WHERE e.department_id <100 and e.department_id >80
;

/*11. 显示出表 employees 的 manager_id 是 100,101,110 的员工姓名、职位*/
SELECT concat(first_name, ' ', last_name)  AS 姓名
     , e.job_id
     , ( SELECT g.job_title
           FROM jobs g
          WHERE g.job_id = e.job_id) AS job_title
  FROM employees e
 WHERE e.manager_id in (100,101,110 )
;

