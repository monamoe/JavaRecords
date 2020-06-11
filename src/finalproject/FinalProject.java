package finalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.StringTokenizer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FinalProject extends Application {

    //Labels and TextFields
    private final Label orderIdLabel = new Label("Order ID:");
    private Label nameLabel = new Label("Name:");
    private Label addressLabel = new Label("Address:");
    private Label cityLabel = new Label("City:");
    private Label productLabel = new Label("Product:");
    private Label priceLabel = new Label("Order Price:");
    private Label quantityLabel = new Label("Quantity:");
    private static TextField orderIdField = new TextField();
    private static TextField nameField = new TextField();
    private static TextField addressField = new TextField();
    private static TextField cityField = new TextField();
    private static TextField productField = new TextField();
    private static TextField priceField = new TextField();
    private static TextField quantityField = new TextField();
    private Rectangle labelsFieldsBox = new Rectangle();

    //Buttons
    private Button nextRecord = new Button("Next ->");
    private Button previousRecord = new Button("<- Previous");
    private Button firstRecord = new Button("<<- First");
    private Button LastRecord = new Button("Last ->>");
    private Button addRecord = new Button("Add");
    private Button removeRecord = new Button("Remove");
    private Button searchRecord = new Button("Search");
    private Button updateRecord = new Button("Update");

    private Rectangle buttonsBox = new Rectangle();

    //Pane
    private Pane pane = new Pane();

    //File
    private static File data = new File("data.dat");

    //ArrayList
    private static ArrayList<Order> orderList = new ArrayList<Order>();
    private static int arrayListCounter = 0;

    //  Button Events  //
    //searching through the records
    public class searchButtonEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            //Labels and TextFields and searchButton
            Label orderIdLabel = new Label("Order ID:");
            Label nameLabel = new Label("Name:");
            Label addressLabel = new Label("Address:");
            Label cityLabel = new Label("City:");
            Label productLabel = new Label("Product:");
            Label priceLabel = new Label("Order Price:");
            Label quantityLabel = new Label("Quantity:");
            TextField orderIdField = new TextField();
            TextField nameField = new TextField();
            TextField addressField = new TextField();
            TextField cityField = new TextField();
            TextField productField = new TextField();
            TextField priceField = new TextField();
            TextField quantityField = new TextField();
            Rectangle labelsFieldsBox = new Rectangle();
            Button searchRecordResults = new Button("Search");

            Pane searchPane = new Pane();

            // UI //
            Label searchResultsLabel = new Label("Search Results: ");
            TextArea searchResults = new TextArea();
            Rectangle searchBackround = new Rectangle();
            searchBackround.setFill(Color.LIGHTBLUE);
            searchBackround.setLayoutX(300);
            searchBackround.setLayoutY(20);
            searchBackround.setWidth(520);
            searchBackround.setHeight(310);

            searchResultsLabel.setLayoutY(40);
            searchResultsLabel.setLayoutX(320);
            searchResults.setLayoutY(60);
            searchResults.setLayoutX(320);
            searchResults.setMinSize(400, 250);
            searchPane.getChildren().add(searchBackround);
            searchPane.getChildren().add(searchResults);
            searchPane.getChildren().add(searchResultsLabel);

            labelsFieldsBox.setLayoutX(20);
            labelsFieldsBox.setLayoutY(20);
            labelsFieldsBox.setWidth(260);
            labelsFieldsBox.setHeight(310);
            labelsFieldsBox.setFill(Color.LIGHTBLUE);
            searchPane.getChildren().add(labelsFieldsBox);

            //Labels
            double labelsX = 50;
            orderIdLabel.setLayoutX(labelsX);
            nameLabel.setLayoutX(labelsX);
            addressLabel.setLayoutX(labelsX);
            cityLabel.setLayoutX(labelsX);
            productLabel.setLayoutX(labelsX);
            priceLabel.setLayoutX(labelsX);
            quantityLabel.setLayoutX(labelsX);

            orderIdLabel.setLayoutY(40);
            nameLabel.setLayoutY(80);
            addressLabel.setLayoutY(120);
            cityLabel.setLayoutY(160);
            productLabel.setLayoutY(200);
            priceLabel.setLayoutY(240);
            quantityLabel.setLayoutY(280);

            //Fields
            double fieldsX = 120;
            orderIdField.setLayoutX(fieldsX);
            nameField.setLayoutX(fieldsX);
            addressField.setLayoutX(fieldsX);
            cityField.setLayoutX(fieldsX);
            productField.setLayoutX(fieldsX);
            priceField.setLayoutX(fieldsX);
            quantityField.setLayoutX(fieldsX);

            orderIdField.setLayoutY(40);
            nameField.setLayoutY(80);
            addressField.setLayoutY(120);
            cityField.setLayoutY(160);
            productField.setLayoutY(200);
            priceField.setLayoutY(240);
            quantityField.setLayoutY(280);

            //Buttons
            searchRecordResults.setLayoutX(130);
            searchRecordResults.setLayoutY(350);
            searchRecordResults.setMinWidth(60);
            searchRecordResults.setMinHeight(30);

            //Add to the pane
            searchPane.getChildren().add(orderIdField);
            searchPane.getChildren().add(nameField);
            searchPane.getChildren().add(addressField);
            searchPane.getChildren().add(cityField);
            searchPane.getChildren().add(productField);
            searchPane.getChildren().add(priceField);
            searchPane.getChildren().add(quantityField);
            //labels
            searchPane.getChildren().add(orderIdLabel);
            searchPane.getChildren().add(nameLabel);
            searchPane.getChildren().add(addressLabel);
            searchPane.getChildren().add(cityLabel);
            searchPane.getChildren().add(productLabel);
            searchPane.getChildren().add(priceLabel);
            searchPane.getChildren().add(quantityLabel);
            searchPane.getChildren().add(searchRecordResults);

            Scene searchScene = new Scene(searchPane, 840, 400);
            Stage secoundaryStage = new Stage();
            secoundaryStage.setScene(searchScene);
            secoundaryStage.setTitle("Searching Order");
            secoundaryStage.show();

            //logic 
            searchRecordResults.setOnAction(e -> {
                ArrayList<Order> searchingList = new ArrayList<Order>();
                for (int i = 0; i < orderList.size(); i++) {
                    searchingList.add(orderList.get(i));
                }
                String finalText = "";

                String orderID = orderIdField.getText().trim();
                String name = nameField.getText().trim();
                String city = cityField.getText().trim();
                String address = addressField.getText().trim();
                String product = productField.getText().trim();
                String price = "" + priceField.getText().trim();
                String quantity = "" + quantityField.getText().trim();

                //loop through
                for (int i = 0; i < searchingList.size(); i++) {
                    if (orderID.equals(Integer.toString(searchingList
                            .get(i)
                            .getOrderID()))) {
                        finalText = finalText + searchingList.get(i)
                                .toString() + "\n";
                        searchingList.remove(i);
                    } else if (name.equals(searchingList.get(i)
                            .getName())) {
                        finalText = finalText + searchingList.get(i)
                                .toString() + "\n";
                        searchingList.remove(i);
                    } else if (city.equals(searchingList.get(i)
                            .getCity())) {
                        finalText = finalText + searchingList.get(i)
                                .toString() + "\n";
                        searchingList.remove(i);
                    } else if (address.equals(searchingList.get(i).
                            getAddress())) {
                        finalText = finalText + searchingList.get(i)
                                .toString() + "\n";
                        searchingList.remove(i);
                    } else if (product.equals(searchingList.get(i).
                            getProduct())) {
                        finalText = finalText + searchingList.get(i)
                                .toString() + "\n";
                        searchingList.remove(i);
                    } else if (price.equals("" + searchingList.get(i).
                            getPrice())) {
                        finalText = finalText + searchingList.get(i)
                                .toString() + "\n";
                        searchingList.remove(i);
                    } else if (quantity.equals("" + searchingList.get(i).
                            getQuantity())) {
                        finalText = finalText + searchingList.get(i)
                                .toString() + "\n";
                        searchingList.remove(i);
                    }
                }
                searchResults.setText(finalText);
            });

        }

    }

