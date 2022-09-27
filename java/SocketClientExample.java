import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
* This class implements java socket client
* @author pankaj
*
*/
public class SocketClientExample {

public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
//get the localhost IP address, if server is running on some other IP, you need to use that
//InetAddress host = InetAddress.getLocalHost();
	InetAddress host = InetAddress.getByName("192.168.1.252");
Socket socket = null;



    Scanner myObj = new Scanner(System.in);

    System.out.println("ingresa tu opcion 1 = roca, 2 = tijeras, 3 = papel");

    // String input
    String name = myObj.nextLine();
    int respuesta = Integer.parseInt(name);
    boolean first = true;

    // Numerical input
   // int age = myObj.nextInt();
 //   double salary = myObj.nextDouble();
 if(respuesta == 1)
 {
         System.out.println("Elegiste roca");
 }
  if(respuesta == 2)
 {
         System.out.println("Elegiste tijeras");
 }
  if(respuesta == 3)
 {
         System.out.println("Elegiste papel");
 }
    // Output input by user
   // System.out.println("Name: " + name);
  //  System.out.println("Age: " + age);
   // System.out.println("Salary: " + salary);

ObjectOutputStream oos = null;
ObjectInputStream ois = null;

while(first == true){
//establish socket connection to server
socket = new Socket(host.getHostName(), 9876);
//write to socket using ObjectOutputStream
oos = new ObjectOutputStream(socket.getOutputStream());
System.out.println("Sending request to Socket Server");

oos.writeObject(name);
//read the server response message
ois = new ObjectInputStream(socket.getInputStream());
String message = (String) ois.readObject();
System.out.println("Message: " + message);
//close resources
first = false;
ois.close();
oos.close();

}
}
}

