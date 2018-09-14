import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;


class Item {
	private String itemName;
	private int quantity;
	private double unitPrice;

	Item(String n, int q, int p) {
		this.itemName = n;
		this.quantity = q;
		this.unitPrice = (double)p;
	}

	Item(String n, int q) {
		this.itemName = n;
		this.quantity = q;
	}
	public String getName() {
		return this.itemName;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public double getPrice() {
		return this.unitPrice;
	}

	public void setQuantity(int newQuantity) {
		this.quantity = newQuantity;
	}

}

class ShoppingCart {
	List< Item >catalogList;
	List<Item>cartList;
	ShoppingCart(){
		catalogList = new List<Item>();
		cartList = new List<Item>();
	}
	public static double totalSum = 0;
	private static boolean flag = false;
	public static double discount = 0.0;
	

	public void addToCatalog(Item catalogObj) {
		catalogList.add(catalogObj);
	}

	public void showCatalog() {
		for (int i = 0; i < catalogList.size() ; i++) {
			Item obj = catalogList.get(i);
			String itemName = obj.getName();
			int itemQuantity = obj.getQuantity();
			double itemPrice = obj.getPrice();
			System.out.println(itemName +" "+ itemQuantity +" "+ itemPrice);
		}
	}

	public void addToCart(Item cartItem) {

		for (int i = 0; i <catalogList.size(); i++) {
			if (catalogList.get(i).getName().equals(cartItem.getName())) {
				if (cartItem.getQuantity() <= catalogList.get(i).getQuantity()) {
					for(int j=0;j<cartList.size();j++){
						if(cartList.get(j).getName().equals(cartItem.getName())){
							cartList.get(j).setQuantity(cartList.get(j).getQuantity()+cartItem.getQuantity());
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

	public void removeFromCart(Item removeItem) {
		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getName().equals(removeItem.getName())) {
				cartList.get(i).setQuantity(cartList.get(i).getQuantity() - removeItem.getQuantity());
				return;
			}
		}
	}

	public void showCart() {
		for (int i = 0; i < cartList.size(); i++) {
			Item obj = cartList.get(i);
			String itemName = obj.getName();
			int itemQuantity = obj.getQuantity();
			System.out.println(itemName + " " + itemQuantity);
		}
	}

	private double price(String name){
		for(int i =0;i<catalogList.size();i++){
			if(catalogList.get(i).getName().equals(name)){
				return catalogList.get(i).getPrice();
			}
		}
		return 0.0;
	}

	public double getTotalAmount() {
		double sum = 0;
		for (int i = 0; i < cartList.size(); i++) {
			sum += cartList.get(i).getQuantity()*price(cartList.get(i).getName());
			//System.out.println(sum);
		}
		return sum;
	}

	public void applyCoupon(String coupon) {
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
		} else {
			System.out.println("Invalid coupon");
		}

	}

	public double getPayableAmount() {

		if (flag) {
			return (totalSum * 1.5 + totalSum);
		}
		return (getTotalAmount() + getTotalAmount() * 1.5);
	}

	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cartList.size(); i++) {
			Item obj = cartList.get(i);
			String itemName = obj.getName();
			int itemQuantity = obj.getQuantity();
			double itemPrice = price(obj.getName());
			System.out.println(itemName + " " + itemQuantity + " " + itemPrice);
		}

		System.out.println("totalAmount: " + getTotalAmount());
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%: " + discount);
		if (flag == true) {

			System.out.println("Tax: " + totalSum * 1.5);
		} else {
			System.out.println("Tax: " + (getTotalAmount() * 1.5));
		}
		System.out.println(getTotalAmount());

	}




}




public class Solution {
	public static void main(String[] args) {
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