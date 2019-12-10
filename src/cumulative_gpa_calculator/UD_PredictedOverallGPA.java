package cumulative_gpa_calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author bbugieda
 */
public class UD_PredictedOverallGPA 
{   
    public static void main(String[] args) 
    {
        Gradebook gradeBook = new Gradebook();
        HashMap<String, ArrayList<Double>> courses = null;
        
        // Adds FRESHMAN year grades to the grade book
        semester1Grades(gradeBook);
        
        System.out.println("Total Quality (Credit) Hours: " + gradeBook.getTotalCreditHours());
        System.out.println("Total Quality Points: " + gradeBook.getTotalQualityPoints());
        System.out.println("\nPredicted Overall GPA: " + gradeBook.calculateGPA(gradeBook.getTotalQualityPoints(), gradeBook.getTotalCreditHours()) + "\n");
        
        printCourses(gradeBook, courses); // Prints out all courses with their respective credit hours and quality points
    }
    
    //--------------------------------------------------------------------------------------------------------
    //  Methods to Input Semester Grades and Print All CourseWork
    //--------------------------------------------------------------------------------------------------------
    
    /**
     * printCourses()
     * Visually prints all of the courses taken, along with the credit hours for 
     * the course and the quality points earned based on your final grade
     * @param gradeBook, the grade book you wish to print out
     * @param courses, a HashMap with all of the course information in your grade book
     * 
     * @author bbugieda
     */
    public static void printCourses(Gradebook gradeBook, HashMap<String, ArrayList<Double>> courses) {
        courses = gradeBook.getCourses();
        
        Iterator<String> courseID = courses.keySet().iterator();
        Iterator<ArrayList<Double>> courseInformation = courses.values().iterator();
        
        while(courseID.hasNext() && courseInformation.hasNext()) {
            ArrayList<Double> currentCourse = courseInformation.next();
            
            System.out.print("Course: " + courseID.next());
            System.out.print("\t Credit Hours: " + gradeBook.displayCreditHoursForOneCourse(currentCourse));
            System.out.println("\t Quality Points: " + gradeBook.displayQualityPointsForOneCourse(currentCourse));
        }
    }
    
    /**
     * semester1Grades()
     * Adds all Semester 1 Grades into the requested grade book
     * @param gradeBook, the grade book to input grades
     * 
     * @author bbugieda
     */
    public static void semester1Grades(Gradebook gradeBook) {
        gradeBook.newGrade("EGGG 101", QualityPointValue.A, CreditHours.TWO);
        gradeBook.newGrade("CISC 108", QualityPointValue.A_MINUS, CreditHours.THREE);
        gradeBook.newGrade("MATH 241", QualityPointValue.A_MINUS, CreditHours.FOUR);
        gradeBook.newGrade("ENGL 110", QualityPointValue.A, CreditHours.THREE);
        gradeBook.newGrade("LEAD 100", QualityPointValue.A, CreditHours.THREE);
    }
    
}
