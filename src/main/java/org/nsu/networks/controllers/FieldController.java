package org.nsu.networks.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.nsu.networks.model.GameModel;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FieldController implements Initializable {

    GameModel gameModel = GameModel.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameNameLabel.setText(gameModel.getGameName());
    }

    @FXML
    private Label gameNameLabel;

    @FXML
    private ListView<Text> playersListView;

    @FXML
    private GridPane fieldGridPane;

    public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
        //disconnect
        Parent newGameParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/menu.fxml")));
        Scene newGameScene = new Scene(newGameParent);
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(newGameScene);
        window.show();
    }
}