//adding Order button
//displays a blank sheet
    public class addButtonEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            //change the layout
            updateRecord.setVisible(true);
            updateRecord.setLayoutX(170);
            updateRecord.setLayoutY(380);
            updateRecord.setMinWidth(60);
            nextRecord.setVisible(false);
            previousRecord.setVisible(false);
            firstRecord.setVisible(false);
            LastRecord.setVisible(false);
            addRecord.setVisible(false);
            removeRecord.setVisible(false);
            searchRecord.setVisible(false);
            //create the order object and add it to the array list
            Order newOrder = new Order(0);
            orderList.add(arrayListCounter + 1, newOrder);
            setOrderDisplay(arrayListCounter + 1);
        }

    }

//removing Order event
//alert asks if they want to delete the record
//if yes, then delete and move to the next record
    public class removeButtonEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
            confirmAlert.setContentText("Click \"ok\" to delete "
                    + "this record.");
            confirmAlert.setTitle("Confirm");
            confirmAlert.setHeaderText("Remove Entry?");
            Optional<ButtonType> result = confirmAlert.showAndWait();

            //true means the data will be set and the page will be updated
            boolean updatingRecord = true;

            //if the user clicks the OK button
            if (result.get() == ButtonType.OK) {
                orderList.remove(arrayListCounter);
                setOrderDisplay(arrayListCounter - 1);
            }
        }

    }

