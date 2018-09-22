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



	/*public String getNextTask(String name){
		for(int i =0;i<taskList.size();i++){
			if(name.equals(taskList.get(i).getName())){

			}
		}		
	}*/


}