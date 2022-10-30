public class ClearAll extends TheZoneSystem {
	public static void clear() {
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
	}
}
