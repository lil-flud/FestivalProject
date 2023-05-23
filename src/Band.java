import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

public class Band {
    String bandName;
//    ArrayList<String> members;
//    ArrayList<String> songs;

    public void setBandInfo() {
        this.setBandName();
    }

    public void setBandName() {
        Scanner scanner = new Scanner(in);
        boolean running = true;
        while (running) {
            out.print("Band name: ");
            String potentialName = scanner.next();
            potentialName += scanner.nextLine();
            out.println("Is " + potentialName + " correct? [Y]es, [N]o: ");
            String confirmation = "";
            boolean confirmed = false;
            while (!confirmed) {
                confirmation = scanner.next().toLowerCase();
                switch (confirmation) {
                    case "y":
                        this.bandName = potentialName;
                        running = false;
                        confirmed = true;
                        break;
                    case "n":
                        confirmed = true;
                        break;
                    default:
                        out.println("Invalid input!");
                        break;
                }
            }
        }
    }
}
