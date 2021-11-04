
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        try{
            DatagramSocket s = new DatagramSocket(7777);
            System.out.println("Server đã được khởi tạo");

            new ServerXuly(s).start();

        }catch(Exception e){
            //TODO
        }
    }
}
