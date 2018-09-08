import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**.
 * Class for set.
 * @author :T someshwar
 */
class Set {
    //your code goes here...
    //Good luck :-)

    /**.
     * { This is list of inttype }
     */
    private int[] list;
    /**.
     * This is size
     */
    private int size;
    /**.
     * This is constructor
     */
    Set() {
        final int ten = 10;
        list = new int[ten];
        size = 0;
    }
    /**.
     * This is size method
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
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
     * Thiss is tostring
     *
     * @return     String representation of the object.
     */
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
    /**.
     * Thisis add method
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (size == list.length) {
            resize();
        }
        if (contains(item)) {
            //This is if condition
            size = size;
        } else {
            list[size++] = item;
        }
    }
    /**.
     * This is resize
     */
    private void resize() {
        list = Arrays.copyOf(list, 2 * list.length);
    }
    /**.
     * This is addAll
     *
     * @param      array  The array
     */
    public void addAll(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
    }
    /**.
     * This is get methd
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        return list[index];
    }
    /**.
     * This is intersection method
     *
     * @param      givenSet  The given set
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(final Set givenSet) {
        Set intersect = new Set();
        for (int i = 0; i < this.size; i++) {
            if (givenSet.contains(this.get(i))) {
                intersect.add(this.get(i));
            }
        }
        return intersect;

    }
    /**.
     * This is retain ALl method
     *
     * @param      array  The array
     *
     * @return     { description_of_the_return_value }
     */
    public Set retainAll(final int[] array) {
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
    /**.
     * This is cartesian product funtion
     *
     * @param      array  The array
     *
     * @return     { description_of_the_return_value }
     */
    public int[][] cartesianProduct(final Set array) {
        int length = this.size * array.size;
        int[][] cartesian = new int[length][2];
        int i = 0;
        if (i < length) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < array.size(); k++) {
                    cartesian[i][0] = this.get(j);
                    cartesian[i][1] = array.get(k);
                    i++;
                }

            }
        }
        if(cartesian.length==0)
            return null;
        return cartesian;

    }

}
/**.
 * Solution class for code-eval.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
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
    /**.
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
                System.out.println(Arrays.
                        deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
