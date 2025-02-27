import java.util.ArrayList;
import java.util.Scanner;

public class La042 {

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
                    la042transactionTestQ1();
                    la042FindLargestRowsAndColumnsQ2();
                    la042RepeatedAdditionQ3();
                    break;
                case 1:
                    la042transactionTestQ1();
                    break;
                case 2:
                    la042FindLargestRowsAndColumnsQ2();
                    break;
                case 3:
                    la042RepeatedAdditionQ3();
                    break;
                case 6:
                    System.exit(-1);
                default:
                    System.out.println("invalid input");
            }
        }
    }

    // test
    public static void la042transactionTestQ1() {

        // craete account and withdraw and deposit
        Account account = new Account("Joe", 1122, 20000);
        account.withdraw(2500);
        account.deposit(3000);

        // print
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Monthly interest: " + account.getMonthlyInterest());
        System.out.println("Date created: " + account.getDateCreated());
    }
    
    public static void la042FindLargestRowsAndColumnsQ2() {

        // create array list for all the max 'ones'
        ArrayList<Integer> largestRows = new ArrayList<Integer>(),
                           largestColumns = new ArrayList<Integer>();

        // the max number of ones in a row and a column
        int maxOnesInRow = 0, maxOnesInColumns = 0;

        // scanner
        Scanner scanner = new Scanner(System.in);

        // prompt user to enter a *positive* number
        int n = -1;
        while (n < 0) {
            System.out.print("Enter a number to generate an n-by-n matrix: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Invalid input");
            }
        }

        // create matrix
        int[][] randomMatrix = new int[n][n];

        // generate random numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                randomMatrix[i][j] = (int)(Math.random()*2);
                System.out.print(randomMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // query through all the rows and columns to find the max number of each
        for (int i = 0; i < n; i++) {
            int rownb1s = 0;
            int colnb1s = 0;
            for (int j = 0; j < n; j++) {
                rownb1s += randomMatrix[i][j];
                colnb1s += randomMatrix[j][i];
            }

            if (rownb1s >= maxOnesInRow) { maxOnesInRow = rownb1s; }
            if (colnb1s >= maxOnesInColumns) { maxOnesInColumns = colnb1s; }
        }

        // append the indices of the rows and columns that are equal to maxOnesInRow or maxOnesInColumn
        for (int i = 0; i < n; i++) {
            int rownb1s = 0;
            int colnb1s = 0;
            for (int j = 0; j < n; j++) {
                rownb1s += randomMatrix[i][j];
                colnb1s += randomMatrix[j][i];
            }
            if (rownb1s == maxOnesInRow) largestRows.add(i);
            if (colnb1s == maxOnesInColumns) largestColumns.add(i);
        }

        // print result for rows
        System.out.print("Most ones are in row(s): ");
        for (int rowIndex = 0; rowIndex < largestRows.size(); rowIndex++) {
            System.out.print(largestRows.get(rowIndex) + " ");
        }
        System.out.println();

        // print result for columns
        System.out.print("Most ones are in column(s): ");
        for (int colIndex = 0; colIndex < largestColumns.size(); colIndex++) {
            System.out.print(largestColumns.get(colIndex) + " ");
        }
        System.out.println();
    }

    public static void la042RepeatedAdditionQ3() {

        // start quiz
        RepeatAdditionQuiz.start();
    }
}
