import java.util.Scanner;

public class Main {
    private static final int ADD_PROPERTY = 1;
    private static final int LIST_ALL_PROPERTIES = 2;
    private static final int FIND_PROPERTY = 3;
    private static final int CALCULATE_AVERAGE_AREA = 4;
    private static final int EXIT = 9;
    private static Scanner sc;


    public static void main(String[] args) {
        sc = new Scanner(System.in);
        PropertyRegister propertyRegister = new PropertyRegister();
        fillWithTestData(propertyRegister);
        start(propertyRegister);
    }
    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     * If 0 is returned, the user has entered a wrong value
     */
    private static int showMenu()
    {
        int menuChoice = 0;
        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property");
        System.out.println("4. Calculate average area");
        //TODO: Add more menus
        System.out.println("9. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");

        if (sc.hasNextInt()) {
            menuChoice = Integer.parseInt(sc.nextLine());
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }
    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public static void start(PropertyRegister propertyRegister) {
        boolean finished = false;
// The while-loop will run as long as the user has not selected
// to quit the application
        while (!finished) {
            int menuChoice = showMenu();
            switch (menuChoice) {
                case ADD_PROPERTY:
                    try{
                        int municipalityNumber = Integer.parseInt(getInput("Municipality Number"));
                        int lotNumber = Integer.parseInt(getInput("Lot Number"));
                        int sectionNumber = Integer.parseInt(getInput("Section Number"));
                        String municipalityName = getInput("Municipality Name");
                        String name = getInput("Property Name (Empty if none)");
                        double area = Double.parseDouble(getInput("Area"));
                        String ownerName = getInput("Name of owner");

                        Property registeredProperty;
                        if(name.isBlank()){
                            registeredProperty = propertyRegister.registerProperty(municipalityNumber, municipalityName,
                                    lotNumber, sectionNumber, area, ownerName);
                        }else{
                            registeredProperty = propertyRegister.registerProperty(municipalityNumber, municipalityName,
                                    lotNumber, sectionNumber, name, area, ownerName);
                        }
                        System.out.println(registeredProperty);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case LIST_ALL_PROPERTIES:
                    System.out.println(propertyRegister.toString());
                    break;
                case FIND_PROPERTY:
                    int municipalityNumber = Integer.parseInt(getInput("Municipality Number"));
                    int lotNumber = Integer.parseInt(getInput("Lot Number"));
                    int sectionNumber = Integer.parseInt(getInput("Section Number"));
                    Property foundProperty = propertyRegister.findProperty(municipalityNumber, lotNumber, sectionNumber);
                    if(foundProperty == null){
                        System.out.println("Couldn't find property with Id: "
                                + municipalityNumber + "-" + lotNumber + "/" + sectionNumber);
                    }else {
                        System.out.println(foundProperty);
                    }
                    break;
                case CALCULATE_AVERAGE_AREA:
                    double averageArea = Math.round(propertyRegister.getAverageArea() * 100.0) / 100.0;
                    System.out.println("Average area is: " + averageArea + " m^2");
                    break;
                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    break;
                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
    }

    private static void fillWithTestData(PropertyRegister propertyRegister){
        propertyRegister.registerProperty(1445,"Gloppen",77,631,
                1017.6,"Jens Olsen");
        propertyRegister.registerProperty(1445,"Gloppen",77,131,
                "Syningom", 661.3,"Nicolay Madsen");
        propertyRegister.registerProperty(1445,"Gloppen",75,19,
                "Fugletun", 650.6,"Evilyn Jensen");
        propertyRegister.registerProperty(1445,"Gloppen",74,188,
                1457.2,"Karl Ove Bråten");
        propertyRegister.registerProperty(1445,"Gloppen",69,47,
                "Høiberg",1339.4,"Elsa Indregård");
    }

    private static String getInput(String name){
        System.out.println("Please insert " + name);
        return sc.nextLine();
    }
}