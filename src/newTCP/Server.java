/**
 * @author Noah El Hayek
 *
 */
package newTCP;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * @author Noah El Hayek
 *
 */
public class Server {
	
	
	public Server() throws Exception {
		
	int portNumber = 2020;
	ServerSocket serverSocket = new ServerSocket(portNumber);
	System.out.println("Port " + portNumber + " is open.");
	
	Socket socket = serverSocket.accept();
	System.out.println("Client " + socket.getInetAddress() + " is connected.");
	
	// I/O buffers
	BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
	
	outSocket.println("Welcome!");
	String message = inSocket.readLine();
	System.out.println("Client message: " + message);

	socket.close();
	System.out.println("Socket is now closed!");
	}
	
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
