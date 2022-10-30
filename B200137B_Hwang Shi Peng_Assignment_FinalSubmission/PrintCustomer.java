import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintCustomer extends TheZoneSystem {
	
	public static void print() {
		//clear all input and radio button
		regularRB.setSelected(false);
		premiumRB.setSelected(false);
		txtID.clear();
		txtName.clear();
		truckRB.setSelected(false);
		railRB.setSelected(false);
		shipRB.setSelected(false);
		selfArrangeRB.setSelected(false);
		txtQuantity.clear();
		txtPrint.clear();
		
		
		//check whether the database file is exists or not
		if(arrayList.customerDetail.exists() & arrayList.customerDetail.length() == 0) {
			
			
			txtPrint.setText("There are nothing inside customer database file.");
			
		}else {
			
			
			// read the detail form file to print it out
			try {
				Scanner reader = new Scanner(arrayList.customerDetail);
				
				while(reader.hasNextLine()) {
					String details = reader.nextLine() + "\n";
					
					txtPrint.appendText(details);
				}
				
				reader.close();
				
			}catch(FileNotFoundException e) {
				txtPrint.setText("System don't have any order!" + "\n"
				  					+ "Please create the order first!");
			}
			
		}
	}
}
