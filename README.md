# Spring-mvc项目搭建



在intellij 中对分支打tag操作。

1. 为什么要打tag？

    tag中文的意思是标签的意思，生活中的标签有很多，比如产品的合格标签，赠品标签。
    而在开发过程中，可能会有这样的问题出现，1  一个版本开发结束后，进行分支合并，在master上进行测试 上线，上线后发现有问题需要急需退回到上一个版本，这就要求我们自己手动在服务器上备份很多的war或者备份很多的文件夹。2  如果一般的修改在没有拉取新分支，而是在master上直接修改的话，修改后上线有问题，可以及时的拉取退回。3  如果在发版的时候忘记了备份war或者备份文件夹，及时代码进行回滚，代码回滚会造成一部分提交无效。所以，打tag很必要。

2. git tag和git branches区别？

    tag就像里程碑标志的一个点，branch是一个新的征程的一条线；tag 是静态的，而branch要往前走；稳定版本备份用tag，新功能开发多人用branch，开发完之后再merge到master上。
    tag是一个只读的branch。

Spring-mvc 测试示例代码   自己学习使用

1. tag1 ： 项目简单的搭建  tag-name = v1.0

    (1).项目的简单配置和搭建

    (2).实现操作简单的hello Word 功能

2. tag2 ： 模拟数据库  tag-name = v1.1

     spring-mvc模拟数据库

     模拟数据库中的增删改查显示页面信息，配置项目的首页显示，在页面上用ajax实现一步刷新等多项功能

3. tag3 ： 模拟数据库  tag-name = v1.2

    (1).绑定converter和formatter的方法

    <!--绑定converter和formatter 的话要用这个-->
    <mvc:annotation-driven conversion-service="customConversionService"/>
    由Converter工厂配置自定义转换器
    <!--spring 内置3中类型转换器接口，分别是
        Converter<S,T>
        ConverterFactory<S,R>
        GenericConverter
        自定义的类型转换器必须实现其中一个-->
    <!--org.springframework.context.support.ConversionServiceFactoryBean 用于绑定converter-->
    <!--org.springframework.format.support.FormattingConversionServiceFactoryBean 绑定converter和formatter都可以-->
    <!--如果formatters和converters 都配置了  会执行formatters里面的方法，converters失效了-->
    <bean id="customConversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
        <property name="converters">
            <set>
                <bean class="org.springframework.core.convert.support.StringToBooleanConverter"/>
                <bean class="com.spring.mvc.converter.MyConverter"/>
            </set>
        </property>
        <property name="formatters">
            <set>
                <bean class="com.spring.mvc.formatter.MyFormatters"/>
            </set>
        </property>
    </bean>

    (2).过滤器的配置

    <!--全局过滤器 配置-->
        <!--可以形成一个拦截器链，拦截器的执行顺序是按声明的先后顺序执行的，
                        先声明的拦截器中的preHandle方法会先执行，
                        然而它的postHandle方法和afterCompletion方法却会后执行-->
        <mvc:interceptors>
            <!--拦截所有请求-->
            <bean class="com.spring.mvc.interceptor.HelloInterceptor"/>
            <mvc:interceptor>
                <!--需要进行拦截的请求路径-->
                <mvc:mapping path="/user/list"/>
                <bean class="com.spring.mvc.interceptor.UserInterceptor" />
            </mvc:interceptor>
        </mvc:interceptors>
