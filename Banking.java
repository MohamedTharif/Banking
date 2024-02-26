import BankingSystem.newAccount;
import BankingSystem.existingAccount;
import BankingSystem.checkExisting;

import java.util.Scanner;

public class Banking{

  
 public static void main(String args[]) throws Exception
 {
   Scanner sc=new Scanner(System.in);
 
  // newAccount ac=new newAccount();
  newAccount nA=new newAccount();
  existingAccount eA=new  existingAccount();
  checkExisting cE=new checkExisting();
  
  int choice;

   System.out.println("WELCOME TO OUR BANK ");
   System.out.println("***********************************");

   
do {
	System.out.println("\n1.CREATE NEW ACCOUNT\n2.BALANCE\n3.Deposit\n4.Withdraw\n5.Exit");
    System.out.println("Enter Option");
    choice= sc.nextInt();
    switch(choice)
    {
		case 1:
			nA.getDetails();
			nA.show();
			break;
			
		case 2:
			eA.getDetails();
			eA.showBalance();
			break;
			
		case 3:
			eA.getDetails();
			eA.deposit();
			break;
			
		case 4:
			eA.getDetails();
			eA.withdraw();
			break;
     
		case 5:
			System.out.println("Thank You....!");
			break;
      }
   }while(choice!=5);



   
  }

}