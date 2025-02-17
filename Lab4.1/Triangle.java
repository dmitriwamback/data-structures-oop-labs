public class Triangle extends GeometricObject {
    
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3, boolean filled, String color) {
        super(filled, color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override public double getArea() {
        // cosine law to get angle between side1 and side2
        // c^2 = a^2 + b^2 - 2abcosC
        double angleC = Math.acos(-(side3*side3 - side1*side1 - side2*side2)/(2 * side1 * side2));
        // using the formula absinC / 2 to find the area
        double area = (side1 * side2 * Math.sin(angleC))/2.0;
        return area;
    }

    @Override public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }
}
