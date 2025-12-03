package ph.com.bpi.hello;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Student_Grading {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        
        char     pick        = '\0';
        String   studentName = "";
        String   studentID   = "";
        int      numSub      = 0 ;
        double[] grades      = null;
        double   aveScore    = 0;
        int      mainDisplay = 1;
        String stats         = "";
        String compStats     = "x";

  
        do {
            System.out.println("===== STUDENT GRADING SYSTEM =====");
            System.out.println("A - Add Student Information");
            System.out.println("B - Compute Student Average");
            System.out.println("C - Display Student Information");
            System.out.println("D - Exit");
            System.out.print("Enter choice: ");
            
            String choice = input.nextLine().trim(); 
            if (!choice.isEmpty()) {
            	pick = choice.charAt(0);
            } else {
                pick = input.nextLine().charAt(0); 
            }//end of if condition

            switch (pick) {
           	case 'a':
           	case 'A':

           		try {
               		System.out.print("Enter student name: ");
           			studentName = input.nextLine();
           			System.out.print("Enter student ID: ");
           			studentID = input.nextLine();
           			System.out.print("Enter number of  subjects: ");
           			numSub = input.nextInt();
           			grades = new double[numSub];
           			
           			for (int i = 0; i < numSub; i++) {
           				System.out.print("Enter grade for subject " + (i + 1) + ": ");
           				grades[i] = input.nextDouble();
           	        }// end of for loop
           			
                    compStats = "x";
           			System.out.println("===== STUDENT SAVED =====");
           			System.out.println(" ");
           		 	
           		} catch (InputMismatchException e) {
           			compStats = "x";
           			System.out.println("Wrong Input. Please Try Again!");
           			System.out.println(" ");
           			input.nextLine();
           			grades = null;
           		}// end of try and catch
            break;
            
           	case 'b':
           	case 'B':

           		if (grades == null && compStats == "x") {
           			System.out.println("Please Input Student Information First!");
           			System.out.println(" ");
           		} else {
           			double sum = 0;
           			for (int i = 0; i < grades.length; i ++ ) {
           				sum = sum + grades[i];
           			}//end of for loop
           			
           			aveScore = sum / grades.length;
           			
           			System.out.println("Average: " + aveScore );
           			
           			if (aveScore >= 75.00) {
           				stats = "PASSED";
           			} else { 
           				stats = "FAILED";      			
           			} // end of if condition
           			
           			compStats = "y";
           			System.out.println("Status:  " + stats );
           			System.out.println(" ");
				}// end of if condition
           	break;
           	
           	case 'c':
           	case 'C':
           		if(studentName == "") {
           			System.out.println("Please Input Student Information First!");
           			System.out.println(" ");
           		} else if (compStats == "x") {
           			System.out.println("Please Compute grades First!");
           			System.out.println(" ");
           		} else {	
           			System.out.println("===== STUDENT SUMMARY =====");
           			System.out.println("Student Name : " + studentName);
           			System.out.println("Student ID   : " + studentID);
           			System.out.println("Average Grade: " + aveScore);
           			System.out.println("Status       : " + stats);
           			System.out.println("===========================");
           			System.out.println(" ");
           		}// end of if condition
            break;

           	case 'd':
           	case 'D':
           		System.out.println("Thank you for using the Student Grading System!");
           		mainDisplay ++;
            break;

           	default:
           		System.out.println("Wrong Input: Try Again");
           		System.out.println(" ");
           		break;
           } // end of switch case
        } while (mainDisplay == 1); // end of while loop        
        input.close();
    }// end of main method
	
}// end of main class
