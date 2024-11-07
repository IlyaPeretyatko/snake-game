package org.nsu.networks.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.nsu.networks.model.GameModel;

import java.io.IOException;
import java.util.Objects;

public class ConnectController {

    private final GameModel gameModel = GameModel.getInstance();

    public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
        Parent newGameParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/menu.fxml")));
        Scene newGameScene = new Scene(newGameParent);
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(newGameScene);
        window.show();
    }

}
