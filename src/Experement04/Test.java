package Experement04;

import  java.time.Instant;
import  java.time.LocalDateTime;
import  java.io.PrintStream;
import  java.io.UnsupportedEncodingException;
import  java.time.Clock;
import  java.time.Duration;
import  java.time.ZoneId;
import  java.time.temporal.ChronoUnit;
import  java.util.Scanner;
import  java.time.OffsetDateTime;
import  java.time.ZoneOffset;
import  java.util.Random;


/**
 *  类的继承
 *  1.计时器（秒表）类Timer，具有计时功能；
 *  2.Watch类是Timer的子类，除了能够计时外，还具备连续持续计时能力；
 *  3.Clock类是Watch的子类，能够设置定时闹铃的功能。
 *
 *  通过实验，需要学生掌握
 *  1.类的继承的特点
 *  1）继承父类的成员，增加自有的成员，覆盖父类的成员；
 *  2）根据可访问性的约束，子类有条件的访问父类的成员。
 *  2.java.time.*下的时间类的使用，java.util.Date和java.util.Calendar的联系
 *
 *  @author  gxw
 *
 */
public  class  Test  {
    public  static  void  main(String[]  args)  {
        System.out.println("testDisplay:");
        testDisplay();
        System.out.println("testDisplay2:");
        testDisplay2();
        System.out.println("testWatchStart:");
        testWatchStart();
        System.out.println("testClockAlarm:");
        testClockAlarm();
    }
    /**
     *  测试timer的打印功能
     */
    public  static  void  testDisplay()  {
        Timer  timer  =  new  Timer();
        timer.display();
        timer.init();
        timer.display();
        Instant  startInstant  =  Instant.now();
        timer.start(startInstant);
        timer.display();
        Instant  pauseInstant  =  startInstant.plusSeconds(1000);
        timer.pause(pauseInstant);
        timer.display();
        Instant  recoverInstant  =  pauseInstant.plusSeconds(5000);
        timer.recover(recoverInstant);
        timer.display();
        Instant  terminateInstant  =  recoverInstant.plusSeconds(2000);
        timer.terminate(terminateInstant);
        timer.display();
    }
    /**
     *  测试Timer类的display功能
     */
    public  static  void  testDisplay2()  {
        Timer  timer  =  new  Timer();
        timer.display();
        timer.init();
        timer.display();
        Instant  startInstant  =  Instant.now();
        timer.start(startInstant);
        timer.display();
        long  sum  =  0;
        for(int  i  =  0;  i  <  10000;  i++)  {
            sum  +=  i;
            doSomething();
            if(i  ==  1234)  {

                timer.pause();
                timer.display();
            }
            if(i  ==  2456)  {
                timer.recover();
                timer.display();
            }

        }
        timer.terminate();
        timer.display();
    }
    private  static  void  doSomething()  {
        int[]  numbers  =  new  int[1000];
        Random  random  =  new  Random();
        for  (int  i  =  0;  i  <  numbers.length;  i++)  {
            numbers[i]  =  random.nextInt();
        }
        for  (int  i  =  0;  i  <  numbers.length;  i++)  {
            for  (int  j  =  i  +  1;  j  <  numbers.length;  j++)  {
                if  (numbers[i]  >  numbers[j])  {
                    int  tmp;
                    tmp  =  numbers[i];
                    numbers[i]  =  numbers[j];
                    numbers[j]  =  tmp;
                }
            }
        }
    }
    /**
     *  测试Watch类的start功能
     */
    public  static  void  testWatchStart()  {
        Watch  watch  =  new  Watch();
        watch.setDateTime(2023,  2,  20,  0,  0,  0);
        watch.start();
    }
    /**
     *  测试Clock类的alarm功能
     */
    public  static  void  testClockAlarm()  {
        MyClock  myClock  =  new  MyClock();
        myClock.alarm();
        myClock.display();
        LocalDateTime  ldt  =LocalDateTime.now();
        myClock.setAlarmTime(ldt.getYear(),  ldt.getMonthValue(),  ldt.getDayOfMonth(),  ldt.getHour(),  ldt.getMinute(),  ldt.getSecond()  +  1);
        myClock.alarm();
    }
}

/**
 *  计时器类，提供计时服务
 *  1.连续计时；
 *  2.可中断的计时；
 *  3.计时器初始化；
 *  4.倒计时。
 *  @author  gxw
 *
 */
