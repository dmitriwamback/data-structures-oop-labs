import java.util.ArrayList;
import java.util.Scanner;

public class RepeatAdditionQuiz {

    public static void start() {

        // create list of all the previously answered guesses
        ArrayList<Integer> enteredAnswers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // create random number
        int number1 = (int)(Math.random()*10) + 1;
        int number2 = (int)(Math.random()*10) + 1;

        // infinite loop until the user guesses correctly
        while (true) {

            // prompt
            System.out.print("What is " + number1 + " + " + number2 + "? ");
            int answer = scanner.nextInt();

            // compare
            if (number1 + number2 != answer) {

                // if the user already guessed the same number
                if (enteredAnswers.contains(answer)) {
                    System.out.println("Wrong! You already entered that answer");
                }
                // otherwise add it to the 'enteredAnswers'
                else {
                    System.out.println("Wrong!");
                    enteredAnswers.add(answer);
                }
            }
            else {
                System.out.println("You got it!");
                break;
            }
        }
    }
}