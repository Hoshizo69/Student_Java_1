package Work1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileClass {
    public static void main(String[] args) throws IOException {
        File file = new File("oplog.txt");
        file.createNewFile();
        OutputStream outputStream = new FileOutputStream(file);
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        String mode;
        while (sc.hasNext()){
            mode = sc.nextLine();
            int flag = 0;
            for (int i = 0; i < mode.length(); i++) {
                if (mode.charAt(i) == '#') {
                    mode = mode.substring(0,i);
                    flag = 1;
                    break;
                }
            }
            arrayList.add(mode);
            if (flag == 1)
                break;
        }
        for (String str:arrayList
             ) {
            byte[] b = str.getBytes();
            for (byte value : b) {
                outputStream.write(value);
            }
            outputStream.write('\n');
        }
        sc.close();
        outputStream.close();
    }
}

