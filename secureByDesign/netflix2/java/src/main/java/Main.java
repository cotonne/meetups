import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Registration ---- ");
        System.out.println("Identifier:");
        String userId = s.next();
        System.out.println("Password:");
        String password = s.next();

        register(userId, password);

        System.out.println("Connection : ");
        System.out.println("Identifier:");
        userId = s.next();
        System.out.println("Password:");
        password = s.next();

        if (login(userId, password)) {
            System.out.println("Films:");

            // List DVD HERE
            // Format
            // dvdId) dvdName

            System.out.println("Selection: ");
            String dvdId = s.next();
            System.out.println("Quantity: ");
            int quantity = s.nextInt();

            booking(dvdId, quantity, userId);
        }

    }

    private static void register(String userId, String password) {

    }

    private static boolean login(String userId, String password) {
        return true;
    }

    private static void booking(String dvdId, int quantity, String userId) {

    }
}
