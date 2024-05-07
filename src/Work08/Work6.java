package Work08;

import java.util.Scanner;

public class Work6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		StringBuilder sb = new StringBuilder("");
		
		char current = str.charAt(0);
		int count = 1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == current)
				count ++;
			else {
				count--;
				if (count == 1)
					sb.append(current);
				else
					sb.append(current).append(count);
				current = str.charAt(i);
				count = 2;
			}
		}
		count--;
		if (count == 1) sb.append(current);
		else sb.append(current).append(count);
		
		System.out.println(sb.toString());
	}
}

