## Mysql
### 1.数据库的概述
####基本概念
    DB：数据库
    DBMS：数据库管理软件
    SQL：数据库关联过程中用到的和数据库交互的语言（结构化查询语言）
####数据的优势：
    数据持久化
    结构化（方便检索）
####数据库的语言分类
    DDL：数据定义语言 对象的增删改查
    DML：数据操作语言 数据的增删改查
    DCL：数据控制语言 权限、事务的控制
###2.Mysql数据库的安装和使用
####下载Mysql
    Windows平台下下载： http://dev.mysql.com/downloads/mysql
####安装Mysql
    略（百度）
####Mysql的服务启动（windows其他服务也是一样）
#####可视化操作：
    右击计算机—管理—服务—启动或停止MySQL服务
#####命令：
    启动： net start mysql服务名
    停止： net stop mysql服务名
####登录和退出
    登录：mysql –h 主机名 –u用户名 –p密码
    退出：exit

##3.数据处理之查询
### 语法结构
    select --3.取哪些列
      from --1.从哪些表取
     where --2.取哪些行
### 聚合函数
    AVG()
    COUNT()
    MAX()
    MIN()
    SUM()

### 4.常见函数
####日期函数
    now：获取当前日期
    select now
    
    str_to_date: 将日期格式的字符转换成指定格式的日期
    STR_TO_DATE('9-13-1999','%m-%d-%Y') 1999-09-13
    
    date_format:将日期转换成字符
    DATE_FORMAT(‘2018/6/6’,‘%Y年%m月%d日’) 2018年06月06日

### 5.dml操作
    如果需要回滚数据，需要保证在DML前，进行设置： 
    SET AUTOCOMMIT = FALSE;

### 6.分页
    limit 1,10
    
### 7.事务
#### 7.1 事务的概念
    1、概念：在mysql中的数据用各种不同的技术存储在文件（或内存）中。
    2、通过show engines；来查看mysql支持的存储引擎。
    3、在mysql中用的最多的存储引擎有： innodb,myisam,memory 等。
    其中innodb支持事务，而myisam、 memory等不支持事务
    
#### 7.2 事务的ACID(acid)属性
    1. 原子性（Atomicity） - 不允许部分成功失败
    2. 一致性（Consistency） - 一个一致性状态到另一个一致性状态
    3. 隔离性（Isolation） - 事务隔离，事务间不影响
    4. 持久性（Durability） - 事务提交就持久化了

#### 7.3数据库的隔离级别
##### 事务隔离的引入
对于同时运行的多个事务, 当这些事务访问数据库中相同的数据时, 如果没有采取必要的隔离机制, 就会导致各种并发问题:
    **脏读**: 对于两个事务 T1, T2, T1 读取了已经被 T2 更新但还没有被提交的字段.之后, 若 T2 回滚, T1读取的内容就是临时且无效的.
    **不可重复读**: 对于两个事务T1, T2, T1 读取了一个字段, 然后 T2 更新了该字段.之后, T1再次读取同一个字段, 值就不同了.
    **幻读**: 对于两个事务T1, T2, T1 从一个表中读取了一个字段, 然后 T2 在该表中插入了一些新的行. 之后, 如果 T1 再次读取同一个表, 就会多出几行.
数据库事务的隔离性: 数据库系统必须具有隔离并发运行各个事务的能力,使它们不会相互影响, 避免各种并发问题.
一个事务与其他事务隔离的程度称为隔离级别. 数据库规定了多种事务隔离级别, 不同隔离级别对应不同的干扰程度, 隔离级别越高, 数据一致性就越好, 但并发性越弱.
###### 隔离级别 （并发和性能是一对矛盾）
    READ UNCOMMITTED（读未提交数据）允许事务读取未被其他事物提交的变更.脏读，不可重复读和幻读的问题都会出现
    READ COMMITED（读已提交数据）只允许事务读取已经被其它事务提交的变更.可以避免脏读，但不可重复读和幻读问题仍然可能出现
    REPEATABLE READ（可重复读）确保事务可以多次从一个字段中读取相同的值.在这个事务持续期间，禁止其他事物对这个字段进行更新.可以避免脏读和不可重复读，但幻读的问题仍然存在.
    SERIALIZABLE（串行化）确保事务可以从一个表中读取相同的行.在这个事务持续期间，禁止其他事务对该表执行插入，更新和删除操作.所有并发问题都可以避免，但性能十分低下.

Ororacle 支持的 2 种事务隔离级别： READ COMMITED,SERIALIZABLE。
Oracle 默认的事务隔离级别为: READ COMMITED
Mysql 支持 4 种事务隔离级别. Mysql 默认的事务隔离级别为: REPEATABLE READ

查看当前的隔离级别: 
    `SELECT @@tx_isolation;`
设置当前 mySQL 连接的隔离级别:
    `set transaction isolation level read committed;`
设置数据库系统的全局的隔离级别:
    `set global transaction isolation level read committed;`

### 8 函数和存储过程
1.查看存储过程或函数的状态：
`show {procedure|function} status like 存储过程或函数名`
2.查看存储过程或函数的定义：
`show create {procedure|function} 存储过程或函数名`
3.通过查看information_schema.routines了解存储过程和函数的信息（了解）
`select * from rountines where rounine_name =存储过程名|函数名`

### 9循环
先判断后执行 while
`Label:while loop_condition
do
loop_list
End while label;`

先执行后判断 repeat
`Label:repeat
loop_list
Until end_condition
end repeat label;`

没有条件的死循环 loop
`Label:loop
loop_list
End loop label;`