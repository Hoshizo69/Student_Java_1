package Work02;

import java.util.Scanner;

public class Pai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a number(10000-100000):");
        int n = sc.nextInt();
        if (n < 10000 || n >100000) {
            System.out.println("The input data is out of range!");
            System.exit(0);
        }
        double pi = 0;
        for (int i = 1; i <= n; i++) {
            pi = pi + 1.0 / (2 * i - 1)*Math.pow(-1,i - 1);
        }
        System.out.println("PI="+4 * pi);
        sc.close();
    }
}
