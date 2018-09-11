import java.util.Scanner;
import java.util.Arrays;
/**.
 * This is list ADT
 */
class List {
    //Implement all the methods mentioned to build a ListADT

    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */

    /**.
     * This is intialisation for list
     */
    private int[] list;
    /**.
     * This is size
     */
    private int size;
    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor

    /*
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     *
     */

    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor

    /*
     * The purpose of the constructor is to initialize the class variables with
     * some default values.
     */
    /**.
     * This is resize method
     */
    private void resize() {
        list = Arrays.copyOf(list, 2 * list.length);
    }

    /**.
     * This is list
     */
    List() {

        // what are the two variables to be initialized here? think about the
        // private variables described above. What should be the default values?
        // In the case of the list, it should be empty but it should be
        // initialized with an array size like 10
        /**
         * This is declaration of int array size
         */
        final int ten = 10;
        list = new int[ten];
        size = 0;
        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.

    }

    /*
     * The add method does what the name suggests. Add an int item to the list.
     * The assumption is to store the item at the end of the list What is the
     * end of the list? Is it the same as the end of the array? Think about how
     * you can use the size variable to add item to the list.
     *
     * The method returns void (nothing)
     */

    /**.
     * This is add method
     *
     * @param      item  item to add
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        if (size == list.length) {
            resize();
        }
        list[size] = item;
        size++;
    }

    /*
     * The size method returns the value of the size. The purpose of the method
     * is to announce the size of the list to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     *
     */

    /**.
     * This is to return the size
     *
     * @return     { integer }
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }

    /*
     * The remove method does what the name suggests. Removes an int item,
     * specified by the index argument, from the list It also does an additional
     * step. Think about what happens when an item is removed from the middle of
     * the list It creates a hole in the list, right? This would mean, all the
     * items that are to the right side of the removed item should be moved to
     * the left by one position. Here is an example: array =
     * [1,2,3,0,0,0,0,0,0,0] remove(1) would remove the item 2 which is at index
     * position 1. But how do you remove the item from an array? Well, the way
     * to remove it is to move all the items, that are to the right of the
     * removed item, to the left So, the new array looks like this. array =
     * [1,3,0,0,0,0,0,0,0,0] The method returns void (nothing)
     *
     */

    /**.
    * { function_description }
    *
    * @param      index      The index
    *
    * @throws     Exception  { exception_description }
    */
    public void remove(final int index) throws Exception {
        // write the logic for remove here. Think about what to do to the size
        // variable.
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            throw new Exception("Invalid Position Exception");
            //System.out.println("Invalid Position Exception");
        }

    }

    /*
     * Get method has to return the items that is at the index position passed
     * as an argument to the method. If the item doesn't exist then return a -1
     * to indicate that there is no element at that index. How can an element
     * not be there at a given position? Well, if the position is greater than
     * the number of items in the list then that would mean the item doesn't
     * exist. How do we check if the position is greater than the number of
     * items in the list? Would size variable be useful?
     */

    /**.
     * This is to get the element at the given index
     *
     * @param      index  index
     *
     * @return     { integer }
     */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (index < 0 || index >= size) {
            return -1;
        }
        return list[index];

    }

    /*
     * What happens when you print an object using println? Java provides a
     * method named toString that is internally invoked when an object variable
     * is used in println. For example: List l = new List();
     * System.out.println(l); This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items in the list in the
     * square brackets notation. i.e., if the list has numbers 1, 2, 3 return
     * the string [1,2,3] Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0] toString should only return the items in
     * the list and not all the elements of the array.
     */

    /**.
     * This is to print the array list
     *
     * @return     String.
     */
    public String toString() {
        // Replace the code below
        if (size == 0) {
            return "[]";
        } else {
            String str = "[";
            for (int i = 0; i < size - 1; i++) {
                str += list[i] + ",";
            }
            return str + list[size - 1] + "]";
        }
    }
    /*
     * Contains return true if the list has the item passed as an argument to
     * the method So, iterate through the list and return true if the item
     * exists and otherwise false
     */

    /**.
     * This is to check the element in t a given array
     *
     * @param      item  Integer
     *
     * @return     { boolean }
     */
    public boolean contains(final int item) {
        // Replace the code below

        if (indexOf(item) == -1) {
            return false;
        }
        return true;
    }
    /*
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     */

    /**.
     * This is to find the indexOf given item
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        // Replace the code below

        for (int i = 0; i < size; i++) {

            if (list[i] == item) {

                return i;
            }
        }
        return -1;
    }
    /*
    Inserts all the elements of specified int array to the end of list
    */

    /**.
     * this is add all the elements in a given array
     *
     * @param      newArray  array
     */
    public void addAll(final int[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            add(newArray[i]);
        }
    }
    /*
     Removes all of its elements that are contained in the specified int
     array.
    */
    /**
     * Removes all. given elements from the given list.
     *
     * @param      newArray   The new array
     *
     * @throws     Exception  { exception message }
     */
    public void removeAll(final int[] newArray) throws Exception {
        // write the logic
        for (int j : newArray) {
            while (indexOf(j) != -1) {
                remove(indexOf(j));
            }
        }

    }

    /*
    Returns a list object containing elements, including startIndex and
    excluding endIndex. The first parameter indicates the startIndex and the
    second parameter indicates the endIndex. Returns null and print
    "Index Out of Bounds Exception" if any of values start and end are negative
    and also if start is greater than end.
    */

    /**.
     * This is sublist to find the siblist for the given indexes
     *
     * @param      start      start Index
     * @param      end        end Index
     *
     * @return     { List object }
     *
     * @throws     Exception  { exception message }
     */
    public List subList(final int start, final int end) throws Exception {
        // write the logic for subList
        List array = new List();
        int j = 0;
        if (size == 0 && end == 0 && size == 0) {
            throw new Exception("Index Out of Bounds Exception");
        }
        if (start < 0 || end > size) {
            throw new Exception("Index Out of Bounds Exception");
        } else {
            for (int i = start; i < end; i++) {
                array.add(list[i]);
            }
            return array;
        }

    }

    /*
    Returns a boolean indicating whether the parameter i.e a List object is
    exactly matching with the given list or not.
    */

    /**.
     * This is equals method
     *
     * @param      newList  The new list
     *
     * @return     { boolean }
     */
    public boolean equals(final List newList) {
        // Replace the code below
        return toString().equals(newList.toString());
    }
    /*
    * Removes all the elements from list
    * Think about this case and make the method
    * the simpler.
    */
    /**.
     * This is clear method to clear all the elemenets in a given arrray
     */
    public void clear() {
        // write the logic for clear.
        size = 0;
    }
    /**.
     * This is method to find the count of the given number in a given list
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int count(final int item) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                counter++;
            }
        }
        return counter;
    }
    /**.
     * { Adding an element at a given position. }
     *
     * @param      index  index
     * @param      item   item
     */
    public void add(int index, int item) {
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
    }
}


