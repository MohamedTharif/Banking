package BankingSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class checkExisting
{
 private String name;
 private int age;
 private boolean found;
 private String phoneNo;
 private String nomineeName;
 private String pan;
 private double balance;
 private String address;

 
   
  
  public boolean checkAccountExist( String csvFilePath,long accNo)
 {
   
     try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) 
  {
           String line;
           String targetAccNo=Long.toString(accNo);

           //found is returned true if account has existed else false
            found = false;

            while ((line = reader.readLine()) != null) 
         {
               // Split the line by comma to get individual values
                String[] columns = line.split(",");

                if (columns.length > 0 && columns[0].equals(targetAccNo))
               {
                    // If accNo matches, extract name and age
                    if (columns.length > -1) 
	                 {
                                      name = columns[1];
                                      String ageNo = columns[2];
	                    age = Integer.parseInt(ageNo);
	                    pan=columns[3];
	                    phoneNo=columns[4];
	                    nomineeName=columns[5];
	                    address=columns[6];
                                      balance=Double.parseDouble(columns[7]);

                                     System.out.println("Name: " + name );
                                     found = true;
                                     break; // No need to continue searching if found
                                 }
                }
            }
            if (!found) 
            {
                System.out.println("Account Number " + targetAccNo + " not found .");
             }
        } catch (IOException e) { e.printStackTrace(); }
        
       return found;
 }

 public String retunrName()
 {
	 return  name; 
 }

//used to return balance from the file
    public double returnbalance() 
    {  
	 return balance; 
     }




}






