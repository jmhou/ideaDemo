package senior.nio.nioConcept;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * @author Jimmy
 * @date 2021-02-01 22:29
 * @description function description
 */
public class CharsetTest {

    @Test
    public void test1() {
        Charset csUTF8 = Charset.forName("UTF-8");
        Charset csGBK = Charset.forName("GBK");

        //编码 ： 字符串转字节
        System.out.println("-----------------------编码 ： 字符转字节");
        ByteBuffer bf = csUTF8.encode("学习很枯燥！");
        System.out.println(bf.toString());

        //解码 ： 字节转字符串
        System.out.println("-----------------------解码 GBK： 字节转字符");
        CharBuffer cb = csGBK.decode(bf);
        System.out.println(cb.toString());

        System.out.println("-----------------------解码 UTF-8： 字节转字符");
        bf.rewind();
        CharBuffer cb2 = csUTF8.decode(bf);
        System.out.println(cb2.toString());
    }
}
