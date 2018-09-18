public class Food{
	String name;
	String quantity;
	String time;
	String date;
	Food(String n, String q, String d,String t){
		this.quantity = q;
		this.name = n;
		this.time = t;
		this.date = d;
	}

	public String getName(){
		return this.name;
	}

	public String getQuantity(){
		return this.quantity;
	}
	public String getTime(){
		return this.time;
	}
	public String getDate(){
		return this.date;
	}

	public void setName(String n){
		this.name=n;
	}
	public void setQuantity(String q){
		this.quantity=q;
	}
	public void setTime(String t){
		this.time=t;
	}
	public String getFoodSummary(){
		return "Name: "+this.name+" || Quantity: "+quantity+" || Date: "+date+" || Time: "+time;
	}
}