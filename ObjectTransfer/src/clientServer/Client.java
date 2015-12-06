package clientServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;

import clientServerTest.Student;

public class Client {
	 public static void main(String[] args) 
			    throws IOException, ClassNotFoundException {
			        System.out.println("Receiver Start");

			        SocketChannel sChannel = SocketChannel.open();
			        sChannel.configureBlocking(true);
			        if (sChannel.connect(new InetSocketAddress("205.178.20.186", 3003))) {

			            ObjectInputStream ois = 
			                     new ObjectInputStream(sChannel.socket().getInputStream());

			            Student s = (Student)ois.readObject();
			            System.out.println(s);
//			            String s = (String)ois.readObject();
//			            System.out.println("String is: '" + s + "'");
			        }

			        System.out.println("End Receiver");
			    }
}
