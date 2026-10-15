// Abstract class: partly built, cannot be instantiated with new
abstract class  Shape {
    abstract double area(); // abstract = no body, subclasses must implement
    abstract double perimeter();
}

//Circle IS-A Shape
class Circle6 extends Shape{
    double r;
    Circle6(double r) {this.r =r ;}
    @Override double area(){return 2* Math.PI* r * r ;} // pi * r^2
    @Override double perimeter(){return  2* Math.PI*r;} // 2* pi*r
}
class Rectangle6 extends Shape{
    double w, h;
    Rectangle6(double w, double h){this.w = w; this.h =h;}
    @Override double area(){return  w* h;}   // width* height
    @Override double perimeter(){return 2* (w+h);}// 2*(w+ h)
}
class Square extends Shape{
    double s;
    Square(double s ){this.s=s;}
    @Override double area(){return s* s;}   // side squared
    @Override double perimeter(){return 4*s;} // 4* side
}
class ShapeDemo{
    public static  void main(String[] args){
        // new Shape(); // compile error: abstract class cannot be instantiated

        // Upcasting: one Shape array holds all three subclasses
        Shape[] shapes = {new Circle6(2), new Rectangle6(3,4), new Square(5)};

        // Each call runs the real object's own are() and perimeter()
        for (Shape sh : shapes)
            System.out.println(sh.area() + "" + sh.perimeter());
    }
}
