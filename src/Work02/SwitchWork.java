package Work02;

import java.util.Scanner;

public class SwitchWork {
    public static void main(String[] args) {
        System.out.print("Input a score:");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        if (score>100||score<0){
            System.out.println("Illegal input, please try again.");
            System.exit(0);
        }
        int grade = score / 10;
        System.out.print("The grade is ");
        switch (grade){
            case 10:
            case 9:
                System.out.println("Very good.");
                break;
            case 8:
                System.out.println("Good.");
                break;
            case 7:
                System.out.println("Medium.");
                break;
            case 6:
                System.out.println("Pass.");
                break;
            default:
                System.out.println("Not passed.");
                break;
        }
        sc.close();
    }
}
