package Work02;

import  java.io.PrintStream;
import  java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import  java.util.Scanner;

public  class  TriangleDemo  {

    public  static  void  main(String[]  args)  throws  UnsupportedEncodingException  {
        //  TODO  Auto-generated  method  stub
        Scanner  input  =  new  Scanner(System.in,"UTF-8");
        PrintStream  out  =  new  PrintStream(System.out,false,"UTF-8");
        out.println("请输入三角形的三个顶点坐标：");
        double[]  coord  =  new  double[6];
        //  TODO  接受控制台输入顶点的坐标的横纵坐标存放在coord数组中，请补全代码。
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0)
                out.print("第" + i / 2 + "个顶点的横坐标是:");
            else
                out.print("第" + i / 2 + "个顶点的纵坐标是:");
            coord[i] = input.nextDouble();
        }

        Point  p1  =  new  Point(coord[0],coord[1]);
        Point  p2  =  new  Point(coord[2],coord[3]);
        Point  p3  =  new  Point(coord[4],coord[5]);
        Triangle  t  =  new  Triangle(p1,p2,p3);
        if(t.isTriangle())  {
            out.println("三角形的周长是："  +  t.perimeter());
            out.println("三角形的面积是："  +  t.area());
        }
        else
            out.println("这三个点无法组成三角形。");

    }

}

class  Point  {
    private  double  x;
    private  double  y;
    public  Point(double  x,  double  y)  {
        super();
        this.x  =  x;
        this.y  =  y;
    }

    public  double  getX()  {
        return  x;
    }

    public  double  getY()  {
        return  y;
    }

    //  TODO  此处缺少一个方法，请根据上下文补全代码
    public double distance(Point point){
        return Math.sqrt((Math.pow(x - point.x,2))+(Math.pow(y - point.y,2)));
    }
}

class  Triangle  {
    private  Point  p1;
    private  Point  p2;
    private  Point  p3;
    public  Triangle()  {
        super();
    }
    public  Triangle(Point  p1,  Point  p2,  Point  p3)  {
        super();
        //  TODO  补全代码
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    public  boolean  isTriangle()  {
        double  side1;
        double  side2;
        double  side3;
        side1  =  p1.distance(p2);
        side2  =  p1.distance(p3);
        side3  =  p2.distance(p3);
        if(side2 < side1 + side3 && side1 < side2 + side3 && side3 < side1 + side2
        )  {
            //  TODO  补全代码
            return  true;
        }
        return  false;
    }
    /**
     *  三角形的周长
     *  @return  如果不能组成三角形则返回-1
     *                          如果可以组成三角形则返回三角形周长
     */
    public  double  perimeter()  {
            double a1,a2,a3;
            BigDecimal side1,side2,side3;
            a1 = p1.distance(p2);
            a2 = p3.distance(p2);
            a3 = p1.distance(p3);
            if (!isTriangle()){
                return -1;
            }else{
                side1 = BigDecimal.valueOf(a1);
                side2 = BigDecimal.valueOf(a2);
                side3 = BigDecimal.valueOf(a3);
            }
            return side1.add(side2.add(side3)).doubleValue();
    }
    /**
     *  三角形的面积
     *
     *  @return    如果不能组成三角形，则返回-1；
     *                          如果可以组成三角形，则用海伦公式计算三角形的面积
     */
    public  double  area()  {
        double p ;
        if (!isTriangle()){
            return -1;
        }else
            p = (p1.distance(p2) + p1.distance(p3) + p2.distance(p3))/2;
        return Math.sqrt(p * (p - p2.distance(p3)) * (p - p1.distance(p2)) * (p - p1.distance(p3)));
    }
}