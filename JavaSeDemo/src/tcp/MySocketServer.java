package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: yusheng
 * @create-date: 2019-11-12 09:36
 **/
public class MySocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);

        while (true) {
            // 阻塞方式，等待客户端来握手，获取客户端的Socket
            Socket s = server.accept();

            // 程序到达这里，说明握手成功，且和对方通讯的socket对象是s,下面可以和对方进行收发消息
            InputStream in = s.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(in);
            String clientMsg = dataInputStream.readUTF();
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip + "说：" + clientMsg);


            // 回复客户端
            OutputStream out = s.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(out);
            dataOutputStream.writeUTF("来自服务器的问候:" + ip + "," + s.getPort() + ",你好！！！");

            // 完成交流后，关闭连接
            dataOutputStream.close();
            s.close();
        }
    }
}