class  Timer  {
    private  Instant  referenceTime;//起始时间
    private  Instant  stopTime;//结束时间
    private  Granularity  granularity;//计时的颗粒度，以纳秒（1），毫秒（2），秒（3），分（4），小时（5），天（6）
    private  Duration  correctionTime;  //修正时间
    private  Status  status;//计时器状态，1表示计时中，2表示暂停，3表示终止，4表示计时就绪
    private  Instant  pauseTime;//暂停计时开始时间
    protected  PrintStream  out;
    protected  Scanner  in;

    {
        try  {
            out  =  new  PrintStream(System.out,true,"UTF-8");
        }  catch  (UnsupportedEncodingException  e)  {}
        in  =  new  Scanner(System.in,"UTF-8");
    }
    /**
     *  计时器的计时颗粒度
     *  @author  gxw
     *
     */
    enum  Granularity{
        NanoSecond,MilliSecond,Second,Minute,Hour,Day
    }
    /**
     *  计时器的状态
     *  @author  gxw
     *
     */
    enum  Status{
        Start,Pause,End,Ready
    }

    /**
     *  开始计时
     */
    public  void  start()  {
    //填写
        if (status.compareTo(Status.Start) != 0)
            out.println("请先初始化计时器后再开始计时。");

    }
    /**
     *  开始计时，仅当计时器状态为就绪时开始计时；否则提"请先初始化计时器后再开始计时。"
     *  @param  instant  开始时间
     */
    public  void  start(Instant  instant)  {
    //填写

    }
    /**
     *  终止计时
     */
    public  void  terminate()  {
    //填写


    }

    /**
     *  终止计时
     *  @param  instant  终止计时时间
     */
    public  void  terminate(Instant  instant)  {
    //填写

    }
    /**
     *  暂停计时
     */
    public  void  pause()  {
    //填写

    }
    /**
     *  暂停计时
     */
    public  void  pause(Instant  instant)  {
    //填写

    }
    /**
     *  恢复计时，如果correctionTime不为空，则累加上本次暂停的时间；否则保存本次暂停时间。
     */
    public  void  recover()  {
        //填写

    }
    /**
     *  恢复计时，如果correctionTime不为空，则累加上本次暂停的时间；否则保存本次暂停时间。
     */
    public  void  recover(Instant  instant)  {
    //填写


    }
    /**
     *  初始化计时器
     */
    public  void  init()  {
        correctionTime  =  null;
        this.referenceTime  =  null;
        this.granularity  =  Granularity.Second;
        this.pauseTime  =  null;
        this.status  =  Status.Ready;
        this.stopTime  =  null;
    }
    /**
     *  计时器显示
     */
    public  void  display()  {
        if(status  ==  null)  {
            out.println("请初始化计时器后再调用display方法。");
            return;
        }
        String  gName  =  "";
        if(granularity  !=  null)  {
            switch(granularity)  {
                case  NanoSecond:gName  =  "纳秒";break;
                case  MilliSecond:gName  =  "毫秒";break;
                case  Second:gName  =  "秒";break;
                case  Minute:gName  =  "分";break;
                case  Hour:gName  =  "小时";break;
                case  Day:gName  =  "天";break;
                default:
                    out.println("计时单位错误。");
                    break;
            }
        }
        LocalDateTime  rtLdt  =  null;
        if(referenceTime  !=  null)
            rtLdt  =  LocalDateTime.now(Clock.fixed(referenceTime,  ZoneId.of("Asia/Shanghai")));
        LocalDateTime  sLdt  =  null;
        //填写

    }
}


/**
 *  手表继承计时器类
 *  @author  gxw
 *
 */
