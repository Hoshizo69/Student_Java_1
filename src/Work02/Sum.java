package Work02;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a positive integer:");
        int a = sc.nextInt();
        int s = 0;
        while (a > 0){
            s += a%10;
            a /= 10;
        }
        System.out.println("\nsum:"+s);
    }
}
