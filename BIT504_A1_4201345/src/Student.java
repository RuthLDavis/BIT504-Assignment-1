		// ***** Ruth Davis 4201345 BIT504 Assignment 1


public class Student {
	
	// declare the variables for the class
	public int id;
	public String firstName;			
	public String lastName;
	public AssignmentMarks englishMarks;					//mathMarks variable with data type "AssignmentMarks"
	public AssignmentMarks mathsMarks;						//englishMarks variable with data type "AssignmentMarks"

	
	// constructor for the class
	public Student (int id, String firstName, String lastName)
	{
		this.id =id;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	public String getFullName() 							// method to get the full name of the student
	{							
		String fullName = firstName + " " + lastName;
		return fullName;
	}
	
	 public int getStudentID()								// method to get the student id number 
	 {
	    return id;
	 }
}
