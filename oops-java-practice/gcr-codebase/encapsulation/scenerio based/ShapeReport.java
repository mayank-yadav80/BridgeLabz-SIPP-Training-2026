public class ShapeReport {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(3.0),
            new Rectangle(4.0, 5.0),
            new Triangle(3.0, 4.0, 5.0)
        };

        System.out.println("Shape Area and Perimeter Report");
        System.out.printf("%-12s %-18s %-12s %-12s%n", "Shape", "Dimensions", "Area", "Perimeter");
        System.out.println("----------------------------------------------------------------");

        for (Shape shape : shapes) {
            String dimensions = shape.getDimensions();
            System.out.printf("%-12s %-18s %-12.2f %-12.2f%n",
                    shape.getClass().getSimpleName(), dimensions, shape.area(), shape.perimeter());
        }
    }
}

abstract class Shape {
    abstract double area();
    abstract double perimeter();
    String getDimensions() {
        return "N/A";
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    String getDimensions() {
        return "r=" + radius;
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive.");
        }
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }

    @Override
    String getDimensions() {
        return "l=" + length + ", w=" + width;
    }
}

class Triangle extends Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive.");
        }
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Sides do not form a valid triangle.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    double area() {
        double s = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    String getDimensions() {
        return "a=" + sideA + ", b=" + sideB + ", c=" + sideC;
    }
}
