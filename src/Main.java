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
            out.print("[C]reate festival, [V]iew festival, [E]dit festival, create [B]and, or [Q]uit: ");
            String option = sc.next().toLowerCase();
            switch (option) {
                case "c":
                    Festival newFestival = new Festival();
                    newFestival.setFestivalInfo();
                    festivalMap.put(newFestival.festName, newFestival);
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
                                out.print("Please enter the name of the festival you would like to view: ");
                                String chosenFest = sc.next();
                                chosenFest += sc.nextLine();
                                for (String festName : festivalMap.keySet()) {
                                    if (festName.equals(chosenFest)) {
                                        currFest = festivalMap.get(chosenFest);
                                        out.println(currFest.festName);
                                        out.println(currFest.location);
                                        out.println(currFest.numOfStages);
                                        out.println(currFest.audienceSize);
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
//                                currentState = "Main-Menu";
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

                case "q":
                    running = false;
                    break;
                default:
                    out.println("Invalid option!");
                    break;
            }
        }
//        while (currentState.equals("Viewing")) {
//            out.print("View [F]estivals or [B]ands: ");
//            String option = sc.next().toLowerCase();
//            switch (option) {
//                case "f":
//                    for (String festName : festivalMap.keySet()) {
//                        Festival eachFest = festivalMap.get(festName);
//                        out.println(eachFest.festName);
//                    }
//
//                    Festival currFest;
//                    out.print("Please enter the name of the festival you would like to view: ");
//                    String chosenFest = sc.next();
//                    chosenFest += sc.nextLine();
//                    for (String festName : festivalMap.keySet()) {
//                        if (festName.equals(chosenFest)) {
//                            currFest = festivalMap.get(chosenFest);
//                            out.println(currFest.festName);
//                            out.println(currFest.location);
//                            out.println(currFest.numOfStages);
//                            out.println(currFest.audienceSize);
//                        } else {
//                            out.println("Invalid festival name!");
//                        }
//                    }
//                    break;
//
//                case "b":
//                    for (String bandName : bandsMap.keySet()) {
//                        Band eachBand = bandsMap.get(bandName);
//                        out.println(eachBand.bandName);
//                    }
//
//                    Band currBand;
//                    out.print("Please enter the name of the band you would like to view: ");
//                    String chosenBand = sc.next();
//                    chosenBand += sc.nextLine();
//                    for (String bandName : bandsMap.keySet()) {
//                        if (chosenBand.equals(bandName)) {
//                            currBand = bandsMap.get(chosenBand);
//                            out.println(currBand.bandName);
//                        } else {
//                            out.println("Invalid band name!");
//                        }
//                    }
//                    break;
//
//                case "m":
//                    currentState = "Main-Menu";
//                    break;
//
//                default:
//                    out.println("Invalid input!");
//                    break;
//            }
//
//        }
//        while (currentState.equals("Festival-Management")) {
//
//        }
//
//        while (currentState.equals("Band-Management")) {
//
//        }
    }
}