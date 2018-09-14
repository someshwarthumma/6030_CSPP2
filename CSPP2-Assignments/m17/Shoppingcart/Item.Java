/**.
 * This is Item class
 */
public class Item {
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
    public Item(final String n, final int q, final int p) {
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
    public Item(final String n, final int q) {
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