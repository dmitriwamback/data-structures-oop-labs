package lab1;

public class AdminStaff extends Employee {

    // AdminStaff-specific properties
    private String department, position;

    /**
     * Default constructor for the AdminStaff
     * @param name the name of the AdminStaff (inherited from Employee)
     * @param age the age of the AdminStaff (inherited from Employee)
     * @param salary the salary of the AdminStaff (inherited from Employee)
     * @param department the department of the AdminStaff
     * @param position the position of the AdminStaff
     */
    public AdminStaff(String name, int age, double salary, String department, String position) {
        super(name, age, salary); // call the superclass's constructor

        // set properties
        this.department = department;
        this.position = position;
    }
    
    //-----------------------------------------------------------------//
    // SETTERS //
    //-----------------------------------------------------------------//

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    //-----------------------------------------------------------------//
    // GETTERS //
    //-----------------------------------------------------------------//

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    //-----------------------------------------------------------------//
    // OVERRIDED TOSTRING //
    //-----------------------------------------------------------------//
    @Override public String toString() {
        return "AdminStaff: " + super.getDefaultProperties() + ", department = '" + department + "', position = '" + position + "'";
    }
}
