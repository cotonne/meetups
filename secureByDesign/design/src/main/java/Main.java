import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //\u001B[41m

        System.out.println("Registration ---- ");
        System.out.println("Name:");
        String name = s.next();
        System.out.println("Password:");
        String password = s.next();

        register(name, password);

        System.out.println("Connection : ");
        System.out.println("Name:");
        name = s.next();
        System.out.println("Password:");
        password = s.next();

        if(login(name, password)) {
            System.out.println("You are connected as " + name);

            System.out.println("Films:");
            System.out.println("H1)	Harry Potter and the Philosopher's Stone (2001)");
            System.out.println("H2)	Harry Potter and the Chamber of Secrets (2002)");
            System.out.println("H3)	Harry Potter and the Prisoner of Azkaban (2004)");
            System.out.println("H4)	Harry Potter and the Goblet of Fire (2005)");
            System.out.println("H5)	Harry Potter and the Order of the Phoenix (2007)");
            System.out.println("H6)	Harry Potter and the Half-Blood Prince (2009)");
            System.out.println("H7)	Harry Potter and the Deathly Hallows – Part 1 (2010)");
            System.out.println("H8)	Harry Potter and the Deathly Hallows – Part 2 (2011)");
            System.out.println("Selection: ");
            String selection = s.next();
            System.out.println("Quantity: ");
            int quantity = s.nextInt();

            order(selection, quantity);
        }

    }

    private static void order(String selection, int quantity) {
        
    }

    private static boolean login(String name, String password) {
        return true;
    }

    private static void register(String name, String password) {

    }
}
