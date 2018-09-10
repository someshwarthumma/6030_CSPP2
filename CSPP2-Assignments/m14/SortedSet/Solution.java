import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :T Someshwar
 */
class Set {
    /**.
     * variable for set.
     */
    private int[] set;
    /**.
     * variable for size of set
     */
    private int size;
    /**.
     * Constructs the object.
     */
    Set() {
        final int value = 10;
        set = new int[value];
        size = 0;
    }
    /**.
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    Set(final int capacity) {
        set = new int[capacity];
        size = 0;
    }
    /**.
     * this function returns the size of set
     *
     * @return     returns size
     */
    public int size() {
        return size;
    }
    /**.
     * this function checks the item is in the set
     * or not and returns boolean value
     *
     * @param      item  The item
     *
     * @return     returns boolean value
     */
    public boolean contains(final int item) {
        for (int index = 0; index < size; index++) {
            if (item == set[index]) {
                return true;
            }
        }
        return false;
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
            str += set[index] + ", ";
        }
        return str + set[size - 1] + "}";
    }
    /**.
     * add the value into the set.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        int flag = 0;
        if (size == set.length) {
            resize();
        }
        if (size >= 0) {
            for (int index = 0; index < size; index++) {
                if (item == set[index]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                int i, j = 0, count = 0;
                if (size > 0) {
                    for (i = 0; i < size; i++) {
                        if (item > set[i]) {
                            count += 1;
                        }
                    }
                    for (j = size; j > count; j--) {
                        set[j] = set[j - 1];
                    }
                }
                set[count] = item;
                size++;
            }
        }

    }
    /**.
     * this function add set of values to the set[].
     *
     * @param      items  The items
     */
    public void add(final int[] items) {
        for (int index = 0; index < items.length; index++) {
            add(items[index]);
        }
    }
    /**.
     * this function add similar values and
     * return the set class object
     *
     * @param      setObject the object
     *
     * @return     returns object
     */
    public Set intersection(final Set setObject) {
        Set s1 = new Set(setObject.size);
        for (int index = 0; index < size; index++) {
            if (setObject.contains(set[index])) {
                s1.add(set[index]);
            }
        }
        return s1;
    }
    /**.
     * this function retains the similar values in
     * both sets.
     *
     * @param      items  The items
     *
     * @return     returns set object
     */
    public Set retainAll(final int[] items) {
        Set s1 = new Set();
        for (int index = 0; index < size; index++) {
            for (int j = 0; j < items.length; j++) {
                if (set[index] == items[j]) {
                    s1.add(items[j]);
                }
            }
        }
        return s1;
    }
    /**.
     * this function returns the product of 2D array
     *
     * @param      obj   The object
     *
     * @return     returns the 2D array
     */
    public int[][] cartesianProduct(final Set obj) {
        if (size == 0 || obj.size == 0) {
            return null;
        }
        int k = 0;
        int[] temp;
        int[][] newArray = new int[size * obj.size][2];
        while (k < newArray.length) {
            for (int index = 0; index < size; index++) {
                temp = new int[2];
                for (int j = 0; j < obj.size; j++) {
                    newArray[k][0] = this.set[index];
                    newArray[k][1] = obj.set[j];
                    k++;
                }
            }
        }
        return newArray;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == set[i]) {
                return i;
            }
        }
        return -1;
    }
    /**.
     * this function resize the array.
     */
    private void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }

}
/**
 * Class for sorted set.
 */
class SortedSet extends Set {
    /**.
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    /**.
     * { var_description }
     */
    private int[] set;
    /**.
     * { var_description }
     */
    private int size;
    /**.
     * Constructs the object.
     */
    SortedSet() {
        final int ten = 10;
        set = new int[ten];
        size = 0;
    }
    /**.
     * { function_description }
     */
    private void resize() {
        set = Arrays.copyOf(set, 2 * size);
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        for (int index = 0; index < size - 1; index++) {
            str += set[index] + ", ";
        }
        return str + set[size - 1] + "}";
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     */
    @Override
    public void add(final int item) {
        int flag = 0;
        if (size == set.length) {
            resize();
        }
        if (size >= 0) {
            for (int index = 0; index < size; index++) {
                if (item == set[index]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                int i, j = 0, count = 0;
                if (size > 0) {
                    for (i = 0; i < size; i++) {
                        if (item > set[i]) {
                            count += 1;
                        }
                    }
                    for (j = size; j > count; j--) {
                        set[j] = set[j - 1];
                    }
                }
                set[count] = item;
                size++;
            }
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */

    public int last() {
        if (size == 0) {
            System.out.println("Set Empty Exception");
            return -1;
        }
        return set[size - 1];
    }
    /**
     * { function_description }.
     *
     * @param      start  The start
     * @param      end    The end
     *
     * @return     { description_of_the_return_value }
     */
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
            subSet[j] = set[i];
        }
        return subSet;
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

    /**
     * { function_description }.
     *
     * @param      start1  The start 1
     *
     * @return     { description_of_the_return_value }
     */
    public int start(final int start1) {
        for (int i = 0; i < size; i++) {
            if (start1 <= set[i]) {
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
            if (end1 >= set[i]) {
                if (end1 > set[i]) {
                    return i + 1;
                }
                return i;
            }
        }
        return -1;
    }

    /**
     * { function_description }.
     *
     * @param      end   The end
     *
     * @return     { description_of_the_return_value }
     */
    public int[] headSet(final int end) {
        int a = end(end);
        if (a == -1) {
            int[] temp = new int[0];
            return temp;
        }
        int[] temp = new int[a];
        for (int i = 0; i < a; i++) {
            temp[i] = set[i];
        }
        return temp;
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
        SortedSet s = new SortedSet();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new
                                    BufferedInputStream(System.in));
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
