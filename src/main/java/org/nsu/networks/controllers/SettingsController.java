package org.nsu.networks.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.nsu.networks.exceptions.WrongSettingsException;
import org.nsu.networks.model.GameModel;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class SettingsController implements Initializable {

    private final GameModel gameModel = GameModel.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        widthTextField.setText(String.valueOf(gameModel.getWidthField()));
        heightTextField.setText(String.valueOf(gameModel.getHeightField()));
        foodStaticTextField.setText(String.valueOf(gameModel.getFoodStatic()));
        stateDelayTextField.setText(String.valueOf(gameModel.getStateDelay()));
        maxPlayersTextField.setText(String.valueOf(gameModel.getMaxPlayers()));
    }

    @FXML
    private TextField gameNameTextField;

    @FXML
    private TextField widthTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField foodStaticTextField;

    @FXML
    private TextField stateDelayTextField;

    @FXML
    private TextField maxPlayersTextField;

    public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
        Parent newGameParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/menu.fxml")));
        Scene newGameScene = new Scene(newGameParent);
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(newGameScene);
        window.show();
    }

    public void startButtonClicked(MouseEvent mouseEvent) {
        try {
            checkGameNameTextField();
            checkSizeTextFields();
            checkFoodTextFields();
            checkStateDelayTextField();
            checkMaxPlayersTextField();
        } catch (WrongSettingsException e) {
            throwError(e.getHeader(), e.getContent());
        }
    }

    private void checkGameNameTextField() throws WrongSettingsException {
        if (gameNameTextField.getText().isEmpty()) {
            throw new WrongSettingsException("Game name is empty", "Print game name please");
        }
        gameModel.setGameName(gameNameTextField.getText());
    }

    private void checkSizeTextFields() throws WrongSettingsException {
        try {
            if (widthTextField.getText().isEmpty()) {
                widthTextField.setText("25");
            }
            if (heightTextField.getText().isEmpty()) {
                heightTextField.setText("25");
            }
            int width = Integer.parseInt(widthTextField.getText());
            int height = Integer.parseInt(heightTextField.getText());
            if (width >= 10 && height >= 10 && width <= 100 && height <= 100) {
                gameModel.setWidthField(width);
                gameModel.setHeightField(height);
            } else {
                throw new WrongSettingsException("Wrong sizes","Sizes must be from 10 to 100");
            }
        } catch (NumberFormatException e) {
            throw new WrongSettingsException("Values must be an integer", "Field sizes - must be an integer");
        }
    }

    private void checkFoodTextFields() throws WrongSettingsException {
        try {
            if (foodStaticTextField.getText().isEmpty()) {
                foodStaticTextField.setText("0");
            }
            int foodStatic = Integer.parseInt(foodStaticTextField.getText());
            if (foodStatic >= 0 && foodStatic <= 100) {
                gameModel.setFoodStatic(foodStatic);
            } else {
                throw new WrongSettingsException("Wrong food static","Food static must be from 0 to 100");
            }
        } catch (NumberFormatException e) {
            throw new WrongSettingsException("Values must be an integer", "Food static - must be an integer");
        }
    }

    private void checkStateDelayTextField() throws WrongSettingsException {
        try {
            if (stateDelayTextField.getText().isEmpty()) {
                stateDelayTextField.setText("1000");
            }
            int stateDelay = Integer.parseInt(stateDelayTextField.getText());
            if (stateDelay >= 100 && stateDelay <= 3000) {
                gameModel.setStateDelay(stateDelay);
            }else {
                throw new WrongSettingsException("Wrong state delay","State delay must be from 100 to 3000");
            }
        } catch (NumberFormatException e) {
            throw new WrongSettingsException("Values must be an integer", "State delay - must be an integer");
        }
    }

    private void checkMaxPlayersTextField() throws WrongSettingsException {
        try {
            if (maxPlayersTextField.getText().isEmpty()) {
                maxPlayersTextField.setText("2");
            }
            int maxPlayers = Integer.parseInt(maxPlayersTextField.getText());
            if (maxPlayers >= 2 && maxPlayers <= 5) {
                gameModel.setMaxPlayers(maxPlayers);
            } else {
                throw new WrongSettingsException("Wrong max players","Max players must be from 2 to 5");
            }
        } catch (NumberFormatException e) {
            throw new WrongSettingsException("Values must be an integer", "Max players - must be an integer");
        }
    }

    private void throwError(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }


}