//updating Order event
    public class updateButtonEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
            confirmAlert.setContentText("Click \"ok\" to add this "
                    + "entry to the program. Click cancel to cancel");
            confirmAlert.setTitle("Confirm");
            confirmAlert.setHeaderText("Add Entry?");
            Optional<ButtonType> result = confirmAlert.showAndWait();

            //true means the data will be set and the page will be updated
            boolean updatingRecord = true;

            //if the user clicks the OK button
            if (result.get() == ButtonType.OK) {
                Order newOrder = new Order(1);

                //checks to see if the orderID is usable
                if (setOrderIDValue(orderIdField.getText().trim())) {
                    //making a new order using the orderID
                    newOrder = new Order(Integer.parseInt(orderIdField.
                            getText().trim()));

                    //setting the name
                    try {
                        newOrder.setName(nameField.getText().trim());
                    } catch (Exception ee) {
                        newOrder.setName("No Name Entered");
                    }

                    //setting the address
                    try {
                        newOrder.setAddress(addressField.getText()
                                .trim());
                    } catch (Exception ee) {
                        newOrder.setAddress("No Address Entered");
                    }

                    //setting the city
                    try {
                        newOrder.setCity(cityField.getText().trim());
                    } catch (Exception ee) {
                        newOrder.setCity("No City Entered");
                    }

                    //setting the product
                    try {
                        newOrder.setProduct(productField.getText()
                                .trim());
                    } catch (Exception ee) {
                        newOrder.setProduct("No Product Entered");
                    }

                    if (setOrderPrice(priceField.getText().trim())) {
                        newOrder.setPrice(Double.parseDouble(
                                priceField.getText().trim()));
                        if (setOrderQuantity(quantityField.getText()
                                .trim())) {
                            newOrder.setQuantity(Integer.parseInt(
                                    quantityField.getText().trim()));
                        }
                    }
                    orderList.set(arrayListCounter, newOrder);
                    nextRecord.setVisible(true);
                    previousRecord.setVisible(true);
                    firstRecord.setVisible(true);
                    LastRecord.setVisible(true);
                    addRecord.setVisible(true);
                    removeRecord.setVisible(true);
                    updateRecord.setLayoutX(220);
                    updateRecord.setMinWidth(60);
                    updateRecord.setLayoutY(410);
                    searchRecord.setVisible(true);
                    setOrderDisplay(arrayListCounter);
                }
            } else {
                //if the user doesnt click the OK button
                //doesnt update the record, page doesnt update
                //data isnt saved either
            }
        }

    }

//scrolling through the records
//next Order event
    public class nextButtonEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            setOrderDisplay(arrayListCounter + 1);
        }

    }

//previous Order event
    public class previousButtonEvent
            implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            setOrderDisplay(arrayListCounter - 1);
        }

    }

