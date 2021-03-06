/**.
 * This is Shopping cart class
 */
public class ShoppingCart {
    /**.
     * This is listgeneric declaration for caatalog list
     */
    List<Item>catalogList;
    /**.
     * Tihs is cartList;
     */
    List <Item> cartList;
    /**.
     * This is Shopping cart constructor
     */
    public ShoppingCart() {
        catalogList = new List<Item>();
        cartList = new List<Item>();
    }
    /**.
     * This is total sum
     */
    public static double totalSum = 0;
    /**.
     * This is flag
     */
    private static boolean flag = false;
    /**.
     * This is discount
     */
    public static double discount = 0.0;

    /**.
     * This is catalog class
     *
     * @param      catalogObj  catalog obj
     */
    public void addToCatalog(final Item catalogObj) {
        catalogList.add(catalogObj);
    }
    /**.
     * This is show catalog
     */
    public void showCatalog() {
        for (int i = 0; i < catalogList.size() ; i++) {
            Item obj = catalogList.get(i);
            String itemName = obj.getName();
            int itemQuantity = obj.getQuantity();
            double itemPrice = obj.getPrice();
            System.out.println(itemName + " " + itemQuantity + " " + itemPrice);
        }
    }
    /**.
     * This carItem class
     *
     * @param      cartItem  The cartesian item
     */
    public void addToCart(final Item cartItem) {

        for (int i = 0; i < catalogList.size(); i++) {
            if (catalogList.get(i).getName().equals(cartItem.getName())) {
                if (cartItem.getQuantity() <= catalogList.get(i).getQuantity()) {
                    for (int j = 0; j < cartList.size(); j++) {
                        if (cartList.get(j).getName().equals(cartItem.getName())) {
                            cartList.get(j).setQuantity(cartList.get(j).getQuantity() + cartItem.getQuantity());
                            return;
                        }
                    }
                    cartList.add(cartItem);
                    catalogList.get(i).setQuantity(catalogList.get(i).getQuantity() - cartItem.getQuantity());
                    return;
                }
            }
        }
    }
    /**.
     * This is remove Item
     *
     * @param      removeItem  The remove item
     */
    public void removeFromCart(final Item removeItem) {
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getName().equals(removeItem.getName())) {
                cartList.get(i).setQuantity(cartList.get(i).getQuantity() - removeItem.getQuantity());
                if (cartList.get(i).getQuantity() == 0) {
                    cartList.remove(i);
                }
                return;
            }
        }
    }
    /**.
     * Shows the cartesian.
     */
    public void showCart() {
        for (int i = 0; i < cartList.size(); i++) {
            Item obj = cartList.get(i);
            String itemName = obj.getName();
            int itemQuantity = obj.getQuantity();
            System.out.println(itemName + " " + itemQuantity);
        }
    }
    /**.
     * this is price method
     *
     * @param      name  The name
     *
     * @return     { description_of_the_return_value }
     */
    private double price(String name) {
        for (int i = 0; i < catalogList.size(); i++) {
            if (catalogList.get(i).getName().equals(name)) {
                return catalogList.get(i).getPrice();
            }
        }
        return 0.0;
    }
    /**.
     * THis isgetTotalAmount
     *
     * @return     The total amount.
     */
    public double getTotalAmount() {
        double sum = 0;
        for (int i = 0; i < cartList.size(); i++) {
            sum += cartList.get(i).getQuantity() * price(cartList.get(i).getName());
            //System.out.println(sum);
        }
        return sum;
    }
    /**.
     * This is apply coupon
     *
     * @param      coupon  The coupon
     */
    public void applyCoupon(final String coupon) {
        if (coupon.equals("IND10") && flag == false) {
            totalSum = getTotalAmount() * 0.9;
            discount = getTotalAmount() * 0.1;
            flag = true;
            return;
        } else if (coupon.equals("IND20") && flag == false) {
            totalSum = getTotalAmount() * 0.8;
            discount = getTotalAmount() * 0.2;
            flag = true;
            return;
        } else if (coupon.equals("IND30") && flag == false) {
            totalSum = getTotalAmount() * 0.7;
            discount = getTotalAmount() * 0.3;
            flag = true;
            return;
        } else if (coupon.equals("IND50") && flag == false) {
            totalSum = getTotalAmount() * 0.5;
            discount = getTotalAmount() * 0.5;
            flag = true;
            return;
        } else if (flag == false) {
            System.out.println("Invalid coupon");
        }

    }
    /**.
     * This is payable Amount
     *
     * @return     The payable amount.
     */
    public double getPayableAmount() {
        double tax;
        if (flag) {
            //System.out.println("This is totalSum in getPay:");
            tax = totalSum * 0.15;
            /*System.out.println("Total in getpay: "+totalSum);
            System.out.println("get payable Tax:"+tax);
            System.out.println("get payable discount:"+discount);
            */
            return (totalSum + tax);
        }
        //System.out.println("This is getTotalAmount() in getPay:");
        tax = (getTotalAmount() * 0.15);
        return (getTotalAmount() - discount + tax);
    }
    /**.
     * This is print Invoice
     */
    public void printInvoice() {
        double tax;
        System.out.println("Name   quantity   Price");
        for (int i = 0; i < cartList.size(); i++) {
            Item obj = cartList.get(i);
            String itemName = obj.getName();
            int itemQuantity = obj.getQuantity();
            double itemPrice = price(obj.getName());
            System.out.println(itemName + " " + itemQuantity + " " + itemPrice);
        }

        //System.out.println("totalAmount: " + getTotalAmount());
        System.out.println("Total:" + getTotalAmount());
        System.out.println("Disc%:" + discount);
        if (flag == true) {
            tax = totalSum * 0.15;
            System.out.println("Tax:" + tax);
        } else {
            tax = (getTotalAmount() * 0.15);
            System.out.println("Tax:" + tax);
        }
        System.out.println("Payable amount: " + (getTotalAmount() - discount + tax));
    }
}