import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerBai1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("SERVER đã chạy .....");
        while (true) {
            Socket s;
            try {
                s = ss.accept();
                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();

                while (true) {
                    int ch = is.read();
                    String res = "";
                    switch (ch) {
                        case '0':
                            res = "Không";
                            break;
                        case '1':
                            res = "Một";
                            break;
                        case '2':
                            res = "Hai";
                            break;
                        case '3':
                            res = "Ba";
                            break;
                        case '4':
                            res = "Bốn";
                            break;
                        case '5':
                            res = "Năm";
                            break;
                        case '6':
                            res = "Sáu";
                            break;
                        case '7':
                            res = "Bảy";
                            break;
                        case '8':
                            res = "Tám";
                            break;
                        case '9':
                            res = "Chín";
                            break;
                        default:
                            res = "Không phải số nguyên";
                        
                    }
                    os.write(res.getBytes());
                    System.out.println("Server : " + res);
                }
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}