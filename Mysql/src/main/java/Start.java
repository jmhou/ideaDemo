import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Jimmy
 * @date 2021-01-24 23:52
 * @description function description
 */
public class Start {



    public boolean startService(String serviceName) {
        Runtime run =Runtime.getRuntime();
        try {
            Process p = run.exec(serviceName);
            InputStream ins= p.getInputStream();
            InputStream ers= p.getErrorStream();
            new Thread(new inputStreamThread(ins)).start();
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    class inputStreamThread implements Runnable {
        private InputStream ins = null;
        private BufferedReader bfr = null;

        public inputStreamThread(InputStream ins) {
            this.ins = ins;
            this.bfr = new BufferedReader(new InputStreamReader(ins));
        }

        @Override
        public void run() {
            String line = null;
            byte[] b = new byte[100];
            int num = 0;
            try {
                while ((num = ins.read(b)) != -1) {
                    System.out.println(new String(b, "gb2312"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
