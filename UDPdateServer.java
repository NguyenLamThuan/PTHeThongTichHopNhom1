import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDate;
import java.time.LocalTime;

public class UDPdateServer {
    public static void main(String[] args) {
        try {
            
            DatagramSocket s = new DatagramSocket(7777);
            System.out.println("UDP server da dc tao");
            byte[] arr = new byte[6000];
            String str;
            do{
                 DatagramPacket nhan = new DatagramPacket(arr, arr.length);
                s.receive(nhan);

                str = new String(nhan.getData(), 0, nhan.getLength());
                String str1 = Xuly(Integer.parseInt(str));

                Thread.sleep(500);
                DatagramPacket gui = new DatagramPacket(str1.getBytes(), str1.length(), nhan.getAddress(), nhan.getPort());
                s.send(gui);
            }while(str != "0");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static String Xuly(int s){
        java.util.Date date = new java.util.Date();
        switch(s){
            case 0:
                return "Exit";
            case 1:
                return LocalTime.now().toString();
            case 2:
                return LocalDate.now().toString();
            case 3:
                return date.toString();
            default :
                return "Khong co chuc nang nay";
        }
    }
}
