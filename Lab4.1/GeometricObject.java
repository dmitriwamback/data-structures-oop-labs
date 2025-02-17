public class GeometricObject {
    
    // default functions
    private boolean filled;
    private String color;

    double getArea() { return 0; }
    double getPerimeter() { return 0; }

    public GeometricObject(boolean filled, String color) {
        this.color = color;
        this.filled = filled;
    }

    

    // getters
    public String getColor() {
        return color;
    }

    public boolean  getFilled() {
        return filled;
    }

    // setters
    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
