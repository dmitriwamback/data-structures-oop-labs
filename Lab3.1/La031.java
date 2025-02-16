import java.util.Scanner;

public class La031 {

    /**
     * This function creates a menu to select questions
     */
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
                    la031ATMSimulationQ1();
                    la031CourseClassQ2();
                    la031Circle2DClassQ3();
                    break;
                case 1:
                    la031ATMSimulationQ1();
                    break;
                case 2:
                    la031CourseClassQ2();
                    break;
                case 3:
                    la031Circle2DClassQ3();
                    break;
                case 6:
                    System.exit(-1);
                default:
                    System.out.println("invalid input");
            }
        }
    }


    public static void la031ATMSimulationQ1() {

        // creating accounts
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
            accounts[i].setBalance(100);
        }
        
        Scanner scanner = new Scanner(System.in);

        // keep going until the user decides to exit the menu
        boolean shouldExit = false;
        while (!shouldExit) {
            System.out.print("Enter an id: ");
            int id = scanner.nextInt();

            Account account = accounts[id];
            boolean choseAccount = true;
            
            // keep going when the account is chosen
            while (choseAccount) {
                System.out.println("Main menu");
                System.out.println("1. View balance\n2. Withdraw\n3. Deposit\n4. Exit");
                System.out.print("> ");
                int choice = scanner.nextInt();

                switch(choice) {
                    case 1: {
                        // gets balance
                        System.out.println("Balance: " + account.getBalance());
                        break;
                    }
                    case 2: {
                        // withdraw
                        double withdrawAmount = positiveDoubleInput(scanner, "Withdraw amount: ");
                        account.withdraw(withdrawAmount);
                        break;
                    }
                    case 3: {
                        // deposit
                        double depositAmount = positiveDoubleInput(scanner, "Deposit amount: ");
                        account.deposit(depositAmount);
                        break;
                    }
                    case 4: {
                        // check when the account should be de-selected
                        choseAccount = false;
                        break;
                    }
                    default: {
                        System.out.println("Invalid option");
                        break;
                    }
                }
            }
        }
    }

    // input validation for positive numbers
    private static double positiveDoubleInput(Scanner scanner, String prompt) {
        double value = -1;
        do { 
            System.out.print(prompt);
            value = scanner.nextDouble();
        } while (value < 0);

        return value;
    }

    public static void la031CourseClassQ2() {
        Course course = new Course("Programming in Java 101");
        course.addStudent("Bob");
        course.addStudent("Joe");
        course.addStudent("Jane");
        course.dropStudent("Joe");

        String[] students = course.getStudents();

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    public static void la031Circle2DClassQ3() {

        // create circle
        Circle2D c1 = new Circle2D(2, 2, 5.5);

        // display stats
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());
        System.out.println("Contains (3, 3): " + c1.contains(3, 3));
        System.out.println("Contains (4, 5) with radius 10.5: " + c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("Overlaps (3, 5) with radius 2.3: " + c1.overlaps(new Circle2D(3, 5, 2.3)));
    }
}
