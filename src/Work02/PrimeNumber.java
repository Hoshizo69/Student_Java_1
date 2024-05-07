package Work02;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tool pt = new PrimeTool();
        int input = sc.nextInt();
        int j = 10;
        for (int i = 0; i < input; j++) {
            for (;;){
                if (pt.judge(pt.change(j)) == true && pt.judge(j) ==true && pt.change(j) != j){
                    System.out.print(j+" ");
                    if ((i + 1) % 10 == 0) {
                        System.out.print("\n");
                    }
                    i++;
                }
                break;
            }
        }
        sc.close();
    }
}

interface Tool{
    int change(int a);
    Boolean judge(int b);
 }

class PrimeTool implements Tool{
    @Override
    public int change(int a) {
        int b = 0;
        for (;a>0;a /= 10){
            b = b * 10 + a % 10;
        }
        return b;
    }

    @Override
    public Boolean judge(int b) {
        int c = (int) Math.sqrt(b);
        Boolean flag = true;
        for (int i = 2; i <= c; i++) {
            if (b % i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}