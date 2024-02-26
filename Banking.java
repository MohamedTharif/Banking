import BankingSystem.newAccount;
import BankingSystem.existingAccount;
import BankingSystem.checkExisting;

import java.util.Scanner;

public class Banking{
	 
 public static void main(String args[]) throws Exception
 {
   Scanner sc=new Scanner(System.in);
 
  
   newAccount nA=new newAccount();
    existingAccount eA=new  existingAccount();
	//checkExisting cE=new checkExisting();	
  
  
  int choice;
  do {
   System.out.println("WELCOME TO OUR BANK ");
   System.out.println("***********************************");

    System.out.println("\n1.CREATE NEW ACCOUNT\n2.BALANCE\n3.Deposit\n4.Withdraw\n5.Exit");
    System.out.println("Enter Option");
    choice= Integer.parseInt(sc.nextLine());
    String accNo;
    switch(choice)
    {
		case 1:
			nA.getDetails();
			nA.show();
			break;
			
		case 2:
			System.out.println("Enter Account Number");
			accNo=sc.nextLine();
			eA.getDetails(accNo);
			eA.showBalance();
			break;
			
		case 3:
			System.out.println("Enter Account Number");
			accNo=sc.nextLine();
			eA.getDetails(accNo);
			eA.deposit();
			break;
			
		case 4:
			System.out.println("Enter Account Number");
			accNo=sc.nextLine();
			eA.getDetails(accNo);
			eA.withdraw();
			break;
     
		case 5:
			System.out.println("Thank You....!");
			break;
      }
   
   
  }while(choice!=5);
sc.close();


   
  }

}