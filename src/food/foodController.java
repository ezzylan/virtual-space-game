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
import javafx.scene.Group;
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
import wallet.Wallet;

public class foodController {

    MusicPlayer musicPlayer = MusicPlayer.getInstance();
    boolean isPlaying = musicPlayer.isPlaying();
    public int cake;
    public int juice;
    public int pasta;
    public int total;
    int walletAmount;
    Wallet wallet = Wallet.getInstance();

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
    private Button SitButton;

    @FXML
    private Text WalletAmount;

    @FXML
    public Button displayButton;

    @FXML
    private Group orderListGroup;

    @FXML
    private Text cakeNum;

    @FXML
    private Text juiceNum;

    @FXML
    private Text pastaNum;

    @FXML
    private Button confirmButton;

    public void initialize() {
        walletAmount = wallet.getAmount();
        WalletAmount.setText(Integer.toString(walletAmount));

        if (isPlaying) {
            MusicButton.setText("Turn off music");
            MusicName.setText(musicPlayer.getFileName());
        }
    }

    @FXML
    void EatButtonClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../eat_drink/EatDrink.fxml"));
            Parent odr = loader.load();

            Scene scene2 = new Scene(odr);

            eat_drink.EatDrinkController controller = loader.getController();
            controller.cake = cake;
            controller.juice = juice;
            controller.pasta = pasta;

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Virtual Space Game - Eat/Drink");
            window.setScene(scene2);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void LeaveButtonClicked(ActionEvent event)
            throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        wallet.setAmount(100);
        musicPlayer.stopMusic(new OffMusicCommand(), false, MusicButton, MusicName);

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
        if (isPlaying) {
            musicPlayer.stopMusic(new OffMusicCommand(), false, MusicButton, MusicName);
        } else {
            musicPlayer.playMusic(new OnMusicCommand(), true, MusicButton, MusicName);
        }
        isPlaying = musicPlayer.isPlaying();
    }

    @FXML
    void displayButtonClicked(ActionEvent event) throws IOException {
        orderListGroup.setVisible(true);
        cakeNum.setText("" + cake);
        juiceNum.setText("" + juice);
        pastaNum.setText("" + pasta);
        displayButton.setDisable(true);
    }

    /**
     * Using Decorator design pattern that use plateDecorator class
     * and foodItemDecorator concrete class which wraps the original
     * class (plate) and provides additional functionality
     * (methods; enjoy()) while keeping exiting class methods intact.
     */

    @FXML
    void confirmButtonClicked(ActionEvent event) {
        orderListGroup.setVisible(false);
        plate testCake = new cakePlate();
        plate testJuice = new juicePlate();
        plate testPasta = new pastaPlate();

        plate decoCake = new foodItemDecorator(testCake);
        plate decoJuice = new foodItemDecorator(testJuice);
        plate decoPasta = new foodItemDecorator(testPasta);

        if (cake != 0) {
            foodBG1.setImage(decoCake.display());
            System.out.println("Display Number of Cake: " + cake);

        }
        if (juice != 0) {
            foodBG2.setImage(decoJuice.display());
            System.out.println("Display Number of Juice: " + juice);

        }
        if (pasta != 0) {
            foodBG3.setImage(decoPasta.display());
            System.out.println("Display Number of Pasta: " + pasta);
        }
        // To display total price:
        // WalletAmount.setText("" + total);

        displayButton.setDisable(true);
        EatButton.setDisable(false);

    }

    @FXML
    void SitButtonClicked(ActionEvent event) {

    }

}