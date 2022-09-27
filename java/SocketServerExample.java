import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
* This class implements java Socket server
* @author pankaj
*
*/
public class SocketServerExample {
	
	
	//static ServerSocket variable
	private static ServerSocket server;
	//socket server port on which it will listen
	private static int port = 9876;
	



	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		int r,s,p;

		r = 1;
		s = 2;
		p = 3;


		
		//create the socket server object
		server = new ServerSocket(port);
		//keep listens indefinitely until receives 'exit' call or program terminates
		while(true)
		{
			System.out.println("Waiting for the client request");
			//creating socket and waiting for client connection
			Socket socket = server.accept();
			//read from socket to ObjectInputStream object
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			//convert ObjectInputStream object to String
			String message = (String) ois.readObject();
			int numero = (int)(Math.random()*3+1);
			System.out.println(numero);
			int msg = Integer.parseInt(message);

			if(msg == 1 && numero ==1)
			{
				oos.writeObject("roca vs roca \n empate");
				System.out.println("escogiste roca ");

			}
			if(msg == 1 && numero ==2)
			{
				oos.writeObject("roca vs tijeras \nganaste");
				System.out.println("escogiste tijeras ");
			}
			if(msg == 1 && numero ==3)
			{
				oos.writeObject("roca vs papel \nperdis");
				System.out.println("escogiste papel ");
			}
			
			// tijeras

			if(msg == 2 && numero ==1)
			{
				oos.writeObject("tijeras vs roca \n perdiste");
				System.out.println("escogiste roca ");
			}
			if(msg == 2 && numero ==2)
			{
				oos.writeObject("tijeras vs tijeras \n empete ");
				System.out.println("escogiste tijeras ");
			}
			if(msg == 2 && numero ==3)
			{
				oos.writeObject("tijeras vs papel \n ganaste ");
				System.out.println("escogiste papel ");
			}

			//papel

			if(msg == 3 && numero ==1)
			{
				oos.writeObject("papel vs roca \n ganaste");
				System.out.println("escogiste roca ");
			}
			if(msg == 3 && numero ==2)
			{
				oos.writeObject("papel vs tijeras \n perdiste");
				System.out.println("escogiste tijeras ");
			}
			if(msg == 3 && numero ==3)
			{
				oos.writeObject("papel vs papel \n empate");
				System.out.println("escogiste papel ");
			}

			ois.close();
			socket.close();
			//terminate the server if client sends exit request
			if(message.equalsIgnoreCase("exit")) break;
		}
		System.out.println("Shutting down Socket server!!");
		//close the ServerSocket object
		server.close();
	}


}