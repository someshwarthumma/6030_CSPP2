import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

class SortedSet{
	int[] list;
	static int size;
	public SortedSet(int capacity){
		list = new int[capacity];
		size = 0;
	}

	/**.
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
	    if (size == 0) {
	        return "{}";
	    }
	    String str = "{";
	    for (int index = 0; index < size - 1; index++) {
	        str += list[index] + ", ";
	    }
	    return str + list[size - 1] + "}";
	}

	/**
	 * Adds all.
	 *
	 * @param      items  The items
	 */
	public void addAll(final int[] items) {
	    for (int i = 0; i < items.length; i++) {
	        add(items[i]);
	    }
	}

	/**.
     * { function_description }
     */
    private void resize() {
        list = Arrays.copyOf(list, 2 * size);
    }

    public void add(final int item) {
        int flag = 0;
        if (size == list.length) {
            resize();
        }
        if (size >= 0) {
            for (int index = 0; index < size; index++) {
                if (item == list[index]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                int i, j = 0, count = 0;
                if (size > 0) {
                    for (i = 0; i < size; i++) {
                        if (item > list[i]) {
                            count += 1;
                        }
                    }
                    for (j = size; j > count; j--) {
                        list[j] = list[j - 1];
                    }
                }
                list[count] = item;
                size++;
            }
        }
    }


    public int indexForSubset(int element){
    	if(getElement(0)>element){
    		return 0;
    	}
    	if(getElement(size-1)<element){
    		return size;
    	}
    	for(int i =size; i<=0;i++){
    		if(list[i]<element){
    			return i+1;
    		}
    	}
    	if(getElement(size-1)<element){
    		return size;
    	}
    	return -1;
    }

	public int getElement(int index){
		if(index>=0 && index<size){
			return list[index];
		}
		return -1;
	}

	public int[] subSet(final int start, final int end) {
        if (size == 0) {
            int[] subSet = new int[0];
            return subSet;
        }
        int a = indexForSubset(start);
        int b = indexForSubset(end);
        int[] subSet = new int[b - a];
        int i, j;
        for (i = a, j = 0; i < b; i++, j++) {
            subSet[j] = list[i];
        }
        return subSet;
    }

    public int[] headSet(final int end) {
        int a = indexForSubset(end);
        if (a == -1) {
            int[] temp = new int[0];
            return temp;
        }
        int[] temp = new int[a];
        for (int i = 0; i < a; i++) {
            temp[i] = list[i];
        }
        return temp;
    }
    public int last() {
        if (size == 0) {
            System.out.println("Set Empty Exception");
            return -1;
        }
        return list[size - 1];
    }




//This is for end of class.
}



public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      str     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String str) {
        String input = str;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (str.contains("[")) {
            input = str.substring(1, str.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Scanner stdin = new Scanner(new
                                    BufferedInputStream(System.in));
        SortedSet s = new SortedSet(Integer.parseInt(stdin.nextLine()));
        // code to read the test cases input file
        
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "print":
                System.out.println(s);
                break;
            case "addAll":
                String[] strArray = tokens[1].split(",");
                int[] intArray1 = new int[strArray.length];
                for (int i = 0; i < strArray.length; i++) {
                    intArray1[i] = Integer.parseInt(strArray[i]);
                }
                s.addAll(intArray1);
                break;
            case "subSet":
                String[] temp = tokens[1].split(",");
                if (Integer.parseInt(temp[0]) > Integer.parseInt(temp[1])) {
                    System.out.println("Invalid Arguments to Subset Exception");
                    break;
                }
                int[] temp1 = s.subSet(Integer.parseInt(temp[0]),
                                       Integer.parseInt(temp[1]));
                String str = "{";
                int i;
                if (temp1.length == 0) {
                    System.out.println("{}");
                    break;
                }
                for (i = 0; i < temp1.length - 1; i++) {
                    str += temp1[i] + ", ";
                }
                str += temp1[temp1.length - 1] + "}";
                System.out.println(str);
                break;
            case "headSet":
                int[] temp2 = s.headSet(Integer.parseInt(tokens[1]));
                String str1 = "{";
                int in;
                if (temp2.length == 0) {
                    System.out.println("{}");
                    break;
                }
                for (in = 0; in < temp2.length - 1; in++) {
                    str1 += temp2[in] + ", ";
                }
                str1 += temp2[temp2.length - 1] + "}";
                System.out.println(str1);
                break;
            case "last":
                System.out.println(s.last());
                break;
            default:
                break;
            }
        }
    }
}