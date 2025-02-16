import java.util.Scanner;

public class TownHouseDemo {
    
    public static void main(String[] args) {
        
        TownHouse[] houseArray = new TownHouse[3];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < houseArray.length; i++) {
            System.out.println("Enter address:");

            // inputting address
            Address address = inputAddress(scanner);

            // inputting color
            String color;
            System.out.print("Input color: ");
            scanner = new Scanner(System.in);
            color = scanner.nextLine();

            // using promptInt
            int noOfBeds = promptInt(scanner, "Input number of beds: "),
                noOfWashRooms = promptInt(scanner, "Input number of washrooms: "),
                noOfFloors = promptInt(scanner, "Input number of floors: "),
                yearOfConstruction = promptInt(scanner, "Input year of construction: ");
            
            System.out.println("Is water front: ");
            boolean isWaterFront = scanner.nextBoolean();

            // using promptDouble
            double dailyRent = promptDouble(scanner, "Input daliy rent: "),
                   discountRent = promptDouble(scanner, "Input discount rent: ");

            TownHouse townHouse;

            // check indices for i
            if (i == 0) {
                // no-args constructor
                townHouse = new TownHouse();
                townHouse.setAddress(address);
                townHouse.setColor(color);
                townHouse.setNoOfBeds(noOfBeds);
                townHouse.setNoOfWashRooms(noOfWashRooms);
                townHouse.setNoOfFloors(noOfFloors);
                townHouse.setYearOfConstruction(yearOfConstruction);
                townHouse.setWaterFront(isWaterFront);
                townHouse.setDailyRent(dailyRent);
                townHouse.setDiscountRate(discountRent);
                houseArray[0] = townHouse;
            }
            else if (i == 1) {
                // 'half'-args constructor
                townHouse = new TownHouse(address, color, noOfBeds, noOfWashRooms);
                townHouse.setNoOfFloors(noOfFloors);
                townHouse.setYearOfConstruction(yearOfConstruction);
                townHouse.setWaterFront(isWaterFront);
                townHouse.setDailyRent(dailyRent);
                townHouse.setDiscountRate(discountRent);
                houseArray[1] = townHouse;
            }
            else if (i == 2) {
                // full constuctor
                townHouse = new TownHouse(address, color, noOfBeds, noOfWashRooms, noOfFloors, yearOfConstruction, isWaterFront, dailyRent, discountRent);
                houseArray[2] = townHouse;
            }
            // seperator
            System.out.println("--------------------------------------------------");
        }

        // find the cheapest rent
        double cheapestRent = houseArray[0].getDailyRent();

        // print data and get cheapest house
        for (TownHouse townHouse : houseArray) {
            System.out.println(townHouse.toString());
            System.out.println("---------------------------------------------------------------------------------------------------");

            if (townHouse.getDailyRent() < cheapestRent) {
                cheapestRent = townHouse.getDailyRent();
            }
        }

        // print the cheapest rent
        System.out.println("cheapest rent: " + cheapestRent);
    }
    /**
     * This function uses validateString to get the user information for the address
     * @param scanner for reading user input
     * @return The address class (Address)
     */
    private static Address inputAddress(Scanner scanner) {
        System.out.print("\tCivic number: ");
        int civicNumber = scanner.nextInt();

        // inputting information and validating them
        String streetName = validateString(scanner, "\tStreet Name: ", false);
        String city = validateString(scanner, "\tCity: ", false);
        String postalCode = validateString(scanner, "\tPostal Code: ", true);
        String province = validateString(scanner, "\tProvince: ", false);
        String country = validateString(scanner, "\tCountry: ", false);

        return new Address(civicNumber, streetName, city, postalCode, province, country);
    }
    
    /**
     * This function validates a string for a given prompt and discards strings that have invalid characters
     * @param scanner for reading user input
     * @param prompt prompt the user what to input
     * @param includeNumbers when we need to use numbers in a given string
     * @return the validated string
     */
    private static String validateString(Scanner scanner, String prompt, boolean includeNumbers) {

        scanner = new Scanner(System.in);

        System.out.print(prompt);
        String result = scanner.nextLine();
        boolean hasInvalidCharacters = false; // flag

        do { 
            char[] characters = result.toCharArray(); // get each character

            // go through each character
            for (char c : characters) {
                hasInvalidCharacters = false;

                if (!includeNumbers) {
                    // checking for unvalid characters other than spaces
                    if (!Character.isLetter(c) && c != ' ') {
                        hasInvalidCharacters = true;
                        System.out.print(prompt);
                        result = scanner.nextLine();
                        break; // break if we find an invalid character excluding space
                    }
                }
                else {
                    // checking for invalid characters other than numbers and spaces
                    if (!Character.isLetterOrDigit(c) && c != ' ') {
                        hasInvalidCharacters = true;
                        System.out.print(prompt);
                        result = scanner.nextLine();
                        break; // break if we find an invalid character excluding space and numbers
                    }
                }
            }

        } while (hasInvalidCharacters);

        return result;
    }

    /**
     * This function prompts the user to enter an integer with validation
     * @param scanner for reading user input
     * @param prompt to prompt the user what to input
     * @return validated integer i.e. >= 0
     */
    private static int promptInt(Scanner scanner, String prompt) {
        int result = -1;
        scanner = new Scanner(System.in);

        while (result < 0) {
            System.out.print(prompt);
            result = scanner.nextInt();
        }
        return result;
    }

    /**
     * This function prompts the user to enter a double with validation
     * @param scanner for reading user input
     * @param prompt to prompt the user what to input
     * @return validated double i.e. >= 0
     */
    private static double promptDouble(Scanner scanner, String prompt) {
        double result = -1;
        scanner = new Scanner(System.in);

        while (result < 0) {
            System.out.print(prompt);
            result = scanner.nextDouble();
        }
        return result;
    }
}
