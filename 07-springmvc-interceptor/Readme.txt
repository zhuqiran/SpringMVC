SSM：SpringMVC + Spring + Mybatis

SSM：一个项目中需要有多个框架，是使用框架解决不同方面的问题。
SpringMVC主要解决，接收用户请求，调用Service完成业务逻辑，返回处理结果。是视图层框架。
Spring主要解决的问题，使用IoC管理对象（Service、Dao、工具类对象等）；使用AOP提供面向切面的编程
Mybatis主要解决数据库访问的问题。

SpringMVC和Spring都属于是容器对象，SringMVC负责管理的对象主要是：Controller、视图对象等；Spring容器
主要管理Service、Dao、工具类对象等。

用户的请求处理流程：
    用户请求 ---------> SpringMVC的Controller ----------> Service ----------> Dao ----------> DB

SpringMVC容器和Spring容器的关系
    SpringMVC容器可以看做是Spring容器的子容器，所以从继承的角度理解，SpringMVC容器时可以访问Spring容器内容的，
也就是说，Controller对象能够访问到Service。但是Spring容器不能访问SpringMVC容器的内容，即Service是访问不到
Controller对象的。


SSM整合步骤：
1. 新建Maven web工程
2. 加入Maven坐标，依赖
3. 配置web.xml文件
    1）注册SpringMVC的中央调度器（DispatcherServlet），读取SpringMVC配置文件，创建文件中的处理器对象
    2）注册Spring监听器，让监听器将Spring容器对象发入到ServletContext域属性空间中。读取Spring的配置文件，创建Service、Dao对象
    3）注册字符集过滤器，解决post请求中的中文乱码问题。
4. 将程序结构包建立起来，dao、service、controller

5. 编写多个配置文件
    1）SpringMVC配置文件
    2）Spring配置文件
    3）Mybatis的主配置文件
    4）数据库的属性配置文件
6. 编写代码：实体类定义，Dao、Service实体、Controller等。





















































