import BankingSystem.newAccount;
import BankingSystem.existingAccount;
import BankingSystem.checkExisting;

import java.util.Scanner;

public class Banking{
	 
 public static void main(String args[]) throws Exception
 {
   Scanner sc=new Scanner(System.in);
 
  //creating objects of NewAccount class and existingAccount Class
   newAccount nA=new newAccount();
   existingAccount eA=new  existingAccount();
	 
   int choice;

  do {
  //Menu
   System.out.println("WELCOME TO OUR BANK ");
   System.out.println("***********************************");

    System.out.println("\n1.CREATE NEW ACCOUNT\n2.BALANCE\n3.DEPOSIT\n4.WITHDRAW\n5.EXIT");
    System.out.println("ENTER YOUR CHOICE");
    choice= Integer.parseInt(sc.nextLine());
    String accNo;
    switch(choice)
    {
		case 1:
			nA.getDetails();
			nA.show();
			break;
			
		case 2:
			System.out.println("ENTER ACCOUNT NUMBER");
			accNo=sc.nextLine();
			eA.getDetails(accNo);
			eA.showBalance();
			break;
			
		case 3:
			System.out.println("ENTER ACCOUNT NUMBER");
			accNo=sc.nextLine();
			eA.getDetails(accNo);
			eA.deposit();
			break;
			
		case 4:
			System.out.println("ENTER ACCOUNT NUMBER");
			accNo=sc.nextLine();
			eA.getDetails(accNo);
			eA.withdraw();
			break;
     
		case 5:
			System.out.println("THANK YOU FOR YOUR VISIT....!");
			break;
      }
   
   
  }while(choice!=5);
sc.close();


   
  }

}