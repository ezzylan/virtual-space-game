package app;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import enter_leave.EnterLeave;
import enter_leave.EnterState;
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
    void EnterButtonClicked(ActionEvent event)
            throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Stage primaryStage = new Stage();
        Parent root;

        enter_leave.EnterLeave context = new EnterLeave();
        enter_leave.State enterState = new EnterState();

        context.setState(enterState);
        context.doAction();

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
    void HowToButtonClicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("../onboarding/onboarding-1.fxml"));
        scene = new Scene(root);
        stage.setTitle("Virtual Space Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setScene(scene);
        ((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();
    }

}
