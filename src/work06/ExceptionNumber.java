package work06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a radius:");
        if (sc.hasNextDouble()){
            double r = sc.nextDouble();
            double area = Math.PI * Math .pow(r,2);
            System.out.println(String.format("area=%.2f",area));
        }else {
            System.out.println("java.util.InputMismatchException");
            System.out.print("Number Format Error.");
        }
    }

}
