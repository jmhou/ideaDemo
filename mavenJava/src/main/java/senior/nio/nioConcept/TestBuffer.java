package senior.nio.nioConcept;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

/**
 * @author Jimmy
 * @date 2021-01-31 09:55
 * 一、缓冲区（Buffer）：在 Java NIO 中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 *
 * 根据数据类型不同（boolean 除外），提供了相应类型的缓冲区：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过 allocate() 获取缓冲区
 *
 * 二、缓冲区存取数据的两个核心方法：
 * put() : 存入数据到缓冲区中
 * get() : 获取缓冲区中的数据
 *
 * 三、缓冲区中的四个核心属性：
 * capacity : 容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit : 界限，表示缓冲区中可以操作数据的大小。（limit 后数据不能进行读写）
 * position : 位置，表示缓冲区中正在操作数据的位置。
 *
 * mark : 标记，表示记录当前 position 的位置。可以通过 reset() 恢复到 mark 的位置
 *
 * 0 <= mark <= position <= limit <= capacity
 *
 * 四、直接缓冲区与非直接缓冲区：
 * 非直接缓冲区：通过 allocate() 方法分配缓冲区，将缓冲区建立在 JVM 的内存中
 * 直接缓冲区：通过 allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 */
public class TestBuffer {




    @Test
    public void test1() {
        String str = new String("abcde");
        String str1 = new String("123456");

        // 1.获取缓冲区
        System.out.println("--allocate()-------------------------------------------");
        CharBuffer cb = CharBuffer.allocate(1024);

        // 2.查看属性
        System.out.println("--capacity()--limit()--position()----------------------");
        /*System.out.println(cb.capacity());
        System.out.println(cb.limit());
        System.out.println(cb.position());*/
        printAttr(cb);

        // 3.缓冲区写入
        cb.put(str);
        System.out.println("--after put()------------------------------------------");
        printAttr(cb);

        // 4.切换为读模式
        cb.flip();
        System.out.println("--after flip()-----------------------------------------");
        printAttr(cb);

        // 5.读取缓冲区数据
        char[] cs = new char[cb.limit()];
        cb.get(cs,0,cs.length-1); //注意 索引越界
        System.out.println("--after get()------------------------------------------");
        printAttr(cb);
        System.out.println(String.valueOf(cs));

        // 6. rewind可以重新读
        cb.rewind();
        System.out.println("--after rewind()---------------------------------------");
        printAttr(cb);
        cb.limit(cb.capacity()); //必须重新设limit = capacity，不认容易 索引越界
        cb.put(str1);
        System.out.println("--after put()---------------------------------------");
        printAttr(cb);

        // 7.清空缓冲区
        cb.clear();
        System.out.println("--after clear()----------------------------------------");
        printAttr(cb);
    }

    public void printAttr(Buffer b) {
        System.out.println("mark:"+b.mark()+",position:"+b.position()+",limit:"+b.limit()+",capacity:"+b.capacity());
        System.out.print("\n");
    }

}
