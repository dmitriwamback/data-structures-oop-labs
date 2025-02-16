public class Main {
    
    public static void main(String[] args) {

        //exercise
        double[][] test = {{1.0, 2.3, 2.1, 2.3}, {0.2, 1.2, 3.2, 0.1}, {8.2, 1.3, -10.2, 2.3}};
        System.out.println("getTotal(): " + A2DArrayOperation.getTotal(test));
        System.out.println("getAverage(): " + A2DArrayOperation.getAverage(test));
        System.out.println("getRowTotal(): " + A2DArrayOperation.getRowTotal(test, 2));
        System.out.println("getColumnTotal(): " + A2DArrayOperation.getColumnTotal(test, 1));
        System.out.println("getHighestRow(): " + A2DArrayOperation.getHighestRow(test, 1));
        System.out.println("getLowestRow(): " + A2DArrayOperation.getLowestRow(test, 0));
        
        //menu
        Lab011.menu();
    }
}
