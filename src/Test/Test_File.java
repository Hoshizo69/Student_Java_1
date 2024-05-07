package Test;

import java.io.FileWriter;
import java.io.IOException;

public class Test_File {
    public static void main(String[ ] args) throws IOException {

    String str = "Hello World";

    FileWriter fw = null;

    try {

        fw = new FileWriter("c:\\hello.txt"); // 1

        fw.write(str);                     // 2

    } catch (IOException e) {

        e.printStackTrace();               // 3

    } finally {

        fw.close();                        // 4

    }

}

}
