import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

class SortedSet{
	int[] list;
	int size;
	SortedSet(){
		list = new int[10];
		size = 0;
	}
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

    /**
     * { function_description }.
     *
     * @param      start1  The start 1
     *
     * @return     { description_of_the_return_value }
     */
    public int start(final int start1) {
        for (int i = 0; i < size; i++) {
            if (start1 <= list[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * { function_description }.
     *
     * @param      end1  The end 1
     *
     * @return     { description_of_the_return_value }
     */
    public int end(final int end1) {
        for (int i = size - 1; i >= 0; i--) {
            if (end1 >= list[i]) {
                if (end1 > list[i]) {
                    return i + 1;
                }
                return i;
            }
        }
        return -1;
    }

	public int get(int index){
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
        int a = start(start);
        int b = end(end);
        int[] subSet = new int[b - a];
        int i, j;
        for (i = a, j = 0; i < b; i++, j++) {
            subSet[j] = list[i];
        }
        return subSet;
    }

    public int[] headSet(final int end) throws Exception{
        int a = end(end);
        if (a == -1) {
        	throw new Exception("Set Empty Exception");
            /*int[] temp = new int[0];
            return temp;*/
        }
        int j=0;
        int[] temp = new int[a];
        for (int i = 0; i < a; i++) {
            temp[i] = list[i];
            j++;
        }
        if(j==0){
        	throw new Exception("Set Empty Exception");
        }
        return temp;
    }
    public int sizee() {
    	return size;
    }
    public int last() throws Exception{
        if (size == 0) {
           throw  new Exception("Set Empty Exception");
        }
        return list[size - 1];
    }

    public SortedSet intersection(final SortedSet givenSet) {
        SortedSet intersect = new SortedSet();
        
        for (int i = 0; i < this.sizee(); i++) {
        	
            if (givenSet.contains(list[i])) {
            	
                intersect.add(list[i]);
            }
        }
        return intersect;

    }

    /**.
     * This is contains method
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**.
     * This is retain ALl method
     *
     * @param      array  The array
     *
     * @return     { description_of_the_return_value }
     */
    public SortedSet retainAll(final int[] array) {
        SortedSet retain = new SortedSet();
        SortedSet newArray = new SortedSet();
        newArray.addAll(array);
        for (int i = 0; i < size; i++) {
            if (newArray.contains(get(i))) {
                retain.add(list[i]);
            }
        }
        return retain;
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
        	try{
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
	            case "intersection":
	                SortedSet p = new SortedSet(10);
	                SortedSet t = new SortedSet(10);
	                int[] intArray = intArray(tokens[1]);
	                p.addAll(intArray);
	                intArray = intArray(tokens[2]);
	                t.addAll(intArray);
	                System.out.println(p.intersection(t));
	                break;
	            case "retainAll":
	                SortedSet q = new SortedSet(10);
	                intArray = intArray(tokens[1]);
	                q.addAll(intArray);
	                intArray = intArray(tokens[2]);
	                System.out.println(q.retainAll(intArray));
	                break;
	            default:
	                break;
	            }
        	} catch (Exception e){
        		System.out.println(e.getMessage());
        	}
        }
    }
}