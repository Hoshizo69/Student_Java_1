package Work04;

public class Findareas{
    public static void main (String []agrs){
        Figure f= new Figure(Double.parseDouble(agrs[0]) , Double.parseDouble(agrs[1]) );
        Rectangle r= new Rectangle(Double.parseDouble(agrs[2])  , Double.parseDouble(agrs[3]) );
        Figure figref;
        figref=f;
        System.out.println("Area is :"+figref.area());
        figref=r;
        System.out.println("Area is :"+figref.area());
    }
}

class Figure{
    private double parseDouble,parseDouble1;

    public Figure(double parseDouble, double parseDouble1) {
        this.parseDouble = parseDouble;
        this.parseDouble1 = parseDouble1;
    }

    public String area() {
        System.out.println("Inside area for figure.");
        return String.format("%.1f",parseDouble*parseDouble1);
    }
}

class Rectangle extends Figure{
    private double parseDouble,parseDouble1;
    public Rectangle(double parseDouble, double parseDouble1) {
        super(parseDouble,parseDouble1);
        this.parseDouble = parseDouble;
        this.parseDouble1 = parseDouble1;
    }

    @Override
    public String area() {
        System.out.println("Inside area for rectangle.");
        return String.format("%.1f",parseDouble*parseDouble1);
    }
}


