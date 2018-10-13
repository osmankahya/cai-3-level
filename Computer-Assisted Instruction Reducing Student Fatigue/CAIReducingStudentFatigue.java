import java.util.Scanner;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
* <h1>Computer-Assisted Instruction: Reducing Student Fatigue</h1>
* Filename: CAIReducingStudentFatigue.java

* @author  Osman Kahya - kahya.osman@yahoo.com
* @version 1.0 Oct 13, 2018.
*/ 

public class CAIReducingStudentFatigue{
    private static SecureRandom randomGenerator = new SecureRandom();
    private static ArrayList<String> success = new ArrayList<String>();
    private static ArrayList<String> failure = new ArrayList<String>();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] digits = new int[2];
        char cont = 'y';

        success.add("Very Good!");
        success.add("Excellent!");
        success.add("Nice Work!");
        success.add("Keep up the good work!");

        failure.add("No. Please try again.");
        failure.add("Wrong. Try once more.");
        failure.add("Don't give up.");
        failure.add("No. Keep trying.");

        while(cont == 'y'){
            digits = newQuestion();

            while(true){
                System.out.printf("How much is %d times %d? ", digits[0], digits[1]);

                if(checkAnswer(digits[0], digits[1], input.nextInt())){
                    printResponse("success");
                    break;
                }else{
                    printResponse("failure");
                }
            }
            System.out.print("Continue? (y/n) ");
            cont = input.next().charAt(0);
        }
        input.close();
    }
    /** 
     * returns 2 random digits for the question
     * 
     */
    public static int[] newQuestion(){
        int[] tmp = {randomGenerator.nextInt(9), randomGenerator.nextInt(9)};

        return tmp;
    }
    /** 
     * checks your the answer of the question
     * 
     */
    public static boolean checkAnswer(int digit1, int digit2, int answer){
        if(answer == digit1 * digit2){
            return true;
        }
        else{
            return false;
        }
    }
    /** 
     * randomly chooses responses and prints from the ArrayList
     * 
     */
    public static void printResponse(String condition){
        switch(condition){
            case "success":
                System.out.println(success.get(randomGenerator.nextInt(success.size())));
                break;
            case "failure":
                System.out.println(failure.get(randomGenerator.nextInt(failure.size())));
                break;
            default:
                break;
        }
    }
}
