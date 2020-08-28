## 介绍

项目是 `Spring Boot` 开发的类似`fir.im`和`蒲公英`的企业 APP 分发平台，提供android app上传功能，以及ios和android二维码合并功能。用过可直接通过微信、浏览器、QQ等扫码下载app。

此项目为前后端分离，前端采用vue实现，请移步https://github.com/liu-xinhui/appPublishFront

## 效果

样式完全参考http://fir.im

本项目预览地址http://118.25.44.86:8556/

账号：admin

密码：123456

## 部署

本项目已经打包成docker镜像并上传到腾讯云的镜像仓库，可直接pull镜像进行部署，也可拉取代码做适应性修改后重新打包

```dockerfile
#拉取镜像
docker pull ccr.ccs.tencentyun.com/liuxh/app-publish

#运行
docker run -itd -p 8060:8060 -v /webapps/appPublish:/my-app/ap --restart=always --name app-publish --env SPRING_PROFILES_ACTIVE=prod ccr.ccs.tencentyun.com/liuxh/app-publish
```

- 项目内部端口为`8060`
- 容器内部数据存储位置`/my-app/ap`，需要做`docker volume`防止容器删除后数据丢失`-v /webapps/appPublish:/my-app/ap`
- 需要设置项目运行环境为`prod`，`--env SPRING_PROFILES_ACTIVE=prod`

## 技术栈

- `spring boot 2.3.2.RELEASE`
- `h2数据库` 嵌入式数据库，性能好，部署方便，可与mysql无缝切换
- `mybatis-plus 3.3.2`

## 截图

![应用列表](https://uploader.shimo.im/f/9ReWOLluDSUqzHRY.png)
![应用版本历史](https://uploader.shimo.im/f/xZaEsvCRnkTgCYAp.png)
![应用基本信息](https://uploader.shimo.im/f/Hk3NkwSheT6ornG3.png)
![应用合并](https://uploader.shimo.im/f/ZNeltMJb3VRkNN3M.png)
![应用下载页](https://uploader.shimo.im/f/ZoKqStY8HH4BU5Qr.png)