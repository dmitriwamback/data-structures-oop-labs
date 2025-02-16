import java.util.Scanner;

public class Lab012 {

    /**
     * this function creates a text-based menu to choose any question at will
     * 1. a while loop ensures that the menu works after the question has been finished
     * 2. it creates the menu procedurally with a number of questions in a for loop
     * 3. we prompt the user with choices
     * 4. use a switch case statement to choose and run the question
     * 5. repeat
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
                    la012ComputeWeeklySalaryQ1();
                    la012FindClosestPointsQ2();
                    la012ConsecutiveFoursQ3();
                    break;
                case 1:
                    la012ComputeWeeklySalaryQ1();
                    break;
                case 2:
                    la012FindClosestPointsQ2();
                    break;
                case 3:
                    la012ConsecutiveFoursQ3();
                    break;
                case 6:
                    System.exit(-1);
                default:
                    System.out.println("invalid input");
            }
            System.out.println("-------------------------------------------");
        }
    }

    public static void la012ComputeWeeklySalaryQ1() {


        int[][] employees = new int[8][7]; // 8 employees as written in the document
        double[] wages = new double[8];
        double[] salaries = new double[8];

        Scanner scanner = new Scanner(System.in);
        
        // check if the wage is negative
        for (int i = 0; i < 8; i++) {
            double wage = -1;
            while (wage < 0) {
                System.out.print("Enter employee " + i +"'s wage: ");
                wage = scanner.nextDouble();
            }
            wages[i] = wage;
        }

        // going through the eight employees for the seven days
        for (int employee = 0; employee < 8; employee++) {
            System.out.print("Enter the hours worked for employee "+employee+": ");
            for (int day = 0; day < 7; day++) {
                // Math.abs indicates that if a user types a negative number, it becomes positive
                employees[employee][day] = Math.abs(scanner.nextInt());
            }
        }

        // going through the eight employees for the seven days
        for (int employee = 0; employee < 8; employee++) {

            // adding the salary
            for (int day = 0; day < 7; day++) {
                salaries[employee] += wages[employee] * employees[employee][day];
            }
        }

        int[] indices = new int[salaries.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // selection sort
        for (int i = 0; i < salaries.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < salaries.length; j++) {
                if (salaries[j] < salaries[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = salaries[i];
            salaries[i] = salaries[minIndex];
            salaries[minIndex] = temp;

            int tempIndex = indices[i];
            indices[i] = indices[minIndex];
            indices[minIndex] = tempIndex;
        }

        for (int i = 0; i < indices.length; i++) {
            System.out.println("Employee " + indices[i] + "'s salary is: " + salaries[i]);
        }
    }

    public static void la012FindClosestPointsQ2() {

        // document-assigned points
        double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1}, {2, 0.5, 9},
                             {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2}, {5.5, 4, -0.5}};

        // final points A and B
        double[] pointA = new double[3], pointB = new double[3];

        // set the min distance to a large number to overestimate the real value
        double minDistance = 10000000;

        // go through each point
        for (double[] point1 : points) {
            for (double[] point2 : points) {

                // if the two points are the same then disregard and continue
                if (point1 == point2) continue;

                // get the xyz coordinates
                double x = point1[0] - point2[0], y = point1[1] - point2[1], z = point1[2] - point2[2];

                // get magnitude
                double magnitude = Math.sqrt(x*x + y*y + z*z);

                // compare magnitude with min distance
                if (magnitude < minDistance) {
                    // set min distance to the magnitude
                    minDistance = magnitude;
                    
                    // assign points
                    pointA = point1;
                    pointB = point2;
                }
            } 
        }
        // display
        System.out.println("the nearest two points are: (" + pointA[0] + ", " + pointA[1] + ", " + pointA[2] + ") and (" + pointB[0] + ", " + pointB[1] + ", " + pointB[2] + ")");
    }

    public static void la012ConsecutiveFoursQ3() {

        // input
        System.out.print("Enter the amount of rows and columns: ");
        Scanner scanner = new Scanner(System.in);

        // Math.abs() to assure the input is positive
        int rows = Math.abs(scanner.nextInt());
        int columns = Math.abs(scanner.nextInt());

        // create matrix with rows and columns
        int[][] matrix = new int[rows][columns];

        // going through each row
        for (int i = 0; i < rows; i++) {
            int size = 0;

            // validate if the number of inputted values is the number of columns
            while (size != columns) {

                // if not then input
                System.out.print("Enter row: ");
                scanner = new Scanner(System.in); // scanner is being reluctant to work
                String input = scanner.nextLine();

                // get elements
                String[] elements = input.split(" ");
                size = elements.length;

                // continue with validation
                if (size != columns) {
                    System.out.println("the number of your elements is not equal to the number of columns");
                    continue;
                }

                // parse the strings to ints
                int[] nums = new int[columns];
                for (int j = 0; j < size; j++) {
                    nums[j] = Integer.parseInt(elements[j]);
                }
                matrix[i] = nums;
            }
        }

        // check and display values
        if (isConsecutiveFours(matrix)) {
            System.out.println("Found consecutive fours");
        }
        else {
            System.out.println("No consecutive fours were found");
        }
    }

    public static boolean isConsecutiveFours(int[][] values) {

        int rows = values.length, columns = values[0].length;

        // iterate through the values horizontally
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= columns - 4; j++) {

                if (values[i][j] == values[i][j + 1] && values[i][j] == values[i][j + 2] && values[i][j] == values[i][j + 3]) {
                    return true;
                }
            }
        }
        // iterate through the values vertically
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j < columns; j++) {

                if (values[i][j] == values[i + 1][j] && values[i][j] == values[i + 2][j] && values[i][j] == values[i + 3][j]) {
                    return true;
                }
            }
        }
        // diagoinally from top left to bottom right
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j <= columns - 4; j++) {

                if (values[i][j] == values[i + 1][j + 1] && values[i][j] == values[i + 2][j + 2] && values[i][j] == values[i + 3][j + 3]) {
                    return true;
                }
            }
        }
        // diagonally from top right to bottom left
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 3; j < columns; j++) {

                if (values[i][j] == values[i + 1][j - 1] && values[i][j] == values[i + 2][j - 2] && values[i][j] == values[i + 3][j - 3]) {
                    return true;
                }
            }
        }

        return false;
    }
}