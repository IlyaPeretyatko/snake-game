package org.nsu.networks.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.nsu.networks.model.GameModel;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class MenuController implements Initializable {

    private final GameModel gameModel = GameModel.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameTextField.setText(gameModel.getName());
    }

    @FXML
    private TextField nameTextField;


    public void exitButtonClicked(MouseEvent mouseEvent) {
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.close();
    }

    public void newGameButtonClicked(MouseEvent mouseEvent) throws IOException {
        String name = nameTextField.getText();
        if (name.isEmpty()) {
            throwErrorEmptyNickname();
        } else {
            gameModel.setName(name);
            Parent newGameParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/settings.fxml")));
            Scene newGameScene = new Scene(newGameParent);
            Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            window.setScene(newGameScene);
            window.show();
        }
    }

    public void connectButtonClicked(MouseEvent mouseEvent) {
        String name = nameTextField.getText();
        if (name.isEmpty()) {
            throwErrorEmptyNickname();
        } else {

        }
    }

    private void throwErrorEmptyNickname() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setHeaderText("Nickname cannot be empty");
        alert.setContentText("Write your nickname");
        alert.showAndWait();
    }


}
