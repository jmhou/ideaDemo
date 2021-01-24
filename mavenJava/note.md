###1.创建maven工程
打开idea创建一个empty project

###2.maven核心配置（idea）
setting中build下的maven配置：
maven安装路径
本地仓库路径

### 3.新建maven模块
设置GAV
groupid：公司域名倒拼，项目名结尾  eg. com.publicment.mavenJava
artifactid: 模块名
version：默认即可

###4.添加junit依赖
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

###5.新增 java文件
..\src\main\java\Hello.java

/**
 * @author Jimmy
 * @date 2021-01-24 12:09
 * @description function description
 */
public class Hello {
    public String sayHello(String name) {
        return "hello " + name + "!";
    }
}


###6.新增单元测试类
..\src\test\java\day01.HelloTest.java
import org.junit.Test;

/**
 * @author Jimmy
 * @date 2021-01-24 12:10
 * @description function description
 */
public class day01.HelloTest {
    @Test
    public void helloTest(){
        Hello hello = new Hello();
        String str = hello.sayHello("maven");
        System.out.println(str);
    }
}

###7.maven插件操作
lifecycle中
clean：清理编译文件 target目录
compile：编译文件
test：运行测试
package：打包，生成jar包
install：本地仓库安装