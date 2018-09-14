import java.util.Scanner;





/**.
 * This is solution
 */
public final class Solution {
    /**.
     * This is solution constructor
     */
    private Solution() {
        //This is solution
    }
    /**.
     * This is main
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        ShoppingCart s = new ShoppingCart();
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "Item":
                String[] data = tokens[1].split(",");
                s.addToCatalog(new Item(data[0], Integer.
                    parseInt(data[1]), Integer.
                    parseInt(data[2])));
                break;
            case "catalog":
                s.showCatalog();
                break;
            case "add":
                String[] data1 = tokens[1].split(",");
                s.addToCart(new Item(data1[0], Integer.
                    parseInt(data1[1])));
                break;
            case "remove":
                String[] data2 = tokens[1].split(",");
                s.removeFromCart(new Item(data2[0], Integer.
                    parseInt(data2[1])));
                break;
            case "show":
                s.showCart();
                break;
            case "totalAmount":
                System.out.println("totalAmount: " + s.getTotalAmount());
                break;
            case "payableAmount":
                System.out.println("Payable amount: " + s.getPayableAmount());
                break;
            case "coupon":
                s.applyCoupon(tokens[1]);
                break;

            case "print":
                s.printInvoice();
                break;
            default:
            }
        }
    }
}
