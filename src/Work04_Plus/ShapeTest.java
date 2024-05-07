package Work04_Plus;

public class ShapeTest {

	public static void main(String[] args) {

		Rectangle r = new Rectangle();
		System.out.println(r.area()+","+r.perimeter());
		Circle c = new Circle();
		System.out.println(c.area()+","+c.perimeter());	
		
		Shapes s = r;
		s = c;

		r = new Rectangle(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
		System.out.println(r.area()+","+r.perimeter());	
		
		c = new Circle(Double.parseDouble(args[2]));
		System.out.println(c.area()+","+c.perimeter());	
		
	}

}

class Shapes{
	double area() {
		return 0;
	}
	
	double perimeter() {
		return 0;
	}
}
class Rectangle extends  Shapes{
	private double longNumber = 1 , wideNumber = 1;

	public Rectangle() {
	}

	public Rectangle(double longNumber, double wideNumber) {
		this.longNumber = longNumber;
		this.wideNumber = wideNumber;
	}

	@Override
	double perimeter() {
		return (longNumber + wideNumber) * 2;
	}

	@Override
	double area() {
		return longNumber * wideNumber;
	}
}


class Circle extends Shapes{
	private double r = 1;

	public Circle() {
	}

	public Circle(double r) {
		this.r = r;
	}

	@Override
	double area() {
		return Math.PI * Math.pow(r,2);
	}

	@Override
	double perimeter() {
		return Math.PI * r * 2;
	}
}




