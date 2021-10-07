package Tuan1.Javacoban;

import java.util.Scanner;

/**
 * Bai1
 */
public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi ký tự: ");
        String chuoi = sc.nextLine();
        System.out.println("Ký tự hoa:"+chuoi.toUpperCase());
        sc.close();
    }
}
