public class Employee extends Person {
    
    private String office;
    private double salary;
    private MyDate dateHired;

    public Employee(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired) {
        super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    // getters
    public String getOffice() {
        return office;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    // seters
    public void setOffice(String office) {
        this.office = office;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    @Override public String toString() {
        return super.toString() + "office: " + office + "\n" +
                                  "salary: " + salary + "\n" +
                                  "date hired (YYYY/MM/DD): " + dateHired.getYear() + "/" + dateHired.getMonth() + "/" + dateHired.getDay() + "\n";
    }
}
