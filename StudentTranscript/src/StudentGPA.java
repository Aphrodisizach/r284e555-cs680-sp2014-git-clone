/*
 * Zach Vickers - GPA calculator
 */

import java.util.Scanner;

public class StudentGPA {
	
	private double GPA;
	private double gradePoints;
	private double credHours;
	
	/*
	 * main - handles output/input to/from user, passes these inputs into studentGPA class
	 * for processing
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Hello! Welcome to the GPA calculator.");
		System.out.print("To begin, enter the number of students: ");
		int students = in.nextInt();
		for(int i = 0; i < students; i++)
		{
			StudentGPA current = new StudentGPA();
			System.out.println("Enter student " + i + "'s number of classes:");
			int classes = in.nextInt();
			System.out.println("Now, enter each class' letter grade and the number of credit hours it was, in the format 'B+ 4'");
			for(int x = 0; x < classes; x++)
			{
				System.out.print("Class " + x + ": ");
				String gr = in.next();
				double cred = in.nextDouble();
				current.updateGrade(current.digitizeGrade(gr), cred);
			}
			System.out.format("Final GPA for student %d: %.2f", i, current.GPA);
		}
		in.close();
	}
	
	/*
	 * Initializer - since we're using running totals to calculate,
	 * class fields must be set to 0.
	 */
	public StudentGPA(){
		this.GPA = 0.0;
		this.credHours = 0.0;
		this.gradePoints = 0.0;
	}
	
	/*
	 * digitizeGrade - Converts string such as "B+" into its GPA equivalent and returns as double
	 */
	private double digitizeGrade(String gr){
		double numericGrade = 0.0;
		String grade = gr.toUpperCase();
		if(grade.equals("A")){
			numericGrade = 4.0;
		}
		else if(grade.equals("A-")){
			numericGrade = 3.67;
		}
		else if(grade.equals("B+")){
			numericGrade = 3.33;
		}
		else if(grade.equals("B")){
			numericGrade = 3.0;
		}
		else if(grade.equals("B-")){
			numericGrade = 2.67;
		}
		else if(grade.equals("C+")){
			numericGrade = 2.33;
		}
		else if(grade.equals("C")){
			numericGrade = 2.0;
		}
		else if(grade.equals("C-")){
			numericGrade = 1.67;
		}
		else if(grade.equals("D+")){
			numericGrade = 1.33;
		}
		else if(grade.equals("D")){
			numericGrade = 1.0;
		}
		else if(grade.equals("D-")){
			numericGrade = 0.67;
		}
		else if(grade.equals("F")){
			numericGrade = 0.0;
		}
		return numericGrade;
	}
	
	/*
	 * updateGrade - multiplies current class' grade by its credit hours
	 * to get its grade points, then we add those to the total and divide
	 * by the credit hours taken to find GPA
	 */
	private void updateGrade(double grade, double cred){
		double localGradePoints = grade * cred;
		this.credHours += cred;
		this.gradePoints += localGradePoints;
		this.GPA = this.gradePoints / this.credHours;
	}

}