/**.
 * This solution class.
 */
public final class Solution {
    /**.
     * This is solution constructor
     */
    private Solution() {
        //This is solution constructor.
    }
    /**.
     * This is scanner class initialisation.
     */
    private static Scanner scan = new Scanner(System.in);
    /**.
     * This is main funtion.
     *
     * @param      args  command line arguments
     */
    public static void main(final String[] args) {
        List s = new List();
        int num = scan.nextInt();
        scan.nextLine();
        while (scan.hasNext()) {
            try {
                String line = scan.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "size":
                    System.out.println(s.size());
                    break;
                case "add":
                    try{
                    s.add(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
                    break;
                    } catch (Exception e) {
                    s.add(Integer.parseInt(tokens[1]));
                    break;
                    }
                    
                case "print":
                    System.out.println(s);
                    break;
                case "remove":
                    if (tokens.length == 2) {
                        s.remove(Integer.parseInt(tokens[1]));
                    }
                    break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(s.indexOf(
                                               Integer.parseInt(tokens[1])));
                    }
                    break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(s.get(
                                               Integer.parseInt(tokens[1])));
                    }
                    break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(s.contains(
                                               Integer.parseInt(tokens[1])));
                    }
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        int[] temp = new int[t1.length];
                        for (int j = 0; j < temp.length; j++) {
                            temp[j] = Integer.parseInt(t1[j]);
                        }
                        s.addAll(temp);
                    }
                    break;
                case "removeAll":
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        int[] a = new int[t2.length];
                        for (int j = 0; j < t2.length; j++) {
                            a[j] = Integer.parseInt(t2[j]);
                        }
                        s.removeAll(a);
                    }
                    break;
                case "subList":
                    if (tokens.length != 2) {
                        break;
                    }
                    String[] arrstring3 = tokens[1].split(",");
                    List object = s.subList(Integer.parseInt(arrstring3[0]),
                                            Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(object);
                    }
                    break;
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        List l2 = new List();
                        for (int k = 0; k < lt.length; k++) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(s.equals(l2));
                    }
                    break;
                case "clear":
                    s.clear();
                    break;

                case "count":
                    //System.out.println("This is count:");
                    if (tokens.length == 2) {
                        System.out.println(s.count(Integer.
                            parseInt(tokens[1])));

                    }
                    break;
                default:
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
