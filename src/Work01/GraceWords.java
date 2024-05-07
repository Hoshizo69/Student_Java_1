package Work01;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;


public class GraceWords {
    public static void main(String[] args) throws UnsupportedEncodingException {
        PrintStream output = new PrintStream(System.out,true,"UTF-8");
        output.println("Greek alphabet:");
        int startInt,endInt;
        char cStart,cEnd;
        cStart='α';
        cEnd='π';
        startInt=cStart;
        endInt=cEnd;
        for (int i = startInt; i < endInt; i++) {
            char c;
            c = (char) i;
            output.print(c+" ");
            if (i-startInt==9)
                output.print('\n');
        }
        output.print((char) endInt);
    }
}
