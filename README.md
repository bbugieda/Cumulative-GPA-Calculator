# Cumulative GPA Calculator
A Java program which converts quality points and credit hours (using the University of Delaware grading scale) into a cumulative GPA

## Installation
It is recommended to download the Netbeans IDE to run this program. You can download Netbeans at the following url:
```https://netbeans.org/downloads/8.1/```

## Setting up Environment
1. Open a terminal and type the following to clone a copy of the repository to your local computer
```bash
git clone https://github.com/bbugieda/cumulative-GPA-calculator.git
```
2. If you are using Netbeans, open the project that you cloned to your machine. If you are not using Netbeans, you can open the java program in an IDE of your chosing. Create a new ```java``` project and copy the files in the ```src``` directory into the ```src``` folder that is generated for the new project. You may need to refactor package names to eliminate errors.

3. Clean and build the project and resolve any other potential warnings.

## Adding Grades to the Gradebook
There are a few steps to add a new grades to a gradebook. Follow this guide to correctly add another semester's grades to the gradebook:

1. Find the ```semester1Grades``` template method in ```UD_PredictedOverallGPA.java``` below the ```printCourses``` method:

```
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
```

2. ```newGrade``` takes three parameters: a course ID (string), a letter grade (enumeration), and the number of credit hours (enumeration). Replace the current values with ones that reflect your course grade information. To do that, provide a string for the course you took (so you have a way to reference it), use the ```QualityPointValue``` enumeration to select the grade you received in the class, and the ```CreditHours``` enumeration to select the number of credit hours the course counted for. You can add as many ```newGrade``` for each semester.

3. To add another semester, simply repeat the above process, but remember to add a method call to the new semester you created in the ```main``` method inside ```UD_PredictedOverallGPA.java``` similar to how I added ```semester1Grades(gradeBook);``` on line 19.

## Running your Program
Be sure to clean and build your project before running and resolve any issues that may occur. A successful build should output a result similar to the following:
```
Total Quality (Credit) Hours: 15.0
Total Quality Points: 57.669

Predicted Overall GPA: 3.845

Course: LEAD 100	 Credit Hours: 3.0	 Quality Points: 4.0
Course: ENGL 110	 Credit Hours: 3.0	 Quality Points: 4.0
Course: CISC 108	 Credit Hours: 3.0	 Quality Points: 3.667
Course: MATH 241	 Credit Hours: 4.0	 Quality Points: 3.667
Course: EGGG 101	 Credit Hours: 2.0	 Quality Points: 4.0
```

The first three lines in the output tell you the total number of credit hours and quality points you have accumulated over all of your semesters, as well as your overall GPA with the grades you added. The rest of your output should be a list of all courses you have taken and added to the gradebook. 

#### **Note: Courses shown in the output list (below the first three lines) will not necessarily be in the order you added them, as they are being printed from an ArrayList which was constructed by iterating over a HashMap.
