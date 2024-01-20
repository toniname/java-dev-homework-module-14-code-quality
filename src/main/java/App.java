import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import static java.lang.System.*;

public class App {
    static byte winner = 0;
    static char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static byte input;
    static byte rand;
    static byte i = 0;
    private static final AtomicBoolean boxAvailable = new AtomicBoolean(false);
    private static final Scanner scan = new Scanner(in);

    public static void main(String[] args) {
        out.println("Enter box number to select. Enjoy!\n");


        boolean boxEmpty = false;
        while (true) {
            for (String s : Arrays.asList(STR."\n\n \{box[0]} | \{box[1]} | \{box[2]} ", "-----------", STR." \{box[3]} | \{box[4]} | \{box[5]} ", "-----------", STR." \{box[6]} | \{box[7]} | \{box[8]} \n")) {
                out.println(s);
            }
            if (!boxEmpty) {
                for (i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }


            if (winner == 1) {
                out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if (winner == 2) {
                out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if (winner == 3) {
                out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }

            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                } else
                    out.println("Invalid input. Enter again.");
            }

            if ((box[0] == 'X' && box[1] == 'X' && box[2] == 'X') || (box[3] == 'X' && box[4] == 'X' && box[5] == 'X') || (box[6] == 'X' && box[7] == 'X' && box[8] == 'X') ||
                    (box[0] == 'X' && box[3] == 'X' && box[6] == 'X') || (box[1] == 'X' && box[4] == 'X' && box[7] == 'X') || (box[2] == 'X' && box[5] == 'X' && box[8] == 'X') ||
                    (box[0] == 'X' && box[4] == 'X' && box[8] == 'X') || (box[2] == 'X' && box[4] == 'X' && box[6] == 'X')) {
                winner = 1;
                continue;
            }

            boxAvailable.set(false);
            for (i = 0; i < 9; i++) {
                if (box[i] != 'X' && box[i] != 'O') {
                    boxAvailable.set(true);
                    break;
                }
            }

            if (!boxAvailable.get()) {
                winner = 3;
                continue;
            }

            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                    box[rand - 1] = 'O';
                    break;
                }
            }

            if ((box[0] == 'O' && box[1] == 'O' && box[2] == 'O') || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O') || (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') ||
                    (box[0] == 'O' && box[3] == 'O' && box[6] == 'O') || (box[1] == 'O' && box[4] == 'O' && box[7] == 'O') || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O') ||
                    (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O')) {
                winner = 2;
            }
        }

    }

}
