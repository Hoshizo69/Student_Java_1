package Test;
import  java.io.PrintStream;
import  java.io.UnsupportedEncodingException;

public class Test1_Print {
    public  static  void  main(String[]  args)  {
        //  TODO  Auto-generated  method  stub
        Printer  p=new  Printer();
        p.brand="HP";
        p.status=1;
        p.printedWords=0;
        p.print();
        p.print("我和我的祖国");
        p.print("我和我的祖国一刻也不能分割。" +
                "无论我走到哪里都流出一首赞歌。"  +
                "我歌唱每一座高山我歌唱每一条河，"  +
                "袅袅炊烟小小村落路上一道辙，"  +
                "你用你那母亲的脉搏和我诉说。"  +
                "我的祖国和我像海和浪花一朵，"  +
                "浪是海的赤子海是那浪的依托，"  +
                "每当大海在微笑我就是笑的旋涡。"  +
                "我分担着海的忧愁分享海的欢乐，"  +
                "永远给我碧浪清波心中的歌，"  +
                "啦啦…永远给我碧浪清波心中的歌。");
    }
}
class  Printer {
    final int lineMaxWords = 20;
    PrintStream out;

    {
        try {
            out = new PrintStream(System.out, false, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //  TODO  Auto-generated  catch  block
            e.printStackTrace();
        }
    }

    int status;
    String brand;
    int printedWords;

    /**
     * 向控制台输出回车符
     */
    void carriageReturn() {
        //添加处理代码
        out.println("\r");
    }

    /**
     * 向控制台输出换行符
     */
    void newLine() {
        //添加处理代码
        out.print("\n");
    }

    /**
     * 向控制台输入字符  如果当前行已经达到最大输出字符数-1，则输出后进行回车换行，当前行输入字符数清0；否则输出字符，当前行输入字符数加1
     */
    void print() {
        //添加处理代码
        if (printedWords == lineMaxWords - 1) {
            out.print('A');
            carriageReturn();
            newLine();
            printedWords = 0;
        } else {
            out.print('A');
            printedWords++;
        }
    }
    /**
     * 从字符s中取出单个字符输出  如果当前行已经达到最大输出字符数-1，则输出后进行回车换行，当前行输入字符数清0；否则输出字符，当前行输入字符数加1
     */
    void  print(String  s) {
        //添加处理代码
        for (int i = 0; i < s.length(); i++) {
            if (printedWords == lineMaxWords - 1) {
                out.print(s.charAt(i));
                carriageReturn();
                newLine();
                printedWords = 0;
            } else {
                out.print(s.charAt(i));
                printedWords = printedWords + 1;
            }
        }
    }
}
