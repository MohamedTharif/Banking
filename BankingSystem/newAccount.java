package BankingSystem;
import BankingSystem.writeAccount;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.regex.*;
  

 

public class newAccount
{ 
 private String firstName,lastName;
 private String name;
 private  String phoneNo;
 private int age;
 private String nomineeName;
 private long accNo;
 private String panNumber;
 private double balance;
 private String address;
 
 //constraints for age,phoneNo,PAN
 private static String noPattern="^[0-9]{10}$";
 private static String agePattern="^(?:[5-9]|[1-5][0-9]|6[0-4])$";
 private static String panPattern="(?i)^[A-Za-z]{5}[1-9]{2}[A-Za-z]{2}$" ;
 
 Random random =new Random();

  public void setaccNo()
 { 
 //setting limit for a account Number
   long upperBound = 1000000000;
   long lowerBound= 1; 
   this.accNo =random.nextLong(upperBound - lowerBound + 1) + lowerBound ;
   }
  public void setName() { this.name =firstName+" "+lastName ; }

  Scanner sc =new Scanner(System.in);

  writeAccount wA = new writeAccount();

 public void getName()
 {
    System.out.println("First Name");
    firstName=sc.nextLine();
 
    System.out.println("Last Name");
    lastName=sc.nextLine();

    //setting name by combining firstName and lastName
    setName();
  
 }

  //getting Input For Age
  public void getAge()
{
   String ageNo;

   do
  { 
   System.out.println("Enter the Age Between 5 to 64");
   ageNo=sc.nextLine();
 
  //if not matches Prompt user to enter correct details
   if (ageNo.matches(agePattern) ) {break;}
    else
    {
         System.out.println("Invalid Age. Please enter 5 to 64.");
     }
   } while(!ageNo.matches(agePattern));
      this.age=Integer.parseInt(ageNo);
}
 
// getting phoneNo and Ensure it was in Correct Format
 public void getPhoneNo()
{
  do{
  System.out.println("Enter Mobile 10 Digits of Mobile Number Only Without (+91)"); 
  this.phoneNo=sc.nextLine();
  if (!phoneNo.matches(noPattern)) 
   {
        System.out.println("Invalid Number. Please enter 10 digits only.");
    }
  }while(!phoneNo.matches(noPattern));
  
}
// getting PAN number and and it was Valid by Matching the Pattern(5 Letters 2 Numbers 2 Letters)
public void getPAN()
{
   do{
   System.out.println("Enter PanCard Number");
   panNumber=sc.nextLine();
   if(!panNumber.matches(panPattern))
   {
     System.out.println("Enter Valid Details of PAN NUMBER");
    }
   }while(!Pattern.matches(panPattern, panNumber)); 
}

//getting address from user
public void getAddress()
{
 System.out.println("*******Enter Address*******");
 System.out.print("Enter DoorNo :");
 String doorNo=sc.nextLine(); 
 
 System.out.print("Enter Street Name : ");
 String streetName=sc.nextLine();
 
 System.out.println("Enter Taluk Name");
 String taluk=sc.nextLine(); 

 System.out.print("Enter District Name : ");
 String district=sc.nextLine();
 
 System.out.print("Enter State Name : ");
 String State=sc.nextLine();
 
 System.out.print("Enter PinCode : ");
 String pinCode=sc.nextLine(); 
 
 this.address=String.join("/", doorNo,streetName,taluk,district,State,pinCode);
 
}
//prompting user to enter Nominee Name
public void getNomineeName() 
{
	System.out.println("*************Nominee Name*************");
	System.out.println("Enter First Name of Nominee Name");
	String f_name=sc.nextLine();
	
	System.out.println("Enter Last Name of Nominee Name");
	String l_name=sc.nextLine();
	 
//assigning the Nominee Name by combining first name and last Name
	this.nomineeName=String.join(" ", f_name,l_name);
}

//getting the balance from the CSV file
public void getBalance()
{
	
 System.out.println("Enter Intial Amount To Deposit");
 System.out.println("Minimum Of 500 can Be deposited");
 balance=sc.nextDouble();
 
 if(balance<500.00)
 { 
  System.out.println("this amount can not be accepted,please Enter above 500/-");
  balance=0.00d;
  balance=sc.nextDouble();
  }
 
}

  public void getDetails()
 {
	  
 getName();

 getAge();

 getPAN();

 getPhoneNo();  
 
 getAddress();
 
 getNomineeName();
 
//intilizing account no for account
 setaccNo();

 getBalance();
  
 } 

public void show()
 {
  
  System.out.println("************Account Created************");
  System.out.println("Welcome to Our Bank,Pleasure to Have you As Our Delightfull Customer");
  System.out.println("Account Details : ")
  System.out.println("Name : "+ name);
  System.out.println("Nominee Name : "+ nomineeName);
  System.out.println("Address is : "+address);
  System.out.println("Pan Number : " + panNumber);
  System.out.println("");
  System.out.println("Your Account Number Is :"+accNo);
  System.out.println("Balance is : "+balance);
  
  
  System.out.println();
  wA.writeData(accNo, name, age, panNumber, phoneNo, nomineeName,address,balance);
 }


}