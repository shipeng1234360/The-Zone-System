import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerFileManage {
	private final String id;
	private final String name;
	private final String type;
	private final int quantity;
	private final String shpMethod;
	private final double shpFee;
	private final double quantityPrice;
	private final double disShpPrice;
	private final double totalPrice;
	
	
	public CustomerFileManage(String id, String name, String type, int quantity, String shpMethod, double shpFee, 
								double quantityPrice, double disShpprice, double totalPrice) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.shpMethod = shpMethod;
		this.shpFee = shpFee;
		this.quantityPrice = quantityPrice;
		this.disShpPrice = disShpprice;
		this.totalPrice = totalPrice;
		
	}
	
	public String getId() {
		return this.id;
		
	}
	
	public String getName() {
		return this.name;
		
	}
	
	public String getType() {
		return this.type;
		
	}
	
	public int getQuantity() {
		return this.quantity;
		
	}
	
	public String getShpMethod() {
		return this.shpMethod;
		
	}
	
	public double getShpFee() {
		return this.shpFee;
		
	}
	
	public double getQuantityPrice() {
		return this.quantityPrice;
	}
	
	public double getDisShpPrice() {
		return this.disShpPrice;
		
	}
	
	public double getTotalPrice() {
		return this.totalPrice;
		
	}		
	
	public static CustomerFileManage parseLines(List<String> lines) {
  	  String id = lines.get(0).split(":")[1];
  	  String name = lines.get(1).split(":")[1];
  	  String type = lines.get(2).split(":")[1];
  	  int quantity = Integer.parseInt(lines.get(3).split(":")[1]);
  	  String shpMethod = lines.get(4).split(":")[1];
  	  double shpFee = Double.parseDouble(lines.get(5).split(":")[1]);
  	  double quantityPrice = Double.parseDouble(lines.get(6).split(":")[1]);
  	  double disShpPrice = Double.parseDouble(lines.get(7).split(":")[1]);
  	  double totalPrice = Double.parseDouble(lines.get(8).split(":")[1]);
  	  
  	  
  	  return new CustomerFileManage(id, name, type, quantity, shpMethod, shpFee, quantityPrice, disShpPrice, totalPrice);
  	  
    }
	
	
	public List<String> toLines() {
		
		return Arrays.asList(
			"CustomerID :" + id,
			"CustomerName :" + name,
			"CustomerTier :" + type,
			"Quantity :" + quantity,
			"ShippingMethod :" + shpMethod,
			"ShippingFee(RM) :" + String.format("%.2f",shpFee),
			"Quantityprice(RM) :" + String.format("%.2f",quantityPrice),
			"DiscountShippingPrice(RM) :" + String.format("%.2f",disShpPrice),
			"TotalPrice(RM) :" + String.format("%.2f",totalPrice)
		);
	}
	
}
