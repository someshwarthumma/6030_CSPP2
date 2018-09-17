import java.util.Scanner;

/**.
 * Class for quiz.
 */
class Quiz {
    /**.
     * This is Question bj
     */
    private List<Questions> questionsObj;
    /**.
     * { var_description }.
     */
    private final int onehundred = 100;
    /**.
     * { var_description }.
     */
    private Questions[] questions;
    /**.
     * { var_description }.
     */
    private int size;
    /**.
     * Constructs the object.
     */
    Quiz() {
        /**.
         * This is question obj for list
         */
        questionsObj = new List<Questions>();
    }


    /**.
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Questions q) {
        questionsObj.add(q);
    }
    /**.
     * Gets the question.
     *
     * @param      i  The index
     *
     * @return     The question.
     */
    public Questions getQuestion(final int i) {

        return questionsObj.get(i);
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
        // leave this blank
    }
    /**.
     * This is marklist for list of type integer
     */
    private static List<Integer> marksList = new List<Integer>();
    /**.
     * boolean flag for error checking
     */
    private static boolean flag = false;
    /**.
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {


        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                if (flag) {
                    break;
                }
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                if (flag) {
                    break;
                }
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**.
     * Loads questions.
     *
     * @param      s       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner s,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        try {
            if (q == 0) {
                flag = true;
                throw new Exception("Quiz does not have questions");
                //return;
            }

            totalGivenQuestion = q;
            for (int i = 0; i < q; i++) {
                String[] line = s.nextLine().split(":");
                //error for abnormal marks.
                final int five = 5;
                final int zero = 0;
                final int four = 4;
                final int three = 3;
                final int two = 2;
                if (line.length != five || line[0].length() == zero) {
                    flag = true;
                    throw new Exception("Error! Malformed question");
                    //return;
                }

                if (Integer.parseInt(line[three]) < zero) {
                    flag = true;
                    throw new Exception("Invalid max marks for " + line[zero]);
                    //return;
                }
                if (Integer.parseInt(line[four]) > 0 + 0) {
                    flag = true;
                    throw new Exception("Invalid penalty for " + line[zero]);
                    //return;
                }
                //error if question is not given.

                String[] choices = line[1].split(",");
                //error for one option.
                if (choices.length < two) {
                    flag = true;
                    throw new Exception(line[zero]
                        + " does not have enough answer choices");
                    //return;

                }
                //For finding the malformed question for finding wrong option
                if (Integer.parseInt(line[two]) > choices.length) {
                    flag = true;
                    throw new Exception(
        "Error! Correct answer choice number is out of range for " + line[zero]);
                    //return;
                }
                try {
                    quiz.addQuestion(new Questions(line[zero], choices, Integer.
                        parseInt(line[two]), Integer.
                        parseInt(line[three]), Integer.
                        parseInt(line[four])));
                } catch (Exception e) {
                    flag = true;
                    throw new Exception("Error! Malformed question");
                    //return;
                }
            }
            System.out.println(q + " are added to the quiz");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**.
     * This is static variable for given total questions
     */
    private static int totalGivenQuestion;

    /**.
     * Starts a quiz.
     *
     * @param      s  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner s,
                                 final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        if (totalGivenQuestion == q) {
            //printing the question with choices.
            for (int i = 0; i < q; i++) {
                System.out.println(quiz.getQuestion(i).
                    getQuestion() + "(" + quiz.
                    getQuestion(i).getMaxMarks() + ")");
                String[] temp = quiz.getQuestion(i).getChoices();

                for (int j = 0; j < temp.length - 1; j++) {
                    System.out.print(temp[j] + "\t");
                }
                System.out.println(temp[temp.length - 1]);
                System.out.println();
                //Evaluate the responses
                String inp = s.nextLine();
                if (inp.equals(quiz.getQuestion(i).getCorrectResponse())) {
                    marksList.add(quiz.getQuestion(i).getMaxMarks());
                } else {
                    marksList.add(quiz.getQuestion(i).getPenalty());
                }


            }

        }
    }
    /**.
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        if (!flag) {
            int sum = 0;
            for (int i = 0; i < marksList.size(); i++) {
                System.out.println(quiz.getQuestion(i).getQuestion());
                if (marksList.get(i) > 0) {
                    System.out.println(
                    " Correct Answer! - Marks Awarded: " + marksList.get(i));
                } else {
                    System.out.println(
                    " Wrong Answer! - Penalty: " + marksList.get(i));
                }
                sum += marksList.get(i);

            }
            System.out.println("Total Score: " + sum);
        }
        return;
    }
}
