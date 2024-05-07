package Test;

public class Test1_Child extends Test1_Father{
    @Override
    public void say() {
        System.out.println("I'm child");;
    }

    @Override
    public int addValue(int a, int b) {
        return a*b;
    }
    public int addValue(int a,int b,int c){
        return  a*b*c;
    }
}
