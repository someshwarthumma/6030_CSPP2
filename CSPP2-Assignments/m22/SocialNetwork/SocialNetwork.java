import java.io.*;
import java.util.*; 
import java.lang.*; 

public class Solution{
	static Scanner s = new Scanner(System.in);
	//static HashMap<String , ArrayList<String>>networkDictionary = new HashMap<String , ArrayList<String>>();
	static List<Users>userList = new List<Users>();
	public static void main(String[] args) {

		try{
		File file = new File("SocialNetwork.txt"); 
    Scanner sc = new Scanner(file); 
  
    while (sc.hasNextLine()) {
    	String[] data = sc.nextLine().replace(".","").split(" is connected to ");
    	String[] followers = data[1].split(", ");
    	userList.add(new Users(data[0],followers));
    }
    }catch (FileNotFoundException e){
    	System.out.println("Exception"+e.getMessage());
    }
    while(s.hasNext()){
    	String[] command = s.nextLine().split(" ");
    	switch(command[0]){
    		case "getConnections":
    		getConnections(command[1]);
    		break;
    		case "addConnection":
    		String[] da = command[1].split(",");
    		addConnection(da[0],da[1]);
    	}

    }

	}

	public static void getConnections(String name){
		for(int i =0;i<userList.size();i++){
			if(userList.get(i).getUser().equals(name)){
				System.out.println(userList.get(i).getFollowers());
			}
		}
	}
	public static void addConnection(String user, String newFrnd){
		for(int i =0;i<userList.size();i++){
			if(userList.get(i).getUser().equals(user)){
				for(int j=0;j<userList.get(i).getFoSize();j++){
					if(userList.get(i).getFollowing(j).equals(newFrnd)){
						return;
					}
				}
			}
		}
		for(int i =0;i<userList.size();i++){
			if(userList.get(i).getUser().equals(user)){
				userList.get(i).addFollower(newFrnd);
			}
		}
		
	}



}