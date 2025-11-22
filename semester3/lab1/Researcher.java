package lab1;

public class Researcher extends Employee {

    // Researcher-specific properties
    private String field;
    private int publications;

    /**
     * Default constructor for the Researcher
     * @param name the name of the Researcher (inherited from Employee)
     * @param age the age of the Researcher (inherited from Employee)
     * @param salary the salary of the Researcher (inherited from Employee)
     * @param field the field of the Researcher
     * @param publications the publications of the Researcher
     */
    public Researcher(String name, int age, double salary, String field, int publications) {
        super(name, age, salary); // call the superclass's constructor
        this.field = field;
        this.publications = publications;
    }

    //-----------------------------------------------------------------//
    // SETTERS //
    //-----------------------------------------------------------------//
    
    public void setField(String field) {
        this.field = field;
    }

    public void setPublications(int publications) {
        this.publications = publications;
    }


    //-----------------------------------------------------------------//
    // GETTERS //
    //-----------------------------------------------------------------//

    public String getField() {
        return field;
    }

    public int getPublications() {
        return publications;
    }
    //-----------------------------------------------------------------//
    // OVERRIDED TOSTRING //
    //-----------------------------------------------------------------//
    @Override public String toString() {
        return "Researcher: " + super.getDefaultProperties() + ", field = '" + field + "', publications = " + publications;
    }
}
