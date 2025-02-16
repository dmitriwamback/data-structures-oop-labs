public class A2DArrayOperation {
    
    // getTotal for double, int, and long
    // all functions work the same way
    public static double getTotal(double[][] array) {
        double total = 0; // define total

        // add the elements
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                total += array[i][j];
            }
        }
        // return
        return total;
    }
    public static int getTotal(int[][] array) {
        int total = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                total += array[i][j];
            }
        }

        return total;
    }
    public static long getTotal(long[][] array) {
        long total = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                total += array[i][j];
            }
        }

        return total;
    }

    // getAverage for double, int, and long
    // all functions work the same way
    public static double getAverage(double[][] array) {
        double total = getTotal(array); // defineTotal
        return total / (array[0].length * array.length); // divide the total by the number of elements in the array
    }
    public static int getAverage(int[][] array) {
        int total = getTotal(array);
        return total / (array[0].length * array.length);
    }
    public static long getAverage(long[][] array) {
        long total = getTotal(array);
        return total / (array[0].length * array.length);
    }

    // getRowTotal for double, int, and long
    // all functions work the same way
    public static double getRowTotal(double[][] array, int row) {
        double total = 0; // define total
        for (int i = 0; i < array[row].length; i++) {
            total += array[row][i]; // add items in row
        }

        return total;
    }
    public static int getRowTotal(int[][] array, int row) {
        int total = 0;
        for (int i = 0; i < array[row].length; i++) {
            total += array[row][i];
        }

        return total;
    }
    public static long getRowTotal(long[][] array, int row) {
        long total = 0;
        for (int i = 0; i < array[row].length; i++) {
            total += array[row][i];
        }

        return total;
    }

    // getColumnTotal for double, int, and long
    // all functions work the same way
    public static double getColumnTotal(double[][] array, int column) {
        double total = 0; // define total
        for (int i = 0; i < array.length; i++) {
            total += array[i][column]; // add items in column
        }

        return total;
    }
    public static int getColumnTotal(int[][] array, int column) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i][column];
        }

        return total;
    }
    public static long getColumnTotal(long[][] array, int column) {
        long total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i][column];
        }

        return total;
    }

    // getHighestRow for double, int, and long
    // all functions work the same way
    public static double getHighestRow(double[][] array, int row) {
        double highest = array[row][0]; // define highest

        for (int i = 0; i < array[row].length; i++) {
            if (highest < array[row][i]) {
                highest = array[row][i]; // set the highest to the new found highest
            }
        }

        return highest;
    }
    public static int getHighestRow(int[][] array, int row) {
        int highest = array[row][0];

        for (int i = 0; i < array[row].length; i++) {
            if (highest < array[row][i]) {
                highest = array[row][i];
            }
        }

        return highest;
    }
    public static long getHighestRow(long[][] array, int row) {
        long highest = array[row][0];

        for (int i = 0; i < array[row].length; i++) {
            if (highest < array[row][i]) {
                highest = array[row][i];
            }
        }

        return highest;
    }

    // getLowestRow for double, int, and long
    // all functions work the same way
    public static double getLowestRow(double[][] array, int row) {
        double lowest = array[row][0]; // define lowest

        for (int i = 0; i < array[row].length; i++) {
            if (lowest > array[row][i]) {
                lowest = array[row][i]; // set lowest to the found lowest in the array
            }
        }

        return lowest;
    }
    public static int getLowestRow(int[][] array, int row) {
        int lowest = array[row][0];

        for (int i = 0; i < array[row].length; i++) {
            if (lowest > array[row][i]) {
                lowest = array[row][i];
            }
        }

        return lowest;
    }
    public static long getLowestRow(long[][] array, int row) {
        long lowest = array[row][0];

        for (int i = 0; i < array[row].length; i++) {
            if (lowest > array[row][i]) {
                lowest = array[row][i];
            }
        }

        return lowest;
    }
}
