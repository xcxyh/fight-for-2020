package com.xiong.Nio;// $Id$

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;
/**
 *  @author: xiongcong
 *  @Date: 2019/12/30 21:13
 *  @Description: 多路复用I/O 示例
 */
public class MultiPortEcho {
    private int ports[];
    private ByteBuffer echoBuffer = ByteBuffer.allocate(1024);

    public MultiPortEcho(int ports[]) throws IOException {
        this.ports = ports;

        go();
    }

    private void go() throws IOException {
        // Create a new selector
        Selector selector = Selector.open();

        // Open a listener on each port, and register each one
        // with the selector
        for (int i = 0; i < ports.length; ++i) {
            ServerSocketChannel ssc = ServerSocketChannel.open(); //为了接收连接，我们需要一个 ServerSocketChannel
            ssc.configureBlocking(false); //设置为 非阻塞的

            //最后三行将它绑定到给定的端口
            ServerSocket ss = ssc.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            ss.bind(address);
            //将新打开的 ServerSocketChannels 注册到 Selector上
            SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
            // OP_ACCEPT 指定我们想要监听 accept 事件，也就是在新的连接建立时所发生的事件。这是适用于 ServerSocketChannel 的唯一事件类型。
            //SelectionKey 代表这个通道在此 Selector 上的这个注册
            System.out.println("Going to listen on " + ports[i]);
        }
        //主循环
        while (true) {
            //返回所发生的事件的数量
            int num = selector.select();

            Set selectedKeys = selector.selectedKeys(); //返回发生了的事件的 SelectionKey 对象

            Iterator it = selectedKeys.iterator();

            while (it.hasNext()) {

                SelectionKey key = (SelectionKey) it.next();

                if ((key.readyOps() & SelectionKey.OP_ACCEPT)
                        == SelectionKey.OP_ACCEPT) {
                    // Accept the new connection
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);

                    // Add the new connection to the selector
                    SelectionKey newKey = sc.register(selector, SelectionKey.OP_READ);// SocketChannel 注册用于 读取 而不是 接受 新连接。
                    it.remove();

                    System.out.println("Got connection from " + sc);
                } else if ((key.readyOps() & SelectionKey.OP_READ)
                        == SelectionKey.OP_READ) {
                    // Read the data
                    SocketChannel sc = (SocketChannel) key.channel();

                    // Echo data
                    int bytesEchoed = 0;
                    while (true) {
                        echoBuffer.clear();

                        int r = sc.read(echoBuffer);

                        if (r <= 0) {
                            break;
                        }

                        echoBuffer.flip();

                        sc.write(echoBuffer);
                        bytesEchoed += r;
                    }

                    System.out.println("Echoed " + bytesEchoed + " from " + sc);

                    it.remove();
                }

            }

//System.out.println( "going to clear" );
//      selectedKeys.clear();
//System.out.println( "cleared" );
        }
    }

    static public void main(String args[]) throws Exception {
        if (args.length <= 0) {
            System.err.println("Usage: java MultiPortEcho port [port port ...]");
            System.exit(1);
        }

        int ports[] = new int[args.length];

        for (int i = 0; i < args.length; ++i) {
            ports[i] = Integer.parseInt(args[i]);
        }

        new MultiPortEcho(ports);
    }
}
