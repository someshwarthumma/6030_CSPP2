import java.util.Scanner;

class Client {
	static List<Food>foodList = new List<Food>();
	static List<Water>waterList = new List<Water>();
	static List<Activity>activityList = new List<Activity>();
	static List<Weight>weightList = new List<Weight>();
	static List<Sleep>sleepList = new List<Sleep>();
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		
		while(s.hasNext()){
			String[] line = s.nextLine().split(" ");
			switch(line[0]){
				case "Food":
					String[] fd = line[1].split(",");
					foodList.add(new Food(fd[0],fd[1],fd[2],fd[3]));
					break;
				case "Water":
					//System.out.println("This is line: "+line[1]);
					String[] wd = line[1].split(",");
					waterList.add(new Water(wd[0],wd[1],wd[2]));
					break;
				case "PhysicalActivity":
					String[] ad = line[1].split(",");
					if(ad.length==5){
						activityList.add(new Activity(ad[0],ad[1],ad[2],ad[3],ad[4]));
						break;
					}
					activityList.add(new Activity(ad[0],ad[1],ad[2],ad[3]));
					break;
				case "Sleep":
					String[] sd = line[1].split(",");
					sleepList.add(new Sleep(sd[0],sd[1],sd[2]));
					break;
				case "Weight":
				String[] wei = line[1].split(",");
				weightList.add(new Weight(wei[0],wei[1],wei[2],wei[3]));
					break;
				case "Summary":
					if(line.length==1){
						getSummary();
						break;
					}
					getSummary(line[1]);
					break;
				case "Foodlog":
					getFoodLog();
					break;
				case "Waterlog":
					getWaterLog();
					break;
				case "Sleeplog":
					getSleepLog();
					break;
				case "PhysicalActivitylog":
				getActivityLog();
				break;
				case "Weightlog":
				getWeightLog();
				break;

			}
		}
		
	}

	public static void getFoodLog(){
		System.out.println();
		System.out.println("*************** Food Log *****************");
		for(int i =0;i<foodList.size();i++){
			System.out.println(foodList.get(i).getFoodSummary());
		}
		System.out.println();
	}
	public static void getWaterLog(){
		System.out.println();
		System.out.println("*************** water Log *****************");
		for(int i =0;i<waterList.size();i++){
			System.out.println(waterList.get(i).getWaterSummary());
		}
	}
	public static void getSleepLog(){
		System.out.println();
		System.out.println("*************** Sleep Log *****************");
		for(int i =0;i<sleepList.size();i++){
			System.out.println(sleepList.get(i).getSleepSummary());
		}
	}

	public static void getActivityLog(){
		System.out.println();
		System.out.println("*************** Activity Log *****************");
		for(int i =0;i<activityList.size();i++){
			System.out.println(activityList.get(i).getActivitySummary());
		}
	}
	public static void getWeightLog(){
		System.out.println();
		System.out.println("*************** Weight Log *****************");
		for(int i =0;i<weightList.size();i++){
			System.out.println(weightList.get(i).getWeightSummary());
		}
	}

	public static void getSummary(){
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("REPORT CARD: ");
		System.out.println();
		System.out.println("Food: ");
		for(int i =0;i<foodList.size();i++){
			System.out.println(foodList.get(i).getFoodSummary());
		}
		System.out.println("Water: ");
		for(int i =0;i<waterList.size();i++){
			System.out.println(waterList.get(i).getWaterSummary());
		}
		System.out.println("Sleep: ");
		for(int i =0;i<sleepList.size();i++){
			System.out.println(sleepList.get(i).getSleepSummary());
		}
		System.out.println("Physical Activity: ");
		for(int i =0;i<activityList.size();i++){
			System.out.println(activityList.get(i).getActivitySummary());
		}
		System.out.println("Weight : ");
		for(int i =0;i<weightList.size();i++){
			System.out.println(weightList.get(i).getWeightSummary());
		}
		System.out.println();
		System.out.println("End of REPORT CARD!! Stay fit with 'FitByte',Thank You!");
		System.out.println("*******************************************");
	}


	public static void getSummary(String date){
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("REPORT CARD for the date: "+date);
		System.out.println();
		System.out.println("Food: ");
		for(int i=0; i<foodList.size();i++){
			if(foodList.get(i).getDate().equals(date)){
				System.out.println(foodList.get(i).getFoodSummary());
			}
		}
		System.out.println("Water: ");
		for(int i = 0;i<waterList.size();i++){
			if(waterList.get(i).getDate().equals(date)){
				System.out.println(waterList.get(i).getWaterSummary());
			}
		}
		System.out.println("Sleep: ");
		for(int i =0; i<sleepList.size();i++){
			if(sleepList.get(i).getDate().equals(date)){
				System.out.println(sleepList.get(i).getSleepSummary());
			}
		}
		System.out.println("Physical Activity: ");
		for(int i =0; i<activityList.size();i++){
			if(activityList.get(i).getDate().equals(date)){
				System.out.println(activityList.get(i).getActivitySummary());
			}
		}
		System.out.println("Weight : ");
		for(int i =0; i<weightList.size();i++){
			if(weightList.get(i).getDate().equals(date)){
				System.out.println(weightList.get(i).getWeightSummary());
			}
		}
		System.out.println();
		System.out.println("End of REPORT CARD!! Stay fit with 'FitByte',Thank You!");
		System.out.println("*******************************************");
	}
}