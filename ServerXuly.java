import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerXuly extends Thread{
    DatagramSocket s;
    public ServerXuly(DatagramSocket s){
        this.s = s;
    }
    public void run(){
        try{
            while(true){
                //nhận
                byte n[] = new byte[6000];
                DatagramPacket dp_receive = new DatagramPacket(n, n.length);
                s.receive(dp_receive);
                String file = new String(dp_receive.getData(), 0, dp_receive.getLength());
                //Xy ly
                File docfile = new File(file);
                System.out.println("Đang đọc file: " + docfile.getName());
                byte files[];
                if(docfile.exists()){
                    FileInputStream fis = new FileInputStream(docfile);
                    byte readfile[] = new byte[50000];
                    fis.read(readfile);
                    files = readfile;
                    int count = 0;
                    for(int i = 0; i < readfile.length; i++){
                        count += i;
                    }
                    System.out.println("Ki tu trong chuoi la: "+ count);
                }else{
                    files = "Khong tìm thấy file".getBytes();
                    System.out.println("Không tìm thấy file");
                }
                //gửi
                DatagramPacket dp_send = new DatagramPacket(files, files.length,dp_receive.getAddress(), dp_receive.getPort());
                s.send(dp_send);
                System.out.println("Gửi nội dung file thành công");
            }
        }catch(Exception e){
            //TODO
        }
        super.run();
    }

}
