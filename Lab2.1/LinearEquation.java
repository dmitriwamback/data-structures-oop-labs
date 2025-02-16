public class LinearEquation {
    
    // private variables
    private double a, b, c, d, e, f;

    // constructor
    public LinearEquation(double a, double b, double c, double d, double e, double f) {

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    // do math to get x
    public double getX() {
        if (!isSolvable()) return 0;
        return (e*d - b*f)/(a*d - b*c);
    }

    // do math to get y
    public double getY() {
        if (!isSolvable()) return 0;
        return (a*f - c*e)/(a*d - b*c);
    }

    // check if the denominator is not 0
    public boolean isSolvable() {
        return a*d - b*c != 0;
    }
}
