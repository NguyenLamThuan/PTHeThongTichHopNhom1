package Tuan3;

import java.io.BufferedWriter;
import java.io.FileWriter;
public class FileTWriter implements Runnable{
    String fileName;
    public String getFileName(){
        return getFileName();
    }
    public void setFileNamer(String fileName){
        this.fileName = fileName;
    }
    public FileTWriter(String fileName){
        this.fileName = fileName;
    }
    public void run(){
        try{
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter buffer = new BufferedWriter(writer);
            for(int i=0; i<10; i++){
                int rand = (int) (Math.random()*10);
                buffer.write(rand + "\t");
            }
            buffer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception{
        
        Thread t1 = new Thread(new FileTWriter("text1.txt"));
        Thread t2 = new Thread(new FileTWriter("text2.txt"));
        Thread t3 = new Thread(new FileTWriter("text3.txt"));
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Done");
    }
}