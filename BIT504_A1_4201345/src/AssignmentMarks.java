		// ***** Ruth Davis 4201345 BIT504 Assignment 1


public class AssignmentMarks {

	// declare private variables for the class
	private String courseName;
	private int assignment1;
	private int assignment2;
	private int assignment3;
	
	// public constructor for the class
	public AssignmentMarks(String name, int mark1, int mark2, int mark3)
	{
		courseName = name;
		assignment1 = mark1;
		assignment2 = mark2;
		assignment3 = mark3;
	}
	
	
	// public methods for the class 
		
	public int getMark(int assignmentNumber)				// method assigns the mark from the assignment1, 2, or 3 private variables 
	{														// to the variable "assignmentNumber" for use in other classes.
		if (assignmentNumber == 1)
		{
			assignmentNumber = assignment1;
		}
		else if (assignmentNumber == 2)
		{
			assignmentNumber = assignment2;
		}
		else if (assignmentNumber == 3)
		{
			assignmentNumber = assignment3;
		}
		return assignmentNumber;
	}
	
	public int getAverageMark()								// averages the marks from the 3 assignments and returns this in variable "average"
	{														// for use in other classes.
		int average = (assignment1 + assignment2 + assignment3) / 3;
		return average;
	}
	
	public String getGrade(int assignmentNumber)			// method assigns the mark from the assignment1, 2, or 3 private variable
	{														// to the variable "assignmentNumber" for use in other classes and the markToGrade method.
		String assignmentGrade ="";
		
		if (assignmentNumber == 1)
		{
			assignmentNumber = assignment1;
		}
		else if (assignmentNumber == 2)
		{
			assignmentNumber = assignment2;
		}
		else if (assignmentNumber == 3)
		{
			assignmentNumber = assignment3;
		}

		assignmentGrade = markToGrade(assignmentNumber);
		return assignmentGrade;
	}
	
	public String getAverageGrade()								// gets the average mark and passes it to MarkToGrade to convert to a letter grade
	{															
		String aveGrade = "";
		int average = (assignment1 + assignment2 + assignment3) / 3;
		aveGrade = markToGrade(average);
		return aveGrade;
	}
	
	public String markToGrade(int mark)							// converts mark numbers to letter grades
	{
		String grade = "";
		
		if (mark <= 40)
		{
			grade = "D"; 
		}
		else if (mark >= 41 && mark <= 49)
		{
			grade = "C-";
		}
		else if (mark >= 50 && mark <= 59)
		{
			grade = "C";
		}
		else if (mark >= 60 && mark <= 69)
		{
			grade = "C+";
		}
		else if (mark >= 70 && mark <= 74)
		{
			grade = "B-";
		}
		else if (mark >= 75 && mark <= 79)
		{
			grade = "B";
		}
		else if (mark >= 80 && mark <= 84 )
		{
			grade = "B+";
		}
		else if (mark >= 85 && mark <= 89)
		{
			grade = "A-";
		}
		else if (mark >= 90 && mark <= 94)
		{
			grade = "A";
		}
		else if (mark >= 95 && mark <= 100)
		{
			grade = "A+";
		}
		else
		{
			grade = "mark cannot be found";
		}
		return grade;		
	}
	
	
	public String getCourseName()									// gets the name of the course from the private variable for use in other classes. 
	{
		return courseName;
	}


	// set the values for the assignments in the constructor and do not currently have a need to change the value. As such do not need the setter method from the task brief in this programme currently
	//public void setMark(int assignmentNumber, int mark)
	//{

	//}
	
	// set the course name in the constructor and do not currently have a need to change the value. As such do not need the setter method from the task brief in this programme currently
	// public String setCourseName(String name)
	//{
		
	//}
}

