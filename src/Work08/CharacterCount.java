package Work08;

import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Character character ;
        int[] num = new int[4];
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)))
                num[0]++;
            else if (Character.isWhitespace(str.charAt(i))) {
                num[1]++;
            } else if (Character.isDigit(str.charAt(i))) {
                num[2]++;
            }else
                num[3]++;
        }
        System.out.println("The number of letter is:" + num[0]);
        System.out.println("The number of space is:" + num[1]);
        System.out.println("The number of number is:" + num[2]);
        System.out.println("The number of other character is:" + num[3]);
        sc.close();
    }
}
