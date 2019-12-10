package cumulative_gpa_calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author brianbugieda
 */
public class Gradebook
{
    private final HashMap<String, ArrayList<Double>> courses = new HashMap<>();
    private final DecimalFormat decimalFormat;
    private final int CREDIT_HOURS_INDEX = 0;
    private final int QUALITY_POINTS_INDEX = 1;
    
    private double totalQualityPoints;
    private double totalCreditHours;
    private double cumulativeGPA;
    
    public Gradebook() {
        this.totalQualityPoints = 0.0;
        this.totalCreditHours = 0.0;
        this.decimalFormat = new DecimalFormat("##.000");
    }
    
    /**
     * newGrade()
     * 
     * Creates a new grade using the quality points  and credit hours provided
     * @param courseID, a string representation of the course
     * @param qualityPoints, the number of quality points associated with the grade received
     * @param creditHours, the number of credit hours associated with the course
     * 
     * @author bbugieda
     */
    public void newGrade(String courseID, QualityPointValue qualityPoints, CreditHours creditHours) {
        double points = qualityPoints.getPoints();
        double hours = creditHours.getCreditHours();
        
        ArrayList<Double> hoursAndPoints = new ArrayList<>();
        hoursAndPoints.add(hours);
        hoursAndPoints.add(points);
        
        addCourse(courseID, hoursAndPoints);
        
        updateQualityPoints(qualityPoints, creditHours);
        updateCreditHours(creditHours);
    }
    
    /**
     * newGrade()
     * 
     * Creates a new grade using the quality points provided
     * Assumes that the credit hours for the course is 3, as that is the most common
     * @param courseID, a string representation of the course
     * @param qualityPoints, the number of quality points associated with the grade received
     * 
     * @author bbugieda
     */
    public void newGrade(String courseID, QualityPointValue qualityPoints) {
        double points = qualityPoints.getPoints();
        double hours = CreditHours.THREE.getCreditHours();
        
        ArrayList<Double> hoursAndPoints = new ArrayList<>();
        hoursAndPoints.add(hours);
        hoursAndPoints.add(points);
        
        addCourse(courseID, hoursAndPoints);
        
        updateQualityPoints(qualityPoints, CreditHours.THREE);
        updateCreditHours(CreditHours.THREE);
    }
    
    /**
     * updateQualityPoints()
     * Quality Points are determined by multiplying the quality point value associated 
     * with the grade received in the course by the number of credit hours for that course.
     * 
     * Example:
     *      Quality Point Value = 4.000 (An "A" was earned in the course)
     *      Credit Hours = 3
     *      Quality Points = 4.000 * 3, which is 12 quality points
     * 
     * @param points, the point value associated with the grade received, 
     *      determined by the QualityPointValue enumeration
     * @param hours, the number of credit hours associated with the course, 
     *      determined by the CreditHours enumeration
     * 
     * @author bbugieda
     */
    private void updateQualityPoints(QualityPointValue points, CreditHours hours) {
        double qualityPoints = points.getPoints();
        double numCredits = hours.getCreditHours();
        
        totalQualityPoints += qualityPoints * numCredits;
    }
    
    /**
     * updateCreditHours()
     * Adds the credit hours for the particular course to the total credit hours
     * 
     * @param hours, the number of credit hours associated with the course, 
     *      determined y the CreditHours enumeration
     * 
     * @author bbugieda
     */
    private void updateCreditHours(CreditHours hours) {
        double creditHours = hours.getCreditHours();
        
        totalCreditHours += creditHours;
    }
    
    /**
     * addCourse()
     * Adds the course information to the courses HashMap
     * 
     * @param courseID, a String to be used for the key in the HashMap, since no
     *      two courses have the same Course ID
     * @param hours_points, an ArrayList of Double values representing the credit hour
     * 
     * @author bbugieda
     */
    private void addCourse(String courseID, ArrayList<Double> hours_points) {
        this.courses.put(courseID, hours_points);
    }
    
    /**
     * getCourses()
     * @return courses, the HashMap containing all grade entries
     * 
     * @author bbugieda
     */
    public HashMap<String, ArrayList<Double>> getCourses() {
        return this.courses;
    }
    
    /**
     * getTotalQualityPoints()
     * @return totalQualityPoints, the total number of quality points for all the courses taken
     * 
     * @author bbugieda
     */
    public double getTotalQualityPoints() {
        return this.totalQualityPoints;
    }
    
    /**
     * getTotalCreditHours()
     * @return totalCreditHours, the total number of credit hours for all the courses taken
     * 
     * @author bbugieda
     */
    public double getTotalCreditHours() {
        return this.totalCreditHours;
    }
    
    /**
     * calculateGPA()
     * Calculates the GPA of the student based on the total quality points and total quality hours
     * Divides totalQualityPoints by totalCreditHours to determine GPA
     * Formats the GPA such that it does not go beyond 3 decimal places
     * @param totalQualityPoints, the total number of quality points for all the courses taken
     * @param totalCreditHours, the total number of credit hours for all the courses taken
     * @return formattedGPA, the cumulative GPA in the specified decimal format
     * 
     * @author bbugieda
     */
    public double calculateGPA(double totalQualityPoints, double totalCreditHours) {
        this.cumulativeGPA = totalQualityPoints / totalCreditHours;
        double formattedGPA = Double.parseDouble(decimalFormat.format(this.cumulativeGPA));
        return formattedGPA;
    }
    
    /**
     * displayCreditHoursForOneCourse()
     * Displays the number of credit hours for the requested course
     * @param singleCourse, an ArrayList containing the course credit hours and quality points
     * @return the number of credit hours for this particular course
     * 
     * @author bbugieda
     */
    public double displayCreditHoursForOneCourse(ArrayList<Double> singleCourse) {
        return singleCourse.get(CREDIT_HOURS_INDEX);
    }
    
    /**
     * displayQualityPointsForOneCourse()
     * Displays the number of quality points for the requested course
     * @param singleCourse, an ArrayList containing the course credit hours and quality points
     * @return the number of quality points for this particular course
     * 
     * @author bbugieda
     */
    public double displayQualityPointsForOneCourse(ArrayList<Double> singleCourse) {
        return singleCourse.get(QUALITY_POINTS_INDEX);
    }
}
