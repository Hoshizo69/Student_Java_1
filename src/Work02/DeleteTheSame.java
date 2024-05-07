package Work02;

import java.util.Scanner;

public class DeleteTheSame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        int[] num = new int[n];
        int k = 0;
        System.out.println("Enter n numbers: ");
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int[] newNum = new int[n];
        for (int i = 0; i < n; i++) {
            newNum[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            Boolean flag = true;
            for (int j = 0;j < k;j++){
                if (num[i] == newNum[j])
                    flag = false;
            }
            if (flag == true){
                newNum[k++] = num[i];
            }
        }
        System.out.println("The number of distinct values is "+k);
        for (int i = 0; i < k-1; i++) {
            System.out.print(newNum[i] + " ");
        }
        System.out.println(newNum[k-1]);
        sc.close();
    }
}
