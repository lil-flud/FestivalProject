import java.util.ArrayList;
import static java.lang.System.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Scanner;

public class Festival {
    String festName;
    String location;
    int audienceSize;
//    byte numOfStages;
    ArrayList<String> lineup = new ArrayList<String>();
    Boolean correctlyCreated;

    public void setFestivalInfo() {
        Scanner scanner = new Scanner(in);
        this.setName();
        this.setLocation();
//        this.setNumOfStages();
        this.setAudienceSize();
        Boolean running = true;
        while (running) {
            String confirmation = String.format("--Festival Name: %s\n--Festival Location: %s\n--Expected Audience Size: %s\n--Is this correct? [Y]es or [N]o: ", this.festName, this.location, this.audienceSize);
            out.print(confirmation);
            String input = scanner.next().toLowerCase();
            switch (input) {
                case "y":
                    this.correctlyCreated = true;
                    running = false;
                    break;

                case "n":
                    this.correctlyCreated = false;
                    running = false;
                    break;

                default:
                    out.println("Invalid option!");
                    break;
            }
        }


    }

    public void setName() {
        Scanner scanner = new Scanner(in);
        boolean confirmed;
        boolean running = true;
        while (running) {
            out.println("Festival name: ");
            String potentialName = scanner.next();
            potentialName += scanner.nextLine();
            out.println(potentialName);
            String confirmation = "";
            if (!potentialName.equals("")) {
                confirmed = false;
            } else {
                confirmed = true;
            }
            while (!confirmed) {
                out.println("Is " + potentialName + " correct? [Y]es, [N]o: ");
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
//    public void setNumOfStages() {
//        boolean running = true;
//        boolean valid;
//        Scanner scan = new Scanner(in);
//        while (running) {
//            out.print("How many stages will there be at this festival? (1-5): ");
//            String numStages = scan.next();
//            valid = this.validateByte(numStages);
//            if (valid) {
//                this.numOfStages = Byte.valueOf(numStages);
//                running = false;
//            }
//        }
//    }
    private boolean validateByte(String potentialByte) {
        Byte num;
        boolean valid;
        try {
            num = Byte.parseByte(potentialByte);
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
            num = Integer.parseInt(potentialInt);
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

    public void pickBandsForLineUp(HashMap<String, Band> allBandsMap, ArrayList<Gig> gigsList) {
        Boolean running = true;
        byte numberOfBandsChosen = 0;
        Scanner scanner = new Scanner(in);
        while (running) {
            Band addedBand;
            int numberInLineCounter = 0;
            int printCounter = 0;
            String bandChoicesPrint = "";
            for (Band eachBand : allBandsMap.values()) {
                if (!this.lineup.contains(eachBand.bandName)) {
                    printCounter += 1;
                    numberInLineCounter++;
                    bandChoicesPrint += numberInLineCounter + ".) " + eachBand.bandName + ", ";
                }
                if (printCounter == 3) {
                    out.println(bandChoicesPrint);
                    bandChoicesPrint = "";
                    printCounter = 0;
                }
            }
            if (printCounter < 3 && !bandChoicesPrint.equals("")) {
                out.println(bandChoicesPrint);
            }
            out.print("Which band would you like to add to the lineup? (Press [Q] to quit): ");
            String chosenBand = scanner.next();
            chosenBand += scanner.nextLine();
            if (chosenBand.toLowerCase().equals("q")) {
                running = false;
            } else {
                for (Band eachBand : allBandsMap.values()) {
                    if (eachBand.bandName.equalsIgnoreCase(chosenBand)) {
                        Gig newGig = new Gig(eachBand, this);
                        gigsList.add(newGig);
                        this.lineup.add(newGig.band.bandName);
                    }
                }
            }
        }
    }
    public void displayLineUp() {
        for (String eachBandName : this.lineup) {
            out.println(eachBandName);
        }
    }
}
