import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static boolean cont = true;
    static Scanner scanner = new Scanner(System.in);
    static Snap snap;
    public static void main() throws IOException {
        while (cont){
            snap = new Snap();
            snap.runGame();
            System.out.println("Play again?");
            System.out.println("Enter y to continue and anything else to exit");
            if(!Objects.equals(scanner.nextLine(), "y")){
                cont = false;
            }
            else{
                System.out.println("Game ending");
            }
        }
    }
}
