package Work01;

import java.util.Scanner;

public class Simulation {
    public static void main(String[] args) {
        System.out.print("Please input the number of particle:");
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble();
        double sum;
        sum=3.39E8*3600.0/a;
        System.out.println("\nNumber of operations is:"+sum);
        sc.close();
    }
}
