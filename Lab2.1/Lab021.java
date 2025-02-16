import java.util.GregorianCalendar;
import java.util.Scanner;

public class Lab021 {

    /**
     * This function uses the GregorianCalendar class
     * 1. get the current time and date
     * 2. create the StopWatch class and start it
     */
    public static void menu() {

        int nbQuestions = 4;
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
                    la021GregorianCalendarClassQ1();
                    lab021StopWatchClassQ2();
                    la021LinearEquationClassQ3();
                    la021LocationClassQ4();
                    break;
                case 1:
                    la021GregorianCalendarClassQ1();
                    break;
                case 2:
                    lab021StopWatchClassQ2();
                    break;
                case 3:
                    la021LinearEquationClassQ3();
                    break;
                case 4:
                    la021LocationClassQ4();
                    break;
                case 6:
                    System.exit(-1);
                default:
                    System.out.println("invalid input");
            }
        }
    }
    
    /**
     * This function uses the GregorianCalendar class
     * 1. get the current time and date
     * 2. display the results
     * 3. create a new GregorianCalendar and set the millis to 1234567898765 milliseconds
     * 4. print the result
     */
    public static void la021GregorianCalendarClassQ1() {

        // get current year
        GregorianCalendar calendar = new GregorianCalendar();
        int year = calendar.get(GregorianCalendar.YEAR);
        int month = calendar.get(GregorianCalendar.MONTH) + 1;
        int day = calendar.get(GregorianCalendar.DAY_OF_MONTH);

        // print the data
        System.out.println("Year: " + year + ", Month: " + month + ", Day: " + day);

        // manipulate the time for this new calendar
        GregorianCalendar timeManipulatedCalendar = new GregorianCalendar();
        timeManipulatedCalendar.setTimeInMillis(1234567898765L);
        year = timeManipulatedCalendar.get(GregorianCalendar.YEAR);
        month = timeManipulatedCalendar.get(GregorianCalendar.MONTH) + 1;
        day = timeManipulatedCalendar.get(GregorianCalendar.DAY_OF_MONTH);

        // print the data
        System.out.println("Year: " + year + ", Month: " + month + ", Day: " + day);

    }

    /**
     * This function computes the time to sort 100,000 nnumbers
     * 1. create a double array and create 100,000 random numbers
     * 2. create the StopWatch class and start it
     * 3. use selection sort to sort the 100,000 numbers
     * 4. stop the stopwatch
     * 5. display the time elapsed in milliseconds and seconds
     */
    public static void lab021StopWatchClassQ2() {

        // create random numbers
        double[] randomNumbers = new double[100000];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = Math.random()*10000;
        }
        // notify the user that the numbers have been created
        System.out.println("Created array of random numbers");

        // create and start stopwatch
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // selection sort
        for (int i = 0; i < randomNumbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < randomNumbers.length; j++) {
                if (randomNumbers[j] < randomNumbers[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = randomNumbers[i];
            randomNumbers[i] = randomNumbers[minIndex];
            randomNumbers[minIndex] = temp;
        }

        // stop
        stopWatch.stop();

        // get elapsed time and display in milliseconds and seconds
        long elapsedTime = stopWatch.getElapsedTime();
        System.out.println("it took " + elapsedTime + " milliseconds (" + (elapsedTime/1000.0f) + " seconds) to sort 100,000 numbers");
    }

    /**
     * This function computes linear equations
     * 1. user input to get the numbers of a, b, c, d, e and f (6 numbers)
     * 2. while loop to see if the input matches to 6 inputs
     * 3. cast the strings (using split) to doubles
     * 4. check if the equation is solvable
     * 5. use the LinearEquation class to get the x and y values
     */
    public static void la021LinearEquationClassQ3() {

        // input
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        String[] inputElements = new String[6];
        double[] nums = new double[6];

        // 6 => there are six numbers a, b, c, d, e, f
        // keep going until we have 6 inputted numbers
        while (size != 6) {
            System.out.print("Insert 6numbers for the linear equation: ");
            String input = scanner.nextLine(); // scanner is being reluctant to work
            inputElements = input.split(" ");
            size = inputElements.length;
            if (size != 6) {
                System.out.println("the number of your inputs ("+size+") is not 6");
            }
        }

        // cast the strings to doubles
        for (int i = 0; i < 6; i++) {
            nums[i] = Double.parseDouble(inputElements[i]);
        }

        // create linearequation class
        LinearEquation linearEquation = new LinearEquation(nums[0], nums[1], nums[2], nums[3], nums[4], nums[5]);

        // see if the solution is not solvable
        if (!linearEquation.isSolvable()) {
            System.out.println("This equation has no solutions");
            return; // break out of the function
        }

        // get x and y
        double x = linearEquation.getX();
        double y = linearEquation.getY();

        // display
        System.out.println("x is " + x + " and y is " + y);
    }


    /**
     * This function finds the largest number in a given matrix and its indices
     * 1. user input to get the numbers of rows and columns
     * 2. for loop for all the rows
     * 3. while loop to see if the input is equal to the number of columns
     * 4. parse the string inputs into doubles
     * 5. use the Location class to get the max value and the indices
     */
    public static void la021LocationClassQ4() {

        // instructions
        System.out.print("Input the number of rows and columns: ");
        Scanner scanner = new Scanner(System.in);

        // input
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        double[][] matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            
            // variables for the row
            String[] elem = new String[columns];
            double[] nums = new double[columns];
            int size = 0;
            
            // keep going until size is not equal to the number of columns
            while (size != columns) {

                // output
                System.out.print("Enter the values for the columns: ");
                scanner = new Scanner(System.in); // scanner is being reluctant to work
                // input
                String input = scanner.nextLine();
                elem = input.split(" ");
                size = elem.length;
                // check if the number of inputted values is not equal to the number of columns
                if (size != columns) {
                    System.out.println("The number of columns is "+columns+". you inputted "+size+" columns");
                }
            }

            // convert string to double
            for (int j = 0; j < columns; j++) {
                nums[j] = Double.parseDouble(elem[j]);
            }
            // set row to the matrix
            matrix[i] = nums;
        }
        // find the location and display
        Location location = Location.locateLargest(matrix);
        System.out.println("The location of the largest element ("+location.maxValue+") is at: ("+location.row+", "+location.column+")");
    }
}
