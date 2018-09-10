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
    public int[] list;
    /**.
     * This is size
     */
    public int size;
    /**.
     * This is constructor
     */
    Set() {
        final int ten = 100;
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
    public void resize() {
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

}

class SortedSet extends Set {

    public void add(int item) {
        /*if(size==list.length){
            super.resize();
        }*/

        System.out.println("This is add(item): " + item);
        if (size == 0) {
            System.out.println("If in add: first element: " + item);
            list[size++] = item;
        } else {
            if (contains(item)) {
                System.out.println("item already present");
                //This is if condition
                size = size;
            } else {
                System.out.println("go for index of item:");
                add(getIndexToAdd(item), item);
            }
        }
    }

    private int getIndexToAdd(int item) {
        System.out.println("This is getIndexToAdd: " + item);
        int i;
        System.out.println("last index: " + (size - 1));
        for (i = size - 1; i >= 0; i--) {
            if (item > get(i)) {
                break;
            }
        }
        System.out.println("index: " + i);
        return i;
    }

    private void add(int index, int item) {
        System.out.println("This is add method with two param: ");
        System.out.println("index: " + index + "item: " + item);
        if (index <= size && index >= 0) {
            int[] list3 = new int[size - index];
            int j = 0;
            for (int i = index; i < size; i++) {
                list3[j] = list[i];
                j++;
            }
            j = 0;
            list[index] = item;
            size++;
            for (int i = index + 1; i < size; i++) {
                list[i] = list3[j];
                j++;
            }
        }
        System.out.println("element added: " + list[index]);
    }

    public void addAll(int[] array) {
        System.out.println("This is addAll: ");
        for (int i : array) {
            System.out.println("i in addAll: " + i);
            add(i);
        }
    }

    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (get(i) == item) {
                return i;
            }
        }
        if (item < get(0)) {
            return 0;
        }
        return size;
    }
    public SortedSet subSet(int fromItem, int toItem) {
        SortedSet sub = new SortedSet();
        if (toItem < fromItem) {
            System.out.println("Invalid Arguments to Subset Exception");
            return null;
        } else {
            for (int i = indexOf(fromItem); i < indexOf(fromItem); i++) {
                sub.add(get(i));
            }
            return sub;

        }
    }

    public SortedSet headSet(int fromItem) {
        SortedSet head = new SortedSet();
        if (fromItem <= get(0)) {
            System.out.println("null returned in headSet");
            return null;
        }
        for (int i = 0; i < indexOf(fromItem); i++) {
            head.add(get(i));

        }
        return head;
    }

    public int last() {
        return get(size - 1);
    }
}





public class Solution {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        SortedSet s = new SortedSet();
        int numOfOperation = scan.nextInt();
        scan.nextLine();
        String[] tokens;
        for (int i = 0; i < numOfOperation; i++) {
            String line = scan.nextLine();
            tokens = line.split(" ");
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "add":
                s.add(Integer.parseInt(tokens[1]));
                break;
            case "addAll":
                String[] input = tokens[1].split(",");
                int[] input1 = new int[input.length];
                for (int j = 0; j < input.length; j++) {
                    input1[j] = Integer.parseInt(input[j]);
                }
                s.addAll(input1);
                break;
            case "subSet":
                String[] input2 = tokens[1].split(",");
                System.out.println(s.subSet(Integer.parseInt(input2[0]), Integer.parseInt(input2[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "headSet":
                System.out.println(s.headSet(Integer.parseInt(tokens[1])));
                break;
            case "last":
                System.out.println(s.last());
                break;
            default:
            }

        }
    }
}