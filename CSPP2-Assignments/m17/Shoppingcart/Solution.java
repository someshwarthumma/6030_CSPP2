import java.util.Scanner;

/**.
 * This is Item class
 */
class Item {
    /**.
     * This is item name;
     */
    private String itemName;
    /**.
     * This is quantity;
     */
    private int quantity;
    /**.
     * This is unit price
     */
    private double unitPrice;
    /**.
     * This is item constructor
     *
     * @param      n     { name }
     * @param      q     quantity
     * @param      p     { unitprice }
     */
    Item(final String n, final int q, final int p) {
        this.itemName = n;
        this.quantity = q;
        this.unitPrice = (double) p;
    }
    /**.
     * This is Item constructor
     *
     * @param      n     { name }
     * @param      q     Quantity
     */
    Item(final String n, final int q) {
        this.itemName = n;
        this.quantity = q;
    }
    /**.
     * This is geName method
     *
     * @return     The name.
     */
    public String getName() {
        return this.itemName;
    }
    /**.
     * This is get Quantity method
     *
     * @return     The quantity.
     */
    public int getQuantity() {
        return this.quantity;
    }
    /**.
     * This is getPrice method
     *
     * @return     The price.
     */
    public double getPrice() {
        return this.unitPrice;
    }
    /**.
     * This is setnewQuantity
     *
     * @param      newQuantity  The new quantity
     */
    public void setQuantity(final int newQuantity) {
        this.quantity = newQuantity;
    }

}



/**.
 * This is solution
 */
public class Solution {
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        ShoppingCart s = new ShoppingCart();
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "Item":
                String[] data = tokens[1].split(",");
                s.addToCatalog(new Item(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                break;
            case "catalog":
                s.showCatalog();
                break;
            case "add":
                String[] data1 = tokens[1].split(",");
                s.addToCart(new Item(data1[0], Integer.parseInt(data1[1])));
                break;
            case "remove":
                String[] data2 = tokens[1].split(",");
                s.removeFromCart(new Item(data2[0], Integer.parseInt(data2[1])));
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
            }
        }
    }
}