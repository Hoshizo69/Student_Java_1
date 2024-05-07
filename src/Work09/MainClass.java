package Work09;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MainClass
{

	public static void write(String[] args,String fileName) {				
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
			
			for(String str:args) {
				out.writeInt(Integer.valueOf(str));
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//public static void read(String fileName)
        public static void read(String fileName){
        		try {
        			DataInputStream in = new DataInputStream(new FileInputStream(fileName));
        			 int b;
        			 int sum = 0;
        			 while (true){
        				 b = in.read();
        				 if (b != -1)
        					 sum += b;
        				 else
        					 break;
        			 }
        			System.out.println("The sum is:" + sum);
        			in.close();
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        	}

	public static void main(String[] args) {
		write(args,"test.dat");
		read("test.dat");

	}
}

