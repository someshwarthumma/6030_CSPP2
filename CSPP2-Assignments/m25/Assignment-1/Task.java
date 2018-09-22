public class Task{
	String title;
	String assignedTo;
	int timeToComplete;
	boolean important ;
	boolean urgent;
	String status;
	Task(String t,String a, int time,boolean imp, boolean urg, String statu) throws Exception{
		if(t.length()!=0){
			this.title = t;
		} else {
			throw new Exception("Title not provided");
		}
		this.assignedTo = a;
		if(time>=0){
			this. timeToComplete = time;
		} else {
			throw new Exception("Invalid timeToComplete "+time);
		}
		
		this.important = imp;
		this.urgent = urg;
		if(statu.equals("todo") || statu.equals("done")){
			this.status = statu;
		} else{
			throw new Exception("Invalid status "+statu);
		}
	}

	public String getName(){
		return this.assignedTo;
	}

	public void tostring(){
		String urgentflag;
		String importantflag;
		
		if(urgent == true){
			urgentflag = "Urgent";
		} else {
			urgentflag = "Not Urgent";
		}
		if(important == true){
			importantflag = "Important";
		} else {
			importantflag = "Not Important";
		}

		System.out.println(title+", "+assignedTo+", "+timeToComplete+", "+importantflag+", "+urgentflag+", "+status);
		//return title+", "+assignedTo+", "+timeToComplete+", "+importantflag+", "+urgentflag+", "+status;
	}

	public void getPrint(){
		String urgentflag;
		String importantflag;
		
		if(urgent == true){
			urgentflag = "Urgent";
		} else {
			urgentflag = "Not Urgent";
		}
		if(important == true){
			importantflag = "Important";
		} else {
			importantflag = "Not Important";
		}

		 System.out.println(title+", "+assignedTo+", "+timeToComplete+", "+importantflag+", "+urgentflag+", "+status);
		//return title+", "+assignedTo+", "+timeToComplete+", "+importantflag+", "+urgentflag+", "+status;
	}
}