import java.security.SecureRandom;
import java.util.ArrayList;

/**
* Filename: CAIMonitoringStudentPerformance.java
*
* @see     CAIMonitoringStudentPerformanceTest
* @author  Osman Kahya - kahya.osman@yahoo.com
* @version 1.0 Oct 13, 2018.
*/

public class CAIMonitoringStudentPerformance{
    private SecureRandom randomGenerator = new SecureRandom();

    private ArrayList<String> success = new ArrayList<String>();
    private ArrayList<String> failure = new ArrayList<String>();

    private int[] values = new int[2];
    private int results = 0;

    // constructor
    public CAIMonitoringStudentPerformance(){
        success.add("Very Good!");
        success.add("Excellent!");
        success.add("Nice Work!");
        success.add("Keep up the good work!");

        failure.add("No. Please try again.");
        failure.add("Wrong. Try once more.");
        failure.add("Don't give up.");
        failure.add("No. Keep trying.");

        setQuestion();
    }
    // setters
    /**
     * sets and stores 2 random digits of the question
     */
    public void setQuestion(){
        values[0] = randomGenerator.nextInt(9);
        values[1] = randomGenerator.nextInt(9);
    }
    // getters
    public void getQuestion(){
        System.out.printf("How much is %d times %d? ", values[0], values[1]);
    }
    public void getResults(){
        System.out.printf("You scored %d out of 10.\n", results);

        if(results >= (10 * 0.75)){
            System.out.println("Congratulations you are ready to go the next level!");
        }
        else{
            System.out.println("Please ask your teacher for extra help.");
        }
    }
    /**
     * resets the question params and prints the new question
     */
    public void newQuestion(){
        setQuestion();
        getQuestion();
    }
    /**
     * checks the answer, prints appropriate response, resets the question
     */
    public void checkAnswer(int answer){
        if(answer == values[0] * values[1]){
            System.out.println(success.get(randomGenerator.nextInt(success.size())));
            setQuestion();
            results++;
        }else{
            System.out.println(failure.get(randomGenerator.nextInt(failure.size())));
        }
    }
    /**
     * resets the count and starts a new round
     */
    public void reset(){
        results = 0;
        setQuestion();
    }
}
