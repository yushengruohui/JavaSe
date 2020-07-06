package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author: yusheng
 * @create-date: 2019-11-12 09:24
 **/
public class MySocketClient {
    public static void main(String[] args) throws IOException {
        // 尝试向指定“IP+端口号”的那台服务器发出握手申请，如果握手等待时间超时则会抛出异常.
        Socket s = new Socket("127.0.0.1", 8888);
        // 如果程序能到达这里，说明上一句没出异常，也就是握手成功，接下来就可以通过s和对方(服务器)进行通讯了

        // 发送数据
        // 通过s获取输出流，可以给服务器传输数据
        OutputStream out = s.getOutputStream();
        // 字符串对象转成字节对象
        // out.write("Hello Server,I'm coming....".getBytes());，这种方式太麻烦了，用下面这种更友好
        // DataOutputStream提供了直接把Java基本数据类型转换成字节的接口
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        // DataOutputStream数据输出流允许应用程序将基本Java数据类型写到字节输出流中
        dataOutputStream.writeUTF("hello server,i'm coming");

        // 接收数据
        // 通过s获取输入流，接受服务器传过来的数据
        InputStream in = s.getInputStream();
        // DataInputStream数据输入流允许应用程序以机器无关的方式从字节输入流中读取基本的Java类型.
        DataInputStream din = new DataInputStream(in);
        // 读取字符串
        String info = din.readUTF();
        System.out.println(info);

        // 完成交流，关闭连接
        din.close();
        s.close();
    }
}

