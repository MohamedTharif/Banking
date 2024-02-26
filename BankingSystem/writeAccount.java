package BankingSystem;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


public class writeAccount
{ 
  
  private String csvFilePath ="C:/Banking/BankingData.csv";
 
  public boolean readData()
  {
     boolean isExist = true;
     try (BufferedReader reader=new BufferedReader(new FileReader(csvFilePath)))
     {     
           // Read the header row to get column names
            String headerLine = reader.readLine();

           //if header was null then no column is present hence the column is set to be false
            if (headerLine == null) 
            { 
 	           isExist = false;
            }
      }catch(IOException e)
        {
	      System.out.println("An error Occured");
         }
      return isExist;
    }


     public void writeData(long accNo,String name,int age,String pan,String phoneNo,String nomineeName,double balance)
    {
      
       try (BufferedWriter writer=new BufferedWriter(new FileWriter(csvFilePath,true)))
       {  
         //check column exist or not 
           boolean exist=readData();
          //if not exist it will be false,then it will write header
           if(exist==false)
           {
            // Writing header
            writer.write("accNo, name, age,pan,phoneNo,nomineeName,balance\n");
           }

            // Writing data
            writer.newLine();
            
            writer.append(String.format("%s,%s,%d,%s,%s,%s,%f",accNo, name, age, pan, phoneNo, nomineeName,balance));

            System.out.println("Data has been Created.");
         } catch (IOException e) 
           {
            System.out.println("An error Occured.");
            e.printStackTrace();
            }
     }


  public void updateData(long targetAccNo,double Balance) throws Exception
  { 
	   
  System.out.println("Updating Balance for AccNo: " + targetAccNo + ", New Balance: " + Balance);

  try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
          BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath + ".tmp"))) {

      String line;
      while ((line = reader.readLine()) != null) {
          String[] parts = line.split(",");
          if (parts.length > 0 && parts[0].equals(String.valueOf(targetAccNo))) {
              // Assuming balance is in the last column
              parts[parts.length - 1] = Double.toString(Balance);
          }
          writer.write(String.join(",", parts) + System.lineSeparator());
      }

  } catch (IOException e) {
      e.printStackTrace();
  }

  // Rename the temporary file to replace the original
  try {
      java.nio.file.Files.move(
              java.nio.file.Paths.get(csvFilePath + ".tmp"),
              java.nio.file.Paths.get(csvFilePath),
              java.nio.file.StandardCopyOption.REPLACE_EXISTING
      );
      System.out.println("Amount Has Been Deposited.");
      System.out.println("Updated Balance for Account Number: " + targetAccNo + ", New Balance: " + Balance);
  } catch (IOException e) {
      System.out.println("An error occured While Depositing,Please Proceed Again....!");
	  e.printStackTrace();
  }
  }
 

}
     





