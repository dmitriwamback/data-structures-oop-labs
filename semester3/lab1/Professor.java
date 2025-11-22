package lab1;

public class Professor extends Employee {

    // Professor-specific properties
    private String department, officeHours;

    /**
     * Default constructor for the professor
     * @param name the name of the professor (inherited from Employee)
     * @param age the age of the professor (inherited from Employee)
     * @param salary the salary of the professor (inherited from Employee)
     * @param department the department of the professor
     * @param officeHours the officeHours of the professor
     */
    public Professor(String name, int age, double salary, String department, String officeHours) {
        super(name, age, salary); // call the superclass's constructor

        // set properties
        this.department = department;
        this.officeHours = officeHours;
    }

    //-----------------------------------------------------------------//
    // SETTERS //
    //-----------------------------------------------------------------//

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }


    //-----------------------------------------------------------------//
    // GETTERS //
    //-----------------------------------------------------------------//

    public String getDepartment() {
        return department;
    }

    public String getOfficeHours() {
        return officeHours;
    }
    
    //-----------------------------------------------------------------//
    // OVERRIDED TOSTRING //
    //-----------------------------------------------------------------//
    @Override public String toString() {
        return "Professor: " + super.getDefaultProperties() + ", department = '" + department + "'', officeHours = '" + officeHours + "'";
    }
}
