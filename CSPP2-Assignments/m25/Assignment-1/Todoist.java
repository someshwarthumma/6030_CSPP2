/**.
 * This is todoist class
 */
public class Todoist{
	static List<Task>taskList = new List<Task>();
	Todoist(){
	}
	/**.
	 *
	 * @param      task  The task
	 */
	public void addTask(Task task){
		taskList.add(task);
	}
	/**.
	 * This is tostring method
	 */
	public void tostring(){
		for(int i=0;i<taskList.size();i++){
			System.out.println(taskList.get(i).getPrint()); 
		}
	}
	/**.
	 * This is getNextTask.
	 *
	 * @param      name  The name
	 *
	 * @return     The next task.
	 */
	public String getNextTask(String name){
		for(int i =0;i<taskList.size();i++){
			if(name.equals(taskList.get(i).getName())){
				if(taskList.get(i).
					getImportant()==true && taskList.get(i).
					getUrgent()==false && taskList.get(i).
					getStatus().equals("todo")){
					return taskList.get(i).getPrint();
				}
			}
	
			
		}
		//System.out.println("This is end: ");
		return "null";
	}
	/**.
	 * This is totalTime method
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int totalTime4Completion(){
		int sum =0;
		for(int i =0 ;i<taskList.size();i++){
			if(taskList.get(i).getStatus().equals("todo")){
				sum += taskList.get(i).getTime();
			}
		}
		return sum;
	}
	/**.
	 * This is getNext task
	 *
	 * @param      name   The name
	 * @param      count  The count
	 *
	 * @return     The next task.
	 */
	public String[] getNextTask(String name, int count){
		String[] arr = new String[count];
		int j = 0;
		for(int i =0;i<taskList.size();i++){
			if(name.equals(taskList.get(i).getName())){
				if(taskList.get(i).
					getImportant()==true && taskList.get(i).
					getUrgent()==false && taskList.get(i).
					getStatus().equals("todo")){
					arr[j] = taskList.get(i).getPrint();
					j++;
					//return taskList.get(i).getPrint();
				}
				if (j == count){
					return arr;
				}
			}
	
			
		}
		for(int k =j+1;j<count;j++){
			arr[k] = "null";
		}
		
		return arr;
	}


}