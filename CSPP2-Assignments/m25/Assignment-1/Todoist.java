public class Todoist{
	static List<Task>taskList = new List<Task>();
	Todoist(){

	}

	public void addTask(Task task){
		taskList.add(task);
	}

	public void tostring(){
		for(int i=0;i<taskList.size();i++){
			System.out.println(taskList.get(i).getPrint()); 
		}
	}



	public String getNextTask(String name){
		for(int i =0;i<taskList.size();i++){
			if(name.equals(taskList.get(i).getName())){
				if(taskList.get(i).getImportant()==true && taskList.get(i).getUrgent()==false && taskList.get(i).getStatus().equals("todo")){
					return taskList.get(i).getPrint();
				}
			}
	
			
		}
		return "null";
	}

	public int totalTime4Completion(){
		int sum =0;
		for(int i =0 ;i<taskList.size();i++){
			if(taskList.get(i).getStatus().equals("todo")){
				sum += taskList.get(i).getTime();
			}
		}
		return sum;
	}

	public String[] getNextTask(String name, int count){
		String[] arr = new String[count];
		int j = 0;
		for(int i =0;i<taskList.size();i++){
			if(name.equals(taskList.get(i).getName())){
				if(taskList.get(i).getImportant()==true && taskList.get(i).getUrgent()==false && taskList.get(i).getStatus().equals("todo")){
					arr[j] = taskList.get(i).getPrint();
					j++;
					//return taskList.get(i).getPrint();
				}
				if (j == count-1){
					return arr;
				}
			}
	
			
		}
		return null;
	}


}