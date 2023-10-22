package com.wingmann.guessing;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame implements Game {
    private static final int MIN = 1;
    private static final int MAX = 100;

    @Override
    public void play() {
        System.out.println("Guess the number!");

        int secretNumber = new Random().nextInt(MIN, MAX);
        int counter = 0;

        while (true) {
            int guess = getInput();

            if (!isValid(guess)) {
                System.out.printf("[i]: the secret number is between %d and %d%n", MIN, MAX);
                continue;
            }
            ++counter;

            if (check(guess, secretNumber)) {
                System.out.printf("[i]: count of attempts: %s%n", counter);
                break;
            }
        }
    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        int guess;

        while (true) {
            System.out.print("[input]: ");

            try {
                guess = Integer.parseInt(scanner.nextLine());
                return guess;
            } catch (NumberFormatException e) {
                System.err.println("[error]: input is incorrect");
            }
        }
    }

    private boolean isValid(int value) {
        return !((value < MIN) || (value > MAX));
    }

    private boolean check(int guess, int secretNumber) {
        if (guess < secretNumber) {
            System.out.println("[<]: too small");
        } else if (guess > secretNumber) {
            System.out.println("[>]: too large");
        } else  {
            System.out.println("\n[=]: you won!");
            return true;
        }
        return false;
    }
}
