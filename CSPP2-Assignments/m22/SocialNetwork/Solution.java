import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
	static Scanner s = new Scanner(System.in);
	//static HashMap<String , ArrayList<String>>networkDictionary = new HashMap<String , ArrayList<String>>();
	static ArrayList<Users>userList = new ArrayList<Users>();
	static ArrayList<String>commonFriends = new ArrayList<String>();
	public static void main(String[] args) {
/*
		try {
			File file = new File("SocialNetwork.txt");
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				String[] data = sc.nextLine().replace(".", "").split(" is connected to ");
				String[] followers = data[1].split(", ");
				userList.add(new Users(data[0], followers));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception" + e.getMessage());
		}*/
		while (s.hasNext()) {
			String[] command = s.nextLine().split(" ");
			switch (command[0]) {
			case "Create":
				createDB(s,Integer.parseInt(command[1]));
				break;
			case "getConnections":
				getConnections(command[1]);
				break;
			case "addConnections":
				addConnection(command[1], command[2]);
				break;
			case "CommonConnections":
				commonConnection(command[1], command[2]);
				break;
			case "Network":
				network();
				break;
			}

		}

	}

	public static  void createDB(Scanner s, int count) {
		for (int i = 0; i < count; i++) {
			String[] data = s.nextLine().replace(".", "").split(" is connected to ");
			String[] followers = data[1].split(", ");
			userList.add(new Users(data[0], followers));
		}
	}

	public static void getConnections(String name) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUser().equals(name)) {
				System.out.println(userList.get(i).getFollowers());
				return;
			}
		}
		System.out.println("Not a user in Network");
	}
	public static void addConnection(String user, String newFrnd) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUser().equals(user)) {
				for (int j = 0; j < userList.get(i).getFoSize(); j++) {
					if (userList.get(i).getFollowing(j).equals(newFrnd)) {
						return;
					}
				}
			}
		}
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUser().equals(user)) {
				userList.get(i).addFollower(newFrnd);
			}
		}

	}

	public static  void commonConnection(String name1, String name2) {
		Users user1 = new Users();
		Users user2 = new Users();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUser().equals(name1)) {
				user1 = userList.get(i);
			}
			if (userList.get(i).getUser().equals(name2)) {
				user2 = userList.get(i);
			}
		}
		int p = user1.getFoSize();
		int k = user2.getFoSize();
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < k; j++) {
				if (user1.getFollowing(i).equals(user2.getFollowing(j))) {
					commonFriends.add(user1.getFollowing(i));
				}
			}
		}
		System.out.println(commonFriends);
	}

	public static void network() {
		//System.out.println("This is network");
		String str = "";
		for (int i = 0; i < userList.size() - 1; i++) {
			Users tempUser = userList.get(i);
			str += tempUser.getUser() + ": " + tempUser.getFollowers() + ", ";
		}
		System.out.println(str + userList.get(userList.size() - 1).getUser() + ": " + userList.get(userList.size() - 1).getFollowers());
	}



}