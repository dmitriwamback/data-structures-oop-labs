public class TownHouse {
    
    private Address address;
    private String color;
    private int noOfBeds;
    private int noOfWashRooms;
    private int noOfFloors;
    private int yearOfConstruction;
    private boolean isWaterFront;
    private double dailyRent;
    private double discountRate;

    public TownHouse() {}
    public TownHouse(Address address, String color, int noOfBeds, int noOfWashRooms) {
        this.address = address;
        this.color = color;
        this.noOfBeds = noOfBeds;
        this.noOfWashRooms = noOfWashRooms;
    }
    public TownHouse(Address address, String color, int noOfBeds, int noOfWashRooms, int noOfFloors, int yearOfConstruction, boolean isWaterFront, double dailyRent, double discountRate) {
        this.address = address;
        this.color = color;
        this.noOfBeds = noOfBeds;
        this.noOfWashRooms = noOfWashRooms;
        this.noOfFloors = noOfFloors;
        this.yearOfConstruction = yearOfConstruction;
        this.isWaterFront = isWaterFront;
        this.dailyRent = dailyRent;
        this.discountRate = discountRate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public int getNoOfWashRooms() {
        return noOfWashRooms;
    }

    public void setNoOfWashRooms(int noOfWashRooms) {
        this.noOfWashRooms = noOfWashRooms;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public int getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public boolean isWaterFront() {
        return isWaterFront;
    }

    public void setWaterFront(boolean waterFront) {
        isWaterFront = waterFront;
    }

    public double getDailyRent() {
        return dailyRent;
    }

    public void setDailyRent(double dailyRent) {
        this.dailyRent = dailyRent;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double calcRent(int days) {
        double totalRent = dailyRent * days;
        double discountAmount = totalRent * (discountRate / 100);
        return totalRent - discountAmount;
    }

    @Override public String toString() {
        return "Address: "+address.toString()+
               "\nColor: "+color+
               "\nNumber of beds: "+noOfBeds+
               "\nNumber of washrooms: "+noOfWashRooms+
               "\nNumber of floors: "+noOfFloors+
               "\nYear of construction: "+yearOfConstruction+
               "\nIs water front: "+isWaterFront+
               "\nDaily rent: "+dailyRent+"$"+
               "\nDiscount rate: "+discountRate+"%"+
               "\nTotal rent: "+calcRent(30)+"$";
    }
}