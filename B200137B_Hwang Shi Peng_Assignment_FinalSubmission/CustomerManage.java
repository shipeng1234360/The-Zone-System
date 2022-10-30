import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CustomerManage {
     public ArrayList<Customer> entry;
     public ArrayList<String> temporary = new ArrayList<>();
     public String addMsg = "";
     public String searchMsg = "";
     public String removeMsg = "";
     public String printMsg = "";
     public String result = "";
     public boolean searchBool = false;
     static File customerDetail = new File("Customer Order.txt");
    		 
    public CustomerManage(){        
        entry = new ArrayList<Customer>();  
    }
    
    // add function to arraylist
    public void add(Customer newCustomer ) {             
        	boolean found = false;
                
    	for(int i =0; i<entry.size() && found == false; i++){
    		Customer p = entry.get(i);
    		if(p. getCustomerType().equalsIgnoreCase(newCustomer.getCustomerType()) &
    				p.getCustomerID().equals(newCustomer.getCustomerID()) &
    				p.getCustomerName().equals(newCustomer.getCustomerName()) &
    				p.FindShippingType().equals(newCustomer.FindShippingType()) &
    				p.getQuantity() == newCustomer.getQuantity()) {
    			found=true;
    				
    		}//end if
    	}//end for
    	
    	if(found ==true){
    		addMsg = "Record of person id " + newCustomer.getCustomerID() +  " already exists." + "\n";
    		
    	}else{ 
            entry.add(newCustomer);
            
            addMsg = "Add Successfuly, " + newCustomer.getCustomerID() + "\n";
    		
    	}
        
    }
    
      //search function in array list
      public void Search(String type, String id, String name, String shpMethod, int quantity) throws IOException{
    	  
    		  try {
    			  Path path = customerDetail.toPath();
    		 		 
    			  int linesPerCustomer = 10;
    		 		
    			  List<String> allLines = Files.readAllLines(path);
    		 		 
    			  List<CustomerFileManage> customers = new ArrayList<>();
    		 		 
    		 		
    			  for(int i= 0; i < allLines.size(); i += linesPerCustomer) {
    				  List<String> lines = allLines.subList(i, i + linesPerCustomer);
    		 			 
    				  customers.add(CustomerFileManage.parseLines(lines));
    		 			 
    			  }
    			  
    			  for (int x = 0; x < customers.size(); x++) {
    		             if(customers.get(x).getId().equals(id) &
    		                    customers.get(x).getName().equals(name) &
    		                    customers.get(x).getType().equals(type) &
    		                    customers.get(x).getQuantity() == quantity &
    		                    customers.get(x).getShpMethod().equals(shpMethod)) {
    		                 
    		                 
    		                 result = "CustomerID :" + customers.get(x).getId() + "\n"
    		             			  + "CustomerName :" + customers.get(x).getName() + "\n"
    		            			  + "CustomerTier :" + customers.get(x).getType()+ "\n"
    		            			  + "Quantity :" + customers.get(x).getQuantity() + "\n"
    		            			  + "ShippingMethod :" + customers.get(x).getShpMethod() + "\n"
    		            			  + "ShippingFee(RM) :" + String.format("%.2f",customers.get(x).getShpFee()) + "\n"
    		            			  + "Quantityprice(RM) :" + String.format("%.2f",customers.get(x).getQuantityPrice()) + "\n"
    		            			  + "DiscountShippingPrice(RM) :" + String.format("%.2f",customers.get(x).getShpFee()) + "\n"
    		            			  + "TotalPrice(RM) :" + String.format("%.2f",customers.get(x).getTotalPrice()) + "\n";
    		                 
    		                 searchMsg = "Searching ID which is " + id + " found!!" + "\n\n"
    		    				  		+ result;
    		                 searchBool = true;
    		                 
    		                 break;
    		             }else {
    		            	 searchMsg = "Searching ID which is " + id + " not found!!" + "\n"
    		    				  		+ "User not in our system!!" + "\n"
    		    				  		+ "Please check careful your input or add new user!";
    		            	 searchBool = false;
    		            	 
    		             }
    		         }
    			 
    		  }catch(FileNotFoundException e) {
    			  searchMsg = "System don't have any order!" + "\n"
    					  		+ "Please create the order first!";
    			  
    		  } // end try and catch	  
      }
      
      //remove function in array list
      public void remove(String type, String id, String name, String shpMethod, int quantity) throws IOException {
         
 		 Path path = customerDetail.toPath();
 		 
 		 int linesPerCustomer = 10;
 		
 		 List<String> allLines = Files.readAllLines(path);
 		 
 		 List<CustomerFileManage> customers = new ArrayList<>();
 		 
 		
 		 for(int i= 0; i < allLines.size(); i += linesPerCustomer) {
 			 List<String> lines = allLines.subList(i, i + linesPerCustomer);
 			 
 			 customers.add(CustomerFileManage.parseLines(lines));
 			 
 		 }
 		 
 		 customers.removeIf(CustomerFileManage -> CustomerFileManage.getId().equals(id) & 
 				 									CustomerFileManage.getName().equals(name) &
 				 									CustomerFileManage.getType().equals(type) &
 				 									CustomerFileManage.getQuantity() == quantity &
 				 									CustomerFileManage.getShpMethod().equals(shpMethod));
 		 
            removeMsg = "Remove of person id " + id + "\n\n"
            			+ "Remove Successfully" + "\n"
            			+ "You may use print or search button to check it.";
            
            List<String> linesAfterRemove = new ArrayList<>();
            
            for (CustomerFileManage p : customers) {
            	linesAfterRemove.addAll(p.toLines());
            	linesAfterRemove.add("");
                
            }
                  
            Files.write(path, linesAfterRemove);
            linesAfterRemove.clear();
            
      }

       
      public void writeInFile() {
    	  for(Customer p:entry){
 	    		try(PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(customerDetail, true)))) {
 	                
 	                write.println(p.toString());
 	                write.close();
 	                
 	            } catch (IOException ex) {
 	            }
 	     	   	
 	    	}
 			
 			entry.clear();
   	}
      
      
}