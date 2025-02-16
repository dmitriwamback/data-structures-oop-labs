public class Course {
    
    private int capacity = 100;
    private String courseName;
    private String[] students = new String[capacity];
    int numberOfStudents = 0;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {

        // alloc more space when necessary
        if (numberOfStudents == capacity) {
            capacity *= 2;
            String[] newStudents = new String[capacity];
            System.arraycopy(students, 0, newStudents, 0, numberOfStudents);
            students = newStudents;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {

        // create a new array
        String[] newStudentsArray = new String[numberOfStudents];
        int k = 0; // number of students found + index

        for (int i = 0; i < students.length; i++) {
            if (!students[i].isEmpty()) { // checking if the current student string is not empty
                newStudentsArray[k] = students[i];
                k++;
            }
            if (k == numberOfStudents) break;
        }
        return newStudentsArray;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {

        // go through each student and find the matching student
        // delete them afterwards
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                students[i] = "";
                numberOfStudents--;
            }
        }
    }

    public void clear() {
        capacity = 100;
        students = new String[100];
    }
}
