# 导入依赖
```
        <dependency><!--添加Swagger依赖 -->
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.7.0</version>
        </dependency>
        <dependency><!--添加Swagger-UI依赖 -->
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.7.0</version>
        </dependency>
```

# 配置类
```java
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("标题：xxx...此处是标题部分")
                        .description("描述：xxx...此处是描述内容")
                        .contact(new Contact("mapleins", "url","mapleins@aliyun.com" ))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.maple.swagger2demo"))//扫描包的路径
                .paths(PathSelectors.any())
                .build();
    }
}
```

# 注解介绍
    @Api : 描述类/接口的主要用途 
    @ApiOperation : 描述方法用途
    @ApiImplicitParam() : 描述方法的参数，如数据类型dataType、参数名name、参数含义value
    @ApiImplicitParams : 描述方法的参数(Multi-Params)
    @ApiIgnore : 忽略某类/方法/参数的文档
