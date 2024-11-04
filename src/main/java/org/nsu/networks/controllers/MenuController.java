package org.nsu.networks.controllers;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MenuController {

    @FXML
    private TextField nameTextField;

    @FXML
    private Button newGameButton;

    @FXML
    private Button connectButton;

    @FXML
    private Button exitButton;

    public void exitButtonClicked(MouseEvent mouseEvent) {
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.close();
    }

    public void newGameButtonClicked(MouseEvent mouseEvent) {
        String name = nameTextField.getText();
        if (name.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText("Nickname cannot be empty");
            alert.setContentText("Write your nickname");
            alert.showAndWait();
        } else {

        }
    }

    public void connectButtonClicked(MouseEvent mouseEvent) {

    }


}