class  Watch  extends  Timer  {
    private  Instant  reviseNow;//手表的校正时点
    private  Instant  sysNow;//手表校正时点时的系统时点
    private  Instant  currentNow;//手表当前的时点
    private  int  mode;//手表的工作模式，1表示手表处于日常计时模式，2表示手表处于秒表模式，3表示手表处于倒计时模式。
    /**
     *  静态初始化参数
     */
    {
        mode  =  1;
        reviseNow  =  Instant.now();
        sysNow  =  reviseNow;
        currentNow  =  reviseNow;
    }
    /**
     *  打印手表的信息
     *  覆盖父类Timer中的display
     */
    @Override
    public  void  display()  {
        //填写

    }
    /**
     *  设置时间，手表校正时间，需要记录校正时间时的系统当前的时间到sysNow中，以便于计时时计算偏离值。手表校正完成后就立刻进入计时。
     */
    public  void  setTime(int  hour,int  minute,int  second)  {
        //填写

    }
    /**
     *  设置日期，手表校正时间，需要记录校正时间时的系统当前的时间到sysNow中，以便于计时时计算偏离值。手表校正完成后就立刻进入计时。
     */
    public  void  setDate(int  year,int  month,int  day)  {
        //填写

    }
    /**
     *  设置时间日期，手表校正时间，需要记录校正时间时的系统当前的时间到sysNow中，以便于计时时计算偏离值。手表校正完成后就立刻进入计时。
     */
    public  void  setDateTime()  {
        reviseNow  =  Instant.now();
        sysNow  =  Instant.now();
    }
    /**
     *  设置时间日期，手表校正时间，需要记录校正时间时的系统当前的时间到sysNow中，以便于计时时计算偏离值。手表校正完成后就立刻进入计时。
     */
    public  void  setDateTime(int  year,int  month,int  day,int  hour,int  minute,int  second)  {
        setDate(year,month,day);
        setTime(hour,minute,second);
    }
    /**
     *  开始计时
     */
    public  void  start()  {
        //填写

    }
    /**
     *  获取当前的时间
     *  @return
     */
    public  Instant  getTime()  {
        Duration  duration  =  Duration.between(  sysNow,Instant.now());
        currentNow  =  reviseNow.plus(duration);
        return  currentNow;
    }
}

class  MyClock  extends  Watch  {
    private  Instant  alarmTime;//闹铃的时间
    private  boolean  status;//闹铃的状态，true表示设置了闹铃；false表示没有设置闹铃
    /**
     *  设置闹铃的时间
     *  如果闹铃的时间早于当前的时间，则提"闹铃时间不能比当前时间早。"并返回。
     *  否则则正常设置闹铃的时间。
     *  @param  instant  闹铃时间
     */
    public  void  setAlarmTime(Instant  instant)  {
        //填写

    }
    /**
     *  设置闹铃时间
     *  @param  year  年
     *  @param  month  月
     *  @param  day  日
     *  @param  hour  时
     *  @param  minute  分
     *  @param  second  秒
     */
    public  void  setAlarmTime(int  year,int  month,int  day,int  hour,int  minute,int  second)  {
        Instant  i  ;
        LocalDateTime  ldt  =  LocalDateTime.of(year,  month,day,hour,minute,second);
        i  =  ldt.toInstant(OffsetDateTime.now().getOffset());
        setAlarmTime(i);
    }
    /**
     *  获取闹铃的时间
     *  如果闹铃没有设置了，则提示"你还没有设置闹铃。"返回null；否则返回alarmTime
     *  @return
     */
    public  Instant  getAlarmTime()  {
        if(status)  {
            return  alarmTime;
        }
        else  {
            out.println("你还没有设置闹铃。");
            return  null;
        }

    }
    /**
     *  获取闹铃的时间字符串
     *  如果没有设置闹铃，则提示"你还没有设置闹铃。"并返回空字符串""
     *  否则，返回"yyyy-MM-dd  h:m:s"年月日时间的字符串，如"2023-02-20  10:08:15"
     *  @return
     */
    public  String  getAlarmTimeString()  {
        if(!status)  {
            out.println("你还没有设置闹铃。");
            return  "";
        }
        LocalDateTime  ldt  =LocalDateTime.ofInstant(alarmTime,ZoneId.of("Asia/Shanghai"));
        return  ldt.getYear()  +  "-"  +  ldt.getMonthValue()  +  "-"  +  ldt.getDayOfMonth()  +  "  "  +  ldt.getHour()  +  ":"  +  ldt.getMinute()  +  ":"  +  ldt.getSecond();
    }
    /**
     *  闹铃
     *  如果没有设置闹铃，则提示"你还没有设置闹铃。"并返回
     *  否则，持续监考等待闹铃时间到达，到达后提示"叮铃铃，时间到"
     */
    public  void  alarm()  {
        //填写

    }
}