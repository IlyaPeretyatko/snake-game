package org.nsu.networks.controllers;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController {

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


}
