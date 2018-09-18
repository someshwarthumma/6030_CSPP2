public class Water{
	String quantity;
	String time;
	String date;
	Water(String q,String dt,String t){
		this.quantity = q;
		this.date = dt;
		this.time = t;
	}

	public String getQuantity(){
		return this.quantity;
	}
	
	public String getDate(){
		return this.date;
	}
	public String getWaterSummary(){
		return "Quantity: "+quantity+"ml || Date: "+date+" || Time: "+time;
	}
}