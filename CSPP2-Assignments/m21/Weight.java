public class Weight{
	String weight;
	String fat;
	String date;
	String time;
	Weight(String date,String time,String weight,String fat){
		this.weight = weight;
		this.fat = fat;
		this.date = date;
		this.time = time;
	}
	 public String getDate(){
	 	return this.date;
	 }
	public String getFat(){
		return this.fat;
	}
	public String getTime(){
		return this.time;
	}
	public String getWeight(){
		return this.weight;
	}
	public String getWeightSummary(){
		return "Weight:	"+this.weight+" || Fat % : "+this.fat+" || Time: "+this.time+" Hours || Date: "+date;
	}
}