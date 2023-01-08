package app;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IndexScene {

    @FXML
    private Button EnterButton;

    @FXML
    private Button HowToButton;

    @FXML
    void EnterButtonClicked(ActionEvent event) {
        Stage primaryStage = new Stage();
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Virtual Space Game");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            ((Node) event.getSource()).getScene().getWindow().hide();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void HowToButtonClicked(ActionEvent event) {

    }

}
