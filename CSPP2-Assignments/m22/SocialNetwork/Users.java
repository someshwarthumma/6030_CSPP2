import java.util.*;

public class Users{
	String user;
	ArrayList<String> followers= new ArrayList<String>();
	Users(String user, String[] fol){
		//System.out.println(Arrays.toString(fol));
		this.user = user;
		for(int i=0; i<fol.length;i++){
			//System.out.println(fol[i]);
			this.followers.add(fol[i]);
		}
		//System.out.println("User: "+user+" Followers: "+followers);
	}
	Users(String user,String follo){
		this.followers.add(follo);
	}
	Users(){
		
	}
	public String getUser(){
		return this.user;
	}
	public ArrayList<String> getFollowers(){
		return this.followers;
	}

	public String getFollowing(int index){
		return this.followers.get(index);
	}
	public int getFoSize(){
		return this.followers.size();
	}
	public void addFollower(String newfrnd){
		this.followers.add(newfrnd);
	} 
}