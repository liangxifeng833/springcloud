# maven多个模块项目之间互相依赖
* eureka-eureka注册中心测试
* pom.xml - parent父级pom,在该pom中引入spring-boot parent 和　所有子项目公共的依赖 (pom类型)
* api-service - 只有api interface 接口和实体类，供其他模块调用 (pom类型)
  + api-member-service - 会员接口,没有springboot启动入口类 (jar类型)
  + api-order-service - 订单接口,没有springboot启动入口类  (jar类型)
* api-member-service-impl - member 服务实现项目,该项目依赖api-service中的api-member-servcie中的接口(pom文件中需要加载该依赖,jar类型)
* api-order-service-impl - order 服务实现项目,该项目依赖api-service中的api-order-servcie中的接口(pom文件中需要加载该依赖,jar类型)
* api-common - 公共功能实现,没有spingboot启动入口, 包含:返回实体ResponseBase等所有项目的通用功能(jar类型)
