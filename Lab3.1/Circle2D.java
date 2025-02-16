public class Circle2D {
    private double x, y;
    private double radius;


    public Circle2D() {
        x = 0;
        y = 0;
        radius = 1;
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    //------------------------------------------------//
    // Getters
    //------------------------------------------------//

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getRadius() {
        return radius;
    }

    //------------------------------------------------//
    // Setters
    //------------------------------------------------//

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    /**
     * @return the area of the circle using pi * r * r
     */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * @return the perimeter (circumference) of the circle using 2 * pi * r
     */
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * function that checks if a point is in a circle
     * @param x - the x coordinate of the point
     * @param y - the y coordinate of the point
     * @return boolean if the magnitude (distance) of the point to the center of the circle is smaller than the radius
     */
    public boolean contains(double x, double y) {

        // difference in x and y
        double dx = this.x - x;
        double dy = this.y - y;

        // magnitude
        double magnitude = Math.sqrt(dx * dx + dy * dy);
        return magnitude <= radius;
    }

    /**
     * function that checks if a circle is inscribed within another
     * @param circle the circle object
     * @return boolean if the magnitude + circle.radius is smaller than the this circle's radius
     */
    public boolean contains(Circle2D circle) {

        // difference in x and y
        double dx = this.x - circle.getX();
        double dy = this.y - circle.getY();

        // magnitude
        double magnitude = Math.sqrt(dx * dx + dy * dy);
        return magnitude + circle.getRadius() <= radius;
    }
    
    /**
     * function that checks if radius1 + radius2 <= magnitude
     * @param circle the circle object
     * @return boolean if the magnitude is smaller than the sum of the radiuses
     */
    public boolean overlaps(Circle2D circle) {

        // difference in x and y
        double dx = this.x - circle.getX();
        double dy = this.y - circle.getY();

        // magnitude
        double magnitude = Math.sqrt(dx * dx + dy * dy);
        return magnitude <= radius + circle.getRadius();
    }
}
