import java.util.*;
class InputValidator
{	String value;
	InputValidator(String input){
		this.value = input;
	}

	boolean validateData(){
	String x = this.value;
	int sum = x.length();
	if (sum >= 6){
		return true;
	}
	return false;
	}
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
