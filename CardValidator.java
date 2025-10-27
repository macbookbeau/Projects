/**
 * Credit Card Validator
 * CPSC 220-03 Project 2
 *
 * I pledge that the work in this lab is mine; any relevant sources are properly cited
 * Beau Wentz, 9. October 2025
 *
 * This code asks a user to input the name of a file.
 * This file will contain card numbers designated AmEx, MasterCard, or Visa.
 * The code is meant to check whether the given numbers match their respective card type.
 *
 * //Sources Cited\\
 * I referred back to the Lab for Chapter 5 for elements of this project
 * ChatGPT was referenced for some structural details, and for help with the checksum algorithm structure.
 * In-Class Maddie helped me as well.
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CardValidator {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);

        System.out.println("This program will determine if given card numbers are valid.");
        System.out.println("It will require a pre-made file that you will provide.");
        System.out.println("Enter the name of the file (usually a .txt document): ");
        String fileName = scnr.nextLine();

        FileInputStream fileReader = new FileInputStream(fileName);
        fileReader = new FileInputStream(fileName);
        Scanner inFS = new Scanner(fileReader);

        while (inFS.hasNext()) {
            String cardType = inFS.next();
            String cardNumber = inFS.next();

            boolean valid = true;
            String reason = "";

            int len = cardNumber.length();
            if (cardType.equals("AmericanExpress")) {
                if (len != 15) {
                    valid = false;
                    reason = "invalid length";
                }
            }
            else if (cardType.equals("MasterCard")) {
                if (len != 16) {
                    valid = false;
                    reason = "invalid length";
                }
            }
            else if (cardType.equals("Visa")) {
                if (len != 13 && len != 16) {
                    valid = false;
                    reason = "invalid length";
                }
            }

            if (valid) {
                if (cardType.equals("AmericanExpress")) {
                    if (!(cardNumber.startsWith("34") || cardNumber.startsWith("37"))) {
                        valid = false;
                        reason = "invalid prefix";
                    }
                }
                else if (cardType.equals("MasterCard")) {
                    if (!(cardNumber.startsWith("51") || cardNumber.startsWith("52") || cardNumber.startsWith("53") || cardNumber.startsWith("54") || cardNumber.startsWith("55"))) {
                        valid = false;
                        reason = "invalid prefix";
                    }
                }
                else if (cardType.equals("Visa")) {
                    if (!(cardNumber.startsWith("4"))) {
                        valid = false;
                        reason = "invalid prefix";
                    }
                }
            }

            if (valid) {
                int checksum = 0;
                boolean doubleChecksum = false;

                for (int i = cardNumber.length() - 1; i >= 0; i--) {
                    int digit = cardNumber.charAt(i) - '0';

                    if (doubleChecksum) {
                        digit = digit * 2;
                        if (digit > 9) {
                            digit = digit - 9;
                        }
                    }

                    checksum = checksum + digit;
                    doubleChecksum = !doubleChecksum;
                }

                if (checksum % 10 != 0) {
                    valid = false;
                    reason = "invalid checksum";
                }
            }
            if (valid) {
                System.out.printf("%-20s %-20s %-20s%n", cardType, cardNumber, "valid");
            } else {
                System.out.printf("%-20s %-20s %-20s%n", cardType, cardNumber, reason);
            }

        }

    }
}