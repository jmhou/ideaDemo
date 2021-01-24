package day01;

import org.junit.Test;

/**
 * @author Jimmy
 * @date 2021-01-24 12:10
 * @description function description
 */
public class HelloTest {

    @Test
    public void helloTest(){
        Hello hello = new Hello();
        String str = hello.sayHello("maven");
        System.out.println(str);
    }
}
