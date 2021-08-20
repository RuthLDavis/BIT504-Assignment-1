import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;

							// ***** Ruth Davis 4201345 BIT504 Assignment 1


public class Main {

	// declare the "students" list using the ADT LinkedList as a class field. This is available to all methods.
	public static LinkedList<Student> allStudents;
	

	// main method 
	public static void main(String[] args) {
		
		// initialize the "students" list	
		allStudents = new LinkedList<Student>();
		
		// call the readFile() method and provide an error message if this method returns false
		String fileName = "C:/Temp/studentdata.txt";
		
		if (readFile(fileName))						// if the file can be read continue with the programme
		{
		int userOption = 0;								
		do												// do while loop for the menu
		{
			displayMenu();
			userOption = selectMenuOption();
			
			switch (userOption)
			{
				case 1:									// display by marks
				{
					displayReportByMarks();
					break;
				}
				case 2:									// display by grades
				{
					displayReportByGrades();
					break;
				}
				case 3:									// add a new student
				{
					addNewStudent();
					break;
				}
				case 4:									// remove a student
				{
					removeStudent();
					break;
				}	
				case 5:											// exit the programme.
				{
					System.out.println("Programme has ended.");		
					System.exit(0);

				}
				default:
				{
					System.out.println("Please enter a valid option number."); //in case the user enters a number that does not exist in the switch eg 8.
					break;
				}
			}
	
		}while (userOption != 5);
			
				
 
		}
		else
		{
			// display error message cannot read the file
		}
		
	}


	
	
	// other methods for the Main class
	
	public static Boolean readFile(String fileName) 					// reading the file and converting to the correct data type
	{
	
			File file = new File(fileName);
			
			try {
				Scanner scanner = new Scanner(file);
				while(scanner.hasNextLine())
				{
					String[] words = scanner.nextLine().split(",");
					
					int id = Integer.parseInt(words[0]);					// take the data from the file and put it into the correct data types.
					String firstName = words[1];
					String lastName = words[2];
					int mathsMark1 = Integer.parseInt(words[3]);
					int mathsMark2 = Integer.parseInt(words[4]);
					int mathsMark3 = Integer.parseInt(words[5]);
					int englishMark1 = Integer.parseInt(words[6]);
					int englishMark2 = Integer.parseInt(words[7]);
					int englishMark3 = Integer.parseInt(words[8]);
					
					// pass the data to the addStudent method.
					addStudent(id, firstName, lastName, mathsMark1, mathsMark2, mathsMark3, englishMark1, englishMark2, englishMark3);
				}
				scanner.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Failed to read file.");					// in case the file can't be read i.e. if there is an error in the file path
			}
			
			return true;
	}
				
		
	private static void addStudent(int id, String firstName, String lastName, int mathsMark1, int mathsMark2, int mathsMark3, int englishMark1, int englishMark2, int englishMark3)
	{
		 
		 // create a Student object from the data in the file
		 Student student = new Student(id, firstName, lastName);
		 AssignmentMarks maths = new AssignmentMarks("Maths", mathsMark1, mathsMark2, mathsMark3);
		 AssignmentMarks english = new AssignmentMarks("English", englishMark1, englishMark2, englishMark3);
		 student.mathsMarks = maths;
		 student.englishMarks = english;
		 
		 // add the student object to the LinkedList
		 allStudents.add(student);
		 
	}
		
