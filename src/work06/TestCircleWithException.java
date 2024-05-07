package work06;

import java.util.*;
public class TestCircleWithException {
  public static void main(String[] args) {
	  Scanner in = new Scanner(System.in);
	  int radius = in.nextInt();
	  CircleWithException circle = new CircleWithException(radius);
  }
}

class CircleWithException {
	  private double radius;

	  public CircleWithException(double newRadius) {
	    setRadius(newRadius);
	  }

	  public double getRadius() {
	    return radius;
	  }

	  public void setRadius(double newRadius)
	      throws IllegalArgumentException {
	      if (newRadius >= 0) {
			  this.radius = newRadius;
			  System.out.println(String.format("The area of the circle is:%.2f", findArea()));
		  }
		  else{
			  try {
				  throw new IllegalArgumentException("Radius cannot be negative");
			  }catch (IllegalArgumentException e){
				  System.out.println(e.getStackTrace());
				  System.out.println(e.getMessage());
				  System.out.println(e.getLocalizedMessage());
				  System.out.println(e.getCause());
				  System.out.println(e.getClass());
				  System.out.println(e.getSuppressed());
			  }
		  }
	  }

	  public double findArea() {
	    return radius * radius * 3.14159;
	  }
}

