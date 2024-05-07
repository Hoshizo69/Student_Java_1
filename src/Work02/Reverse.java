package Work02;

import java.util.Scanner;

public class Reverse {
    static int a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        reverse(input);
        sc.close();
    }
    public static void reverse(int number){
        if (number>0){
            a = a * 10 + number % 10;
            number /= 10;
            reverse(number);
        }else
            System.out.println(a);

    }
}
