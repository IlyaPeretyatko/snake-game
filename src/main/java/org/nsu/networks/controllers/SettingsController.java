package org.nsu.networks.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.nsu.networks.model.GameModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SettingsController {

    private final GameModel gameModel;

    @Autowired
    public SettingsController(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @FXML
    private TextField widthTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField foodStaticTextField;

    @FXML
    private TextField foodPerPlayerTextField;

    @FXML
    private TextField stateDelayTextField;

    @FXML
    private TextField deadFoodProbTextField;

    @FXML
    private TextField pingDelayTextField;

    @FXML
    private TextField nodeTimeoutTextField;

    @FXML
    private TextField maxPlayersTextField;

    @FXML
    private Button startButton;

    public void startButtonClicked(MouseEvent mouseEvent) {

    }


}
