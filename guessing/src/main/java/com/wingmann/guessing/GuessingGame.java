package com.wingmann.guessing;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public void play() {
        System.out.println("Guess the number!");

        final var min = 1;
        final var max = 100;
        var secretNumber = new Random().nextInt(min, max);
        var counter = 0;
        var guess = 0;
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("[input]: ");

            try {
                guess = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.err.println("[error]: your input is incorrect");
                continue;
            }

            if ((guess < min) || (guess > max)) {
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
