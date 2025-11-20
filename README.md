# Project Context

## Purpose
基于 Spring Boot 3 的多模块企业级项目脚手架，旨在提供一套完整、规范、易于扩展的后端开发框架。项目集成了现代化的技术栈和最佳实践，为快速构建企业级应用提供基础架构支持。

## Tech Stack

### 核心框架
- **Spring Boot 3.5.7** - 主要应用框架
- **Java 17** - 编程语言版本
- **Maven** - 项目构建和依赖管理

### 数据库与数据访问
- **MySQL 8.x** - 主数据库
- **MyBatis Plus 3.5.12** - ORM 框架，简化数据库操作
- **Druid 1.2.27** - 数据库连接池，提供监控和SQL防火墙
- **Dynamic DataSource 4.3.1** - 动态多数据源支持

### 缓存与会话
- **Redis** - 缓存和会话存储
- **Sa-Token 1.44.0** - 轻量级Java权限认证框架，支持Redis存储

### API文档
- **Knife4j 4.5.0** - API文档生成工具，基于OpenAPI 3

### 工具库
- **HuTool 5.8.41** - Java工具类库
- **Lombok** - 减少样板代码
- **Jackson** - JSON序列化和反序列化

## Project Conventions

### 代码结构
项目采用多模块架构设计：
```
base-demo/
├── common/          # 公共模块 - 通用工具类、配置、异常处理等
├── core/           # 核心业务模块 - 业务逻辑层、数据访问层
├── server/         # Web层模块 - 控制器、配置文件、启动类
└── pom.xml         # 父级Maven配置
```

### 包命名规范
- **基础包名**: `com.mos.base`
- **公共模块**: `com.mos.base.common.*`
- **核心模块**: `com.mos.base.core.*`
- **Web模块**: `com.mos.base.server.*`

### 代码风格
- **编码**: UTF-8
- **注释**: 类和方法使用标准JavaDoc注释，包含作者信息
- **命名**:
    - 类名使用大驼峰命名法 (PascalCase)
    - 方法和变量使用小驼峰命名法 (camelCase)
    - 常量使用全大写下划线分隔 (UPPER_SNAKE_CASE)
- **注解**: 优先使用Lombok简化代码，使用@RequiredArgsConstructor注入依赖

### 数据库规范
- **字段命名**: 数据库字段使用下划线命名 (snake_case)
- **实体映射**: 使用MyBatis Plus注解，支持自动驼峰转换
- **审计字段**: createTime、updateTime、isDeleted、version 为标准审计字段
- **主键策略**: 使用AUTO自增主键

### API设计规范
- **RESTful风格**: 遵循RESTful API设计原则
- **统一返回格式**: 使用Result<T>包装所有API响应
- **分页返回**: 使用RPage<T>包装分页数据
- **参数校验**: 使用Jakarta Validation进行参数校验
- **文档注解**: 使用@Operation和@Tag提供API文档

## Important Constraints

### 技术约束
- 必须使用Java 17+环境
- 数据库要求MySQL 8.0+
- Redis为必需的缓存和会话存储组件
- 遵循Spring Boot 3的Jakarta EE规范

### 业务约束
- 用户密码必须加密存储
- 所有API接口需要合适的权限控制
- 敏感数据需要适当的脱敏处理

### 安全约束
- 使用Sa-Token进行权限认证
- SQL注入防护通过MyBatis Plus和Druid防火墙实现
- 支持CORS跨域配置
