package Tuan1.Javacoban;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập n: ");
        int n = sc.nextInt();
        int k = 0;
        for(int i = 2; i <n ; i++){
            if(n % i ==0){
                k++;
            }
        }
        if(k == 0){
            System.out.println(n+" là số nguyên tố");
        }
        else{
            System.out.println(n+" không phải số nguyên tố");
        }
        sc.close();

    }
}
