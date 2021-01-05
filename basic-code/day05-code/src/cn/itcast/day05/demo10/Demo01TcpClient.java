package cn.itcast.day05.demo10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo01TcpClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",7777);
        OutputStream os = socket.getOutputStream();
        os.write("ÄãºÃ·þÎñÆ÷".getBytes());

        InputStream is = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int len =is.read(bytes);
        System.out.println(new String(bytes,0,len));



        socket.close();
    }
}
