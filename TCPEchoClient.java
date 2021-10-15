import java.io.*;
import java.net.Socket;
public class TCPEchoClient {
	public final static String SERVER_IP = "127.0.0.8";
	public final static int SERVER_PORT = 8;
	public static void main(String[] args) throws InterruptedException,
	IOException{
		Socket s = null;
		try {	
			s = new Socket(SERVER_IP, SERVER_PORT);
			System.out.println("Client da duoc tao");	
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			for(int i = '0';i<'9';i++){
				os.write(i);
				int ch = is.read();
				System.out.println((char)ch);
				Thread.sleep(2000);
			}	
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			if(s != null){
				s.close();
			}
		}
		
	}
}