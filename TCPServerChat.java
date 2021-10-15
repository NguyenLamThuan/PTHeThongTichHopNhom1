import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServerChat {
	public final static String SERVER_IP = "127.0.0.1";
	public final static int SERVER_PORT = 10;
	
	public static void main(String[] args) {

		try {
			ServerSocket ss = new ServerSocket(SERVER_PORT);
			System.out.println("Server đã được tạo : "
					+ ss.getInetAddress().getHostAddress() + "/" + ss.getLocalPort() + "...");
			
			Socket s = ss.accept();
			System.out.println("Client đã kết nối đến server " + s.getRemoteSocketAddress());
			
			String remoteIP = s.getInetAddress().getHostAddress();
			String remotePort = ":"+s.getLocalPort();
			System.out.println("remoteIP: "+remoteIP+" / remotePort: "+remotePort);
			
			PrintStream welcome = new PrintStream(s.getOutputStream());
			welcome.println("Hi, say something!!!");
			
			String msg_in="", msg_out="";
			while(!msg_in.equals("bye") && !msg_out.equals("bye")) 
			{
				Scanner inFromClient = new Scanner(s.getInputStream());
				msg_in = inFromClient.nextLine();
				System.out.println("client: " + msg_in);
				
				PrintStream outToClient = new PrintStream(s.getOutputStream());
				Scanner scan = new Scanner(System.in);
				msg_out = scan.nextLine();
				outToClient.println(msg_out);
			}
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}