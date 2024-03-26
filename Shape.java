abstract class Shape {
    protected String name;
    protected String color;

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    abstract double calculateArea();
    abstract double calculatePerimeter();
}

interface Resizable {
    void resize(int percent);
}

class Circle extends Shape implements Resizable {
    private double radius;

    public Circle(String name, String color, double radius) {
        super(name, color);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void resize(int percent) {
        radius *= (1 + percent / 100.0);
    }
}

class Rectangle extends Shape implements Resizable {
    private double length;
    private double width;

    public Rectangle(String name, String color, double length, double width) {
        super(name, color);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public void resize(int percent) {
        length *= (1 + percent / 100.0);
        width *= (1 + percent / 100.0);
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Circle circle = new Circle("Circle", "Red", 5);
        Rectangle rectangle = new Rectangle("Rectangle", "Blue", 4, 6);

        System.out.println("Circle:");
        System.out.println("Name: " + circle.getName());
        System.out.println("Color: " + circle.getColor());
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());
        circle.resize(50);
        System.out.println("Resized Circle - Radius: " + circle.getRadius());

        System.out.println("\nRectangle:");
        System.out.println("Name: " + rectangle.getName());
        System.out.println("Color: " + rectangle.getColor());
        System.out.println("Length: " + rectangle.getLength());
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        rectangle.resize(50);
        System.out.println("Resized Rectangle - Length: " + rectangle.getLength() + ", Width: " + rectangle.getWidth());
    }
}