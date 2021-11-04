import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.InputStreamReader;
public class Client {
    public static void main(String[] args) {
        try{
            DatagramSocket s = new DatagramSocket();

            InetAddress address = InetAddress.getByName("localhost");
            Scanner sc = new Scanner(System.in);
            //Gửi dữ liệu cho client
            System.out.println("Nhập tên file cần đọc: ");
            String filename = sc.nextLine();
            DatagramPacket dp_send = new DatagramPacket(filename.getBytes(),filename.length(),address,7777);
            s.send(dp_send);

            //nhận
            byte nhan[] = new byte[6000];
            DatagramPacket dp_recv = new DatagramPacket(nhan,nhan.length);
            s.receive(dp_recv);
            //
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("Nhập ký tự: ");
            String n = br.readLine();
            //
            System.out.println("Server >> Nội dung file");
            System.out.println(new String(dp_recv.getData(),0, dp_recv.getLength()));

        }catch(Exception e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}