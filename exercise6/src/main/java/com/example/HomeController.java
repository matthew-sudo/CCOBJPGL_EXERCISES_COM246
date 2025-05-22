package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController implements Initializable {

    ObservableList<User> mylist = FXCollections.observableArrayList();

    @FXML
    private Label userLabel;

    @FXML
    private TableColumn<User, String> usertable;

    @FXML
    private TableColumn<User, String> acctable;

    @FXML
    private TableColumn<User, String> pwordtable;

    @FXML
    private TableColumn<User, String> stattable;

    @FXML
    private TableView<User> mytable;

    @FXML
    private ChoiceBox<String> statusbutton;

    @FXML
    private Button createbutton;

    @FXML
    private Button updatebutton;

    @FXML
    private Button deletebutton;

    @FXML
    private TextField uname;

    @FXML
    private TextField pword;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        initializeCol();
        loadData();

        String user = LoginHandler.user.getUsername();
        userLabel.setText(user);
    }

    private void initializeCol() {
        usertable.setCellValueFactory(new PropertyValueFactory<>("username"));
        pwordtable.setCellValueFactory(new PropertyValueFactory<>("password"));
        acctable.setCellValueFactory(new PropertyValueFactory<>("accountcreated"));
        stattable.setCellValueFactory(new PropertyValueFactory<>("accountstatus"));
    }

    private void loadData() {
        mylist.clear();

        try {
            File myFile = new File("accounts.txt");

            if (myFile.exists()) {
                Scanner filescanner = new Scanner(myFile);

                while (filescanner.hasNextLine()) {
                    String data = filescanner.nextLine();
                    String[] parts = data.split(",");
                    if (parts.length >= 4) {
                        String username = parts[0];
                        String password = parts[1];
                        String dcreated = parts[2];
                        String status = parts[3];
                        mylist.add(new User(username, password, dcreated, status));
                    }
                }

                mytable.setItems(mylist);
                filescanner.close();
            } else {
                System.out.println(myFile.getName() + " does not exist!");
            }
        } catch (Exception e) {
            System.out.println("There is an error: " + e.getMessage());
        }
    }

    @FXML
    private boolean createuser(ActionEvent event) {
        String username = uname.getText().trim();
        String password = pword.getText().trim();
        String status = statusbutton.getValue() != null ? statusbutton.getValue().trim() : "";

        if (username.isEmpty()) {
            showAlert(AlertType.ERROR, "Validation Error", "No username provided");
            return false;
        }

        if (password.isEmpty()) {
            showAlert(AlertType.ERROR, "Validation Error", "No password provided");
            return false;
        }

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate = today.format(formatter);

        User user = new User(username, password, formattedDate, status);

        try (BufferedWriter myWriter = new BufferedWriter(new FileWriter("accounts.txt", true))) {
            myWriter.newLine();
            myWriter.write(user.getUsername() + "," + user.getPassword() + "," + user.getAccountCreated() + "," + user.getAccountStatus());

            showAlert(AlertType.INFORMATION, "User Created", "User account has been successfully created.");
            loadData();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return true;
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