//first Order event
    public class firstButtonEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            setOrderDisplay(0);
        }

    }

//last Order event
    public class lastButtonEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            setOrderDisplay(orderList.size() - 1);
        }

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //on close
        primaryStage.setOnCloseRequest(event -> {
            Alert confirmAlert = new Alert(AlertType.INFORMATION);
            confirmAlert.setTitle("Terminating Program");
            confirmAlert.setHeaderText("Closing the program");
            confirmAlert.setContentText("Data will be saved to a file");
            confirmAlert.show();

            try {
                // Save file
                FileWriter fw = new FileWriter(data);
                BufferedWriter bw = new BufferedWriter(fw);
                String line;
                for (int i = 0; i < orderList.size(); i++) {
                    line = "";
                    line += orderList.get(i).getOrderID() + ", ";
                    line += orderList.get(i).getName() + ", ";
                    line += orderList.get(i).getAddress() + ", ";
                    line += orderList.get(i).getCity() + ", ";
                    line += orderList.get(i).getProduct() + ", ";
                    line += orderList.get(i).getPrice() + ", ";
                    line += orderList.get(i).getQuantity() + ", ";
                    line += "\n";
                    bw.write(line);
                }
                bw.close();
                fw.close();

            } catch (IOException ex) {

            }
        });

        //buttons events
        //adding a new record
        //displays a blank object, user inputs data and then clicks 
        //an update button to set the data to that object
        addRecord.setOnAction(new addButtonEvent());
        //update buttons displays an alert, if confirmed, the new record 
        //should appear
        //if cancelled, the previous record should appear
        updateRecord.setOnAction(new updateButtonEvent());
        //alert asks if theyw ant to delete the record
        //if yes, then delete and move to the next record
        removeRecord.setOnAction(new removeButtonEvent());
        //search through records
        searchRecord.setOnAction(new searchButtonEvent());

        //scrolling through the records
        nextRecord.setOnAction(new nextButtonEvent());
        previousRecord.setOnAction(new previousButtonEvent());
        firstRecord.setOnAction(new firstButtonEvent());
        LastRecord.setOnAction(new lastButtonEvent());

        // UI //
        labelsFieldsBox.setLayoutX(30);
        labelsFieldsBox.setLayoutY(30);
        labelsFieldsBox.setWidth(340);
        labelsFieldsBox.setHeight(310);
        labelsFieldsBox.setFill(Color.LIGHTBLUE);
        pane.getChildren().add(labelsFieldsBox);

        //Labels
        double labelsX = 50;
        orderIdLabel.setLayoutX(labelsX);
        nameLabel.setLayoutX(labelsX);
        addressLabel.setLayoutX(labelsX);
        cityLabel.setLayoutX(labelsX);
        productLabel.setLayoutX(labelsX);
        priceLabel.setLayoutX(labelsX);
        quantityLabel.setLayoutX(labelsX);

        orderIdLabel.setLayoutY(40);
        nameLabel.setLayoutY(80);
        addressLabel.setLayoutY(120);
        cityLabel.setLayoutY(160);
        productLabel.setLayoutY(200);
        priceLabel.setLayoutY(240);
        quantityLabel.setLayoutY(280);

        //Fields
        double fieldsX = 120;
        orderIdField.setLayoutX(fieldsX);
        nameField.setLayoutX(fieldsX);
        addressField.setLayoutX(fieldsX);
        cityField.setLayoutX(fieldsX);
        productField.setLayoutX(fieldsX);
        priceField.setLayoutX(fieldsX);
        quantityField.setLayoutX(fieldsX);

        orderIdField.setLayoutY(40);
        nameField.setLayoutY(80);
        addressField.setLayoutY(120);
        cityField.setLayoutY(160);
        productField.setLayoutY(200);
        priceField.setLayoutY(240);
        quantityField.setLayoutY(280);

        //Buttons
        firstRecord.setLayoutX(30);
        previousRecord.setLayoutX(120);
        nextRecord.setLayoutX(220);
        LastRecord.setLayoutX(310);
        nextRecord.setLayoutY(380);
        previousRecord.setLayoutY(380);
        firstRecord.setLayoutY(380);
        LastRecord.setLayoutY(380);

        addRecord.setLayoutX(30);
        removeRecord.setLayoutX(120);
        updateRecord.setLayoutX(220);
        searchRecord.setLayoutX(310);
        addRecord.setLayoutY(410);
        removeRecord.setLayoutY(410);
        updateRecord.setLayoutY(410);
        searchRecord.setLayoutY(410);

        addRecord.setMinWidth(60);
        removeRecord.setMinWidth(60);
        updateRecord.setMinWidth(60);
        searchRecord.setMinWidth(60);
        firstRecord.setMinWidth(60);
        previousRecord.setMinWidth(60);
        nextRecord.setMinWidth(60);
        LastRecord.setMinWidth(60);

        //Add to the pane
        pane.getChildren().add(orderIdField);
        pane.getChildren().add(nameField);
        pane.getChildren().add(addressField);
        pane.getChildren().add(cityField);
        pane.getChildren().add(productField);
        pane.getChildren().add(priceField);
        pane.getChildren().add(quantityField);
        //labels
        pane.getChildren().add(orderIdLabel);
        pane.getChildren().add(nameLabel);
        pane.getChildren().add(addressLabel);
        pane.getChildren().add(cityLabel);
        pane.getChildren().add(productLabel);
        pane.getChildren().add(priceLabel);
        pane.getChildren().add(quantityLabel);
        //buttons
        pane.getChildren().add(addRecord);
        pane.getChildren().add(removeRecord);
        pane.getChildren().add(updateRecord);
        pane.getChildren().add(searchRecord);
        pane.getChildren().add(nextRecord);
        pane.getChildren().add(previousRecord);
        pane.getChildren().add(firstRecord);
        pane.getChildren().add(LastRecord);

        Scene scene = new Scene(pane, 400, 470);
        primaryStage.setTitle("Records");
        primaryStage.setScene(scene);
        primaryStage.show();

        //main method shit
        try {
            //Finds the file, if the file doesn't exist
            //then creates a new file
            if (!data.exists()) {
                System.out.println("File was not found");
                //if file doesnt exist, then create a new file
                if (data.createNewFile()) {
                    System.out.println(data.getName() + " has been "
                            + "created.");
                }
            }
        } catch (IOException e) {
        }

        //setup the data inside the array list
        updateData();

        //initial setup of the output
        setOrderDisplay(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws
            FileNotFoundException,
            IOException {
        launch(args);
    }

    /**
     * updates the data in the files
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void updateData()
            throws FileNotFoundException, IOException {
        try {
            ArrayList<Order> temp = new ArrayList();

            Order tempOrder = new Order(3);
            FileReader fr = new FileReader(data);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            StringTokenizer st;

            while (line != null) {
                st = new StringTokenizer(line, ",");
                //setting the orderID
                String temp2 = st.nextToken().trim();
                if (setOrderIDValue(temp2)) {
                    tempOrder = new Order(Integer.parseInt(temp2));
                    tempOrder.setName(st.nextToken().trim());
                    tempOrder.setAddress(st.nextToken().trim());
                    tempOrder.setCity(st.nextToken().trim());
                    tempOrder.setProduct(st.nextToken().trim());
                    //setting the quantity
                    String price = st.nextToken().trim();
                    if (setOrderPrice(price)) {
                        tempOrder.setPrice(Double.parseDouble(price));
                        String quantity = st.nextToken().trim();
                        if (setOrderPrice(quantity)) {
                            tempOrder.setQuantity(Integer
                                    .parseInt(quantity));
                            //setting the price
                        }
                    }
                    temp.add(tempOrder);
                    line = br.readLine();
                }
            }
            orderList = temp;
        } catch (Exception e) {
            Alert loadingDataError = new Alert(AlertType.ERROR);
            loadingDataError.setTitle("Fatal Error");
            loadingDataError.setHeaderText("Data Load Procedure "
                    + "interrupeted");
            loadingDataError.setContentText("Invalid data "
                    + "file format detected."
                    + "your file may have been tampered with! "
                    + "\nPlease correct the formatting errors "
                    + "in the data file! \n\n "
                    + e);
            loadingDataError.showAndWait();
        }

    }

    /**
     * Displays the order data for the first entry in the arrayList
     */
    public static void setOrderDisplay(int location) {
        try {
            orderIdField.setText(Integer.toString(orderList.get(location)
                    .getOrderID()));
            nameField.setText(orderList.get(location).getName());
            addressField.setText(orderList.get(location).getAddress());
            cityField.setText(orderList.get(location).getCity());
            productField.setText(orderList.get(location).getProduct());
            priceField.setText(Double.toString(orderList.get(location)
                    .getPrice()));
            quantityField.setText(Integer.toString(orderList.get(location)
                    .getQuantity()));
            arrayListCounter = location;

        } catch (Exception e) {
            location = arrayListCounter;
            orderIdField.setText(Integer.toString(orderList.get(location
            ).getOrderID()));
            nameField.setText(orderList.get(location).getName());
            addressField.setText(orderList.get(location).getAddress());
            cityField.setText(orderList.get(location).getCity());
            productField.setText(orderList.get(location).getProduct());
            priceField.setText(Double.toString(orderList.get(location)
                    .getPrice()));
            quantityField.setText(Integer.toString(orderList.get(location)
                    .getQuantity()));

        }
    }

    public static boolean setOrderPrice(String input) {
        double temp;
        try {
            temp = Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            Alert invalidDataTypeError = new Alert(Alert.AlertType.ERROR);
            invalidDataTypeError.setTitle("Data Type Error");
            invalidDataTypeError.setHeaderText("Invalid Data Type");
            invalidDataTypeError.setContentText("Please enter a "
                    + "double for the price");
            invalidDataTypeError.showAndWait();
            return false;
        }
    }

    public static boolean setOrderQuantity(String input) {
        int temp;
        try {
            temp = Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            Alert invalidDataTypeError = new Alert(Alert.AlertType.ERROR);
            invalidDataTypeError.setTitle("Data Type Error");
            invalidDataTypeError.setHeaderText("Invalid Data Type");
            invalidDataTypeError.setContentText("Please enter an "
                    + "integer for the quantity");
            invalidDataTypeError.showAndWait();
            return false;
        }
    }

    //make sure the userID is usable
    public static boolean setOrderIDValue(String input) {
        //check if the number is an integer
        boolean output = false;
        try {
            //if temp is 0, there is no error, temp is 0 by default
            //change to 1 if the value if fine
            int temp = 0;
            //if the size of the list isnt 0, then check all 
            //of the values in the array list to make sure 
            //the value is usable
            if (orderList.size() != 0) {
                for (int counter = 0; counter < orderList.size();
                        counter++) {

                    //check if the number already exists
                    if (Integer.parseInt(input) == orderList.get(counter)
                            .getOrderID()) {
                        //found a match
                        //find out if were editing the Order or 
                        //if were adding a new Order
                        if (Integer.parseInt(input)
                                == orderList.get(arrayListCounter)
                                        .getOrderID()) {
                            temp = 0;
                        } else {
                            //this order id already exists
                            temp = 1;
                        }
                        break;
                    }
                }
            } else {
                temp = 0;
            }

            //if temp is 1, then display the error
            if (temp == 1) {
                Alert orderIdExistsError
                        = new Alert(Alert.AlertType.ERROR);
                orderIdExistsError.setTitle("OrderID Error");
                orderIdExistsError.setHeaderText("OrderID already"
                        + " Exists");
                orderIdExistsError.setContentText("There is already an "
                        + "order with this "
                        + "OrderID, please enter a different OrderID");
                orderIdExistsError.showAndWait();
                output = false;
            } else {
                output = true;
            }

        } catch (Exception e) {
            Alert invalidDataTypeError = new Alert(Alert.AlertType.ERROR);
            invalidDataTypeError.setTitle("Data Type Error");
            invalidDataTypeError.setHeaderText("Invalid Data Type");
            invalidDataTypeError.setContentText("Please enter an integer "
                    + "for the orderID");
            invalidDataTypeError.showAndWait();
            output = false;
        }
        return output;
    }

}
