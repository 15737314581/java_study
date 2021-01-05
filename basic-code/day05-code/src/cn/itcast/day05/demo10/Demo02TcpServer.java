package cn.itcast.day05.demo10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo02TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7777);
        Socket socket = server.accept();

        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));


        OutputStream os = socket.getOutputStream();
        os.write("�յ�лл��".getBytes());

        socket.close();
        server.close();
    }
}
