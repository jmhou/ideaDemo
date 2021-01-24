###1.创建工程（已完成，略）

###2.新增maven模块
groupid：公司域名倒拼，项目名结尾  eg. com.publicment.mavenWeb
artifactid: 模块名
version：默认即可

###3.设置打包方式
    <groupId>com.publicment.mavenWeb</groupId>
    <artifactId>mavenWeb</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

###4.添加web.xml
项目结构设置中的模块下添加 web文件夹（如已有就跳过）


###5.配置tomcat
配置tomcat的安装路径
选择发布方式 war 或者 war exploed
war模式（**发布模式**）：将web工程以war包的形式上传到服务器，是先打包war包，再发布；
war exploed模式（**热部署模式**）：直接把文件夹，jsp页面，classes等等移到Tomcat部署文件夹里面，进行加载部署。
