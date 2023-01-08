package onboarding;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class onboardingController {

    @FXML
    private Button backButton1;

    @FXML
    private Button nextButton1;

    @FXML
    private Button backButton2;

    @FXML
    private Button nextButton2;

    @FXML
    private Button backButton3;

    @FXML
    private Button nextButton3;

    @FXML
    private Button backButton4;

    @FXML
    private Button startButton;

    @FXML
    void backButton1Clicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("../app/IndexScene.fxml"));
        scene = new Scene(root);
        stage.setTitle("Virtual Space Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setScene(scene);
        ((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    void backButton2Clicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("onboarding-1.fxml"));
        scene = new Scene(root);
        stage.setTitle("Virtual Space Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setScene(scene);
        ((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    void backButton3Clicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("onboarding-2.fxml"));
        scene = new Scene(root);
        stage.setTitle("Virtual Space Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setScene(scene);
        ((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    void backButton4Clicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("onboarding-3.fxml"));
        scene = new Scene(root);
        stage.setTitle("Virtual Space Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setScene(scene);
        ((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    void nextButton1Clicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("onboarding-2.fxml"));
        scene = new Scene(root);
        stage.setTitle("Virtual Space Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setScene(scene);
        ((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    void nextButton2Clicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("onboarding-3.fxml"));
        scene = new Scene(root);
        stage.setTitle("Virtual Space Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setScene(scene);
        ((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    void nextButton3Clicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("onboarding-4.fxml"));
        scene = new Scene(root);
        stage.setTitle("Virtual Space Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setScene(scene);
        ((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();
    }

    @FXML
    void startButtonClicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Scene scene;
        Parent root = FXMLLoader.load(getClass().getResource("../app/MainScene.fxml"));
        scene = new Scene(root);
        stage.setTitle("Virtual Space Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setScene(scene);
        ((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();
    }

}
