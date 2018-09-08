import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
    //your code goes here...
    //Good luck :-)
    public int[] list;
    public int size;

    public Set() {
        list = new int[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(int item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        for (int i = 0; i < size - 1; i++) {
            str = str + list[i] + ", ";
        }
        return str + list[size - 1] + "}";
    }

    public void add(int item) {
        if (size == list.length) {
            resize();
        }
        if (contains(item) == false) {
            list[size++] = item;
        }
    }

    private void resize() {
        list = Arrays.copyOf(list, 2 * list.length);
    }

    public void addAll(int[] array) {
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
    }

    public int get(int index) {
        return list[index];
    }

    public Set intersection(Set givenSet) {
        Set intersect = new Set();
        for (int i = 0; i < this.size; i++) {
            if (givenSet.contains(this.get(i))) {
                intersect.add(this.get(i));
            }
        }
        return intersect;

    }

    public Set retainAll(int[] array) {
        Set retain = new Set();
        Set newArray = new Set();
        newArray.addAll(array);
        for (int i = 0; i < size; i++) {
            if (newArray.contains(get(i))) {
                retain.add(list[i]);
            }
        }
        return retain;
    }

    public int[][] cartesianProduct(Set array) {
        int length = this.size * array.size;
        int[][] cartesian = new int[length][2];
        int i= 0;
        if(i<length) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < array.size(); k++) {
                    cartesian[i][0] = this.get(j);
                    cartesian[i][1] = array.get(k);
                    i++;
                }

            }
        }
        if (cartesian==null){
            System.out.println("This is mod");
            return null;
        }
        return cartesian;

    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
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
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.addAll(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
