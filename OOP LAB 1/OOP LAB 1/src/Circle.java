import java.util.concurrent.Callable;

public class Circle {
    private double radius;
    // Constructor taking a radius
    private  static  int  count =0;
    public  Circle (double radius ){
        this.radius = radius; // this.radius = field, radius =parameter
        count ++;

    }
    // No-argument constructor: radius defaults to 1.0
    public Circle(){
        this(1.0);   //calls the constructor above;must be first statement
    }
    //Static getter: can be called without creating an object
    public  static int getCount(){
        return count;
    }
    public double getRadius(){
        return radius;
    }public static void main(String[] args){
        Circle c1 = new Circle(5.5);
       Circle c2 = new Circle();
         Circle c3 = new Circle(2.0);


        System.out.println("c1 radius:  " + c1.getRadius()); //5.5
        System.out.println("c2  radius:  " +  c2.getRadius());//1.0
        System.out.println("c3  radius:  " +  c3.getRadius());//2.0


        //Called on the class itself, not an object
        System.out.println("Circles created: " + Circle.getCount());  //3
        }

}

