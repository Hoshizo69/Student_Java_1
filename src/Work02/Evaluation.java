package Work02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Evaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float[] grade = new float[n];
        float sum = 0;
        for (int i = 0; i < n; i++) {
            grade[i] = sc.nextFloat();
        }
        ArrayList<Float> number = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            number.add(grade[i]);
        }
        Collections.sort(number);
        number.remove(0);
        number.remove(n-2);
        for (float i:number) {
            sum += i;
        }
        float ave = sum / (n - 2);
        System.out.println(String.format("average score:%.2f",ave));
        sc.close();
    }
}
