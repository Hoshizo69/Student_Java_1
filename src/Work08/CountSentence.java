package Work08;

import java.util.ArrayList;
import java.util.Scanner;

public class CountSentence {
    public static void main(String[] args) {
        System.out.println("Please enter a sentence:");
        Scanner sc = new Scanner(System.in);
        String mode = sc.nextLine();
        ArrayList<String> str = new ArrayList<String>();
        int[] count = new int[10];
        int countj = 0;
        for (int i = 0,j = 0; i < mode.length(); i++) {
            if (mode.charAt(i)==' ' || mode.charAt(i)=='.' || mode.charAt(i)=='?' || mode.charAt(i)=='!'||i == mode.length() - 1){
                int flag = -1;
                for (int k = 0; k < str.size(); k++) {
                    if (mode.substring(j, i).equals(str.get(k))) {
                        flag = str.indexOf(str.get(k));
                        count[flag]++;
                        j = i + 1;
                        break;
                    }
                }
                if (flag == -1){
                    if (i == mode.length() - 1)
                        str.add(mode.substring(j, i + 1));
                    else
                        str.add(mode.substring(j, i));
                    count[countj]++;
                    countj++;
                    j = i + 1;
                }
            }
        }
        System.out.println("The words in this sentence are:");
        for (String s:str
             ) {
            System.out.print(s+";");
        }
        System.out.println();
        System.out.println("The number of times the words appear are as follows:");
        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i) + " occurs " + count[i] + " times ");
        }
        sc.close();
    }


}
