import java.io.IOException;

public class DeleteCustomer extends TheZoneSystem {
	
	public static void delete() {
		//declare variables
		String id = "";
		String name = "";
		int quantity = 0;
		String type = "";
		String shpMethod = "";
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
		
		//check the input of id is equals 5 characters and empty or not
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
			 shpMethod = "Truck";
			 shpMethodChecked = true;
			
		}else if(railRB.isSelected()) {
			unSltMethod.setText("");
			shpMethod = "Rail";
			shpMethodChecked = true;
			
		}else if(shipRB.isSelected()) {
			unSltMethod.setText("");
			shpMethod = "Ship";
			shpMethodChecked = true;
			
		}else {
			unSltMethod.setText("");
			shpMethod = "Self arrange";
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
		
		//execute delete function
		if(typeChecked == true &
				idChecked == true &
				nameChecked == true &
				shpMethodChecked == true &
				qtyChecked == true) {
			
			
			if(!arrayList.customerDetail.exists()) {
				
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
				
				txtPrint.setText("System don't have any order!" + "\n"
									+ "Please create the order first!");
				
			}else {
				try {
					arrayList.Search(type, id, name, shpMethod, quantity);
					
				} catch (IOException e) {
					e.printStackTrace();
					
				}
				
				if(arrayList.searchBool == true) {
					try {
						arrayList.remove(type, id, name, shpMethod, quantity);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//set the output in text area
					txtPrint.setText(arrayList.removeMsg);
					
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
					
					txtPrint.setText("No found id, " + id);
				}
			}

		}
	}
}
