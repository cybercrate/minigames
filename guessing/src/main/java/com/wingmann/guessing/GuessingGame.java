package com.wingmann.guessing;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private static final int MIN = 1;
    private static final int MAX = 100;

    public void play() {
        System.out.println("Guess the number!");

        var secretNumber = new Random().nextInt(MIN, MAX);
        var counter = 0;
        var guess = 0;
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("[input]: ");

            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("[error]: input is incorrect");
                continue;
            }

            if ((guess < MIN) || (guess > MAX)) {
                System.out.println("[i]: the secret number is between 1 and 100");
                continue;
            }
            ++counter;

            if (guess < secretNumber) {
                System.out.println("[<]: too small");
            } else if (guess > secretNumber) {
                System.out.println("[>]: too large");
            } else  {
                System.out.printf("\n[=]: you won!\n[i]: count of attempts: %s", counter);
                break;
            }
        }
    }
}
