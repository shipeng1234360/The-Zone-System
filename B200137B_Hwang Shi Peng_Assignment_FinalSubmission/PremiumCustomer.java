public class PremiumCustomer extends Customer {
    public PremiumCustomer(String Tier, String CustomerID, String CustomerName, int shippingMethod, int Quantity) {
        super(Tier, CustomerID, CustomerName, shippingMethod, Quantity);
        super.setTier(Tier);
        super.setCustomerID(CustomerID);
        super.setCustomerName(CustomerName);
        super.setShippingMethod(shippingMethod);
        super.setQuantity(Quantity);
    }
    public double computeTotalShippingDiscount(){
         double TotalPrice=computeQuantityPrice();
         double TotalShippingDiscount;
         double TotalShippingFee= computeShippingFee();

         if(TotalPrice<400){
              TotalShippingDiscount = 0;
         } 
         else if(TotalPrice<1200){
              TotalShippingDiscount= TotalShippingFee*10/100; 
         }
         else{
             TotalShippingDiscount= TotalShippingFee*20/100;
         }
         return TotalShippingDiscount;    
     }
    
    //Compute Total Price
    public double ComputeGrandTotal(){
        double GrandTotal = computeQuantityPrice()+computeShippingFee()-computeTotalShippingDiscount();
        return GrandTotal;
     }
    @Override
    public String toString(){
        return super.toString()
        	   + "DiscountShippingPrice(RM) :" + String.format("%.2f",computeTotalShippingDiscount()) +"\n"
        	   + "TotalPrice(RM) :" + String.format("%.2f",ComputeGrandTotal())+ "\n";
    } 
}