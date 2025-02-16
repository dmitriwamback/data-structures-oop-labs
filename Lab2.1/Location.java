public class Location {
    
    // variables
    public double maxValue;
    public int row, column;

    /**
     * this function finds the location of the largest number in a 2d array
     * 1. it assigns the max value to the first element of the matrix
     * 2. it initializes a location class
     * 3. it loops around the rows and columns of the matrix
     * 4. it checks if the value of the matrix at (row, column) is larger than the initial var
     * 5. it assigns the largest row and largest column indices to where the max value was found
     * 6. it assigns the max value and the row/column indices to the Location class
     * @param a the 2d matrix
     * @return Location
     */
    public static Location locateLargest(double[][] a) {

        // set max to the first element
        double maxValue = a[0][0];

        // create location
        Location location = new Location();
        // get rows, columns
        int rows = a.length;
        int columns = a[0].length;
        // row and column indices for the max value
        int largestRowIndex = 0;
        int largestRowColumn = 0;

        // iterate
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                // see if the element is larger than the initial max value
                if (a[i][j] > maxValue) {
                    // set the indices and the max value
                    largestRowColumn = j;
                    largestRowIndex = i;
                    maxValue = a[i][j];
                }
            }
        }
        // assign the values to the class
        location.maxValue = maxValue;
        location.row = largestRowIndex;
        location.column = largestRowColumn;

        // return the location
        return location;
    }
}
