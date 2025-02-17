
import java.util.Scanner;

public class Lab041 {
    

    public static void menu() {
        int nbQuestions = 3;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // procedurally generate the menu
            System.out.println("-------------------------------------------");
            for (int i = 0; i < nbQuestions+1; i++) {
                if (i == 0) {
                    System.out.println("Input 0 to run all the questions");
                }
                else {
                    System.out.println("Input " + i + " to run Question " + i);
                }
            }
            System.out.println("Input 6 to exit");
            System.out.print("> ");

            int option = scanner.nextInt();

            // go through each option
            switch(option) {
                case 0: 
                    lab041MyStringBuilderClassQ1();
                    lab041PersonClassInheritenceQ2();
                    lab041TriangleGeometricClassQ3();
                    break;
                case 1:
                    lab041MyStringBuilderClassQ1();
                    break;
                case 2:
                    lab041PersonClassInheritenceQ2();
                    break;
                case 3:
                    lab041TriangleGeometricClassQ3();
                    break;
                case 6:
                    System.exit(-1);
                default:
                    System.out.println("invalid input");
            }
        }
    }

    public static void lab041MyStringBuilderClassQ1() {
        
        // create sample MyStringBuilder1
        MyStringBuilder1 myStringBuilder1 = new MyStringBuilder1("Hello World");
        
        // append
        myStringBuilder1.append(new MyStringBuilder1("World"));
        System.out.println(myStringBuilder1.toString()); // see results

        // append
        myStringBuilder1.append(84);
        System.out.println(myStringBuilder1.toString()); // see results

        // show off the other functions
        System.out.println(myStringBuilder1.toLowerCase());
        System.out.println(myStringBuilder1.substring(8, 16));
        System.out.println(myStringBuilder1.charAt(2));
    }

    public static void lab041PersonClassInheritenceQ2() {

        // creating sample person
        Person person = new Person("John", "Moscow", "123 456 7890", "johnsemail@something.com");

        // creating sample student
        Student student = new Student("Joe", "Ufa", "987 654 4321", "joeemail@email.com", "sophomore");

        // creating sample employee
        Employee employee = new Employee("Jane", "Montreal", "443 928 1038", "jane@jane.ai", "N/A", 54.9, new MyDate());

        // creating sample faculty
        Faculty faculty = new Faculty("Joseph", 
                                      "Quebec", 
                                      "938 3821 0001", 
                                      "joseph@gmail.com", 
                                      "N/A", 
                                      100.43, 
                                      new MyDate(),
                                      new int[] {0, 1, 3, 2, 3, 2 , 0}, 
                                      "employee of the month");

        // creating sample staff
        Staff staff = new Staff("Jennifer", 
                                "Karachaevo Cherkessia", 
                                "843 932 9919", 
                                "jennifer@gamil.com",
                                 "N/A", 
                                 82.1,
                                 new MyDate(),
                                 "manager");

        // print each objects' information
        System.out.println("----------------PERSON----------------");
        System.out.println("Person: " + person.toString());

        System.out.println("\n----------------EMPLOYEE----------------");
        System.out.println("Employee: " + employee.toString());

        System.out.println("\n----------------STUDENT----------------");
        System.out.println("Student: " + student.toString());

        System.out.println("\n----------------FACULTY----------------");
        System.out.println("Faculty: " + faculty.toString());

        System.out.println("\n----------------STAFF----------------");
        System.out.println("Staff: " + staff.toString());
    }

    public static void lab041TriangleGeometricClassQ3() {

        double side1 = 0, side2 = 0, side3 = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // input
            System.out.print("Input three sides for the triangle: ");
            side1 = scanner.nextDouble();
            side2 = scanner.nextDouble();
            side3 = scanner.nextDouble();

            if (side1 < 0 || side2 < 0 || side3 < 0) {
                System.out.println("Found a side with negative value");
                continue;
            }

            // use the cosine law to see if the triangle is valid
            //-1 <= cosx <= 1 => cosx ∈ [-1, 1]
            // c² = a² + b² - 2abcosC
            // cosC = -(c² - a² - b²)/2ab
            double cosC = -(side3*side3 - side2*side2 - side1*side1)/(2.0 * side1 * side2);

            // if the value of cosC is outside [-1, 1], then the triangle is invalid
            if (cosC > 1 || cosC < -1) {
                System.out.println("Invalid triangle");
            }
            else {
                break;
            }
        }

        System.out.print("Enter triangle color: ");
        scanner = new Scanner(System.in);
        String color = scanner.nextLine();

        System.out.print("is filled: ");
        boolean isFilled = scanner.nextBoolean();

        GeometricObject triangle = new Triangle(side1, side2, side3, isFilled, color);
        System.out.println(triangle.toString());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.getFilled());
    }
}
