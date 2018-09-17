import java.util.Scanner;



class Quiz {
    List<Questions>questionsObj;
    static int totalQuestion;
    List<Integer>marks;
    static boolean flag = false;
    public Quiz() {
        questionsObj = new List<Questions>();
        marks = new List<Integer>();
    }


    public void loadQuestions(Scanner s, int no) {
        try {
            totalQuestion = no;
            for (int i = 0; i < no; i++) {
                String[] d = s.nextLine().split(":");
                if (d.length != 5 || d[0] == null) {
                    flag = true;
                    throw new Exception("Error! Malformed question");
                    //return;
                }
                String[] choices = d[1].split(",");
                if (choices.length < 2) {
                    flag =  true;
                    throw new Exception(
                    "trick  question  does not have enough answer choices");
                    //return;
                }
                if (Integer.parseInt(d[2]) > choices.length) {
                    flag = true;
                    throw new Exception(
  "Error! Correct answer choice number is out of range for question text 1");
                    //return;
                }
                questionsObj.add(new Questions(d[0], choices, Integer.
                    parseInt(d[2]), Integer.
                    parseInt(d[3]), Integer.
                    parseInt(d[4])));;
            }
            if (no == 0) {
                flag = true;
                throw new Exception("Quiz does not have questions");
                //return;
            }
            System.out.println(no + " are added to the quiz");
        } catch ( Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void startQuiz(Scanner s, int num) {
        try {
            if (num == totalQuestion) {
                for (int i = 0; i < num; i++) {
                    try {
                        System.out.println(questionsObj.get(i).
                            getQueston() + "(" + questionsObj.get(i).
                            getMaxMarks() + ")");

                    } catch (Exception e) {
                        return;
                    } String[] options = questionsObj.get(i).getChoices();

                    //System.out.println("Oprions length()"+options.length);
                    for (int j = 0; j < options.length - 1; j++) {
                        //System.out.println("This is for in for:");
                        System.out.print(options[j] + " ");
                    }
                    System.out.println(options[options.length - 1]);
                    System.out.println();
                    String chosenOption = s.nextLine();

                    if (chosenOption.equals(questionsObj.get(i).getCorrectResponse())) {
                        marks.add(questionsObj.get(i).getMaxMarks());
                    } else {
                        marks.add(questionsObj.get(i).getPenalty());
                    }
                }
            }
        } catch (Exception e) {
            return;
        }

    }


    public void displayScore() {
        try {
            if (flag == true) {
                return;
            }
            int sum = 0;
            int lengthMarks = marks.size();
            for (int i = 0; i < lengthMarks; i++) {
                System.out.println(questionsObj.get(i).getQueston());
                sum = sum + marks.get(i);
                if (marks.get(i) > 0) {
                    System.out.println(
                        " Correct Answer! - Marks Awarded: " + marks.get(i));
                } else {
                    System.out.println(
                        " Wrong Answer! - Penalty: " + marks.get(i));
                }
            }
            if (totalQuestion == 0) {
                return;
            }

            System.out.println("Total Score: " + sum);
        } catch (Exception e) {
            return;
        }
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
                q.loadQuestions(s, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                /*if(flag==true){
                    break;
                }*/
                q.startQuiz(s, Integer.parseInt(tokens[1]));

                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                /*if(flag==true){
                    break;
                }*/
                q.displayScore();
                break;
            default:
                break;
            }
        }
    }

    /* public static void loadQuestions(final Scanner s
    , final Quiz quiz, final int questionCount) {
         // write your code here to read the questions from the console
         // tokenize the question line and create the question object
         // add the question objects to the quiz class
     }*/


    /*public static void startQuiz(final Scanner s, final Quiz quiz
    , final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
    }
    */

    /*public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }*/
}
