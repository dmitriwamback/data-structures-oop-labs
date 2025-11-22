package lab1;

public class Employee {
    
    // Default properties for all subclasses
    private String name;
    private int age;
    private double salary;

    /**
     * Employee default constructor
     * @param name the name of the employee
     * @param age the age of the employee
     * @param salary the salary of the employee
     */
    public Employee(String name, int age, double salary) {

        // set properties
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    //-----------------------------------------------------------------//
    // SETTERS //
    //-----------------------------------------------------------------//

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //-----------------------------------------------------------------//
    // GETTERS //
    //-----------------------------------------------------------------//

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    //-----------------------------------------------------------------//
    // OVERRIDED TOSTRING //
    //-----------------------------------------------------------------//
    @Override public String toString() {
        return "Employee: " + getDefaultProperties();
    }

    /**
    Helper function to help with the subclass toString()s (filling in the fields without the 'Employee' prefix)
    */
    public String getDefaultProperties() {
        return "name = '" + name + "'', age = " + age + " salary = " + salary+"$";
    }
}
