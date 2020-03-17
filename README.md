# 关于Spring的配置和注解的说明

## 1. 基于xml方式来做bean的配置
- <bean>标签的使用:id class
- 构造器注入:ref 引用其它对象
- setter 注入： p:简写形式

## 2. 两种方式可以获得xml中的bean
- ApplicationContext 的到上下文、ac.getBean("")
- @Autowired 注解，单元测试中使用，注意命名规范

## 3. 基于Java类来做bean的配置（主流）
- 配置类一定要加上@Configuration
- 配置bean的方法，要加上@Bean注解

```java
@Configuration
public class AppConfig {
    @Bean
    public Book book() {
        return new Book();
    }
}
```

## 4. 如何在SpringFramework中获得Java类配置的bean
- main 方法
> 注意：在此处的 new AnnotationConfigApplicationContext()，可以传递一个参数，找到对应的配置类
>       也在不填参数，在下面调用 scan() 方法， 进行扫包，把整个包中的配置类都扫描到。但是必须使
>       用refresh()方法

```java 
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

```xml
    <context:component-scan base-package="com.soft1851.spring.ioc.config" />
```
