import org.junit.Test;

/**
 * @author Jimmy
 * @date 2021-01-25 00:00
 * @description function description
 */
public class StartTest {
    @Test
    public void startServiceTest(){
        Start start = new Start();
        boolean running = start.startService("net start | find /c \"MySQL\"");
        System.out.println("running = " + running);
    }

}
