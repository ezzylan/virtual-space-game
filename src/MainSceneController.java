import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private Button EatButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Button LeaveButton;

    @FXML
    private Button MenuButton;

    @FXML
    private Button MusicButton;

    @FXML
    private Button OrderButton;

    @FXML
    private Button SitButton;

    @FXML
    void EatButtonClicked(ActionEvent event) {

    }

    @FXML
    void LeaveButtonClicked(ActionEvent event) {
        Stage primaryStage = new Stage();
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("IndexScene.fxml"));
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
    void MenuButtonClicked(ActionEvent event) {

    }

    @FXML
    void MusicButtonClicked(ActionEvent event) {

    }

    @FXML
    void OrderButtonClicked(ActionEvent event) {

    }

    @FXML
    void SitButtonClicked(ActionEvent event) {

    }

}
