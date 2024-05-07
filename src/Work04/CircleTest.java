package Work04;

import java.util.Random;
import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SimpleCircle simpleCircle = new SimpleCircle(n);
        printArea(simpleCircle,n);
        sc.close();
    }

    public static void printArea(SimpleCircle myCircle,int n){
        for (int i = 0; i < n; i++) {
            myCircle.printArea(i);
        }
    }
}

class SimpleCircle{
    private int n;
    Random random = new Random();

    public SimpleCircle(int n) {
        this.n = n;
    }
    public void printArea(int n){
        System.out.println(String.format("Area is:%.2f",Math.PI * Math.pow(n + 1,2)));
    }
}