# maven多个模块项目之间互相依赖
* eureka-eureka注册中心测试
* pom.xml - parent父级pom,在该pom中引入spring-boot parent 和　所有子项目公共的依赖
* api-service - 只有api interface 接口和实体类，供其他模块调用
* api-member-service-impl - member 服务实现项目,该项目依赖api-service中的api-member-servcie中的接口(pom文件中需要加载该依赖)
* api-order-service-impl - order 服务实现项目,该项目依赖api-service中的api-order-servcie中的接口(pom文件中需要加载该依赖)
