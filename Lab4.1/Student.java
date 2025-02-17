public class Student extends Person {
    
    private final String status;

    Student(String name, String address, String phoneNumber, String emailAddress, String status) {
        super(name, address, phoneNumber, emailAddress);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override public String toString() {
        return super.toString() + "status: " + status;
    }
}
