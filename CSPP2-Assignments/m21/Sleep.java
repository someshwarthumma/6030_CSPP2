public class Sleep{
	String date;
	String startTime;
	String endTime;
	int hours ;
	Sleep(String d,String st, String et){
		this.date = d;
		this.startTime = st;
		this.endTime = et;
	}
	public String getDate(){
		return this.date;
	}
	public String getStartTime(){
		return this.startTime;
	}
	public String getEndTime(){
		return this.endTime;
	}

	public int getNumOfHoursSleep(){
		hours = Integer.parseInt(endTime)-Integer.parseInt(startTime);
		return hours;
	}

	public String getSleepSummary(){
		return "No of hours: "+getNumOfHoursSleep()+" || Start Time: "+this.startTime+" Hours";
	}

}