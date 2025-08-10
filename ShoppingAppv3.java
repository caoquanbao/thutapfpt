import java.util.*;

public class ShoppingAppv3 {

    private static final Map<String, Integer> menu = new LinkedHashMap<>();
    private static final Map<String, Integer> cart = new LinkedHashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setupMenu();
        while (true) {
            showMenu();
            String input = readLine("Product (type product or press enter to print invoice): ").trim();

            if (input.isEmpty()) {
                if (cart.isEmpty()) {
                    System.out.println("Invalid request. Cart is empty.");
                } else {
                    showInvoice();
                }
            } else if (!menu.containsKey(input)) {
                System.out.println("Invalid product, please try again.");
            } else {
                int quantity = readQuantity(input);

                if (quantity <= 0) {
                    System.out.println("Invalid quantity. Please enter a number greater than 0.");
                    continue;
                }

                cart.put(input, cart.getOrDefault(input, 0) + quantity);
                System.out.println("Current cart: " + cart);
            }
        }
    }

    private static void setupMenu() {
        menu.put("Apple", 10000);
        menu.put("Banana", 5000);
        menu.put("Orange", 7000);
        menu.put("Grape", 20000);
        menu.put("Peach", 15000);
        menu.put("Lemon", 12000);
        menu.put("Coconut", 25000);
    }

    private static void showMenu() {
        System.out.println("\n--- MENU ---");
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            System.out.printf("%-10s : %dVND\n", entry.getKey(), entry.getValue());
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int readQuantity(String product) {
        String input = readLine("Quantity (must be > 0): ").trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity, please try again.");
            return 0;
        }
    }

    private static void showInvoice() {
        System.out.println("\n--- INVOICE ---");
        int total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String name = entry.getKey();
            int quantity = entry.getValue();
            int price = menu.get(name);
            int subtotal = quantity * price;
            total += subtotal;
            System.out.printf("%-10s x%-3d = %dVND\n", name, quantity, subtotal);
        }
        System.out.println("Total: " + total + "VND");

        readLine("Press [Enter] to checkout: ");
        System.out.println("Thank you for buying, see you soon!");
        System.exit(0);
    }
}
