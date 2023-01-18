package order_Food;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class foodController {

    @FXML
    private Button cancelOrder;

    @FXML
    private Button cbutton;

    @FXML
    private Button dbutton;

    @FXML
    private ImageView myImageView;

    @FXML
    private Button sbutton;

    @FXML
    void cBtnClicked(ActionEvent event) {

    }

    @FXML
    void cancelOrderClicked(ActionEvent event) {
        Stage viewMenuStage = new Stage();
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("../app/MainScene.fxml"));   
            Scene scene = new Scene(root);
            viewMenuStage.setTitle("Virtual Space Game - Menu");
            viewMenuStage.setScene(scene);
            viewMenuStage.setResizable(false);
            ((Node) event.getSource()).getScene().getWindow().hide();
            viewMenuStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }

    @FXML
    void dBtnClicked(ActionEvent event) {

    }

    @FXML
    void sBtnClicked(ActionEvent event) {

    }

}

