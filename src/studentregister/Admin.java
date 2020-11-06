package studentregister;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.bson.Document;

import com.google.gson.Gson;

class Admin {

	HashMap<String, Student> studentRegister = new HashMap<String, Student>();
	Scanner input = new Scanner(System.in);
	Gson gson = new Gson();
	DBManager dbManager = new DBManager();

	
	public void add(String ID, String Name, int CRN_SEM, int SHIFT, float S1_GPA, float S2_GPA, float S3_GPA, 
			float S4_GPA, float S5_GPA, float S6_GPA, float S7_GPA, float S8_GPA,String NAME_OF_EVENT, String ACCOMPLISHMENT, String STU_PW) {
		Student tempStudent = new Student(Name,ID,CRN_SEM,SHIFT,S1_GPA,S2_GPA,S3_GPA,S4_GPA,S5_GPA,S6_GPA, S7_GPA,S8_GPA,NAME_OF_EVENT,ACCOMPLISHMENT,STU_PW);
		studentRegister.put(ID, tempStudent);
	}

	public void edit(String ID) {
		Student tempStudent = studentRegister.get(ID);
		if (tempStudent == null) {
			System.out.println("ID not present");
		} else {
			System.out.println(tempStudent.toString());
			int choice = -1;
			do {
				System.out.println("What do you want to edit?\n 1. Name \n 2. Current Semester \n 3.Shift \n 4.SGPA \n 5.Name of Event \n 6.Accomplishment \n 0.Exit \n");
				choice = input.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the Student's First Name");
					String fname = input.next();
					System.out.println("Enter the Student's Last Name");
					String lname = input.next();
					String newName  = fname + " " + lname;
					tempStudent.setStudentName(newName);
					studentRegister.put(ID, tempStudent);
					break;
				case 2:
					System.out.println("Enter the Student's Current Semester");
					int curr_sem=input.nextInt();
					tempStudent.setCurrSem(curr_sem);
					studentRegister.put(ID, tempStudent);
					break;
				case 3:
					System.out.println("Enter the Shift");
					int shift=input.nextInt();
					tempStudent.setShift(shift);
					studentRegister.put(ID, tempStudent);
					break;
				case 4:
					System.out.println("Enter the Semester");
					int sem=input.nextInt();
					if(sem >= tempStudent.getCurrSem() || sem <= 0)
						System.out.println("INVALID SEMESTER !!");
					else {
						System.out.println("Enter the SGPA");
						int sgpa=input.nextInt();
						tempStudent.setSGPA(sem, sgpa);
					}
					studentRegister.put(ID, tempStudent);
					break;
				case 5:
					System.out.println("Enter the Name of Event");
					String name_event=input.next();
					tempStudent.setNameOfEvent(name_event);
					studentRegister.put(ID, tempStudent);
					break;
				case 6:
					System.out.println("Enter the Accomplishment");
					String accomp = input.nextLine();
					tempStudent.setAccomplishment(accomp);
					studentRegister.put(ID, tempStudent);
					break;
				default:
					System.out.println("Wrong Input");
					break;
				}
			}while(choice!=0);
		}
	}

	public void delete(String ID) {
		Student tempStudent = studentRegister.remove(ID);
		if (tempStudent == null) {
			System.out.println("ID not present, Student not Found");
		} else {
			System.out.println(tempStudent.toString() + "\ndeleted");
		}
	}

	public void save() throws IOException {

			ArrayList<Document> documents = new ArrayList<Document>();
			for (Student student : studentRegister.values()) {
				documents.add(Document.parse(gson.toJson(student)));
			}
			dbManager.saveHashMap(documents);
	}

	public void load() throws IOException, ClassNotFoundException {

		ArrayList<Student> students = dbManager.loadHashMap();
		if (students != null) {
			studentRegister = new HashMap<String, Student>();
			for (Student student : students) {
				studentRegister.put(student.getStudentId(), student);
			}
		}

	}

	public boolean matchPassword(String ID, String password)
	{
		Student tempStudent = studentRegister.get(ID);
		if (tempStudent == null) {
			System.out.println("ID not present, Student not Found");
		}
		if(tempStudent.getPassWord().equals(password))
		{
			return true;
		}
		return false;
	}
	
	public void resetPassword(String ID, String password)
	{
		Student tempStudent = studentRegister.get(ID);
		if (tempStudent == null) {
			System.out.println("ID not present, Student not Found");
		}
		else
			tempStudent.setPassWord(password);
	}
	
	public void view(String ID) {
		if (studentRegister.isEmpty()) {
			System.out.println("No values inserted");
		} 
		else {
				Student tempStudent = studentRegister.get(ID);
				if (tempStudent == null) {
					System.out.println("ID not present, Student not Found");
				}
				else {
					System.out.println("------------ Student Details ------------");
					System.out.println(" Student ID        : " + tempStudent.getStudentId());
					System.out.println(" Student Name 	   : " + tempStudent.getStudentName());
					System.out.println(" Current Semester  : " + tempStudent.getCurrSem());
					System.out.println(" Shift             : " + tempStudent.getShift());
					for(int i=1;i<tempStudent.getCurrSem();i++) {
						System.out.println(" Sem "+i+" GPA 	   : " + tempStudent.getSGPA(i));
					}
					System.out.println(" Name of Event 	   : " + tempStudent.getNameOfEvent());
					System.out.println(" Accomplishment    : " + tempStudent.getAccomplishment());
					System.out.println("------------------------------------------");
				}
		}
	}
}