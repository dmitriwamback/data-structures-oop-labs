public class Address {
    private int civicNumber;
    private String streetName;
    private String city;
    private String postalCode;
    private String province;
    private String country;

    public Address(int civicNumber, String streetName, String city, String postalCode, String province, String country) {
        this.civicNumber = civicNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    public int getCivicNumber() {
        return civicNumber;
    }
    public String getStreetName() {
        return streetName;
    }
    public String getCity() {
        return city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getProvince() {
        return province;
    }
    public String getCountry() {
        return country;
    }

    public void setCivicNumber(int civicNumber) {
        this.civicNumber = civicNumber;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Override public String toString() {
        return "Civic number: " + civicNumber +
               " Street name: " + streetName +
               " City: " + city +
               " Postal Code: " + postalCode +
               " Province: " + province +
               " Country: " + country;
    }
}
