package Tuan1.Javacoban;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n");
        int n = sc.nextInt();
        int c = 0;
        for(int i = 0; i<=n; i++){
            c = c+i;
        }
        System.out.println("Tổng là: "+c);
        sc.close();
    }
}
