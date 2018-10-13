import java.util.Scanner;

/**
* <h1>Computer-Assisted Instruction: Monitoring Student Performance</h1>
* Filename: CAIMonitoringStudentPerformanceTest.java
*
* @see     CAIMonitoringStudentPerformance
* @author  Osman Kahya - kahya.osman@yahoo.com
* @version 1.0 Oct 13, 2018.
*/ 

public class CAIMonitoringStudentPerformanceTest{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        CAIMonitoringStudentPerformance cai = new CAIMonitoringStudentPerformance();

        int count = 0;
        char cont = 'y';

        while(cont == 'y'){
            // inner loop to ensure a sample size of 10
            while(count != 10){
                cai.getQuestion();
                cai.checkAnswer(input.nextInt());

                count++;
            }
            cai.getResults();

            System.out.print("Continue? (y/n) ");
            cont = input.next().charAt(0);

            if(cont == 'y')
                count = 0;
                cai.reset();
        }
        input.close();
    }
}
