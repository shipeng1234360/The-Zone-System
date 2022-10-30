import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TheZoneSystem extends Application{
	//create CustomerManager object called arrayList
			static CustomerManage arrayList = new CustomerManage();
			
			//create label
			static Label lbID = new Label("Customer ID :");
			static Label lbType = new Label("Please select your customer type:");
			static Label lbName = new Label("Name :");
			static Label lbQuantity = new Label("Quantity :");
			static Label lbShippingMethod = new Label("Shipping Method :");
			static Label lbTitle = new Label("The Zone");
			static Label lbError = new Label();
			static Label unSltType = new Label();
			static Label unSltMethod = new Label();
			static Label lbNull = new Label();
			
			//create Text Field
			static TextField txtID = new TextField();
			static TextField txtName = new TextField();
			static TextField txtQuantity = new TextField();
			
			//create Radio Button
			static RadioButton regularRB = new RadioButton("Regular");
			static RadioButton premiumRB = new RadioButton("Premium");
			static RadioButton truckRB = new RadioButton("Truck");
			static RadioButton railRB = new RadioButton("Rail");
			static RadioButton shipRB = new RadioButton("Ship");
			static RadioButton selfArrangeRB = new RadioButton("Customer arranges shippings");
			
			//create Button
			static Button btnAdd = new Button("Add");
			static Button btnDlt = new Button("Delete");
			static Button btnSearch = new Button("Search");
			static Button btnPrt = new Button("Print All");
			static Button btnBck = new Button("Back");
			
			//create Toggle Group
			static ToggleGroup toggleType = new ToggleGroup();
			static ToggleGroup toggleMethod = new ToggleGroup();
			
			//create Text Area
			static TextArea txtPrint = new TextArea();
			
			//create stack pane to store error message in message stage
			static StackPane messagePane = new StackPane();
			
			//create scene for message stage
			static Scene messageScene = new Scene(messagePane);
			
			//create a new stage called messageStage to display error message
			static Stage messageStage = new Stage();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//defined the property of messagePane
		messagePane.getChildren().add(lbError);
		
		//defined the property of messageStage
		messageStage.setScene(messageScene);
		messageStage.setResizable(false);
		messageStage.setWidth(400);
		messageStage.setHeight(200);
		messageStage.initStyle(StageStyle.UTILITY);
		messageStage.initOwner(primaryStage);
		messageStage.initModality(Modality.APPLICATION_MODAL);
		messageStage.setTitle("                                         Error");
		
		//set property for label
		lbTitle.setFont(Font.font("Serif", FontWeight.BOLD, 
           FontPosture.ITALIC, 40));
		lbTitle.setTextFill(Color.PURPLE);
		
		lbError.setTextFill(Color.RED);
		unSltType.setTextFill(Color.RED);
		unSltMethod.setTextFill(Color.RED);
		
		//set the property for text field
		txtID.setMaxWidth(180);
		txtName.setMaxWidth(180);
		txtQuantity.setMaxWidth(180);
		
		//set the toggle group for radio button
		regularRB.setToggleGroup(toggleType);
		premiumRB.setToggleGroup(toggleType);
		truckRB.setToggleGroup(toggleMethod);
		railRB.setToggleGroup(toggleMethod);
		shipRB.setToggleGroup(toggleMethod);
		selfArrangeRB.setToggleGroup(toggleMethod);
		
		//set style of button
		btnAdd.setStyle("-fx-background-radius:30, 30, 30, 30; "
				+ "-fx-background-color:DODGERBLUE");
		btnDlt.setStyle("-fx-background-radius:30, 30, 30, 30; "
				+ "-fx-background-color:ORANGERED");
		btnSearch.setStyle("-fx-background-radius:30, 30, 30, 30; "
				+ "-fx-background-color:GOLD");
		btnPrt.setStyle("-fx-background-radius:30, 30, 30, 30; "
				+ "-fx-background-color:MEDIUMORCHID");
		btnBck.setStyle("-fx-background-radius:30, 30, 30, 30; "
				+ "-fx-background-color:GRAY");
		
		//set the property for text area
		txtPrint.setMaxSize(800, 300);
		txtPrint.setEditable(false);
		
		//create GridPane to display title
		GridPane titlePane = new GridPane();
		titlePane.setAlignment(Pos.CENTER);
		titlePane.add(lbTitle, 0, 0);
		titlePane.setPadding(new Insets(20,0,0,0));
		
		//create HBox to store the button
		HBox btnBox = new HBox(80);
		btnBox.getChildren().addAll(btnAdd, btnDlt, btnSearch, btnPrt, btnBck);
		btnBox.setPadding(new Insets(0, 0, 20, 80));
		
		//create the GridPane to store main UI
		GridPane pane = new GridPane();
		
		//set the property of main UI
		pane.setAlignment(Pos.CENTER);
		pane.add(lbType, 0, 0);
		pane.add(regularRB, 1, 0);
		pane.add(premiumRB, 2, 0);
		pane.add(unSltType, 1, 1);
		pane.add(lbID, 0, 2);
		pane.add(txtID, 1, 2);
		pane.add(lbName, 0, 3);
		pane.add(txtName, 1, 3);
		pane.add(lbShippingMethod, 0, 4);
		pane.add(truckRB, 1, 4);
		pane.add(railRB, 2, 4);
		pane.add(shipRB, 1, 5);
		pane.add(selfArrangeRB, 2, 5);
		pane.add(unSltMethod, 1, 6);
		pane.add(lbQuantity, 0, 7);
		pane.add(txtQuantity, 1, 7);
		pane.add(lbNull, 1, 8);
		pane.setHgap(10);
		pane.setVgap(15);
		pane.setPadding(new Insets(20, 0, 0, 0));
		
		//add effect on button
		btnAdd.setOnMouseEntered((t) -> {
			btnAdd.setEffect(new DropShadow());
		});
		
		btnAdd.setOnMouseExited((t) -> {
			btnAdd.setEffect(null);
		});

		btnDlt.setOnMouseEntered((t) -> {
			btnDlt.setEffect(new DropShadow());
		});
		
		btnDlt.setOnMouseExited((t) -> {
			btnDlt.setEffect(null);
		});
		
		btnSearch.setOnMouseEntered((t) -> {
			btnSearch.setEffect(new DropShadow());
		});
		
		btnSearch.setOnMouseExited((t) -> {
			btnSearch.setEffect(null);
		});
		
		btnPrt.setOnMouseEntered((t) -> {
			btnPrt.setEffect(new DropShadow());
		});
		
		btnPrt.setOnMouseExited((t) -> {
			btnPrt.setEffect(null);
		});
		
		btnBck.setOnMouseEntered((t) -> {
			btnBck.setEffect(new DropShadow());
		});
		
		btnBck.setOnMouseExited((t) -> {
			btnBck.setEffect(null);
		});
		
		
		//set action of add button
		btnAdd.setOnAction((t) -> {
			AddCustomer.add();		
		});
		
		//set action of search button
		btnSearch.setOnAction((t) -> {
			SearchCustomer.search();
		});
		
		//set action of delete button
		btnDlt.setOnAction((t) -> {
			DeleteCustomer.delete();
		});
		
		//set action for print button
		btnPrt.setOnAction((t) -> {
			PrintCustomer.print();
		});
		
		//set action of back button
		btnBck.setOnAction((t) -> {
			ClearAll.clear();
		});
		
		//create the first border pane to store main UI, title, and button
		BorderPane bp = new BorderPane();
		bp.setTop(titlePane);
		bp.setCenter(pane);
		bp.setBottom(btnBox);
		
		//create the second border pane to store first border pane and text area
		BorderPane bp2 = new BorderPane();
		bp2.setCenter(bp);
		bp2.setBottom(txtPrint);
		
		//create the scene to store second border pane
		Scene scene = new Scene(bp2);
		
		//set the property of primaryStage
		primaryStage.setTitle("The Zone System");
		primaryStage.setResizable(false);
		primaryStage.setWidth(800);
		primaryStage.setHeight(750);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
