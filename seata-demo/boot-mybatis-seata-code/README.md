## Seata Demo 说明文档

### Boot-Mybatis-Seata 说明

- 下载 Nacos 本文使用的是1.4.1
  - [Nacos 安装与使用说明](https://github.com/yanghaiji/Advanced-books/blob/master/note/nacos/README.md)
- 下载 Seata 本文使用的是1.4.1
  - [Seata安装与使用说明](https://github.com/yanghaiji/Advanced-books/blob/master/note/transaction/README.md)
- 创建两个数据库并将init.sql导入
- undo_log创建到prod 项目所连接的数据库
- 启动` prod 、coms` 项目
  - 访问 `http://localhost:9011/goods/10` 