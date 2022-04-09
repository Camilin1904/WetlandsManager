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
     * Looks for the wetland with the least species of flora
     */
    private void  LeastFloraWetland(){
        if(dagma.getRegWetlands()>0){
            System.out.println(dagma.LeastFloraWetland());
        }
        else{
            System.out.println("Register a wetland first");
        }
    }
    /**
     * Looks for the wetland with the most species of fauna
     */
    private void  MostFaunaWetland(){
        if(dagma.getRegWetlands()>0){
            System.out.println(dagma.MostFaunaWetland());
        }
        else{
            System.out.println("Register a wetland first");
        }
    }
    /**
     * Looks for the ammount of maintenance a given wetland recieves a year
     */
    private void NumMaintenance(){
        int index, year;
        index = DisplayWetlands();
        scan.nextLine();
        if(index>=0){
            System.out.println("Input the year");
            year = scan.nextInt();
            System.out.println("The amount of maintenace that year is: " + dagma.getNumMaintenance(index, year));
        }
    }
    /**
     * displays the wetlands and asks the user to pick one
     * @returnthe index of teh wetland and -1 if the wetland was not found
     */
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
    /**
     * displays the species and asks the user to pick one
     * @returnthe index of the specie and -1 if the specie was not found
     */
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
     * Prints the number of wetlands a specie inhabits
     */
    private void WetlandsWhereSpecieIs(){
        int index = DisplaySpecies();
        if(index>=0){
            System.out.println("the wetlands the specie inhabits are: " + dagma.getAllHabitats(index));
        }
    }
    /**
     * Register an event for a given wetland
     */
    private void RegisterEvent(){
        String  organizer = "", description = "", date = "";
        int type = 0, index = 0;
        double price = 0;
        boolean check = true;
        index = DisplayWetlands();
        if (index>=0){
            do{
                System.out.println("\nInput the type of the event: \n1). Maintenance \n2). School visit \n3). Bettering activities \n4). Celebrations");
                type = scan.nextInt();  
                if(type>=1&&type<=4){
                    check = false;
                }       
                else{
                    System.out.println("Invalid event");
                }
            }while(check);
            scan.nextLine();
            System.out.println("Input the name of the organizer");
            organizer = scan.nextLine();
            System.out.println("Input the price of the event");
            price = scan.nextDouble();
            scan.nextLine();
            System.out.println("input a short description for the event");
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
            int type = 0, zoneType = 0;
            String name, location, photoUrl, strProtectedStatus, zoneName;
            boolean protectedStatus=true, check=false;
            double percentage = 0, size = 0;
            scan.nextLine();
            System.out.println("Input the name of the Wetland");
            name = scan.nextLine();
            System.out.println("Input the location of the Wetland");
            location = scan.nextLine();
            System.out.println("Input the size of the Wetland");
            size = scan.nextDouble();
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
            if(protectedStatus){
                System.out.println("Input the percentage of completion of the environment manage plan");
                percentage = scan.nextDouble();
            }

            scan.nextLine();
            dagma.RegisterWetland(name, location, size, type, photoUrl, protectedStatus, zoneName, zoneType, percentage );
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
		boolean migratoryStatus = true, check = true, menuBool = true, assingBool = true, check2 = false;
        ArrayList<Integer> newWetland = new ArrayList<Integer>();
        int indexHolder = -1, specieIndex =  0, wetlandIndex = 0, type = 0, sType = 0;
        if(dagma.getRegWetlands()>0){
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
                            System.out.println("does the specie migrate?(yes or no)");
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
                            indexHolder = DisplayWetlands();
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
                                            check2 = true;
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
                        if(check2){
                            dagma.RegisterSpecie(name, scientificName, migratoryStatus, type, sType, newWetland); 
                        }
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
        else{
            System.out.println("Register a wetland first");
        }
    }
    /**
     * Dysplays all of the information about both the wetlands and the species
     */
    private void InfoDisplay(){
        if(dagma.getRegWetlands()>0){
            for (int counter=0; counter<dagma.getRegWetlands(); counter++){
                System.out.println("\nWetland " + (counter+1));
                System.out.println(dagma.PrintAllWetlands(counter));
            }
        }
        else{
            System.out.println("\nNo wetlands");
        }
        if(dagma.getNumSpecies()>0){
            for (int counter=0; counter<dagma.getNumSpecies(); counter++){
                System.out.println("\nSpecie " + (counter+1));
                System.out.println(dagma.PrintAllSpecies(counter));
            }
        }
        else{
            System.out.println("\nNo species");
        }
    }
    /**
     * the menu where the user is asked what to do next
     */
    private void Menu(){
        boolean checkMenu = true;
        String menu = "";
        do{
            System.out.println("\n\nWhat would you like to do?\n1)Register a wetland\n2)Assing a Specie to a wetland\n3)Register a new event\n4)Cuantity of maintenance a year for a wetland\n5)Display the wetland with the least ammount of flora\n6)Wetlands where a specie is found\n7)Display all the information for all wetlands and all the species\n8)Display the wetland with most ammount of fauna\nN)Exit");
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
                    LeastFloraWetland();
                    break;
                case ("6"):
                    WetlandsWhereSpecieIs();
                    break;
                case ("7"):
                    InfoDisplay();
                    break;
                case ("8"):
                    MostFaunaWetland();
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
        Manager.Menu();
    }
}
