import java.util.Scanner;

public class anExperiment_One {
    public static void main(String[] args) {
        Scanner yeet = new Scanner(System.in);

        double numOne;
        double numTwo;
        double numThree;
        double numFour;

        System.out.println("This program acts as an experiment to see what I can do with Java.");

        //The following section gets the input from the user, assigning that input to the respective variables
        System.out.println("Please enter the first number: ");
        numOne = yeet.nextDouble();

        System.out.println("Please enter the second number: ");
        numTwo = yeet.nextDouble();

        System.out.println("Please enter the third number: ");
        numThree = yeet.nextDouble();

        System.out.println("Please enter the fourth number: ");
        numFour = yeet.nextDouble();

        System.out.println("The numbers you have chosen are: " + numOne + " " + numTwo + " " + numThree + " " + numFour);

//The next section experiments with some Math functions

        //New doubles based off of numOne
        double newNumOne_a = Math.pow(numOne, numOne);
        double newNumOne_b = Math.pow(numOne, numTwo);
        double newNumOne_c = Math.pow(numOne, numThree);
        double newNumOne_d = Math.pow(numOne, numFour);

        System.out.println("We created new variables based on numOne where we used Math.pow() to multiply numOne to the exponents of numOne through numFour.");
        System.out.println("We named these new variables newNumOne_x where x denotes the letters a-d.");
        System.out.println("These are the new numbers based on numOne: ");
        System.out.println("newNumOne_a = " + newNumOne_a);
        System.out.println("newNumOne_b = " + newNumOne_b);
        System.out.println("newNumOne_c = " + newNumOne_c);
        System.out.println("newNumOne_d = " + newNumOne_d);

//The above section could be repeated for numTwo through numFour, though that might be overkill.

//We're gonna experiment more with user input etc
        System.out.println("We will now be taking in new user input that requires a correct answer." + "\n" + "Perform the equations and input the correct answer.");

        double yallOne;
        double yallTwo;
        boolean validInput = false;

        do {
            System.out.println("What is 15 + 77?");
            if (yeet.hasNextDouble()) {
                yallOne = yeet.nextDouble();
                if (yallOne == 92) {
                    validInput = true;
                } else {
                    System.out.println("That is incorrect. Please try again.");
                }
            } else {
                System.out.println("That input is invalid. Please try again.");
                yeet.next();
            }
        } while (!validInput);

        System.out.println("Your answer was correct!");

        System.out.println("What is 75 * (175 - 38)?");
        if (yeet.hasNextDouble()) {
            yallTwo = yeet.nextDouble();
            if (yallTwo == 10275) {
                validInput = true;
            } else {
                System.out.println("That is incorrect. Please try again.");
            }
        } else {
            System.out.println("That input is invalid. Please try again.");
            yeet.next();
        }

        System.out.println("Your answer was correct!");
        yeet.close();
    }
}