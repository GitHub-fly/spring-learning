# 关于 Spring 的配置和注解的说明

## 1. 基于 xml 方式来做 bean 的配置

- `<bean>`标签的使用:id class
- 构造器注入:ref 引用其它对象
- setter 注入： p:简写形式

## 2. 两种方式可以获得 xml 中的 bean

- ApplicationContext 的到上下文、ac.getBean("")
- @Autowired 注解，单元测试中使用，注意命名规范

## 3. 基于 Java 类来做 bean 的配置（主流）

- 配置类一定要加上@Configuration
- 配置 bean 的方法，要加上@Bean 注解

``` java
@Configuration
public class AppConfig {
    @Bean
    public Book book() {
        return new Book();
    }
}
```

## 4. 如何在 SpringFramework 中获得 Java 类配置的 bean

- main 方法

> 注意：在此处的 new AnnotationConfigApplicationContext()，可以传递一个参数，找到对应的配置类也在不填参数，在下面调用 scan() 方法， 进行扫包，把整个包中的配置类都扫描到。但是必须使用 refresh()方法

``` java
    // 生成基于注解配置的应用上下文对象
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    // 手动开启扫包
    ctx.scan("com.soft1851.spring.ioc.config");
    ctx.refresh();
    Book book = (Book) ctx.getBean("book");
    book.setName("java");
    book.setPrice(88.8);
    System.out.println(book);
```

- 单元测试

> 注意在 xml 配置文件中手动开启扫包操作

``` xml
    <context:component-scan base-package="com.soft1851.spring.ioc.config" />
```

## 5. 配置类的设计步骤

- 创建配置类
  - 使用 @Configuration 配置注解
  - 使用 @ComponentScan("包路劲") 扫包
  - 使用@Bean 标记单例
- 主方法中测试
  - ![代码图](https://uploader.shimo.im/f/U0GgXDvjPGEZ4vxm.png!thumbnail)
- 单元测试
  - 使用 @RunWith(SpringJUnit4ClassRunner.class) 启动单元测试
  - 使用@ContextConfiguration(classes = {JdbcConfig.class}) 扫类操作
  - 使用@Autowired 获取单例
