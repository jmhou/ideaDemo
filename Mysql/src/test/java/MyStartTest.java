import org.junit.Test;

/**
 * @author Jimmy
 * @date 2021-01-25 00:11
 * @description function description
 */
public class MyStartTest {
    @Test
    public void myStartTest() {
        MyStart myStart = new MyStart();
        System.out.println(myStart.start("net start | find /c \"MySQL\""));
    }
}
