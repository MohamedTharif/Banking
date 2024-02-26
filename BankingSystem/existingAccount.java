package BankingSystem;

import java.util.Scanner;
import java.util.regex.*;
import BankingSystem.checkExisting;
import BankingSystem.writeAccount;

public class existingAccount {

   private double balance;
   private String csvFilePath ;
   private String columnName ;
   private int index;
   private boolean Value;
  private long accNo;

   static String accNoPattern="^[0-9]{9}$";
  

  checkExisting cE =new checkExisting();
  writeAccount wA = new writeAccount();

   public void setBalance(){ balance=cE.returnbalance(); }
   public void setCsvFilePath(){csvFilePath= "C:/Banking/BankingData.csv";}
   public void setColumnName(){columnName="accNo";}


   Scanner sc =new Scanner(System.in);

 public void getDetails()
 {
   
    System.out.println("Enter ACCOUNT NUMBER");
    String accNoStr=sc.nextLine();

  /* if(!accNoStr.matches(accNoPattern))
   {

   System.out.println("Incorrect Account Number,Enter Again the Account Number :");
   accNoStr=sc.nextLine();

   }*/
       
   this.accNo = Long.parseLong(accNoStr);
   System.out.println("Entered Account Number is :"+ accNo);

   setCsvFilePath();
   setColumnName();
   Value=cE.checkAccountExist(csvFilePath,accNo);
  
    

  }

public void deposit() throws Exception

  {  
	if(!Value) {System.out.println("Bot Found");}
	else {
	setBalance();
  
      System.out.println("Enter amount to Deposit");
      
      balance = balance + sc.nextDouble();
      
      wA.updateData(accNo,balance);
	}
           
  }
 public void withdraw() throws Exception
 { 
	 if(!Value) {System.out.println("Bot Found");}
	 
	 else {	 
	 
   setBalance();
   
   if(balance>500.00 )
   {
    System.out.println("Enter Amount to Withdraw");
  
    balance =balance - sc.nextDouble();
   
    wA.updateData(accNo,balance);
    
    } else
   {
     System.out.println("Insufficient Amount");
   } 
	}
}
	 
	 

 public void showBalance()
 {
    setBalance();
	
    if(!Value){

    System.out.println();

      }
     else{  
          System.out.println("Balance is " +balance);
       }

  }



}