package Work01;

import java.util.Scanner;

public class ChangeTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double hua = sc.nextDouble();
        double she = (hua-32)*5/9;
        sc.close();
        System.out.println(String.format("Celsius is:%.1f",she));
    }
}
