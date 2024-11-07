package org.nsu.networks.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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

    public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
        Parent newGameParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/menu.fxml")));
        Scene newGameScene = new Scene(newGameParent);
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(newGameScene);
        window.show();
    }

    public void startButtonClicked(MouseEvent mouseEvent) {
        checkFoodTextFields();
        checkSizeTextFields();
    }

    private void checkSizeTextFields() {
        try {
            if (widthTextField.getText().isEmpty()) {
                widthTextField.setText("25");
            }
            if (heightTextField.getText().isEmpty()) {
                heightTextField.setText("25");
            }
            int width = Integer.parseInt(widthTextField.getText());
            int height = Integer.parseInt(heightTextField.getText());
            if (width >= 10 && height >= 10 && width <= 50 && height <= 50 && width % 5 == 0 && height % 5 == 0) {
                gameModel.setWidthField(width);
                gameModel.setHeightField(height);
            } else {
                throwError("Wrong sizes","Sizes must be from 10 to 50 and multiples of 5");
                return;
            }
        } catch (NumberFormatException e) {
            throwError("Values must be an integer", "Field sizes - must be an integer");
        }
    }

    public void checkFoodTextFields() {
        try {
            if (foodStaticTextField.getText().isEmpty()) {
                foodStaticTextField.setText("0");
            }
            int foodStatic = Integer.parseInt(foodStaticTextField.getText());
            if (foodStatic >= 0 && foodStatic <= 5) {
                gameModel.setFoodStatic(foodStatic);
            } else {
                throwError("Wrong food static","Food Static must be from 0 to 5");
            }
        } catch (NumberFormatException e) {
            throwError("Values must be an integer", "Food static - must be an integer");
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
