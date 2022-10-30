import java.io.IOException;

public class AddCustomer extends TheZoneSystem {
	
	TheZoneSystem addCustomer = new TheZoneSystem();
	
	
	public static void add() {
		
		//declare the variables
		String id = "";
		String name = "";
		int quantity = 0;
		String type = "";
		String tmpShpMethod = "";
		int shpMethod = 0;
		boolean typeChecked = false;
		boolean idChecked = false;
		boolean nameChecked = false;
		boolean shpMethodChecked = false;
		boolean qtyChecked = false;
		
		//check the regular and premium radio button is selected and empty or not
		if(regularRB.isSelected() == false & premiumRB.isSelected() == false) {
			unSltType.setText("Please select your type!");
			
		}else if(regularRB.isSelected()) {
			unSltType.setText("");
			type = "Regular";
			typeChecked = true;
			
		}else if(premiumRB.isSelected()) {
			unSltType.setText("");
			type = "Premium";
			typeChecked = true;
			
		}
		
		//check textField for input id is equals 5 character and empty or not
		if(txtID.getText().length() == 5) {
			id = txtID.getText();
			idChecked = true;
			
		}else if(txtID.getText().isEmpty()) {
			lbError.setText("                        Invalid Input ID!\nCannot empty, more than or less than 5 charater");
			messageStage.show();
			
		}else if(txtID.getLength() < 5 || txtID.getLength() > 5) {
			lbError.setText("                        Invalid Input ID!\nCannot empty, more than or less than 5 charater");
			messageStage.show();
			
		}
		
		//check the input of name is empty or not
		if(txtName.getText().isEmpty()) {
			lbError.setText("         Invalid Input Name! Cannot empty");
			messageStage.show();
			
		}else {
			name = txtName.getText();
			nameChecked = true;
			
		}
		
		//check truck, rail, ship and customer self arranger radio button is selected or not
		if(truckRB.isSelected() == false & 
				railRB.isSelected() == false &
				shipRB.isSelected() == false &
				selfArrangeRB.isSelected() == false) {
			unSltMethod.setText("Please select your method!");
			
		}else if(truckRB.isSelected()) {
			 unSltMethod.setText("");
			 shpMethod = 1;
			 tmpShpMethod = "Truck";
			 shpMethodChecked = true;
			
		}else if(railRB.isSelected()) {
			unSltMethod.setText("");
			shpMethod = 2;
			tmpShpMethod = "Rail";
			shpMethodChecked = true;
			
		}else if(shipRB.isSelected()) {
			unSltMethod.setText("");
			shpMethod = 3;
			tmpShpMethod = "Ship";
			shpMethodChecked = true;
			
		}else {
			unSltMethod.setText("");
			shpMethod = 4;
			tmpShpMethod = "Self arrange";
			shpMethodChecked = true;
			
		}
		
		//check the input of quantity is integer and empty or not
		if(txtQuantity.getText().isEmpty()) {
			lbError.setText("       Invalid Input Quantity!\nCannot empty or double value!");
			messageStage.show();
			
		}else {
			try {
				quantity = Integer.parseInt(txtQuantity.getText());
				qtyChecked = true;
				
			}catch(NumberFormatException ex) {
				lbError.setText("       Invalid Input Quantity!\nCannot empty or double value!");
				messageStage.show();
				
			}
			
		}
		
		//execute the add function
		if(typeChecked == true &
				idChecked == true &
				nameChecked == true &
				shpMethodChecked == true &
				qtyChecked == true) {
			
			if(type.equals("Regular")) {
				
				if(!arrayList.customerDetail.exists()) {
					Customer person= new RegularCustomer(type, id, name, shpMethod, quantity);
					arrayList.add(person);
					
					//write the detail into file
					arrayList.writeInFile();
					
					//set output in text area
					txtPrint.setText(arrayList.addMsg);
					
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
					
					
					
				}else {
					try {
						arrayList.Search(type, id, name, tmpShpMethod, quantity);
						
					} catch (IOException e) {
						e.printStackTrace();
						
					}
					
					if(arrayList.searchBool == true) {
						txtPrint.setText("User exists!!" + "\n"
											+ "Please change your ID or name and create again!");
						
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
						
					}else {
						Customer person= new RegularCustomer(type, id, name, shpMethod, quantity);
						arrayList.add(person);
						
						//write the detail into file
						arrayList.writeInFile();
						
						//set output in text area
						txtPrint.setText(arrayList.addMsg);
						
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
					}
					
				}
				
				
				
			}else if(type.equals("Premium")) {
				
				if(!arrayList.customerDetail.exists()) {
					Customer person= new RegularCustomer(type, id, name, shpMethod, quantity);
					arrayList.add(person);
					
					//write the detail into file
					arrayList.writeInFile();
					
					//set output in text area
					txtPrint.setText(arrayList.addMsg);
					
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
					
				}else {
					try {
						arrayList.Search(type, id, name, tmpShpMethod, quantity);
						
					} catch (IOException e) {
						e.printStackTrace();
						
					}
					
					if(arrayList.searchBool == true) {
						txtPrint.setText("User exists!!" + "\n"
											+ "Please change your ID or name and create again!");
						
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
						
					}else {
						Customer person= new RegularCustomer(type, id, name, shpMethod, quantity);
						arrayList.add(person);
						
						//write the detail into file
						arrayList.writeInFile();
						
						//set output in text area
						txtPrint.setText(arrayList.addMsg);
						
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
					}
					
				}
			}
		}
	}
	
}
