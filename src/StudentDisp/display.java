package StudentDisp;
import java.util.List;
import java.util.Scanner;

import controller.ListStudentHelper;
import model.ListStudent;


public class display {

	static Scanner in = new Scanner(System.in);
	static ListStudentHelper lsh = new ListStudentHelper();

	private static void addStudentName() {
		System.out.print("Enter a college name: ");
		String college = in.nextLine();
		System.out.print("Enter student name: ");
		String studentName = in.nextLine();
		ListStudent toAdd = new ListStudent(college, studentName);
		lsh.insertStudentName(toAdd);

	}

	private static void deleteStudentName() {
		System.out.print("Enter the college to delete: ");
		String college = in.nextLine();
		System.out.print("Enter the studentName to delete: ");
		String studentName = in.nextLine();
		ListStudent toDelete = new ListStudent(college, studentName);
		lsh.deleteStudent(toDelete);

	}

	private static void editStudentName() { 
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by college");
		System.out.println("2 : Search by studentName");
		int searchBy = in.nextInt();
		in.nextLine();

		List<ListStudent> foundStudentNames;
		if (searchBy == 1) {
			System.out.print("Enter the college name: ");
			String collegeName = in.nextLine();
			foundStudentNames = lsh.searchForstudentNameByCollege(collegeName);
		} else {
			System.out.print("Enter the studentName: ");
			String studentName = in.nextLine();
			foundStudentNames = lsh.searchForstudentNameByStudentName(studentName);
		}

		if (!foundStudentNames.isEmpty()) {
			System.out.println("Found Results.");
			for (ListStudent l : foundStudentNames) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ListStudent toEdit = lsh.searchForStudentNameById(idToEdit);
			System.out.println("Retrieved " + toEdit.getStudentName() + " from " + toEdit.getCollege());
			System.out.println("1 : Update college");
			System.out.println("2 : Update studentName");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New college: ");
				String newCollege = in.nextLine();
				toEdit.setCollege(newCollege);
			} else if (update == 2) {
				System.out.print("New studentName: ");
				String newStudent = in.nextLine();
				toEdit.setStudentName(newStudent);
			}

			lsh.updateStudentName(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		runDisplayStudent();
	}

	public static void runDisplayStudent() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our College - Student List! ---");
		while (goAgain) {
			System.out.println("*  Select an option given below:");
			System.out.println("*  1 -- Add a CollegeName and StudentName");
			System.out.println("*  2 -- Edit either a CollegeName or StudentName");
			System.out.println("*  3 -- Delete a CollegeName and StudentName");
			System.out.println("*  4 -- View the list of Colleges and StudentNames");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addStudentName();
			} else if (selection == 2) {
				editStudentName();
			} else if (selection == 3) {
				deleteStudentName();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lsh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<ListStudent> allstudentNames = lsh.showAllstudentNames();
		for(ListStudent singlestudentName: allstudentNames) {
			System.out.println(singlestudentName.returnstudentNameDetails());
		}
		System.out.println("\n");
	}
}
