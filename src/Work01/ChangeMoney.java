package Work01;

import java.math.BigDecimal;
import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float simple = sc.nextFloat();
        int[] number = new int[5];
        float[] units = new float[]{100,25,10,5,1};
        number[0]= (int) simple;
        simple -= number[0];
        simple *= 100;
        for (int i = 1; i < 4; i++) {
            number[i]= (int) ((int) simple/units[i]);
            simple=simple % units[i];
        }
        BigDecimal bd=new BigDecimal((double) (simple / units[4]));
        bd=bd.setScale(0,4);
        number[4]=(int) bd.floatValue();
        System.out.println(number[0] + " dollars");
        System.out.println(number[1] + " quarters");
        System.out.println(number[2] + " dimes");
        System.out.println(number[3] + " nickels");
        System.out.print(number[4] + " pennies");
        System.out.println(String.format("%.3f",number[0]/3.0));
    }
}
