import java.util.*;

public class ShoppingAppv2 {

    private static final Map<String, Integer> menu = new LinkedHashMap<>();
    private static final Map<String, Integer> cart = new LinkedHashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setupMenu();
        while (true) {
            showMenu();
            String input = readLine("Product (type product or press enter to print invoice): ").trim(); //Gõ sản phẩm hoặc enter để in hóa đơn

            if (input.isEmpty()) {
                if (cart.isEmpty()) {
                    System.out.println("Invalid request. Cart is empty."); // Nếu giỏ hàng không có gì, gõ enter
                } else {
                    showInvoice();
                }
            } else if (!menu.containsKey(input)) {
                System.out.println("Invalid product, please try again."); //Nếu sản phẩm không hợp lệ
            } else {
                int quantity = readQuantity(input);
                if (quantity == 0) {
                    if (!cart.containsKey(input)) {
                        System.out.println("Invalid. Product not in cart."); //Nếu sản phẩm chưa có trong giỏ hàng và trả giá trị về 0, trả kết quả như vậy
                    } else {
                        cart.remove(input);
                        System.out.println(input + " removed from cart."); //Nếu sản phẩm đã có trong giỏ hàng, và trả kết quả cuối về 0, thì hiển thị là đã xóa khỏi giỏ hàng
                    }
                } else {
                    cart.put(input, cart.getOrDefault(input, 0) + quantity);
                    if (cart.get(input) <= 0) {
                        cart.remove(input);
                        System.out.println(input + " removed from cart."); // Nếu mà tổng số sản phẩm bé hơn 0 -> xóa sản phẩm khỏi giỏ hàng
                    } else {
                        System.out.println(input + " added to cart. Current quantity: " + cart.get(input)); // else
