package Tuan1.Javacoban;

import java.util.Scanner;
public class Bai5 {
    public static void main(String[] args) {
        int n;
        Float sum = (float) 0;
        Scanner scanner = new Scanner(System.in);
         
        do {
            System.out.print("Nhập n: ");
            n = (int) scanner.nextFloat();
        } while (n < 0);
        Float array[] = new Float[n];
        for (int i = 0; i < n; i++) {
            System.out.print("nhập số: ");
            array[i] = scanner.nextFloat();
        }
        for (int i = 0; i < n; i++) {
            if(array[i] > 0){
                sum += array[i];
            }else{
                sum = sum + 0;
            }
            
        }
        System.out.println("Tổng = " + sum);
        scanner.close();

    }
}
