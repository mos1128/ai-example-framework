# AI Example Framework

基于 Spring Boot 3 的后端脚手架项目，采用 Maven 多模块结构，内置常用基础配置、统一返回结果、异常处理、登录示例、Redis、MyBatis-Flex 和 Knife4j/OpenAPI 文档。

## 技术栈

依赖版本统一由父级 `pom.xml` 管理。

- Java 17
- Maven
- Spring Boot 3.5.14
- MyBatis-Flex 1.11.6
- MySQL 8.x
- Redis
- Sa-Token 1.45.0
- HuTool 5.8.44
- Knife4j 4.5.0

## 模块结构

```text
ai-example-framework/
├── common/          # 公共模块：通用基础类、配置、异常处理、工具类
├── core/            # 核心业务模块：Service、Mapper、DTO、Domain、VO
├── server/          # Web 启动模块：启动类、Controller、运行配置
└── pom.xml          # 父级 Maven 配置
```

当前根包为 `com.example`：

```text
com.example
├── ServerApplication
├── common
├── core
└── server
```

启动类位于根包 `com.example` 下，Spring Boot 会自动扫描根包及其子包。项目中不需要额外维护 `@ComponentScan`、`@MapperScan` 或 `springdoc.packages-to-scan` 这类固定包名配置。

## 新项目使用

1. 复制或基于本仓库创建新项目。
2. 使用 IDE 的重构功能将根包 `com.example` 整体改成目标包名，例如 `com.company.project`。
3. 修改 `server/src/main/resources/application-dev.yml` 中的 MySQL、Redis、日志路径等本地配置。

## 初始化 SQL

初始化脚本位于 `sql/`：

- `base-init.sql`：初始化 `base` 库，内置登录测试账号 `admin / 123456`。
- `test-init.sql`：初始化 `test` 库，内置用户列表测试数据。

用户分页接口示例：`GET /user/list?pageNo=1&pageSize=10`。

## 开发约定

- Controller 显式返回 `Result<T>`，成功使用 `Result.success(data)`。
- 业务异常优先使用 `BusinessException`，由全局异常处理器统一转换响应。
- Mapper 接口继承 MyBatis-Flex `BaseMapper<T>`，并使用 `@Mapper` 注册。
- 通用能力放在 `common`，可复用业务能力放在 `core`，端侧接口和端侧配置放在 `server`。
- 如果后续拆分用户前台、管理后台，优先按 Controller 包和接口路径隔离，例如 `server.controller.front`、`server.controller.admin`，Service 和 Mapper 继续在 `core` 复用。
- 新增代码时保持现有风格，先复用已有工具类和基础封装，再补充新的抽象。
