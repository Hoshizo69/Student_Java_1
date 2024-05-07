package Work02;

import java.util.Scanner;

public class ReUse {
    public static void main(String[] args) {
        Function f = new Function();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a int number a:");
        int a = sc.nextInt();
        System.out.println("invoke int cube()\nCube of a is:"+f.cube(a));
        System.out.println("Please input a float number b:");
        float b = sc.nextFloat();
        System.out.println("invoke float cube()\nCube of b is:"+String.format("%.2f",f.cube(b)));
        System.out.println("Please input a double number c:");
        double c = sc.nextDouble();
        System.out.println("invoke double cube()\nCube of c is:"+String.format("%.4f",f.cube(c)));
        sc.close();
    }
}

class Function{
    public int cube(int a){
        return (int)Math.pow(a,3);
    }
    public float cube(float a){
        return (float) Math.pow(a,3);
    }
    public double cube(double a){
        return Math.pow(a,3);
    }
}
