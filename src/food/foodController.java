package food;

import java.io.Console;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import enter_leave.EnterLeave;
import enter_leave.LeaveState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import music_player.MusicPlayer;
import music_player.OffMusicCommand;
import music_player.OnMusicCommand;

public class foodController {

    MusicPlayer musicPlayer = new MusicPlayer();
    boolean isPlaying = false;
    public int cake;
    public int juice;
    public int pasta;

    @FXML
    private ImageView indexBG;

    @FXML
    private ImageView foodBG1;

    @FXML
    private ImageView foodBG2;

    @FXML
    private ImageView foodBG3;

    @FXML
    private Button EatButton;

    @FXML
    private Button LeaveButton;

    @FXML
    private Button MenuButton;

    @FXML
    private Button MusicButton;

    @FXML
    private Text MusicName;

    @FXML
    private Button OrderButton;

    @FXML
    private Button SitButton;

    @FXML
    private Text WalletAmount;

    @FXML
    public Button displayButton;

    @FXML
    void EatButtonClicked(ActionEvent event) {

    }

    @FXML
    void LeaveButtonClicked(ActionEvent event)
        throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Stage primaryStage = new Stage();
        Parent root;

        enter_leave.EnterLeave context = new EnterLeave();
        enter_leave.State leaveState = new LeaveState();

        context.setState(leaveState);
        context.doAction();

        try {
        root = FXMLLoader.load(getClass().getResource("../app/IndexScene.fxml"));
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
        Stage viewMenuStage = new Stage();
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("ViewMenuScene.fxml"));   
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
    void MusicButtonClicked(ActionEvent event)
        throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        // if (isPlaying) {
        //   musicPlayer.stopMusic(new OffMusicCommand(), this, MusicButton, MusicName);
        // } else {
        //   musicPlayer.playMusic(new OnMusicCommand(), this, MusicButton, MusicName);
        // }
    }

    /**
     * Using Decorator design pattern that use plateDecorator class 
     * and foodItemDecorator concrete class which wraps the original 
     * class (plate) and provides additional functionality 
     * (methods; enjoy()) while keeping exiting class methods intact.
     */
    @FXML
    void displayButtonClicked(ActionEvent event) throws IOException {
        plate testCake = new cakePlate();
        plate testJuice = new juicePlate();
        plate testPasta = new pastaPlate();

        plate decoCake = new foodItemDecorator(testCake);
        plate decoJuice = new foodItemDecorator(testJuice);
        plate decoPasta = new foodItemDecorator(testPasta);
        
        if (cake != 0){
            // Alert a = new Alert(AlertType.INFORMATION);
            // a.setHeaderText(null);
            // a.setContentText("Display Number of Cake: " + cake);
            // a.showAndWait();
            foodBG1.setImage(decoCake.display());
            System.out.println("Display Number of Cake: " + cake);

        }
        if (juice != 0){
            // Alert b = new Alert(AlertType.INFORMATION);
            // b.setHeaderText(null);
            // b.setContentText("Display Number of Juice: " + juice);
            // b.showAndWait();
            foodBG2.setImage(decoJuice.display());
            System.out.println("Display Number of Juice: " + juice);

        }
        if (pasta != 0){
            // Alert c = new Alert(AlertType.INFORMATION);
            // c.setHeaderText(null);
            // c.setContentText("Display Number of Pasta: " + pasta);
            // c.showAndWait();
            foodBG3.setImage(decoPasta.display());
            System.out.println("Display Number of Pasta: " + pasta);
        }
        displayButton.setDisable(true);
    }

    @FXML
    void SitButtonClicked(ActionEvent event) {

    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

}