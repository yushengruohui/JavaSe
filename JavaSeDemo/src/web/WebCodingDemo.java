package web;

import org.junit.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @author: yusheng
 * @create-time 2019-11-10 19:43
 **/
public class WebCodingDemo {
    @Test
    public void test1() throws UnknownHostException {
        //获取本机的网络地址
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);
        //获得主机名
        System.out.println(inetAddress.getHostName());
        //获得IP地址
        System.out.println(inetAddress.getHostAddress());
    }

    @Test
    public void test2() throws UnknownHostException {
        // 网络地址
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
        // 获取此 IP 地址的主机名。
        System.out.println(inetAddress.getHostName());
        //返回 IP 地址字符串（以文本表现形式）。
        System.out.println(inetAddress.getHostAddress());
    }

    @Test
    public void test3() throws UnknownHostException {
        // socket 插口，套字节，网络插口地址=/ip：port
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8082);

        System.out.println(inetSocketAddress);

        //获得InetSocketAddress的端口
        System.out.println(inetSocketAddress.getPort());

        // 获取主机名
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getHostString());

        //返回一个InetAddress对象（IP对象）
        InetAddress address = inetSocketAddress.getAddress();
        System.out.println(address);

    }
}
