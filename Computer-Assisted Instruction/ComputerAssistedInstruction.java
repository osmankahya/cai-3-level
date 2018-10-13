import java.util.Scanner;
import java.security.SecureRandom;

/**
* <h1>Computer-Assisted Instruction</h1>
* Filename: ComputerAssistedInstruction.java

* @author  Osman Kahya - kahya.osman@yahoo.com
* @version 1.0 Oct 13, 2018.
*/ 

public class ComputerAssistedInstruction{
    private static SecureRandom randomGenerator = new SecureRandom();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] digits = new int[2];
        char cont = 'y';

        while(cont == 'y'&& cont != 'n'){
            digits = newQuestion();

            while(true){
                System.out.printf("How much is %d times %d? ", digits[0], digits[1]);

                if(checkAnswer(digits[0], digits[1], input.nextInt())){
                    System.out.println("Very good!");
                    break;
                }
                else{
                    System.out.println("No. Please try again.");
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
}
