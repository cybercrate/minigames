package com.wingmann.minigames;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game;

        System.out.println("""
                List of games:
                - guessing
                """);

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("command: ");
            command = scanner.nextLine();

            switch (command) {
                case "guessing" -> {
                    game = new GuessingGame();
                    game.play();
                }
                case "exit" -> System.exit(0);
                default -> System.err.println("Command not found");
            }
        }
    }
}
