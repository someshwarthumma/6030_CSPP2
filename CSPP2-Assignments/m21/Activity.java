public class Activity{
	String name;
	String date;
	String startTime;
	String endTime;
	String notes;
	Activity(String n,String notes, String d, String st,String et){
		this.name = n;
		this.date = d;
		this.startTime=st;
		this.endTime = et;
		this.notes = notes;
	}

	Activity(String n, String d, String st,String et){
		this.name = n;
		this.date = d;
		this.startTime=st;
		this.endTime = et;
		this.notes = "";
	}

	public String getName(){
		return this.name;
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
	public String getNotes(){
		return this.notes;
	}
	public String getActivitySummary(){
		int time = Integer.parseInt(endTime)-Integer.parseInt(startTime);
		if(notes.length()==0){
			return "Name: "+this.name+" for '"+time+"' hours";
		}
		return "Name: "+this.name+" || Duration "+time+" hours || From: "+startTime+" || Date: "+date+"Hours || NOTES: "+this.notes+".";
	}
}