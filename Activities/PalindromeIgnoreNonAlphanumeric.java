
import java.util.Scanner;

public class PalindromeIgnoreNonAlphanumeric {

    public static void main(String[] args) {
        
        System.out.print("Enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println("Discarding non-alphanumberic characters");
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String filtered = filter(s);

        return filtered.equals(reverse(filtered));
    }

    public static String filter(String s) {

        String input = s;
        char[] stringCharacters = input.toCharArray();
        char[] nonAlphanumericCharacters = new char[stringCharacters.length];
        int index = 0;

        for (char character : stringCharacters) {
            if (!Character.isLetterOrDigit(character)) {
                nonAlphanumericCharacters[index] = character;
                index++;
            }
        }

        for (int i = 0; i < index; i++) {
            input = input.replace(Character.toString(nonAlphanumericCharacters[i]), "");
        }

        return input;
    }

    public static String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }
}