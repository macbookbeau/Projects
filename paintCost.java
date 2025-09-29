import java.util.Scanner;

public class paintCost {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //Establishing variables//
        //These variables require user input
        int roomLength;
        int roomWidth;
        int roomHeight;

        int paintCoverage;
        double pricePerGallon;

        //Introductory output
        System.out.println("Welcome to the Paint Cost Estimator!");
        System.out.println("This program uses user input to calculate the cost of paint for a room.");
        System.out.println("First we will start with room dimensions.");

        //Begin user input
        System.out.println("Enter the room length (in feet):");
        roomLength = scnr.nextInt();
        System.out.println("Enter the room width (in feet):");
        roomWidth = scnr.nextInt();
        System.out.println("Enter the room height (in feet):");
        roomHeight = scnr.nextInt();

        System.out.println("Enter the paint coverage (square feet per gallon):");
        paintCoverage = scnr.nextInt();
        System.out.println("Enter the price of paint (per gallon):");
        pricePerGallon = scnr.nextDouble();

        //Establishing and initialising variables from user input
        int wallArea = (2 * (roomLength * roomHeight)) + (2 * (roomWidth * roomHeight));
        int gallonsNeed = Math.round(wallArea / paintCoverage);
        double totalCost = gallonsNeed * pricePerGallon;

        //End results formatted using % operators
        System.out.println("Your results: ");
        System.out.printf("- Wall Area: %d square feet%n", wallArea);
        System.out.printf("- Gallons of Paint Required: %d%n", gallonsNeed);
        System.out.printf("- Total Paint Cost: $%.2f%n", totalCost);
        System.out.println("Thank you for using the Paint Cost Estimator!");

    }
}