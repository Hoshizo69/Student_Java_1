package Work02;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public  class  StudentDemo  {

    public  static  void  main(String[]  args) throws UnsupportedEncodingException {
        test01();
        test02();
        test03();
    }

    public  static    void  test01(){
        Student  zhangsan  =  new  Student();
        zhangsan.setSno("20230523875201");
        zhangsan.setName("张三");
        zhangsan.setCredit(56.73);
        zhangsan.listen("你好，你是谁？");
        zhangsan.say();
        zhangsan.read("忆江南  白居易  江南好，风景旧曾谙。日出江花红胜火，春来江水绿如蓝。能不忆江南？");
        zhangsan.write("贵有恒何必三更眠五更起，最无益只怕一日曝十日寒。");
        zhangsan.display();
    }
    /**
     *  本方法使用构造方法初始化lisi对象，然后依次调用listen、say、read、write、display方法，
     *  看看输出是否与你预想的一致
     */
    public  static    void  test02(){
//  TODO  完成test02
        Student  lisi  =  new  Student();
        lisi.setSno("20230523875202");
        lisi.setName("李四");
        lisi.setCredit(72.38);
        lisi.listen("你好，你是谁？");
        lisi.say();
        lisi.read("王维《鹿柴》：空山不见人，但闻人语响。返景入深林，复照青苔上。");
        lisi.write("诗书勤乃有，不勤腹空虚。 ——韩愈");
        lisi.display();
    }
    /**
     *  本方法使用构造方法初始化mike对象，在用setNationality方法设置国籍，
     *  然后依次调用listen、say、read、write、display方法，
     *  看看输出是否与你预想的一致
     *  对比和体会初始化块的作用和构造方法的作用
     */
    public  static    void  test03(){
        //  TODO  完成test03
        Student mike = new Student();
        mike.setSno("20230523875203");
        mike.setName("mike");
        mike.setCredit(64.85);
        mike.setNation("America");
        mike.listen("你好，你是谁？");
        mike.say();
        mike.read("cease to struggle and you cease to live.");
        mike.write("You are not strong,no one brave for you.");
        mike.display();
    }

}
/**
 *  学生类Student
 *  @author  XXX
 *
 */
class Student{
    private String name;
    private String sno;
    private double credit;
    private final PrintStream output;
    private String nation;

    {
        this.nation = "中国";
        try {
            output = new PrintStream(System.out,true,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setSno(String s) {
        this.sno = s;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void listen(String s) {
        output.println("我听到了\""+s+"\"");
    }

    public void say() {
        output.println("大家好，我是"+name+"来自"+nation);
    }

    public void read(String s) {
        output.println("阅读改变人生，今天我要读的是\"" + s + "\"");
    }

    public void write(String s) {
        output.println("记录我们美好的回忆，今天我要记录的是\"" + s +"\"");
    }

    public void display()  {
        output.println("学号\t" + sno);
        output.println("姓名\t" + name);
        output.println("学分\t" + credit);
        output.println("国籍\t" + nation);
    }
}