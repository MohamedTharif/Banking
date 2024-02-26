package BankingSystem;

import java.util.Scanner;
import java.util.Random;
  

 

public class newAccount
{ 
  private String firstName;
 private  String lastName;
 private String Name;
 private  String phoneNO;
 private int age;
  private String nomineeName;
  private long accNo;
 
   Random random =new Random()

  public void setaccNo(){ this.accNo =random.nextInt(15);}
  public void setName(){ this.name =firstName+" "+lastName ); }

 public void getDetails(){

  Scanner sc =new Scanner(System.in);
 
  System.out.println("First Name");
  this.firstName=sc.nextLine();
  sc.nextLine();
 
 System.out.println("Last Name");
 this.lastName=sc.nextLine();
 sc.nextLine();
 setName();

 System.out.println("Age");
 this.age=sc.nextInt();
 
 System.out.println("Phone No"); 
  this.phoneNO=sc.nextLine();
  sc.nextLine();
 
 System.out.println("Nominee Name");
 this.nomineeName=sc.nextLine();
 } 

}