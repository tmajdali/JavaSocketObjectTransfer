package clientServer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import clientServerTest.Student;

public class Server {
	public static void main(String[] args) throws IOException {
        System.out.println("Sender Start");

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(true);
        int port = 3003 ;
        ssChannel.socket().bind(new InetSocketAddress(port));

        Student obj = new Student(211,"ravi",22);
        while (true) {
            SocketChannel sChannel = ssChannel.accept();

            ObjectOutputStream  oos = new 
                      ObjectOutputStream(sChannel.socket().getOutputStream());
            oos.writeObject(obj);
            oos.close();


            System.out.println("Connection ended");
        }
    }

}
