package ui;
import java.util.ArrayList;
import java.util.Scanner;
import model.Dagma;
/**
 * Manage the wetlands of Cali
 */
public class WetlandsManager {
    /**
     * The object  that allows for the management of the wetlands of Cali
     */
    private Dagma dagma = new Dagma();
    /**
     * scan
     */
    private Scanner scan = new Scanner(System.in);
    /**
     * Looks for the wetland with the least species
     */
    private void  LeastPopulatedWetland(){
        System.out.println(dagma.LeastFloraWetland());
    }
    /**
     * Looks for the wetland with the most species
     */
    private void  MostPopulatedWetland(){
        System.out.println(dagma.MostFaunaWetland());
    }
    /**
     * Looks for the ammount of maintenance a given wetland recieves a year
     */
    private void NumMaintenance(){
        int index, menu;
        boolean check = true;
        do{
            System.out.println("Which Wetland: \n" + dagma.DisplayWetlands());
            menu = scan.nextInt();
            scan.nextLine();
            index = dagma.FindWetlandIndexDisplay(menu);
            if(index>=0){
                check = false;
            }
            else{
                System.out.println("non-existent wetland");
            }
        }while(check);
        System.out.println("the amount of maintenace a year is: " + dagma.getNumMaintenance(index));
    }
    private int DisplayWetlands(){
        int index = 0, menu = 0;
        boolean check = true;
        do{
            System.out.println("Which Wetland: \n" + dagma.DisplayWetlands() + "\n0). Exit");
            menu = scan.nextInt();
            scan.nextLine();
            index = dagma.FindWetlandIndexDisplay(menu);
            if(index>=0&&menu!=0){
                check = false;
            }
            else if (menu==0){
                check = false;
                index = -1;
            }
            else{
                System.out.println("non-existent Wetland");
            }
        }while(check);
        return index;
    }
    private int DisplaySpecies(){
        int index = 0, menu = 0;
        boolean check = true;
        do{
            System.out.println("Which Specie: \n" + dagma.DisplaySpecies() + "\n0). Exit");
            menu = scan.nextInt();
            scan.nextLine();
            index = dagma.FindSpecieIndexDisplay(menu);
            if(index>=0&&menu!=0){
                check = false;
            }
            else if (menu==0){
                check = false;
                index = -1;
            }
            else{
                System.out.println("non-existent Specie");
            }
        }while(check);
        return index;
    }
    /**
     * Returns the number of wetlands a specie inhabits
     */
    private void WetlandsWhereSpecieIs(){
        int index = DisplaySpecies();
        System.out.println("the wetlands whres the specie is are: " + dagma.getAllHabitats(index));
    }
    /**
     * Register an event for a givven wetland
     */
    private void RegisterEvent(){
        String type = "", organizer = "", description = "", date = "";
        double price = 0;
        boolean check = true;
        int index = DisplayWetlands();
        if (index>=0){
            System.out.println("\nInput the type of the event");
            type = scan.nextLine();
            System.out.println("Input the name of the organizer");
            organizer = scan.nextLine();
            System.out.println("Input the price of the event");
            price = scan.nextDouble();
            System.out.println("input a short description fo rthe event");
            description = scan.nextLine();
            do{
                System.out.println("Input the date of the event in format dd/mm/yyyy");
                date =scan.next();
                if (date.charAt(2)=='/'&&date.charAt(5)=='/'&&date.length()==10&&(date.charAt(0)>=48&&date.charAt(0)<=57)&&(date.charAt(1)>=48&&date.charAt(1)<=57)&&(date.charAt(3)>=48&&date.charAt(3)<=57)&&(date.charAt(4)>=48&&date.charAt(4)<=57)&&(date.charAt(6)>=48&&date.charAt(6)<=57)&&(date.charAt(7)>=48&&date.charAt(7)<=57)&&(date.charAt(8)>=48&&date.charAt(8)<=57)&&(date.charAt(9)>=48&&date.charAt(9)<=57)){
                    check = false;
                }
                else{
                    System.out.println("invalid date input");
                    check = true;
                }
            }while(check);
            dagma.RegisterEvent(index, type, organizer, description, price, date);
        }
    }
    /**
     * Registers a wetland into the database
     */
    private void RegisterWetland(){
        if(dagma.getRegWetlands()<dagma.getMAX_WETLANDS()){
            int numMaintenace = 0, type = 0, zoneType = 0;
            String name, location, size, photoUrl, strProtectedStatus, zoneName;
            double percentage;
            boolean protectedStatus=true, check=false;
            scan.nextLine();
            System.out.println("Input the name of the Wetland");
            name = scan.nextLine();
            System.out.println("Input the location of the Wetland");
            location = scan.nextLine();
            System.out.println("Input the size of the Wetland");
            size = scan.next();
            scan.nextLine();
            do{
                System.out.println("Input the type: \n1). Public\n2). Private");
                type = scan.nextInt();
                scan.nextLine();
                if(type==1||type==2){
                    check = false;
                }
                else{
                    System.out.println("Invalid type");
                    check = true;
                }
            }while(check);
            System.out.println("Input the photoUrl of the Wetland");
            photoUrl = scan.next();
            scan.nextLine();
            do{
                System.out.println("Input the protected status of the Wetland (yes or no)");
                strProtectedStatus = scan.next();
                strProtectedStatus.toLowerCase();
                scan.nextLine();
                if (strProtectedStatus.equals("yes")){
                    protectedStatus = true;
                    check = false;
                }
                else if (strProtectedStatus.equals("no")){
                    protectedStatus = false;
                    check = false;
                }
                else{
                    System.out.println("Invalid value");
                    check = true;
                }
            }while(check);
            do{
                System.out.println("Input the type o zone the Wetland is located in: \n1). Urban\n2). Rural");
                zoneType = scan.nextInt();
                scan.nextLine();
                if(zoneType==1||zoneType==2){
                    check = false;
                }
                else{
                    System.out.println("Invalid type");
                    check = true;
                }
            }while(check);
            System.out.println("Input the zone name where the Wetland is located(the name of the neighbourhood if its locates id an urban area, or the name of the municipality)");
            zoneName = scan.next();
            scan.nextLine();
            System.out.println("Input the percentage of completion of the environment manage plan of the wetland");
            percentage = scan.nextDouble();
            scan.nextLine();
            System.out.println("Input the pcuantity of maintenance a year it has");
            numMaintenace = scan.nextInt();
            scan.nextLine();
            dagma.RegisterWetland(name, location, size, type, photoUrl, protectedStatus, zoneName, zoneType, percentage, numMaintenace);
        }
        else{
            System.out.println("There is no space for more wetlands");
        }
    }
    /**
     * Either registers a new specie into the database or assings an existing specie into a new wetland
     */
    private void AssingSpecie(){
        String name, scientificName, strmigratoryStatus, menu;
		boolean migratoryStatus = true, check = true, menuBool = true, assingBool = true;
        ArrayList<Integer> newWetland = new ArrayList<Integer>();
        int indexHolder = -1, specieIndex =  0, wetlandIndex = 0, type = 0, sType = 0;
        do{
            System.out.println("Is the specie allready in any wetland?\n1)yes\n2)no\nN)Exit");
            menu = scan.next();
            scan.nextLine();
            menu.toUpperCase(); 
            switch (menu){
                case ("1"):
                    specieIndex = DisplaySpecies();
                    if(specieIndex>=0){
                        wetlandIndex = DisplayWetlands();
                        if(wetlandIndex>=0&&!dagma.IsSpecieInWetland(wetlandIndex, specieIndex)){
                            dagma.AssingHabitat(wetlandIndex, specieIndex);
                        }
                        else{
                            System.out.println("Specie already in Wetland");
                        }
                    }
                    assingBool = false;
                    break;
                case ("2"):
                    System.out.println("Input the name of the specie");
                    name = scan.nextLine();
                    scan.nextLine();
                    System.out.println("Input the scientific name of the specie");
                    scientificName = scan.nextLine();
                    scan.nextLine();
                    do{
                        System.out.println("does the specie migrate(yes or no)");
                        strmigratoryStatus = scan.next();
                        scan.nextLine();
                        strmigratoryStatus.toLowerCase();
                        if (strmigratoryStatus.equals("yes")){
                            migratoryStatus = true;
                            check = false;
                        }
                        else if (strmigratoryStatus.equals("no")){
                            migratoryStatus = false;
                            check = false;
                        }
                        else{
                            System.out.println("Invalid value");
                            check = true;
                        }
                    }while (check);
                    do{
                        System.out.println("Input the type of the specie: \n1). Flora\n2).Fauna");
                        type = scan.nextInt();
                        scan.nextLine();
                        if(type==1||type==2){
                            check = false;
                        }
                        else{
                            System.out.println("Invalid Type");
                            check = true;
                        }
                    }while(check);
                    switch (type){
                        case (1):
                            do{
                                System.out.println("Input the Specific type of the specie: \n1). Terrestrial\n2). Aquatic");
                                sType = scan.nextInt();
                                scan.nextLine();
                                if(sType==1||sType==2){
                                    check = false;
                                }
                                else{
                                    System.out.println("Invalid Type");
                                    check = true;
                                }
                            }while(check);
                            break;
                        case (2):
                            do{
                                System.out.println("Input the Specific type of the specie: \n1). Aquatic\n2). Bird\n3). Mammal");
                                sType = scan.nextInt();
                                scan.nextLine();
                                if(sType==1||sType==2||sType==3){
                                    sType++;
                                    check = false;
                                }
                                else{
                                    System.out.println("Invalid Type");
                                    check = true;
                                }
                            }while(check);
                            break;

                    }
                    
                    do{
                        indexHolder = DisplaySpecies();
                        if(indexHolder>=0){
                            if (!newWetland.contains(indexHolder)){
                                newWetland.add(indexHolder);
                                System.out.println(newWetland.size());
                            }
                            else{
                                System.out.println("The specie is allready in that wetland");
                            }
                            do{
                                System.out.println("is the specie in any more wetlands?(1 for yes 2 for no)");
                                menu = scan.next();
                                switch (menu){
                                    case("1"):
                                        check = true;
                                        menuBool = false;
                                        break;
                                    case("2"):
                                        check = false;
                                        menuBool = false;
                                        break;
                                    default:
                                        System.out.println("invalid option");
                                        menuBool = true;
                                }
                            }while(menuBool);
                        }
                        else{
                            check = false;
                        }

                    }while(check);
                    dagma.RegisterSpecie(name, scientificName, migratoryStatus, type, sType, newWetland);
                    assingBool = false;
                    break;

                case ("N"):
                    assingBool = false;
                    break;

                 default:
                    System.out.println("Invalid input");
                    assingBool = true;
            }
        }while(assingBool);

    }
    /**
     * Dysplays all of the information about both the wetlands and the species
     */
    private void InfoDisplay(){
        for (int counter=0; counter<dagma.getRegWetlands(); counter++){
            System.out.println("Wetland " + (counter+1));
            System.out.println(dagma.PrintAllWetlands(counter));
        }
        for (int counter=0; counter<dagma.getNumSpecies(); counter++){
            System.out.println("Specie " + (counter+1));
            System.out.println(dagma.PrintAllSpecies(counter));
        }
    }
    /**
     * the menu where the user is asked what to do next
     */
    private void menu(){
        boolean checkMenu = true;
        String menu = "";
        do{
            System.out.println("\n\nWhat would you like to do?\n1)Register a wetland\n2)Assing a Specie to a wetland\n3)Register a new event\n4)Cuantity of maintenance a year for a wetland\n5)Display the wetland with the least ammount of species\n6)Wetlands where a specie is found\n7)Display all the information for all wetlands\n8)Display the wetland with most ammount of species\nN)Exit");
            menu = scan.next();
            menu = menu.toUpperCase();
            switch (menu){
                case ("1"):
                    RegisterWetland();
                    break;
                case ("2"):
                    AssingSpecie();
                    break;
                case ("3"):
                    RegisterEvent();
                    break;
                case ("4"):
                    NumMaintenance();
                    break;
                case ("5"):
                    LeastPopulatedWetland();
                    break;
                case ("6"):
                    WetlandsWhereSpecieIs();
                    break;
                case ("7"):
                    InfoDisplay();
                    break;
                case ("8"):
                    MostPopulatedWetland();
                    break;
                case ("N"):
                    System.out.println("\n\nGoodbye");
                    checkMenu = false;
                    break;
            }

        }while(checkMenu);
    }
    /**
     * main
     * @param args
     */
    public static void main(String args[]){
        WetlandsManager Manager = new WetlandsManager();
        System.out.println("\nHello, this application was built to manage the different wetlands of Cali\n\n");
        Manager.menu();
    }
}