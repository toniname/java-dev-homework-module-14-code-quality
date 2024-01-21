import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.System.*;
import static java.lang.System.in;

public class TicTacToeGame {
    private static final AtomicBoolean boxAvailable = new AtomicBoolean(false);
    private static final Scanner scan = new Scanner(in);
    private byte winner = 0;
    private final char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};



    void play() {
        out.println("Enter box number to select. Enjoy!\n");

        do {
            printBoard();

            if (!boxAvailable.get()) {
                clearBoard();
                boxAvailable.set(true);
            }

            playerMove();
            if (checkWinner('X')) {
                winner = 1;
                continue;
            }

            if (!boxAvailable.get()) {
                winner = 3;
                continue;
            }

            computerMove();
            if (checkWinner('O')) {
                winner = 2;
            }

            if (winner != 0) {
                printResult();
                break;
            }
        } while (true);
    }

    private void printBoard() {
        for (String s : Arrays.asList(STR."\n\n \{box[0]} | \{box[1]} | \{box[2]} ",
                "-----------", STR." \{box[3]} | \{box[4]} | \{box[5]} ",
                "-----------", STR." \{box[6]} | \{box[7]} | \{box[8]} \n")) {
            out.println(s);
        }
    }

    private void clearBoard() {
        byte i = 0;
        for (i = 0; i < 9; i++) {
            box[i] = ' ';
        }
    }

    private void printResult() {
        if (winner == 1) {
            out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 2) {
            out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 3) {
            out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }

    private void playerMove() {
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O') {
                    out.println("That one is already in use. Enter another.");
                } else {
                    box[input - 1] = 'X';
                    break;
                }
            } else {
                out.println("Invalid input. Enter again.");
            }
        }
    }

    private void computerMove() {
        while (true) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private boolean checkWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            // Перевірка рядків
            if (box[i * 3] == symbol && box[i * 3 + 1] == symbol && box[i * 3 + 2] == symbol) {
                return true;
            }
            // Перевірка стовпців
            if (box[i] == symbol && box[i + 3] == symbol && box[i + 6] == symbol) {
                return true;
            }
        }
        // Перевірка діагоналей
        if (box[0] == symbol && box[4] == symbol && box[8] == symbol) {
            return true;
        }
        return box[2] == symbol && box[4] == symbol && box[6] == symbol;
    }
}