1 数据库的配置文件在 Exam\src\main\resources 下 dbconfig.properties
  需要修改user的值 和password的值，与你的数据库用户名和密码一致即可
2 进入Exam 下   mvn clean compile 编译
3 mvn jetty:run 运行
4 在浏览器的地址栏输入 http://localhost:8080/index.jsp