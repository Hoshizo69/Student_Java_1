package Work09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileReadAndWrite{

	public static void main(String[] args) {
		write(args);
		read("test.txt");

	}
	public static void read(String filename){
		try {
			FileReader reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			while (true){
				String str = br.readLine();
				if (str != null)
					System.out.println(str);
				else
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void write(String[] args) {

		try {
			FileWriter writer = new FileWriter("test.txt");
			BufferedWriter bw = new BufferedWriter(writer);
			for(int i=0;i<args.length;i++) {
				bw.write(args[i]+'\n');
			}
			
			bw.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}


