import java.util.HashMap;
import java.util.Scanner;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        String currentState = "Main-Menu";
        boolean running = true;
        HashMap<String, Festival> festivalMap = new HashMap<>();
        HashMap<String, Band> bandsMap = new HashMap<>();


        while (running) {
            out.print("[C]reate festival, [V]iew festival, [S]et festival lineup, create [B]and, or [Q]uit: ");
            String option = sc.next().toLowerCase();
            switch (option) {
                case "c":
                    Festival newFestival = new Festival();
                    newFestival.setFestivalInfo();
                    if (newFestival.correctlyCreated.equals(true)) {
                        festivalMap.put(newFestival.festName, newFestival);
                        out.println(newFestival.festName + " festival created!");
                    } else {
                        newFestival = null;
                        out.println("Incorrectly created festival deleted!");
                    }
                    break;
                case "v":
//                    currentState = "Viewing";
                    boolean viewing = true;
                    while (viewing) {
                        out.print("View [F]estivals or [B]ands: ");
                        option = sc.next().toLowerCase();
                        switch (option) {
                            case "f":
                                for (String festName : festivalMap.keySet()) {
                                    Festival eachFest = festivalMap.get(festName);
                                    out.println(eachFest.festName);
                                }

                                Festival currFest;
                                out.println("Please enter the name of the festival you would like to view: ");
                                out.println("(Please type festival name exactly as you see it.)");
                                String chosenFest = sc.next();
                                chosenFest += sc.nextLine();
                                for (String festName : festivalMap.keySet()) {
                                    if (festName.equals(chosenFest)) {
                                        currFest = festivalMap.get(chosenFest);
                                        out.println(currFest.festName);
                                        out.println(currFest.location);
//                                        out.println(currFest.numOfStages);
                                        out.println(currFest.audienceSize);
                                        out.println(currFest.lineup);
                                    } else {
                                        out.println("Invalid festival name!");
                                    }
                                }
                                break;

                            case "b":
                                for (String bandName : bandsMap.keySet()) {
                                    Band eachBand = bandsMap.get(bandName);
                                    out.println(eachBand.bandName);
                                }

                                Band currBand;
                                out.print("Please enter the name of the band you would like to view: ");
                                String chosenBand = sc.next();
                                chosenBand += sc.nextLine();
                                for (String bandName : bandsMap.keySet()) {
                                    if (chosenBand.equals(bandName)) {
                                        currBand = bandsMap.get(chosenBand);
                                        out.println(currBand.bandName);
                                    } else {
                                        out.println("Invalid band name!");
                                    }
                                }
                                break;

                            case "m":
                                viewing = false;
                                break;

                            default:
                                out.println("Invalid input!");
                                break;
                        }
                    }
                    break;

                case "b":
                    Band newBand = new Band();
                    newBand.setBandInfo();
                    bandsMap.put(newBand.bandName, newBand);
                    break;

                case "s":
                    if (bandsMap.size() >= 5) {
                        int numberInLineCounter = 0;
                        int printCounter = 0;
                        String festivalPrint = "";
                        for (Festival eachFestival : festivalMap.values()) {
                            printCounter += 1;
                            numberInLineCounter += 1;
                            if (eachFestival.lineup.size() == 0) {
                                festivalPrint += numberInLineCounter + ".) " + eachFestival.festName + ", ";
                            }
                            if (printCounter == 3) {
                                out.println(festivalPrint);
                                festivalPrint = "";
                                printCounter = 0;
                            }
                        }
                        if (printCounter < 3 && !festivalPrint.equals("")) {
                            out.println(festivalPrint);
                        }

                        out.println("Which festival would you like to set the lineup for?");
                        out.println("(Type the name of the festival as it appears.)");
                        Festival currFest;
                        String chosenFest = sc.next();
                        chosenFest += sc.nextLine();
                        for (Festival eachFest : festivalMap.values()) {
                            if (eachFest.festName.equalsIgnoreCase(chosenFest)) {
                                currFest = eachFest;
                                currFest.pickBandsForLineUp(bandsMap);
                            }
                        }
                    } else {
                        out.println("There are not enough bands in the system to set a lineup yet!");
                    }
                    break;

                case "q":
                    running = false;
                    break;
                default:
                    out.println("Invalid option!");
                    break;
            }
        }
    }
}