package Work03;

import  java.io.PrintStream;
import  java.io.UnsupportedEncodingException;
import  java.time.Instant;
import  java.util.Date;
import  java.util.Scanner;

import  java.time.temporal.ChronoUnit;

public  class  TeaDemo  {
    private  static  Scanner  input;
    private  static  PrintStream  out;
    static  {
        input  =  new  Scanner(System.in,"UTF-8");
        try  {
            out  =  new  PrintStream(System.out,false,"UTF-8");
        }  catch  (UnsupportedEncodingException  e)  {
            //  TODO  Auto-generated  catch  block
            e.printStackTrace();
        }
    }
    public  static  void  main(String[]  args)  {
        //  TODO  Auto-generated  method  stub
        String  msg  =  "-----------\n";
        msg  +=  "testConstruction测试"  +  (testConstruction()  ?  "通过"  :  "不通过")  +  "\n";
        msg  +=  "testSetter测试"  +  (testSetter()  ?  "通过"  :  "不通过")  +  "\n";
        out.println(msg);
    }

    public  static  boolean  testConstruction()  {
        boolean  bRtn1  =  false;
        Tea  mingqianlongjing  =  new  Tea();
        String  answer  =  "南湖龙井的GREENTEA生产于Sun  Dec  03  10:15:30  GMT  2023售价108.66保质期180天请在Fri  May  31  10:15:30  GMT  2024前饮用。";
        if(answer.equals(mingqianlongjing.toString()))
            bRtn1  =  true;
        boolean  bRtn2  =  false;
        mingqianlongjing  =  new  Tea(2,  Date.from(Instant.parse("2021-12-03T10:15:30Z")),  30,  "茶到人生",  123.45);
        answer  =  "茶到人生的OOLONGTEA生产于Fri  Dec  03  10:15:30  GMT  2021售价123.45保质期30天请在Sun  Jan  02  10:15:30  GMT  2022前饮用。";
        if(answer.equals(mingqianlongjing.toString()))  {
            bRtn2  =  true;
        }
        return  bRtn1  &&  bRtn2;
    }

    public  static  boolean  testSetter()  {
        boolean  bRtn1  =  false;
        Tea  tieguanyin  =  new  Tea();
        tieguanyin.setType(12);
        String  answer  =  "南湖龙井的GREENTEA生产于Sun  Dec  03  10:15:30  GMT  2023售价108.66保质期180天请在Fri  May  31  10:15:30  GMT  2024前饮用。";

        if(answer.equals(tieguanyin.toString()))
            bRtn1  =  true;

        boolean  bRtn2  =  false;
        tieguanyin.setType(1);;
        answer  =  "南湖龙井的BLACKTEA生产于Sun  Dec  03  10:15:30  GMT  2023售价108.66保质期180天请在Fri  May  31  10:15:30  GMT  2024前饮用。";

        if(answer.equals(tieguanyin.toString()))  {
            bRtn2  =  true;
        }

        boolean  bRtn3  =  false;
        tieguanyin.setPrice(-128);
        if(answer.equals(tieguanyin.toString()))  {
            bRtn3  =  true;
        }

        boolean  bRtn4  =  false;
        tieguanyin.setExpirationDay(-28);;
        if(answer.equals(tieguanyin.toString()))  {
            bRtn4  =  true;
        }
        return  bRtn1  &&  bRtn2  &&  bRtn3  &&  bRtn4;
    }

}




class  Tea  {
    private int teaType;
    private Date date;
    private long day;
    private String brand;
    private double price;

    public Tea(int i, Date from, int i1, String s, double v) {
        this.teaType = i;
        this.date = from;
        this.day = i1;
        this.brand = s;
        this.price = v;
    }

    public Tea() {
        this.teaType = 0;
        this.price = 108.66;
        this.brand = "南湖龙井";
        this.date = Date.from(Instant.parse("2023-12-03T10:15:30Z"));
    }

    public void setExpirationDay(int i) {//生产日期
    }

    public void setPrice(int i) {
    }

    public void setType(int i) {
    }
    public String toString(){
        String s = null;
      return s;
    }
}