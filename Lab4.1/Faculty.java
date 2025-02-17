public class Faculty extends Employee {
    
    private int[] officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired, int[] officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    // getters
    public int[] getOfficeHours() {
        return officeHours;
    }

    public String getRank() {
        return rank;
    }

    // setters
    public void setOfficeHours(int[] officeHours) {
        this.officeHours = officeHours;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override public String toString() {
        String officeHoursString = "";
        for (int i = 0; i < 7; i++) {
            officeHoursString +=officeHours[i] + ", ";
        }
        return super.toString() + "office hours: " + officeHoursString + "\n"
                                + "rank: " + rank;
    }
}
