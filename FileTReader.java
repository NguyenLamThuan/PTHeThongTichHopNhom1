package Tuan3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileTReader extends Thread {
    String filename;
    public FileTReader(String filename){
        this.filename = filename;
    }
    @Override
    public void run(){
        try{
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                Thread.sleep(2000);
            }
            fr.close();
            br.close();
        } catch(Exception ex){
            System.out.println("Loi doc file: " + ex);
        }
    }
    
    public static void main(String[] args){
        FileTReader t1 = new FileTReader("D:\\JAVA\\Tuan3\\text1.txt");
        FileTReader t2 = new FileTReader("D:\\JAVA\\Tuan3\\text2.txt");
        FileTReader t3 = new FileTReader("D:\\JAVA\\Tuan3\\text3.txt");
        t1.start();
        t2.start();
        t3.start();
    }
}
