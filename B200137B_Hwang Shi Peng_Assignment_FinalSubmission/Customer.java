public class Customer{
    /*private String CUSTOMERID="CustomerID",CUSTOMERNAME="CustomerName",SHIPPNGMETHOD="ShippingMethod", 
            CUSTOMERTIER="CustomerTier",SHIPPINGFEE="ShippingFee",QUANTITYPRICE="QuantityPrice:";  */  
    
    private String CustomerID;
    private String CustomerName;
    private String Tier;
    private int Quantity;
    private int shippingMethod;
    
    public Customer(String Tier,String CustomerID, String CustomerName,int shippingMethod, int Quantity) {
         
        this.Tier = Tier;
        this.CustomerID= CustomerID;
        this.CustomerName= CustomerName;
        this.shippingMethod = shippingMethod;
        this.Quantity= Quantity;
    
    }
    
    //getMethod
     public String getTier(){
     return Tier;
    }
    public String getCustomerID(){
       return CustomerID;
    }

    public String getCustomerName(){
       return CustomerName;
    }

    public int getQuantity(){
       return Quantity;
    }
    public int getShippingMethod(){
       return shippingMethod;
    }
    //set Method
    public void setTier(String theTier){
       Tier= theTier;
    }
    public void setCustomerID(String theCustomerID){
        CustomerID= theCustomerID;
    }
    public void setCustomerName(String theCustomerName){
       CustomerName = theCustomerName;
    }
    public void setQuantity(int theQuantity){
       Quantity = theQuantity;
    }
    public void setShippingMethod(int theShippingMethod){
         shippingMethod = theShippingMethod; 
    }    
   // compute Quantity price class
    public double computeQuantityPrice(){
        double quantity=getQuantity();
        double quantityPrice=0;
        if(quantity<48){
           quantityPrice=quantity*2.85;
        }
        else if(quantity<=107 & quantity>=48){
          quantityPrice= quantity*2.63;
        }
        else if(quantity<=215 & quantity>=108){
          quantityPrice= quantity*2.27;
        }
        else{
          quantityPrice= quantity*2.00;
        }  
        return quantityPrice;
    } 
    //Find the shipping Type class
    public String FindShippingType(){
      
        int ShippingMethod = getShippingMethod();
        String ShippingType = "UNKNOWN";
        if(ShippingMethod==1){
          
          ShippingType="Truck";
        }
        else if(ShippingMethod==2){
          ShippingType="Rail";
        }
        else if(ShippingMethod==3){
          ShippingType="Ship";
        }
        else if(ShippingMethod==4){
         ShippingType="Self arrange";
        }  
        return ShippingType;
    
    }
    
    public String getCustomerType() {
    	String customerType = "";
    	
    	if(getTier().equals("Regular")) {
    		customerType = "Regular";
    		
    	}else if(getTier().equals("Premium")) {
    		customerType = "Premium";
    		
    	}
    	
    	return customerType;
    }
    // Compute shipping fee class
    public double computeShippingFee(){
        int ShippingMethod = getShippingMethod();
        double quantity = getQuantity();
        double ShippingFee = 0;
        
         if(ShippingMethod==1){
           ShippingFee=quantity*0.20;
        }
        else if(ShippingMethod==2){
           ShippingFee= quantity*0.18;
        }
        else if(ShippingMethod==3){
          ShippingFee= quantity*0.12;
        }
        else{
          ShippingFee= quantity*0.00;
        }  
        return ShippingFee;
    }
   
    
    
      
     //toString()method
     /*public String toString(){
       return "CustomerID: "+ getCustomerID()+
               "\nCustomerName: "+getCustomerName()+
               "\nShippingMethod: "+FindShippingType()+
               "\nCustomerTier: "+getTier()+
               "\nShippingFee: "+String.format("%.2f",computeShippingFee())+
               "\nQuantityPrice: "+String.format("%.2f",computeQuantityPrice());
               
     }*/
     
     public String toString(){   
       return "CustomerID :"+ getCustomerID() + "\n"
    		   + "CustomerName :" + getCustomerName() + "\n"
    		   + "CustomerTier :" + getCustomerType() +"\n" 
    		   + "Quantity :" + getQuantity() + "\n"
    		   + "ShippingMethod :" + FindShippingType() + "\n"
    		   + "ShippingFee(RM) :" + String.format("%.2f",computeShippingFee()) + "\n"
    		   + "QuantityPrice(RM):" + String.format("%.2f",computeQuantityPrice()) +"\n";
     }     
    
} 