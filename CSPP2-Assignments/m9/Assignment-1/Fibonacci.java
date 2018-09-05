import java.util.Scanner;
//import List.java;

/*
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 */
/**.
 * This is a Fibanacci class
 */
public final class Fibonacci {
    /**.
     * This is constructor object
     */
    private Fibonacci() {
        //This is contructor
    }
    /*
     * fib is a static method takes a argument n
     * n is the count of the fibonacci numbers to be generated.
     * The method returns a List with the n fibonacci numbers.
     *
     * Look for the hint.txt if some of the testcases fail.
     */
    /**.
     * { This is method is to print the fibonacci in a list }
     *
     * @param      n     { integer }
     *
     * @return     { a list datatype }
     */
    public static List fib(final int number) {
        // todo - complete this method
        List l = new List(number);
        int previous = 0;
        int latest = 1;
        l.add(previous);
        int temp = 0;
        for (int i = 0; l.size < number; i++) {
            l.add(latest);
            //System.out.println(l.tostring());
            temp = latest;
            latest = latest + previous;
            previous = temp;
            /*System.out.println(l.size);
            System.out.println(latest);
*/
        }

        return l;
    }
    /**.
     * { This is main method }
     *
     * @param      args  Argument
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(fib(number).tostring());
    }
}