	private static void displayReportByMarks()
	{	// print the heading
		System.out.println("\nID" + "\t" + "Student Name" + "\t" + "Maths" + "\t" + "A1"
				+ "\t" + "A2" + "\t" + "A3" + "\t" + "Average" + "\t\t" + "English" + "\t" + "A1" + "\t" + "A2" + "\t" + "A3" + "\t" + "Average");
		
		// enhanced for loop to iterate through the LinkedList and get the data for each student.
		for(Student list : allStudents) {
			System.out.println(list.id + "\t" + list.getFullName() + "\t\t" +  list.mathsMarks.getMark(1) + "\t" + list.mathsMarks.getMark(2) 
			+ "\t" + list.mathsMarks.getMark(3) + "\t" + list.mathsMarks.getAverageMark() + "\t\t\t" + list.englishMarks.getMark(1) + "\t" 
			+ list.englishMarks.getMark(2) + "\t" + list.englishMarks.getMark(3) + "\t" + list.englishMarks.getAverageMark() + "\n");
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------- \n\n");
	}
	
	private static void displayReportByGrades()
	{	// print the heading
		System.out.println("\nID" + "\t" + "Student Name" + "\t" + "Maths" + "\t" + "A1"
				+ "\t" + "A2" + "\t" + "A3" + "\t" + "Average" + "\t\t" + "English" + "\t" + "A1" + "\t" + "A2" + "\t" + "A3" + "\t" + "Average");
		
		// enhanced for loop to iterate through the LinkedList and get the data for each student.
		for(Student list : allStudents) {
			System.out.println(list.id + "\t" + list.getFullName() + "\t\t" +  list.mathsMarks.getGrade(1) + "\t" + list.mathsMarks.getGrade(2) 
			+ "\t" + list.mathsMarks.getGrade(3) + "\t" + list.mathsMarks.getAverageGrade() + "\t\t\t" + list.englishMarks.getGrade(1) + "\t" 
			+ list.englishMarks.getGrade(2) + "\t" + list.englishMarks.getGrade(3) + "\t" + list.englishMarks.getAverageGrade() + "\n\n" );
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------- \n\n");
	}
		
		
	private static void addNewStudent()
	{	 
		Scanner scanner = new Scanner(System.in);		// create the scanner object to get the user input. 
		
		// integer variables where we will need to perform exception handling on user input.
		int id = 0;
		int mathsMark1 = 0;
		int mathsMark2 = 0;
		int mathsMark3 = 0;
		int englishMark1 = 0;
		int englishMark2 = 0;
		int englishMark3 = 0;
		
		
		while (id == 0)						// ask user for input and validate their input is an integer. Loop until an integer is entered. 
		{
			System.out.print("\nEnter the student's ID number:");
			try
			{	
				id = scanner.nextInt();				
			}
			catch (Exception e)
			{
				System.out.println("\nEnter a valid number.");
				scanner.next();						// discard the bad input
			}
		}
		
		
		System.out.print("Enter the student's first name:");
		String firstName = scanner.next();
		
		System.out.print("Enter the student's last name:");
		String lastName = scanner.next();
		
		
		while (mathsMark1 == 0)				// ask user for input and validate their input is an integer. Loop until an integer is entered.
		{
			System.out.print("Enter the student's mark for Maths assignment 1:");
			try
			{	
				mathsMark1 = scanner.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("\nEnter a valid number.");
				scanner.next();						// discard the bad input
			}
		}
		
		
		while (mathsMark2 == 0)				// ask user for input and validate their input is an integer. Loop until an integer is entered.
		{
			System.out.print("Enter the student's mark for Maths assignment 2:");
			try
			{	
				mathsMark2 = scanner.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("\nEnter a valid number.");
				scanner.next();						// discard the bad input
			}
		}
		
		while (mathsMark3 == 0)				// ask user for input and validate their input is an integer. Loop until an integer is entered.
		{
			System.out.print("Enter the student's mark for Maths assignment 3:");
			try
			{	
				mathsMark3 = scanner.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("\nEnter a valid number.");
				scanner.next();						// discard the bad input
			}
		}
		
		while (englishMark1 == 0)			// ask user for input and validate their input is an integer. Loop until an integer is entered.
		{
			System.out.print("Enter the student's mark for English assignment 1:");
			try
			{	
				englishMark1 = scanner.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("\nEnter a valid number.");
				scanner.next();						// discard the bad input
			}
		}
	
		
		while (englishMark2 == 0)			// ask user for input and validate their input is an integer. Loop until an integer is entered.
		{
			System.out.print("Enter the student's mark for English assignment 2:");
			try
			{	
				englishMark2 = scanner.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("\nEnter a valid number.");
				scanner.next();						// discard the bad input
			}
		}
	
		while (englishMark3 == 0)			// ask user for input and validate their input is an integer. Loop until an integer is entered.
		{
			System.out.print("Enter the student's mark for English assignment 3:");
			try
			{	
				englishMark3 = scanner.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("\nEnter a valid number.");
				scanner.next();						// discard the bad input
			}
		}
		
		
		// pass the data to the addStudent method to be added to the LinkedList.
		addStudent(id, firstName, lastName, mathsMark1, mathsMark2, mathsMark3, englishMark1, englishMark2, englishMark3);
		
		// advise user the student has been added. 
		System.out.println("\nStudent has been added successfully.\n");
		System.out.println("---------------------------------------------------------------------------------------------------------------- \n\n");
	}
		
	private static void removeStudent()
	{	
		Scanner scanner = new Scanner(System.in);		// create the scanner object to get the user input. 
		int removeID = 0;					// Declare and initialise the removeID integer variable. 
		
		while (removeID == 0)				// ask the user for input and validate their input is an integer. Loop until an integer has been entered. 
		{
			System.out.print("\nEnter the ID number of the student to be removed:");
			try
			{	
				removeID = scanner.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("Enter a valid number.");
				scanner.next();						// discard the bad input
			}
		}
		
		
		//create an iterator to search through the list to find the ID number entered by the user.
		Iterator<Student> it = allStudents.iterator();		 
		while(it.hasNext()) 
		{
			Student stud = (Student)it.next();
			if (stud.getStudentID() == removeID) 					// if the id input by the user matches the student id.
				{
					it.remove();									// remove the student from the Linked List. 
					System.out.println("\nStudent has been removed.\n");		// advise the user the student has been removed. 
					System.out.println("---------------------------------------------------------------------------------------------------------------- \n\n");
					return;
		        }        
			
		}
		System.out.println("\nStudent with ID " + removeID + " was not found**\n");   // advise the user if they input a number for which their is no student. 
		System.out.println("---------------------------------------------------------------------------------------------------------------- \n\n");

	}
	

	private static void displayMenu() 	// display the menu only
	{
		System.out.println("\nStudent Report System \n------------------------\n");
		System.out.println("1. Display Student Marks \n2. Display Student Grades \n3. Add New Student \n4. Remove Student \n5. Exit" );
		
	}
	
	private static int selectMenuOption()			// ask user for input and validate user input is an integer. 
	{
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		System.out.print("\nEnter the option number:");
		
        try
        {
            userInput = scanner.nextInt();              				// try catch method to handle letters being entered
        }
        catch (InputMismatchException e)
        {
        	System.out.println("Please enter a valid option number.");
        }
  
		
        return userInput;
		
	}
	
	
}
		
