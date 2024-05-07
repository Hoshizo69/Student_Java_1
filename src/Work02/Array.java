package Work02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        System.out.print("Please input the length of array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.printf("\nPlease input %d Integer: %n",n);
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            num.add(sc.nextInt());
        }
        Collections.sort(num);
        System.out.println("The sorted result of array is:");
        for (int i:num) {
            System.out.print(i+"  ");
        }
        sc.close();
    }
}
