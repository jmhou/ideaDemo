import java.io.IOException;

/**
 * @author Jimmy
 * @date 2021-01-25 00:08
 * @description function description
 */
public class MyStart {

    public static void main(String[] args) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("net start MySQL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(process.getInputStream());
    }

    public boolean start(String serviceName) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(serviceName);
            // Runtime.exec()创建的子进程公用父进程的流，不同平台上，父进程的stream buffer可能被打满导致子进程阻塞，从而永远无法返回。
            //针对这种情况，我们只需要将子进程的stream重定向出来即可。
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(process.getInputStream());
        return true;
    }
}
