 package BankingSystem;

import java.util.Scanner;
import java.util.regex.*;
import BankingSystem.checkExisting;
import BankingSystem.writeAccount;

public class existingAccount  {

   private double balance;
   private String csvFilePath ;
   private String columnName ;
   private boolean Value;
   private long accNo;


   static String accNoPattern="^[0-9]{9}$";
  
 //Creating Objects for checkExisting and writeAccount classes
  checkExisting cE =new checkExisting();
  writeAccount wA = new writeAccount();

   public void setBalance(){ this.balance=cE.returnbalance(); }
   public void setCsvFilePath(){this.csvFilePath= "C:/Banking/BankingData.csv";}
   public void setColumnName(){this.columnName="accNo";}
   public void setAccNo(String accNo) {this.accNo = Long.parseLong(accNo);}
   


   Scanner sc =new Scanner(System.in);

 public void getDetails(String accNoStr) throws Exception
 {
   
try {
   
 //Checking the Entered Account Number is Valid
  if(!accNoStr.matches(accNoPattern))
   {

   System.out.println("Incorrect Account Number,Enter Again the Account Number :");
   accNoStr=sc.nextLine();

   }
  //creating account Number
   setAccNo(accNoStr);
   
   System.out.println("Entered Account Number is :"+ accNo);

   //Setting the csvFilePath and columnName as accNo
   setCsvFilePath();
   setColumnName();
   
   //It returns true if Account Exist in the Database
   Value=cE.checkAccountExist(csvFilePath,accNo);
   
   }catch(Exception e) {
	   e.printStackTrace();   }
    

  }

public void deposit() throws Exception

  {  
	if(!Value) {
		System.out.println();
		}
	else {
		//getting the balance from the Database
	  setBalance();
  
      System.out.println("Enter amount to Deposit");
      
      balance = balance + sc.nextDouble();
      
      wA.updateData(accNo,balance);
	}
           
  }
 public void withdraw() throws Exception
 { 
	 if(!Value) {
		 System.out.println();
	 }
	 
	 else 
   {	 
	 //getting the balance from the Database
      setBalance();
   
      System.out.println("Enter Amount to Withdraw");
      double newBalance = sc.nextDouble();
   
     // Minimum of 500 can be Withdrawn 
   
       if(balance>newBalance && balance>=500 )
       {
    
         balance =balance - newBalance; 
   
        //Updating the Balance in Database
         wA.updateData(accNo,balance);
    
        } else
         {
           System.out.println("Insufficient Amount");
         } 
	}
}
	 
	 

 public void showBalance()
 {
	//getting the balance from the Database
    setBalance();
	
    if(!Value)
    {

    System.out.println();

      }
     else{  
          System.out.println("Balance is " +balance);
       }

  }



}