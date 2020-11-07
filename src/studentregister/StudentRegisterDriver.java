package studentregister;

import java.io.IOException;

import java.util.Scanner;


public class StudentRegisterDriver {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();
		int opt0 = -1;
		int opt2 =-1;
		int opt3 = -1;
		while(opt0 != 0)
		{
			System.out.println("\nWelcome to Students Achievements DataBase\n 1. Admin \n 2. Student \n 0. Exit\n");
			opt0 = input.nextInt();
			switch(opt0) {
				
						case 0 :
							input.close();
							System.out.println("©2020 | Creators :  Rishikesh Kale | Yash Roy | Rohit Chandani");
							System.exit(0);
							break;
							
						case 1 :
							System.out.println("\nWelcome to Admin Section!!");
							opt2 =-1;
							while (opt2 != 0) {
								
								System.out.println("\n    >>> Loading database ... \n");
								try {
									admin.load();
								} 
								catch (ClassNotFoundException e) 
								{
									e.printStackTrace();
								} 
								catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("\n-----------------------------------------");
								System.out.println("\nChoose the option :\n 1. Add \n 2. Edit \n 3. Delete \n 4. View \n 0. Logout\n");
								System.out.println("\n-----------------------------------------");
								opt2 = input.nextInt();
								switch (opt2) {
									case 1:
										System.out.println("Enter the Student's First Name");
										String fname = input.next();
										System.out.println("Enter the Student's Last Name");
										String lname = input.next();
										String name  = fname + " " + lname;
										System.out.println("Enter the Student's ID");
										String iDInteger = input.next();
										
										System.out.println("Enter the Student's Current Semester");
										int curr_sem = input.nextInt();
										
										System.out.println("Enter the Shift");
										int shift = input.nextInt();
										
										float sgpa_arr[] = new float[8];
										for(int i = 0; i < curr_sem - 1;i++)
										{
											System.out.println("Enter Semester " + (i+1) + " SGPA");
											sgpa_arr[i] = input.nextFloat();
										}
										
										if(curr_sem != 8)
										{
											for(int j = curr_sem ; j < 8; j++)
											{
												sgpa_arr[j] = 0;
											}
										}
										
			
										System.out.println("Enter the Name of Event");
										String name_event=input.next();
										
										System.out.println("Enter the Accomplishment");
										String accomp = input.next();
										
										//Add details here
										admin.add(iDInteger, name, curr_sem, shift, sgpa_arr[0],sgpa_arr[1], sgpa_arr[2],sgpa_arr[3],sgpa_arr[4],sgpa_arr[5],
												sgpa_arr[6], sgpa_arr[7], name_event , accomp , "0000" ); //default password : 0000
										System.out.println("\n ======= Adding and Saving to database =======");
										try {
											admin.save();
										} catch (Exception e) {
											e.printStackTrace();
										}
										break;
									case 2:
										System.out.println("Enter the Student's ID");
										String editIDInteger = input.next();
										admin.edit(editIDInteger);
										System.out.println("\n ======= Saved changes to database =======");
										try {
											admin.save();
										} catch (Exception e) {
											e.printStackTrace();
										}
										break;
									case 3:
										System.out.println("Enter the Student's ID");
										String deleteIDInteger = input.next();
										admin.delete(deleteIDInteger);
										System.out.println("\n ======= Saved changes to database =======");
										try {
											admin.save();
										} catch (Exception e) {
											e.printStackTrace();
										}
										break;
									case 4:						
										System.out.println("Enter the Student's ID");
										String viewIDInteger = input.next();
										admin.view(viewIDInteger);
										break;
									
									case 0:
										System.out.println("Logging out from admin ...");
										break;
									default:
										System.out.println("Wrong input");
										break;
								}
							}
										break;
							
							case 2 :
										System.out.println("\nWelcome to Student Section");
									
										opt3 = -1;
										while(opt3 != 3)
											{
											System.out.println("\n    >>> Loading database ... ");
											try {
												admin.load();
											} 
											catch (ClassNotFoundException e) 
											{
												e.printStackTrace();
											} 
											catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}	
											System.out.println("\n-----------------------------------------");
											System.out.println("\nChoose the option :\n 1. Login \n 2. Create new account or Change your password \n 3. Logout");
											System.out.println("\n-----------------------------------------");	
											opt3 = input.nextInt();
												switch (opt3) {
												case 1:

													
														System.out.println("Enter the your ID");
														String logIDInteger = input.next();
														if(admin.IDexist(logIDInteger))
														{	
															System.out.println("Enter password");
															String password = input.next();
																
																if(admin.matchPassword(logIDInteger, password))
																	admin.view(logIDInteger);
																else
																{
																	System.out.println("Incorrect Password !!");
																}
														}
												
													break;
													
												
												case 2:
														System.out.println("Enter the your ID");
														String newIDInteger = input.next();
														if(admin.IDexist(newIDInteger))
														{	
															System.out.println("Set your password");
															String newPassword = input.next();
															admin.resetPassword(newIDInteger, newPassword);
															System.out.println("\n------------------------------------------------");
															System.out.println("Passsword reset successfully !! Kindly login to view your credentials.");
															System.out.println("------------------------------------------------");
															try {
																admin.save();
															} catch (Exception e) {
																e.printStackTrace();
															}
														}
													break;
													
												case 3:
													System.out.println(" ======= Logging out =======");
													break;
											
												}
											}
										break;
						
							
			
			}
		}
		
		

	}

}
