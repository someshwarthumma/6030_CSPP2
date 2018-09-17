import java.util.Scanner;
/**
 * Class for question.
 */

/**
 * Class for quiz.
 */
class Quiz {
    List<Questions>questionsObj;
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Questions[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questionsObj= new List<Questions>();
    }


    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Questions q) {
        questionsObj.add(q);
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Questions getQuestion(final int i) {

        return questionsObj.get(i);
    }
    
    public String showReport() {
        String s = "";
        return s;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    static List<Integer>marksList= new List<Integer>();
    static boolean flag =false;
    private Solution() {
        // leave this blank
    }
    /**
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
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner s,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        

        totalGivenQuestion = q;
        for(int i =0; i<q;i++){
            String[] line = s.nextLine().split(":");
            String[] choices = line[1].split(",");
            quiz.addQuestion(new Questions(line[0],choices,
                Integer.parseInt(line[2]),Integer.parseInt(line[3]),Integer.parseInt(line[4])));
        }
        System.out.println(q+" are added to the quiz");
        

    }

    static int totalGivenQuestion;

    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner s,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        if(totalGivenQuestion==q){
            //printing the question with choices.
            for(int i =0;i<q;i++){
                if(quiz.getQuestion(i).getQuestion().length()==0){
                    flag=true;
                    System.out.println("Error! Malformed question");
                    return;
                }
                System.out.println(quiz.getQuestion(i).getQuestion()+"("+quiz.getQuestion(i).getMaxMarks()+")");
                String[] temp =quiz.getQuestion(i).getChoices();

                for(int j=0;j<temp.length-1;j++){
                    System.out.print(temp[j]+"\t");
                }
                System.out.println(temp[temp.length-1]);
                System.out.println();
                //Evaluate the responses
                String inp = s.nextLine();
                if(inp.equals(quiz.getQuestion(i).getCorrectResponse())){
                    marksList.add(quiz.getQuestion(i).getMaxMarks());
                } else {
                    marksList.add(quiz.getQuestion(i).getPenalty());
                }


            }

        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        if(flag==false){
            int sum = 0;
            for(int i = 0; i< marksList.size();i++){
                System.out.println(quiz.getQuestion(i).getQuestion());
                if(marksList.get(i)>0){
                    System.out.println(" Correct Answer! - Marks Awarded: "+marksList.get(i));
                } else {
                    System.out.println(" Wrong Answer! - Penalty: "+marksList.get(i));
                }
                sum += marksList.get(i);
                
            }
            System.out.println("Total Score: "+sum);
        }


        return;
    }
}
