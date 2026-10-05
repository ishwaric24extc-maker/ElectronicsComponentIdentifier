import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Component> components = ComponentDatabase.getComponents();
        int choice;
        do {
            System.out.println("\n======================================");
            System.out.println("     ELECTRONICS COMPONENT IDENTIFIER");
            System.out.println("======================================");
            System.out.println("1. Search Component");
            System.out.println("2. Display All Components");
            System.out.println("3. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter component name: ");
                    String search = sc.nextLine();
                    boolean found = false;
                    for (Component component : components) {
                        if (component.name.equalsIgnoreCase(search)) {
                            System.out.println("\n---------- COMPONENT DETAILS ----------");
                            System.out.println("Name         : " + component.name);
                            System.out.println("Category     : " + component.category);
                            System.out.println("Function     : " + component.function);
                            System.out.println("Pins         : " + component.pins);
                            System.out.println("Applications : " + component.applications);
                            System.out.println("Advantages   : " + component.advantages);
                            System.out.println("---------------------------------------");

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("\nComponent not found.");
                    }
                    break;

                case 2:
                    System.out.println("\nAVAILABLE COMPONENTS:");
                    System.out.println("---------------------");

                    for (Component component : components) {
                        System.out.println("- " + component.name);
                    }
                    break;

                case 3:
                    System.out.println("\nThank you for using Electronics Component Identifier!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}