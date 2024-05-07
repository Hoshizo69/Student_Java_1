package Work03;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
public class ProductDemo {
    private static Scanner input;
    private static PrintStream out;
    static {
        input = new Scanner(System.in,"UTF-8");
        try {
            out = new PrintStream(System.out,false,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String msg = "-----------\n";
        msg += "testProductID测试" + (testProductID() ? "通过" : "不通过") + "\n";
        msg += "testDateInProduced测试" + (testDateInProduced() ? "通过" : "不通过") + "\n";
        msg += "testProductToString测试" + (testProductToString() ? "通过" : "不通过") + "\n";
        msg += "testProduct测试" + (testProduct() ? "通过" : "不通过") + "\n";
        out.println(msg);
    }
    private static boolean testProductID() {
        boolean bRtn1 = false;
        Product pen = new Product();
        String sId = "1234567890123";
        pen.setId(sId);
        if(pen.getId().equals(sId))
            bRtn1 = true;
        boolean bRtn2 = false;
        sId = "123456789012";
        pen.setId(sId);
        if(!pen.getId().equals(sId))
            bRtn2 = true;//f
        boolean bRtn3 = false;
        sId = "123456789012a";
        pen.setId(sId);
        if(!pen.getId().equals(sId))
            bRtn3 = true;//f
        return bRtn1 && bRtn2 && bRtn3;
    }
    private static boolean testDateInProduced() {
        //完成下面代码实现，模仿testProductID方法对MyDate日期类进行测试
        //1.测试一个正常日期初始化MyDate对象，并检查该对象的toString方法得到的日期是否是我们期望的；
        //2.测试一个年份小于或大于规定年份的日期，创建MyDate对象；
        //3.测试一个月份不在要求范围的日期，创建MyDate对象；
        //4.测试一个日不在要求范围的日期，创建MyDate对象；
        boolean bTime1 = false;
        MyDate date1 = new MyDate(1971,6,6,6,6,6);
        if (date1.toString().equals("1971年6月6日 6:6:6"))
            bTime1 =true;//f
        boolean bTIme2 = false;
        MyDate date2 = new MyDate(1666,6,6);
        if (date2.toString().equals("1666年6月6日"))
            bTIme2 = true;
        boolean bTime3 = false;
        MyDate date3 = new MyDate(1971,13,6);
        if (date3.toString().equals("1971年13月6日"))
            bTime3 = true;
        boolean bTime4 = false;
        MyDate date4 = new MyDate(1971,6,120);
        if (date4.toString().equals("1971年6月120日"))
            bTime4 = true;
        return bTime3 && bTIme2 && bTime1 && bTime4;

    }
    private static boolean testProductToString() {
        //完成下面代码实现，模仿testProductID方法对产品的toString方法进行测试
        boolean tStr1 = false;
        MyDate date1 = new MyDate(2023,5,17);
        Product product1 = new Product("0000000000001","龙芯一号","000001",1,date1);
        if (product1.toString().equals("龙芯一号\t\tCPU\t\t2023年5月17日\t出厂检验合格")){
            tStr1 = true;
            product1.Print();
        }
        boolean sStr2 = false;
        MyDate date2 = new MyDate(2023,5,30);
        Product product2 = new Product("0000000000001","龙芯一号","000001",1,date2);
        if (!product2.toString().equals("龙芯一号        CPU      2023年5月17日 出厂检验合格"))
            sStr2 = true;
        return sStr2 && tStr1;

    }
    private static boolean testProduct() {
        //完成下面代码实现，模仿testProductID方法对产品的其他方法进行测试
        boolean test = false;
        MyDate date = new MyDate(2023,5,10);
        Product product = new Product("0000000000001","龙芯一号","000001",10,date);
        if (!product.toString().equals("龙芯一号        CPU      2023年5月17日 出厂检验合格"))
            test = true;
        return test;

    }
}
/**
 *提示：
 *	private String id;//与业务无关的id
 *	private String name;//产品名称
 *	private String pid;//产品编号，6位产品编号000001到000009分别表示CPU、主板、内存、显卡、网卡、键盘、鼠标、机箱、电源
 *	private MyDate dateInProduced;//生产日期
 *	private int status;//产品的状态,-1表示产品不可用（默认值），0表示生产中，1表示出厂检验合格，2表示出厂检验不合格，
 *						//3表示报废中，4表示已经报废，5表示产品已销售，
 *						//6表示产品已经返厂维修，其他数值无效
 */
class Product{
    private String id;
    private String name;
    private String pid;
    private int status;
    private  MyDate  dateInProduced;
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

    public Product() {
    }

    public Product(String id, String name, String pid, int status, MyDate dateInProduced) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.status = status;
        this.dateInProduced = dateInProduced;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public MyDate getDateInProduced() {
        return dateInProduced;
    }
    public boolean judge(String s){
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0')
                flag = false;
        }
        return flag;
    }

    public void setId(String sId) {
        if (sId.length() != 13 || judge(sId))
            out.println("产品的无业务无关的id必须是13位数字组成的字符串。");
        if (this.id == null)
            this.id = sId;
    }

    public String getId() {
        return id;
    }
    public String toString(){
        String str = "";
        str += name+"\t\t";
        switch (pid){
            case "000001":str += "CPU\t\t";
                break;
            case "000002":str += "主板\t\t";
                break;
            case "000003":str += "内存\t\t";
                break;
            case "000004":str += "显卡\t\t";
                break;
            case "000005":str += "网卡\t\t";
                break;
            case "000006":str += "键盘\t\t";
                break;
            case "000007":str += "鼠标\t\t";
                break;
            case "000008":str += "机箱\t\t";
                break;
            default:str += "电源\t\t";
                break;
        }
        str += dateInProduced.toString()+"\t";
        switch (status){
            case 0:str += "生产中";
                break;
            case 1:str += "出厂检验合格";
                break;
            case 2:str += "出厂检验不合格";
                break;
            case 3:str += "报废中";
                break;
            case 4:str += "已经报废";
                break;
            case 5:str += "已销售";
                break;
            case 6:str += "已返厂维修";
                break;
            case -1:str += "产品不可用";
            default:out.println("产品状态信息参数异常，请检查。");
                break;
        }
        return str;
    }
    public void Print(){
        out.println("产品名称\t\t产品类型\t\t生成时间\t\t产品状态");
        out.println(this+"\n");
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private boolean isOnlyYMD;

    private static Scanner input;
    private static PrintStream out;
    static {
        input = new Scanner(System.in,"UTF-8");
        try {
            out = new PrintStream(System.out,false,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public MyDate(int year, int month, int day, int hour, int minute, int second) {
        super();
        setYear(year);
        setMonth(month);
        setDay(day);
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        isOnlyYMD = false;
    }
    public MyDate() {
        super();
        // TODO Auto-generated constructor stub
    }
    public MyDate(int year, int month, int day) {
        super();
        setYear(year);
        setMonth(month);
        setDay(day);
        isOnlyYMD = true;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if(year < 1970 || year > 2023) {
            out.println("你输入的年份无法通过数据验证，请检查。年份必须介于[1970,2023]");
        }
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        if(month < 1 || month > 12) {
            out.println("你输入的月份无法通过数据验证，请检查。月份必须介于[1,12]");
        }
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        if(day < 1 || day > 31) {
            out.println("你输入的日无法通过数据验证，请检查。日必须介于[1,31]");
        }
        this.day = day;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        if(hour < 1 || hour > 24) {
            out.println("你输入的时无法通过数据验证，请检查。时必须介于[1,24]");
        }
        isOnlyYMD = false;
        this.hour = hour;
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        if(minute < 1 || minute > 60) {
            out.println("你输入的分无法通过数据验证，请检查。分必须介于[1,60]");
        }
        isOnlyYMD = false;
        this.minute = minute;
    }
    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        if(second < 1 || second > 60) {
            out.println("你输入的秒无法通过数据验证，请检查。秒必须介于[1,60]");
        }
        isOnlyYMD = false;
        this.second = second;
    }
    @Override
    public String toString() {
        String sRtn = "";
        sRtn = year + "年" + month + "月" + day + "日";
        if(!isOnlyYMD) {
            sRtn += " " + hour + ":" + minute + ":" + second;
        }
        return sRtn;
    }




}

