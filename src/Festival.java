import java.util.ArrayList;
import static java.lang.System.*;

import java.util.Locale;
import java.util.Scanner;

public class Festival {
    String festName;
    String location;
    int audienceSize;
    byte numOfStages;
    ArrayList<Band> lineup;

    public void setFestivalInfo() {
        this.setName();
        this.setLocation();
        this.setNumOfStages();
        this.setAudienceSize();
    }

    public void setName() {
        Scanner scanner = new Scanner(in);
        boolean running = true;
        while (running) {
            out.println("Festival name: ");
            String potentialName = scanner.next();
            potentialName += scanner.nextLine();
            out.println("Is " + potentialName + " correct? [Y]es, [N]o: ");
            String confirmation = "";
            boolean confirmed = false;
            while (!confirmed) {
                confirmation = scanner.next().toLowerCase();
                switch (confirmation) {
                    case "y":
                        this.festName = potentialName;
                        running = false;
                        confirmed = true;
                        break;
                    case "n":
                        confirmed = true;
                        break;
                    default:
                        out.println("Invalid option!");
                }
            }
        }
    }

//
//    public void setLineup() {
//
//    }
//
    public void setLocation() {
        Scanner scanner = new Scanner(in);
        boolean running = true;
        while (running) {
            out.println("Festival location (Please enter location in 'City, State' format): ");
            String potentialLocation = scanner.next();
            potentialLocation += scanner.nextLine();
            out.println("Is " + potentialLocation + " correct? [Y]es, [N]o: ");
            String confirmation = "";
            boolean confirmed = false;
            while (!confirmed) {
                confirmation = scanner.next().toLowerCase();
                switch (confirmation) {
                    case "y":
                        this.location = potentialLocation;
                        running = false;
                        confirmed = true;
                        break;
                    case "n":
                        confirmed = true;
                        break;
                    default:
                        out.println("Invalid option!");

                }
            }
        }
    }
//
    public void setNumOfStages() {
        boolean running = true;
        boolean valid;
        Scanner scan = new Scanner(in);
        while (running) {
            out.print("How many stages will there be at this festival? (1-5): ");
            String numStages = scan.next();
            valid = this.validateByte(numStages);
            if (valid) {
                this.numOfStages = Byte.valueOf(numStages);
                running = false;
            }
        }
    }
    private boolean validateByte(String potentialByte) {
        Byte num;
        boolean valid;
        try {
            num = Byte.valueOf(potentialByte);
//            valid = (num > 0 && num < 6) ? true: false;
            if (num > 0 && num < 6) {
                valid = true;
            } else {
                out.println("Too many or too few stages!");
                valid = false;
            }
        } catch (NumberFormatException ex) {
            valid = false;
            out.println("Invalid input!");
        }
        return valid;
    }

    public void setAudienceSize() {
        boolean running = true;
        boolean valid;
        Scanner scan = new Scanner(in);
        while (running) {
            out.print("What is the expected size of the audience: ");
            String expectedAudienceSize = scan.next();
            valid = this.validateInt(expectedAudienceSize);
            if (valid) {
                this.audienceSize = Integer.valueOf(expectedAudienceSize);
                running = false;
            }
        }
    }

    private boolean validateInt(String potentialInt) {
        int num;
        boolean valid;
        try {
            num = Integer.valueOf(potentialInt);
            if (num > 0 && num < 100001) {
                valid = true;
            } else {
                out.println("Too large or too small audience size!");
                valid = false;
            }
        } catch (NumberFormatException ex) {
            valid = false;
            out.println("Invalid input!");
        }
        return valid;
    }

    public void pickBandsForLineUp(ArrayList<Band> allBands) {

    }

    public void setLineup(ArrayList<Band> lineup) {
        this.lineup = lineup;
    }
}
