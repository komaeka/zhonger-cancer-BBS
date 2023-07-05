> 本项目学习自bilibili的UP主**码匠笔记**的[【Spring Boot 实战】论坛项目【第一季】](https://www.bilibili.com/video/BV1r4411r7au)
> 
> 并在系统中增加了个性化推荐的模块

# 资源文件
未使用 Flyway 之前的数据库脚本

```sql
CREATE TABLE USER
(
    ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN VARCHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);
```

运行 migrate 和 generator 的命令

```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
