package Work01;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double l = sc.nextDouble();
        double w = sc.nextDouble();
        double s = l * w;
        System.out.print(String.format("The area is:%.2f",s));
        sc.close();
    }
}
