package Work02;

import java.util.Scanner;

public class SwitchPlus {
    public static void main(String[] args) {
        System.out.print("score:");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        if (score>100||score<0){
            System.out.println("input error");
            System.exit(0);
        }
        int grade = score / 10;
        System.out.print("grade:");
        switch (grade){
            case 10:
            case 9:
                System.out.println("very good");
                break;
            case 8:
                System.out.println("good");
                break;
            case 7:
                System.out.println("medium");
                break;
            case 6:
                System.out.println("pass");
                break;
            default:
                System.out.println("not pass");
                break;
        }
        sc.close();
    }
}
