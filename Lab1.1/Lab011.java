import java.util.Scanner;

public class Lab011 {

    // note: la => lab assignment
    // la11 => la 1.1

    public static void menu() {

        int nbQuestions = 3;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            
            // procedurally generate the menu
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

            int option = scanner.nextInt(); // try-catch would be useful

            // go through each option
            switch(option) {
                case 0: 
                    la11MultiplyMatrixQ1();
                    la11FindLargestRowAndColumnsQ2();
                    la11LocateSmallestElementQ3();
                    break;
                case 1:
                    la11MultiplyMatrixQ1();
                    break;
                case 2:
                    la11FindLargestRowAndColumnsQ2();
                    break;
                case 3:
                    la11LocateSmallestElementQ3();
                    break;
                case 6:
                    System.exit(-1);
                default:
                    System.out.println("invalid input");
            }
        }
    }

    public static void la11MultiplyMatrixQ1() {

        // printing question number
        System.out.println("\n-------------------------------------------------------");
        System.out.println("QUESTON 1 - multiply 3x3 matrix");
        System.out.println("-------------------------------------------------------");

        System.out.println("Matrix elements should be divided by ' ' (space)");

        // create two matrices with length 3x3
        double[][] matrix1 = getMatrix("first", 3, 3);
        double[][] matrix2 = getMatrix("second", 3, 3);

        // multiply the matrices
        double[][] resultingMatrix = multiplyMatrix(matrix1, matrix2);

        // go through the resulting matrix and print its contents
        for (int row = 0; row < resultingMatrix.length; row++) {
            for (int col = 0; col < resultingMatrix[0].length; col++) {
                System.out.print(resultingMatrix[row][col] + " ");
            }
            System.out.println();
        }

    }
    public static double[][] getMatrix(String matrixCount, int columns, int rows) {

        // print the instructions
        System.out.print("Input "+matrixCount+" matrix ("+(columns*rows)+" elements): ");

        // read input
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        String[] elements = result.split(" ");
        int size = elements.length;

        // input validation
        while (size != columns * rows) {
            System.out.println("\n<<-----------------------VALIDATION----------------------->>");
            System.out.println("number of elements should equal "+(columns*rows));
            System.out.println("The number of your elements is " + size);
            System.out.print("Input "+matrixCount+" matrix ("+(columns*rows)+" elements): ");
            scanner = new Scanner(System.in);
            result = scanner.nextLine();
            elements = result.split(" ");
            size = elements.length;
        }

        // create matrix
        double[][] matrix = new double[rows][columns];

        // fill matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Double.parseDouble(elements[i*columns+j]);
            }
        }

        return matrix;
    }
    
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {

        // debug variables
        // double[][] c = {{1,2,3}, {4,5,6}, {7,8,9}}, d = {{0, 2, 4}, {1, 4.5, 2.2}, {1.1, 4.3, 5.2}};

        // create matrix for the product of A and B matrix
        double[][] newMatrix = new double[3][3];

        // looping through rows/cols
        // int k => extra variable to leave 'row' as 'static' as to not mess up the multiplication
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                for (int k = 0; k < 3; k++) {
                    // multiply and add
                    newMatrix[row][col] += a[row][k] * b[k][col];
                }
            }
        }
        // return
        return newMatrix;
    }

    public static void la11FindLargestRowAndColumnsQ2() {

        // Printing question number
        System.out.println("\n-------------------------------------------------------");
        System.out.println("QUESTON 2 - get most 1s in columns and rows");
        System.out.println("-------------------------------------------------------");

        // Generating random matrix
        int[][] matrix = generateRandomMatrix();

        // Print the rows and columns of the matrix;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        // Index of the row and column which contain the most 1s
        int rowContainingMax = 0;
        int columnContainingMax = 0;
        // the max number of 1s for the current row
        int rowMax = 0;
        int columnMax = 0;
        // sums of all rows/columns
        int[] rowSum = new int[5];
        int[] columnSum = new int[5];

        // adding all the elements in the rows/columns (bigger number indicates more 1s)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //switching [row][col] for rows and [col][row] for columns
                rowSum[row] += matrix[row][col];
                columnSum[row] += matrix[col][row];
            }
        }

        // searching for the largest sum of 1s for each row and column
        // assigning max value to the sum and getting the index of that sum
        for (int i = 0; i < 5; i++) {
            // rows
            if (rowSum[i] > rowMax) {
                rowMax = rowSum[i];
                rowContainingMax = i;
            }
            // columns
            if (columnSum[i] > columnMax) {
                columnMax = columnSum[i];
                columnContainingMax = i;
            }
        }

        // print results
        System.out.println("Max row index: "+rowContainingMax);
        System.out.println("Max column index: "+columnContainingMax);
    }

    // additional function for q2
    private static int[][] generateRandomMatrix() {

        // creating a 5x5 matrix
        int[][] matrix = new int[5][5];

        // go through each row and column
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                // Math.random() => [0, 1)
                // Math.random() * 2 => [0, 2) then cast to int for [0, 1]
                matrix[row][col] = (int)(Math.random() * 2);
            }
        }

        // return the matrix
        return matrix;
    }

    public static void la11LocateSmallestElementQ3() {

        System.out.println("\n-------------------------------------------------------");
        System.out.println("QUESTON 3 - find smallest");
        System.out.println("-------------------------------------------------------");

        // create scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input rows and columns: ");

        // get matrix elements
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        
        // create matrix
        double[][] matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            // display instructions
            System.out.print("Input the row/array: ");
            scanner = new Scanner(System.in); // scanner reads sysout so it needs to be reinitialized

            // get values and its properties
            String input = scanner.nextLine();
            String[] elements = input.split(" ");
            int size = elements.length;
            
            // input validation
            while (size != columns) {
                System.out.println("Your array should have " + columns + " elements");
                System.out.print("Input the row/array: ");
                input = scanner.nextLine();
                elements = input.split(" ");
                size = elements.length;
            }

            // cast strings to doubles and 
            for (int k = 0; k < size; k++) {
                double val = Double.parseDouble(elements[k]);
                matrix[i][k] = val;
            }
        }

        // set min as the first element of the matrix
        double min = matrix[0][0];
        
        // create variables for the indices of the smallest element
        int smallestRowIndex = 0, smallestColumnIndex = 0;

        // looping through the matrix
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                // see if the current element is smaller than 'min'
                if (matrix[row][col] < min) {
                    // if so, assign the min to the current element in the matrix
                    min = matrix[row][col];

                    // set the indices to the row and column
                    smallestRowIndex = row;
                    smallestColumnIndex = col;
                }
            }
        }

        // print the output
        System.out.println("the smallest number is located at: ("+smallestRowIndex+", "+smallestColumnIndex+")");
    }
}
