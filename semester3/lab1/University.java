package lab1;
import java.util.ArrayList;

public class University {

    public static void main(String[] args) throws Exception {
         
        // create an arraylist of employees
        ArrayList<Employee> employees = new ArrayList<>();

        // hard-coded sample employees
        employees.add(new Employee("John Doe", 30, 40000.0));
        employees.add(new Professor("Jane Doe", 26, 70000.0, "Biology", "8am-6pm"));
        employees.add(new Researcher("Bronwyn Samantha", 40, 65000.0, "Chemistry", 20));
        employees.add(new AdminStaff("Jonathan Doe", 32, 80000.0, "Student Services", "Manager"));

        // iterate and print out all the employees' information (array list reduces the line count)
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}