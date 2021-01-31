# 1.简介
    java nio 是java 1.4 引入的。
    目的和作用 与java io是一样的——进行数据的读写操作

# 2.核心内容
    缓冲区：基本数据类型（除boolean外） BufferXxx
    通道：文件通道、网络通道
    选择器：监听和调度
    
# 3.缓冲区
    在 Java NIO 中负责数据的存取。
    缓冲区就是数组。
    用于存储不同数据类型的数据。

## 3.1 Buffer的主要实现类
    Buffer
      |---ByteBuffer
      |---ShortBuffer
	  |---IntBuffer
	  |---LongBuffer
      |---CharBuffer
      |---FloatBuffer
      |---DoubleBuffer

## 3.2 Buffer的属性和方法  ##
### 核心属性 ###
    capacity : 容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
    limit : 界限，表示缓冲区中可以操作数据的大小。（limit 后数据不能进行读写）
    position : 位置，表示缓冲区中正在操作数据的位置。
    mark : 标记，表示记录当前 position 的位置。可以通过 reset() 恢复到 mark 的位置
    
    备注：0 <= mark <= position <= limit <= capacity
    
### 核心方法 ###
    put() : 存入数据到缓冲区中
    get() : 获取缓冲区中的数据

### 其他常用方法 ###
    allocate(int cap) ：用以生成指定容量大小的缓冲区
        eg. ByteBuffer.allocate(1024)  返回容量1024大小的字节缓冲区
    capacity()  获取核心属性capacity的值
    limit() 获取核心属性limit的值
    position() 获取核心属性position的值
    reset(): 将mark的值设为position的值，就回到之前mark的位置
    flip()： 切换为读模式（limit=position，position=0）
    rewind(): 初始化position=0，如果limit本身是合适的值，就可以当做flip()
    hasRemaining()：判断缓冲区中是否还有剩余数据
    remaining()：获取缓冲区中剩余数据
    clear()： 清空缓冲区

    注意：读写切换要考虑 limit的值，一般直接一次性操作缓冲区

## 3.3 直接缓冲区与非直接缓冲区 ##
    非直接缓冲区：通过 allocate() 方法分配缓冲区，将缓冲区建立在 JVM 的内存中
    直接缓冲区：通过 allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率，但是后续超脱JVM的管理范围。


## 4.通道(Channel) ##
    用于源节点与目标节点的连接。
    在 Java NIO 中负责缓冲区中数据的传输。
    Channel 本身不存储数据，因此需要配合缓冲区进行传输。

### 4.1 通道的主要实现类 ###
	java.nio.channels.Channel 接口：
		|--FileChannel
		|--SocketChannel
		|--ServerSocketChannel
		|--DatagramChannel

### 4.2 获取通道
    Java 针对支持通道的类提供了 getChannel() 方法
      本地 IO：
		FileInputStream/FileOutputStream
		RandomAccessFile

      网络IO：
        Socket
        ServerSocket
        DatagramSocket
 		
     在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
     在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 
### 4.3 通道之间的数据传输
     transferFrom()
     transferTo()
 
### 4.4 分散(Scatter)与聚集(Gather)
     分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
     聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 
### 4.5 字符集：Charset
     编码：字符串 -> 字节数组
     解码：字节数组  -> 字符串











