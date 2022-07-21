import java.util.Objects;
import java.util.Scanner;

class Circle{
    double radius;
    String color;
    Circle(double radius){
        this.radius=radius;
        this.color="White";
    }
    Circle(double radius,String color){
        this.radius=radius;
        this.color=color;
    }
    final double pi=3.14;
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return pi*radius*radius;
    }

}
class Cylinder extends Circle{
    double height;
    Cylinder(double height,double radius){
        super(radius);
        this.height=height;
    }
    Cylinder(double height,double radius,String color){
        super(radius,color);
        this.height=height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return height*getArea();
    }

    public double getArea() {
        double radius=getRadius();
        double pi=super.pi;
        return 2*pi*radius*height;
    }
}
public class Prog3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Cylinder c1,c2;
        double r,h;
        String c;
        System.out.println("Enter the color radius and height of the first cylinder");
        c=sc.nextLine();
        r=sc.nextDouble();
        h= sc.nextDouble();
        sc.nextLine();
        c1=new Cylinder(h,r,c);
        System.out.println("Enter the color radius and height of the second cylinder");
        c=sc.nextLine();
        r=sc.nextDouble();
        h= sc.nextDouble();
        sc.nextLine();
        c2=new Cylinder(h,r,c);
        if(c1.getArea()== c2.getArea()&&c1.getVolume()==c2.getVolume()&& Objects.equals(c1.color, c2.color))
            System.out.println("Similar");
        else
            System.out.println("Not Similar");
    }
}
